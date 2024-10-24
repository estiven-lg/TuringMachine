
package view;

import com.umg.turingmachineproject.model.State;
import com.umg.turingmachineproject.model.Transition;
import com.umg.turingmachineproject.model.TuringMachine;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author dany9
 */
public class EstadoDatos extends javax.swing.JFrame {

    /**
     * Creates new form EstadoDatos
     */
    public EstadoDatos() {
        initComponents();
        actualizarDatos();
    }
    
    TuringMachine turingMachine = TuringMachine.getInstance();

    //Ingreso ingresoView = new Ingreso();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void actualizarEstadoActualCinta(List<Character> tape, int headPosition) {
        if (tape == null || tape.isEmpty()) {
            lblCinta.setText("Cinta vacía");
            return;
        }

        if (headPosition < 0 || headPosition >= tape.size()) {
            lblCinta.setText("Cabezal fuera");
            return;
        }

        StringBuilder estadoActual = new StringBuilder("<html>");
        int previousPos = Math.max(0, headPosition - 1);
        int nextPos = Math.min(tape.size() - 1, headPosition + 1);

        // Iterar sobre la cinta y colorear el anterior, actual y siguiente caracteres del cabezal
        for (int i = 0; i < tape.size(); i++) {
            if (i == headPosition) {
                estadoActual.append("<span style='color:red;'><b>'").append(tape.get(i)).append("'</b></span>"); // Cabezal actual en rojo y negrita
            } else if (i == previousPos || i == nextPos) {
                estadoActual.append("<span style='color:blue;'>").append(tape.get(i)).append("</span>"); // Elementos anteriores y siguientes en azul
            } else {
                estadoActual.append(tape.get(i));
            }

            // Separar cada carácter para mejor visualización
            estadoActual.append(" ");
        }

