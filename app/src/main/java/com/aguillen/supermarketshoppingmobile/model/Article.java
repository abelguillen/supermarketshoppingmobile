package com.aguillen.supermarketshoppingmobile.model;

public class Article {

    private Integer id;
    private String name;
    private String description;
    private String category;
    private int image;

    public Article() {}

    public Article(Integer id, String name, String description, String category, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Article(String name, String description, String category, int image) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}