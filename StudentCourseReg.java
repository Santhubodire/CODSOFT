import java.util.ArrayList;
import java.util.Scanner;

class Crse {
    private String code;
    private String title;
    private String desc;
    private int cap;
    private int slots;

    public Crse(String code, String title, String desc, int cap) {
        this.code = code;
        this.title = title;
        this.desc = desc;
        this.cap = cap;
        this.slots = cap;
    }

    public String getCode() { return code; }
    public int getSlots() { return slots; }

    public boolean regStu() {
        if (slots > 0) {
            slots--;
            return true;
        } else {
            return false;
        }
    }

    public void dropStu() {
        if (slots < cap) {
            slots++;
        }
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Title: " + title + ", Description: " + desc +
                ", Slots: " + slots + "/" + cap;
    }
}

class Stu {
    private String id;
    private String name;
    private ArrayList<Crse> enrolledCrse;

    public Stu(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCrse = new ArrayList<>();
    }

    public String getId() { return id; }

    public void enroll(Crse crse) {
        if (!enrolledCrse.contains(crse)) {
            enrolledCrse.add(crse);
        }
    }

    public void drop(Crse crse) {
        enrolledCrse.remove(crse);
    }

    public ArrayList<Crse> getCourses() { return enrolledCrse; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

class RegSystem {
    private ArrayList<Crse> crses;
    private ArrayList<Stu> stus;

    public RegSystem() {
        crses = new ArrayList<>();
        stus = new ArrayList<>();
    }

    public void addCrse(Crse crse) {
        crses.add(crse);
    }

    public void addStu(Stu stu) {
        stus.add(stu);
    }

    public void listCrse() {
        System.out.println("Available Courses:");
        for (Crse crse : crses) {
            System.out.println(crse);
        }
    }

    public Stu findStu(String stuId) {
        for (Stu stu : stus) {
            if (stu.getId().equals(stuId)) {
                return stu;
            }
        }
        return null;
    }

    public Crse findCrse(String crseCode) {
        for (Crse crse : crses) {
            if (crse.getCode().equals(crseCode)) {
                return crse;
            }
        }
        return null;
    }

    public boolean regStuToCrse(String stuId, String crseCode) {
        Stu stu = findStu(stuId);
        Crse crse = findCrse(crseCode);

        if (stu == null) {
            System.out.println("Registration failed: Student ID not found.");
            return false;
        }

        if (crse == null) {
            System.out.println("Registration failed: Course code not found.");
            return false;
        }

        if (crse.regStu()) {
            stu.enroll(crse);
            System.out.println("Registration successful!");
            return true;
        } else {
            System.out.println("Registration failed: Course is full.");
            return false;
        }
    }

    public boolean dropStuFromCrse(String stuId, String crseCode) {
        Stu stu = findStu(stuId);
        Crse crse = findCrse(crseCode);
        if (stu != null && crse != null && stu.getCourses().contains(crse)) {
            crse.dropStu();
            stu.drop(crse);
            System.out.println("Course dropped successfully!");
            return true;
        }
        System.out.println("Failed to drop course.");
        return false;
    }

    public void showStuCrse(String stuId) {
        Stu stu = findStu(stuId);
        if (stu != null) {
            System.out.println("Courses for " + stu.getId() + ":");
            for (Crse crse : stu.getCourses()) {
                System.out.println(crse);
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class StudentCourseReg {
    public static void main(String[] args) {
        RegSystem sys = new RegSystem();
        sys.addCrse(new Crse("CS101", "Intro to CS", "Basics of programming", 10));
        sys.addCrse(new Crse("MATH101", "Calculus I", "Intro to calculus", 10));
        sys.addCrse(new Crse("BIO101", "Biology Basics", "Fundamentals of biology", 10));
        sys.addCrse(new Crse("CHEM101", "Chemistry Basics", "Intro to chemistry", 10));
        sys.addCrse(new Crse("PHY101", "Physics I", "Intro to physics", 10));
        sys.addCrse(new Crse("ENG101", "English Literature", "Study of English literature", 10));
        sys.addCrse(new Crse("HIST101", "History of World", "Intro to world history", 10));
        sys.addCrse(new Crse("MATH201", "Linear Algebra", "Advanced math course", 10));

        Scanner sc = new Scanner(System.in);
        String stuId, crseCode, stuName;

        while (true) {
            System.out.println("\n1. Add Student in the System\n2. List of Courses\n3. Register\n4. Drop a Course\n5. View Courses Registered\n6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    stuId = sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    stuName = sc.nextLine();
                    sys.addStu(new Stu(stuId, stuName));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    sys.listCrse();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    stuId = sc.nextLine();
                    System.out.print("Enter Course Code: ");
                    crseCode = sc.nextLine();
                    sys.regStuToCrse(stuId, crseCode);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    stuId = sc.nextLine();
                    System.out.print("Enter Course Code: ");
                    crseCode = sc.nextLine();
                    sys.dropStuFromCrse(stuId, crseCode);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    stuId = sc.nextLine();
                    sys.showStuCrse(stuId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
