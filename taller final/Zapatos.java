public class Zapatos extends producto{
    private int talla;
    
    public Zapatos (int id, String nombre, double precio, int cantidadStock, int talla){
        super(id, nombre, precio, cantidadStock);
        this.talla = talla;
    }

    @Override
    public void verTodo() {
        System.out.println("id: " + getId() + "   nombre: " + getNombre() + "   precio: " + getPrecio() + "   cantidad de stock: " + getCantidadStock() + "   talla: " + talla);
    }
    

    @Override
    public double descuentoEspecial() {
        double valorFinal = 0;
        if (getCantidadStock() >= 350) {
            System.out.println("obtuviste un descuenjto del 2%");
            valorFinal = getPrecio() - (getPrecio() * 0.02);
            setPrecio(valorFinal);
        }else if (getCantidadStock() >= 700) {
            System.out.println("Obtuviste un 3% de descuento");
            valorFinal = getPrecio() - (getPrecio() * 0.03);
            setPrecio(valorFinal);
        }else if (getCantidadStock() >= 1200) {
            System.out.println("Obtuviste un 6% de descuento");
            valorFinal = getPrecio() - (getPrecio() * 0.06);
            setPrecio(valorFinal);
        }else{
            System.out.println("no obtuviste el descuento");
        }
        return valorFinal;
    }
}
