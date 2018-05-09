package com.teamdut.werewolfandroid1.models;

public class BodyGuard extends Role {

    public BodyGuard(int id, String name, int score, int imgRes) {
        super(id, name, score, imgRes);
    }

    public void protect(Player player) {
        player.setProtected(true);
    }
}
