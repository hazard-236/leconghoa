package Lab01;

import javax.swing.JOptionPane;

public class Calculation {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Nhap so thu nhat (Bai 2.2.5):", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Nhap so thu hai (Bai 2.2.5):", "Input", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        String result = "Tong: " + (num1 + num2) + "\n"
                      + "Hieu: " + (num1 - num2) + "\n"
                      + "Tich: " + (num1 * num2) + "\n";

        if (num2 != 0) {
            result += "Thuong: " + (num1 / num2);
        } else {
            result += "Loi: Khong the chia cho 0!";
        }

        JOptionPane.showMessageDialog(null, result, "Ket qua Bai 2.2.5", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}