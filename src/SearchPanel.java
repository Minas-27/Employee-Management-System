import javax.swing.*;

public class SearchPanel extends JPanel {
    public SearchPanel(EmployeeManager employeeManager) {
        setLayout(null);

        JLabel searchLabel = new JLabel("Enter name to search:");
        searchLabel.setBounds(50, 50, 200, 30);
        add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(250, 50, 200, 30);
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(470, 50, 100, 30);
        add(searchButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(50, 100, 600, 300);
        add(scrollPane);

        searchButton.addActionListener(e -> {
            String name = searchField.getText();
            resultArea.setText("");
            for (Employee employee : employeeManager.getEmployees()) {
                if (employee.getName().equalsIgnoreCase(name)) {
                    resultArea.append("Name: " + employee.getName() +
                            ", Age: " + employee.getAge() +
                            ", Department: " + employee.getDepartment() + "\n");
                }
            }
            if (resultArea.getText().isEmpty()) {
                resultArea.setText("No employee found with the name: " + name);
            }
        });
    }
}
