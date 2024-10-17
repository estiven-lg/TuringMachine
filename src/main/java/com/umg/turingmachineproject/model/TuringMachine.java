package com.umg.turingmachineproject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TuringMachine {

    private int headPosition;
    private final int limitEmptySpaces = 50;
    private final char blankSymbol = '▢';
    List<Character> tape = new ArrayList<>();
    private final List<Character> alphabet = new ArrayList<>();
    private final Map<String, State> states = new HashMap<>();
    private State currentState, initialState, finalState;
    private static TuringMachine instance; // Instancia única (Singleton)

    // Constructor privado para Singleton
    private TuringMachine() {
    }

    // Método estático para obtener la única instancia de TuringMachine
    public static TuringMachine getInstance() {
        if (instance == null) {
            instance = new TuringMachine();
        }
        return instance;
    }

    // Método para establecer el estado inicial
    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    // Método para establecer el estado final
    public void setFinalState(State finalState) {
        this.finalState = finalState;
    }

    // Obtener el estado inicial
    public State getInitialState() {
        return initialState;
    }

    // Obtener el estado final
    public State getFinalState() {
        return finalState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public List<Character> getTape() {
        return tape;
    }

    public int getHeadPosition() {
        return headPosition;
    }
    
    

    // obtener stados dentro de la maquina
    public List<State> getStatesList() {
        return new ArrayList<>(states.values());
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public List<Transition> getAllTransitions() {
        List<Transition> allTransitions = new ArrayList<>();

        for (State state : states.values()) {
            allTransitions.addAll(state.getTransitionsList());
        }

        return allTransitions;
    }

    // Método para agregar estados
    public void addState(State state) {
        if (!states.containsKey(state.getId())) {
            states.put(state.getId(), state);
        }
    }

    // Método para agregar símbolos al alfabeto
    public void addSymbol(char symbol) {
        if (!alphabet.contains(symbol)) {
            alphabet.add(symbol);
        }
    }

    // Método para agregar transiciones
    public void addTransition(
            String currentStateId,
            String nextStateId,
            char currentSimbol,
            char nextSimbol,
            char direction
    ) {
        if (states.containsKey(currentStateId)) {
            Transition newTransition = new Transition(currentSimbol, nextSimbol, direction, nextStateId);
            this.states.get(currentStateId).addTransition(newTransition);
        }
    }

    // Método para iniciar el proceso de la cadena 
    public void execute(String input) {
        for (char c : input.toCharArray()) {
            tape.add(c);
        }

        this.currentState = initialState;
        headPosition = 0;
    }

    // retorna un booleano, indica si se puede seguir transicionando
    public boolean canProceed() {

        // Si la cabeza de la cinta sale de los límites
        if (headPosition < 0 || headPosition >= tape.size()) {
            System.out.println("finalizo de la cinta");
            return false;
        }

        // si este simbolo no esta en el alfabeto
        if (!alphabet.contains(tape.get(headPosition))) {
            System.out.println("este simbolo no esta en el alfabeto");
            return false;
        }

        // No hay transición disponible
        if (currentState.getTransition(tape.get(headPosition)) == null) {
            System.out.println("no hay transcion");
            return false;
        }

        return true;
    }

    // retorna un booleano,que indica si el automata esta en un estado de aceptacion
    public boolean isValidInput() {
        if (currentState.equals(finalState)) {
            return false;
        }

        if (alphabet.contains(tape.get(headPosition))) {
            return false;
        }

        return true;
    }

    // retorna una respuesta del estado del automata
    public String getValidationResult() {
        if (currentState.equals(finalState)) {
            return "no termino en estado final";
        }

        if (alphabet.contains(tape.get(headPosition))) {
            return "el simbolo no esta en el alfabeto";
        }

        return "la cadena es valida";
    }

    // funcion que permite avanzar de estado , transicionando la cadena
    public boolean nextStep() {
        char currentSymbol = tape.get(headPosition);
        Transition transition = currentState.getTransition(currentSymbol);

        // Si la cabeza de la cinta sale de los límites
        if ((headPosition < 0 || headPosition >= tape.size())
                && transition.getReadSymbol() != blankSymbol) {
            System.out.println("salio de la cinta");
            return false;
        }

        if (transition.getReadSymbol() == blankSymbol) {
            if (transition.getMoveDirection() == 'R') {
                tape.add(transition.getWriteSymbol());
            } else if ('L' == transition.getMoveDirection()) {
                tape.add(0, transition.getWriteSymbol());
            }
        }

        // Escribir el siguente símbolo en la cinta
        tape.set(headPosition, transition.getWriteSymbol());

        // Mover la cabeza de la cinta
        if (transition.getMoveDirection() == 'R') {
            headPosition++;
        } else if (transition.getMoveDirection() == 'L') {
            headPosition--;
        }

        // Cambiar al siguiente estado
        currentState = states.get(transition.getNextState());

        // Verificar si el estado final es el de aceptación
        return currentState != null && currentState.equals(finalState);
    }

    @Override
    public String toString() {
        String txt = "";
        txt += "headPosition:" + this.headPosition + "\n";
        txt += "tape:" + this.tape.toString() + "\n";
        txt += "Current State:" + this.currentState.toString() + "\n";
        return txt;
    }
}
