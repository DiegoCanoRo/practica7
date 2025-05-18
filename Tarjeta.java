package comdiegocano.memorama;

public abstract class Tarjeta {
    
    protected String id;
    protected boolean descubierta;
    
    public Tarjeta(String id){
        this.id = id;
        descubierta = false;
    }
    
    
    public abstract String getTipo();
    
    public String getId(){
        return id;
    }
    
    public boolean estaDescubierta(){
        return descubierta;
    }
    
    public void voltearTarjeta(){
        descubierta = !descubierta;
    }
    
    public boolean esIgual(Tarjeta otra) {
    return this.id.equals(otra.id);
    }

}
