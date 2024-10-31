/**
 * <p>The Course class represents the requirement students need to choose when the register courses.</p>
 * It includes course name, program ID, semester, professor, and course ID.
 * @author Nikita Zelenskiy
 * @since 2024-10-25
 * @see StudentForm, Register, Student
 * -program_name: String
 * -course_name: String
 * -course_ID: String
 * -semester: String
 * -professor: String
 * <br>
 * +setStudentCourse(): void
 * +setProgramName(int choice): void
 * +setSemester(int choice): void
 * +setProfessor(int choice): void
 * +setProgram_ID(int choice): void
 * +displayCourse(int program_choice): void
 * +displaySemester(int semester): void
 * +getSemester() : String
 * +getProfessor() : String
 * +getCourse_ID() : String
 * +getProgramName() : String
 */

package Assignements.Team_Project_V1;

import java.util.Random;

public class Course {

    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    Random random = new Random();

    private String program_name;
    private String course_name;
    private String program_ID;
    private String semester;
    private String professor;

    /**
     * set Student Course with program choice and course choice
     * @param program_choice
     * @param course_choice
     */
    public void setStudentCourse(int program_choice, int course_choice) {
        switch (program_choice) {
            case 1:
                program_name = "Pure and Applied Sciences";
                setProgram_ID(1);
                switch (course_choice) {
                    case 1:
                        course_name = "Physics";
                        break;
                    case 2:
                        course_name = "Chemistry";
                        break;
                    case 3:
                        course_name = "Mathematics";
                        break;
                    case 4:
                        course_name = "Statistics";
                        break;
                }
                break;
            case 2:
                program_name = "Psychology";
                setProgram_ID(2);
                switch (course_choice) {
                    case 1:
                        course_name = "Human Development 101";
                        break;
                    case 2:
                        course_name = "Neuroscience";
                        break;
                    case 3:
                        course_name = "Brain Anatomy of a Developer";
                        break;
                    case 4:
                        course_name = "Childhood Development";
                        break;
                }
                break;
            case 3:
                program_name = "Computer Science";
                setProgram_ID(3);
                switch (course_choice) {
                    case 1:
                        course_name = "JAVA";
                        break;
                    case 2:
                        course_name = "SQL DATABASE";
                        break;
                    case 3:
                        course_name = "C++";
                        break;
                    case 4:
                        course_name = "PHP";
                        break;
                }
                break;
            case 4:
                program_name = "Fine Arts";
                setProgram_ID(4);
                switch (course_choice) {
                    case 1:
                        course_name = "Drawing";
                        break;
                    case 2:
                        course_name = "Sculpture";
                        break;
                    case 3:
                        course_name = "History of Art";
                        break;
                    case 4:
                        course_name = "Color Theory";
                        break;
                }
                break;
        } // switch 1
    } // method

    /**
     * set Program ID with program choice
     * @param program_choice
     */
    public void setProgram_ID(int program_choice) {
        int id = random.nextInt(100, 1000);
        switch (program_choice) {
            case 1:
                program_ID = "PAP" + id;
                break;
            case 2:
                program_ID = "PSY" + id;
                break;
            case 3:
                program_ID = "CS" + id;
                break;
            case 4:
                program_ID = "FAR" + id;
                break;
        }
    }

    /**
     * set Semester with semester choice
     * @param semester_choice
     */
    public void setSemester(int semester_choice) {
        switch (semester_choice) {
            case 1:
                semester = "WINTER";
                break;
            case 2:
                semester = "SPRING";
                break;
            case 3:
                semester = "SUMMER";
                break;
        }
    }

    /**
     * assign professor with professor choice
     * @param professor_choice
     */
    public void setProfessor(int professor_choice) {
        switch (professor_choice) {
            case 1: // Computer Science
                professor = "M. Bill Gates";
                break;
            case 2: // pure applied
                professor = "M. Elon Musk";
                break;
            case 3: // Psy
                professor = "M. Khattar Daou";
                break;
            case 4: // Fine Arts
                professor = "M. Snoop Dogg";
                break;
        }
    }

    public void displaySemester(){
        System.out.println(YELLOW + """
                   
                    \t1 -> Winter
                    \t2 -> Spring
                    \t3 -> Summer""" + RESET);
    }

    /**
     * display course information
     * @param program_choice
     */
    public void displayCourseInfo(int program_choice){
        switch (program_choice) {
            case 1:
                System.out.println(YELLOW + """
                    
                    \t1 -> Physics
                    \t2 -> Chemistry
                    \t3 -> Maths
                    \t4 -> Statistics
                    """ + RESET);
                break;
            case 2:
                System.out.println(YELLOW + """
                    
                    \t1 -> Human Development 101
                    \t2 -> Neuroscience
                    \t3 -> Brain Anatomy and Histology
                    \t4 -> Childhood Development
                    """ + RESET);
                break;
            case 3:
                System.out.println(YELLOW + """
                    
                    \t1 -> Java
                    \t2 -> SQL Database
                    \t3 -> C++
                    \t4 -> PHP language
                    """ + RESET);
                break;
            case 4:
                System.out.println(YELLOW + """
                    
                    \t1 -> Drawing
                    \t2 -> Sculpture
                    \t3 -> History of Art
                    \t4 -> Color Theory
                    """ + RESET);
                break;
        }
    }

    /**
     *
     * @return the according program name
     */
    public String getProgramName() {
        return program_name;
    }

    /**
     *
     * @return the according course name
     */
    public String getCourseName(){
        return course_name;
    }

    /**
     *
     * @return the according semester name
     */
    public String getSemester() {
        return semester;
    } //user's choice // before choosing courses

    /**
     *
     * @return the according professor name
     */
    public String getProfessor() {
        return professor;
    } // assigned // working on it

    /**
     *
     * @return the according program ID
     */
    public String getProgram_ID() {
        return program_ID;
    } // assigned

}

