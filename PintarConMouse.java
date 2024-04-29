/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pintarconmouse;
// sacar la clase drawingpanel
//pintarConMouse y drawing panel en dos archivos
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PintarConMouse extends JFrame {
    JComboBox<String> comboBox;
    DrawingPanel drawingPanel;

    public PintarConMouse() {
        setTitle("paint");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        comboBox = new JComboBox<>(new String[]{"Rojo", "Verde", "Azul"});
        drawingPanel = new DrawingPanel(comboBox);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(comboBox, BorderLayout.NORTH);
        c.add(drawingPanel);
    }

    class DrawingPanel extends JPanel {
        JComboBox<String> comboBox;
        int lastX, lastY;
        Color currentColor;

        public DrawingPanel(JComboBox<String> comboBox) {
            this.comboBox = comboBox;

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    cambiarColor();
                    lastX = e.getX();
                    lastY = e.getY();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Graphics g = getGraphics();
                    int x = e.getX();
                    int y = e.getY();
                    g.setColor(currentColor);
                    g.drawLine(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
            });
        }

        public void cambiarColor() {
            String color = (String) comboBox.getSelectedItem();
            switch (color) {
                case "Rojo":
                    currentColor = Color.RED;
                    break;
                case "Verde":
                    currentColor = Color.GREEN;
                    break;
                case "Azul":
                    currentColor = Color.BLUE;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        PintarConMouse app = new PintarConMouse();
        app.setVisible(true);
    }
}
