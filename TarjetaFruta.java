package comdiegocano.memorama;


public class TarjetaFruta extends Tarjeta {
    
      public TarjetaFruta(String id) {
        super(id, 3, "Robar punto");
    }
    
    @Override
    public String getTipo() {
        return "Fruta";
    }
  
}
