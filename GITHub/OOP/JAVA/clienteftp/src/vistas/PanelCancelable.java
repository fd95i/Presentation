package vistas;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class PanelCancelable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton cancelarBtn;

	protected void armar() {
		cancelarBtn.addActionListener(e -> irAPrincipal());
	}
	public abstract void irAPrincipal();

}
