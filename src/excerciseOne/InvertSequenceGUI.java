package excerciseOne;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class InvertSequenceGUI {
    private JTextField txtNumbers;
    private JButton invertButton;
    private JTextArea textArea1;
    private JPanel pGeneral;

    public InvertSequenceGUI() {
        invertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sequence = txtNumbers.getText();
                if (!sequence.isEmpty()){
                    String invertedSequence = invertedSequence(sequence);
                    textArea1.setText(invertedSequence);
                } else {
                    textArea1.setText("Ingrese una secuencia de numeros:");
                }
            }
        });

        txtNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invertButton.doClick();
            }
        });
    }

    private String invertedSequence(String sequence) {
        Stack<String> stack = new Stack<>();
        String[] numbers = sequence.split(" ");

        for (String num : numbers) {
            stack.push(num);
        }
        StringBuilder invertedSequence = new StringBuilder();
        while (!stack.isEmpty()) {
            invertedSequence.append(stack.pop()).append(" ");
        }

        return invertedSequence.toString().trim();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InvertSequenceGUI");
        frame.setContentPane(new InvertSequenceGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
