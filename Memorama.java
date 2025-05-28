package comdiegocano.memorama;
//package practica7;

import java.util.*;

public class Memorama {

    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Jugador> jugadores;
    private int turnoActual;
    private Tarjeta primeraSeleccionada;
    private Tarjeta segundaSeleccionada;
    private String tipoDeTarjeta;
    private int racha;
    private Interfaz interfaz;

    public void seleccionarTipoTarjeta(String tipo) {
        this.tipoDeTarjeta = tipo;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    public String getTipo() {
        return tipoDeTarjeta;
    }

    //se crean los jugadores, genera las tarjetas y se reinicia el turno actual
    public void iniciarJuego(int numeroJugadores) {
        jugadores = new ArrayList<>();
        for (int i = 1; i <= numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador " + i));
        }
        tarjetas = generarTarjetas();
        barajarTarjetas();
        turnoActual = 0;
    }

    //guardará el tipo de tarjeta que se usara (fruta, emoji o animal)
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
                return new TarjetaEmoji(id);
            case "Animales":
                return new TarjetaAnimal(id);
            case "Frutas":
                return new TarjetaFruta(id);
            default:
                throw new IllegalArgumentException("Tipo de tarjeta inválido");
        }
    }

    //mezcla las tarjetas
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

    //compara si son iguales las tarjetas seleccionadas
    //si son iguales se asignan puntos y el turno no cambia y si son
    //distintas se voltean y pasa el turno
    //tambien maneja el comportamiento de racha, 
    public boolean evaluarSeleccion() {
        if (primeraSeleccionada != null && segundaSeleccionada != null) {
            boolean acerto = primeraSeleccionada.getId().equals(segundaSeleccionada.getId());

            if (!acerto) {
                racha = 0;
                primeraSeleccionada.voltearTarjeta();
                segundaSeleccionada.voltearTarjeta();
                siguienteTurno(); // si falla, cambia turno
                interfaz.actualizarInterfaz();

            } else {
                manejarPorComportamiento();
                racha++;
                interfaz.actualizarInterfaz();

            }

            primeraSeleccionada = null;
            segundaSeleccionada = null;
            interfaz.actualizarInterfaz();

            return acerto;
        }
        interfaz.actualizarInterfaz();

        return false;
    }

    public boolean verificarEmparejamiento(Tarjeta t1, Tarjeta t2) {
        if (t1.esIgual(t2)) {
            interfaz.actualizarInterfaz();

            return true;
        } else {
            t1.voltearTarjeta();
            t2.voltearTarjeta();
            return false;
        }
    }

    //maneja el comportamiento cuando un jugador tiene racha
    public void manejarPorComportamiento() {
        if (racha >= 1) {
            String comportamiento = primeraSeleccionada.getComportamiento();
            //cuando esta en racha obtiene un punto extra
            switch (comportamiento) {
                case "Punto extra":
                    jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale());
                    jugadores.get(turnoActual).sumarPuntos(1);
                    interfaz.actualizarInterfaz();

                    break;
                //cuando esta en racha le resta a los demas jugadores
                case "Restar":
                    jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale());

                    for (Jugador jugador : jugadores) {
                        if (jugador.equals(jugadores.get(turnoActual))) {
                            jugador.sumarPuntos(0);
                        } else {
                            jugador.sumarPuntos(-1);
                        }
                    }
                    interfaz.actualizarInterfaz();

                    break;
                //cuando esta en racha le roba puntos al jugador con mas puntos
                //si el jugador en racha es el que tiene mas puntos no se le resta
                case "Robar punto":
                    int masPuntos = 0;
                    for (Jugador jugador : jugadores) {
                        if (jugador.getPuntaje() > masPuntos) {
                            masPuntos = jugador.getPuntaje();
                        }
                    }

                    boolean pudoRobar = false;

                    for (Jugador jugador : jugadores) {
                        if (jugador.getPuntaje() == masPuntos && !jugador.equals(jugadores.get(turnoActual))) {
                            jugador.sumarPuntos(-1);
                            pudoRobar = true;
                            break; // solo le roba a uno
                        }
                    }

                    if (pudoRobar) {
                        jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale() + 1);
                    } else {
                        jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale());
                    }

                    interfaz.actualizarInterfaz();
                    break;

            }
        } else {
            jugadores.get(turnoActual).sumarPuntos(primeraSeleccionada.getCuantoVale());
            interfaz.actualizarInterfaz();
        }

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

    //se determina el ganador basado en quien tiene mas puntos
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

    public String toStringRacha() {
        if (racha >= 1) {
            switch (tipoDeTarjeta) {
                case "Animales":
                    return "¡Estás en racha! Obtendrás un punto adicional por cada acierto.";
                case "Frutas":
                    return "¡Estás en racha! Robarás un punto al jugador con más puntos.";
                case "Emojis":
                    return "¡Estás en racha! Harás que los demás jugadores pierdan un punto.";
                default:
                    return "¡Estás en racha!aaaaaaaaaaaaaaaaaaaaa";
            }
        } else {
            return "";
        }
    }

}
