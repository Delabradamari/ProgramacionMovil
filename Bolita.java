/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolita;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bolita extends Canvas {
    int moverX, moverY;

    public Bolita() {
        setSize(400, 200);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(moverX, moverY, 30, 30);
    }

    public int getMoverX() {
        return this.moverX;
    }

    public void setMoverX(int moverX) {
        this.moverX = moverX;
    }

    public static void main(String[] args) {
        Controlador c = new Controlador();
        c.setVisible(true);
    }

    public abstract class Control extends JPanel implements ActionListener {
        JButton btnIzquierda, btnDerecha;
        Bolita bolita;

        public Control(Bolita b) {
            btnIzquierda = new JButton("izquierda");
            btnDerecha = new JButton("derecha");
            bolita = b;

            btnIzquierda.addActionListener(this);
            btnDerecha.addActionListener(this);

            setLayout(new BorderLayout());
            add(btnIzquierda, BorderLayout.WEST);
            add(btnDerecha, BorderLayout.EAST);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(btnIzquierda)) {
                bolita.setMoverX(bolita.getMoverX() - 5);
            }
            if (e.getSource().equals(btnDerecha)) {
                bolita.setMoverX(bolita.getMoverX() + 5);
            }
            bolita.repaint();
        }
    }

    public class Controlador extends JFrame {
        Bolita b;
        JPanel pBolita, pControl;

        public Controlador() {
            setTitle("Mover");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            b = new Bolita();
            pBolita = new JPanel();
            pControl = new Control(b);

            pBolita.add(b);
            add(pBolita);
            add(pControl, BorderLayout.SOUTH);
        }
    }
}


