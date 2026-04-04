package modelo.dto;

public class ProductoDTO {
	
	private int idProducto;
	private String nombreProducto;
	private double valorUnitario;
	
	public ProductoDTO(int idProducto, String nombreProducto, double valorUnitario) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.valorUnitario = valorUnitario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		return "ProductoDTO [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", valorUnitario="
				+ valorUnitario + "]";
	}
	
	
	
}