        estadoActual.append("</html>");
        lblCinta.setText(estadoActual.toString());
    }


    public void actualizarDatos() {
        Boolean machingReady = true; // turingMachine.canProceed();

        if (machingReady) {
            // Actualizar el estado actual de la máquina de Turing
            lblMostrarEstadoActual.setText(turingMachine.getCurrentState().getId());

            // Actualizar la visualización de la cinta
            actualizarEstadoActualCinta(turingMachine.getTape(), turingMachine.getHeadPosition());

            // Obtener la lista de transiciones del estado actual
            List<Transition> transiciones = turingMachine.getCurrentState().getTransitionsList();

            // Actualizar las siguientes transiciones visualmente
            actualizarSiguientesEstados(transiciones);
        } else {
            // Mostrar el resultado de validación si la máquina no puede proceder
            lblCadenaCondicion.setText(turingMachine.getValidationResult());
        }
    }
    
    public void actualizarSiguientesEstados(List<Transition> transitions) {
        int transitionCount = transitions.size();

        if (transitionCount >= 2) {
            // Obtener la primera transición
            Transition t1 = transitions.get(0);
            lblSiguienteEstado1.setText("<html>Estado: " + t1.getNextState() + "<br>"
                                        + "Transición: " + t1.getReadSymbol() + " → " + t1.getWriteSymbol() + "<br>"
                                        + "Movimiento: " + (t1.getMoveDirection() == 'L' ? "Izquierda" : "Derecha")
                                        + "</html>");

            // Obtener la segunda transición
            Transition t2 = transitions.get(1);
            lblSiguienteEstado2.setText("<html>Estado: " + t2.getNextState() + "<br>"
                                        + "Transición: " + t2.getReadSymbol() + " → " + t2.getWriteSymbol() + "<br>"
                                        + "Movimiento: " + (t2.getMoveDirection() == 'L' ? "Izquierda" : "Derecha")
                                        + "</html>");

        } else if (transitionCount == 1) {
            // Si solo hay una transición
            Transition t1 = transitions.get(0);
            lblSiguienteEstado1.setText("<html>Estado: " + t1.getNextState() + "<br>"
                                        + "Transición: " + t1.getReadSymbol() + " → " + t1.getWriteSymbol() + "<br>"
                                        + "Movimiento: " + (t1.getMoveDirection() == 'L' ? "Izquierda" : "Derecha")
                                        + "</html>");
            lblSiguienteEstado2.setText("Sin transición adicional");
        } else {
            // Si no hay transiciones
            lblSiguienteEstado1.setText("Sin transiciones");
            lblSiguienteEstado2.setText("Sin transiciones");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlEstadoActual = new javax.swing.JPanel();
        lblEstadoActual = new javax.swing.JLabel();
        lblMostrarEstadoActual = new javax.swing.JLabel();
        pnlCintaPosicion = new javax.swing.JPanel();
        lblCintaPosicion = new javax.swing.JLabel();
        lblCinta = new javax.swing.JLabel();
        lblPosicionActual1 = new javax.swing.JLabel();
        pnlSiguientesEstados = new javax.swing.JPanel();
        lblSiguienteEstado2 = new javax.swing.JLabel();
        lblSiguienteEstado1 = new javax.swing.JLabel();
        lblSiguientesEstados = new javax.swing.JLabel();
        pnlEstadoCadena = new javax.swing.JPanel();
        lblCadenaCondicion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSiguienteEstado = new javax.swing.JButton();
        btnNuevoIngreso = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFondo.setForeground(new java.awt.Color(255, 255, 255));

        pnlEstadoActual.setBackground(new java.awt.Color(204, 204, 204));
        pnlEstadoActual.setForeground(new java.awt.Color(153, 153, 153));

        lblEstadoActual.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEstadoActual.setForeground(new java.awt.Color(0, 102, 102));
        lblEstadoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstadoActual.setText("Estado Actual");

        lblMostrarEstadoActual.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMostrarEstadoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarEstadoActual.setText("...............");

        javax.swing.GroupLayout pnlEstadoActualLayout = new javax.swing.GroupLayout(pnlEstadoActual);
        pnlEstadoActual.setLayout(pnlEstadoActualLayout);
        pnlEstadoActualLayout.setHorizontalGroup(
            pnlEstadoActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoActualLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlEstadoActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEstadoActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMostrarEstadoActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlEstadoActualLayout.setVerticalGroup(
            pnlEstadoActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoActualLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblMostrarEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pnlCintaPosicion.setBackground(new java.awt.Color(204, 204, 204));
        pnlCintaPosicion.setForeground(new java.awt.Color(153, 153, 153));

        lblCintaPosicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCintaPosicion.setForeground(new java.awt.Color(0, 102, 102));
        lblCintaPosicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCintaPosicion.setText("Cinta");

        lblCinta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCinta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCinta.setText("---------------------------");
        lblCinta.setMaximumSize(new java.awt.Dimension(60, 17));
        lblCinta.setMinimumSize(new java.awt.Dimension(60, 17));
        lblCinta.setPreferredSize(new java.awt.Dimension(150, 17));

        lblPosicionActual1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPosicionActual1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosicionActual1.setText("Rojo posición actual");

        javax.swing.GroupLayout pnlCintaPosicionLayout = new javax.swing.GroupLayout(pnlCintaPosicion);
        pnlCintaPosicion.setLayout(pnlCintaPosicionLayout);
        pnlCintaPosicionLayout.setHorizontalGroup(
            pnlCintaPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCintaPosicionLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(pnlCintaPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblCintaPosicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCintaPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPosicionActual1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
        );
        pnlCintaPosicionLayout.setVerticalGroup(
            pnlCintaPosicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCintaPosicionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblCintaPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblCinta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblPosicionActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pnlSiguientesEstados.setBackground(new java.awt.Color(204, 204, 204));
        pnlSiguientesEstados.setForeground(new java.awt.Color(204, 204, 204));

        lblSiguienteEstado2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSiguienteEstado2.setText("......................................................");
        lblSiguienteEstado2.setMaximumSize(new java.awt.Dimension(216, 34));
        lblSiguienteEstado2.setMinimumSize(new java.awt.Dimension(216, 34));
        lblSiguienteEstado2.setPreferredSize(new java.awt.Dimension(216, 34));

        lblSiguienteEstado1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSiguienteEstado1.setText("......................................................");
        lblSiguienteEstado1.setMaximumSize(new java.awt.Dimension(216, 34));
        lblSiguienteEstado1.setMinimumSize(new java.awt.Dimension(216, 34));
        lblSiguienteEstado1.setPreferredSize(new java.awt.Dimension(216, 34));

        lblSiguientesEstados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSiguientesEstados.setForeground(new java.awt.Color(0, 102, 102));
        lblSiguientesEstados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSiguientesEstados.setText("Posibles Siguientes Estados");

        javax.swing.GroupLayout pnlSiguientesEstadosLayout = new javax.swing.GroupLayout(pnlSiguientesEstados);
        pnlSiguientesEstados.setLayout(pnlSiguientesEstadosLayout);
        pnlSiguientesEstadosLayout.setHorizontalGroup(
            pnlSiguientesEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSiguientesEstadosLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(pnlSiguientesEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSiguientesEstadosLayout.createSequentialGroup()
                        .addComponent(lblSiguienteEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSiguientesEstadosLayout.createSequentialGroup()
                        .addGroup(pnlSiguientesEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSiguienteEstado1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(lblSiguientesEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        pnlSiguientesEstadosLayout.setVerticalGroup(
            pnlSiguientesEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSiguientesEstadosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblSiguientesEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblSiguienteEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblSiguienteEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnlEstadoCadena.setBackground(new java.awt.Color(204, 204, 204));
        pnlEstadoCadena.setForeground(new java.awt.Color(153, 153, 153));

        lblCadenaCondicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCadenaCondicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadenaCondicion.setText(".................................................");

        javax.swing.GroupLayout pnlEstadoCadenaLayout = new javax.swing.GroupLayout(pnlEstadoCadena);
        pnlEstadoCadena.setLayout(pnlEstadoCadenaLayout);
        pnlEstadoCadenaLayout.setHorizontalGroup(
            pnlEstadoCadenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstadoCadenaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCadenaCondicion)
                .addGap(54, 54, 54))
        );
        pnlEstadoCadenaLayout.setVerticalGroup(
            pnlEstadoCadenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEstadoCadenaLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(lblCadenaCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        btnSiguienteEstado.setBackground(new java.awt.Color(204, 204, 204));
        btnSiguienteEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSiguienteEstado.setForeground(new java.awt.Color(0, 102, 102));
        btnSiguienteEstado.setText("Siguiente Estado");
        btnSiguienteEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEstadoActionPerformed(evt);
            }
        });

        btnNuevoIngreso.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevoIngreso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNuevoIngreso.setForeground(new java.awt.Color(0, 102, 102));
        btnNuevoIngreso.setText("Nuevo Ingreso");
        btnNuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoIngresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSiguienteEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnSiguienteEstado)
                .addGap(18, 18, 18)
                .addComponent(btnNuevoIngreso)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Máquina de Turing - Estado Actual");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(pnlCintaPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(pnlEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSiguientesEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEstadoCadena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(pnlCintaPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlSiguientesEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlEstadoCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEstadoActionPerformed

                    actualizarDatos();
            
    }//GEN-LAST:event_btnSiguienteEstadoActionPerformed

    private void btnNuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoIngresoActionPerformed
        //ingresoView.setVisible(true);
        //ingresoView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNuevoIngresoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoIngreso;
    private javax.swing.JButton btnSiguienteEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCadenaCondicion;
    private javax.swing.JLabel lblCinta;
    private javax.swing.JLabel lblCintaPosicion;
    private javax.swing.JLabel lblEstadoActual;
    private javax.swing.JLabel lblMostrarEstadoActual;
    private javax.swing.JLabel lblPosicionActual1;
    private javax.swing.JLabel lblSiguienteEstado1;
    private javax.swing.JLabel lblSiguienteEstado2;
    private javax.swing.JLabel lblSiguientesEstados;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlCintaPosicion;
    private javax.swing.JPanel pnlEstadoActual;
    private javax.swing.JPanel pnlEstadoCadena;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlSiguientesEstados;
    // End of variables declaration//GEN-END:variables
}
