package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Libro;
import logic.Reader;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class HomeView extends JDialog {

	private JPanel contentPane;
	
	private LoginView lv;
	private String usuario;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	private JList list;
	
	private Reader reader;
	private JButton btnComprar;
	private JPanel panel;
	private JRadioButton rdbtn15;
	private JRadioButton rdbtn1540;
	private JRadioButton rdbtn40;
	private final ButtonGroup buttonGroup = new ButtonGroup();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeView frame = new HomeView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HomeView(LoginView login, String usuario, Reader reader) {
		this.reader = reader;
		lv = login;
		this.usuario = usuario;
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLblTitulo(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}
	
	private void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("!Bienvenid@ \n" + getUsuario() + "!");
			lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 28));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTitulo;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.ORANGE);
			scrollPane.setViewportView(getList());
			scrollPane.setRowHeaderView(getBtnComprar());
			scrollPane.setColumnHeaderView(getPanel());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			DefaultListModel model = new DefaultListModel();
			list = new JList(model);
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()){
			            JList source = (JList)e.getSource();
			            String titulo = source.getSelectedValue().toString();
			            Long ISBN = null;
			            String editorial = "";
			        	String autor = "";
			        	String genero = "";
			        	String resumen = "";
			        	double precio = 0.0;
			            for (Libro libro : reader.getLibros()) {
			            	if(libro.getTitulo().equals(titulo)) {
			            		ISBN = libro.getISBN();
			            		editorial = libro.getEditorial();
					        	autor = libro.getAutor();
					        	genero = libro.getGenero();
					        	resumen = libro.getResumen();
					        	precio = libro.getPrecio();
			            	}
			            }
			            JOptionPane.showMessageDialog(null, "ISBN: " + ISBN + "\n" + "Título: " + titulo + "\n" + 
			            "Editorial: " + editorial + "\n" + "Autor: " + autor + "\n" + "Género: " + genero + "\n"+ 
			            "Resumen: " + resumen + "\n" + "Precio: " + precio + "€" + "\n", "Información del libro", JOptionPane.INFORMATION_MESSAGE);
			        }
				}
			});
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.setBackground(Color.ORANGE);
			for(int i = 0; i < reader.getLibros().size(); i++) {
				model.add(i, reader.getLibros().get(i).titulo);
			}
			list.revalidate();
			list.repaint();
			
		}
		return list;
	}
	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.setBackground(Color.ORANGE);
		}
		return btnComprar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getRdbtn15());
			panel.add(getRdbtn1540());
			panel.add(getRdbtn40());
		}
		return panel;
	}
	private JRadioButton getRdbtn15() {
		if (rdbtn15 == null) {
			rdbtn15 = new JRadioButton("<=15€");
			buttonGroup.add(rdbtn15);
		}
		return rdbtn15;
	}
	private JRadioButton getRdbtn1540() {
		if (rdbtn1540 == null) {
			rdbtn1540 = new JRadioButton("15>=40€");
			buttonGroup.add(rdbtn1540);
		}
		return rdbtn1540;
	}
	private JRadioButton getRdbtn40() {
		if (rdbtn40 == null) {
			rdbtn40 = new JRadioButton(">40€");
			buttonGroup.add(rdbtn40);
		}
		return rdbtn40;
	}
}
