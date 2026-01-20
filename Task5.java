import java.io.*;
import java.util.*;

class Student implements Serializable {
    String name;
    int rollNo;
    String grade;

    public Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> s = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        s.add(new Student(name, roll, grade));
        System.out.println("Student added successfully!");
    }

    void displayStudents() {
        if (s.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student st : s) {
                System.out.println(st);
            }
        }
    }

    void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        for (Student st : s) {
            if (st.rollNo == roll) {
                System.out.println("Student Found: " + st);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void removeStudent() {
        System.out.print("Enter Roll Number to remove: ");
        int roll = sc.nextInt();

        Iterator<Student> it = s.iterator();
        while (it.hasNext()) {
            Student st = it.next();
            if (st.rollNo == roll) {
                it.remove();
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
            oos.writeObject(s);
            oos.close();
            System.out.println("Data saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            s = (ArrayList<Student>) ois.readObject();
            ois.close();
            System.out.println("Data loaded from file.");
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }

    void menu() {
        loadFromFile();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: removeStudent(); break;
                case 5:
                    saveToFile();
                    System.out.println("Thank you! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}

