package com.github.htgazurex1212.ronnyaa;

import com.github.htgazurex1212.ronnyaa.listeners.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import org.slf4j.LoggerFactory;

public class RonNyaaMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(RonNyaaMain.class);

    public static void main(String[] args) throws InterruptedException {
        try {
            LOGGER.trace("loading environment variables");
            Dotenv dotenv = new DotenvBuilder().load();

            LOGGER.trace("building JDA");
            JDA jda = JDABuilder
                    .create(dotenv.get("BOT_TOKEN"), GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .addEventListeners(new ReadyListener())
                    .build();

            jda.awaitReady();
        } catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}