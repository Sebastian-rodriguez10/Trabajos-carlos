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

		} catch (SQLException e) {
			System.out.println("No se pudo agregar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo agregar el producto";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}

	}
	
	public void actualizarProducto(ProductoDTO producto2) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "UPDATE producto SET nombre_producto = ?, valor_unitario = ? WHERE id_producto = ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(3, producto2.getIdProducto());
			preStatement.setString(1, producto2.getNombreProducto());
			preStatement.setDouble(2, producto2.getValorUnitario());
			preStatement.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Exito al actualizar el producto");

		} catch (SQLException e) {
			if (consulta == null) {
				JOptionPane.showMessageDialog(null, "El id del producto no existe");
			}
			System.out.println("No se pudo actualizar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo actualizar el producto";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}
	}
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}
