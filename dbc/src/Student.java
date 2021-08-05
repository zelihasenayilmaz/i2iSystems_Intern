import java.util.Scanner;

public class Student {

    int age;

    public Student(int age) {

        this.age = age;
    }

    public static void main(String[] args) {
        Student student = new Student(12);

        System.out.println("Enter the age: ");
        Scanner input = new Scanner(System.in);
        student.age = input.nextInt();

        if (student.age > 4 && student.age <7) {
            System.out.println("Can enrolled in kindergarten school.");
        } else if (student.age > 7 && student.age <15) {
            System.out.println("Can enrolled in primary school.");
        } else {
            System.out.println("Cannot enrolled.");
        }

        assert student.age > 4 : "Cannot enrolled in kindergarten school.";
        assert student.age > 7 : "Cannot enrolled in primary school";

    }
}
