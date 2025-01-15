import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(null);

            EmployeeManager employeeManager = new EmployeeManager();

            Sidebar sidebar = new Sidebar(frame, employeeManager);
            sidebar.setBounds(0, 0, 200, 600);
            frame.add(sidebar);

            frame.setVisible(true);
        });
    }
}
