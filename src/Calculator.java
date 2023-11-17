import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JPanel jpanel;
    private JButton btnCompute;
    private JLabel lblResult;

    public Calculator() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int op = cbOperations.getSelectedIndex();
                String n1 = tfNumber1.getText();
                String n2 = tfNumber2.getText();

                if(n1.length() == 0 && n2.length() == 0) {
                    JOptionPane.showMessageDialog(null, "ENTER A NUMBER");
                    return;
                }

                if(n1.length() == 0) {
                    JOptionPane.showMessageDialog(null, "ENTER FIRST NUMBER");
                    return;
                }
                if(n2.length() == 0) {
                    JOptionPane.showMessageDialog(null, "ENTER SECOND NUMBER");
                    return;
                }
                
                double res = 0;
                double num1 = 0, num2 = 0;

                try {
                    num1 = Double.parseDouble(n1);
                    num2 = Double.parseDouble(n2);

                    switch (op) {
                        case 0:
                            res = num1 + num2;
                            break;
                        case 1:
                            res = num1 - num2;
                            break;
                        case 2:
                            res = num1 * num2;
                            break;
                        case 3:
                            res = num1 / num2;
                            break;
                    }

                    if(res % 1 == 0) {
                        int a = (int)res;
                        lblResult.setText(Integer.toString(a));
                    } else {
                        lblResult.setText(Double.toString(res));
                    }

                    tfNumber1.setText("");
                    tfNumber2.setText("");
                    cbOperations.setSelectedIndex(0);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID NUMBER");
                }




            }
        });
    }


    public static void main(String[] args) {
        Calculator app = new Calculator();

        app.setContentPane(app.jpanel);

        app.setSize(700, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setTitle("Simple Calculator");
        app.setVisible(true);
    }
}
