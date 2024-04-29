package prueba;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Edad extends JFrame implements ActionListener{
    JPanel panel01;
    JTextField txtEdad;
    JButton b1;
    
    public Edad(){
        this.setSize(300,90);
        this.setTitle("Programa edad");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txtEdad = new JTextField(10);
        //add(txtEdad);
        panel01 = new JPanel(new GridLayout(1,2));
        b1 = new JButton("Dame tu edad: ");
        panel01.add(txtEdad);
        b1.addActionListener(this);
        panel01.add(b1);
        add(panel01);
    }
    
    public void actionPerformed(ActionEvent e){
    int edad = Integer.parseInt(txtEdad.getText());
    String res = "";
    if (edad >= 18){
        res = "Mayor de edad";
    }
    else {
        res = "Menor de edad";
    }
    JOptionPane.showMessageDialog(null, res);
    }
}
