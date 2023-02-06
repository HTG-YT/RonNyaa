package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.modals.RegistrationModal;
import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class RegisterCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("登記", "新玩家登記");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.replyModal(new RegistrationModal().asModal())
                .queue();
    }
}
