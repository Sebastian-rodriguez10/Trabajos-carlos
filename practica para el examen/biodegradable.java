public class biodegradable extends clasePadre{
    
    private int tiempoDescompocicionMeses;
    
    public biodegradable (String codigo, String nombre, double precio, int tiempoDescompocicionMeses){
        super(codigo, nombre, precio);
        this.tiempoDescompocicionMeses = tiempoDescompocicionMeses;

    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "tiempo de descompocicion en meses: " + tiempoDescompocicionMeses;

    }

    public int getTiempoDescompocicionMeses() {
        return tiempoDescompocicionMeses;
    }
    public void setTiempoDescompocicionMeses(int tiempoDescompocicionMeses) {
        this.tiempoDescompocicionMeses = tiempoDescompocicionMeses;
    }



}
