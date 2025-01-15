import javax.swing.*;

public class Sidebar extends JPanel {
    public Sidebar(JFrame frame, EmployeeManager employeeManager) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton viewButton = new JButton("View Employees");
        JButton addButton = new JButton("Add Employee");
        JButton searchButton = new JButton("Search Employee");
        JButton deleteButton = new JButton("Delete Employee");
        JButton updateButton = new JButton("Update Employee");

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

    private void switchPanel(JFrame frame, JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(this);
        frame.getContentPane().add(newPanel);
        newPanel.setBounds(200, 0, 600, 600);
        frame.repaint();
        frame.revalidate();
    }
}
