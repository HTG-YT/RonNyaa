package com.github.htgazurex1212.ronnyaa.listeners;

import com.github.htgazurex1212.ronnyaa.commands.PingCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandInteractionListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "延遲":
                new PingCommand().execute(event);
                break;
            default:
                break;
        }
    }
}
