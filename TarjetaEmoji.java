package comdiegocano.memorama;

public class TarjetaEmoji extends Tarjeta {


    public TarjetaEmoji(String id) {
        super(id, 2, "Restar");
    }

    @Override
    public String getTipo() {
        return "Emoji";
    }

  
}
