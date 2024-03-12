package com.nsolution.nfood.Models;

public class ShippingAddressDto {
    private String street;
    private double latitude;
    private double longitude;


    public ShippingAddressDto() {

    }

    public ShippingAddressDto(String street, double latitude, double longitude) {
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ShippingAddressDto{" +
                "street='" + street + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
