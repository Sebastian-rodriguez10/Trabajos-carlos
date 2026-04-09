package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.dto.ProductoDTO;

import java.awt.event.*;
import java.util.List;

public class VentanaAdmin extends JFrame implements ActionListener {

    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField txtId, txtNombre, txtValor;

    private JButton btnAgregar, btnActualizar, btnEliminar, btnCargar, btnVolver;

    private Coordinador coordinador;
    private ProductoDTO producto;

    public VentanaAdmin() {

        setTitle("Administrador - Productos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Valor"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 550, 150);
        add(scroll);

     // 🔥 LABEL ID
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(20, 180, 100, 20);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(20, 200, 100, 25);
        add(txtId);

        // 🔥 LABEL NOMBRE
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(140, 180, 150, 20);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 200, 150, 25);
        add(txtNombre);

        // 🔥 LABEL VALOR
        JLabel lblValor = new JLabel("Valor Unitario");
        lblValor.setBounds(310, 180, 120, 20);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(310, 200, 100, 25);
        add(txtValor);


        // BOTONES
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(20, 250, 100, 30);
        add(btnAgregar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(130, 250, 110, 30);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(250, 250, 100, 30);
        add(btnEliminar);

        btnCargar = new JButton("Cargar Tabla");
        btnCargar.setBounds(360, 250, 120, 30);
        add(btnCargar);

        btnVolver = new JButton("Cerrar sesion");
        btnVolver.setBounds(240, 300, 130, 30);
        add(btnVolver);

        // EVENTOS
        btnAgregar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnCargar.addActionListener(this);
        btnVolver.addActionListener(this);

        // CLICK EN TABLA
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.getSelectedRow();
                txtId.setText(modelo.getValueAt(fila, 0).toString());
                txtNombre.setText(modelo.getValueAt(fila, 1).toString());
                txtValor.setText(modelo.getValueAt(fila, 2).toString());
            }
        });
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAgregar) {
        	
        	try {
        		producto = new ProductoDTO();
            	producto.setIdProducto(Integer.parseInt(txtId.getText()));
            	producto.setNombreProducto(txtNombre.getText());
            	producto.setValorUnitario(Double.parseDouble(txtValor.getText()));
                coordinador.agregarProducto(producto);
            	System.out.println("se agrego un nuevo producto");
			} catch (NumberFormatException n) {
				if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtValor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos para poder agregar un nuevo producto");
				}else {
					JOptionPane.showMessageDialog(null, "El valor debe ser un números");
				}
				
			}
        	
        }

        if (e.getSource() == btnActualizar) {
        	producto = new ProductoDTO();
        	producto.setIdProducto(Integer.parseInt(txtId.getText()));
        	producto.setNombreProducto(txtNombre.getText());
        	producto.setValorUnitario(Double.parseDouble(txtValor.getText()));
            coordinador.actualizarProducto(producto);
        }

        if (e.getSource() == btnEliminar) {
        	String idtexto = JOptionPane.showInputDialog("Escribe el id del numero que quiere eliminar");
        	
        	try {
        		
        		int id = Integer.parseInt(idtexto);
        		coordinador.eliminarProducto(id);
        		limpiar();
			} catch (NumberFormatException a) {
				if (idtexto.isEmpty()) {
    				JOptionPane.showMessageDialog(null, "Debe llenar el campo con el id del producto que desea eliminar");
    			}else {
    				JOptionPane.showMessageDialog(null, "No se puede letras tienen que ser numeros");
    			}
			}
            
        }

        if (e.getSource() == btnCargar) {
            coordinador.listarProductos();
        }

        if (e.getSource() == btnVolver) {
            coordinador.mostrarInicio();
            limpiar();
        }
    }
    
    public void limpiar() {
    	txtId.setText("");
    	txtNombre.setText("");
    	txtValor.setText("");
    }

    // Método para llenar tabla
    public void mostrarProductos(List<ProductoDTO> lista) {
        modelo.setRowCount(0);

        for (ProductoDTO p : lista) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getValorUnitario()
            });
        }
    }

}

