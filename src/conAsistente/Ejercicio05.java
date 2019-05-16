package conAsistente;
/**
 * 5. Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, la primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
 *
 *Componentes gráficos: 
 *
 *Etiquetas.
 *Fichero origen y destino.
 *Botón para ejecutar la acción.
 *Caja de texto con el contenido del fichero destino no editable.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Ejercicio05 {

  private JFrame frmIntercalaLineas;
  private JTextField cajaRuta1;
  private JTextField cajaRuta2;
  private JTextField cajaRuta3;
  private JButton botonFusionar;
  private JTextField cajaContenidoResultante;
  File fichero1;
  File fichero2;
  File fichero3;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio05 window = new Ejercicio05();
          window.frmIntercalaLineas.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ejercicio05() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmIntercalaLineas = new JFrame();
    frmIntercalaLineas.setTitle("Intercala lineas");
    frmIntercalaLineas.setBounds(100, 100, 900, 600);
    frmIntercalaLineas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmIntercalaLineas.getContentPane().setLayout(null);
    
    cajaRuta1 = new JTextField();
    cajaRuta1.setEditable(false);
    cajaRuta1.setBounds(232, 6, 600, 25);
    frmIntercalaLineas.getContentPane().add(cajaRuta1);
    cajaRuta1.setColumns(10);
    
    JLabel etiquetaF1 = new JLabel("Fichero 1:");
    etiquetaF1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    etiquetaF1.setBounds(9, 6, 80, 25);
    frmIntercalaLineas.getContentPane().add(etiquetaF1);
    
    JButton botonSeleccionar1 = new JButton("Seleccionar...");
    botonSeleccionar1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      //Creamos el objeto JFileChooser
        JFileChooser fc1=new JFileChooser();
         
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc1.showOpenDialog(frmIntercalaLineas.getContentPane());
         
        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){
         
            //Seleccionamos el fichero
            fichero1=fc1.getSelectedFile();
         
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            cajaRuta1.setText(fichero1.getAbsolutePath());         
        } 
    }
    });
    botonSeleccionar1.setBounds(99, 6, 123, 25);
    frmIntercalaLineas.getContentPane().add(botonSeleccionar1);
    
    JLabel etiquetaF2 = new JLabel("Fichero 2:");
    etiquetaF2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    etiquetaF2.setBounds(9, 46, 80, 25);
    frmIntercalaLineas.getContentPane().add(etiquetaF2);
    
    JButton botonSeleccionar2 = new JButton("Seleccionar...");
    botonSeleccionar2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      //Creamos el objeto JFileChooser
        JFileChooser fc2=new JFileChooser();
         
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc2.showOpenDialog(frmIntercalaLineas.getContentPane());
         
        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){
         
            //Seleccionamos el fichero
            fichero2=fc2.getSelectedFile();
         
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            cajaRuta2.setText(fichero2.getAbsolutePath());
        } 
      }
    });
    botonSeleccionar2.setBounds(99, 46, 123, 25);
    frmIntercalaLineas.getContentPane().add(botonSeleccionar2);
    
    cajaRuta2 = new JTextField();
    cajaRuta2.setEditable(false);
    cajaRuta2.setColumns(10);
    cajaRuta2.setBounds(232, 46, 600, 25);
    frmIntercalaLineas.getContentPane().add(cajaRuta2);
    
    JLabel etiquetaF3 = new JLabel("Fichero Destino:");
    etiquetaF3.setFont(new Font("Tahoma", Font.PLAIN, 14));
    etiquetaF3.setBounds(9, 82, 100, 25);
    frmIntercalaLineas.getContentPane().add(etiquetaF3);
    
    JButton botonSeleccionar3 = new JButton("Seleccionar...");
    botonSeleccionar3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {//Creamos el objeto JFileChooser
        JFileChooser fc3=new JFileChooser();
         
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc3.showOpenDialog(frmIntercalaLineas.getContentPane());
         
        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){
         
            //Seleccionamos el fichero
            fichero3=fc3.getSelectedFile();
         
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            cajaRuta3.setText(fichero3.getAbsolutePath());
        } 
      }
    });
    botonSeleccionar3.setBounds(121, 84, 123, 25);
    frmIntercalaLineas.getContentPane().add(botonSeleccionar3);
    
    cajaRuta3 = new JTextField();
    cajaRuta3.setEditable(false);
    cajaRuta3.setColumns(10);
    cajaRuta3.setBounds(254, 82, 578, 25);
    frmIntercalaLineas.getContentPane().add(cajaRuta3);
    
    JButton botonSalir = new JButton("Salir");
    botonSalir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    
    JLabel etiquetaResultado = new JLabel("Resultado:");
    etiquetaResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
    etiquetaResultado.setBounds(33, 131, 100, 25);
    frmIntercalaLineas.getContentPane().add(etiquetaResultado);
    
    cajaContenidoResultante = new JTextField();
    cajaContenidoResultante.setEditable(false);
    cajaContenidoResultante.setBounds(33, 156, 826, 339);
    frmIntercalaLineas.getContentPane().add(cajaContenidoResultante);
    cajaContenidoResultante.setColumns(10);
    botonSalir.setBounds(89, 530, 133, 32);
    frmIntercalaLineas.getContentPane().add(botonSalir);
    
    botonFusionar = new JButton("Fusionar");
    botonFusionar.addActionListener(new ActionListener() {
    private BufferedReader br1;
    private BufferedReader br2;
    private BufferedReader br3;

      public void actionPerformed(ActionEvent e) {
        try {
          br1 = new BufferedReader(new FileReader(fichero1));
          br2 = new BufferedReader(new FileReader(fichero2));
          BufferedWriter bw3 = new BufferedWriter(new FileWriter(fichero3));
          
          String linea = "";
          ArrayList<String> lineasF1 = new ArrayList<String>();
          ArrayList<String> lineasF2 = new ArrayList<String>();
          //Recorremos el primer fichero y almacenamos su contenido en un arraylist
          while (linea != null) {
            linea = br1.readLine();
            if(linea != null) {
              lineasF1.add(linea);
            }
          }
          linea = "";
          while (linea != null) {
            linea = br2.readLine();
            if(linea != null) {
              lineasF2.add(linea);
            }
          }
          int mayorNumeroLineas = lineasF1.size();
          if (lineasF2.size() > lineasF1.size()) {
            mayorNumeroLineas = lineasF2.size();
          }
          
          for (int i=0;i<mayorNumeroLineas;i++) {
            if(lineasF1.size() >= i+1) {
              bw3.write(lineasF1.get(i)+"\n");
            }
            if(lineasF2.size() >= i+1) {
              bw3.write(lineasF2.get(i)+"\n");
            }
          }
          bw3.close();
          br3 = new BufferedReader(new FileReader(fichero3));
          
          String contenidoFichero3 = "";
          linea = "";
          while(linea != null) {
            linea = br3.readLine();
            if (linea != null) {
              contenidoFichero3 += linea+"\n";
            }   
          }
          cajaContenidoResultante.setText(contenidoFichero3);
          br1.close();
          br2.close();
          br3.close();
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          JOptionPane.showMessageDialog(null, "Oooops! Algo ha fallado con la eleccion del fichero.");
        }
        
      }
    });
    botonFusionar.setBounds(704, 530, 133, 32);
    frmIntercalaLineas.getContentPane().add(botonFusionar);
    
  }
}
