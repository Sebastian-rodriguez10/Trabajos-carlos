public class estorPedidos {
    private clasePadre[] pedido;
    private int contadorInicio;
    private int contadorFInal;

    public estorPedidos (int contadorFInal){
        this.pedido = new clasePadre[contadorFInal];
        contadorInicio = 0;

    }

    public void agregarProducto(clasePadre item){
        pedido[contadorInicio] = item;
        contadorInicio++;
    }

    public clasePadre[] getPedido() {
        return pedido;
    }


}
