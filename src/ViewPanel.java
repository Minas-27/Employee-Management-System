import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {
    private JTextArea employeeListArea;

    public ViewPanel(EmployeeManager employeeManager) {
        setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("View Employees");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        employeeListArea = new JTextArea();
        employeeListArea.setEditable(false);
        add(new JScrollPane(employeeListArea), BorderLayout.CENTER);

        refreshList(employeeManager);
    }

    public void refreshList(EmployeeManager employeeManager) {
        StringBuilder list = new StringBuilder();
        for (Employee employee : employeeManager.getEmployees()) {
            list.append("Name: ").append(employee.getName())
                    .append(", Age: ").append(employee.getAge())
                    .append(", Department: ").append(employee.getDepartment())
                    .append("\n");
        }
        employeeListArea.setText(list.toString());
    }
}
