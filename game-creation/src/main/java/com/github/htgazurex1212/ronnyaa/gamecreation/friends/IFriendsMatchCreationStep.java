package com.github.htgazurex1212.ronnyaa.gamecreation.friends;

import net.dv8tion.jda.api.interactions.components.ItemComponent;

import java.util.List;

public interface IFriendsMatchCreationStep {
    String message();

    List<ItemComponent> asComponents();
}
