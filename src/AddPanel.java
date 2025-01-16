import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
    public AddPanel(EmployeeManager employeeManager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField();
        JButton addButton = new JButton("Add Employee");

        addButton.setBackground(new Color(34, 139, 34));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(departmentLabel, gbc);
        gbc.gridx = 1;
        add(departmentField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(addButton, gbc);

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
