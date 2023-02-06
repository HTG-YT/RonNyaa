package com.github.htgazurex1212.ronnyaa.models.game.ranking;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    NOVICE_I,
    NOVICE_II,
    NOVICE_III,
    ADEPT_I,
    ADEPT_II,
    ADEPT_III,
    EXPERT_I,
    EXPERT_II,
    EXPERT_III,
    MASTER_I,
    MASTER_II,
    MASTER_III,
    SAINT_I,
    SAINT_II,
    SAINT_III,
    CELESTIAL;

    private static final Map<Integer, Rank> map = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            map.put(rank.ordinal(), rank);
        }
    }

    public static Rank valueOf(int rank) {
        return map.get(rank);
    }

    @Override
    public String toString() {
        return switch (this) {
            case NOVICE_I -> "初心一星";
            case NOVICE_II -> "初心二星";
            case NOVICE_III -> "初心三星";
            case ADEPT_I -> "雀士一星";
            case ADEPT_II -> "雀士二星";
            case ADEPT_III -> "雀士三星";
            case EXPERT_I -> "雀傑一星";
            case EXPERT_II -> "雀傑二星";
            case EXPERT_III -> "雀傑三星";
            case MASTER_I -> "雀豪一星";
            case MASTER_II -> "雀豪二星";
            case MASTER_III -> "雀豪三星";
            case SAINT_I -> "雀聖一星";
            case SAINT_II -> "雀聖二星";
            case SAINT_III -> "雀聖三星";
            case CELESTIAL -> "魂天";
        };
    }

    public int pointsRequired() throws IllegalArgumentException {
        return switch (this) {
            case NOVICE_I -> 25;
            case NOVICE_II -> 100;
            case NOVICE_III -> 250;
            case ADEPT_I -> 750;
            case ADEPT_II -> 1000;
            case ADEPT_III -> 1250;
            case EXPERT_I -> 1500;
            case EXPERT_II -> 1750;
            case EXPERT_III -> 2500;
            case MASTER_I -> 3500;
            case MASTER_II -> 4000;
            case MASTER_III -> 4500;
            case SAINT_I -> 5000;
            case SAINT_II -> 7500;
            case SAINT_III -> 11250;
            default -> throw new IllegalArgumentException();
        };
    }
}
