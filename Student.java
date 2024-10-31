/**
 * <p>The Student class represents the requirement students need to choose when the register courses.</p>
 *  It includes first name, last name, student ID, and program.
 * @author Anastassia Tarassova
 * @since 2024-10-25
 * @see StudentForm, Register, Course
 * <br>
 * Variables in class Student:
 *  - f_name
 *  - l_name
 *  - student_ID
 *
 *   Methods in class Student:
 *  - setStudentName
 *  - setStudentID
 *  - getStudentName
 *  - getStudentID
 */

package Assignements.Team_Project_V1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//main class
public class Student {
    Random random = new Random();

    // declaring variables
    private String f_name, l_name, student_ID;

    /**
     *
     * @param f_name indicate first name of student
     * @param l_name indicate last name of student
     */
    public void setStudentName(String f_name, String l_name) {
        this.f_name = f_name;
        this.l_name = l_name;
    }

    // using String.valueOf as we read a character, and we need a String arg to pass to println()

    /**
     * get first name and last name to set student ID
     * @param f_name
     * @param l_name
     */
    public void setStudent_ID(String f_name, String l_name) {
        this.student_ID = student_ID;
        student_ID = String.valueOf(f_name.toUpperCase().charAt(0) + String.valueOf(l_name.toUpperCase().charAt(0)) + random.nextInt(100000, 999999));
    }

    /**
     *
     * @return the first and last name of student entered
     */
    public String getStudentName()  {
        return f_name + " " + l_name;
    }

    /**
     *
     * @return the according student ID
     */
    public String getStudentID()  { return student_ID; }

}

