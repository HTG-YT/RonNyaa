package com.github.htgazurex1212.ronnyaa.models.game;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Game {
    public @Nullable RoomRank roomRank;
    public @NotNull GameType gameType;

    public Game(@Nullable RoomRank roomRank, @NotNull GameType gameType) {
        this.roomRank = roomRank;
        this.gameType = gameType;
    }

    public @NotNull GameType getGameType() {
        return gameType;
    }

    public @Nullable RoomRank getRoomRank() {
        return roomRank;
    }

    public boolean isFriendly() {
        return !isRanked();
    }

    public boolean isRanked() {
        return roomRank != null;
    }
}
