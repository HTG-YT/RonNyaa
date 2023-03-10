package com.github.htgazurex1212.ronnyaa.gamecreation.friends;

import com.github.htgazurex1212.ronnyaa.gamecreation.friends.steps.GameFormatStep;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FriendsMatchCreationSteps {
    public List<IFriendsMatchCreationStep> steps;

    public int gameId;

    private int currentStep = 0;

    public FriendsMatchCreationSteps(int gameId) {
        steps = new ArrayList<>();
        steps.add(new GameFormatStep(gameId));

        this.gameId = gameId;
    }

    public @NotNull IFriendsMatchCreationStep firstStep() {
        return steps.get(0);
    }

    public @NotNull IFriendsMatchCreationStep currentStep() {
        return steps.get(currentStep);
    }

    public @NotNull IFriendsMatchCreationStep nextStep() {
        currentStep += 1;
        return steps.get(currentStep);
    }
}
