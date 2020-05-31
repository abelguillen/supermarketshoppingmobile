package com.aguillen.supermarketshoppingmobile.dto;

import java.io.Serializable;

public class ArticleDTO implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String category;
    private String image;

    public ArticleDTO() {}

    public ArticleDTO(Integer id, String name, String description, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public ArticleDTO(String name, String description, String category, String image) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
