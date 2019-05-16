package conAsistente;
/**
 * 3. Pide un DNI y comprueba que es correcto, ser� correcto si tiene 9 caracteres y la letra es correcta.
 * 
 * @author Adrian Moya
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio03 {

  private JFrame frmCompruebaDni;
  private JTextField dniCajaTexto;
  private JTextField compruebaDNICaja;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio03 window = new Ejercicio03();
          window.frmCompruebaDni.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ejercicio03() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCompruebaDni = new JFrame();
    frmCompruebaDni.setTitle("Comprueba DNI");
    frmCompruebaDni.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
    frmCompruebaDni.setBounds(100, 100, 450, 300);
    frmCompruebaDni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCompruebaDni.getContentPane().setLayout(null);
    
    JLabel dniEtiqueta = new JLabel("DNI:");
    dniEtiqueta.setFont(new Font("Tahoma", Font.PLAIN, 18));
    dniEtiqueta.setBounds(10, 11, 59, 36);
    frmCompruebaDni.getContentPane().add(dniEtiqueta);
    
    dniCajaTexto = new JTextField();
    dniCajaTexto.setBounds(79, 16, 309, 26);
    frmCompruebaDni.getContentPane().add(dniCajaTexto);
    dniCajaTexto.setColumns(10);
    
    compruebaDNICaja = new JTextField();
    compruebaDNICaja.setEditable(false);
    compruebaDNICaja.setColumns(10);
    compruebaDNICaja.setBounds(79, 82, 309, 26);
    frmCompruebaDni.getContentPane().add(compruebaDNICaja);
    
    JButton comprobarBoton = new JButton("Comprobar");
    comprobarBoton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          //Agnadimos comportamiento del programa al pulsar el boton
          //Obtenemos el String que nos introduce el usuario y eliminamos espacios
          String textoAComprobar = dniCajaTexto.getText().replace(" ","");
          //Y tambien eliminamos los "-" y lo ponemos en mayuscula para mejor comprobacion.
          textoAComprobar = textoAComprobar.replace("-","").toUpperCase();
          if(textoAComprobar.length() != 9) {
            throw new Exception();
          }
          int numeroDNI = Integer.parseInt(textoAComprobar.substring(0,8));
          String letraDNI = textoAComprobar.substring(8,9);
          boolean esCorrecto = false;
          
          String[] arrayLetras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
          if(letraDNI.equals(arrayLetras[numeroDNI%23])) {
            esCorrecto = true;
          }
          if(esCorrecto) {
            compruebaDNICaja.setText("El DNI introducido es correcto.");
          }
          else {
            compruebaDNICaja.setText("El DNI introducido es falso.");
          }
          
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(null, "Error, no has introducido un valor correcto");
        }
      }
    });
    comprobarBoton.setBounds(61, 236, 116, 26);
    frmCompruebaDni.getContentPane().add(comprobarBoton);
    
    JButton salirBoton = new JButton("Salir");
    salirBoton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    salirBoton.setBounds(274, 236, 116, 26);
    frmCompruebaDni.getContentPane().add(salirBoton);
  }
}
