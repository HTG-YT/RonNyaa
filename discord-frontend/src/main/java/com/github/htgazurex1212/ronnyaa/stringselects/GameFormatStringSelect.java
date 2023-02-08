package com.github.htgazurex1212.ronnyaa.stringselects;

import com.github.htgazurex1212.ronnyaa.models.discord.IStringSelect;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class GameFormatStringSelect implements IStringSelect {
    @Override
    public StringSelectMenu asStringSelect() {
        return StringSelectMenu.create("gameFormat")
                .addOption("三人東", "三人：東一至東三")
                .addOption("三人南", "三人：東一至南三")
                .addOption("三人北", "三人：東一至北三")
                .addOption("四人東", "四人：東一至東四")
                .addOption("四人南", "四人：東一至南四")
                .addOption("四人北", "四人：東一至北四")
                .build();
    }

    @Override
    public void handle(StringSelectInteractionEvent event) {
        event.editMessage(""
                event.getInteraction().getSelectedOptions().get(0).getLabel())
    }
}
