package com.example.tokenapp.project.modal;

public class Orders {
    int id;
    String userName;
    String customerName;
    String product;
    boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Orders(int id, String userName, String customerName, String product, boolean status) {
        this.id = id;
        this.userName = userName;
        this.customerName = customerName;
        this.product = product;
        this.status = status;
    }
}
