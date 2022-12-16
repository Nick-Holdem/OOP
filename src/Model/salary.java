package Model;

public class salary {
    private Integer Salary;
    public salary(Integer code) {
        this.Salary = code;
        System.out.println(Salary);
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }
}
