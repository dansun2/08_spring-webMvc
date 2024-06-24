package com.ohgiraffers.boardpractice.model.dto;

public class TeamDTO {

    private String name;
    private String link;

    public TeamDTO() {
    }

    public TeamDTO(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
