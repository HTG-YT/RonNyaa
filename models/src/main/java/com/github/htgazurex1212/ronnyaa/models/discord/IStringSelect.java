package com.github.htgazurex1212.ronnyaa.models.discord;

import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public interface IStringSelect {
    void handle(StringSelectInteractionEvent event);
}
