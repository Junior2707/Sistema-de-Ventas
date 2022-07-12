package SistemaVentas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
//import javax.swing.*; para importar todas las librerias
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Inicio {
	JFrame inicio = new JFrame();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField();
	JButton b1 = new JButton();
	String Nom = "";
	String cod = "";
	int id = 0;
	int contador = 3;
	
	Object [][] datos_tabla = new Object[400][3];
	
	public void frame() {
		inicio.setTitle("Login");
		//setSize(200,150)
		//setbounds(x,y,ancho,alto)
		inicio.setBounds(250,250,400,400);
		inicio.setLocationRelativeTo(null);
		inicio.setResizable(false);
		inicio.setVisible(true);
		
		//Darle color y tamaño al panel
		p1.setBackground(Color.red);
		p1.setBounds(250,250,400,400);
		p1.setLayout(null);
		//Codigo para agregar algo a un JFrame
		//En este caso estamos agregando un panel
		inicio.add(p1);
		
		
	}

	public void etiquetas() {
		//Etiqueta usuarios
		l1.setText("Usuarios:");
		l1.setBounds(50,50,100,80);
		l1.setFont(new Font("Sergi", Font.PLAIN, 15));
		l1.setVisible(true);
		p1.add(l1);
		//Etiqueta contraseña
		l2.setText("Contraseña:");
		l2.setBounds(50,75,100,80);
		l2.setFont(new Font("Sergi", Font.PLAIN, 15));
		l2.setVisible(true);
		p1.add(l2);
		
		//JTextfield usuario
		t1.setBounds(150,80,100,20);
		t1.setVisible(true);
		p1.add(t1);
		
		//textfield contraseña
		t2.setBounds(150,105,100,20);
		t2.setVisible(true);
		p1.add(t2);
	}
	
	public void botones() {
		b1.setText("Ingresar");
		b1.setFont(new Font("Sergi", Font.PLAIN, 15));
		b1.setBounds(150,150,100,20);
		b1.setVisible(true);
		p1.add(b1);
		
		//Funcionalidad
		ActionListener ingresar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//Lo que hace el boton	
			if(t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
				System.out.println("Ingreso correctamente");
				inicio.setVisible(false);
				Menu_Principal mp = new Menu_Principal();
				try {
					mp.ej_menup();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				try {
					validar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		};
		//Acion del evento
		b1.addActionListener(ingresar);
		
	}
	
	public void validar() throws ClassNotFoundException {
		int filas = 0;
		int id = 0;

		boolean val = false;
		//Validar si los textfields tienen contenido
		if(t1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe colocar su usuario");
		}else if(t2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe colocar su contraseña");
		}
		//Codigo para cargar los datos de la base a nuestro object
		VendedoresDAO rp = new VendedoresDAO();
		List<DatosVendedores> lista = rp.listarUsuario();
		//for para saber el tamaño
		for(int i = 0; i < lista.size();i++) {
			//System.out.println(lista.get(i).getNombre());
			filas++;
		}
		//for para llenar el object
		for(int i = 0; i<lista.size(); i++) {
			datos_tabla [i][0] = lista.get(i).getNombre();
			datos_tabla [i][1] = lista.get(i).getCodigo();
		}
		//for para validar el login
		for(int i = 0; i < datos_tabla.length;i++) {
			if(t1.getText().equals(datos_tabla[i][0]+"")&& t2.getText().equals(datos_tabla[i][1]+"")) {
				id = lista.get(i).getCodigo();
				
				contador = 3;
				val = false;
				modulo_vendedor u = new modulo_vendedor();
				inicio.setVisible(false);
				u.ej_modulo(id);
				break;
			}else {
				val = true;
			}
		}
		if(val == true) {
			contador--;
			JOptionPane.showMessageDialog(null, "Datos Incorrectos, te quedan " + contador + " oportunidades");
			if(contador == 0) {
				JOptionPane.showMessageDialog(null, "El programa se cerrara");
				System.exit(0);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inicio p1 = new Inicio();
		conectar c = new conectar();
		c.Conectar();
		p1.frame();
		p1.etiquetas();
		p1.botones();
	}

}
