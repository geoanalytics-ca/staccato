package com.planet.staccato.catalog;

import com.planet.staccato.collection.CollectionMetadata;
import com.planet.staccato.dto.api.SearchRequest;
import com.planet.staccato.dto.api.extensions.FieldsExtension;
import com.planet.staccato.es.api.ElasticsearchApiService;
import com.planet.staccato.model.Item;
import com.planet.staccato.model.ItemCollection;
import com.planet.staccato.service.AggregationService;
import com.planet.staccato.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.*;

/**
 * Responsible for processing any request for collections or subcatalogs.
 *
 * @author joshfix
 * Created on 10/24/18
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RequestHandler {

    private final SubcatalogPropertiesService subcatalogPropertiesService;
    private final LinkGenerator linkGenerator;
    private final CatalogService catalogService;
    private final AggregationService aggregationService;
    private final ElasticsearchApiService searchService;

    public Mono<ItemCollection> handleItemsRequest(CollectionMetadata collection, ServerRequest request) {
        // api for all items with the given subcatalog parameters
        Map<String, String> subcatalogPathParamMap = subcatalogPropertiesService
                .createSubcatalogPathParamMap(collection.getId(), request.path());
        SearchRequest searchRequest = convertItemsRequestParamsToSearchRequest(request.queryParams());
        return catalogService.getItems(collection.getId(), subcatalogPathParamMap, searchRequest);
    }

    public Mono<Item> handleItemRequest(CollectionMetadata collection, ServerRequest request) {
        // the path contains /items, but it doesn't end with items... assume it ends with an item id
        String[] pathParts = request.path().split("/");
        String itemId = pathParts[pathParts.length - 1];
        return catalogService.getItem(itemId, collection.getId());
    }

    /**
     * Search params for SearchRequest values that can be specified by items request
     * https://stacspec.org/STAC-api.html#operation/getFeatures
     *
     * @param params
     * @return
     */
    public SearchRequest convertItemsRequestParamsToSearchRequest(MultiValueMap<String, String> params) {
        SearchRequest request = new SearchRequest();
        request.setDatetime(params.getFirst("datetime"));
        request.setNext(params.getFirst("next"));
        try {
            int limit = Integer.parseInt(params.getFirst("limit"));
            request.setLimit(limit);
        } catch (NumberFormatException e) {
            log.warn("Error parsing limit", e);
        }
        // TODO also set bbox
        return request;
    }

    /**
     * This method is executed if somebody has traversed down the /stac/xxx path into a subcatalog.
     *
     * @param collection
     * @param request
     * @return
     */
    public Mono<CollectionMetadata> handleSubcatalogRequest(CollectionMetadata collection, ServerRequest request) {
        String path = request.path();
        String collectionId = collection.getId();
        List<String> parsePath = subcatalogPropertiesService.parsePath(path);
        Map<String, String> propertiesMap =
                subcatalogPropertiesService.createSubcatalogPathParamMap(collectionId, request.path());

        // calculate and set the extent given the url path filters
        collection.setExtent(aggregationService.getExtent(collectionId, propertiesMap));
        // TODO: cholmes requested that the id change with each subcatalog, but since we removed the collection field from
        // properties, we rely on the collection id.  but we also rely on the collection id for the name of the es index.
        // this all gets muddled.  we could parse out additional path segments to only use the original ID /shrug
        //collection.setId(request.path().replace("/stac/", ""));
        generatePrettyTitle(collection, parsePath);

        int size = parsePath.size();
        if (size % 2 == 0) {
            // even -- means we have both a property name and value -- should display more property name links
            log.debug("EVEN (should display properties) - path: " + path + " - size: " + size);

            List<PropertyField> remainingProperties = subcatalogPropertiesService.getRemainingProperties(collection.getId(), request.path());
            linkGenerator.generatePropertyFieldLinks(request, collection, remainingProperties);

            // if there are no remaining properties (eg, no more subcatalogs to traverse down), generate item links
            if (remainingProperties.isEmpty()) {
                StringBuilder filterBuilder = new StringBuilder();
                Iterator<Map.Entry<String, String>> it = propertiesMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> entry = it.next();
                    filterBuilder.append("properties.").append(entry.getKey()).append("=").append(entry.getValue());
                    if (it.hasNext()) {
                        filterBuilder.append(" AND ");
                    }
                }
                Set<String> idField = new HashSet<>();
                idField.add("id");
                FieldsExtension fields = new FieldsExtension().include(idField);

                SearchRequest searchRequest = new SearchRequest()
                        .query(filterBuilder.toString())
                        .limit(10000)
                        .collections(new String[]{collectionId})
                        .fields(fields);

                return searchService.getItemsFlux(searchRequest)
                        .map(item -> item.getId())
                        .map(id -> linkGenerator.buildItemLink(collectionId, id))
                        .map(link -> collection.getLinks().add(link))
                        .then(Mono.just(collection));
            }

            return Mono.just(collection);
        } else {
            // odd
            log.debug("ODD (should display values) - path: " + path + " - size: " + size);

            collection.getLinks().clear();

            List<String> values = catalogService.getValuesForField(collection, parsePath);
            linkGenerator.generatePropertyValueLinks(request, collection, values);

            return Mono.just(collection);
        }
    }

    private void generatePrettyTitle(CollectionMetadata collection, List<String> pathValues) {
        if (pathValues.size() == 1) {
            return;
        }
        String title = collection.getTitle() + ": ";
        for (int i = 2; i < pathValues.size(); i = i + 2) {
            String property = pathValues.get(i);
            title += property;
            if ((i + 2) <= pathValues.size()) {
                String value = pathValues.get(i + 1);
                title += " " + value;
                if ((i + 3) <= pathValues.size()) {
                    title += ", ";
                }
            }
        }
        collection.setTitle(title);
    }

}
