package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.RonNyaaMain;
import com.github.htgazurex1212.ronnyaa.gamecreation.friends.FriendsMatchCreationSteps;
import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import java.util.Random;

public class FriendsMatchCommand implements IApplicationCommand {
    @Override
    public CommandData asCommandData() {
        return Commands.slash("友人", "創建友人場對局");
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        int gameId = new Random().nextInt(100000, 1000000);
        FriendsMatchCreationSteps steps = new FriendsMatchCreationSteps(gameId);
        RonNyaaMain.stepsPool.put(gameId, steps);

        ReplyCallbackAction action = event.reply(steps.steps.get(0).message())
                .setEphemeral(true);

        for (Component components : steps.steps.get(0).asComponents()) {
            action
                    .addActionRow(components);
        }
    }
}
