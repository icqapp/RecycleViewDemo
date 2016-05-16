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
 * 文章实体类
 * Created by icqapp on 16/5/15.
 */
public class Article implements Serializable{
    private static final long serialVersionUID = -6079929156476601584L;
    /**
     * id : 3
     * imgUrl : http://img1.imgtn.bdimg.com/it/u=112648096,582309873&fm=23&gp=0.jpg
     * title : 标题三
     * content : 内容三
     * disc : 描述三
     */

    private int id;
    private String imgUrl;
    private String title;
    private String content;
    private String disc;


    public static Article objectFromData(String str) {

        return new Gson().fromJson(str, Article.class);
    }

    public static Article objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Article.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Article> arrayArticleFromData(String str) {

        Type listType = new TypeToken<ArrayList<Article>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Article> arrayArticleFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Article>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
