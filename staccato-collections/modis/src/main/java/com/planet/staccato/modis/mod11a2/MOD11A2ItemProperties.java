package com.planet.staccato.modis.mod11a2;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.CoreProperties;
import com.planet.staccato.model.Provider;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
@JsonTypeName("mod11a2")
@JsonDeserialize(as = MOD11A2ItemProperties.class)
public class MOD11A2ItemProperties implements CoreProperties, EO,MOD11A2 {
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
    private String epsg;
    private String constellation;
    private List<EO.Band> bands;

    // MODIS
    private Integer year;
    private Integer month;
    private Integer day;
    private String dayNightFlag;
}
