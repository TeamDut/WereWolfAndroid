package com.teamdut.werewolfandroid1.models;

public class Player {
    private int id;
    private int roleId = 0;
    private String name;
    private int lifeCount = 1;
    private boolean isSelected = false;
    private boolean isCalled = false;
    private boolean isDead = false;
    private boolean isHang = false;
    private boolean isProtected = false;
    private boolean isSilenced = false;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(int id, String name, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.isSelected = isSelected;
    }

    public void changeLifeCount(int addLife) {
        this.lifeCount = lifeCount + addLife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isCalled() {
        return isCalled;
    }

    public void setCalled(boolean called) {
        isCalled = called;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isHang() {
        return isHang;
    }

    public void setHang(boolean hang) {
        isHang = hang;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public void setSilenced(boolean silenced) {
        isSilenced = silenced;
    }
}
