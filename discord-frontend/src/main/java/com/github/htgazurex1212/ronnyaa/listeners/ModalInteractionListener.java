package com.github.htgazurex1212.ronnyaa.listeners;

import com.github.htgazurex1212.ronnyaa.modals.RegistrationModal;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ModalInteractionListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        if (event.getModalId().equals("registration")) {
            new RegistrationModal().handle(event);
        }
    }
}
