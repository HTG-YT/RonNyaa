package com.github.htgazurex1212.ronnyaa.models.discord;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public interface IButton {
    void handle(ButtonInteractionEvent event);
}
