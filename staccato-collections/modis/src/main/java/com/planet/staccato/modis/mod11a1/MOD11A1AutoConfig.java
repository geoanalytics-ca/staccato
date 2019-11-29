package com.planet.staccato.modis.mod11a1;

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
public class MOD11A1AutoConfig {

    // autowiring this in ensures the static LINK_PREFIX value is built
    private final LinksConfigProps linksConfigProps;

    @Bean
    public CollectionMetadata mod11a1Collection() {
        MOD11A1CollectionMetadata metadata = new MOD11A1CollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .catalogType(CatalogType.COLLECTION);
        return metadata;
    }

    @Bean
    public CollectionMetadata mod11a1Catalog() {
        MOD11A1CollectionMetadata metadata = new MOD11A1CollectionMetadata();
        metadata.links(LinkHelper.buildCollectionLinks(metadata.getId()))
                .setCatalogType(CatalogType.CATALOG);
        return metadata;
    }
}
