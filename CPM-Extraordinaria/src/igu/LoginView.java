package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Reader;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		reader = new Reader();
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/Vladi/Downloads/Practico Julio 2016/img/libreria.jpg"));
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
			try {
				reader.read("files/clientes.dat");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			reader.print(reader.usuarios);
		}
	}
	private Action getAction() {
		if (action == null) {
			action = new SwingAction();
		}
		return action;
	}
}
