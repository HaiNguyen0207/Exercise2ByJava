package Lesson1;

public class Employee {
    private String id; //mã nhân viên
    private String fullName;    //họ tên
    private String address; //địa chỉ
    private int age;    //tuổi
    private String number;  //số điện thoại
    private float wage; //mức lương
    private float exp;//kinh nghiệm

    public Employee() {
        id = "";
        fullName = "";
        address = "";
        age = 0;
        number = "";
        wage = 0f;
        exp = 0;
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String fullName) {
        this(id);
        this.fullName = fullName;
    }

    public Employee(String id, String fullName, String address) {
        this(id, fullName);
        this.address = address;
    }

    public Employee(String id, String fullName, String address, int age) {
        this(id, fullName, address);
        this.age = age;
    }

    public Employee(String id, String fullName, String address, int age, String number) {
        this(id, fullName, address, age);
        this.number = number;
    }

    public Employee(String id, String fullName, String address, int age, String number, float wage) {
        this(id, fullName, address, age, number);
        this.wage = wage;
    }

    public Employee(String id, String fullName, String address, int age, String number, float wage, float exp) {
        this(id, fullName, address, age, number, wage);
        this.exp = exp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

}
