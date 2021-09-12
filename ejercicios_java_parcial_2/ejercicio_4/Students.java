package ejercicios_java_parcial_2. ejercicio_4;

import java.util.ArrayList;

public class Students {
    double averageAge;
    int firstLevelStudents;
    int latestLevelStudents;
    ArrayList<Student> students = new ArrayList<Student>();
    int malesMarrieds, femalesmarrieds, totalNotMarried;
    int undersAge = 0;

    public Students() {

    }

    public void setstudents(Student student) {
        this.students.add(student);
    }

    // calculate average age
    public void calculateAverageAge() {
        double suma = 0;
        for (Student student : students) {
            suma += student.getAge();
        }
        this.averageAge = suma / students.size();
    }

    // calculate total level 1 or 6
    public void calculateLevelStudents() {
        int sumafirst = 0, sumalatest = 0;
        for (Student student : students) {
            if (student.getLevelStudy() == 1) {
                sumafirst++;
            }
            if (student.getLevelStudy() == 6) {
                sumalatest++;
            }
        }
        this.firstLevelStudents = sumafirst;
        this.latestLevelStudents = sumalatest;
    }

    // calculate males and females married and total students not married
    public void calculateMaritalStatusFemaleAndMale() {
        int malesMarrieds = 0, femalesmarrieds = 0, totalNotMarried = 0;

        for (Student student : students) {
            // male married
            if (student.maleIsMarried()) {
                malesMarrieds++;
            }
            // female married
            if (student.femaleIsMarried()) {
                femalesmarrieds++;
            }
            // student not married
            if (student.NotMarried()) {
                totalNotMarried++;
            }
        }

        this.malesMarrieds = malesMarrieds;
        this.femalesmarrieds = femalesmarrieds;
        this.totalNotMarried = totalNotMarried;
    }

    // calcualte total students under age
    public void calculateUndersAge() {
        int suma = 0;
        for (Student student : students) {
            if (student.isunderAge()) {
                suma++;
            }
        }
        this.undersAge = suma;
    }

    public void calculateAllData() {
        calculateAverageAge();
        calculateLevelStudents();
        calculateMaritalStatusFemaleAndMale();
        calculateUndersAge();

    }

    public void dispose() {
        this.students.clear();
    }

}
