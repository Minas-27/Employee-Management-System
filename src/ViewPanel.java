import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {
    public ViewPanel(EmployeeManager employeeManager) {
        setLayout(new BorderLayout());

        JTextArea employeeListArea = new JTextArea();
        employeeListArea.setEditable(false);
        employeeListArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JButton refreshButton = new JButton("Refresh List");
        refreshButton.setBackground(new Color(100, 149, 237));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));

        add(new JScrollPane(employeeListArea), BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Employee employee : employeeManager.getEmployees()) {
                sb.append("ID: ").append(employee.getId()).append("\n");
                sb.append("Name: ").append(employee.getName()).append("\n");
                sb.append("Age: ").append(employee.getAge()).append("\n");
                sb.append("Department: ").append(employee.getDepartment()).append("\n");
                sb.append("====================================\n");
            }
            employeeListArea.setText(sb.toString());
        });

        // Load employees on initial view
        refreshButton.doClick();
    }
}
