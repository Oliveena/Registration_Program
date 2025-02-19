/**
 * @authors Group 6: Trang Trieu, Anastassia Tarassova and Nikita Zelenskiy
 * @version 3.0
 * @since 2024/09/25
 * @link to GitHub [...]</p>
 * <h1>Student Form</h1><br>
 * <br>
 * <p>Description of project:  This is a course registration form, allowing the students to pick their program, associated courses.
 * It contains four classses:
 * <ul>Student Form</ul>
 * This is the Main class of our program.
 * @see Assignements.Team_Project_V1.StudentForm
 * <ul>Student</ul>
 * This class allows the user to enter their first name, last name and desired program. A student ID is randomly generated.
 * @see Assignements.Team_Project_V1.Student
 * <ul>Course</ul>
 * This class allows the user to view and select courses and choose their semester (Summer, Fall, Winter). The course ID and the associated professor are generated by the program for further realism.
 * @see Assignements.Team_Project_V1.Course
 * <ul>Register</ul>
 * This class allows to view the registration date, confirm the number of courses the user wishes to take, and the classroom mode (in person, distance, or hybrid).</p>
 * @see Assignements.Team_Project_V1.Register
 * <br>
 * <h3>Thank you for reading our documentation!</h3>
 * <br>
 */
// (optional) Add @deprecated for classes that shouldn't be used

package Assignements.Team_Project_V1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Date;

public class StudentForm {

    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String BLUE = "\u001B[34m";
    public static String RESET = "\u001B[0m";


    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Register register = new Register();
        Course course = new Course();
        Student student = new Student();
        Date date = new Date();

        // Declare variables
        String f_name, l_name, student_ID; // Student attributes
        int numOfCourses = 0;
        int program_choice = 0;
        int course_choice = 0;
        String[] nameCourses;
        int semester_choice = 0;
        int mode_choice = 0;

        // Course attributes

        // Checks the registered date against the current date
        // Displays current date and welcome message
        register.displayRegister();

        // STUDENT REGISTRATION

        System.out.println("Please enter your first name to check if you are in our records : ");

        f_name = input.nextLine().trim().toLowerCase();

        System.out.println("Please enter your last name : ");
        l_name = input.nextLine().trim().toLowerCase();
        student.setStudentName(f_name, l_name);
        System.out.printf("\nHello, %s\n", GREEN + student.getStudentName() + RESET);

        // Defining absolute path of the file containing list of authorized students
        // Please enter a student's name from our current course so continue with the program
        String filePath = "C:\\Users\\anata\\Desktop\\FINAL_Group 6 final project\\30th October Group 6 final project\\AcceptedStudents.txt";

        // Initializing the ArrayList that will contain data from AcceptedStudents.txt
        ArrayList<String> students = new ArrayList<>();

