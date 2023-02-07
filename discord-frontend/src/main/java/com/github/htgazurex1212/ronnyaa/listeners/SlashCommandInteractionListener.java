package com.github.htgazurex1212.ronnyaa.listeners;

import com.github.htgazurex1212.ronnyaa.commands.PingCommand;
import com.github.htgazurex1212.ronnyaa.commands.ProfileCommand;
import com.github.htgazurex1212.ronnyaa.commands.RegisterCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandInteractionListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "延遲" -> new PingCommand().execute(event);
            case "玩家" -> new ProfileCommand().execute(event);
            case "登記" -> new RegisterCommand().execute(event);
            default -> {
            }
        }
    }
}
