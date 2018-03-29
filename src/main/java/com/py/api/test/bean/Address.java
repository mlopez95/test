package com.py.api.test.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Objeto Address. Representa la direccion de un usuario")
public class Address {

    @ApiModelProperty(value = "Identificador la calle", example = "-25.278736")
    private String street;
    @ApiModelProperty(value = "Identificador del inmobiliario")
    private String suite;
    @ApiModelProperty(value = "Identificador de la ciudad", example = "Limpio")
    private String city;
    @ApiModelProperty(value = "Identificador del codigo Postal", example = "00")
    private String zipcode;
    @ApiModelProperty(value = "Identificador de la ubicacion")
    private Geo geo;

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
