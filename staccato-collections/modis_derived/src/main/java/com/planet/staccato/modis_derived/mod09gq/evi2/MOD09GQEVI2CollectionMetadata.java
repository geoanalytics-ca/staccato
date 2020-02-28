package com.planet.staccato.modis_derived.mod09gq.evi2;


import com.planet.staccato.collection.CollectionMetadataAdapter;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.Provider;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// !!

// !!
@Data
public class MOD09GQEVI2CollectionMetadata extends CollectionMetadataAdapter<MOD09GQEVI2ItemProperties> {
    // !!
    public static final String ID = "modis.mod09gq.evi2";
    public static final String TITLE = "MODIS MOD09GQ EVI2";
    //public static final String DESCRIPTION = "MODIS/Terra Surface Reflectance Daily L2G Global 250 m SIN Grid";
    // https://vip.arizona.edu/documents/MODIS/MODIS_VI_UsersGuide_June_2015_C6.pdf
    public static final String DESCRIPTION = "TODO";
    public static final String VERSION = "0.8.0";
    public static final String LICENSE = "";
    public static final String[] KEYWORDS = {"modis", "modis-terra", "modis-aqua", "terra", "aqua", "MOD09GQ", "EVI2"};
    public static final String CRS = "http://www.opengis.net/def/crs/OGC/1.3/CRS84";

    // !!
    public MOD09GQEVI2CollectionMetadata() {
        super();

        setId(ID);
        crs(CRS);
        setTitle(TITLE);
        setDescription(DESCRIPTION);
        setVersion(VERSION);
        setLicense(LICENSE);
        keywords.addAll(Arrays.asList(KEYWORDS));
        // !!
        properties = new MOD09GQEVI2ItemProperties();
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
