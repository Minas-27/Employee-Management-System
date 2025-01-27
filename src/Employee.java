import java.util.UUID;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
