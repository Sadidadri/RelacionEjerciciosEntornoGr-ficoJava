package sinAsistente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoCalculo01 implements ActionListener {
  
  private JTextField cuadroAncho;
  private JTextField cuadroAlto;
  private JTextField resultado;
  
  public EventoCalculo01(JTextField cuadroAncho,JTextField cuadroAlto,JTextField resultado) {
    this.cuadroAncho = cuadroAncho;
    this.cuadroAlto = cuadroAlto;
    this.resultado = resultado;
  }

  public void actionPerformed(ActionEvent e) {
    double ancho = Double.parseDouble(cuadroAncho.getText());
    double alto = Double.parseDouble(cuadroAlto.getText());
    double area = ancho*alto;
    this.resultado.setText(""+area);
  }
 }