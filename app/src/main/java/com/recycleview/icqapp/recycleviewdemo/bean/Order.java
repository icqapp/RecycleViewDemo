package com.recycleview.icqapp.recycleviewdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 订单列表实体类(嵌套产品列表)
 * Created by icqapp on 16/5/14.
 */
public class Order implements Serializable{


    private static final long serialVersionUID = 6924559147991063360L;

    private int pId;
    private String companyName;
    private int role;
    private int status;
    private double total;
    private int totalPrice;
    private int fare;

    public List<Products> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Products> goodses) {
        this.goodses = goodses;
    }

    private List<Products> goodses;

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }


}
