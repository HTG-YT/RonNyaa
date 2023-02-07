package com.github.htgazurex1212.ronnyaa;

import com.github.htgazurex1212.ronnyaa.commands.PingCommand;
import com.github.htgazurex1212.ronnyaa.commands.ProfileCommand;
import com.github.htgazurex1212.ronnyaa.commands.RegisterCommand;
import com.github.htgazurex1212.ronnyaa.listeners.ModalInteractionListener;
import com.github.htgazurex1212.ronnyaa.listeners.ReadyListener;
import com.github.htgazurex1212.ronnyaa.listeners.SlashCommandInteractionListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import org.slf4j.LoggerFactory;

public class RonNyaaMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(RonNyaaMain.class);
    public static final Dotenv DOTENV = new DotenvBuilder().load();

    public static void main(String[] args) {
        try {
            LOGGER.trace("loading environment variables");

            LOGGER.trace("building JDA");
            JDA jda = JDABuilder
                    .create(DOTENV.get("RONNYAA_BOT_TOKEN"), GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .addEventListeners(
                            new ModalInteractionListener(),
                            new ReadyListener(),
                            new SlashCommandInteractionListener()
                    )
                    .build();

            jda.awaitReady();

            jda.updateCommands()
                    .addCommands(new PingCommand().asCommandData())
                    .addCommands(new ProfileCommand().asCommandData())
                    .addCommands(new RegisterCommand().asCommandData())
                    .queue();
        } catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}
