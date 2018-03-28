package com.py.api.test.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Objeto Company. Representa una compania")
public class Company {
    @ApiModelProperty(value = "Identificador de la compania", example = "EDGE S.A.")
    private String name;
    @ApiModelProperty(value = "Descripcion de la empresa")
    private String catchPhrase;
    @ApiModelProperty(value = "Rubro de la empresa")
    private String bs;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
