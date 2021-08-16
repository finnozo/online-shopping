package com.isolutions4u.onlineshopping.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /////////////// add many to one relation ship
    @ManyToOne
    private User user;
    /*----------------------*/
    @Column(name = "address_line_one")
    @NotBlank(message = "Please Enter Address Line One!")
    private String addressLineOne;

    @Column(name = "address_line_two")
    @NotBlank(message = "Please Enter Address Line Two!")
    private String addressLineTwo;

    @Column(name = "city")
    @NotBlank(message = "Please Enter City!")
    private String city;

    @Column(name = "state")
    @NotBlank(message = "Please Enter City!")
    private String state;

    @Column(name = "country")
    @NotBlank(message = "Please Enter Country!")
    private String country;

    @Column(name = "postal_code")
    @NotBlank(message = "Please Enter Postal Code!")
    private String postalCode;

    @Column(name = "shipping")
    private boolean shipping;

    @Column(name = "billing")
    private boolean billing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
                + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
                + ", shipping=" + shipping + ", billing=" + billing + "]";
    }

}
