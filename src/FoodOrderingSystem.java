import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FoodOrderingSystem extends JFrame{
    private JPanel jpanel;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    JCheckBox[] foodList = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
    JRadioButton[] discountOptions = {rb5, rb10, rb15};

    ArrayList<JCheckBox> foodOrdered = new ArrayList<>();

    public FoodOrderingSystem() {

        /////////// PLACE ORDER
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int totalPrice = checkFoodSelected();
                int discount = checkDiscountSelected();

                double finalPrice = updatePriceFromDiscount(discount, totalPrice);


                String message = "The total price is Php" + Double.toString(finalPrice);
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }

    private int checkFoodSelected() {
        int res = 0;
        for(JCheckBox food : foodList) {
            if(food.isSelected()) {
                foodOrdered.add(food);
                res += getPrice(food.getText());
            };
        }
        return res;
    }

    private int checkDiscountSelected() {
        if(rb5.isSelected()) return 5;
        if(rb10.isSelected()) return 10;
        if(rb15.isSelected()) return 15;

        return 0;
    }

    private double updatePriceFromDiscount(int discountPercent, int totalPrice) {
        double discount = discountPercent / 100.0;
        return totalPrice - (totalPrice * discount);
    }

    private int getPrice(String foodName) {
        switch (foodName) {
            case "Pizza":
                return 100;
            case "Burger":
                return 80;
            case "Fries":
                return 65;
            case "Soft Drinks":
                return 55;
            case "Tea":
                return 50;
            case "Sundae":
                return 40;
        }
        return 0;
    }



    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();

        app.setContentPane(app.jpanel);

        app.setSize(700, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setTitle("Food Ordering System");
        app.setVisible(true);
    }
}
