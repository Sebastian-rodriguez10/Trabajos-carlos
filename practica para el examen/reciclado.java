public class reciclado extends clasePadre {
    private int porcentajeDeMateriaPrima;

    public reciclado (String codigo, String nombre, double precio, int porcentajeDeMateriaPrima){
        super(codigo, nombre, precio);
        this.porcentajeDeMateriaPrima = porcentajeDeMateriaPrima;
    }

    @Override
    public String mostrarDatos() {
        
        return super.mostrarDatos() + "porcentaje de materia prima: " + porcentajeDeMateriaPrima;
    }

    public int getPorcentajeDeMateriaPrima() {
        return porcentajeDeMateriaPrima;
    }
    public void setPorcentajeDeMateriaPrima(int porcentajeDeMateriaPrima) {
        this.porcentajeDeMateriaPrima = porcentajeDeMateriaPrima;
    }



    
}