package com.planet.staccato.extension;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.planet.staccato.elasticsearch.annotation.Mapping;
import com.planet.staccato.elasticsearch.annotation.MappingType;
import com.planet.staccato.model.Centroid;

import java.util.List;

public interface Projection {

    String EXTENSION_PREFIX = "proj";

    @Mapping(type = MappingType.INTEGER)
    @JsonProperty(EXTENSION_PREFIX + ":epsg")
    Integer getEpsg();
    void setEpsg(Integer epsg);

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty(EXTENSION_PREFIX + ":proj4")
    String getProj4();
    void setProj4(String proj4);

    @Mapping(type = MappingType.KEYWORD)
    @JsonProperty(EXTENSION_PREFIX + ":wkt2")
    String getWkt2();
    void setWkt2(String wkt2);

    @JsonProperty(EXTENSION_PREFIX + ":projjson")
    Object getProjjson();
    void setProjjson(String projjson);

    @JsonProperty(EXTENSION_PREFIX + ":geometry")
    Object getGeometry();
    void setGeometry(Object geometry);

    @JsonProperty(EXTENSION_PREFIX + ":bbox")
    List<Double> getBbox();
    void setBbox(List<Double> bbox);

    @Mapping(type = MappingType.GEO_POINT)
    @JsonProperty(EXTENSION_PREFIX + ":centroid")
    Centroid getCentroid();
    void setCentroid(Centroid centroid);

}