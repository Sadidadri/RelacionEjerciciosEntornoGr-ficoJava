package sinAsistente;
/**
 * 2. Pide al usuario dos pares de números x1,y2 y x2,y2, que representen dos puntos en 
 * el plano. Calcula y muestra la distancia entre ellos.
 *
 *Componentes gráficos: 
 *
 *Etiquetas.
 *Cajas de texto para base y altura.
 *Botón para calcular.
 *Caja de texto resultado.
 *No utilizar asistente.
 *
 *@author Adrian Moya
 */
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejercicio02 extends JFrame {
  public Ejercicio02() {
    //Creamos la ventana heredada de JFrame
    super("Calculo de distancia de dos puntos");
    //Con tamagno de 400x300 px
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    //Creamos un contenedor donde se alojaran los elementos
    Container cp = getContentPane();
    //Agnadimos la etiqueta de x1,y1 y sus cajas de texto
    cp.add(new JLabel("x1 :"));
    JTextField x1 = new JTextField(14);
    cp.add(x1);
    cp.add(new JLabel("y1 :"));
    JTextField y1 = new JTextField(14);
    cp.add(y1);
    //Agnadimos la etiqueta de x2,y2 y sus cajas de texto
    cp.add(new JLabel("x2 :"));
    JTextField x2 = new JTextField(14);
    cp.add(x2);
    cp.add(new JLabel("y2 :"));
    JTextField y2 = new JTextField(14);
    cp.add(y2);
    //Creamos el boton de calcular la distancia
    JButton botonCalcular = new JButton("Calcular");
    cp.add(botonCalcular);
    //Agnado la caja de la distancia y su etiqueta
    cp.add(new JLabel("Distancia :"));
    JTextField distancia = new JTextField(20);
    distancia.setEditable(false);
    cp.add(distancia);
    //Por ultimo agnado el comportamiento del boton Calcular
    botonCalcular.addActionListener(new EventoCalculo02(x1,y1,x2,y2,distancia));
  }

}
