package com.github.htgazurex1212.ronnyaa.gamecreation.friends.steps;

import com.github.htgazurex1212.ronnyaa.gamecreation.friends.IFriendsMatchCreationStep;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.util.ArrayList;
import java.util.List;

public class GameFormatStep implements IFriendsMatchCreationStep {
    @Override
    public List<Component> asComponents() {
        ArrayList<Component> list = new ArrayList<>();
        list.add(StringSelectMenu.create("gameFormat")
                        .addOption("三人東", "三人：東一至東三")
                        .addOption("三人南", "三人：東一至南三")
                        .addOption("三人北", "三人：東一至北三")
                        .addOption("四人東", "四人：東一至東四")
                        .addOption("四人南", "四人：東一至南四")
                        .addOption("四人北", "四人：東一至北四")
                        .build());
        list.add(Button.success("confirm", "確定"));

        return list;
    }
}
