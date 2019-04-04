/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.ParentesisDerechoinvalidoexception;
import Exceptions.ParentesisIzquierdoinvalidoException;
import Exceptions.Parentesisinvalidoexception;
import com.sun.javafx.util.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author eriss
 */
public class FramePrincipal extends JFrame{

    private JPanel pantalla;
    private JPanel pantallaR;
    private JPanel Resultado;
    private JPanel Botones;
    private Caracteres caracteres;

    private TitledBorder pantalla1;
    private TitledBorder pantalla2;
    private TitledBorder botones;
    
    private JLabel calcular;
    private JLabel resultado;
    
    private JButton borrartodo;
    private JButton borrar;
    private JButton parentesisI;
    private JButton ParentesisD;
    private JButton potencia;
    private JButton mas;
    private JButton menos;
    private JButton por;
    private JButton division;
    private JButton a;
    private JButton x;
    private JButton y;
    private JButton z;
    private JButton t;
    private JButton igual;
    public FramePrincipal() {
        super("Calculadora Polaca");
        super.setSize(300,300);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/ca.png")).getImage());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        ////////
        pantalla=new JPanel();
        pantalla.setBackground(Color.WHITE);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        pantalla.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        super.add(pantalla,BorderLayout.NORTH);
        pantalla1=new TitledBorder(new BorderUIResource.EtchedBorderUIResource(1, Color.RED, Color.DARK_GRAY),"");
        pantalla.setBorder(pantalla1);
        calcular=new JLabel();
        calcular.setFont(new Font("Arial Black",9,12));
        pantalla.add(calcular);
        caracteres=new Caracteres();
                
        ///////
        pantallaR=new JPanel(new BorderLayout());
        Resultado=new JPanel();
        Resultado.setBackground(Color.WHITE);
        Resultado.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Resultado.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        pantallaR.add(Resultado,BorderLayout.NORTH);
        pantalla2=new TitledBorder(new BorderUIResource.EtchedBorderUIResource(1, Color.BLUE, Color.DARK_GRAY),"Resultado");
        Resultado.setBorder(pantalla2);
        resultado=new JLabel();
        resultado.setFont(new Font("Arial Black",9,12));
        Resultado.add(resultado);
        super.add(pantallaR);
        //////
        Botones=new JPanel(new GridLayout(3,4));
        Botones.setBackground(Color.WHITE);
        borrartodo=new JButton("Ac");
        borrartodo.setFont(new Font("Arial Black",1,14));
        borrartodo.setBackground(Color.getHSBColor(0,0,0));
        borrartodo.setForeground(Color.white);
        borrartodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.borra();
                calcular.setText(caracteres.convertir());
            }
        });
        
        borrar=new JButton("C");
        borrar.setFont(new Font("Arial Black",1,14));
        borrar.setBackground(Color.getHSBColor(0,0,0));
        borrar.setForeground(Color.white);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.borraruno();
                calcular.setText(caracteres.convertir());
            }
        });
        
        parentesisI=new JButton("(");
        parentesisI.setFont(new Font("Arial Black",1,14));
        parentesisI.setBackground(Color.getHSBColor(0,0,0));
        parentesisI.setForeground(Color.white);
        parentesisI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('(');
                calcular.setText(caracteres.convertir());
            }
        });
        
        ParentesisD=new JButton(")");
        ParentesisD.setFont(new Font("Arial Black",1,14));
        ParentesisD.setBackground(Color.getHSBColor(0,0,0));
        ParentesisD.setForeground(Color.white);
        ParentesisD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar(')');
                calcular.setText(caracteres.convertir());
            }
        });
        
        potencia=new JButton("^");
        potencia.setFont(new Font("Arial Black",1,14));
        potencia.setBackground(Color.getHSBColor(0,0,0));
        potencia.setForeground(Color.white);
        potencia.setBackground(Color.red);
        potencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('^');
                calcular.setText(caracteres.convertir());
            }
        });
        
        mas=new JButton("+");
        mas.setFont(new Font("Arial Black",1,14));
        mas.setBackground(Color.getHSBColor(0,0,0));
        mas.setForeground(Color.white);
        mas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('+');
                calcular.setText(caracteres.convertir());
            }
        });
        
        menos=new JButton("-");
        menos.setFont(new Font("Arial Black",1,14));
        menos.setBackground(Color.getHSBColor(0,0,0));
        menos.setForeground(Color.white);
        menos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('-');
                calcular.setText(caracteres.convertir());
            }
        });
        
        por=new JButton("*");
        por.setFont(new Font("Arial Black",1,14));
        por.setBackground(Color.getHSBColor(0,0,0));
        por.setForeground(Color.white);
        por.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('*');
                calcular.setText(caracteres.convertir());
            }
        });
        
        division=new JButton("/");
        division.setFont(new Font("Arial Black",1,14));
        division.setBackground(Color.getHSBColor(0,0,0));
        division.setForeground(Color.white);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('/');
                calcular.setText(caracteres.convertir());
            }
        });
        
        a=new JButton("A");
        a.setFont(new Font("Arial Black",1,14));
        a.setBackground(Color.getHSBColor(0,0,0));
        a.setForeground(Color.white);
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('A');
                calcular.setText(caracteres.convertir());
            }
        });
        
        x=new JButton("X");
        x.setFont(new Font("Arial Black",1,14));
        x.setBackground(Color.getHSBColor(0,0,0));
        x.setForeground(Color.white);
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('X');
                calcular.setText(caracteres.convertir());
            }
        });
        
        y=new JButton("Y");
        y.setFont(new Font("Arial Black",1,14));
        y.setBackground(Color.getHSBColor(0,0,0));
        y.setForeground(Color.white);
        y.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('Y');
                calcular.setText(caracteres.convertir());
            }
        });
        
        z=new JButton("Z");
        z.setFont(new Font("Arial Black",1,14));
        z.setBackground(Color.getHSBColor(0,0,0));
        z.setForeground(Color.white);
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('Z');
                calcular.setText(caracteres.convertir());
            }
        });
        
        t=new JButton("T");
        t.setFont(new Font("Arial Black",1,14));
        t.setBackground(Color.getHSBColor(0,0,0));
        t.setForeground(Color.white);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caracteres.agregar('T');
                calcular.setText(caracteres.convertir());
            }
        });
        
        igual=new JButton("=");
        igual.setFont(new Font("Arial Black",1,14));
        igual.setBackground(Color.getHSBColor(0,0,0));
        igual.setForeground(Color.white);
        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(caracteres.comprobar()){
                    resultado.setText(caracteres.shuntingYard());
                }else{
                    try {
                        throw new Parentesisinvalidoexception();
                    } catch (Parentesisinvalidoexception ex) {
                        Parentesise(ex);
                    }
                }
            }
        });
        ///////
        Botones.add(borrartodo);
        Botones.add(borrar);
        Botones.add(parentesisI);
        Botones.add(ParentesisD);
        Botones.add(potencia);
        Botones.add(a);
        Botones.add(t);
        Botones.add(mas);
        Botones.add(menos);
        Botones.add(por);
        Botones.add(x);
        Botones.add(y);
        Botones.add(y);
        Botones.add(z);
        Botones.add(division);
        Botones.add(igual);
        pantallaR.add(Botones,BorderLayout.CENTER);
        super.setVisible(true);
    }
    public void Parentesise(Parentesisinvalidoexception ex){
        JOptionPane.showMessageDialog(this,"Falta cerra parentesis","Error en el parentesis",JOptionPane.ERROR_MESSAGE);
    }
}
