package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.Coordinador;

public class VentanaLoginAdmin extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar, btnVolver;

    private Coordinador coordinador;

    public VentanaLoginAdmin() {

        setTitle("Login Administrador");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(30, 30, 80, 25);
        add(lblUser);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 120, 25);
        add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(30, 70, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 120, 25);
        add(txtPassword);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(30, 110, 100, 30);
        add(btnIngresar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(140, 110, 100, 30);
        add(btnVolver);

        // EVENTOS
        btnIngresar.addActionListener(this);
        btnVolver.addActionListener(this);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIngresar) {

            String user = txtUsuario.getText();
            String pass = new String(txtPassword.getPassword());
            if (user.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Tiene campos vacios");
			}else if (user.equals("admin") && pass.equals("123")) {
                coordinador.mostrarAdmin();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
                limpiar();
            }
        }

        if (e.getSource() == btnVolver) {
            coordinador.mostrarInicio();
            limpiar();
        }
    }
    public void limpiar() {
    	txtUsuario.setText("");
    	txtPassword.setText("");
    }
}
