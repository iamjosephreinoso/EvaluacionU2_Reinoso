package ec.edu.ups.EvaluacionU2_ReinosoClienteWeb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.EvaluacionU2_Reinoso.business.VehiculoONRemote;
import ec.edu.ups.EvaluacionU2_Reinoso.model.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JRadioButton btnMarca;
	private JRadioButton btnModelo;
	private JRadioButton btnAnio;
	private JTextArea txtResultados;
	private VehiculoONRemote veh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscar frame = new VentanaBuscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public VentanaBuscar() throws Exception {
		conectar();
		AgregarVehiculo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Vehiculo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 10, 244, 19);
		contentPane.add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(21, 44, 96, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		btnBuscar.setBounds(171, 43, 85, 21);
		contentPane.add(btnBuscar);
		
		btnMarca = new JRadioButton("Marca");
		btnMarca.setBounds(21, 82, 103, 21);
		contentPane.add(btnMarca);
		
		btnModelo = new JRadioButton("Modelo");
		btnModelo.setBounds(126, 82, 103, 21);
		contentPane.add(btnModelo);
		
		btnAnio = new JRadioButton("A\u00F1o");
		btnAnio.setBounds(253, 82, 103, 21);
		contentPane.add(btnAnio);
		
		txtResultados = new JTextArea();
		txtResultados.setBounds(21, 109, 386, 499);
		contentPane.add(txtResultados);
	}
	
	public void Buscar() {
	
		boolean bandera = false;
		txtResultados.setText("");
		String buscar = txtBuscar.getText();
		List<Vehiculo> listado = veh.getList();
		if(btnMarca.isSelected()) {
			for (int i = 0;i<listado.size();i++) {
				if(listado.get(i).getMarca().equalsIgnoreCase(buscar)) {
					txtResultados.append(listado.get(i).getPlaca()+"\n");
					txtResultados.append(listado.get(i).getModelo()+"\n");
					txtResultados.append(listado.get(i).getMarca()+"\n");
					txtResultados.append(listado.get(i).getAnio()+"\n");
					bandera = true;
					txtResultados.append("----------------- \n");
				}
				
			}
		}else if (btnModelo.isSelected()) {
			for (int i = 0;i<listado.size();i++) {
				if(listado.get(i).getModelo().equalsIgnoreCase(buscar)) {
					txtResultados.append(listado.get(i).getPlaca()+"\n");
					txtResultados.append(listado.get(i).getModelo()+"\n");
					txtResultados.append(listado.get(i).getMarca()+"\n");
					txtResultados.append(listado.get(i).getAnio()+"\n");
					bandera = true;
					txtResultados.append("----------------- \n");
				}
				
			}
		}else if (btnAnio.isSelected()) {
			for (int i = 0;i<listado.size();i++) {
				if(listado.get(i).getAnio().equalsIgnoreCase(buscar)) {
					txtResultados.append(listado.get(i).getPlaca()+"\n");
					txtResultados.append(listado.get(i).getModelo()+"\n");
					txtResultados.append(listado.get(i).getMarca()+"\n");
					txtResultados.append(listado.get(i).getAnio()+"\n");
					bandera = true;
					txtResultados.append("-----------------");
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "No selecciono ninguna opcion");
		}
		if(bandera == false) {
			JOptionPane.showMessageDialog(null, "No hay resultados");
		}
	}
	public void AgregarVehiculo() {
		Vehiculo v = new Vehiculo();
		v.setPlaca("ABA1000");
		v.setMarca("Hyundai");
		v.setModelo("I10");
		v.setAnio("2012");
		veh.insertar(v);
		Vehiculo v2 = new Vehiculo();
		v2.setPlaca("ABB1001");
		v2.setMarca("Hyundai");
		v2.setModelo("Tucson");
		v2.setAnio("2016");
		veh.insertar(v2);
		Vehiculo v3 = new Vehiculo();
		v3.setPlaca("BBB1201");
		v3.setMarca("Chevrolet");
		v3.setModelo("LUV DMAX");
		v3.setAnio("2021");
		veh.insertar(v3);
		Vehiculo v4 = new Vehiculo();
		v4.setPlaca("BBB3201");
		v4.setMarca("JAC");
		v4.setModelo("T8");
		v4.setAnio("2021");
		veh.insertar(v4);
	}
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demo");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demo");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/EvaluacionU2_Reinoso/VehiculoON!ec.edu.ups.EvaluacionU2_Reinoso.business.VehiculoONRemote";  
              
            this.veh = (VehiculoONRemote) context.lookup(lookupName);  
             
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
