public class clasePadre {

    //atributos

    private String codigo;
    private String nombre;
    private double precio;

    //constructor
    
    public clasePadre(String codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    //metodos

    public String mostrarDatos(){
        String datos = "codigo: " + codigo + "  nombre: " + nombre + "  precio: " + precio;
        return datos;
    }

    //get y set

    public String getCodigo() {
        return codigo;
    }public String getNombre() {
        return nombre;
    }public double getPrecio() {
        return precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }public void setPrecio(double precio) {
        this.precio = precio;
    }

}
