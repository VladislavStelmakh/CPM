package igu;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class CruiseView extends JPanel {
	private JPanel pnUpLeft;
	private JPanel pnDownLeft;
	private JPanel pnUpRight;
	private JPanel pnDownRight;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public CruiseView() {
		setLayout(new GridLayout(2, 2, 0, 0));
		add(getPnUpLeft());
		add(getPnUpRight());
		add(getPnDownLeft());
		add(getPnDownRight());

	}

	private JPanel getPnUpLeft() {
		if (pnUpLeft == null) {
			pnUpLeft = new JPanel();
			pnUpLeft.add(getLblNewLabel());
		}
		return pnUpLeft;
	}
	private JPanel getPnDownLeft() {
		if (pnDownLeft == null) {
			pnDownLeft = new JPanel();
		}
		return pnDownLeft;
	}
	private JPanel getPnUpRight() {
		if (pnUpRight == null) {
			pnUpRight = new JPanel();
		}
		return pnUpRight;
	}
	private JPanel getPnDownRight() {
		if (pnDownRight == null) {
			pnDownRight = new JPanel();
		}
		return pnDownRight;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
		}
		return lblNewLabel;
	}
}
