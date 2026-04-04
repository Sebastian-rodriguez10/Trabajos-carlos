package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.Conexion;
import controlador.Coordinador;
import modelo.dto.ClienteDTO;
import modelo.dto.ProductoDTO;

public class ProductoDAO {
	private Coordinador coordinador;
	private ProductoDTO producto;
	
	public void agregarProducto(ProductoDTO producto) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO producto (id_producto,nombre_producto,valor_unitario)"
				+ "  VALUES (?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(1, producto.getIdProducto());
			preStatement.setString(2, producto.getNombreProducto());
			preStatement.setDouble(3, producto.getValorUnitario());
			preStatement.executeUpdate();
			resultado = "ok";
			
			JOptionPane.showMessageDialog(null, "Exito al agregar el nuevo producto");
			coordinador.volverLoginCliente();

		} catch (SQLException e) {
			System.out.println("No se pudo agregar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo agregar el producto";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}

	}
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

}
