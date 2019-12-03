package com.planet.staccato.modis.mod11a1;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.planet.staccato.collection.Subcatalog;
import com.planet.staccato.elasticsearch.annotation.Mapping;
import com.planet.staccato.elasticsearch.annotation.MappingType;

/**
 * This class is added in order to provide Subcatalog features to the collection
 */
public interface MOD11A1 {
    String EXTENSION_PREFIX = "modis";

    @Subcatalog
    @Mapping(type = MappingType.KEYWORD)
    @JsonAlias("year")
    @JsonProperty(EXTENSION_PREFIX + ":year")
    Integer getYear();
    void setYear(Integer year);

    @Subcatalog
    @Mapping(type = MappingType.KEYWORD)
    @JsonAlias("month")
    @JsonProperty(EXTENSION_PREFIX + ":month")
    Integer getMonth();
    void setMonth(Integer month);

    @Subcatalog
    @Mapping(type = MappingType.KEYWORD)
    @JsonAlias("day")
    @JsonProperty(EXTENSION_PREFIX + ":day")
    Integer getDay();
    void setDay(Integer day);

    @JsonAlias("day_night_flag")
    @JsonProperty(EXTENSION_PREFIX + ":day_night_flag")
    String getDayNightFlag();
    void setDayNightFlag(String flag);
}
