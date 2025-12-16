import java.util.ArrayList;
import java.util.List;

public class gestioProductos {
    private ArrayList<producto> lista = new ArrayList<>();

    public ArrayList<producto> getLista() {
        return lista;
    }

    public gestioProductos(){
        this.lista = new ArrayList<>();
    }
    
    public void agregarProducto(producto item) {
        lista.add(item);
        System.out.println("se agrego el producto");
    }

    public void eliminarPedido(int id){
        lista.remove(id-1);
        System.out.println("su producto se elimino exitosamente");
    }

    public void verpedido(int id){
        lista.get(id-1).verTodo();
    }
    

    public void ModificarNombre(int id, String nombre){
       lista.get(id).setNombre(nombre);
       System.out.println("El nombre se ha modificado");
    }

    public void ModificarPrecio(int id, double precio){
       lista.get(id).setPrecio(precio);
       System.out.println("El precio se ha modificado");
    }

    public void ModificarStock(int id, int cantidad){
       lista.get(id).setCantidadStock(cantidad);
       System.out.println("Se ha modificado la cantidad de stock");
    }

    public void ModificarTodos(int id, String nombre, double precio, int cantidad){
       lista.get(id).setNombre(nombre);
       lista.get(id).setPrecio(precio);
       lista.get(id).setCantidadStock(cantidad);
       System.out.println("Se modifico el nombre, el precio y la cantidad en stock");
    }
}
