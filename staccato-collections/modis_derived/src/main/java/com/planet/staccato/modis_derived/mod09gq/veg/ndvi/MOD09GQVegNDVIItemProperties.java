package com.planet.staccato.modis_derived.mod09gq.veg.ndvi;


import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.extension.EO;
import com.planet.staccato.extension.Projection;
import com.planet.staccato.model.Centroid;
import com.planet.staccato.model.CoreProperties;
import com.planet.staccato.model.Provider;
import lombok.Data;

import java.util.List;
import java.util.Set;

//import com.planet.staccato.modis.ModisItemProperties;

// !!
@Data
@JsonTypeName("mod09gq_veg_ndvi")
@JsonDeserialize(as = MOD09GQVegNDVIItemProperties.class)
public class MOD09GQVegNDVIItemProperties implements CoreProperties, EO, Projection, MOD09GQVegNDVI {
    // CoreProperties
    private String datetime;
    private String created;
    private String updated;
    private String title;
    private String license;
    private Set<Provider> providers;

    // Collection field as part of the commons extension (merged from the collection metadata)
    //private String collection = ModisCollectionMetadata.ID;

    // EO
    private String platform;
    private String instrument;
    private Double cloudCover;
    private Integer offNadir;
    private Double gsd;
    private Double azimuth;
    private Double sunAzimuth;
    private Double sunElevation;
    //private String epsg;
    private String constellation;
    private List<Band> bands;

    // Projection
    private Integer epsg;
    private String proj4;
    private String wkt2;
    private String projjson;
    private Object geometry;
    private List<Double> bbox;
    private Centroid centroid;

    // MODIS
    private Integer year;
    private Integer month;
    private Integer day;
    private String dayNightFlag;
}
