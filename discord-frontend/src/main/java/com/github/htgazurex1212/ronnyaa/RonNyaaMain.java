package com.github.htgazurex1212.ronnyaa;

import com.github.htgazurex1212.ronnyaa.commands.FriendsMatchCommand;
import com.github.htgazurex1212.ronnyaa.commands.PingCommand;
import com.github.htgazurex1212.ronnyaa.commands.ProfileCommand;
import com.github.htgazurex1212.ronnyaa.commands.RegisterCommand;
import com.github.htgazurex1212.ronnyaa.gamecreation.friends.FriendsMatchCreationSteps;
import com.github.htgazurex1212.ronnyaa.listeners.*;
import com.github.htgazurex1212.ronnyaa.models.game.Game;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class RonNyaaMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(RonNyaaMain.class);
    public static final Dotenv DOTENV = new DotenvBuilder().load();

    public static Map<Integer, FriendsMatchCreationSteps> stepsPool = new HashMap<>();
    public static Map<Integer, Game> gamePool = new HashMap<>();

    public static void main(String[] args) {
        try {
            LOGGER.trace("loading environment variables");

            LOGGER.trace("building JDA");
            JDA jda = JDABuilder
                    .create(DOTENV.get("RONNYAA_BOT_TOKEN"), GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .addEventListeners(
                            new ButtonInteractionListener(),
                            new ModalInteractionListener(),
                            new ReadyListener(),
                            new SlashCommandInteractionListener(),
                            new StringSelectInteractionListener()
                    )
                    .build();

            jda.awaitReady();

            jda.updateCommands()
                    .addCommands(new FriendsMatchCommand().asCommandData())
                    .addCommands(new PingCommand().asCommandData())
                    .addCommands(new ProfileCommand().asCommandData())
                    .addCommands(new RegisterCommand().asCommandData())
                    .queue();
        } catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}
