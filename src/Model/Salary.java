package Model;

public class Salary {
    private Integer Salary;
    public Salary(Integer code) {
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
