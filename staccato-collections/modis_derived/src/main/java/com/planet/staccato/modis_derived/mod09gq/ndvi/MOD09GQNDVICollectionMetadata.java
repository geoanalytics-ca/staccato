package com.planet.staccato.modis_derived.mod09gq.ndvi;


import com.planet.staccato.collection.CollectionMetadataAdapter;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.Provider;
// !!
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// !!
@Data
public class MOD09GQNDVICollectionMetadata extends CollectionMetadataAdapter<MOD09GQNDVIItemProperties> {
    // !!
    public static final String ID = "modis.mod09gq.ndvi";
    public static final String TITLE = "MODIS MOD09GQ NDVI";
    //public static final String DESCRIPTION = "MODIS/Terra Surface Reflectance Daily L2G Global 250 m SIN Grid";
    public static final String DESCRIPTION = "TODO";
    public static final String VERSION = "0.8.0";
    public static final String LICENSE = "";
    public static final String[] KEYWORDS = {"modis", "modis-terra", "modis-aqua", "terra", "aqua", "MOD09GQ", "NDVI"};
    public static final String CRS = "http://www.opengis.net/def/crs/OGC/1.3/CRS84";

    // !!
    public MOD09GQNDVICollectionMetadata() {
        super();

        setId(ID);
        crs(CRS);
        setTitle(TITLE);
        setDescription(DESCRIPTION);
        setVersion(VERSION);
        setLicense(LICENSE);
        keywords.addAll(Arrays.asList(KEYWORDS));
        // !!
        properties = new MOD09GQNDVIItemProperties();
        buildProperties();
        buildProviders();
    }

    private void buildProviders() {
        providers.add(Provider.build()
                .name("USGS")
                .addRole(Provider.Role.PRODUCER)
                .url("https://modis.gsfc.nasa.gov/"));

        providers.add(Provider.build()
                .name("Geo Analytics Canada")
                .addRole(Provider.Role.PROCESSOR)
                .url("https://geoanalytics.ca/"));

        //providers.add(Provider.build()
        //        .name("LP-DAAC")
        //        .addRole(Provider.Role.PRODUCER)
        //        .url("https://lpdaac.usgs.gov/products/mod09gqv006/"));
    }

    private void buildProperties() {
        //properties.setPlatform("modis");
        //properties.setInstrument("MODIS Terra");
        //properties.setConstellation("modis");
        //properties.setOffNadir(0);
        //properties.setBands(buildBands());
    }

    private List<EO.Band> buildBands() {
        List<EO.Band> bands = new ArrayList<>();
        return bands;
    }

}
