import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите информацию о сотруднике (фамилия)");
            String surname = scanner.next();
            System.out.println("Введите информацию о сотруднике (имя)");
            String name = scanner.next();
            System.out.println("Введите информацию о сотруднике (возраст)");
            int age = scanner.nextInt();
            System.out.println("Введите информацию о сотруднике (пол)");
            String gender = scanner.next();
            System.out.println("Введите информацию о сотруднике (образование)");
            String education = scanner.next();
            System.out.println("Введите информацию о сотруднике (должность)");
            String occupation = scanner.next();
            System.out.println("Введите информацию о сотруднике (отдел)");
            String department = scanner.next();
            Employee employee = new Employee(surname, name, age, gender, education, occupation, department);
            employees.add(employee);
            System.out.println("Для завершения программы, введите, пожалуйста, 'end'! Для продолжения программы 'continue'!");
            String input = scanner.next();
            if (input.equals("end")) {
                System.out.println("Программа завершена!");
                for (int i = 0; i < employees.size(); i++) {
                    System.out.println(employees.get(i).toString());
                }
                break;
            }
        }

        while (true) {
            System.out.println("Если не хотите менять данные, введите 'end'! Для внесения изменений 'continue'!");
            String input = scanner.next();
            if (input.equals("end")) {
                System.out.println("Программа завершена!");
                break;
            }
            System.out.println("Введите фамилию и имя работника, для которого хотите внести изменения");
            System.out.println("Введите фамилию");
            String surname = scanner.next();
            System.out.println("Введите имя");
            String name = scanner.next();
            int empIndex = searchBySurname(surname, name, employees);
            if (empIndex != -1) {
                while (true) {
                    System.out.print("""
                            Выберите что хотите изменить:
                            1. Имя
                            2. Фамилия
                            3. Возраст
                            4. Пол
                            5. Образование
                            6. Должность
                            7. Отдел
                            0. Выйти
                            """);
                    int option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                    switch (option) {
                        case 1 -> {
                            System.out.println("Введите новое имя: ");
                            String nName = scanner.next();
                            employees.get(empIndex).setName(nName);
                        }
                        case 2 -> {
                            System.out.println("Введите новую фамилию: ");
                            String nSurname = scanner.next();
                            employees.get(empIndex).setSurname(nSurname);
                        }
                        case 3 -> {
                            System.out.println("Введите новый возраст: ");
                            int nAge = scanner.nextInt();
                            employees.get(empIndex).setAge(nAge);
                        }
                        case 4 -> {
                            System.out.println("Введите новый пол: ");
                            String nGender = scanner.next();
                            employees.get(empIndex).setGender(nGender);
                        }
                        case 5 -> {
                            System.out.println("Введите новое образование: ");
                            String nEducation = scanner.next();
                            employees.get(empIndex).setEducation(nEducation);
                        }
                        case 6 -> {
                            System.out.println("Введите новую должность: ");
                            String occupation = scanner.next();
                            employees.get(empIndex).setOccupation(occupation);
                        }
                        case 7 -> {
                            System.out.println("Введите новый отдел: ");
                            String nDepartment = scanner.next();
                            employees.get(empIndex).setDepartment(nDepartment);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }

    public static int searchBySurname(String surname, String name, List<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            String thisName = list.get(i).getName();
            String thisSurname = list.get(i).getSurname();
            if (thisName.equals(name) && thisSurname.equals(surname)) {
                return i;
            }
        }
        return -1;
    }
}