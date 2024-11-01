package excerciseThree.hospitalGUI;

import excerciseThree.PrioritySystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class HospitalGUI {
    private JTextField txtName;
    private JComboBox <Integer> prioritycomboBox;
    private JButton addPatientButton;
    private JTextArea txtResult;
    private JPanel pGeneral;
    private JButton servePatientsButton;

    private PrioritySystem.HospitalQueue hospitalQueue ;



    public HospitalGUI() {
        PrioritySystem system = new PrioritySystem();
        hospitalQueue = system.new HospitalQueue();

        prioritycomboBox.addItem(1);
        prioritycomboBox.addItem(2);
        prioritycomboBox.addItem(3);

        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                int priority = (int) prioritycomboBox.getSelectedItem();
                hospitalQueue.addPatient(name, priority);
                txtResult.append(name+ "added with priority " + priority + "\n");
                txtName.setText("");
            }
        });

        servePatientsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String servedPatients = hospitalQueue.servePatients();
                txtResult.append("\nServing patients :\n"+ servedPatients);


            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Emergency Priority System");
        frame.setContentPane(new HospitalGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
