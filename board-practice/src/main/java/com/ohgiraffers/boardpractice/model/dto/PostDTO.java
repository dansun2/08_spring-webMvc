package com.ohgiraffers.boardpractice.model.dto;

public class PostDTO {
    private String title;
    private String imgUrl;
    private String link;

    public PostDTO(String title, String imgUrl, String link) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.link = link;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
