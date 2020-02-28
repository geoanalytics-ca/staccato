package com.planet.staccato.modis_derived.mod09gq.veg.ndvi;

import com.planet.staccato.collection.CatalogType;
import com.planet.staccato.collection.CollectionMetadata;
import com.planet.staccato.collection.LinkHelper;
import com.planet.staccato.config.LinksConfigProps;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// !!
@Configuration
@AllArgsConstructor
public class MOD09GQVegNDVIAutoConfig {

    // autowiring this in ensures the static LINK_PREFIX value is built
    private final LinksConfigProps linksConfigProps;

    // !!
    @Bean
    public CollectionMetadata mod09gqVegNDVICollection() {
        // !!
        MOD09GQVegNDVICollectionMetadata metadata = new MOD09GQVegNDVICollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .catalogType(CatalogType.COLLECTION);
        return metadata;
    }

    // !!
    @Bean
    public CollectionMetadata mod09gqVegNDVICatalog() {
        // !!
        MOD09GQVegNDVICollectionMetadata metadata = new MOD09GQVegNDVICollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .setCatalogType(CatalogType.CATALOG);
        return metadata;
    }
}
