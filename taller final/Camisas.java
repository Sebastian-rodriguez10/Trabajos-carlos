public class Camisas extends producto{
    private boolean conEstampado;

    public Camisas (int id, String nombre, double precio, int cantidadStock, boolean conEstampado){
        super(id, nombre, precio, cantidadStock);
        this.conEstampado = conEstampado;
    }

    @Override
    public void verTodo() {
        System.out.println("id: " + getId() + "   nombre: " + getNombre() + "   precio: " + getPrecio() + "   cantidad de stock: " + getCantidadStock() + "   Tiene rotos: " + isConEstampado());
    }

    @Override
    public double descuentoEspecial() {
        double valorFinal = 0;
        if (conEstampado) {
            System.out.println("Obtuvo descuento de 5% por haber comprado camisas con estampado");
            valorFinal = getPrecio() - (getPrecio() * 0.03);
            setPrecio(valorFinal);
        }else{
            System.out.println("no hay descuento, el descuento solo aplica para las camisas con estanpado");
        }
        return valorFinal;
    }

    public boolean isConEstampado() {
        return conEstampado;
    }
    public void setConEstampado(boolean conEstampado) {
        this.conEstampado = conEstampado;
    }
}
