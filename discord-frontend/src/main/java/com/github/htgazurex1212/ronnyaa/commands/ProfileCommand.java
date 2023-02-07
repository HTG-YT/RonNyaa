package com.github.htgazurex1212.ronnyaa.commands;

import com.github.htgazurex1212.ronnyaa.RonNyaaMain;
import com.github.htgazurex1212.ronnyaa.models.discord.IApplicationCommand;
import com.github.htgazurex1212.ronnyaa.models.game.ranking.Rank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Properties;

public class ProfileCommand implements IApplicationCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCommand.class);

    @Override
    public CommandData asCommandData() {
        return Commands.slash("玩家", "提取玩家資料")
                .addOption(OptionType.USER, "user", "玩家 Discord 用戶", false);
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        User user = Objects.requireNonNull(event.getInteraction().getOption("user")).getAsUser();

        Properties properties = new Properties();
        properties.setProperty("user", RonNyaaMain.DOTENV.get("RONNYAA_PGSQL_USERNAME"));
        properties.setProperty("password", RonNyaaMain.DOTENV.get("RONNYAA_PGSQL_PASSWD"));

        try {
            LOGGER.trace("connecting to database");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", properties);

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"Players\" WHERE userid = ?"
            );
            statement.setString(1, user.getId());
            ResultSet resultSet = statement.executeQuery();

            EmbedBuilder builder = new EmbedBuilder()
                    .addField("玩家名稱", resultSet.getString("username"), false)
                    .addField("玩家 ID", user.getId(), false)
                    .addField("段位：三人麻 / 四人麻",
                            Rank.valueOf(resultSet.getInt("threePlayerRank")).toString()
                                    + " / "
                                    + Rank.valueOf(resultSet.getInt("fourPlayerRank")).toString(),
                            true
                    )
                    .addField(
                            "段位分：三人麻 / 四人麻",
                            "`"
                                    + resultSet.getInt("threePlayerXp")
                                    + " / "
                                    + Rank.valueOf(resultSet.getInt("threePlayerRank")).pointsRequired()
                                    + "` / `"
                                    + resultSet.getInt("threePlayerXp")
                                    + " / "
                                    + Rank.valueOf(resultSet.getInt("fourPlayerRank")).pointsRequired()
                                    + "`",
                            false
                    )
                    .setColor(Rank.valueOf(0).embedColor());
            event.replyEmbeds(builder.build())
                    .queue();
        }
        catch (Throwable throwable) {
            LOGGER.error("Unhandled exception:", throwable);
        }
    }
}
