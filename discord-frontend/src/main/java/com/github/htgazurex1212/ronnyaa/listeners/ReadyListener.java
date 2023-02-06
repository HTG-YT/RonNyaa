package com.github.htgazurex1212.ronnyaa.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadyListener extends ListenerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadyListener.class);

    @Override
    public void onReady(ReadyEvent event) {
        JDA jda = event.getJDA();
        SelfUser selfUser = jda.getSelfUser();

        LOGGER.info(selfUser.getAsTag() + " is now connected to Discord");
    }
}
