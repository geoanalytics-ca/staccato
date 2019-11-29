package com.planet.staccato.modis.mod13q1;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;


@Data
@JsonTypeName("mod13q1")
@JsonDeserialize(as = MOD13Q1ItemProperties.class)
public class MOD13Q1ItemProperties extends ModisItemProperties {

}
