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
 * Created by icqapp on 16/5/16.
 */
public class Beauty implements Serializable{
    private static final long serialVersionUID = -6224713839415651182L;
    /**
     * type : 1
     * name : 美女1
     * age : 20
     * head : http://p3.wmpic.me/article/2015/11/19/1447921382_LVGBhWjt.jpg
     */

    private int type;
    private String name;
    private int age;
    private String head;

    public static Beauty objectFromData(String str) {

        return new Gson().fromJson(str, Beauty.class);
    }

    public static Beauty objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Beauty.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Beauty> arrayBeautyFromData(String str) {

        Type listType = new TypeToken<ArrayList<Beauty>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Beauty> arrayBeautyFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Beauty>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
