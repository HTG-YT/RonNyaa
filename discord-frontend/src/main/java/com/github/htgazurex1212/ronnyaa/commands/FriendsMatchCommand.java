package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

public class FriendsMatchCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("友人", "創建友人場對局");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        ReplyCallbackAction action = event.reply("請完成友人場房間設定。（`1 / 1`）\n**對局長度：**")
                .setEphemeral(true);
    }
}