        // Importing data from AcceptedStudents.txt with a BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(line.trim().toLowerCase());
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file AcceptedStudents.txt");
        }

        // Comparing user entry and ArrayList data
        boolean allowed = students.contains(student.getStudentName());

        if (allowed) {
            System.out.println("You may proceed to registration.");
        } else {
            System.out.println(YELLOW + "Your name is not in our records." + RESET);
            System.out.println(" ");
            System.out.println("Please pay the tuition fees before registering for courses.");
            System.exit(0);
        }

        // Set Student ID
        student.setStudent_ID(f_name, l_name);
        student_ID = student.getStudentID();
        System.out.printf("\nYour student ID number is : %s.\n", GREEN + student_ID + RESET);


        // Program Options
        register.display_programs();
        System.out.print("\nPlease enter program choice (1, 2, 3 or 4 only) : ");
        do {
            try {
                program_choice = input.nextInt();
                if (program_choice < 1 || program_choice > 4)
                    System.out.println("Option " + program_choice + " is invalid");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid Entry! Please enter only numbers between 1 and 4 : ");
                input.nextLine();
            }
        } while (program_choice != 1 && program_choice != 2 && program_choice != 3 && program_choice != 4);

        course.setStudentCourse(program_choice, course_choice);
        course.setProfessor(program_choice);
        System.out.println("\nYour program of choice is : " + YELLOW + course.getProgramName() + RESET);
        System.out.println("\nYour professor for " + YELLOW + course.getProgramName() + RESET + " is : " +
                YELLOW + course.getProfessor() + RESET);

        // Semester Options
        course.displaySemester();
        System.out.println("\nPlease enter semester choice (1,2 or 3 only) : ");
        do {
            try {
                semester_choice = input.nextInt();
                if (semester_choice < 1 || semester_choice > 3)
                    System.out.println("Select either 1, 2 or 3 only!");

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid Entry! Please only enter numbers between 1 and 3 : ");
                input.nextLine();
            }
        } while (semester_choice != 1 && semester_choice != 2 && semester_choice != 3);

        course.setSemester(semester_choice);
        System.out.println("\nYour semester of choice is : " + YELLOW + course.getSemester() + RESET);

        // Classroom mode
        register.display_mode(mode_choice);
        System.out.println("Please enter classroom mode choice (1,2 or 3 only) : ");
        do {
            try {
                mode_choice = input.nextInt();
                if (mode_choice < 1 || mode_choice > 3) System.out.println("Select either 1, 2 or 3 only!");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid Entry! Please only enter numbers between 1 and 3 : ");
                input.nextLine();
            }
        } while (mode_choice != 1 && mode_choice != 2 && mode_choice != 3);

        register.setMode(mode_choice);
        System.out.println("\nYour classroom mode of choice is : " + YELLOW + register.getMode() + RESET);

        // Number of Courses

        // First course selected by user still displays null, no matter which program and which course are being picked first.
        // I thought it had to do with the counter or the course choice storage array, currently out of ideas.

        System.out.println("\nPlease enter the desired number of courses you wish to attend (1, 2, 3 or 4 only) : ");
        do {
            try {
                numOfCourses = input.nextInt();
                if (numOfCourses <= 0 || numOfCourses > 4) System.out.println("Please choose between 1 and 4 courses.");
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid Entry! Please only enter numbers between 1 and 4 : ");
                input.nextLine();
            }
        } while (numOfCourses < 1 || numOfCourses > 4);
        register.setNumCourses(numOfCourses);
        numOfCourses = register.getNumCourses();
        System.out.println("\nYou are registering for " + GREEN + numOfCourses + RESET + " course(s).");
        // Course choices
        System.out.println("\nEnter the desired courses you wish to attend in: " + YELLOW + course.getProgramName() + RESET);


        nameCourses = new String[numOfCourses];
        course.displayCourseInfo(program_choice);
        System.out.print("Please enter course choice (1, 2, 3 or 4 only) : ");

        // storing the selected courses, because there may be more than one!
        int[] selectedCourses = new int[numOfCourses];

        int counter = 0;

        // choosing courses where i is number of courses being selected by user
        for (int i = 0; i < numOfCourses; i++) {
            try {
                course_choice = input.nextInt();
                // Validate the course choice
                while (course_choice < 1 || course_choice > 4) {
                    System.out.println("\nSelect either 1, 2, 3 or 4 only!");
                    course_choice = input.nextInt();
                }

                // we would check here is the course was already selected or not
                // i don;t know how to do this while keeping the progress achieved

                // storing selected courses into an array
                selectedCourses[counter] = course_choice;
                System.out.println("You have selected " + course.getCourseName());
                course.setProfessor(counter + 1);
                nameCourses[counter] = course.getCourseName();
                course.setStudentCourse(program_choice, course_choice);
                counter++;

            } catch (InputMismatchException e) {
                System.out.printf("%nInvalid Entry! Please enter only numbers between 1 and 4 : ");
                input.nextLine();
                i--;
            }
        }

        input.close();
        System.out.println("\nYou have selected : " + GREEN + numOfCourses + RESET + " courses.\n");


        System.out.println("\nYou have selected : " + GREEN + numOfCourses + RESET + " courses.\n");


        System.out.println("Your program of choice is : " + YELLOW + course.getProgramName() + RESET +
                GREEN + "( ID = " + course.getProgram_ID() + " ).\n" + RESET + YELLOW +
                course.getProgramName() + RESET + "'s professor is : " + YELLOW + course.getProfessor() + RESET);
        for (int i = 0; i < numOfCourses; i++) {
            System.out.println("Your course of choice is : " + YELLOW + nameCourses[i] + RESET);
        }

        System.out.println("\n\tSUMMARY:");
        System.out.println(BLUE + "\n\t=================================");
        System.out.println("\tYOUR STUDENT CREDENTIALS:");
        System.out.println("\t=================================" + RESET);
        System.out.println("\tYour Full Name: " + YELLOW + student.getStudentName() + RESET);
        System.out.println("\tYour Student ID: " + YELLOW + student.getStudentID() + RESET);
        System.out.println(BLUE + "\t=================================");
        System.out.println("\tYOUR CLASSES' DETAILS:");
        System.out.println("\t=================================" + RESET);
        System.out.println("\tYour program of choice is : " + GREEN + course.getProgramName() + RESET);
        System.out.println("\tYour Professor for " + GREEN + course.getProgramName() + RESET + " is : " + YELLOW + course.getProfessor() + RESET);
        System.out.println("\tYour courses for " + GREEN + course.getProgramName() + RESET + " are : ");
        for (int i = 0; i < numOfCourses; i++) {
            System.out.println(GREEN + "\t" + nameCourses[i]);
        }
        System.out.println(RESET + "\tYour semester of choice is : " + GREEN + course.getSemester() + RESET);
        System.out.println("\tYour choice of classroom mode is : " + GREEN + register.getMode() + RESET);


        System.out.printf("\n\tRegistration successfully completed on : " + BLUE + date.toString() + RESET);
        System.out.println("\n");
        System.out.println("\tThe summary of yur registrations details have been output to RegistrationSummary.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("RegistrationSummary.txt"));
            bw.write("\tSUMMARY:\n" +
                    "\t=================================\n" +
                    "\tYOUR STUDENT CREDENTIALS:\n" +
                    "\t=================================\n" +
                    "\n" +
                    "\tYour Full Name: \n" +
                    "\t" + student.getStudentName() + "\n" +
                    "\tYour Student ID: \n" +
                    "\n" +
                    "\t" + student.getStudentID() + "\n" +
                    "\t=================================\n" +
                    "\tYOUR CLASSES' DETAILS:\n" +
                    "\t=================================\n" +
                    "\n" +
                    "\tYour program of choice is : \n" +
                    "\t" + course.getProgramName() + "\n" +
                    "\n" +
                    "\tYour Professor for " + course.getProgramName() + " is : " + course.getProfessor() + "\n");

            // I have not figured out how to output an if...else loop result into a BufferedWriter output
            //"\tYour courses for " + course.getProgramName() + " are : ###" + "\n");
            //bw.write(for (int i = 0; i < numOfCourses; i++) {
            //System.out.println(GREEN + "\t" + nameCourses[i]);
            // } );

            bw.write("\tYour semester of choice is : " + course.getSemester() + "\n" +
                    "\tYour choice of classroom mode is : " + register.getMode() + "\n" +
                    "\n\tYour registration summary has been saved to RegistrationSummary.txt");
            bw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.exit(0);
        }
    }
}