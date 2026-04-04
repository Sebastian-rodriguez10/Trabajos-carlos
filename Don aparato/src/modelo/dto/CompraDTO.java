package modelo.dto;

public class CompraDTO {
	private int idCompra;
	private int cantidadProductos;
	private String idCliente;
	private int idPedido;
	
	public CompraDTO(int idCompra, int cantidadProductos, String idCliente, int idPedido) {
		this.idCompra = idCompra;
		this.cantidadProductos = cantidadProductos;
		this.idCliente = idCliente;
		this.idPedido = idPedido;
	}
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public String toString() {
		return "CompraDTO [idCompra=" + idCompra + ", cantidadProductos=" + cantidadProductos + ", idCliente="
				+ idCliente + ", idPedido=" + idPedido + "]";
	}
	
	
}
