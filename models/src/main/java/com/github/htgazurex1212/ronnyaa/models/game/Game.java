package com.github.htgazurex1212.ronnyaa.models.game;

import org.jetbrains.annotations.Nullable;

public class Game {
    public @Nullable RoomRank roomRank;

    public Game(@Nullable RoomRank roomRank) {
        this.roomRank = roomRank;
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
