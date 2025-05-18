package comdiegocano.memorama;


public class TarjetaEmoji extends Tarjeta {
   
    public TarjetaEmoji(String id) {
        super(id);
    }
    
    @Override
    public String getTipo() {
        return "Emoji";
    }
}
