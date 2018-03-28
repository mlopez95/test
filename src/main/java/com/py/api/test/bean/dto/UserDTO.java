package com.py.api.test.bean.dto;

import com.py.api.test.bean.Address;
import com.py.api.test.bean.Company;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Objeto para transferencia de Dato User. Representa un usuario")
public class UserDTO {

    @ApiModelProperty(value = "Nombre del usuario",example = "Marcelo Lopez")
    private String name;
    @ApiModelProperty(value = "Nombre unico del usuario/(uso externo, a eleccion del usuario y de acuerdo a la disponibilidad)",example = "mlopez95")
    private String username;
    @ApiModelProperty(value = "Identificador del email", example = "mchelo.lopez@hotmail.com")
    private String email;
    @ApiModelProperty(value = "Identificador del celular", example = "mchelo.lopez@hotmail.com")
    private String phone;
    @ApiModelProperty(value = "Identificador del website", example = "mchelo.lopez@hotmail.com")
    private String website;
    @ApiModelProperty(value = "Identificador de la direccion")
    private Address address;
    @ApiModelProperty(value = "Identificador de la compania")
    private Company company;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}';
    }
}
