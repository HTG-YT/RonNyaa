package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import com.github.htgazurex1212.ronnyaa.stringselects.GameFormatStringSelect;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class FriendsMatchCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("友人", "創建友人場對局");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("請完成一下友人場房間設定。（`1 / 1`）\n**對局長度：**")
                .addActionRow(new GameFormatStringSelect().asStringSelect())
                .addActionRow(Button.success("confirm", "確定"))
                .setEphemeral(true)
                .queue();
    }
}
