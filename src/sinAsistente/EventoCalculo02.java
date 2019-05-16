package sinAsistente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class EventoCalculo02 implements ActionListener {
  private JTextField x1;
  private JTextField x2;
  private JTextField y1;
  private JTextField y2;
  private JTextField distancia;
  
  public EventoCalculo02(JTextField x1,JTextField y1,JTextField x2,JTextField y2,JTextField d) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.distancia = d;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    double x1 = Double.parseDouble(this.x1.getText());
    double y1 = Double.parseDouble(this.y1.getText());
    double x2 = Double.parseDouble(this.x2.getText());
    double y2 = Double.parseDouble(this.y2.getText());
    double calculoDistancia = Math.sqrt((Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2)));
    this.distancia.setText(""+calculoDistancia);
  }

}
