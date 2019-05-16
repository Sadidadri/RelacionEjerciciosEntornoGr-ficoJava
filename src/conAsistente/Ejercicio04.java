package conAsistente;
/**
 * 4. Cajero de cambio: devuelve y desglosa el cambio en billetes y monedas de forma 
 * "ideal"; es decir, con el menor n�mero de billetes y monedas posibles.
 *
 *Componentes gr�ficos: 
 *
 *Etiquetas.
 *Caja de texto para introducir dinero a cambiar.
 *Cajas de texto para billetes y monedas.
 *Bot�n para calcular.
 *Opcional: sustituir la etiqueta de cada billete y moneda por su imagen. 
 */
import java.awt.EventQueue;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio04 {

  private JFrame frmCambioAutomatico;
  private JTextField cajaTextoDinero;
  private JTextField bc500;
  private JTextField bc200;
  private JTextField bc100;
  private JTextField bc50;
  private JTextField bc20;
  private JTextField bc10;
  private JTextField bc5;
  private JTextField mc2;
  private JTextField mc1;
  private JTextField mc050;
  private JTextField mc020;
  private JTextField mc010;
  private JTextField mc005;
  private JTextField mc002;
  private JTextField mc001;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio04 window = new Ejercicio04();
          window.frmCambioAutomatico.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ejercicio04() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmCambioAutomatico = new JFrame();
    frmCambioAutomatico.setTitle("Cambio automatico");
    frmCambioAutomatico.setBounds(100, 100, 800, 600);
    frmCambioAutomatico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmCambioAutomatico.getContentPane().setLayout(null);
    
    JLabel etiquetaDinero = new JLabel("Cantidad de Dinero:");
    etiquetaDinero.setFont(new Font("Tahoma", Font.PLAIN, 20));
    etiquetaDinero.setBounds(10, 53, 231, 28);
    frmCambioAutomatico.getContentPane().add(etiquetaDinero);
    
    cajaTextoDinero = new JTextField();
    cajaTextoDinero.setFont(new Font("Tahoma", Font.PLAIN, 18));
    cajaTextoDinero.setBounds(211, 53, 357, 31);
    frmCambioAutomatico.getContentPane().add(cajaTextoDinero);
    cajaTextoDinero.setColumns(10);
    
    ImageIcon imgb500=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\500.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b500 = new JLabel(imgb500);
    b500.setBounds(52, 130, 60, 30);
    frmCambioAutomatico.getContentPane().add(b500);
    
    
    bc500 = new JTextField();
    bc500.setEditable(false);
    bc500.setBounds(136, 130, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc500);
    bc500.setColumns(10);
    
    ImageIcon imgb200=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\200.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b200 = new JLabel(imgb200);
    b200.setBounds(52, 190, 60, 30);
    frmCambioAutomatico.getContentPane().add(b200);
    
    bc200 = new JTextField();
    bc200.setEditable(false);
    bc200.setColumns(10);
    bc200.setBounds(136, 190, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc200);
    
    ImageIcon imgb100=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\100.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b100 = new JLabel(imgb100);
    b100.setBounds(52, 250, 60, 30);
    frmCambioAutomatico.getContentPane().add(b100);
    
    bc100 = new JTextField();
    bc100.setEditable(false);
    bc100.setColumns(10);
    bc100.setBounds(136, 250, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc100);
    
    ImageIcon imgb50=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\50.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b50 = new JLabel(imgb50);
    b50.setBounds(52, 310, 60, 30);
    frmCambioAutomatico.getContentPane().add(b50);
    
    bc50 = new JTextField();
    bc50.setEditable(false);
    bc50.setColumns(10);
    bc50.setBounds(136, 310, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc50);
    
    ImageIcon imgb20=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\20.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b20 = new JLabel(imgb20);
    b20.setBounds(52, 370, 60, 30);
    frmCambioAutomatico.getContentPane().add(b20);
    
    bc20 = new JTextField();
    bc20.setEditable(false);
    bc20.setColumns(10);
    bc20.setBounds(136, 370, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc20);
    
    ImageIcon imgb10=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\10.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b10 = new JLabel(imgb10);
    b10.setBounds(52, 430, 60, 30);
    frmCambioAutomatico.getContentPane().add(b10);
    
    bc10 = new JTextField();
    bc10.setEditable(false);
    bc10.setColumns(10);
    bc10.setBounds(136, 430, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc10);
    
    ImageIcon imgb5=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\5.jpg").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel b5 = new JLabel(imgb5);
    b5.setBounds(52, 490, 60, 30);
    frmCambioAutomatico.getContentPane().add(b5);
    
    bc5 = new JTextField();
    bc5.setEditable(false);
    bc5.setColumns(10);
    bc5.setBounds(136, 490, 97, 30);
    frmCambioAutomatico.getContentPane().add(bc5);
    
    ImageIcon imgm2=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\2.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m2 = new JLabel(imgm2);
    m2.setBounds(414, 130, 60, 30);
    frmCambioAutomatico.getContentPane().add(m2);
    
    mc2 = new JTextField();
    mc2.setEditable(false);
    mc2.setColumns(10);
    mc2.setBounds(498, 130, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc2);
    
    ImageIcon imgm1=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\1.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m1 = new JLabel(imgm1);
    m1.setBounds(414, 183, 60, 30);
    frmCambioAutomatico.getContentPane().add(m1);
    
    mc1 = new JTextField();
    mc1.setEditable(false);
    mc1.setColumns(10);
    mc1.setBounds(498, 183, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc1);
    
    ImageIcon imgm050=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\050.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m050 = new JLabel(imgm050);
    m050.setBounds(414, 236, 60, 30);
    frmCambioAutomatico.getContentPane().add(m050);
    
    mc050 = new JTextField();
    mc050.setEditable(false);
    mc050.setColumns(10);
    mc050.setBounds(498, 236, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc050);
    
    ImageIcon imgm020=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\020.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m020 = new JLabel(imgm020);
    m020.setBounds(414, 289, 60, 30);
    frmCambioAutomatico.getContentPane().add(m020);
    
    mc020 = new JTextField();
    mc020.setEditable(false);
    mc020.setColumns(10);
    mc020.setBounds(498, 289, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc020);
    
    ImageIcon imgm010=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\010.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m010 = new JLabel(imgm010);
    m010.setBounds(414, 342, 60, 30);
    frmCambioAutomatico.getContentPane().add(m010);
    
    mc010 = new JTextField();
    mc010.setEditable(false);
    mc010.setColumns(10);
    mc010.setBounds(498, 342, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc010);
    
    ImageIcon imgm005=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\005.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m005 = new JLabel(imgm005);
    m005.setBounds(414, 395, 60, 30);
    frmCambioAutomatico.getContentPane().add(m005);
    
    mc005 = new JTextField();
    mc005.setEditable(false);
    mc005.setColumns(10);
    mc005.setBounds(498, 395, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc005);
    
    ImageIcon imgm002=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\002.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m002 = new JLabel(imgm002);
    m002.setBounds(414, 448, 60, 30);
    frmCambioAutomatico.getContentPane().add(m002);
    
    mc002 = new JTextField();
    mc002.setEditable(false);
    mc002.setColumns(10);
    mc002.setBounds(498, 448, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc002);
    
    ImageIcon imgm001=new ImageIcon(new ImageIcon("src\\conAsistente\\imagenesCajero\\001.png").getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
    JLabel m001 = new JLabel(imgm001);
    m001.setBounds(414, 501, 60, 30);
    frmCambioAutomatico.getContentPane().add(m001);
    
    mc001 = new JTextField();
    mc001.setEditable(false);
    mc001.setColumns(10);
    mc001.setBounds(498, 501, 119, 30);
    frmCambioAutomatico.getContentPane().add(mc001);
    
    JButton botonMostrarCambio = new JButton("Mostrar cambio");
    botonMostrarCambio.addActionListener(new ActionListener() {
      //Comportamiento del boton
      public void actionPerformed(ActionEvent arg0) {
        try {
          //Cogemos solo hasta dos decimales, lo que serian los centimos.
          double dinero = Double.parseDouble(cajaTextoDinero.getText());
          BigDecimal bigDecimal = new BigDecimal(dinero).setScale(2, RoundingMode.DOWN);
          dinero = bigDecimal.doubleValue();
          
          int cont500 = 0;
          int cont200 = 0;
          int cont100 = 0;
          int cont50 = 0;
          int cont20 = 0;
          int cont10 = 0;
          int cont5 = 0;
          int cont2 = 0;
          int cont1 = 0;
          int cont050 = 0;
          int cont020 = 0;
          int cont010 = 0;
          int cont005 = 0;
          int cont002 = 0;
          int cont001 = 0;
          
          while(dinero >= 500) {
            cont500++;
            dinero-=500;
          }
          while(dinero >= 200) {
            cont200++;
            dinero-=200;
          }
          while(dinero >= 100) {
            cont100++;
            dinero-=100;
          }
          while(dinero >= 50) {
            cont50++;
            dinero-=50;
          }
          while(dinero >= 20) {
            cont20++;
            dinero-=20;
          }
          while(dinero >= 10) {
            cont10++;
            dinero-=10;
          }
          while(dinero >= 5) {
            cont5++;
            dinero-=5;
          }
          while(dinero >= 2) {
            cont2++;
            dinero-=2;
          }
          while(dinero >= 1) {
            cont1++;
            dinero-=1;
          }
          while(dinero >= 0.50) {
            cont050++;
            dinero-=0.50;
          }
          while(dinero >= 0.20) {
            cont020++;
            dinero-=0.20;
          }
          while(dinero >= 0.10) {
            cont010++;
            dinero-=0.10;
          }
          while(dinero >= 0.05) {
            cont005++;
            dinero-=0.05;
          }
          while(dinero >= 0.02) {
            cont002++;
            dinero-=0.02;
          }

          while(dinero > 0.01) {
            cont001++;
            dinero-=2;
          }
          
          bc500.setText(""+cont500);
          bc200.setText(""+cont200);
          bc100.setText(""+cont100);
          bc50.setText(""+cont50);
          bc20.setText(""+cont20);
          bc10.setText(""+cont10);
          bc5.setText(""+cont5);
          mc2.setText(""+cont2);
          mc1.setText(""+cont1);
          mc050.setText(""+cont050);
          mc020.setText(""+cont020);
          mc010.setText(""+cont010);
          mc005.setText(""+cont005);
          mc002.setText(""+cont002);
          mc001.setText(""+cont001);
          
        } catch (Exception e) {
          //En caso de error se mostrara una ventana con un mensaje indicandolo
          JOptionPane.showMessageDialog(null, "Error, no has introducido un valor correcto");
        }
      }
    });
    botonMostrarCambio.setBounds(615, 49, 156, 46);
    frmCambioAutomatico.getContentPane().add(botonMostrarCambio);
    
    
  }
  
}
