package Model.work;

public class manager {
    private Integer ID;
    private String FirstName;
    private Integer Code;
    private String Atribute;
    private Double Salary;

    public manager(Integer id, String firstName, Integer code, String atribute, Double salary) {
        this.ID = id;
        this.FirstName = firstName;
        this.Code = code;
        this.Atribute = atribute;
        this.Salary = salary;
        System.out.println(ID+" "+FirstName+" "+Code+" "+Atribute+" "+Salary);

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getAtribute() {
        return Atribute;
    }

    public void setAtribute(String atribute) {
        Atribute = atribute;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }
//   Salary public workers(Integer key, String name, Integer code, String atriute, Double salary) {
//    }
}