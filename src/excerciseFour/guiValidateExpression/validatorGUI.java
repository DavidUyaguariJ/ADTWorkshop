package excerciseFour.guiValidateExpression;

import excerciseFour.ExpressionsValidator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class validatorGUI {
    private JTextField txtImput;
    private JButton Validate;
    private JPanel pGeneral;

    ExpressionsValidator calculator = new ExpressionsValidator();
    public validatorGUI() {
        Validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String value = txtImput.getText();
                    calculator.setExpression(value);
                    calculator.validateExpression();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calculadoraGUI");
        frame.setContentPane(new validatorGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
