
package practica7;


public class Jugador {
   
    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public void sumarPuntos(int puntos) {
       puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public String getNombre() {
        return nombre;
    }

}
