package com.github.htgazurex1212.ronnyaa.models.game.player;

import com.github.htgazurex1212.ronnyaa.models.game.ranking.Rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Player {
    private @NotNull String username;
    private @NotNull String userId;
    private @NotNull Rank fourPlayerRank;
    private @NotNull Rank threePlayerRank;
    private int fourPlayerXp;
    private int threePlayerXp;

    public Player(
            @NotNull String username,
            @NotNull String userId,
            @Nullable Rank threePlayerRank,
            @Nullable Rank fourPlayerRank,
            int threePlayerXp,
            int fourPlayerXp
    ) {
        this.username = username;
        this.userId = userId;
        this.threePlayerRank = threePlayerRank == null ? Rank.NOVICE_I : threePlayerRank;
        this.threePlayerXp = threePlayerXp;
        this.fourPlayerRank = fourPlayerRank == null ? Rank.NOVICE_I : fourPlayerRank;
        this.fourPlayerXp = fourPlayerXp;
    }

    public @NotNull Rank getThreePlayerRank() {
        return threePlayerRank;
    }

    public @NotNull Rank getFourPlayerRank() {
        return fourPlayerRank;
    }

    public int getThreePlayerXp() {
        return threePlayerXp;
    }

    public int getFourPlayerXp() {
        return fourPlayerXp;
    }

    public @NotNull String getUserId() {
        return userId;
    }

    public @NotNull String getUsername() {
        return username;
    }

    public void setThreePlayerRank(@NotNull Rank rank) {
        this.threePlayerRank = rank;
    }

    public void setFourPlayerRank(@NotNull Rank fourPlayerRank) {
        this.fourPlayerRank = fourPlayerRank;
    }

    public void setThreePlayerXp(int threePlayerXp) {
        this.threePlayerXp = threePlayerXp;
    }

    public void setFourPlayerXp(int fourPlayerXp) {
        this.fourPlayerXp = fourPlayerXp;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

}
