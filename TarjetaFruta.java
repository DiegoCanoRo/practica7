package comdiegocano.memorama;


public class TarjetaFruta extends Tarjeta {
    
      public TarjetaFruta(String id, int cuantoVale) {
        super(id, cuantoVale);
    }
    
    @Override
    public String getTipo() {
        return "Fruta";
    }
    
    @Override
    public void comportamientoRacha(){
        comportamiento = "Robar punto";
    }
}
