
package com.example.hazem.gameofthrones.Models;

import android.net.LinkAddress;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Characters implements Serializable{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("culture")
    @Expose
    private String culture;
    @SerializedName("born")
    @Expose
    private String born;
    @SerializedName("died")
    @Expose
    private String died;
    @SerializedName("titles")
    @Expose
    private ArrayList<String> titles = null;
    @SerializedName("aliases")
    @Expose
    private ArrayList<String> aliases = null;
    @SerializedName("father")
    @Expose
    private String father;
    @SerializedName("mother")
    @Expose
    private String mother;
    @SerializedName("spouse")
    @Expose
    private String spouse;
    @SerializedName("allegiances")
    @Expose
    private ArrayList<String> allegiances = null;
    @SerializedName("books")
    @Expose
    private ArrayList<String> books = null;
    @SerializedName("povBooks")
    @Expose
    private ArrayList<String> povBooks = null;
    @SerializedName("tvSeries")
    @Expose
    private ArrayList<String> tvSeries = null;
    @SerializedName("playedBy")
    @Expose
    private ArrayList<String> playedBy = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public ArrayList<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(ArrayList<String> allegiances) {
        this.allegiances = allegiances;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }

    public ArrayList<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(ArrayList<String> povBooks) {
        this.povBooks = povBooks;
    }

    public ArrayList<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(ArrayList<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public ArrayList<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(ArrayList<String> playedBy) {
        this.playedBy = playedBy;
    }

}
