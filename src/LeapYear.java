import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYear extends JFrame {
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JPanel jpanel;


    public LeapYear() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfYear.getText();
                String message = "";

                try {
                    if(checkLeapYear(Integer.parseInt(input))) {
                        message = "Leap Year";
                    } else {
                        message = "Not a Leap Year";
                    }

                    tfYear.setText("");
                    JOptionPane.showMessageDialog(null, message);
                } catch(NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID YEAR");

                }

            }
        });
    }



    boolean checkLeapYear(int n) {
        if(n % 4 == 0) {
            return n % 400 == 0;
        }
        return false;
    }


    public static void main(String[] args) {
        LeapYear app = new LeapYear();

        app.setContentPane(app.jpanel);

        app.setSize(500, 200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setTitle("Leap Year Checker");
        app.setVisible(true);
    }
}
