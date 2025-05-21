package comdiegocano.memorama;

public class TarjetaEmoji extends Tarjeta {


    public TarjetaEmoji(String id, int cuantoVale) {
        super(id, cuantoVale);
    }

    @Override
    public String getTipo() {
        return "Emoji";
    }

    @Override
    public void comportamientoRacha(){
        comportamiento = "Restar";
    }
}
