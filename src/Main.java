import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            EmployeeManager employeeManager = new EmployeeManager();

            Sidebar sidebar = new Sidebar(frame, employeeManager);
            frame.add(sidebar, BorderLayout.WEST);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            frame.add(mainPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
