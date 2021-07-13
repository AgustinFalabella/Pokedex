package pokedex;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ver {

	DefaultTableModel dt = new DefaultTableModel();

	/*
	 * JLabel[] foto = new JLabel[2];
	 * 
	 * public JLabel getJLabel() {
	 * 
	 * return foto[0]; }
	 */

	public JLabel verpokedex(JTable table, Blob blob, JLabel[] foto) {
		table.setDefaultRenderer(Object.class, new Visualizar());

		dt.addColumn("Foto");
		dt.setColumnCount(1);

		if (blob != null) {
			try {
				byte[] data = blob.getBytes(1, (int) blob.length());
				BufferedImage img = null;

				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				ImageIcon icono = new ImageIcon(img.getScaledInstance(table.getWidth(), table.getHeight(),Image.SCALE_DEFAULT));
				foto[0] = new JLabel(icono);
			} catch (Exception e) {
				foto[0] = new JLabel();
			}
		} else {
			foto[0] = new JLabel();
		}

		dt.addRow(foto);
		
		table.setModel(dt);
		table.setRowHeight(180);
		return foto[0];

	}
	public  void limpiarfoto() {
		dt.setRowCount(0);
	}
	
}
