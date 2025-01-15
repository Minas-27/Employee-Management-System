import javax.swing.*;

public class UpdatePanel extends JPanel {
    public UpdatePanel(EmployeeManager employeeManager) {
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        add(nameField);

        JLabel ageLabel = new JLabel("New Age:");
        ageLabel.setBounds(50, 100, 100, 30);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(150, 100, 200, 30);
        add(ageField);

        JLabel departmentLabel = new JLabel("New Department:");
        departmentLabel.setBounds(50, 150, 200, 30);
        add(departmentLabel);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(150, 150, 200, 30);
        add(departmentField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(150, 200, 100, 30);
        add(updateButton);

        updateButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String department = departmentField.getText();
            if (employeeManager.updateEmployee(name, age, department)) {
                JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "No employee found with the name: " + name);
            }
        });
    }
}
