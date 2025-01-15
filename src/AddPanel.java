import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
    public AddPanel(EmployeeManager employeeManager) {
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField();
        JButton addButton = new JButton("Add Employee");

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(departmentLabel);
        add(departmentField);
        add(new JLabel());
        add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int age;
            try {
                age = Integer.parseInt(ageField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age!");
                return;
            }
            String department = departmentField.getText();
            employeeManager.addEmployee(new Employee(name, age, department));
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
            nameField.setText("");
            ageField.setText("");
            departmentField.setText("");
        });
    }
}
