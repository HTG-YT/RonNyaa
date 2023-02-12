package com.github.htgazurex1212.ronnyaa.buttons;

import com.github.htgazurex1212.ronnyaa.models.discord.IButton;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.util.List;

public class FriendsMatchCreationNextStepButton implements IButton {
    @Override
    public void handle(ButtonInteractionEvent event) {
        String message = event.getMessage().getContentRaw();
        List<String> messageLines = message.lines().toList();

        if (messageLines.get(2).endsWith("：**")) {
            event.editMessage(message + "\n\n:x: **錯誤：請選擇對局長度！**").queue();
            return;
        }

        String gameIdLine = messageLines.get(1);
        String gameIdString = gameIdLine.substring(5, gameIdLine.length() - 2);
        int gameId = Integer.parseInt(gameIdString);
    }
}
