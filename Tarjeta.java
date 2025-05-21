package comdiegocano.memorama;

public abstract class Tarjeta {
    
    protected String id;
    protected boolean descubierta;
    protected int cuantoVale;
    protected String comportamiento;
    
    public Tarjeta(String id, int cuantoVale){
        this.id = id;
        descubierta = false;
        this.cuantoVale = cuantoVale;
    }
    
    public abstract void comportamientoRacha();
    public abstract String getTipo();
    
    public String getId(){
        return id;
    }
    
    public boolean estaDescubierta(){
        return descubierta;
    }
    
    public int getCuantoVale(){
        return cuantoVale;
    }
    
    public void voltearTarjeta(){
        descubierta = !descubierta;
    }
    
    public String getComportamiento(){
        return comportamiento;
    }
    public boolean esIgual(Tarjeta otra) {
    return this.id.equals(otra.id);
    }

}
