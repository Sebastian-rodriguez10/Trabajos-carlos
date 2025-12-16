public class Pantalones extends producto{
    private boolean conRotos;

    public Pantalones (int id, String nombre, double precio, int cantidadStock, boolean conRotos){
        super(id, nombre, precio, cantidadStock);
        this.conRotos = conRotos;
    }

    @Override
    public void verTodo() {
        System.out.println("id: " + getId() + "   nombre: " + getNombre() + "   precio: " + getPrecio() + "   cantidad de stock: " + getCantidadStock() + "   Tiene rotos: " + isConRotos());
    }

    @Override
    public double descuentoEspecial() {
        double valorFinal = 0;
        if (conRotos) {
            System.out.println("obtuvo el 10% de descuento");
            valorFinal = getPrecio() - (getPrecio() * 0.10);
            setPrecio(valorFinal);
        }else{
            System.out.println("obtuvo el 5% de descuento");
            valorFinal = getPrecio() - (getPrecio() * 0.05);
            setPrecio(valorFinal);
        }
        return valorFinal;
    }

    public boolean isConRotos() {
        return conRotos;
    }
    public void setConRotos(boolean conRotos) {
        this.conRotos = conRotos;
    }
}
