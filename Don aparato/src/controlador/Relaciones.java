package controlador;

import modelo.LogicaCompras;
import modelo.dao.ClienteDAO;
import modelo.dao.CompraDAO;
import modelo.dao.ProductoDAO;
import vista.*;

public class Relaciones {
	private LogicaCompras logicaCompra;
    private VentanaInicio vInicio;
    private VentanaLoginAdmin vLoginAdmin;
    private VentanaLoginCliente vLoginCliente;
    private VentanaAdmin vAdmin;
    private VentanaRegistro vRegistro;
    private VentanaCompra vCompra;
    
    private ClienteDAO clienteDAO;
    private CompraDAO compraDAO;
    private ProductoDAO productoDAO;

    public Coordinador coordinador;
    
	public void iniciar() {

        // VISTAS
        vInicio = new VentanaInicio();
        vLoginAdmin = new VentanaLoginAdmin();
        vLoginCliente = new VentanaLoginCliente();
        vAdmin = new VentanaAdmin();
        vRegistro = new VentanaRegistro();
        vCompra = new VentanaCompra();
        
        logicaCompra = new LogicaCompras();
        
        clienteDAO = new ClienteDAO();
        compraDAO = new CompraDAO();
        productoDAO = new ProductoDAO();
        
        // COORDINADOR
        coordinador = new Coordinador();

        // INYECTAR
        vInicio.setCoordinador(coordinador);
        vLoginAdmin.setCoordinador(coordinador);
        vLoginCliente.setCoordinador(coordinador);
        vAdmin.setCoordinador(coordinador);
        vRegistro.setCoordinador(coordinador);
        vCompra.setCoordinador(coordinador);
        logicaCompra.setCoordinador(coordinador);
        clienteDAO.setCoordinador(coordinador);
        compraDAO.setCoordinador(coordinador);
        productoDAO.setCoordinador(coordinador);
        
        coordinador.setVentanaInicio(vInicio);
        coordinador.setVentanaLoginAdmin(vLoginAdmin);
        coordinador.setVentanaLoginCliente(vLoginCliente);
        coordinador.setVentanaAdmin(vAdmin);
        coordinador.setVentanaRegistro(vRegistro);
        coordinador.setVentanaCompra(vCompra);
        coordinador.setLogicaCompras(logicaCompra);
        coordinador.setClienteDAO(clienteDAO);
        coordinador.setComprasDAO(compraDAO);
        coordinador.setProductoDAO(productoDAO);
        
        vInicio.setVisible(true);
    }
}
