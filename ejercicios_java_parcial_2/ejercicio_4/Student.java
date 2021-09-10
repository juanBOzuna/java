package ejercicio_4;

public class Student {
    int age;
    String name;
    int gender;
    int maritalStatus;
    int levelStudy;

    public Student() {

    }

    // Setters & Getters name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Setters & Getters age
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // Setters & Getters gender
    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        // 1 male , 0 female
        return gender;
    }

    // Setters & Getters maritalStatus
    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getMaritalStatus() {
        // 1 married , 0 not married
        return maritalStatus;
    }

    // Setters & Getters vivel_esetudio
    public void setLevelStudy(int levelStudy) {
        this.levelStudy = levelStudy;
    }

    public int getLevelStudy() {
        return levelStudy;
    }

    // calculate if male is married
    public boolean maleIsMarried() {
        return (getGender() == 1 && getMaritalStatus() == 1);
    }

    // calculate if female is married
    public boolean femaleIsMarried() {
        return (getGender() == 0 && getMaritalStatus() == 1);
    }

    // calculate if male or female are married
    public boolean NotMarried() {
        return (getMaritalStatus() == 0);
    }

    // calculate if student is under age
    public boolean isunderAge() {
        return !(getAge() >= 18);
    }
}
