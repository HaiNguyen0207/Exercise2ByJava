package Lesson1;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        var input = new Scanner(System.in);
        createNewEmployees(employees);
        var choice = 0;
        do {
            out.println("===========================MENU===========================");
            out.println("= 1. Thêm mới một nhân viên vào danh sách                =");
            out.println("= 2. Hiển thị danh sách nhân viên                        =");
            out.println("= 3. Tìm nhân viên theo tên                              =");
            out.println("= 4. Xóa nhân viên theo mã                               =");
            out.println("= 0. Kết thúc chương trình                               =");
            out.println("==========================================================");
            out.println("=======================> Mời lựa chọn <===================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    out.println("===================> Hẹn gặp lại <===================");
                    break;
                case 1:
                    var addEmp = createNewEmployee(input);
                    employees.add(addEmp);
                    out.println("============> Thêm nhân viên thành công <============");
                    break;
                case 2:
                    if (employees.size() > 0) {
                        showEmps(employees);
                    } else {
                        out.println("==============> Danh sách nhân viên rỗng <==============");
                    }
                    break;
                case 3:
                    if (employees.size() > 0) {
                        out.println("Nhập tên cần tìm : ");
                        input.nextLine();
                        var name = input.next();
                        var result = findEmpByName(employees, name);
                        if (result.size() > 0) {
                            out.println("============> Đã tìm thấy : " + result.size() + " kết quả <============");
                            showEmps(result);
                        } else {
                            out.println("=============> Không tìm thấy tên này <==============");
                        }

                    } else {
                        out.println("===============> Danh sách nhân viên rỗng <===============");
                    }
                    break;
                case 4:
                    if (employees.size() > 0) {
                        out.println("Nhập mã nhân viên cần xóa : ");
                        input.nextLine();
                        var id = input.nextLine();
                        var isSuccess = removeEmpById(employees, id);
                        if (isSuccess) {
                            out.println("=============> Xóa ID : " + id + " thành công <==============");
                        } else {
                            out.println("=============> Xóa ID : " + id + " thất bại  <===============");
                        }
                    } else {
                        out.println("==============> Danh sách nhân viên rỗng <==============");
                    }
                    break;
                default:
                    out.println("=========> Sai chức năng ! Vui lòng nhập lại <==========");
                    break;
            }

        } while (choice != 0);
    }

    /**
     * phương thức xóa nhân viên theo mã
     *
     * @param employees danh sách nhân viên gốc
     * @param id        mã nhân viễn cần xóa
     * @return true nếu xóa thành công ,flase nếu ngược lại
     */
    private static boolean removeEmpById(ArrayList<Employee> employees, String id) {
        for (var emp : employees) {
            if (emp.getId().compareToIgnoreCase(id) == 0) {
                employees.remove(emp);
                return true;
            }
        }
        return false;
    }

    /**
     * phương thức tìm kiếm nhân viên theo tên
     *
     * @param employees danh sách nhân viên gốc
     * @param name      tên cần tìm
     * @return emp
     */
    private static ArrayList<Employee> findEmpByName(ArrayList<Employee> employees, String name) {
        ArrayList<Employee> emp = new ArrayList<>();
        for (var s : employees) {
            var fristName = getFristName(s.getFullName());
            if (fristName.compareToIgnoreCase(name) == 0) {
                emp.add(s);
            }
        }
        return emp;
    }

    /**
     * phương thức tách lấy tên
     *
     * @param fullName họ tên cần tách
     * @return tên
     */
    private static String getFristName(String fullName) {
        var index = fullName.lastIndexOf(" ");
        return fullName.substring(index + 1);
    }

    /**
     * phương thức hiển thị danh sách nhân viên theo dạng cột
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showEmps(ArrayList<Employee> employees) {
        out.printf("%-20s%-20s%-20s%-15s%-20s%-20s%-15s\n", "Mã NV", "Họ Tên", "Địa chỉ", "Tuổi", "Số DT", "Lương", "Năm KN");
        for (var emp : employees) {
            showEmp(emp);
        }
    }

    /**
     * phương thức hiển thị 1 nhân viên theo dạng cột
     *
     * @param emp nhân viên đc hiển thị
     */
    private static void showEmp(Employee emp) {
        out.printf("%-20s%-20s%-20s%-15d%-20s%-20.2f%-15.2f\n", emp.getId(), emp.getFullName(), emp.getAddress(),
                emp.getAge(), emp.getNumber(), emp.getWage(), emp.getExp());
    }

    /**
     * phương thức thêm mới 1 nhân viên
     *
     * @param input đối tượng của lớp Scanner
     * @return nhân viên vừa tạo
     */
    private static Employee createNewEmployee(Scanner input) {
        out.println("Nhập mã nhân viên : ");
        input.nextLine();
        var id = input.nextLine();
        out.println("Nhập họ tên : ");
        var fullName = input.nextLine();
        out.println("Nhập địa chỉ : ");
        var address = input.nextLine();
        out.println("Nhập tuổi : ");
        var age = Integer.parseInt(input.nextLine());
        out.println("Nhập số điện thoại : ");
        var number = input.nextLine();
        out.println("Nhập mức lương : ");
        var wage = Float.parseFloat(input.nextLine());
        out.println("Nhập năm kinh nghiệm : ");
        var exp = Float.parseFloat(input.nextLine());
        return new Employee(id, fullName, address, age, number, wage, exp);
    }

    /**
     * phương thức tạo ra đối tượng
     * tiết kiệm thời gian chạy chương trình
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void createNewEmployees(ArrayList<Employee> employees) {
        employees.add(new Employee("NV001", "Nguyễn Văn A", "Hà Nội", 19, "0983638abc",
                9000f, 2.5f));
        employees.add(new Employee("NV002", "Nguyễn Văn B", "Hà Nội", 19, "0983638abc",
                9000f, 2.5f));
        employees.add(new Employee("NV003", "Nguyễn Thị C", "Hà Nội", 19, "0983638abc",
                9000f, 2.5f));
        employees.add(new Employee("NV004", "Nguyễn Văn D", "Hà Nội", 19, "0983638abc",
                9000f, 2.5f));
        employees.add(new Employee("NV005", "Nguyễn Văn E", "Hà Nội", 19, "0983638abc",
                9000f, 2.5f));

    }

}
