package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTextField txtUser;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JPasswordField passwordFieldContraseña;
	private JButton btnLogin;
	private Action action;

	private Reader reader;

	private HomeView home;

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
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("/Users/Vladi/Downloads/Practico Julio 2016/img/libreria.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitulo());
		contentPane.add(getTxtUser());
		contentPane.add(getLblUsuario());
		contentPane.add(getLblContraseña());
		contentPane.add(getPasswordFieldContraseña());
		contentPane.add(getBtnLogin());

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

	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Tienda de libros");
			lblTitulo.setForeground(new Color(255, 127, 80));
			lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(6, 6, 438, 44);
		}
		return lblTitulo;
	}

	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setBounds(220, 82, 173, 26);
			txtUser.setColumns(10);
		}
		return txtUser;
	}

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(147, 87, 61, 16);
		}
		return lblUsuario;
	}

	private JLabel getLblContraseña() {
		if (lblContraseña == null) {
			lblContraseña = new JLabel("Contraseña:");
			lblContraseña.setBounds(127, 115, 81, 16);
		}
		return lblContraseña;
	}

	private JPasswordField getPasswordFieldContraseña() {
		if (passwordFieldContraseña == null) {
			passwordFieldContraseña = new JPasswordField();
			passwordFieldContraseña.setBounds(220, 110, 173, 26);
		}
		return passwordFieldContraseña;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Loguearse");
			btnLogin.setAction(getAction());
			btnLogin.setBounds(276, 148, 117, 29);
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
				createWindow();
			}
		}
	}

	private Action getAction() {
		if (action == null) {
			action = new SwingAction();
		}
		return action;
	}
	
	private void createWindow()
	{
		home = new HomeView(this);
		home.setModal(true);
		home.setLocationRelativeTo(this);
		home.setVisible(true);
	}
}
