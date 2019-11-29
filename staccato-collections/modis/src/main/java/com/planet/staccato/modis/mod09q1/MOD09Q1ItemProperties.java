package com.planet.staccato.modis.mod09q1;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;


@Data
@JsonTypeName("mod09q1")
@JsonDeserialize(as = MOD09Q1ItemProperties.class)
public class MOD09Q1ItemProperties extends ModisItemProperties {

}
