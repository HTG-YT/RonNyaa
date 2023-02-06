package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.ApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class RegisterCommand implements ApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("登記", "新玩家登記");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        TextInput username = TextInput.create("username", "玩家名稱", TextInputStyle.SHORT)
                .setMinLength(2)
                .setMaxLength(12)
                .build();
        Modal modal = Modal.create("registration", "玩家登記")
                .addActionRows(ActionRow.of(username))
                .build();

        event.replyModal(modal)
                .queue();
    }
}
