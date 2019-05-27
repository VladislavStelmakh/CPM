package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel pnUp;
	private JPanel pnDown;
	private JPanel pnUpLeft;
	private JPanel pnUpRight;
	private JPanel pnCenter;
	private JPanel pnCenterLeft;
	private JPanel pnCenterRight;
	private JPanel pnFilterUp;
	private JPanel pnFilterDown;
	private JButton btnHelp;
	private JButton btnShoppingCart;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Agencia de viajes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnUp(), BorderLayout.NORTH);
		contentPane.add(getPnDown(), BorderLayout.SOUTH);
		contentPane.add(getPnCenter(), BorderLayout.CENTER);
		
		addCruise();
	}
	private void addCruise() {
		
		CruiseView cruise = new CruiseView();
		cruise.setVisible(true);
		getScrollPane().add(cruise);
		getScrollPane().revalidate();
		getScrollPane().repaint();
	}

	private JPanel getPnUp() {
		if (pnUp == null) {
			pnUp = new JPanel();
			pnUp.setLayout(new GridLayout(1, 0, 0, 0));
			pnUp.add(getPnUpLeft());
			pnUp.add(getPnUpRight());
		}
		return pnUp;
	}
	private JPanel getPnDown() {
		if (pnDown == null) {
			pnDown = new JPanel();
		}
		return pnDown;
	}
	private JPanel getPnUpLeft() {
		if (pnUpLeft == null) {
			pnUpLeft = new JPanel();
			pnUpLeft.add(getBtnHelp());
		}
		return pnUpLeft;
	}
	private JPanel getPnUpRight() {
		if (pnUpRight == null) {
			pnUpRight = new JPanel();
			pnUpRight.add(getBtnShoppingCart());
		}
		return pnUpRight;
	}
	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setLayout(new BorderLayout(0, 0));
			pnCenter.add(getPnCenterLeft(), BorderLayout.WEST);
			pnCenter.add(getPnCenterRight(), BorderLayout.CENTER);
		}
		return pnCenter;
	}
	private JPanel getPnCenterLeft() {
		if (pnCenterLeft == null) {
			pnCenterLeft = new JPanel();
			pnCenterLeft.setLayout(new GridLayout(0, 1, 0, 0));
			pnCenterLeft.add(getPnFilterUp());
			pnCenterLeft.add(getPnFilterDown());
		}
		return pnCenterLeft;
	}
	private JPanel getPnCenterRight() {
		if (pnCenterRight == null) {
			pnCenterRight = new JPanel();
			pnCenterRight.setLayout(new CardLayout(0, 0));
			pnCenterRight.add(getScrollPane(), "name_3246609367402");
		}
		return pnCenterRight;
	}
	private JPanel getPnFilterUp() {
		if (pnFilterUp == null) {
			pnFilterUp = new JPanel();
			pnFilterUp.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return pnFilterUp;
	}
	private JPanel getPnFilterDown() {
		if (pnFilterDown == null) {
			pnFilterDown = new JPanel();
			pnFilterDown.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return pnFilterDown;
	}
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("?");
			btnHelp.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			btnHelp.setForeground(Color.BLACK);
		}
		return btnHelp;
	}
	private JButton getBtnShoppingCart() {
		if (btnShoppingCart == null) {
			btnShoppingCart = new JButton("Shopping Cart");
			btnShoppingCart.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		}
		return btnShoppingCart;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
}
