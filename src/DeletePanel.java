import javax.swing.*;
import java.awt.*;

public class DeletePanel extends JPanel {
    public DeletePanel(EmployeeManager employeeManager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField();
        JButton deleteButton = new JButton("Delete Employee");

        deleteButton.setBackground(new Color(220, 20, 60));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(idLabel, gbc);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(deleteButton, gbc);

        deleteButton.addActionListener(e -> {
            String id = idField.getText();
            boolean success = employeeManager.deleteEmployeeById(id);
            if (success) {
                JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
                idField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        });
    }
}
