package comdiegocano.memorama;

public class TarjetaAnimal extends Tarjeta {
    
    
    public TarjetaAnimal(String id, int cuantoVale) {
        super(id, cuantoVale);
    }
    
    @Override
    public String getTipo() {
        return "Animal";
    }
    
    @Override
    public void comportamientoRacha(){
        comportamiento = "Punto extra";
    }
}
