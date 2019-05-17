package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Libro;
import logic.Reader;
import logic.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private Action action;

	private Reader reader;

	private HomeView home;
	private JLabel label;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContraseña;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public LoginView() throws FileNotFoundException {
		
		reader = new Reader();
		
		try {
			reader.readUsers("files/clientes.dat");
		} catch (Exception e) {
			throw new FileNotFoundException("Problema al leer el archivo de clientes");
		}

		try {
			reader.readBooks("files/libros.dat");
		} catch (Exception e) {
			throw new FileNotFoundException("Problema al leer el archivo de libros");
		}
		
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("/Users/Vladi/Downloads/Practico Julio 2016/img/libreria.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLabel(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);

	}
	
	private void createWindow(String usuario, Reader reader)
	{
		home = new HomeView(this, usuario, reader);
		home.setModal(true);
		home.setLocationRelativeTo(this);
		home.setVisible(true);
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Tienda de libros");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(new Color(255, 127, 80));
			label.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		}
		return label;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getPanel_1());
			panel.add(getPanel_2());
			panel.add(getPanel_3());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			panel_1.add(getLblUsuario());
			panel_1.add(getTxtUser());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(1, 0, 0, 0));
			panel_2.add(getLblContraseña());
			panel_2.add(getPasswordFieldContraseña());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_3.add(getBtnLogin());
		}
		return panel_3;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblUsuario;
	}
	private JTextField getTxtUser() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
		}
		return txtUsuario;
	}
	private JLabel getLblContraseña() {
		if (lblContraseña == null) {
			lblContraseña = new JLabel("Contraseña:");
			lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblContraseña;
	}
	private JPasswordField getPasswordFieldContraseña() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
		}
		return passwordField;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Loguearse");
			btnLogin.setAction(getAction());
		}
		return btnLogin;
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Loguearse");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String nombre = getTxtUser().getText();
			String contraseña = getPasswordFieldContraseña().getText();
			boolean registrado = false;
			boolean correcta = false;
			if (registrado == false || correcta == false) {
				for (Usuario usuario : reader.usuarios) {
					if (usuario.getNombre().equals(nombre)) {
						registrado = true;
					}
					if (usuario.getContraseña().equals(contraseña)) {
						correcta = true;
					}
				}
			}

			if (registrado == false || correcta == false) {
				JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos", "Error de acceso",
						JOptionPane.ERROR_MESSAGE);
			} else {
				createWindow(nombre, reader);
			}
		}
	}
	
	private Action getAction() {
		if (action == null) {
			action = new SwingAction();
		}
		return action;
	}
}
