package com.planet.staccato.modis.mcd12q1;

import com.planet.staccato.collection.CatalogType;
import com.planet.staccato.collection.CollectionMetadata;
import com.planet.staccato.collection.LinkHelper;
import com.planet.staccato.config.LinksConfigProps;
import com.planet.staccato.modis.mod09gq.MOD09GQCollectionMetadata;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AllArgsConstructor
public class MCD12Q1AutoConfig {

    // autowiring this in ensures the static LINK_PREFIX value is built
    private final LinksConfigProps linksConfigProps;

    @Bean
    public CollectionMetadata mcd12q1Collection() {
        MCD12Q1CollectionMetadata metadata = new MCD12Q1CollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .catalogType(CatalogType.COLLECTION);
        return metadata;
    }

    @Bean
    public CollectionMetadata mcd12q1Catalog() {
        MCD12Q1CollectionMetadata metadata = new MCD12Q1CollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .setCatalogType(CatalogType.CATALOG);
        return metadata;
    }
}
