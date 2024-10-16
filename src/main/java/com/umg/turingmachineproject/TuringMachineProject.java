/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.umg.turingmachineproject;

import com.umg.turingmachineproject.model.State;
import com.umg.turingmachineproject.model.TuringMachine;

/**
 *
 * @author estiven
 */
public class TuringMachineProject {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        TuringMachine machine = TuringMachine.getInstance();

        // Crear estados
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2"); // Estado de aceptación

        // Configurar estado inicial y de aceptación
        machine.setInitialState(q0);
        machine.setFinalState(q2);

        // Agregar estados a la máquina
        machine.addState(q0);
        machine.addState(q1);
        machine.addState(q2);

        // Agregar transiciones
        machine.addTransition("q0", "q1", 'a', 'b', 'R'); // Cambia 'a' por 'b' y va a la derecha
        machine.addTransition("q1", "q2", 'b', 'a', 'R'); // Cambia 'b' por 'a' y va a la derecha
        machine.addTransition("q2", "q2", 'b', 'a', 'R'); // Cambia 'b' por 'a' y va a la derecha
        machine.addTransition("q2", "q2", 'a', 'b', 'R'); // Cambia 'b' por 'a' y va a la derecha

        machine.addTransition("q2", "q2", '\0', '\0', 'R'); // Transición al vacío en el estado de aceptación

        machine.execute("abbaa");

        while (machine.canProceed()) {
            System.out.println(machine.toString());
            machine.nextStep();

        }
        System.out.println(machine.toString());
        
        

    }
}
