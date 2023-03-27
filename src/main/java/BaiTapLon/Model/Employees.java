package BaiTapLon.Model;

public class Employees {
    private  String employees_id;
    private String employees_name;
    private String gender;
    private String email;
    private String phone_number;
    private String employees_job;
    private long salary;
    private String department_id;

    public Employees() {
    }

    public Employees(String employees_id, String employees_name, String gender, String email, String phone_number, String employees_job, long salary, String department_id) {
        this.employees_id = employees_id;
        this.employees_name = employees_name;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.employees_job = employees_job;
        this.salary = salary;
        this.department_id = department_id;
    }

    public String getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(String employees_id) {
        this.employees_id = employees_id;
    }

    public String getEmployees_name() {
        return employees_name;
    }

    public void setEmployees_name(String employees_name) {
        this.employees_name = employees_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmployees_job() {
        return employees_job;
    }

    public void setEmployees_job(String employees_job) {
        this.employees_job = employees_job;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees_id='" + employees_id + '\'' +
                ", employees_name='" + employees_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", employees_job='" + employees_job + '\'' +
                ", salary=" + salary +
                ", department_id='" + department_id + '\'' +"\n"+
                '}';
    }
}
