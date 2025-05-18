package comdiegocano.memorama;

public class TarjetaAnimal extends Tarjeta {
    
    public TarjetaAnimal(String id) {
        super(id);
    }
    
    @Override
    public String getTipo() {
        return "Animal";
    }

}
