package com.planet.staccato.modis_derived.mod09gq.highquality;

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
public class MOD09GQHQAutoConfig {

    // autowiring this in ensures the static LINK_PREFIX value is built
    private final LinksConfigProps linksConfigProps;

    // !!
    @Bean
    public CollectionMetadata mod09gqHQCollection() {
        // !!
        MOD09GQHQCollectionMetadata metadata = new MOD09GQHQCollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .catalogType(CatalogType.COLLECTION);
        return metadata;
    }

    // !!
    @Bean
    public CollectionMetadata mod09gqHQCatalog() {
        // !!
        MOD09GQHQCollectionMetadata metadata = new MOD09GQHQCollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .setCatalogType(CatalogType.CATALOG);
        return metadata;
    }
}
