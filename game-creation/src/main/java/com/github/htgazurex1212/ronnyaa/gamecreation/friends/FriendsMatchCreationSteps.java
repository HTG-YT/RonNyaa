package com.github.htgazurex1212.ronnyaa.gamecreation.friends;

import com.github.htgazurex1212.ronnyaa.gamecreation.friends.steps.GameFormatStep;

import java.util.ArrayList;
import java.util.List;

public class FriendsMatchCreationSteps {
    public List<IFriendsMatchCreationStep> steps;

    public FriendsMatchCreationSteps() {
        steps = new ArrayList<>();
        steps.add(new GameFormatStep());
    }
}
