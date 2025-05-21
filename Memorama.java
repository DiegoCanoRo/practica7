package comdiegocano.memorama;

import java.util.*;

public class Memorama {

    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Jugador> jugadores;
    private int turnoActual;
    private Tarjeta primeraSeleccionada;
    private Tarjeta segundaSeleccionada;
    private String tipoDeTarjeta;

    public void seleccionarTipoTarjeta(String tipo) {
        this.tipoDeTarjeta = tipo;
    }

    public String getTipo() {
        return tipoDeTarjeta;
    }

    public void iniciarJuego(int numeroJugadores) {
        jugadores = new ArrayList<>();
        for (int i = 1; i <= numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador " + i));
        }
        tarjetas = generarTarjetas();
        barajarTarjetas();
        turnoActual = 0;
    }

    public ArrayList<Tarjeta> generarTarjetas() {
        ArrayList<Tarjeta> lista = new ArrayList<>();
        String[] ids;

        switch (tipoDeTarjeta) {
            case "Emojis":
                ids = new String[]{"porfavor", "nono", "riendose", "llamame", "asustado", "bate", "yo", "patas"};
                break;
            case "Animales":
                ids = new String[]{"rino", "kiri", "mapache", "perro", "chango", "pollo", "panda", "efelante"};
                break;
            case "Frutas":
                ids = new String[]{"aguacate", "fresa", "mango", "manzana", "naranja", "platano", "sandia", "uva"};
                break;
            default:
                throw new IllegalArgumentException("Tipo de tarjeta inválido");
        }

        for (int i = 0; i < ids.length; i++) {
            Tarjeta t1 = crearTarjeta(ids[i]);
            Tarjeta t2 = crearTarjeta(ids[i]);
            lista.add(t1);
            lista.add(t2);
        }
        return lista;
    }

    public Tarjeta crearTarjeta(String id) {
        switch (tipoDeTarjeta) {
            case "Emojis":
                return new TarjetaEmoji(id, 1);
            case "Animales":
                return new TarjetaAnimal(id, 2);
            case "Frutas": 
                return new TarjetaFruta(id, 3);
            default:
                throw new IllegalArgumentException("Tipo de tarjeta inválido");
        }
    }

    public void barajarTarjetas() {
        Collections.shuffle(tarjetas);
    }

    public boolean seleccionarTarjeta(int posicion) {
        if (posicion < 0 || posicion >= tarjetas.size()) {
            return false;
        }
        Tarjeta seleccionada = tarjetas.get(posicion);
        if (seleccionada.estaDescubierta() || segundaSeleccionada != null) {
            return false;
        }

        seleccionada.voltearTarjeta();

        if (primeraSeleccionada == null) {
            primeraSeleccionada = seleccionada;
        } else {
            segundaSeleccionada = seleccionada;
        }
        return true;
    }

    public boolean puedeSeleccionar() {
        return segundaSeleccionada == null;
    }

    public boolean evaluarSeleccion() {
        if (primeraSeleccionada != null && segundaSeleccionada != null) {
            boolean acerto = primeraSeleccionada.getId().equals(segundaSeleccionada.getId());

            if (!acerto) {
                primeraSeleccionada.voltearTarjeta();
                segundaSeleccionada.voltearTarjeta();
                siguienteTurno(); // si falla, cambia turno
            } else {
                asignarPuntoAJugadorActual(); // si acierta, gana punto y mantiene turno
            }

            primeraSeleccionada = null;
            segundaSeleccionada = null;

            return acerto;
        }
        return false;
    }

    public boolean verificarEmparejamiento(Tarjeta t1, Tarjeta t2) {
        if (t1.esIgual(t2)) {
            return true;
        } else {
            t1.voltearTarjeta();
            t2.voltearTarjeta();
            return false;
        }
    }

    //le suma un punto al jugador con turno
    public void asignarPuntoAJugadorActual() {
        jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale());
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    //si todas las tarjetas fueron volteadas el juego termina
    public boolean juegoTerminado() {
        for (Tarjeta t : tarjetas) {
            if (!t.estaDescubierta()) {
                return false;
            }
        }
        return true;
    }

   public String obtenerGanador() {
    int maxPuntaje = Integer.MIN_VALUE;
    List<Jugador> empatados = new ArrayList<>();

    for (Jugador j : jugadores) {
        if (j.getPuntaje() > maxPuntaje) {
            maxPuntaje = j.getPuntaje();
            empatados.clear();
            empatados.add(j);
        } else if (j.getPuntaje() == maxPuntaje) {
            empatados.add(j);
        }
    }

    if (empatados.size() == 1) {
        return empatados.get(0).getNombre() + " con " + maxPuntaje + " puntos";
    } else {
        StringBuilder resultado = new StringBuilder("Empate entre: ");
        for (int i = 0; i < empatados.size(); i++) {
            resultado.append(empatados.get(i).getNombre());
            if (i < empatados.size() - 2) {
                resultado.append(", ");
            } else if (i == empatados.size() - 2) {
                resultado.append(" y ");
            }
        }
        resultado.append(" con ").append(maxPuntaje).append(" puntos");
        return resultado.toString();
    }
}

    public ArrayList<Tarjeta> obtenerTablero() {
        return tarjetas;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    //
//    public int[] obtenerPuntajes() {
//        int[] puntos = new int[jugadores.size()];
//        for (int i = 0; i < jugadores.size(); i++) {
//            puntos[i] = jugadores.get(i).getPuntaje();
//        }
//        return puntos;
//    }
    
    
    public Tarjeta getPrimeraSeleccionada() {
        return primeraSeleccionada;
    }

    public Tarjeta getSegundaSeleccionada() {
        return segundaSeleccionada;
    }

    public String obtenerJugadorActualTexto() {
        return jugadores.get(turnoActual).getNombre();
    }

    public String obtenerPuntajesTexto() {
        StringBuilder sb = new StringBuilder();
        for (Jugador j : jugadores) {
            sb.append(j.getNombre())
                    .append(" : ")
                    .append(j.getPuntaje())
                    .append(" puntos\n");
        }
        return sb.toString();
    }

}
