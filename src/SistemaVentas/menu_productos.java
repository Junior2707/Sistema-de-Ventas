package SistemaVentas;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class menu_productos {
	//Creando la tabla
		JTable tbl;
		JScrollPane scroll;
		//Creando los botones
		JButton bt_crear = new JButton();
		JButton bt_carga = new JButton();
		JButton bt_actualizar = new JButton();
		JButton bt_eliminar = new JButton();
		JButton bt_pdf = new JButton();
		JButton bt_refresh = new JButton();
		int suma = 0;
		int validar = 0;
		//Matrices
		Object [][] productos = new Object[200][5];
		Object [][] datos_tabla = new Object[200][5];
		
		
		////Metodo para crear botones
		private void boton() {
			////Boton crear
			bt_crear.setText("Crear");
			bt_crear.setBounds(550,100,100,50);
			ActionListener funcion_crear = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
				crear();
				}
			};
			bt_crear.addActionListener(funcion_crear);
			
			//Boton carga masiva
			bt_carga.setText("Carga");
			bt_carga.setBounds(650,100,100,50);
			ActionListener funcion_cargar = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
				carga_masiva();
				}
			};
			//Acion del evento
			bt_carga.addActionListener(funcion_cargar);
			
			/////Boton Actualizar datos
			bt_actualizar.setText("Actualizar");
			bt_actualizar.setBounds(550,150,100,50);
			ActionListener funcion_actualizar = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
				actualizar();
				}
			};
			//Acion del evento
			bt_actualizar.addActionListener(funcion_actualizar);
			/////boton eliminar
			bt_eliminar.setText("Eliminar");
			bt_eliminar.setBounds(650,150,100,50);
			ActionListener funcion_eliminar = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
					try {
						eliminar();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			//Acion del evento
			bt_eliminar.addActionListener(funcion_eliminar);
		
			bt_pdf.setText("Generar Pdf");
			bt_pdf.setBounds(550,200,200,50);
			ActionListener funcion_pdf = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
					try {
						exportar_pdf();
					} catch (FileNotFoundException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			//Acion del evento
			bt_pdf.addActionListener(funcion_pdf);
			
			
			
		}

		private void exportar_pdf() throws FileNotFoundException, DocumentException {
			
			FileOutputStream pdf = new FileOutputStream("producto.pdf");
			Document documento = new Document();
			
			PdfWriter.getInstance(documento, pdf);
			documento.open();
			
			Paragraph parrafo = new Paragraph("producto");
			parrafo.setAlignment(1);
			documento.add(parrafo);
			documento.add(new Paragraph("\n"));
			
			for(int i = 0; i < productos.length; i++) {
				if(productos[i][0] == null) {
					break;
				}else {
					documento.add(new Paragraph(("Codigo: ") +productos[i][0]));
					documento.add(new Paragraph(("Nombre: ") + productos[i][1]));
					documento.add(new Paragraph(("Descripcion: ") + productos[i][2]));
					documento.add(new Paragraph(("Cantidad: ") + productos[i][3]));
					documento.add(new Paragraph(("Precio: ") + productos[i][4]));
					documento.add(new Paragraph("\n\n"));
				}
			}
			documento.close();
			JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
			try {
				
				File productos_doc = productos_doc = new File("producto.pdf");
				Desktop.getDesktop().open(productos_doc);
			}catch(Exception e) {
				
			}
		}
		
		private void eliminar() throws IOException {
			int x = tbl.getSelectedRow();
			int id = x;
			//Validar que tenga seleccionada una fila
			if(x == -1 || productos[x][0]== null ) {
				JOptionPane.showMessageDialog(null, "Debe de seleccionar un producto");
			}else if(productos[x][0] != null) {
				//Eliminar el dato seleccionado
				int reply = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto","Pregunta", JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION) {
					ProductosDAO p = new ProductosDAO();
					List<DatosProductos> lista = p.listarUsuario();
					id = lista.get(id).getCodigo();
					p.delete(id);
					JOptionPane.showMessageDialog(null, "Se elimino correctamente");
					//elimi.setVisible(false);
				}
			}
			tbl.clearSelection();
		}
		
		private void tabla() throws ClassNotFoundException {
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
				datos_tabla [i][0] = lista.get(i).getCodigo();
				datos_tabla [i][1] = lista.get(i).getNombre();
				datos_tabla [i][2] = lista.get(i).getDescripcion();
				datos_tabla [i][3] = lista.get(i).getCantidad();
				datos_tabla [i][4] = lista.get(i).getPrecio();
			}
			for(int i = 0; i<lista.size(); i++) {
				productos[i][0] =  datos_tabla [i][0];
				productos[i][1] =  datos_tabla [i][1];
				productos[i][2] =  datos_tabla [i][2];
				productos[i][3] =  datos_tabla [i][3];
				productos[i][4] =  datos_tabla [i][4];
			}
			String [] datos = {"Codigo", "Nombre", "Descripcion","Cantidad","Precio"};
			tbl = new JTable(datos_tabla,datos); 
			scroll = new JScrollPane(tbl);
			scroll.setBounds(10, 10, 500, 510);;
		}

		private String leerarchivo(){
			JPanel c1 = new JPanel();
			JFileChooser fc = new JFileChooser();
			int op = fc.showOpenDialog(c1);
			String content = "";
			if(op == JFileChooser.APPROVE_OPTION) {
				File pruta = fc.getSelectedFile();
				String ruta = pruta.getAbsolutePath();
				File archivo =  null;
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					archivo = new File(ruta);
					fr = new FileReader(archivo);
					br = new BufferedReader(fr);
					String linea = "";
					
					while((linea = br.readLine())!= null) {
						content += linea + "\n";
					}
					return content;
				
				}catch(FileNotFoundException ex) {
					String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
				}catch(IOException ex) {
					String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
				}finally {
					try {
						if(null != fr) {
							fr.close();
						}
					}catch( Exception e2) {
						String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
						return "";
					}
				}
				return content;	
			}	
			return null;
		}
		
		private void carga_masiva() {
			int x = 0;
			int y = 0;
			String archivo_retorno = leerarchivo();
			
			JsonParser parse = new JsonParser();
			JsonArray matriz =  parse.parse(archivo_retorno).getAsJsonArray();
			
			for(int i = 0; i<200;i++) {
				if(productos[i][0] == null) {
					y = i;
					break;
				}
			}
			x = y;
			for(int i = 0; i < matriz.size(); i++) {
				if(productos [199][0] == null) {
					JsonObject objeto =  matriz.get(i).getAsJsonObject();
					producto p = new producto(objeto.get("codigo").getAsInt(),objeto.get("nombre").getAsString(), objeto.get("descripcion").getAsString(), objeto.get("cantidad").getAsInt(),objeto.get("precio").getAsInt());
					datos_tabla[x][0] = p.codigo;
					datos_tabla[x][1] = p.nombre;
					datos_tabla[x][2] = p.descripcion;
					datos_tabla[x][3] = p.cantidad;
					datos_tabla[x][4] = p.precio;
					x++;
				}else {
					JOptionPane.showMessageDialog(null, "Tu documento excede el maximo permitido");
					break;
				}
			}
			

			ProductosDAO p = new ProductosDAO();
			for(int i = 0; i < datos_tabla.length; i++) {
				p.insertar(Integer.parseInt(datos_tabla[i][0]+""), datos_tabla[i][1]+"", datos_tabla[i][2]+"", Integer.parseInt(datos_tabla[i][3]+""), Integer.parseInt(datos_tabla[i][4]+""));
				//System.out.println(Integer.parseInt(datos_tabla[i][0]+"")+""+ datos_tabla[i][1]+"" +""+ datos_tabla[i][2]+"" +""+ datos_tabla[i][3]+"" +""+Integer.parseInt(datos_tabla[i][0]+""));
			}
			//tabla();
		}
	
		private void actualizar() {
			//Crear la ventana actualizar con frame y panel
			JFrame crear = new JFrame();
			JPanel panel1 = new JPanel();
			int x = tbl.getSelectedRow();
			
			crear.setTitle("Actualizar");
			crear.setBounds(250,250,425,400);
			crear.setLocationRelativeTo(null);
			crear.setResizable(false);
			crear.setVisible(true);
			panel1.setBackground(Color.cyan);
			panel1.setVisible(true);
			crear.add(panel1);
			//Crear textfield
			JTextField t1 = new JTextField();
			JTextField t2 = new JTextField();
			JTextField t3 = new JTextField();
			JTextField t4 = new JTextField();
			JTextField t5 = new JTextField();
			//Crear labels
			JLabel lb1 = new JLabel();
			JLabel lb2 = new JLabel();
			JLabel lb3 = new JLabel();
			JLabel lb4 = new JLabel();
			JLabel lb5 = new JLabel();
			JLabel lb6 = new JLabel();
			//botones
			JButton b1 = new JButton();
			
			//Llenar las 5 etiquetas y text field
			lb1.setText("Codigo");
			lb1.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb1.setBounds(50,100,100,20);
			lb1.setVisible(true);
			panel1.add(lb1);
			t1.setBounds(150,100,200,20);
			t1.setVisible(true);
			panel1.add(t1);
			
			lb2.setText("Nombre");
			lb2.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb2.setBounds(50,140,100,20);
			lb2.setVisible(true);
			panel1.add(lb2);
			t2.setBounds(150,140,200,20);
			t2.setVisible(true);
			panel1.add(t2);
			
			lb3.setText("Descripcion");
			lb3.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb3.setBounds(50,180,100,20);
			lb3.setVisible(true);
			panel1.add(lb3);
			t3.setBounds(150,180,200,20);
			t3.setVisible(true);
			panel1.add(t3);
			
			lb4.setText("Cantidad");
			lb4.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb4.setBounds(50,220,100,20);
			lb4.setVisible(true);
			panel1.add(lb4);
			t4.setBounds(150,220,200,20);
			t4.setVisible(true);
			panel1.add(t4);
			
			lb5.setText("Precio");
			lb5.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb5.setBounds(50,260,100,20);
			lb5.setVisible(true);
			panel1.add(lb5);
			t5.setBounds(150,260,200,20);
			t5.setVisible(true);
			panel1.add(t5);

			lb6.setText("Actualizar Producto");
			lb6.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb6.setBounds(140,30,200,20);
			lb6.setVisible(true);
			panel1.add(lb6);
			
			b1.setText("Actualizar");
			b1.setFont(new Font("Sergi", Font.PLAIN, 15));
			b1.setBounds(150,300,200,20);
			b1.setVisible(true);
			panel1.add(b1);
			//Para poder poner coordenadas
			panel1.setLayout(null);
			
			//Cargar los datos
			t1.setText(productos[x][0].toString());
			t2.setText(productos[x][1].toString());
			t3.setText(productos[x][2].toString());
			t4.setText(productos[x][3].toString());
			t5.setText(productos[x][4].toString());
			
			/////////Boton guardar
			ActionListener actualizar = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				//Lo que hace el boton	
					int id = 0;
					int f = tbl.getSelectedRow();;
					if(t1.getText().isEmpty()|| t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
					}else {
						ProductosDAO p = new ProductosDAO();
						List<DatosProductos> lista = p.listarUsuario();
						id = lista.get(f).getCodigo();
						p.modificar(id, t2.getText(),t3.getText(),Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()));
						JOptionPane.showMessageDialog(null, "Se modifico correctamente");
						crear.setVisible(false);
					}
			}
		};
			//Acion del evento
			b1.addActionListener(actualizar);
		}
		
		private void crear() {
			//Crear la ventana crear con frame y panel
			JFrame crear = new JFrame();
			JPanel panel1 = new JPanel();
			
			crear.setTitle("Crear");
			crear.setBounds(250,250,425,400);
			crear.setLocationRelativeTo(null);
			crear.setResizable(false);
			crear.setVisible(true);
			panel1.setBackground(Color.cyan);
			panel1.setVisible(true);
			crear.add(panel1);
			//Crear textfield
			JTextField t1 = new JTextField();
			JTextField t2 = new JTextField();
			JTextField t3 = new JTextField();
			JTextField t4 = new JTextField();
			JTextField t5 = new JTextField();
			//Crear labels
			JLabel lb1 = new JLabel();
			JLabel lb2 = new JLabel();
			JLabel lb3 = new JLabel();
			JLabel lb4 = new JLabel();
			JLabel lb5 = new JLabel();
			JLabel lb6 = new JLabel();
			//botones
			JButton b1 = new JButton();
			
			//Llenar las 5 etiquetas y text field
			lb1.setText("Codigo");
			lb1.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb1.setBounds(50,100,100,20);
			lb1.setVisible(true);
			panel1.add(lb1);
			t1.setBounds(150,100,200,20);
			t1.setVisible(true);
			panel1.add(t1);
			
			lb2.setText("Nombre");
			lb2.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb2.setBounds(50,140,100,20);
			lb2.setVisible(true);
			panel1.add(lb2);
			t2.setBounds(150,140,200,20);
			t2.setVisible(true);
			panel1.add(t2);
			
			lb3.setText("Descripcion");
			lb3.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb3.setBounds(50,180,100,20);
			lb3.setVisible(true);
			panel1.add(lb3);
			t3.setBounds(150,180,200,20);
			t3.setVisible(true);
			panel1.add(t3);
			
			lb4.setText("Cantidad");
			lb4.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb4.setBounds(50,220,100,20);
			lb4.setVisible(true);
			panel1.add(lb4);
			t4.setBounds(150,220,200,20);
			t4.setVisible(true);
			panel1.add(t4);
			
			lb5.setText("Precio");
			lb5.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb5.setBounds(50,260,100,20);
			lb5.setVisible(true);
			panel1.add(lb5);
			t5.setBounds(150,260,200,20);
			t5.setVisible(true);
			panel1.add(t5);
		
			lb6.setText("Crear Nuevo producto");
			lb6.setFont(new Font("Sergi", Font.PLAIN, 15));
			lb6.setBounds(140,30,200,20);
			lb6.setVisible(true);
			panel1.add(lb6);
			
			b1.setText("Agregar");
			b1.setFont(new Font("Sergi", Font.PLAIN, 15));
			b1.setBounds(150,300,200,20);
			b1.setVisible(true);
			panel1.add(b1);
			//Para poder poner coordenadas
			panel1.setLayout(null);
			
			
			/////////Boton guardar
			ActionListener guardar = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(t1.getText().isEmpty()|| t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
					}else {
						ProductosDAO p = new ProductosDAO();
						p.insertar(Integer.parseInt(t1.getText()), t2.getText(),t3.getText(),Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()));
						JOptionPane.showMessageDialog(null, "Se creo correctamente");
						crear.setVisible(false);
					}
					//Borrar el Try catch
					try {
						tabla();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			};
			//Acion del evento
			b1.addActionListener(guardar);
		}

		
		public void ej_productos() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		boton();
		tabla();
	}

}
