package com.recycleview.icqapp.recycleviewdemo.bean;

import java.io.Serializable;

/**
 * Created by icqapp on 16/5/16.
 */
public class Products implements Serializable{

    private static final long serialVersionUID = 4227713395301645415L;

    private String gId;
    private String imgUrl;
    private String goodsName;
    private String spec;
    private double price;
    private int amount;

    public String getGId() {
        return gId;
    }

    public void setGId(String gId) {
        this.gId = gId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
