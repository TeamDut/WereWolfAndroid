package com.teamdut.werewolfandroid1.models;

public class Role {
    private int id;
    private String name;
    private int score;
    private int quantity = 0;
    private int imgRes;

    public Role(int id, String name, int score, int imgRes) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.imgRes = imgRes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int number) {
        this.quantity = quantity + number;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
