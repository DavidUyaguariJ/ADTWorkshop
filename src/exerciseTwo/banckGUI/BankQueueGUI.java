package exerciseTwo.banckGUI;

import exerciseTwo.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
/**
 * The BankQueueGUI class represents a graphical interface to manage a queue in a bank.
 * It allows adding people to the queue, serving them, and clearing the output.
 */
public class BankQueueGUI {
    private JTextField txtName;
    private JTextArea txtOutput;
    private JButton addButton;
    private JButton attendButton;
    private JPanel pGeneral;
    private JButton clearButton;
    /**
     * Queue that stores people waiting in line.
     */
    Queue queue=new LinkedList<Person>();
    /**
     * Current client to be added or served in the queue.
     */
    Person client;
    /**
     * Constructor for BankQueueGUI.
     * Sets up action listeners for the buttons in the graphical interface.
     */
    public BankQueueGUI() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String inp= txtName.getText();
                if (inp.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Elemento inválido");
                    throw new NullPointerException();
                }
                client = new Person(inp);
                queue.add(client);
                txtOutput.append(inp + " fue añadido a la cola\n");
                txtName.setText("");
                txtName.grabFocus();
            }
        });
        attendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (queue.isEmpty()){
                    JOptionPane.showMessageDialog(null,"La cola esta vacía");
                    throw new NullPointerException();
                }
                txtOutput.append(queue.poll() + " ha sido atendido \n");
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtOutput.setText("");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("BancoColaGUI");
        frame.setContentPane(new BankQueueGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
