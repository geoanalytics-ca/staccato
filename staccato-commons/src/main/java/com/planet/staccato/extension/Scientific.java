package com.planet.staccato.extension;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

/**
 * Defines the fieldsExtension and Jackson property values for fieldsExtension in the scientific extension.
 * @see <a href="https://github.com/radiantearth/stac-spec/tree/master/extensions/scientific">Scientific Extension</a>
 * @author joshfix
 * Created on 2/11/19
 */
public interface Scientific {

    String EXTENSION_PREFIX = "sci";

    @JsonProperty(EXTENSION_PREFIX + ":doi")
    String getDoi();
    void setDoi(String doi);

    @JsonProperty(EXTENSION_PREFIX + ":citation")
    String getCitation();
    void setCitation(String citation);

    @JsonProperty(EXTENSION_PREFIX + ":publications")
    Collection<Publication> getPublications();
    void setPublications(Collection<Publication> publications);

    @Data
    class Publication {
        private String doi;
        private String citation;
    }
}
