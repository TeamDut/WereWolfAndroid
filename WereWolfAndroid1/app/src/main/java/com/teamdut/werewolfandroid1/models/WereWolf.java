package com.teamdut.werewolfandroid1.models;

public class WereWolf extends Role{
    public WereWolf(int id, String name, int score, int imgRes) {
        super(id, name, score, imgRes);
    }

    public void kill(Player player) {
        if (!player.isProtected()) {
            player.changeLifeCount(-1);
            if (player.getLifeCount() <= 0) {
                player.setDead(true);
            }
        }
    }
}
