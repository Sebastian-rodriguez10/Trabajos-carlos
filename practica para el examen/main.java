public class main {
    public static void main(String[] args) {
        
        estorPedidos gestorPedidos = new estorPedidos(4);
        clasePadre b1 = new biodegradable("A1", "wii", 10000, 50);
        clasePadre b2 = new biodegradable("A2", "wix2", 20000, 20);
        clasePadre r1 = new reciclado("A3", "pandebono", 5000, 5);
        clasePadre r2 = new reciclado("A4", "empanada de cambray", 2000, 5);
        
        gestorPedidos.agregarProducto(b1);
        gestorPedidos.agregarProducto(b2);
        gestorPedidos.agregarProducto(r1);
        gestorPedidos.agregarProducto(r2);

        int total = 0;


        for(int i = 0; i < gestorPedidos.getPedido().length; i++){
            System.out.println(gestorPedidos.getPedido()[i].mostrarDatos());
            total += gestorPedidos.getPedido()[i].getPrecio();

        }

        System.out.println("Total: " + total);


    }
}
