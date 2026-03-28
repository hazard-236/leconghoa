package Lab01;

import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog(null, "Nhap 1 de giai PT Bac 1\nNhap 3 de giai PT Bac 2:");

        if (choice != null && choice.equals("1")) {
            // Bước 2: Giai PT Bac 1: ax + b = 0
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
            
            if (a == 0) {
                JOptionPane.showMessageDialog(null, b == 0 ? "Vo so nghiem" : "Vo nghiem");
            } else {
                JOptionPane.showMessageDialog(null, "x = " + (-b/a));
            }
        } else if (choice != null && choice.equals("3")) {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Nhap c:"));
            
            double delta = b*b - 4*a*c;
            JOptionPane.showMessageDialog(null, "Delta = " + delta);
        }
        
        System.exit(0);
    }
}