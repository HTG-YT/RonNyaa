package com.github.htgazurex1212.ronnyaa.gamecreation.friends.steps;

import com.github.htgazurex1212.ronnyaa.gamecreation.friends.IFriendsMatchCreationStep;
import com.github.htgazurex1212.ronnyaa.models.game.Game;
import com.github.htgazurex1212.ronnyaa.models.game.GameType;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.ArrayList;
import java.util.List;

public class GameFormatStep implements IFriendsMatchCreationStep {
    public int gameId;

    public GameFormatStep(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public String message() {
        return "請完成友人場房間設定。（`1 / 2`）\n**房號：" + this.gameId + "**\n**對局長度：**";
    }

    @Override
    public List<ItemComponent> asComponents() {
        ArrayList<ItemComponent> list = new ArrayList<>();
        list.add(
                StringSelectMenu.create("gameFormat")
                        .addOption("三人東", "三人：東一至東三")
                        .addOption("三人南", "三人：東一至南三")
                        .addOption("三人北", "三人：東一至北三")
                        .addOption("四人東", "四人：東一至東四")
                        .addOption("四人南", "四人：東一至南四")
                        .addOption("四人北", "四人：東一至北四")
                        .build()
        );
        list.add(Button.primary("nextStep", "下一步"));

        return list;
    }

    @Override
    public void save(Game game, Object data) {
        String type = (String) data;

        game.gameType = GameType.of(type);
        System.out.println(game.gameType);
    }
}
