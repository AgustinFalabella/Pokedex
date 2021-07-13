package ProfesorOAK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VisualProfesor extends JFrame {

	String ruta=null;
	private JPanel contentPane;

	private JTextField textnombre;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textHabitat;
	private JTextField textCategoría;
	private JTextField textHabilidad;
	private JTextField textHabilidadOculta;
	private JTextField textTipo;
	private JTable table;
	private JTextField textIdPK;
	private JTextField textEvolucionaDe;
	private JTextField textEvolucionaA;
	
	
	
	private void limpiarcampos() {
		textIdPK.setText(null);
		textnombre.setText(null);
		textTipo.setText(null);
		textPeso.setText(null);
		textAltura.setText(null);
		textHabitat.setText(null);
		textCategoría.setText(null);
		textHabilidad.setText(null);
		textHabilidadOculta.setText(null);
		textEvolucionaDe.setText(null);
		textEvolucionaA.setText(null);
	
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualProfesor frame = new VisualProfesor();
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
	public VisualProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1335, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 26, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(20, 51, 46, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(20, 77, 46, 14);
		contentPane.add(lblAltura);
		
		JLabel lblHabitat = new JLabel("Habitat");
		lblHabitat.setBounds(20, 145, 46, 14);
		contentPane.add(lblHabitat);
		
		JLabel lblCategoría = new JLabel("Categor\u00EDa");
		lblCategoría.setBounds(20, 190, 102, 14);
		contentPane.add(lblCategoría);
		
		JLabel lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(20, 215, 102, 14);
		contentPane.add(lblHabilidad);
		
		JLabel lblHabilidadOculta = new JLabel("Habilidad Oculta");
		lblHabilidadOculta.setBounds(20, 252, 102, 14);
		contentPane.add(lblHabilidadOculta);
		
		JLabel lblurl = new JLabel("url");
		lblurl.setBounds(868, 543, 451, 14);
		contentPane.add(lblurl);
		
		
		
		textnombre = new JTextField();
		textnombre.setBounds(141, 23, 86, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(141, 48, 86, 20);
		contentPane.add(textPeso);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(141, 74, 86, 20);
		contentPane.add(textAltura);
		
		textHabitat = new JTextField();
		textHabitat.setColumns(10);
		textHabitat.setBounds(141, 142, 86, 20);
		contentPane.add(textHabitat);
		
		textCategoría = new JTextField();
		textCategoría.setColumns(10);
		textCategoría.setBounds(141, 187, 86, 20);
		contentPane.add(textCategoría);
		
		textHabilidad = new JTextField();
		textHabilidad.setColumns(10);
		textHabilidad.setBounds(141, 212, 86, 20);
		contentPane.add(textHabilidad);
		
		textHabilidadOculta = new JTextField();
		textHabilidadOculta.setColumns(10);
		textHabilidadOculta.setBounds(141, 249, 86, 20);
		contentPane.add(textHabilidadOculta);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(24, 341, 279, 180);
		contentPane.add(lblImagen);
		
		JButton btnAgregar = new JButton("Agregar a la pokedex");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Conexion conexion=new Conexion();
				String IdPK=textIdPK.getText();
				String nombre=textnombre.getText();
				String Tipo=textTipo.getText();
				String Peso=textPeso.getText();
				String Altura=textAltura.getText();
				String Habitat=textHabitat.getText();
				String Categoría=textCategoría.getText();
				String Habilidad=textHabilidad.getText();
				String HabilidadOculta=textHabilidadOculta.getText();
				String EvolucionaDe=textEvolucionaDe.getText();
				String EvolucionaA=textEvolucionaA.getText();
				String url=lblurl.getText();
	
			if(url.trim().length()!=0 && nombre.trim().length()!=0 && Tipo.trim().length()!=0 && Peso.trim().length()!=0 && Altura.trim().length()!=0 && Habitat.trim().length()!=0 && Categoría.trim().length()!=0 && Habilidad.trim().length()!=0 && HabilidadOculta.trim().length()!=0){
				
				conexion.guardarImagen( IdPK, nombre,Tipo, Peso, Altura, Habitat, Categoría, Habilidad, HabilidadOculta,EvolucionaDe,EvolucionaA, url);
				
				limpiarcampos();
				JOptionPane.showMessageDialog(null, "Pokemón agregado");
				}
			else {
				JOptionPane.showMessageDialog(null, "No dejar los campos vacíos");
			}
				
			}
		});
		btnAgregar.setBounds(24, 532, 227, 37);
		contentPane.add(btnAgregar);
		
		JButton btnAbrir = new JButton("Abrir...");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser j=new JFileChooser();
				int ap=j.showOpenDialog(btnAbrir);
				if (ap==JFileChooser.APPROVE_OPTION) {
					ruta=j.getSelectedFile().getAbsolutePath();
					lblImagen.setIcon(new ImageIcon(ruta));
					lblurl.setText(ruta);
				
					
				}
				
			}
		});
		btnAbrir.setBounds(493, 539, 89, 23);
		contentPane.add(btnAbrir);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerProfesorOAK v= new VerProfesorOAK();
				v.visualizarProfesorOAK(table);
			
			}
			
		});
		btnVisualizar.setBounds(261, 539, 175, 23);
		contentPane.add(btnVisualizar);
	
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(20, 110, 46, 14);
		contentPane.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBounds(141, 107, 86, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		table = new JTable();
		table.setBounds(511, 26, 1095, 455);
		contentPane.add(table);
		
		textIdPK = new JTextField();
		textIdPK.setBounds(141, 0, 86, 20);
		contentPane.add(textIdPK);
		textIdPK.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IdPokemon");
		lblNewLabel.setBounds(20, 3, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Evoluciona de");
		lblNewLabel_1.setBounds(237, 3, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textEvolucionaDe = new JTextField();
		textEvolucionaDe.setBounds(318, 0, 102, 20);
		contentPane.add(textEvolucionaDe);
		textEvolucionaDe.setColumns(10);
		
		textEvolucionaA = new JTextField();
		textEvolucionaA.setBounds(318, 34, 102, 20);
		contentPane.add(textEvolucionaA);
		textEvolucionaA.setColumns(10);
		
		JLabel EvolucionaA = new JLabel("Evoluciona a");
		EvolucionaA.setBounds(237, 37, 86, 14);
		contentPane.add(EvolucionaA);
	
	}
}
