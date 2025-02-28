package com.example.newsdata;

import java.util.ArrayList;

public class newsdata {
int totalResult;
String status;
ArrayList<model> article;

    public newsdata(int totalResult, String status, ArrayList<model> article) {
        this.totalResult = totalResult;
        this.status = status;
        this.article = article;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<model> getArticle() {
        return article;
    }
}
