package java8;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private int yearOfJoining;
    private double salary;
    private String gender;

    public Employee(int id,String name,int age, String department,int yearOfJoining,double salary,String gender){
        this.id=id;
        this.name=name;
        this.age=age;
        this.department=department;
        this.yearOfJoining=yearOfJoining;
        this.salary=salary;
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

  public void setDepartment(String department){
        this.department=department;
  }
  public void setYearOfJoining(int yearOfJoining){
        this.yearOfJoining=yearOfJoining;
  }
  public void setSalary(double salary){
        this.salary=salary;
  }

  public int getId(){
        return id;
  }
  public String getName(){
        return name;
  }
  public int getAge(){
        return age;
  }
  public String getDepartment() {
    return department;
  }
  public int getYearOfJoining(){
        return yearOfJoining;
  }
  public double getSalary(){
        return salary;
  }
  public String toString(){
        return "Id:"+id
                +",Name:"+name
                +",age:"+age
                +",Department:"+department
                +",Year Of Joining:"+yearOfJoining
                +",Salary:"+salary
                +",Gender:"+gender;
  }

}
