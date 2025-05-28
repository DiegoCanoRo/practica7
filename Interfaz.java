package comdiegocano.memorama;
//package practica7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Interfaz extends javax.swing.JDialog {

    private Memorama juego;
    private boolean esperando = false;

    public Interfaz(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        getContentPane().setBackground(new Color(105, 150, 150));
        initComponents();
        setTitle("Memorama");
        racha.setText("");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        titulo.setFont(new Font("Serif", Font.BOLD, 19));
        racha.setFont(new Font("Serif", Font.BOLD, 14));
        turno.setFont(new Font("Serif", Font.BOLD, 14));
        puntajeLabel.setFont(new Font("Serif", Font.BOLD, 14));
        getContentPane().setLayout(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciarJuego = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        puntajeLabel = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        puntaje = new javax.swing.JTextArea();
        titulo = new javax.swing.JLabel();
        racha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        iniciarJuego.setText("Iniciar juego");
        iniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarJuegoActionPerformed(evt);
            }
        });

        puntajeLabel.setText("Puntaje");

        turno.setText("Turno actual");

        puntaje.setColumns(20);
        puntaje.setRows(5);
        jScrollPane1.setViewportView(puntaje);

        titulo.setText("Memorama");

        racha.setText("jLabel17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(iniciarJuego)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel2))))
                        .addGap(154, 154, 154)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addGap(242, 242, 242)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(puntajeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(racha, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(racha)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(turno)
                        .addGap(41, 41, 41)
                        .addComponent(puntajeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(50, 50, 50)
                .addComponent(iniciarJuego)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarJuegoActionPerformed
        int jugadores = 0;
        boolean valido;

        // Pedir número de jugadores entre 2 y 4
        do {
            valido = true;
            String entrada = JOptionPane.showInputDialog(this, "¿Cuántos jugadores? (2-4)");

            if (entrada == null) {
                return; // Cancelar
            }
            try {
                jugadores = Integer.parseInt(entrada);
                if (jugadores < 2 || jugadores > 4) {
                    JOptionPane.showMessageDialog(this, "Debe ser un número entre 2 y 4.");
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
                valido = false;
            }
        } while (!valido);

        // Crear el objeto del juego
        juego = new Memorama();
        juego.setInterfaz(this);
        // Pedir tipo de tarjetas
        String[] opciones = {"Animales", "Frutas", "Emojis"};
        String tipo = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el tipo de tarjetas:",
                "Tipo de juego",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (tipo == null) {
            return; // Cancelar
        }
        juego.seleccionarTipoTarjeta(tipo);

        juego.iniciarJuego(jugadores);

        actualizarImagenesTablero();
    }//GEN-LAST:event_iniciarJuegoActionPerformed

    private void actualizarImagenesTablero() {
        // Tamaño de cada imagen
        int imagenAncho = 105;
        int imagenAlto = 135;

        // Espacio entre las imágenes
        int espacioX = 30; // Separación horizontal
        int espacioY = 15; // Separación vertical

        // Posiciones para las 4 filas y 4 columnas
        int inicioX = 50;  // Ajusta para centrar las tarjetas horizontalmente
        int inicioY = 50;  // Ajusta para centrar las tarjetas verticalmente

        JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5,
            jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12,
            jLabel13, jLabel14, jLabel15, jLabel16};

        List<Tarjeta> tarjetas = juego.obtenerTablero();
        String tipo = juego.getTipo().toLowerCase(); // emojis, animales, etc.

        // Primero posicionamos todos los JLabel
        for (int i = 0; i < tarjetas.size(); i++) {
            JLabel label = labels[i];

            int fila = i / 4;
            int columna = i % 4;
            int posX = inicioX + columna * (imagenAncho + espacioX);
            int posY = inicioY + fila * (imagenAlto + espacioY);
            label.setBounds(posX, posY, imagenAncho, imagenAlto);

            label.putClientProperty("indice", i);

            if (label.getMouseListeners().length == 0) {
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel clickeado = (JLabel) e.getSource();
                        int indice = (int) clickeado.getClientProperty("indice");
                        manejarClicEnTarjeta(indice);
                        actualizarInterfaz();
                    }
                });
            }
        }

        // Ahora asignamos las imágenes
        for (int i = 0; i < tarjetas.size(); i++) {
            Tarjeta tarjeta = tarjetas.get(i);
            JLabel label = labels[i];

            String archivoImagen = tarjeta.estaDescubierta() ? tarjeta.getId() + ".png" : "volteada.png";
            String ruta = "C:/Users/diego/Documents/NetBeansProjects/Memorama/src/main/java/comdiegocano/memorama/Memorama/" + tipo + "/" + archivoImagen;

            ImageIcon iconoOriginal = new ImageIcon(ruta);

            if (iconoOriginal.getIconWidth() != -1) {
                Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(imagenAncho, imagenAlto, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenRedimensionada));
            } else {
                System.out.println("No se encontró la imagen: " + ruta);

            }
        }

    }

    private void manejarClicEnTarjeta(int indice) {
        if (esperando) {
            return;
        }

        boolean seleccionValida = juego.seleccionarTarjeta(indice);
        if (!seleccionValida) {
            return;
        }

        actualizarImagenesTablero();
        //si el jugador selecciona dos tarjetas entra en la condicion para
        //asegurarse si es par, se crea el timer que espera 1 segundo antes
        //de verificar si ambas tarjetas coinciden
        if (juego.getPrimeraSeleccionada() != null && juego.getSegundaSeleccionada() != null) {
            esperando = true;

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean acerto = juego.evaluarSeleccion();
                    //se actualiza el tablero para mostrar resultados
                    actualizarImagenesTablero();
                    actualizarInterfaz();
                    esperando = false;
                    //si el juego ha terminado le muestra un mensaje al jugador ganador

                    if (juego.juegoTerminado()) {
                        String ganador = juego.obtenerGanador();
                        actualizarInterfaz();
                        JOptionPane.showMessageDialog(null, "¡Fin del juego! Ganó " + ganador);
                        //si no acerto solo se actualiza la interfaz

                    } else if (!acerto) {
                        actualizarInterfaz();
                    }
                }
            });
            //el timer se ejecuta una sola vez, seguido se actualiza la interfaz
            //y lo inicia
            timer.setRepeats(false);
            actualizarInterfaz();
            timer.start();
        }
    }

    //como lo dice el método es para actualizar la interfaz con ello se
    //actualiza el turno del jugador actual y los puntajes
    public void actualizarInterfaz() {
        turno.setText("Turno actual: " + juego.obtenerJugadorActualTexto());
        puntaje.setText("" + juego.obtenerPuntajesTexto());
        racha.setText("" + juego.toStringRacha());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interfaz dialog = new Interfaz(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea puntaje;
    private javax.swing.JLabel puntajeLabel;
    private javax.swing.JLabel racha;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel turno;
    // End of variables declaration//GEN-END:variables
}
