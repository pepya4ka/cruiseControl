package Frames.Enums;

import Frames.Actions;

public enum OperatorComponents {
    START ("start", new Actions.StartAction()),
    GAS ("gas", new Actions.GasAction()),
    BRAKE ("brake", new Actions.BrakeAction()),
    CRUISE ("cruise", new Actions.CruiseAction());

    private String representation;
    private Actions.BaseAction action;

    OperatorComponents(String representation, Actions.BaseAction action) {
        this.representation = representation;
        this.action = action;
    }

    public String getRepresentation() {
        return this.representation;
    }
    public Actions.BaseAction getAction() {
        return action;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
