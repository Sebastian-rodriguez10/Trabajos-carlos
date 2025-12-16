public abstract class  producto {
    //atributos
    private int id;
    private String nombre;
    private double precio;
    private int cantidadStock;

    //constructor
    producto(int id, String nombre, double precio, int cantidadStock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }
    //metodo
    public void verTodo(){
        System.out.println("id: " + id + "   nombre: " + nombre + "   precio: " + precio + "   cantidad de stock: " + cantidadStock);
    }

    public int getId() {
        return id;
    }
    public int getCantidadStock() {
        return cantidadStock;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //metodo abstracto
    public abstract double descuentoEspecial();



}