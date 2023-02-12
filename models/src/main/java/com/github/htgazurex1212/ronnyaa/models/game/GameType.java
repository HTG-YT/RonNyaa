package com.github.htgazurex1212.ronnyaa.models.game;

public enum GameType {
    THREE_PLAYER_EAST,
    THREE_PLAYER_SOUTH,
    THREE_PLAYER_NORTH,

    FOUR_PLAYER_EAST,
    FOUR_PLAYER_SOUTH,
    FOUR_PLAYER_NORTH;

    public static GameType of(String name) {
        return switch (name) {
            case "三人東" -> GameType.THREE_PLAYER_EAST;
            case "三人南" -> GameType.THREE_PLAYER_SOUTH;
            case "三人北" -> GameType.THREE_PLAYER_NORTH;
            case "四人東" -> GameType.FOUR_PLAYER_EAST;
            case "四人南" -> GameType.FOUR_PLAYER_SOUTH;
            case "四人北" -> GameType.FOUR_PLAYER_NORTH;
            default -> throw new IllegalArgumentException();
        };
    }
}
