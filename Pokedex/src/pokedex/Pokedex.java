package pokedex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;

import javax.swing.SwingConstants;

public class Pokedex {

	private JFrame frame;
	private JTextField textNombre;
	private JLabel textIdPK;
	private JLabel textNombre1;
	private JLabel textPeso;
	private JLabel textAltura;
	private JLabel textCategoría;
	private JLabel textHabitat;
	private JLabel textHablidad;
	private JLabel textHabilidadOculta;
	private JLabel textGeneración;
	private JLabel textTipo;
	private JTable table;
	// private JLabel foto;

	String ruta = "src/imagenes/";

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Ver v = new Ver();

	private void limpiarbusquedas() {
		textNombre.setText(null);
		textIdPK.setText(null);
		textNombre1.setText(null);
		textTipo.setText(null);
		textPeso.setText(null);
		textAltura.setText(null);
		textCategoría.setText(null);
		textHablidad.setText(null);
		textHabilidadOculta.setText(null);
		textGeneración.setText(null);
		textHabitat.setText(null);
		v.limpiarfoto();

	}

	private void limpiarEvolucion() {
		textNombre.setText(null);
		textIdPK.setText(null);
		textTipo.setText(null);
		textPeso.setText(null);
		textAltura.setText(null);
		textCategoría.setText(null);
		textHablidad.setText(null);
		textHabilidadOculta.setText(null);
		textGeneración.setText(null);
		textHabitat.setText(null);
		v.limpiarfoto();

	}
	private void limpiarFlechas() {
		textNombre.setText(null);
		textTipo.setText(null);
		textPeso.setText(null);
		textAltura.setText(null);
		textCategoría.setText(null);
		textHablidad.setText(null);
		textHabilidadOculta.setText(null);
		textGeneración.setText(null);
		textHabitat.setText(null);
		v.limpiarfoto();
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 250, 702, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textNombre = new JTextField();
		textNombre.setBounds(25, 307, 154, 55);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnUp = new JButton("\u2191");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();

				try {
					limpiarFlechas();
					preparedStatement = conexion.prepareStatement(
							"SELECT * FROM pokemon WHERE IdPK = (SELECT MIN(IdPK) FROM pokemon WHERE IdPK >"
									+ textIdPK.getText() + ")");

					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						textNombre1.setText(resultSet.getString("Nombre"));
						textIdPK.setText(resultSet.getString("IdPK"));

						v.limpiarfoto();

						JLabel[] foto = new JLabel[1];

						v.verpokedex(table, resultSet.getBlob("Foto"), foto);

						textNombre.setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "Pokemón no encontrado, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la Pokedex, vuelve a intentarlo más tarde " + e1.getMessage());
				}
			}

		});
		btnUp.setBounds(221, 296, 47, 26);
		frame.getContentPane().add(btnUp);

		JButton btnLeft = new JButton("\u2190");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar();

				try {
					limpiarFlechas();
					preparedStatement = conexion.prepareStatement(
							"SELECT * FROM pokemon WHERE IdPK ="
									+ textIdPK.getText());
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						int Id = Integer.parseInt(textIdPK.getText());
						if (152>=Id) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =1");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							
							
							
						} else if ((151 <= Id) && (Id <= 251)) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =252");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
					
						} else if ((251 < Id) && (Id < 386)) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =386");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							
						} else if ((386 < Id) && (Id < 493)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =493");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((493 < Id) && (Id < 649)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =649");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((649 < Id) && (Id < 721)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =721");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							textGeneración.setText("Sexta");
						} else if ((721 < Id) && (Id < 809)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =809");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((809 < Id) && (Id < 898)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =898");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						}

						
					} else {
						JOptionPane.showMessageDialog(null, "Pokemón no encontrado, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			
			}
		});
		btnLeft.setBounds(193, 321, 47, 26);
		frame.getContentPane().add(btnLeft);

		JButton btnRigth = new JButton("\u2192");
		btnRigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar();

				try {
					limpiarFlechas();
					preparedStatement = conexion.prepareStatement(
							"SELECT * FROM pokemon WHERE IdPK ="
									+ textIdPK.getText());
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						int Id = Integer.parseInt(textIdPK.getText());
						if (Id <= 151) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =152");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							
							
							
						} else if ((152 <= Id) && (Id <= 251)) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =252");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
					
						} else if ((251 < Id) && (Id < 386)) {
							
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =386");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							
						} else if ((386 < Id) && (Id < 493)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =493");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((493 < Id) && (Id < 649)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =649");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((649 < Id) && (Id < 721)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =721");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
							textGeneración.setText("Sexta");
						} else if ((721 < Id) && (Id < 809)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =809");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						} else if ((809 < Id) && (Id < 898)) {
							try {
								preparedStatement = conexion.prepareStatement(
										"SELECT * FROM pokemon WHERE IdPK =898");
								resultSet = preparedStatement.executeQuery();
								if (resultSet.next()) {
								textNombre1.setText(resultSet.getString("Nombre"));
								textIdPK.setText(resultSet.getString("IdPK"));

								v.limpiarfoto();

								JLabel[] foto = new JLabel[1];

								v.verpokedex(table, resultSet.getBlob("Foto"), foto);

								textNombre.setText(null);
								}	
							}catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
							}
						}

						
					} else {
						JOptionPane.showMessageDialog(null, "Pokemón no encontrado, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnRigth.setBounds(250, 321, 47, 26);
		frame.getContentPane().add(btnRigth);

		JButton btnDown = new JButton("\u2193");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();

				try {
					limpiarFlechas();
					preparedStatement = conexion.prepareStatement(
							"SELECT * FROM pokemon WHERE IdPK = (SELECT MAX(IdPK) FROM pokemon WHERE IdPK < "
									+ textIdPK.getText() + ")");
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						textNombre1.setText(resultSet.getString("Nombre"));
						textIdPK.setText(resultSet.getString("IdPK"));
						v.limpiarfoto();

						JLabel[] foto = new JLabel[1];

						v.verpokedex(table, resultSet.getBlob("Foto"), foto);

						textNombre.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "Pokemón no encontrado, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnDown.setBounds(221, 347, 47, 26);
		frame.getContentPane().add(btnDown);

		JButton btnEvolucionSiguiente = new JButton("Siguiente");
		btnEvolucionSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					limpiarEvolucion();
					preparedStatement = conexion.prepareStatement(
							"Select IdPK,Nombre,Peso, Altura, Tipo, Habitat, Categoría,  Habilidad, HabilidadOculta, EvolucionaA, Generación, Foto from pokemon where EvolucionaDe =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						textNombre1.setText(resultSet.getString("Nombre"));
						textIdPK.setText(resultSet.getString("IdPK"));

						v.limpiarfoto();

						JLabel[] foto = new JLabel[1];// foto= new
														// JLabel();//v.verpokedex(table,resultSet.getBlob("Foto"));
						v.verpokedex(table, resultSet.getBlob("Foto"), foto);

						textNombre.setText(null);
					} else {
						JOptionPane.showMessageDialog(null,
								"Este pokemon ya no evoluciona, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}

		});
		btnEvolucionSiguiente.setBounds(133, 271, 98, 14);
		frame.getContentPane().add(btnEvolucionSiguiente);

		JButton btnEvolucionAnterior = new JButton("Anterior");
		btnEvolucionAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				conexion = Conexion.conectar();

				try {
					limpiarEvolucion();
					preparedStatement = conexion.prepareStatement(
							"Select IdPK,Nombre,Peso, Altura, Tipo, Habitat, Categoría,  Habilidad, HabilidadOculta, EvolucionaDe, Generación, Foto from pokemon where EvolucionaA  =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						textNombre1.setText(resultSet.getString("Nombre"));
						textIdPK.setText(resultSet.getString("IdPK"));

						v.limpiarfoto();

						JLabel[] foto = new JLabel[1];
						v.verpokedex(table, resultSet.getBlob("Foto"), foto);

						textNombre.setText(null);

					} else {
						JOptionPane.showMessageDialog(null,
								"Este pokemon no tiene evolución previa, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la Pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
				}

			}
		});
		btnEvolucionAnterior.setBounds(25, 271, 98, 14);
		frame.getContentPane().add(btnEvolucionAnterior);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limpiarEvolucion();
				conexion = Conexion.conectar();
				try {

					preparedStatement = conexion.prepareStatement(
							"Select IdPK,Nombre,Peso, Altura, Tipo, Habitat, Categoría,  Habilidad, HabilidadOculta, EvolucionaDe, EvolucionaA, Generación, Foto from pokemon where IdPK =?");
					preparedStatement.setString(1, textNombre.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						limpiarEvolucion();
						textNombre1.setText(resultSet.getString("Nombre"));
						textIdPK.setText(resultSet.getString("IdPK"));

						v.limpiarfoto();

						JLabel[] foto = new JLabel[1];// foto= new
														// JLabel();//v.verpokedex(table,resultSet.getBlob("Foto"));
						v.verpokedex(table, resultSet.getBlob("Foto"), foto);

						textNombre.setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "Pokemón no encontrado, ingrese una nueva búsqueda");
						limpiarbusquedas();
					}
					conexion.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la Pokedex, vuelve a intentarlo más tarde" + e1.getMessage());
				}

			}
		});
		btnBuscar.setBounds(25, 387, 272, 23);
		frame.getContentPane().add(btnBuscar);

		JButton btnCategoría = new JButton("Categor\u00EDa");
		btnCategoría.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Categoría from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						if (textCategoría.getText() == null) {
							textCategoría.setText(resultSet.getString("Categoría"));
						} else {
							textCategoría.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnCategoría.setBounds(360, 121, 89, 23);
		frame.getContentPane().add(btnCategoría);

		JButton btnTipo = new JButton("Tipo");
		btnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Tipo from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						if (textTipo.getText() == null) {
							textTipo.setText(resultSet.getString("Tipo"));
						} else {
							textTipo.setText(null);
						}

					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnTipo.setBounds(360, 87, 89, 23);
		frame.getContentPane().add(btnTipo);

		JButton btnHabilidad = new JButton("Habilidad");
		btnHabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Habilidad from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						if (textHablidad.getText() == null) {
							textHablidad.setText(resultSet.getString("Habilidad"));
						} else {
							textHablidad.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnHabilidad.setBounds(360, 189, 89, 23);
		frame.getContentPane().add(btnHabilidad);

		JButton btnHabilidadOculta = new JButton("Habilidad Oculta");
		btnHabilidadOculta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion
							.prepareStatement("Select HabilidadOculta from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						if (textHabilidadOculta.getText() == null) {
							textHabilidadOculta.setText(resultSet.getString("HabilidadOculta"));
						} else {
							textHabilidadOculta.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnHabilidadOculta.setBounds(311, 230, 138, 23);
		frame.getContentPane().add(btnHabilidadOculta);

		JButton btnHabitat = new JButton("Habitat");
		btnHabitat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Habitat from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						if (textHabitat.getText() == null) {
							textHabitat.setText(resultSet.getString("Habitat"));
						} else {
							textHabitat.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnHabitat.setBounds(360, 155, 89, 23);
		frame.getContentPane().add(btnHabitat);

		JButton btnGeneración = new JButton("Generación");
		btnGeneración.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Generación from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						int Id = Integer.parseInt(textIdPK.getText());
						if (textGeneración.getText() == null) {
							if (Id < 151) {
								textGeneración.setText("Primera");
							} else if ((151 < Id) && (Id < 251)) {
								textGeneración.setText("Segunda");
							} else if ((251 < Id) && (Id < 386)) {
								textGeneración.setText("Tercera");
							} else if ((386 < Id) && (Id < 493)) {
								textGeneración.setText("Cuarta");
							} else if ((493 < Id) && (Id < 649)) {
								textGeneración.setText("Quinta");
							} else if ((649 < Id) && (Id < 721)) {
								textGeneración.setText("Sexta");
							} else if ((721 < Id) && (Id < 809)) {
								textGeneración.setText("Septima");
							} else if ((809 < Id) && (Id < 898)) {
								textGeneración.setText("Octava");
							}
						}

						else {
							textGeneración.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnGeneración.setBounds(337, 267, 112, 23);
		frame.getContentPane().add(btnGeneración);

		JButton btnPeso = new JButton("Peso");
		btnPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Peso from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						if (textPeso.getText() == null) {
							textPeso.setText(resultSet.getString("Peso"));
						} else {
							textPeso.setText(null);
						}

					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnPeso.setBounds(360, 22, 89, 23);
		frame.getContentPane().add(btnPeso);

		JButton btnAltura = new JButton("Altura");
		btnAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion.prepareStatement("Select Altura from pokemon where Nombre =?");
					preparedStatement.setString(1, textNombre1.getText());
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						if (textAltura.getText() == null) {
							textAltura.setText(resultSet.getString("Altura"));
						} else {
							textAltura.setText(null);
						}
					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null,
							"Ocurrió un error en la pokedex, vuelve a intentarlo más tarde" + e2.getMessage());
				}
			}
		});
		btnAltura.setBounds(360, 56, 89, 23);
		frame.getContentPane().add(btnAltura);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarbusquedas();
			}
		});
		btnLimpiar.setBounds(360, 387, 89, 23);
		frame.getContentPane().add(btnLimpiar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(529, 387, 89, 23);
		frame.getContentPane().add(btnSalir);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(25, 11, 21, 14);
		frame.getContentPane().add(lblID);

		JLabel lblNombrePokemon = new JLabel("Nombre:");
		lblNombrePokemon.setBounds(104, 11, 54, 14);
		frame.getContentPane().add(lblNombrePokemon);

		textIdPK = new JLabel();
		textIdPK.setHorizontalAlignment(SwingConstants.RIGHT);
		textIdPK.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textIdPK.setEditable(false);
		textIdPK.setBounds(46, 6, 35, 20);
		frame.getContentPane().add(textIdPK);
		// textIdPK.setColumns(10);

		textNombre1 = new JLabel();
		textNombre1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textNombre1.setEditable(false);
		textNombre1.setBounds(168, 8, 129, 20);
		frame.getContentPane().add(textNombre1);
		// textNombre1.setColumns(10);

		textTipo = new JLabel();
		textTipo.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textTipo.setEditable(false);
		textTipo.setBounds(459, 88, 159, 20);
		frame.getContentPane().add(textTipo);
		// textTipo.setColumns(10);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setEnabled(false);
		table.setBounds(25, 57, 233, 163);
		frame.getContentPane().add(table);

		textPeso = new JLabel();
		// textPeso.setSelectionColor(Color.WHITE);
		// textPeso.setEditable(false);
		textPeso.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textPeso.setColumns(10);
		textPeso.setBounds(459, 23, 159, 20);
		frame.getContentPane().add(textPeso);

		textAltura = new JLabel();
		// textAltura.setEditable(false);
		textAltura.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textAltura.setColumns(10);
		textAltura.setBounds(459, 57, 159, 20);
		frame.getContentPane().add(textAltura);

		textCategoría = new JLabel();
		textCategoría.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textCategoría.setEditable(false);
		// textCategoría.setColumns(10);
		textCategoría.setBounds(459, 122, 159, 20);
		frame.getContentPane().add(textCategoría);

		textHabitat = new JLabel();
		textHabitat.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textHabitat.setEditable(false);
		// textHabitat.setColumns(10);
		textHabitat.setBounds(459, 156, 159, 20);
		frame.getContentPane().add(textHabitat);

		textHablidad = new JLabel();
		textHablidad.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textHablidad.setEditable(false);
		// textHablidad.setColumns(10);
		textHablidad.setBounds(459, 190, 159, 20);
		frame.getContentPane().add(textHablidad);

		textHabilidadOculta = new JLabel();
		textHabilidadOculta.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textHabilidadOculta.setEditable(false);
		// textHabilidadOculta.setColumns(10);
		textHabilidadOculta.setBounds(459, 231, 159, 20);
		frame.getContentPane().add(textHabilidadOculta);

		textGeneración = new JLabel();
		// textGeneración.setEditable(false);
		textGeneración.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		// textGeneración.setColumns(10);
		textGeneración.setBounds(459, 268, 159, 20);
		frame.getContentPane().add(textGeneración);

		JLabel lblEvolución = new JLabel("\u00BFEvoluciona?");
		lblEvolución.setBounds(99, 234, 112, 14);
		frame.getContentPane().add(lblEvolución);

	}
}
