package Lab05.hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

public class TestGuiException extends JFrame {
    private JTextField tfInput;
    private JButton btnCheck;

    public TestGuiException() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(new JLabel("Nhap vao do dai dia DVD (phai lon hon 0): "));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        btnCheck = new JButton("Kiem tra");
        cp.add(btnCheck);

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int val = Integer.parseInt(tfInput.getText().trim());
                    if (val <= 0) {
                        throw new InvalidDataException("ERROR: Do dai khong the nho hon hoac bang 0!");
                    }
                    JOptionPane.showMessageDialog(null, "Do dai hop le: " + val + " phut.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: Ban phai nhap vao mot so nguyen hop le!", "Number Format Error", JOptionPane.ERROR_MESSAGE);
                } catch (InvalidDataException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Illegal Value Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GUI Exception Test");
        setSize(400, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestGuiException();
    }
}