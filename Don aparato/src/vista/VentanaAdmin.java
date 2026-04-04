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

        // CAMPOS
        txtId = new JTextField();
        txtId.setBounds(20, 200, 100, 25);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 200, 150, 25);
        add(txtNombre);

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

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(240, 300, 100, 30);
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
            coordinador.agregarProducto(txtId.getText(), txtNombre.getText(), txtValor.getText());
        }

        if (e.getSource() == btnActualizar) {
            coordinador.actualizarProducto(txtId.getText(), txtNombre.getText(), txtValor.getText());
        }

        if (e.getSource() == btnEliminar) {
            coordinador.eliminarProducto(txtId.getText());
        }

        if (e.getSource() == btnCargar) {
            coordinador.listarProductos();
        }

        if (e.getSource() == btnVolver) {
            coordinador.mostrarInicio();
        }
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

