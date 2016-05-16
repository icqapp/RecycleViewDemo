package com.recycleview.icqapp.recycleviewdemo.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品实体类
 * Created by icqapp on 16/5/14.
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -5466392229564726705L;
    /**
     * imgServerPath : http://www.ts5000.com/file/
     * pid : 1038597
     * productImage : /cnff/product/2016/4/12/1460442573602_6054.png
     * sales : 0
     * title : 北京同仁堂 枸杞子200克 瓶装优质精选中宁夏枸杞茶特产滋补品
     * tsPrice : 55
     */

    private String imgServerPath;
    private String pid;
    private String productImage;
    private int sales;
    private String title;
    private int tsPrice;


    public static Goods objectFromData(String str) {

        return new Gson().fromJson(str, Goods.class);
    }

    public static Goods objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Goods.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Goods> arrayGoodsFromData(String str) {

        Type listType = new TypeToken<ArrayList<Goods>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Goods> arrayGoodsFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Goods>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getImgServerPath() {
        return imgServerPath;
    }

    public void setImgServerPath(String imgServerPath) {
        this.imgServerPath = imgServerPath;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTsPrice() {
        return tsPrice;
    }

    public void setTsPrice(int tsPrice) {
        this.tsPrice = tsPrice;
    }
}
