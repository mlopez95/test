package com.py.api.test.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Objeto Geo. Representa la ubicacion de un usuario")
public class Geo {
    @ApiModelProperty(value = "Identificador la latitud", example = "-25.278736")
    private String lat;
    @ApiModelProperty(value = "Identificador la longitud", example = "-57.615586")
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
