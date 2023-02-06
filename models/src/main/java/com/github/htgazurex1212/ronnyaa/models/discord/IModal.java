package com.github.htgazurex1212.ronnyaa.models.discord;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.Modal;

public interface IModal {
    Modal asModal();

    void handle(ModalInteractionEvent event);
}
