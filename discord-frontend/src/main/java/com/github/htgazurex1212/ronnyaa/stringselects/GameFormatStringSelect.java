package com.github.htgazurex1212.ronnyaa.stringselects;

import com.github.htgazurex1212.ronnyaa.RonNyaaMain;
import com.github.htgazurex1212.ronnyaa.models.discord.IStringSelect;
import com.github.htgazurex1212.ronnyaa.models.game.Game;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class GameFormatStringSelect implements IStringSelect {
    @Override
    public void handle(StringSelectInteractionEvent event) {
        String display = event.getMessage().getContentRaw();
        if (display.lines().count() == 5) {
            int end = display.lastIndexOf('\n');
            display = display.substring(0, end);

            end = display.lastIndexOf('\n');
            display = display.substring(0, end);
        }

        if (!display.endsWith("：**")) {
            display = display.substring(0, display.length() - 5);
        } else {
            display = display.substring(0, display.length() - 2);
        }

        String type = event.getInteraction().getSelectedOptions().get(0).getLabel();
        event.editMessage(display + type + "**")
                .queue();

        String gameIdLine = display.lines().toList().get(1);
        String gameIdString = gameIdLine.substring(5, gameIdLine.length() - 2);
        int gameId = Integer.parseInt(gameIdString);

        RonNyaaMain.gamePool.put(gameId, new Game(null));

        RonNyaaMain.stepsPool.get(gameId).currentStep().save(RonNyaaMain.gamePool.get(gameId), type);
    }
}
