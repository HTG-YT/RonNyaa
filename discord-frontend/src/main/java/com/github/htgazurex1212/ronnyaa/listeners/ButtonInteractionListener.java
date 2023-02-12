package com.github.htgazurex1212.ronnyaa.listeners;

import com.github.htgazurex1212.ronnyaa.buttons.FriendsMatchCreationNextStepButton;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ButtonInteractionListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (Objects.equals(event.getButton().getId(), "nextStep")) {
            new FriendsMatchCreationNextStepButton().handle(event);
        }
    }
}
