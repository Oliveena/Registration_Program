/**
 * <p>The Register class represents the requirement students need to choose when the register courses.</p>
 * It includes registration date, number of courses, and classroom mode.
 * @author Trang Trieu
 * @since 2024-10-25
 * @see Student, Course, StudentForm
 * <br>
 * numCourses = int
 * mode = String
 * displayRegister(): void
 * display_mode(): void
 * setNumCourses(): void
 * setMode(): void
 * getNumCourses(): void
 * getMode(): void
 */

package Assignements.Team_Project_V1;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Register {

    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    private int numCourses;
    private String mode;

    /**
     * Check the current date if it fits with the registered date
     */
    public void displayRegister(){
        // get the current date
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(currentDate);
        System.out.println("\nRegistration date is October 30, 2024");
        System.out.println("Current date : " + GREEN + date + RESET);

        System.out.println(YELLOW + """
                
                WELCOME TO THE REGISTRATION!
                
                STEPS:
                1 -> Student Registration
                2 -> Program + Courses Selection
                3 -> Each program has its unique ID and you, as a student, will be provided with a unique ID :)
                4 -> Your registration confirmation will be available in "Info.txt"
                """ + RESET);
    }

    /**
     * display program choice
     */
    public void display_programs() {
        System.out.println(YELLOW + """                    
                
                \t1 -> Pure and Applied Sciences
                \t2 -> Psychology
                \t3 -> Computer Science
                \t4 -> Fine Arts""" + RESET);
    }

    /**
     * display classroom mode choice
     * @param mode_choice
     */
    public void display_mode(int mode_choice) {
        System.out.println(YELLOW + """
                
                1 -> In Person
                2 -> Online
                3 -> Hybrid
                """ + RESET);
    }

    // Setter for number of courses

    /**
     * set number of courses
     * @param numCourses
     */
    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    // Setter for classroom mode

    /**
     * set classroom mode
     * @param choice
     */
    public void setMode(int choice) {
        switch(choice){
            case 1:
                mode = "In Person";
                break;
            case 2:
                mode = "Online";
                break;
            case 3:
                mode = "Hybrid";
                break;
        }
    }

    // Getter for number of courses

    /**
     *
     * @return according number of courses students choose
     */
    public int getNumCourses() {
        return numCourses;
    }

    // Getter for classroom mode // user's choice

    /**
     *
     * @return according classroom mode students choose
     */
    public String getMode() {
        return mode;
    }
}
