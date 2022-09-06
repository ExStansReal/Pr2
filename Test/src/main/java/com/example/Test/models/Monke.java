package com.example.Test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    public String getChena() {
        return chena;
    }

    public void setChena(String chena) {
        this.chena = chena;
    }

    public int getRost() {
        return rost;
    }

    public void setRost(int rost) {
        this.rost = rost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    String name,opisanie,chena;

    public Monke(String name, String opisanie, String chena, int rost, int weight) {
        this.name = name;
        this.opisanie = opisanie;
        this.chena = chena;
        this.rost = rost;
        this.weight = weight;
    }

    int rost,weight;

    public Monke() {

    }
}
