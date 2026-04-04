package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;

import java.awt.event.*;
import java.util.List;

import modelo.dto.ProductoDTO;

public class VentanaCompra extends JFrame implements ActionListener {

    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField txtIdProducto, txtCantidad;
    private JButton btnComprar, btnVolver;

    private JLabel lblResultado;

    private Coordinador coordinador;

    public VentanaCompra() {

        setTitle("Compra de Productos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        
     // 🔥 BUSCAR
        JLabel lblBuscar = new JLabel("Buscar producto:");
        lblBuscar.setBounds(20, 10, 120, 25);
        add(lblBuscar);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(140, 10, 200, 25);
        add(txtBuscar);

        // 🔥 TITULO
        JLabel titulo = new JLabel("PRODUCTOS DISPONIBLES");
        titulo.setBounds(180, 40, 250, 25);
        add(titulo);

        // 🔥 TABLA
        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Valor"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 70, 550, 150);
        add(scroll);

        // 🔥 ID PRODUCTO
        JLabel lblId = new JLabel("ID producto:");
        lblId.setBounds(50, 225, 120, 25);
        add(lblId);

        txtIdProducto = new JTextField();
        txtIdProducto.setBounds(170, 225, 120, 25);
        add(txtIdProducto);

        // 🔥 CANTIDAD
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(50, 265, 120, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(170, 265
        		, 120, 25);
        add(txtCantidad);

        // 🔥 BOTONES
        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(100, 300, 100, 30);
        add(btnComprar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(250, 300, 100, 30);
        add(btnVolver);

        // 🔥 RESULTADO
        lblResultado = new JLabel("Resultado...");
        lblResultado.setBounds(50, 340, 400, 25);
        add(lblResultado);

        // EVENTOS
        btnComprar.addActionListener(this);
        btnVolver.addActionListener(this);

        // 🔥 CLICK EN TABLA → auto llenar ID
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.getSelectedRow();
                txtIdProducto.setText(modelo.getValueAt(fila, 0).toString());
            }
        });
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnComprar) {
//            coordinador.realizarCompra(
//                txtIdProducto.getText(),
//                txtCantidad.getText()
//            );
        }

        if (e.getSource() == btnVolver) {
            coordinador.mostrarInicio();
        }
    }

    // 🔥 CARGAR PRODUCTOS (LISTA PRO)
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

    public void mostrarResultado(String texto) {
        lblResultado.setText(texto);
    }
}
