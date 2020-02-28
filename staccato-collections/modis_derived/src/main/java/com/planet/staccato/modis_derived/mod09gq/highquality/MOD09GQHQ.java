package com.planet.staccato.modis_derived.mod09gq.highquality;

import com.planet.staccato.modis_derived.mod09gq.ndvi.MOD09GQNDVI;

/**
 * This class is added in order to provide Subcatalog features to the collection
 */
public interface MOD09GQHQ extends MOD09GQNDVI {
    /*
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
    */
}
