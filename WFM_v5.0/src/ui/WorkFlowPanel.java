package ui;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WorkFlowPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public WorkFlowPanel() {
		Color background = new Color(255, 242, 204);
		this.setBackground(background);
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
}
