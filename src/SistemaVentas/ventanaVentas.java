package SistemaVentas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ventanaVentas {
	JFrame principal = new JFrame();
	
	JTabbedPane pestañas = new JTabbedPane();
	JTabbedPane pestañas1 = new JTabbedPane();
	//Paneles para pestañas
	JPanel NuevaVenta = new JPanel();
	JPanel Ventas = new JPanel();
	JPanel fondo1 = new JPanel();	
	JPanel fondo2 = new JPanel(); 
	JPanel fondo3 = new JPanel(); 
	JScrollPane scroll;
	
	//cajas de texto y labels
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	JTextField t8 = new JTextField();
	//LABELS parte 1
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	////Parte dos
	JLabel label9 = new JLabel();
	JLabel label10 = new JLabel();
	JLabel label11 = new JLabel();
	JLabel label12= new JLabel();
	JLabel label13 = new JLabel();
	JLabel label14 = new JLabel();
	JLabel label15 = new JLabel();
	JLabel label16 = new JLabel();
	//////Botones
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	Object [][] clientes = new Object[100][5];
	String [] resultados = new String[100];
	Object [][] agregar_p = new Object[10][6];
	JComboBox filtro = new JComboBox(resultados);
	
	Object [][] productos = new Object[200][5];
	//Object [][] datos_tabla = new Object[200][5];
	int p = 0;
	int total = 0;
	int idVenta = 0;

	public void botones() {
		ActionListener agregar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//boton_validar();
				agregar();
		}
	};
		//Acion del evento
		b3.addActionListener(agregar);
	}

	public void agregar() {
		int filas = 0;
		ProductosDAO rp = new ProductosDAO();
		List<DatosProductos> lista = rp.listarUsuario();
		//for para saber el tamaño
		for(int i = 0; i < lista.size();i++) {
			//System.out.println(lista.get(i).getNombre());
			filas++;
		}
		//Object [][] datos_tabla = new Object[50][5];
		//for para llenar el object
		for(int i = 0; i<lista.size(); i++) {
			productos[i][0] = lista.get(i).getCodigo();
			productos[i][1] = lista.get(i).getNombre();
			productos[i][2] = lista.get(i).getDescripcion();
			productos[i][3] = lista.get(i).getCantidad();
			productos[i][4] = lista.get(i).getPrecio();
		}
		int cantidad = Integer.parseInt(t7.getText());
	
		for(int i = 0; i<lista.size(); i++) {
			if(t6.getText().equals(productos[i][0]+"")) {
				int precio = Integer.parseInt(productos[i][4]+"");
				agregar_p[p][0] = productos[i][0]+"";
				agregar_p[p][1] = productos[i][1]+"";
				agregar_p[p][2] = cantidad;
				agregar_p[p][3] = precio;
				agregar_p[p][4] = precio*cantidad;
				total = total+(precio*cantidad);
				JOptionPane.showMessageDialog(null, "Se agrego correctamente");
				t8.setText(total+"");
				p++;
				break;	
			}
			
		}
	}
	
	public void inicio() {
/////////Seleccionar cliente
		label1.setText("Seleccionar al Cliente:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(10,10,300,25);
		//////
		label2.setText("Filtrar por: ");
		label2.setBounds(40,50,200,25);
		//////
		label3.setText("Nombre: ");
		label3.setBounds(150,50,75,25);
		t1.setBounds(210,50,200,25);
		//////
		label4.setText("Correo: ");
		label4.setBounds(150,90,75,25);
		t2.setBounds(210,90,200,25);
		/////
		label5.setText("Nit: ");
		label5.setBounds(430,50,75,25);
		t3.setBounds(490,50,200,25);
		/////
		label6.setText("Genero: ");
		label6.setBounds(430,90,75,25);
		t4.setBounds(490,90,200,25);
		///////
		label7.setText("Filtrados: ");
		label7.setBounds(40,180,75,25);
		label8.setText("Cliente: ");
		label8.setBounds(150,180,75,25);
		//t5.setBounds(210,180,200,25);
		filtro.setBounds(210,180,200,25);
		
		b1.setText("Aplicar Filtro");
		b1.setBounds(150,130,540,25);
		b1.setVisible(true);
		////////////
		b2.setText("Nuevo Cliente");
		b2.setBounds(490,180,200,25);
		b2.setVisible(true);
		
		//////Agregar productos
		label9.setText("Agregar Productos");
		label9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label9.setBounds(10,10,300,25);
		//
		label10.setText("Fecha: ");
		label10.setBounds(350,10,100,25);
		//Para sacar la fecha
	
		//LocalDate hoy = LocalDate.now();
		//label11.setText(sdf.format(hoy));
		label11.setText("No me funciono");
		label11.setBounds(400,10,100,25);
		//
		label12.setText("No.");
		label12.setBounds(600,10,100,25);
		//
		label13.setText("1");
		label13.setBounds(660,10,100,25);
		//
		label14.setText("Codigo");
		label14.setBounds(50,50,75,25);
		t6.setBounds(100,50,150,25);
		//
		label15.setText("Cantidad");
		label15.setBounds(280,50,75,25);
		t7.setBounds(345,50,150,25);
		//
		b3.setText("Agregar");
		b3.setBounds(560,50,150,25);
		b3.setVisible(true);
		//
		label16.setText("Total: ");
		label16.setBounds(550,310,75,25);
		t8.setBounds(590,310,150,25);
		t8.setText(total+"");
		
		
		b4.setText("Vender");
		b4.setBounds(30,310,500,25);
		b4.setBackground(Color.green);
		b4.setVisible(true);
		
		
		
		ActionListener vender = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentasDAO p = new VentasDAO();
				//p.insertar(idVentas, t2.getText(),t3.getText(),Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()));
				JOptionPane.showMessageDialog(null, "Se creo correctamente");
			}
		};
		//Acion del evento
		b4.addActionListener(vender);
		
		String [] datos = {"Codigo", "Nombre", "Cantidad","Precio","Subtotal"};
		JTable tabla = new JTable(agregar_p,datos); 
		scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 90, 740, 183);
		
		//Agregar el contenido al panel nueva venta
		//Labels
	
		//textsfields
		fondo1.add(t1);
		fondo1.add(t2);
		fondo1.add(t3);
		fondo1.add(t4);
		fondo1.add(t5);
		fondo2.add(t6);
		fondo2.add(t7);
		fondo2.add(t8);
		fondo1.add(filtro);
		//botones
		fondo1.add(b1);
		fondo1.add(b2);
		fondo2.add(b3);
		fondo2.add(b4);
		fondo2.add(scroll);
		
		fondo1.setLayout(null);
		fondo2.setLayout(null);
		
	}
	
	public void ej_ventas() throws ClassNotFoundException {
		inicio();
		botones();
	}
	
}
