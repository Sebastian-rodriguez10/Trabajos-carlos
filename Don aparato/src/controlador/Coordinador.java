package controlador;

import java.util.ArrayList;

import modelo.LogicaCompras;
import modelo.dao.ClienteDAO;
import modelo.dao.CompraDAO;
import modelo.dao.ProductoDAO;
import modelo.dto.ClienteDTO;
import modelo.dto.ProductoDTO;
import vista.VentanaAdmin;
import vista.VentanaCompra;
import vista.VentanaInicio;
import vista.VentanaLoginAdmin;
import vista.VentanaLoginCliente;
import vista.VentanaRegistro;

public class Coordinador {
	private VentanaInicio vInicio;
    private VentanaLoginAdmin vLoginAdmin;
    private VentanaLoginCliente vLoginCliente;
    private VentanaAdmin vAdmin;
    private VentanaRegistro vRegistro;
    private VentanaCompra vCompra;
    private LogicaCompras logica;
    private ClienteDAO clienteDAO;
    private CompraDAO compraDAO;
    private ProductoDAO productoDAO;

	public void setVentanaInicio(VentanaInicio vInicio) {
		this.vInicio = vInicio;
	}

	public void setVentanaLoginAdmin(VentanaLoginAdmin vLoginAdmin) {
		this.vLoginAdmin = vLoginAdmin;
	}

	public void setVentanaLoginCliente(VentanaLoginCliente vLoginCliente) {
		this.vLoginCliente = vLoginCliente;
	}

	public void setVentanaAdmin(VentanaAdmin vAdmin) {
		this.vAdmin = vAdmin;
	}

	public void setVentanaRegistro(VentanaRegistro vRegistro) {
		this.vRegistro = vRegistro;
	}

	public void setVentanaCompra(VentanaCompra vCompra) {
		 this.vCompra = vCompra;
	}
	
	public void setLogicaCompras(LogicaCompras logicaCompra) {
		this.logica = logicaCompra;
	}
	
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public void setComprasDAO(CompraDAO compraDAO) {
		this.compraDAO = compraDAO;
	}
	
	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}
	
	//=======METODOS=======
	public void mostrarLoginAdmin() {
        vInicio.setVisible(false);
        vLoginAdmin.setVisible(true);
    }

    public void mostrarLoginCliente() {
        vInicio.setVisible(false);
        vLoginCliente.setVisible(true);
    }

    public void mostrarAdmin() {
        vLoginAdmin.setVisible(false);
        vAdmin.setVisible(true);
    }

    public void mostrarRegistro() {
        vLoginCliente.setVisible(false);
        vRegistro.setVisible(true);
    }

    public void volverLoginCliente() {
        vRegistro.setVisible(false);
        vLoginCliente.setVisible(true);
    }

    public void mostrarCompra() {
        vLoginCliente.setVisible(false);
        vCompra.setVisible(true);
    }
    
    public void mostrarInicio() {
        vLoginAdmin.setVisible(false);
        vLoginCliente.setVisible(false);
        vCompra.setVisible(false);
        vAdmin.setVisible(false);
        vCompra.setVisible(false);
        vInicio.setVisible(true);
    }
    
//    public boolean existeCliente(String id) {
//        return logica.existeCliente(id);
//    }

	public void registrarCliente(ClienteDTO cliente) {
		clienteDAO.registrarCliente(cliente);
	}

	public void agregarProducto(ProductoDTO producto) {
		productoDAO.agregarProducto(producto);
		listarProductos();

	}

	public void actualizarProducto(ProductoDTO producto) {
		productoDAO.actualizarProducto(producto);
		listarProductos();

	}

	public void eliminarProducto(int int1) {
		productoDAO.eliminarProducto(int1);
		listarProductos();

	}

	public void listarProductos() {

	    ArrayList<ProductoDTO> lista = productoDAO.listarProductos();

	    vAdmin.mostrarProductos(lista);
	}
	public void listarProductosVcompra() {

	    ArrayList<ProductoDTO> lista = productoDAO.listarProductos();

	    vCompra.mostrarProductos(lista);
	}




}
