package modelo;

import controlador.Coordinador;
import modelo.dao.ClienteDAO;

public class LogicaCompras {
	private Coordinador coordinador;
	private ClienteDAO clienteDAO;

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public boolean existeCliente(String id) {
		return clienteDAO.buscarCliente(id) != null;
	}

}
