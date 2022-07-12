package SistemaVentas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Menu_Principal {

	JFrame principal = new JFrame();
	
	JTabbedPane pestañas = new JTabbedPane();
	JTabbedPane pestañas1 = new JTabbedPane();
	
	//Paneles para pestañas
	JPanel sucursales = new JPanel();
	JPanel clientes = new JPanel();
	JPanel vendedores = new JPanel();
	JPanel productos = new JPanel();
	JTextField t1 = new JTextField();
	JButton bt = new JButton();
	static int pest;
	
	menu_sucursales sm = new menu_sucursales();
	menu_productos pm = new menu_productos();
	menu_clientes cm = new menu_clientes();
	menu_vendedores vm = new menu_vendedores();
	modulo_vendedor mv = new modulo_vendedor();
	
	private void valores_iniciales() throws ClassNotFoundException {
		
		
		principal.setTitle("Administrador");
		//setSize(200,150)
		//setbounds(x,y,ancho,alto)
		principal.setBounds(250,250,800,600);
		principal.setLocationRelativeTo(null);
		principal.setResizable(false);
		principal.setVisible(true);
		principal.add(pestañas);
		//Añadir color al paneñas
		sucursales.setBackground(Color.cyan);
		clientes.setBackground(Color.cyan);
		vendedores.setBackground(Color.cyan);
		productos.setBackground(Color.cyan);
	
		
		//Pestañas
		pestañas.addTab("Sucursales", sucursales);
		pestañas.addTab("Productos", productos);
		pestañas.addTab("Clientes", clientes);
		pestañas.addTab("Vendedores", vendedores);
		
		//Pestaña sucursales
		sm.ej_sucursales();
		sucursales.add(sm.bt_crear);
		sucursales.add(sm.bt_carga);
		sucursales.add(sm.bt_actualizar);
		sucursales.add(sm.bt_eliminar);
		sucursales.add(sm.bt_pdf);
		sucursales.setLayout(null);
		
		//Mandar a llamar tabla
		sucursales.add(sm.scroll);
		
		sucursales.setLayout(null);
		
		
		//////////////No me dio tiempo asi que agregue el modulo de vendedor en este boton :))
		/*ActionListener modulo_vendedores= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//Lo que hace el boton	
			principal.setVisible(false);
			try {
				mv.ej_modulo();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			iframe.setBounds(15,50,750,500);
			iframe.setResizable(false);
			iframe.setVisible(true);
			secundario.getContentPane().add(iframe);
			//secundario.add(pestañas1);
			//nueva_v.setLayout(null);
			//pestañas1.addTab("Nueva Ventana", nueva_v);
			//pestañas1.addTab("Ventas", ventas);
			
			mv.ej_modulo();
			nueva_v.add(mv.label1);
			nueva_v.add(mv.label2);
			nueva_v.add(mv.label3);
			nueva_v.add(mv.label4);
			nueva_v.add(mv.t1);
			nueva_v.add(mv.t2);
			nueva_v.add(mv.label5);
			
			}
		};
		cerrar.addActionListener(modulo_vendedores);*/
		
		//pestaña productos
		pm.ej_productos();
		productos.add(pm.bt_crear);
		productos.add(pm.bt_carga);
		productos.add(pm.bt_actualizar);
		productos.add(pm.bt_eliminar);
		productos.add(pm.bt_pdf);
		productos.setLayout(null);
		productos.add(pm.scroll);
		JButton cerrar1 = new JButton("Cerrar Sesion");
	
		productos.add(cerrar1);
		productos.setLayout(null);
		
		//pestaña clientes
		cm.ej_clientes();
		clientes.add(cm.bt_crear);
		clientes.add(cm.bt_carga);
		clientes.add(cm.bt_actualizar);
		clientes.add(cm.bt_eliminar);
		clientes.add(cm.bt_pdf);
		clientes.setLayout(null);
		clientes.add(cm.scroll);
		JButton cerrar2 = new JButton("Cerrar Sesion");
	
		clientes.add(cerrar2);
		clientes.setLayout(null);
		
		//pestaña vendedores
		vm.ej_vendedores();
		vendedores.add(vm.bt_crear);
		vendedores.add(vm.bt_carga);
		vendedores.add(vm.bt_actualizar);
		vendedores.add(vm.bt_eliminar);
		vendedores.add(vm.bt_pdf);
		vendedores.setLayout(null);
		vendedores.add(vm.scroll);
		JButton cerrar3 = new JButton("Cerrar Sesion");

		vendedores.add(cerrar3);
		vendedores.setLayout(null);
	}	
	
	public void ej_menup() throws ClassNotFoundException {
		valores_iniciales();
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Menu_Principal menu = new Menu_Principal();
		menu.valores_iniciales();
	}
}