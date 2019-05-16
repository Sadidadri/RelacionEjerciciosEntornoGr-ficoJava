package sinAsistente;
/**
 * Calcular el perimetro y área de un rectangulo dada su base y su altura.
 *
 *Componentes graficos: 
 *
 *Etiquetas.
 *Cajas de texto para base y altura.
 *Boton para calcular.
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

public class Ejercicio01 extends JFrame {
  public Ejercicio01() {
    //Creamos la ventana heredada de JFrame
    super("Calculo de area de un rectangulo");
    //Con tamagno de 400x300 px
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    //Creamos un contenedor donde se alojaran los elementos
    Container cp = getContentPane();
    //Agnadimos la etiqueta del ancho y su caja de texto
    cp.add(new JLabel("Ancho :"));
    JTextField ancho = new JTextField(30);
    cp.add(ancho);
    //Agnadimos la etiqueta del alto y su caja de texto
    cp.add(new JLabel("Alto :"));
    JTextField alto = new JTextField(30);
    cp.add(alto);
    //Creamos el boton de calcular el area
    JButton botonCalcular = new JButton("Calcular");
    cp.add(botonCalcular);
    //Agnado la caja del resultado y su etiqueta
    cp.add(new JLabel("Resultado :"));
    JTextField resultado = new JTextField(20);
    resultado.setEditable(false);
    cp.add(resultado);
    //Por ultimo agnado el comportamiento del boton Calcular
    botonCalcular.addActionListener(new EventoCalculo01(ancho,alto,resultado));
  }

}
