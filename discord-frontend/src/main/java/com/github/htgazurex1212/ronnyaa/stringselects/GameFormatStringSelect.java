package com.github.htgazurex1212.ronnyaa.stringselects;

import com.github.htgazurex1212.ronnyaa.models.discord.IStringSelect;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class GameFormatStringSelect implements IStringSelect {
    @Override
    public void handle(StringSelectInteractionEvent event) {
        String display = event.getMessage().getContentRaw();
        System.out.println(display);
        if (!display.endsWith("：**")) {
            display = display.substring(0, display.length() - 5);
        } else {
            display = display.substring(0, display.length() - 2);
        }

        event.editMessage(display
                        + event.getInteraction().getSelectedOptions().get(0).getLabel()
                        + "**"
                )
                .queue();
    }
}
