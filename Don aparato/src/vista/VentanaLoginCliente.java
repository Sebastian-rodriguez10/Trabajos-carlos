package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.Coordinador;

public class VentanaLoginCliente extends JFrame implements ActionListener {

    private JTextField txtDocumento;
    private JButton btnIngresar, btnRegistrar, btnVolver;

    private Coordinador coordinador;

    public VentanaLoginCliente() {

        setTitle("Login Cliente");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblDoc = new JLabel("Documento:");
        lblDoc.setBounds(30, 30, 80, 25);
        add(lblDoc);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(120, 30, 120, 25);
        add(txtDocumento);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(30, 70, 100, 30);
        add(btnIngresar);

        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(140, 70, 120, 30);
        add(btnRegistrar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(80, 110, 120, 30);
        add(btnVolver);

        // EVENTOS
        btnIngresar.addActionListener(this);
        btnRegistrar.addActionListener(this);
        btnVolver.addActionListener(this);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIngresar) {

            String id = txtDocumento.getText();

             //🔥 Aquí luego conectamos con DAO
            if (coordinador.existeCliente(id)) {
                coordinador.mostrarCompra();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no existe");
            }
            coordinador.mostrarCompra();

        }

        if (e.getSource() == btnRegistrar) {
            coordinador.mostrarRegistro();
        }

        if (e.getSource() == btnVolver) {
            coordinador.mostrarInicio();
        }
    }
}
