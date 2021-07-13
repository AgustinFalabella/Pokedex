package ProfesorOAK;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VerProfesorOAK {
	
public void visualizarProfesorOAK (JTable tabla) {
	Conexion conexion=new Conexion();
	ResultSet rs=conexion.visualizar();
	
	tabla.setDefaultRenderer(Object.class, new ProfesorOAK());
	
	DefaultTableModel dt=new DefaultTableModel();
	dt.addColumn("IdPk");
	dt.addColumn("Nombre");
	dt.addColumn("Peso");
	dt.addColumn("Foto");
	dt.addColumn("altura");
	dt.addColumn("Habitat");
	dt.addColumn("Categoría");
	dt.addColumn("Habilidad");
	dt.addColumn("HabilidadOculta");
	
	
	try {
		while(rs.next()) {
			Object[] fila=new Object[15];
			fila[0]=rs.getObject(1);
			fila[1]=rs.getObject(2);
			fila[2]=rs.getObject(3);
			Blob blob=rs.getBlob(12);
			fila[4]=rs.getObject(4);
			fila[5]=rs.getObject(5);
			fila[6]=rs.getObject(6);
			fila[7]=rs.getObject(7);
			fila[8]=rs.getObject(8);
			fila[9]=rs.getObject(9);
			
			
			
			if (blob!= null) {
				try {
					byte []data=blob.getBytes(1, (int)blob.length());
					BufferedImage img=null;
					
					try {
						img=ImageIO.read(new ByteArrayInputStream(data));
					} catch (Exception e) {
						System.out.println(e.getMessage());
				}
				ImageIcon icono=new ImageIcon (img);
				fila[3]= new JLabel (icono);
				} catch (Exception e) {
					fila[3]= "No Imagen";
				}
				}
		else {
			fila[3]="No Imagen";
		}
			
		dt.addRow(fila);
	} 
		tabla.setModel(dt);
		tabla.setRowHeight(124);
		
	} catch (Exception e) {
		System.out.println("Error al visualizar la tabla" + e.getMessage());
	}

}

}
