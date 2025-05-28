package comdiegocano.memorama;
//package practica7;
public class TarjetaAnimal extends Tarjeta {
    
    //animales vale 
    public TarjetaAnimal(String id) {
        super(id, 1, "Punto extra");
        
    }
    
    @Override
    public String getTipo() {
        return "Animal";
    }
    
    
}
