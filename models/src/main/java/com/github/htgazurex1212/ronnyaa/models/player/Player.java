package com.github.htgazurex1212.ronnyaa.models.player;

import com.github.htgazurex1212.ronnyaa.models.ranking.Rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Player {
    private @NotNull String username;
    private @NotNull String userId;
    private @NotNull Rank rank;
    private int xp;

    public Player(@NotNull String username, @NotNull String userId, @Nullable Rank rank, int xp) {
        this.rank = rank == null ? Rank.NOVICE_I : rank;
        this.username = username;
        this.userId = userId;
        this.xp = xp;
    }

    public @NotNull Rank getRank() {
        return rank;
    }

    public @NotNull String getUserId() {
        return userId;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public int getXp() {
        return xp;
    }

    public void setRank(@NotNull Rank rank) {
        this.rank = rank;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
