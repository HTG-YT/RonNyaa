package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class PingCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("延遲", "獲取延遲資料");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        long time = System.currentTimeMillis();
        event.reply("我的延遲嘛...")
                .flatMap(
                        hook -> hook.editOriginalFormat("我的延遲嘛... `%d 毫秒`", System.currentTimeMillis() - time)
                )
                .queue();
    }
}
