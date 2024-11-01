package excerciseFive.polishFormGUI;

import excerciseFive.ReversePolishCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class polishGUI {
    private JPanel pGeneral;
    private JButton evaluateButton;
    private JTextField txtImput;
    private JTextArea txtResponse;

    public polishGUI() {
        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value= txtImput.getText();
                ReversePolishCalculator rpn = new ReversePolishCalculator(value);
                txtResponse.setText(rpn.evaluateRPN()+" ");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("polishGUI");
        frame.setContentPane(new polishGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
