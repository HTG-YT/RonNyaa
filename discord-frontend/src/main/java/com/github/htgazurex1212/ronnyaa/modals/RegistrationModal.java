package com.github.htgazurex1212.ronnyaa.modals;

import com.github.htgazurex1212.ronnyaa.RonNyaaMain;
import com.github.htgazurex1212.ronnyaa.models.discord.IModal;
import com.github.htgazurex1212.ronnyaa.models.game.ranking.Rank;
import net.dv8tion.jda.api.EmbedBuilder;
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

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO \"Players\" (username, userid, \"threePlayerRank\", \"threePlayerXp\", \"fourPlayerRank\", \"fourPlayerXp\") VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, Objects.requireNonNull(event.getValue("username")).getAsString());
            statement.setString(2, event.getInteraction().getUser().getId());
            statement.setInt(3, 0);
            statement.setInt(4, 0);
            statement.setInt(5, 0);
            statement.setInt(6, 0);
            statement.executeUpdate();

            @SuppressWarnings("DataFlowIssue")
            EmbedBuilder builder = new EmbedBuilder()
                    .addField("玩家名稱", event.getValue("username").getAsString(), false)
                    .addField("玩家 ID", event.getInteraction().getUser().getId(), false)
                    .addField("段位：三人麻", Rank.valueOf(0).toString(), true)
                    .addField("段位：四人麻", Rank.valueOf(0).toString(), true)
                    .addField("段位分：三人麻", "`0 / " + Rank.valueOf(0).pointsRequired() + "`", false)
                    .addField("段位分：四人麻", "`0 / " + Rank.valueOf(0).pointsRequired() + "`", true)
                    .setColor(Rank.valueOf(0).embedColor());
            event.reply("登記完成！請檢查以下資料是否正確：")
                    .setEphemeral(true)
                    .addEmbeds(builder.build())
                    .queue();
        }
        catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}
