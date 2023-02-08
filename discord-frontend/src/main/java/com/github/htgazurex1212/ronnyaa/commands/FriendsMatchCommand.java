package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class FriendsMatchCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("友人", "創建友人場對局");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

    }
}
