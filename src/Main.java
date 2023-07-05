import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class Main{
public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
    Scanner scnr = new Scanner(System.in);

    menu();

    }



    public static void menu() throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        HashMap<Integer, StudentRecord> studentHash = new HashMap<Integer, StudentRecord>();
        SortedList studentList = new SortedList();
        Scanner file = null;



        int choice;
        do {
            System.out.println("choose option:");
            System.out.println("1. open a file");
            System.out.println("2. add a new student");
            System.out.println("3. remove a student");
            System.out.println("4. look up info");
            System.out.println("5. add course to student");
            System.out.println("6. display student info");
            System.out.println("7. save student file");
            choice = scnr.nextInt();}
        while(choice > 6 && choice < 1);

        switch(choice) {
            case 1:
                FileInputStream input = null;

                String fileName;
                System.out.println("What is the name of the file (ex: student.txt)");
                fileName = scnr.next();
                try {
                    input = new FileInputStream(fileName);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                file = new Scanner(input);

            case 2:
                studentList.insertSorted(addStudent(studentList, file));
                menu();
                break;
            case 3:
                removeStudent(studentList, file);
                menu();
                break;
            case 4:
                lookUp(studentList, file).toStringNew();
                menu();
                break;
            case 5:
                addCourse(studentList, file);
                menu();
                break;
            case 6:
                infoDisplay(studentList, file);
                menu();
                break;
            case 7:
                output(studentList);
                file.close();
                break;


        }

        scnr.close();


        }


    public static StudentRecord addStudent(SortedList LL, Scanner file) {
        String first = file.nextLine();
        String last = file.nextLine();

        String ID = file.next();
        Double gpa = file.nextDouble();
        int credits = file.nextInt();
        StudentRecord stu = new StudentRecord(first, last, ID, gpa, credits);

        LL.insertSorted(stu);
        System.out.println("Student added");
        System.out.println(stu.toStringNew());
        return stu;


    }


    public static void removeStudent(SortedList LL, Scanner file) throws FileNotFoundException {
        StudentRecord stuRemove = new StudentRecord();

        String idSearch;

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is the ID of the student?");

        idSearch = scnr.next();

        stuRemove = LL.searchID(idSearch);

        LL.deleteSorted(stuRemove);

        scnr.close();

        menu();


    }
    public static StudentRecord lookUp(SortedList LL, Scanner file) {
        String Id;
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is the students id number?");
        Id = scnr.next();
        StudentRecord stu = LL.searchID(Id);
        System.out.println(stu.toStringNew());

        scnr.close();
        return LL.searchID(Id);


    }
    public static void addCourse(SortedList LL, Scanner file) throws FileNotFoundException {
        int newCredits;
        double newGPA;
        StudentRecord affectedStu;

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is the students ID number?");
        affectedStu = LL.searchID(scnr.next());
        System.out.println("how many credits is the course?");
        newCredits = scnr.nextInt();
        System.out.println("What is the gpa in the class?");
        newGPA = scnr.nextDouble();
        affectedStu.newGrade(newCredits, newGPA);

        System.out.println("Done");


        menu();

    }
    public static void infoDisplay(SortedList LL, Scanner file) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);

        String ID;

        System.out.println("What is the ID number");
        ID = scnr.next();

        StudentRecord stu = new StudentRecord();
        stu = LL.searchID(ID);

        System.out.println(stu.toStringNew());

        scnr.close();
        try {
            menu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void output(SortedList LL) throws FileNotFoundException {
        FileOutputStream out = new FileOutputStream("updatedStu.txt");
        PrintWriter writeOut = new PrintWriter(out);
        writeOut.println(LL.toString());
        writeOut.close();


    }


}
