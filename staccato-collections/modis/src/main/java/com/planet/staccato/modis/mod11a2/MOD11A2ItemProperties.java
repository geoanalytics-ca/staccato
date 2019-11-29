package com.planet.staccato.modis.mod11a2;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;


@Data
@JsonTypeName("mod11a2")
@JsonDeserialize(as = MOD11A2ItemProperties.class)
public class MOD11A2ItemProperties extends ModisItemProperties {

}
