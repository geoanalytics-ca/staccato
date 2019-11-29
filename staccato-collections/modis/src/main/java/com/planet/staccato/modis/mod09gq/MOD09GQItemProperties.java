package com.planet.staccato.modis.mod09gq;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.planet.staccato.modis.ModisItemProperties;
import lombok.Data;


@Data
@JsonTypeName("mod09gq")
@JsonDeserialize(as = MOD09GQItemProperties.class)
public class MOD09GQItemProperties extends ModisItemProperties {

}
