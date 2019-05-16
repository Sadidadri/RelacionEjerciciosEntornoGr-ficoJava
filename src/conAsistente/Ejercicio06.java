package conAsistente;
/**
 * 6. Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero. 
 *
 *Componentes gráficos: 
 *
 *Etiquetas.
 *Fichero a comprobar.
 *Caja de texto con resultado.
 *Botón calcular.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Ejercicio06 {

  private JFrame frmCuentaPalabras;
  private JTextField cajaPalabra;
  private JTextField cajaRuta;
  private JTextField cajaOcurrencias;
  File fichero1;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio06 window = new Ejercicio06();
          window.frmCuentaPalabras.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ejercicio06() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCuentaPalabras = new JFrame();
    frmCuentaPalabras.setTitle("Cuenta palabras");
    frmCuentaPalabras.setBounds(100, 100, 450, 180);
    frmCuentaPalabras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCuentaPalabras.getContentPane().setLayout(null);
    
    JLabel etiquetaInicial = new JLabel("Indique la palabra:");
    etiquetaInicial.setBounds(10, 11, 120, 14);
    frmCuentaPalabras.getContentPane().add(etiquetaInicial);
    
    cajaPalabra = new JTextField();
    cajaPalabra.setBounds(124, 8, 224, 20);
    frmCuentaPalabras.getContentPane().add(cajaPalabra);
    cajaPalabra.setColumns(10);
    
    JLabel etiquetaFichero = new JLabel("Fichero:");
    etiquetaFichero.setBounds(10, 58, 63, 14);
    frmCuentaPalabras.getContentPane().add(etiquetaFichero);
    
    cajaRuta = new JTextField();
    cajaRuta.setEditable(false);
    cajaRuta.setColumns(10);
    cajaRuta.setBounds(87, 55, 217, 20);
    frmCuentaPalabras.getContentPane().add(cajaRuta);
    
    JButton botonFichero1 = new JButton("Seleccionar");
    botonFichero1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        //Creamos el objeto JFileChooser
        JFileChooser fc1=new JFileChooser();
         
        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion=fc1.showOpenDialog(frmCuentaPalabras.getContentPane());
         
        //Si el usuario, pincha en aceptar
        if(seleccion==JFileChooser.APPROVE_OPTION){
         
            //Seleccionamos el fichero
            fichero1 = fc1.getSelectedFile();
         
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            cajaRuta.setText(fichero1.getAbsolutePath());         
        } 
      }
    });
    botonFichero1.setBounds(314, 54, 118, 23);
    frmCuentaPalabras.getContentPane().add(botonFichero1);
    
    JLabel etiquetaOcurrencias = new JLabel("Ocurrencias:");
    etiquetaOcurrencias.setBounds(10, 116, 84, 14);
    frmCuentaPalabras.getContentPane().add(etiquetaOcurrencias);
    
    cajaOcurrencias = new JTextField();
    cajaOcurrencias.setEditable(false);
    cajaOcurrencias.setColumns(10);
    cajaOcurrencias.setBounds(84, 113, 202, 20);
    frmCuentaPalabras.getContentPane().add(cajaOcurrencias);
    
    JButton botonContar = new JButton("Contar");
    botonContar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          BufferedReader br = new BufferedReader(new FileReader(fichero1));
          String linea = "";
          String palabraDeseada = cajaPalabra.getText(); // Palabra la cual queremos buscar en el fichero
          int coincidencias = 0; // Numero de veces que se encuentra la palabra
          while (linea != null) {
            linea = br.readLine();
            String[] palabras = new String[] { "" }; // Se inicializa para evitar que en el foreach pueda dar un
                                                     // NullPointerExceptionAlFinal
            if (linea != null) {
              palabras = linea.split(" "); // Separa las palabras separadas por espacios y las almacena en un array de
                                           // string
            }
            for (String x : palabras) { // Recorre el array y si coincide con la palabra deseada, aumenta el contador
              String[] palabrasSinComa = x.split(",");
              for (String y : palabrasSinComa) {
                if (y.toUpperCase().equals(palabraDeseada.toUpperCase())) {
                  coincidencias++;
                }
              }
            }
          }

          cajaOcurrencias.setText(""+coincidencias);
          br.close(); // Cierre de archivo
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(null,"Error, comprueba que este escrita una palabra y se haya indicado un fichero valido");
        }
      }
    });
    botonContar.setBounds(317, 107, 115, 33);
    frmCuentaPalabras.getContentPane().add(botonContar);
  }
}
