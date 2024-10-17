package com.umg.turingmachineproject.model;

public class Transition {

    private final char id;
    private final char readSymbol;
    private final char writeSymbol;
    private final char moveDirection;  // 'L' para izquierda, 'R' para derecha
    private final String nextState;

    public Transition(char readSymbol, char writeSymbol, char moveDirection, String nextState) {
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
        this.id = readSymbol;
    }

    public char getReadSymbol() {
        return readSymbol;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public char getMoveDirection() {
        return moveDirection;
    }

    public String getNextState() {
        return nextState;
    }

    public char getId() {
        return id;
    }

    @Override
    public String toString() {
        return readSymbol + "," + writeSymbol + ";" + moveDirection + "|" + nextState;
    }

}
