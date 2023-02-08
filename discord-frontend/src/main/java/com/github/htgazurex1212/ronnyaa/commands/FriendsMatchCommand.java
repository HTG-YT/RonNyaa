package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class FriendsMatchCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("友人", "創建友人場對局");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("請完成一下友人場房間設定。（`1 / 1`）\n**對局長度：**")
                .addActionRow(StringSelectMenu.create("gameFormat")
                        .addOption("三人東", "三人：東一至東三")
                        .addOption("三人南", "三人：東一至南三")
                        .addOption("三人北", "三人：東一至北三")
                        .addOption("四人東", "四人：東一至東四")
                        .addOption("四人南", "四人：東一至南四")
                        .addOption("四人北", "四人：東一至北四")
                        .build()
                )
                .addActionRow(Button.success("confirm", "確定"))
                .setEphemeral(true)
                .queue();
    }
}
