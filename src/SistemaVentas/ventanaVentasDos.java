package SistemaVentas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ventanaVentasDos {
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	//text 
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	//
	JButton b1 = new JButton();
	//
	JScrollPane scroll;
	//
	Object [][] clientes = new Object[100][5];
	String [] resultados = new String[100];
	Object [][] agregar_p = new Object[30][5];
	
	public void inicio() {
		label1.setText("Listado General:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(10,10,300,25);
		//////
		label2.setText("Filtrar por: ");
		label2.setBounds(40,50,200,25);
		//////
		label3.setText("No. Factura: ");
		label3.setBounds(130,50,75,25);
		t1.setBounds(210,50,200,25);
		//////
		label4.setText("Nombre: ");
		label4.setBounds(150,90,75,25);
		t2.setBounds(210,90,200,25);
		/////
		label5.setText("Nit: ");
		label5.setBounds(430,50,75,25);
		t3.setBounds(490,50,200,25);
		/////
		label6.setText("Fecha: ");
		label6.setBounds(430,90,75,25);
		t4.setBounds(490,90,200,25);
		///////
		label7.setText("Filtrados: ");
		label7.setBounds(40,180,75,25);
		
		//t5.setBounds(210,180,200,25);
		//filtro.setBounds(210,180,200,25);
		//
		b1.setText("Aplicar Filtro");
		b1.setBounds(150,130,540,25);
		b1.setVisible(true);
		//
		String [] datos = {"No. Factura", "Nit", "Nombre","Fecha","Total"};
		JTable tabla = new JTable(agregar_p,datos); 
		scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 220, 740, 390);
		
	}
	public void ej_ventasDos() throws ClassNotFoundException {
		inicio();
	}
}
