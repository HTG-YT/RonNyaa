package com.github.htgazurex1212.ronnyaa.models.discord;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public interface IApplicationCommand {
    CommandData asCommandData();

    void execute(SlashCommandInteractionEvent event);
}
