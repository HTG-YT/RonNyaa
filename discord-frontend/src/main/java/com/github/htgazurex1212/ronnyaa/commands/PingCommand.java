package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.ApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class PingCommand implements ApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("延遲", "獲取延遲資料");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        long time = System.currentTimeMillis();
        event.reply("Pong!")
                .flatMap(
                        hook -> hook.editOriginalFormat("Pong! My latency: `%d ms`", System.currentTimeMillis() - time)
                )
                .queue();
    }
}
