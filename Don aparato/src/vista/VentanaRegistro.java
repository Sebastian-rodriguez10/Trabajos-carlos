package vista;

import javax.swing.*;
import java.awt.event.*;

import controlador.Coordinador;
import modelo.dto.ClienteDTO;

public class VentanaRegistro extends JFrame implements ActionListener {

    private JTextField txtId, txtNombre, txtApellido, txtTelefono;
    private JComboBox<String> comboTipo;
    private JButton btnGuardar, btnVolver;

    private Coordinador coordinador;
    private ClienteDTO cliente;

    public VentanaRegistro() {

        setTitle("Registro Cliente");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        txtId = new JTextField();
        txtId.setBounds(100, 20, 150, 25);
        add(new JLabel("ID")).setBounds(20, 20, 80, 25);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 60, 150, 25);
        add(new JLabel("Nombre")).setBounds(20, 60, 80, 25);
        add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 100, 150, 25);
        add(new JLabel("Apellido")).setBounds(20, 100, 80, 25);
        add(txtApellido);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 140, 150, 25);
        add(new JLabel("Teléfono")).setBounds(20, 140, 80, 25);
        add(txtTelefono);

        comboTipo = new JComboBox<>(new String[]{"A", "B", "C"});
        comboTipo.setBounds(100, 180, 150, 25);
        add(new JLabel("Tipo")).setBounds(20, 180, 80, 25);
        add(comboTipo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(40, 220, 100, 30);
        add(btnGuardar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(150, 220, 100, 30);
        add(btnVolver);

        btnGuardar.addActionListener(this);
        btnVolver.addActionListener(this);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnGuardar) {
        	cliente = new ClienteDTO();
        	cliente.setIdCliente(txtId.getText());
        	cliente.setNombreCliente(txtNombre.getText());
        	cliente.setApellido(txtApellido.getText());
        	cliente.setTelefono(txtTelefono.getText());
        	cliente.setTipo(comboTipo.getSelectedItem().toString());
        	
            coordinador.registrarCliente(cliente);
        }else if (e.getSource() == btnVolver) {
            coordinador.volverLoginCliente();
        }
    }
}
