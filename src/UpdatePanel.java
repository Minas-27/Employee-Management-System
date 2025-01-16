import javax.swing.*;
import java.awt.*;

public class UpdatePanel extends JPanel {
    public UpdatePanel(EmployeeManager employeeManager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("New Age:");
        JTextField ageField = new JTextField();
        JLabel departmentLabel = new JLabel("New Department:");
        JTextField departmentField = new JTextField();
        JButton updateButton = new JButton("Update Employee");

        updateButton.setBackground(new Color(255, 165, 0));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(idLabel, gbc);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(departmentLabel, gbc);
        gbc.gridx = 1;
        add(departmentField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(updateButton, gbc);

        updateButton.addActionListener(e -> {
            String id = idField.getText();
            Employee employee = employeeManager.getEmployeeById(id);
            if (employee != null) {
                employee.setName(nameField.getText());
                try {
                    employee.setAge(Integer.parseInt(ageField.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid age!");
                    return;
                }
                employee.setDepartment(departmentField.getText());
                JOptionPane.showMessageDialog(this, "Employee updated successfully!");
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                departmentField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        });
    }
}
