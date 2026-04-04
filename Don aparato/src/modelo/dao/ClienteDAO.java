package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.Conexion;
import controlador.Coordinador;
import modelo.dto.ClienteDTO;

public class ClienteDAO {
	private Coordinador coordinador;
	private ClienteDTO clienteDTO;
	
	public void registrarCliente(ClienteDTO cliente) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO cliente (id_cliente,nombre_cliente,apellido,telefono,tipo)"
				+ "  VALUES (?,?,?,?,?)";
		

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, cliente.getIdCliente());
			preStatement.setString(2, cliente.getNombreCliente());
			preStatement.setString(3, cliente.getApellido());
			preStatement.setString(4, cliente.getTelefono());
			preStatement.setString(5, cliente.getTipo());
			preStatement.executeUpdate();
			resultado = "ok";
			
			JOptionPane.showMessageDialog(null, "Cuenta creada exitoxamente");
			coordinador.volverLoginCliente();

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el cliente: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar el cliente";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}

	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

}
