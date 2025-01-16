import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {
    public Sidebar(JFrame frame, EmployeeManager employeeManager) {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBackground(new Color(70, 130, 180));

        JButton viewButton = createStyledButton("View Employees");
        JButton addButton = createStyledButton("Add Employee");
        JButton searchButton = createStyledButton("Search Employee");
        JButton deleteButton = createStyledButton("Delete Employee");
        JButton updateButton = createStyledButton("Update Employee");

        viewButton.addActionListener(e -> switchPanel(frame, new ViewPanel(employeeManager)));
        addButton.addActionListener(e -> switchPanel(frame, new AddPanel(employeeManager)));
        searchButton.addActionListener(e -> switchPanel(frame, new SearchPanel(employeeManager)));
        deleteButton.addActionListener(e -> switchPanel(frame, new DeletePanel(employeeManager)));
        updateButton.addActionListener(e -> switchPanel(frame, new UpdatePanel(employeeManager)));

        add(viewButton);
        add(addButton);
        add(searchButton);
        add(deleteButton);
        add(updateButton);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private void switchPanel(JFrame frame, JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(this, BorderLayout.WEST);
        frame.getContentPane().add(newPanel, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
    }
}
