package com.github.htgazurex1212.ronnyaa.modals;

import com.github.htgazurex1212.ronnyaa.models.discord.IModal;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class RegistrationModal implements IModal {
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

    }
}
