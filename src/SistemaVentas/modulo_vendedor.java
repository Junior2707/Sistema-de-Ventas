package SistemaVentas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class modulo_vendedor {
	JFrame principal = new JFrame();
	
	JTabbedPane pestañas = new JTabbedPane();
	//Paneles para pestañas
	JPanel nuevaVenta = new JPanel();
	JPanel seccion1 = new JPanel();
	JPanel seccion2 = new JPanel();
	JPanel seccion3 = new JPanel();
	JPanel ventas = new JPanel();
	
	//hacer instancias
	ventanaVentas Vv = new ventanaVentas();
	ventanaVentasDos vDos = new ventanaVentasDos();
	
	public void inicio() throws ClassNotFoundException {
		principal.setTitle("Administrador");
		//setbounds(x,y,ancho,alto)
		principal.setBounds(250,250,800,710);
		principal.setLocationRelativeTo(null);
		principal.setResizable(false);
		principal.setVisible(true);
		principal.add(pestañas);
		//Añadir color al paneñas
		nuevaVenta.setBackground(Color.cyan);
		ventas.setBackground(Color.cyan);
		// agregar Pestañas
		pestañas.addTab("Nueva Venta", nuevaVenta);
		pestañas.addTab("Ventas", ventas);
		
		
		
		//Agregar secciones a las pestañas
		seccion1.setBounds(10,10, 760,250);
		seccion1.setBackground(Color.white);
		nuevaVenta.add(seccion1);
		
		seccion2.setBounds(10,270, 760,360);
		seccion2.setBackground(Color.white);
		nuevaVenta.add(seccion2);

		seccion3.setBounds(10,10, 760,625);
		seccion3.setBackground(Color.white);
		ventas.add(seccion3);
		
		seccion1.setLayout(null);
		seccion2.setLayout(null);
		seccion3.setLayout(null);
		nuevaVenta.setLayout(null);
		ventas.setLayout(null);
		//////////////prestaña nueva venta
		Vv.ej_ventas();
		//agregar labels
		seccion1.add(Vv.label1);
		seccion1.add(Vv.label2);
		seccion1.add(Vv.label3);
		seccion1.add(Vv.label4);
		seccion1.add(Vv.label5);
		seccion1.add(Vv.label6);
		seccion1.add(Vv.label7);
		seccion1.add(Vv.label8);
		seccion2.add(Vv.label9);
		seccion2.add(Vv.label10);
		seccion2.add(Vv.label11);
		seccion2.add(Vv.label12);
		seccion2.add(Vv.label13);
		seccion2.add(Vv.label14);
		seccion2.add(Vv.label15);
		seccion2.add(Vv.label16);
		/////
		seccion1.add(Vv.t1);
		seccion1.add(Vv.t2);
		seccion1.add(Vv.t3);
		seccion1.add(Vv.t4);
		seccion1.add(Vv.t5);
		seccion2.add(Vv.t6);
		seccion2.add(Vv.t7);
		seccion2.add(Vv.t8);
		seccion1.add(Vv.filtro);
		//
		seccion1.add(Vv.b1);
		seccion1.add(Vv.b2);
		seccion2.add(Vv.b3);
		seccion2.add(Vv.b4);
		seccion2.add(Vv.scroll);
		//agregar textfields
		
		//////////////pestaña ventas
		vDos.ej_ventasDos();
		//agregar labels
		seccion3.add(vDos.label1);
		seccion3.add(vDos.label2);
		seccion3.add(vDos.label3);
		seccion3.add(vDos.label4);
		seccion3.add(vDos.label5);
		seccion3.add(vDos.label6);
		seccion3.add(vDos.label7);
		seccion3.add(vDos.label8);
		//
		seccion3.add(vDos.t1);
		seccion3.add(vDos.t2);
		seccion3.add(vDos.t3);
		seccion3.add(vDos.t4);
		//
		seccion3.add(vDos.b1);
		//
		seccion3.add(vDos.scroll);
	}

	public void ej_modulo(int id) throws ClassNotFoundException {
		inicio();
	}
}
