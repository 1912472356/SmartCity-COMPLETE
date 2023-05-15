package com.cx.smartcity.bean;

public class CheliangBean {
    private String carNo;
    private String chewei;
    private String parkNo;
    private String name;
    private String phone;
    private String addressName;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getChewei() {
        return chewei;
    }

    public void setChewei(String chewei) {
        this.chewei = chewei;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CheliangBean(String carNo, String chewei, String parkNo, String name, String phone, String addressName, String address) {
        this.carNo = carNo;
        this.chewei = chewei;
        this.parkNo = parkNo;
        this.name = name;
        this.phone = phone;
        this.addressName = addressName;
        this.address = address;
    }

    private String address;
}
