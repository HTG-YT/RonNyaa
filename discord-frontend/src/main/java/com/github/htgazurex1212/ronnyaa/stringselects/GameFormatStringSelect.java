package com.github.htgazurex1212.ronnyaa.stringselects;

import com.github.htgazurex1212.ronnyaa.models.discord.IStringSelect;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;

public class GameFormatStringSelect implements IStringSelect {
    @Override
    public void handle(StringSelectInteractionEvent event) {
        event.editMessage("請完成一下友人場房間設定。（`1 / 1`）\n**對局長度："
                        + event.getInteraction().getSelectedOptions().get(0).getLabel() + "**"
                )
                .queue();
    }
}
