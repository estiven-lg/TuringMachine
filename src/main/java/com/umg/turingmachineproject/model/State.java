package com.umg.turingmachineproject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

    private final String id;
    private final Map<Character, Transition> transitions;

    public State(String name) {
        this.id = name;
        this.transitions = new HashMap<>();
    }

    public void addTransition(Transition transition) {
        if (!transitions.containsKey(transition.getId())) {
            this.transitions.put(transition.getId(), transition);
        }
    }

    public Transition getTransition(Character id) {
        return this.transitions.get(id);
    }

    public Map<Character, Transition> getTransitions(String id) {
        return this.transitions;
    }

    public List<Transition> getTransitionsList() {
        List<Transition> transitionList = new ArrayList<>();

        transitionList.addAll(this.transitions.values());

        return transitionList;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
