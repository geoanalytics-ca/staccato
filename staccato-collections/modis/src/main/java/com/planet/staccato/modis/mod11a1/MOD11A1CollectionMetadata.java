package com.planet.staccato.modis.mod11a1;

import com.planet.staccato.collection.CollectionMetadataAdapter;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.Provider;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MOD11A1CollectionMetadata extends CollectionMetadataAdapter<MOD11A1ItemProperties> {

    public static final String ID = "modis.mod11a1";
    public static final String TITLE = "MODIS MOD11A1";
    public static final String DESCRIPTION = "MODIS/Terra Land Surface Temperature/Emissivity Daily L3 Global 1 km SIN Grid";
    public static final String VERSION = "0.8.0";
    public static final String LICENSE = "";
    public static final String[] KEYWORDS = {"modis", "modis-terra", "modis-aqua", "terra", "aqua", "MOD11a1"};
    public static final String CRS = "http://www.opengis.net/def/crs/OGC/1.3/CRS84";


    public MOD11A1CollectionMetadata() {
        super();

        setId(ID);
        crs(CRS);
        setTitle(TITLE);
        setDescription(DESCRIPTION);
        setVersion(VERSION);
        setLicense(LICENSE);
        keywords.addAll(Arrays.asList(KEYWORDS));
        properties = new MOD11A1ItemProperties();

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

        providers.add(Provider.build()
                .name("LP-DAAC")
                .addRole(Provider.Role.PRODUCER)
                .url("https://lpdaac.usgs.gov/products/mod11a1v006/"));
    }

    private void buildProperties() {
        properties.setPlatform("modis");
        properties.setInstrument("MODIS Terra");
        properties.setConstellation("modis");
        properties.setOffNadir(0);
        properties.setBands(buildBands());
    }

    private List<EO.Band> buildBands() {
        List<EO.Band> bands = new ArrayList<>();
        return bands;
    }

}
