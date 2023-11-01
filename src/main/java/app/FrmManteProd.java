package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Citas;
import model.Servicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JComboBox cboServicios;
	private JTextField txtFecha;
	private JTextField txtDueño;
	private JTextField txtMascota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Num Cita:");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboServicios = new JComboBox();
		cboServicios.setBounds(122, 130, 86, 22);
		contentPane.add(cboServicios);

		JLabel lblCategora = new JLabel("Mascota");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Fecha :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(122, 42, 144, 20);
		contentPane.add(txtFecha);

		JLabel lblStock = new JLabel("Nombre Dueño:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtDueño = new JTextField();
		txtDueño.setColumns(10);
		txtDueño.setBounds(122, 103, 77, 20);
		contentPane.add(txtDueño);

		JLabel lblPrecio = new JLabel("Servicio");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtMascota = new JTextField();
		txtMascota.setColumns(10);
		txtMascota.setBounds(122, 71, 77, 20);
		contentPane.add(txtMascota);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
	}

	void llenaCombo() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
		EntityManager manager = fabrica.createEntityManager();
		
		//select from tb_xxxx
	
				String sql = "select c from Servicio c";
				List<Servicio> lstServicio = manager.createQuery(sql, Servicio.class).getResultList();
				//recorrer y mostrar
				cboServicios.addItem("Selectione..");
				for(Servicio c : lstServicio) {
					
					cboServicios.addItem(c.getNom_servicio());
					
					
				}
				
				//select from tb_xxxx
				
				
				
				
				manager.close();
	}

	void registrar() {
		// TODO Auto-generated method stub
		//lamar a la conexion
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
				//crear un manejador de las entidades
				EntityManager manager = fabrica.createEntityManager();
				
				 int num_cita  = Integer.parseInt(txtCodigo.getText());
				
				 String fecha = txtFecha.getText() ;
				 String nom_dueño = txtDueño.getText() ;
				 String nom_mascota = txtMascota.getText() ;
				 int cod_servicio = cboServicios.getSelectedIndex();
				 
				Citas p =new Citas();
				p.setNum_cita(num_cita);
				p.setFecha(fecha);
				p.setNom_dueño(nom_dueño);
				p.setNom_mascota(nom_mascota);
				p.setCod_servicio(cod_servicio);
				
				
				
				try {
					//si queremos reqistrar, actualizar o eliminar
					manager.getTransaction().begin();
					manager.persist(p);
					manager.getTransaction().commit();
					aviso("registro ok");
				} catch (Exception e) {
					// TODO: handle exception
					aviso("Error: Al gravar, verificar datos ingresados \n" + e.getCause().getMessage());
				}
				manager.close();
	}
	void aviso(String algo) {
		JOptionPane.showMessageDialog(this, algo, "Aviso del sistema", JOptionPane.INFORMATION_MESSAGE);
	}

	void listado() {
		//lamar a la conexion
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("repaso");
			
				EntityManager manager = fabrica.createEntityManager();
				
				//select from tb_xxxx
			
						String sql = "select p from Citas p";
						List<Citas> lstCitas = manager.createQuery(sql, Citas.class).getResultList();
						//recorrer y mostrar
						
						for(Citas p : lstCitas) {
							imprimir("Citas..:" + p.getNum_cita());
							imprimir("Fecha..:" + p.getFecha() );
							imprimir("Dueño..:" + p.getNom_dueño()) ;
							imprimir("Mascota.......:" + p.getNom_mascota());
							imprimir("CodServicio....:" + p.getCod_servicio());
							
						}
						
						
						
						manager.close();
						
		
	}
	void imprimir(String algo) {
		txtSalida.append(algo + "\n");
	}
	
	void buscar() {
		// TODO Auto-generated method stub
		
	}
	
}
