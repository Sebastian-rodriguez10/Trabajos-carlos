import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gestioProductos lista = new gestioProductos();
        

        boolean continuar = true;
        int contador = 0;

        while (continuar) {

            contador++;
            System.out.println("Con un numero escoja que producto quiere agregar:");
            System.out.println(
                    "1. Camisas   2. Pantalones   3. Zapatos   4. Eliminar un producto con id   5. Buscar con id    6. Modificar producto");
            int respuestaProducto = scanner.nextInt();
            switch (respuestaProducto) {
                case 1:
                    boolean boleanoCamisa;
                    System.out.println("el id del producto es: " + contador);
                    System.out.println("ingrese el nombre de la camisa: ");
                    scanner.nextLine();
                    String nombreCamisa = scanner.nextLine();
                    System.out.println("Escriba el precio de la camisa: ");
                    double camisaPrecio = scanner.nextDouble();
                    System.out.println("coloque la cantidad de stock: ");
                    int stockCamisa = scanner.nextInt();
                    System.out.println("1. camisas con estampado   2. camisas sin estampado");
                    int camisaEstampado = scanner.nextInt();
                    if (camisaEstampado < 2) {
                        boleanoCamisa = true;
                    } else {
                        boleanoCamisa = false;
                    }
                    producto camisa = new Camisas(contador, nombreCamisa, camisaPrecio, stockCamisa, boleanoCamisa);
                    lista.agregarProducto(camisa);

                    System.out.println("Quiere ingresar otro producto 1. SI   2. NO");
                    int respuesta1 = scanner.nextInt();
                    if (respuesta1 < 2) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;

                case 2:
                    boolean boleanoPantalon;
                    System.out.println("el id del producto es: " + contador);
                    System.out.println("ingrese el nombre del pantalon: ");
                    scanner.nextLine();
                    String nombrePantalon = scanner.nextLine();
                    System.out.println("Escriba el precio del pantalon: ");
                    double pantalonPrecio = scanner.nextDouble();
                    System.out.println("coloque la cantidad de stock: ");
                    int stockPantalon = scanner.nextInt();
                    System.out.println("1. Pantalon con rotos   2. Pantalon sin rotos");
                    int pantalonRotos = scanner.nextInt();
                    if (pantalonRotos == 1) {
                        boleanoPantalon = true;
                    } else {
                        boleanoPantalon = false;
                    }
                    producto pantalon = new Pantalones(contador, nombrePantalon, pantalonPrecio, stockPantalon,
                            boleanoPantalon);
                    lista.agregarProducto(pantalon);

                    System.out.println("Quiere ingresar otro producto 1. SI   2. NO");
                    int respuesta12 = scanner.nextInt();
                    if (respuesta12 < 2) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;

                case 3:
                    System.out.println("el id del producto es: " + contador);
                    System.out.println("ingrese el nombre del zapato: ");
                    scanner.nextLine();
                    String nombreZapato = scanner.nextLine();
                    System.out.println("Escriba el precio del zapato: ");
                    double zapatoPrecio = scanner.nextDouble();
                    System.out.println("coloque la cantidad de stock: ");
                    int stockZapato = scanner.nextInt();
                    System.out.println("Escriba la talla del zapato: ");
                    int tallaZapato = scanner.nextInt();
                    producto zapato = new Zapatos(contador, nombreZapato, zapatoPrecio, stockZapato, tallaZapato);
                    lista.agregarProducto(zapato);

                    System.out.println("Quiere ingresar otro producto 1. SI   2. NO");
                    int respuesta13 = scanner.nextInt();
                    if (respuesta13 < 2) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;

                case 4:
                    System.out.println("escriba el numero id del producto que quiere eliminar: ");
                    int respuesta2 = scanner.nextInt();
                    lista.eliminarPedido(respuesta2);
                    System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                    int respuesta3 = scanner.nextInt();
                    if (respuesta3 < 2) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;

                case 5:
                    System.out.println("Escriba el id del producto que quiere ver: ");
                    int respuesta4 = scanner.nextInt();
                    lista.verpedido(respuesta4);
                    System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                    int respuesta5 = scanner.nextInt();
                    if (respuesta5 < 2) {
                        continuar = true;
                    } else {
                        continuar = false;
                    }
                    break;

                case 6:
                    System.out.println("Escriba el id del producto que quiere hacerle un cambio: ");
                    int respuesta6 = scanner.nextInt();
                    System.out.println("Escriba un numero segun lo que quiera cambiar: ");
                    System.out.println("1. nombre   2. precio   3. cantidad en stock   4. modificar todos");
                    int respuesta7 = scanner.nextInt();

                    switch (respuesta7) {
                        case 1:
                            System.out.println("Escriba el nuevo nombre del producto: ");
                            scanner.nextLine();
                            String nuevoNombre = scanner.nextLine();
                            lista.ModificarNombre(respuesta7, nuevoNombre);
                            System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                            int respuesta8 = scanner.nextInt();
                            if (respuesta8 < 2) {
                                continuar = true;
                            } else {
                                continuar = false;
                            }
                            break;

                        case 2:
                            System.out.println("Escriba el nuevo precio del producto: ");
                            scanner.nextLine();
                            double nuevoPrecio = scanner.nextDouble();
                            lista.ModificarPrecio(respuesta7, nuevoPrecio);
                            System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                            int respuesta9 = scanner.nextInt();
                            if (respuesta9 < 2) {
                                continuar = true;
                            } else {
                                continuar = false;
                            }
                            break;

                        case 3:
                            System.out.println("Escriba la nueva cantidad en stock: ");
                            scanner.nextLine();
                            int nuevoStock = scanner.nextInt();
                            lista.ModificarStock(respuesta7, nuevoStock);
                            System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                            int respuesta10 = scanner.nextInt();
                            if (respuesta10 < 2) {
                                continuar = true;
                            } else {
                                continuar = false;
                            }
                            break;

                        case 4:
                            System.out.println("ingrese el nuevo nombre del producto: ");
                            scanner.nextLine();
                            String nuevoNombre1 = scanner.nextLine();
                            System.out.println("Escriba el nuevo precio del producto: ");
                            double nuevoPrecio1 = scanner.nextDouble();
                            System.out.println("Escriba la nueva cantidad en stock: ");
                            int nuevoStock1 = scanner.nextInt();

                            lista.ModificarTodos(respuesta7, nuevoNombre1, nuevoPrecio1, nuevoStock1);

                            System.out.println("Quiere seguir agregando productos   1. SI   2. NO");
                            int respuesta11 = scanner.nextInt();
                            if (respuesta11 < 2) {
                                continuar = true;
                            } else {
                                continuar = false;
                            }

                            break;

                        default:
                            break;
                    }

                    break;
                default:
                    break;
            }
        }

        System.out.println("===== resumen del pedido ====");
        for (producto p : lista.getLista()) {
            p.verTodo();
            p.descuentoEspecial();
        }
    }
}
