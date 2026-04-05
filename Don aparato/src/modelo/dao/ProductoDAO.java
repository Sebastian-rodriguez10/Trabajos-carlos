package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			int filas = preStatement.executeUpdate();
			
			if (filas > 0) {
		            JOptionPane.showMessageDialog(null, "Éxito al actualizar el producto");
		        } else {
		            JOptionPane.showMessageDialog(null, "El ID del producto no existe");
		        }
		} catch (SQLException e) {
			
			System.out.println("No se pudo actualizar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo actualizar el producto";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}
	}
	public void eliminarProducto(int int1) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "DELETE from producto WHERE id_producto = ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(1, int1);
			
			int filas = preStatement.executeUpdate();
			
			if (filas > 0) {
		            JOptionPane.showMessageDialog(null, "Éxito al eliminar el producto");
		        } else {
		            JOptionPane.showMessageDialog(null, "El ID del producto no existe");
		        }
		} catch (SQLException e) {
			
			System.out.println("No se pudo eliminar el producto: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo eliminar el producto";
			JOptionPane.showMessageDialog(null, resultado);
			
		} finally {
			conexion.desconectar();
		}
	}
	
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public ArrayList<ProductoDTO> listarProductos() {
		ArrayList<ProductoDTO> lista = new ArrayList<>();

	    Connection connection = null;
	    Conexion conexion = new Conexion();
	    PreparedStatement preStatement = null;
	    ResultSet result = null;
	    String consulta = "SELECT * FROM producto";
	    try {
	        connection = conexion.getConnection();

	        
	        preStatement = connection.prepareStatement(consulta);

	        result = preStatement.executeQuery();
	        while (result.next()) {

	            ProductoDTO producto = new ProductoDTO();

	            producto.setIdProducto(result.getInt("id_producto"));
	            producto.setNombreProducto(result.getString("nombre_producto"));
	            producto.setValorUnitario(result.getDouble("valor_unitario"));

	            lista.add(producto);
	        }

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al listar productos");
	        e.printStackTrace();

	    } finally {
	        conexion.desconectar();
	    }

	    return lista;
	}

}
