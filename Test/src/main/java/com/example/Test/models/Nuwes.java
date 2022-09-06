package com.example.Test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nuwes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title,body,text;

    public Nuwes(String title, String body, String text, Integer vuews, Integer likes) {
        this.title = title;
        this.body = body;
        this.text = text;
        this.vuews = vuews;
        this.likes = likes;
    }

    Integer vuews, likes;

    public Nuwes() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVuews() {
        return vuews;
    }

    public void setVuews(Integer vuews) {
        this.vuews = vuews;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
