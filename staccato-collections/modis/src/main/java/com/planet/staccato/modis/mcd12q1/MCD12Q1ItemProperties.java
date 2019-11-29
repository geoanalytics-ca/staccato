package com.planet.staccato.modis.mcd12q1;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;


@Data
@JsonTypeName("mcd12q1")
@JsonDeserialize(as = MCD12Q1ItemProperties.class)
public class MCD12Q1ItemProperties extends ModisItemProperties {

}
