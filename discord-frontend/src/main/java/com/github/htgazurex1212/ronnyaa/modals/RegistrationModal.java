package com.github.htgazurex1212.ronnyaa.modals;

import com.github.htgazurex1212.ronnyaa.RonNyaaMain;
import com.github.htgazurex1212.ronnyaa.models.discord.IModal;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Properties;

public class RegistrationModal implements IModal {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationModal.class);
    @Override
    public Modal asModal() {
        TextInput username = TextInput.create("username", "玩家名稱", TextInputStyle.SHORT)
                .setMinLength(2)
                .setMaxLength(12)
                .build();

        return Modal.create("registration", "玩家登記")
                .addActionRows(ActionRow.of(username))
                .build();
    }

    @Override
    public void handle(ModalInteractionEvent event) {
        Properties properties = new Properties();
        properties.setProperty("user", RonNyaaMain.DOTENV.get("RONNYAA_PGSQL_USERNAME"));
        properties.setProperty("password", RonNyaaMain.DOTENV.get("RONNYAA_PGSQL_PASSWD"));

        try {
            LOGGER.trace("connecting to database");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", properties);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Players\" (username, userid, rank, xp) VALUES (?, ?, ?, ?)");
            statement.setString(1, Objects.requireNonNull(event.getValue("username")).getAsString());
            statement.setString(2, event.getInteraction().getUser().getId());
            statement.setInt(3, 0);
            statement.setInt(4, 0);
            statement.executeUpdate();
        }
        catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}
