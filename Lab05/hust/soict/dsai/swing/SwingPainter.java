package Lab05.hust.soict.dsai.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingPainter extends JFrame {
    private JPanel drawPanel;
    private JRadioButton penBtn;
    private JRadioButton eraserBtn;
    private Color currentColor = Color.BLACK;
    private int currentSize = 4;

    public SwingPainter() {
        setTitle("Painter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
            }
        };
        drawPanel.setBackground(Color.WHITE);
        
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = drawPanel.getGraphics();
                g.setColor(currentColor);
                g.fillOval(e.getX(), e.getY(), currentSize, currentSize);
            }
        });

        JPanel ctrlPanel = new JPanel();
        ctrlPanel.setLayout(new BoxLayout(ctrlPanel, BoxLayout.Y_AXIS));
        
        penBtn = new JRadioButton("Pen", true);
        eraserBtn = new JRadioButton("Eraser");
        ButtonGroup group = new ButtonGroup();
        group.add(penBtn);
        group.add(eraserBtn);

        penBtn.addActionListener(e -> {
            currentColor = Color.BLACK;
            currentSize = 4;
        });
        eraserBtn.addActionListener(e -> {
            currentColor = Color.WHITE;
            currentSize = 16;
        });

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            drawPanel.repaint();
        });

        ctrlPanel.add(new JLabel("Tools"));
        ctrlPanel.add(penBtn);
        ctrlPanel.add(eraserBtn);
        ctrlPanel.add(clearBtn);

        add(ctrlPanel, BorderLayout.WEST);
        add(drawPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingPainter();
    }
}