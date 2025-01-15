import javax.swing.*;

public class DeletePanel extends JPanel {
    public DeletePanel(EmployeeManager employeeManager) {
        setLayout(null);

        JLabel deleteLabel = new JLabel("Enter name to delete:");
        deleteLabel.setBounds(50, 50, 200, 30);
        add(deleteLabel);

        JTextField deleteField = new JTextField();
        deleteField.setBounds(250, 50, 200, 30);
        add(deleteField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(470, 50, 100, 30);
        add(deleteButton);

        deleteButton.addActionListener(e -> {
            String name = deleteField.getText();
            if (employeeManager.deleteEmployee(name)) {
                JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "No employee found with the name: " + name);
            }
        });
    }
}
