package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controlador.Coordinador;

public class VentanaInicio extends JFrame implements ActionListener{

    private JButton btnAdmin, btnCliente;
    Coordinador coordinador;
    public VentanaInicio() {
        setTitle("DON APARATO");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnAdmin = new JButton("Administrador");
        btnAdmin.setBounds(80, 40, 140, 30);
        add(btnAdmin);

        btnCliente = new JButton("Cliente");
        btnCliente.setBounds(80, 90, 140, 30);
        add(btnCliente);
        
        btnAdmin.addActionListener(this);
        btnCliente.addActionListener(this);
        
    }

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdmin) {
            coordinador.mostrarLoginAdmin();
        }

        if (e.getSource() == btnCliente) {
            coordinador.mostrarLoginCliente();
        }		
	}
}
