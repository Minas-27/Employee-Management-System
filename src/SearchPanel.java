import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    public SearchPanel(EmployeeManager employeeManager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField();
        JButton searchButton = new JButton("Search Employee");
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(idLabel, gbc);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(new JScrollPane(resultArea), gbc);

        searchButton.addActionListener(e -> {
            String id = idField.getText();
            Employee employee = employeeManager.getEmployeeById(id);
            if (employee != null) {
                resultArea.setText("Employee Found:\n");
                resultArea.append("ID: " + employee.getId() + "\n");
                resultArea.append("Name: " + employee.getName() + "\n");
                resultArea.append("Age: " + employee.getAge() + "\n");
                resultArea.append("Department: " + employee.getDepartment());
            } else {
                resultArea.setText("Employee not found!");
            }
        });
    }
}
