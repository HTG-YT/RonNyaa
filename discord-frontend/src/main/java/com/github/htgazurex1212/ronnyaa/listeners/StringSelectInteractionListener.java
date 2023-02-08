package com.github.htgazurex1212.ronnyaa.listeners;

import com.github.htgazurex1212.ronnyaa.stringselects.GameFormatStringSelect;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StringSelectInteractionListener extends ListenerAdapter {
    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        switch (event.getComponentId()) {
            case "gameFormat" -> new GameFormatStringSelect().handle(event);
        }
    }
}
