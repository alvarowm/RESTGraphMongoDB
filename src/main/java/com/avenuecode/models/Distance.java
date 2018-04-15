
package com.avenuecode.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "distance")
public class Distance {

    private Integer distance;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
