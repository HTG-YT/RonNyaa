package com.github.htgazurex1212.ronnyaa.models.game;

import com.github.htgazurex1212.ronnyaa.models.ranking.Rank;
import org.jetbrains.annotations.NotNull;

public enum RoomRank {
    BRONZE,
    SILVER,
    GOLD,
    JADE,
    PEAFOWL,
    THRONE;

    public boolean isApplicableToRank(@NotNull Rank rank) {
        return switch (this) {
            case BRONZE -> rank.compareTo(Rank.ADEPT_III) <= 0;                                  // NOVICE_I  to ADEPT_III
            case SILVER ->
                    rank.compareTo(Rank.ADEPT_I) >= 0 && rank.compareTo(Rank.EXPERT_III) <= 0;   // ADEPT_I   to EXPERT_III
            case GOLD ->
                    rank.compareTo(Rank.EXPERT_I) >= 0 && rank.compareTo(Rank.MASTER_III) <= 0;  // EXPERT_I  to MASTER_III
            case JADE ->
                    rank.compareTo(Rank.MASTER_I) >= 0 && rank.compareTo(Rank.SAINT_III) <= 0;   // MASTER_I  to SAINT_III
            case PEAFOWL ->
                    rank.compareTo(Rank.SAINT_I) >= 0 && rank.compareTo(Rank.CELESTIAL) <= 0;    // SAINT_I   to CELESTIAL
            case THRONE ->
                    rank.compareTo(Rank.CELESTIAL) >= 0;                                         // CELESTIAL and above
        };
    }
}
