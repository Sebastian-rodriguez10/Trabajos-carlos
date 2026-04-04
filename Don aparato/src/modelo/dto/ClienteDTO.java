package modelo.dto;

public class ClienteDTO {
	private String idCliente;
	private String nombreCliente;
	private String apellido;
	private String telefono;
	private String tipo;
	
	public ClienteDTO() {
		
	}
	public ClienteDTO(String idCliente, String nombreCliente, String apellido, String telefono, String tipo) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
