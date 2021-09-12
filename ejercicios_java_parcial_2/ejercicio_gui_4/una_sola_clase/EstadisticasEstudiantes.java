package ejercicios_java_parcial_2.ejercicio_gui_4.una_sola_clase;


import java.util.ArrayList;

import javax.swing.*;

import ejercicios_java_parcial_1.methods.*;
import java.awt.event.*;
import java.awt.*;

public class EstadisticasEstudiantes {
    public static void main(String[] args) {
        Ventana v = new Ventana();

        v.setVisible(true);
    }
}


class Ventana extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    Students students = new Students();

    public Ventana() {
        setSize(width / 3, height / 2);
        JPanel panelP = new JPanel();

        panelP.setSize(width / 3, height / 2);
        panelP.setBackground(Color.white);
        panelP.setLayout(null);

        double widthForm = (int) ((width / 6) - (int) (width * 0.030));

        Tfmfld name = new Tfmfld((int) (width * 0.015), (int) ((width * 0.040) + 20), (int) (widthForm), 28,
                " nombre del estudiante", false);
        panelP.add(name);

        Tfmfld age = new Tfmfld((int) (width * 0.17), (int) ((width * 0.040) + 20), (int) (widthForm), 28,
                " edad del estudiante", true);
        panelP.add(age);

        JpanelCheck gender = new JpanelCheck((int) (width * 0.015), (int) (height * 0.15), (int) (widthForm), 50,
                "Genero", "masculino", "femenino");
        panelP.add(gender);

        JpanelCheck maritalStatus = new JpanelCheck((int) (width * 0.17), (int) (height * 0.15), (int) (widthForm), 50,
                "Estado civil", "casad@", "solter@");
        panelP.add(maritalStatus);

        Tfmfld levelStudy = new Tfmfld((int) (width * 0.015), (int) (height * 0.25), (int) (widthForm), 28,
                " Semestre del estudiante", true);
        panelP.add(levelStudy);

        JButton boton1 = new JButton();
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                boolean validateForm = (name.validateForm() && age.validateForm() && levelStudy.validateForm()
                        && gender.getValidateValues() && maritalStatus.getValidateValues());
                saveAndCallBack(name, age, levelStudy, gender, maritalStatus, validateForm, false);
            }
        });
        panelP.add(boton((int) (width * 0.025), (int) (height * 0.35), (int) (width * 0.11), 25, "Guardar y otro",
                boton1));

        JButton boton2 = new JButton();
        boton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evento) {
                boolean validateForm = (name.validateForm() && age.validateForm() && levelStudy.validateForm()
                        && gender.getValidateValues() && maritalStatus.getValidateValues());
                saveAndCallBack(name, age, levelStudy, gender, maritalStatus, validateForm, true);
            }
        });
        panelP.add(boton((int) (width * 0.17), (int) (height * 0.35), (int) (width * 0.11), 25, "Guardar y finalizar",
                boton2));

        JLabel text = new JLabel();
        text.setText("Estadisticas universitarios");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("bahnschrift", 1, (int) (width * 0.018)));
        text.setBounds(0, 20, width / 3, (int) (width * 0.025));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panelP.add(text);

        add(panelP);

    }

    JButton boton(int x, int y, int width, int height, String title, JButton boton) {
        boton.setBounds(x, y, width, height);
        boton.setText(title);

        return boton;
    }

    void saveAndCallBack(Tfmfld name, Tfmfld age, Tfmfld levelStudy, JpanelCheck gender, JpanelCheck maritalStatus,
            boolean validateForm, boolean finalize) {

        if (validateForm) {
            Student student = new Student();
            student.setName(name.GetFormValue());
            student.setAge(age.getFormValueInt());
            student.setLevelStudy(levelStudy.getFormValueInt());
            student.setGender(boolToInt(gender.getCheck1()));
            student.setMaritalStatus(boolToInt(maritalStatus.getCheck1()));
            students.setstudents(student);

            name.dispose();
            age.dispose();
            levelStudy.dispose();
            gender.dispose();
            maritalStatus.dispose();

            if (finalize) {
                students.calculateAllData();
                JOptionPane.showMessageDialog(null, "Edad promedio de los estudiantes: " + students.averageAge
                        + "\nTotal de estudiantes del 1er nivel: " + students.firstLevelStudents
                        + "\n Total de estudiantes del último nivel: " + students.latestLevelStudents
                        + "\nTotal de hombres casados: " + students.malesMarrieds + "\n Total de mujeres casadas: "
                        + students.femalesmarrieds + "\nTotal de estudiantes solteros: " + students.totalNotMarried
                        + "\nTotal de estudiantes menores de edad: " + students.undersAge);
                students.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }

    int boolToInt(boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }

    }
}

/**
 * JpanelCheck
 */
class JpanelCheck extends JPanel {
    JCheckBox check1 = new JCheckBox();
    JCheckBox check2 = new JCheckBox();

    public JpanelCheck(int x, int y, int width, int height, String title, String titleCheck1, String titleCheck2) {
        this.setBounds(x, y, width, height);
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));

        JLabel text = new JLabel();
        text.setText(title);
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JPanel checks = new JPanel();
        checks.setBounds(50, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.5));
        checks.setBackground(Color.white);
        checks.setLayout(new GridLayout(1, 2));

        check1.setText(titleCheck1);
        check1.setBackground(Color.white);
        checks.add(check1);

        check2.setText(titleCheck2);
        check2.setBackground(Color.white);
        checks.add(check2);

        add(checks);

        check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    check2.setSelected(false);
                    ;
                } catch (Exception e) {
                }
            }
        });

        check2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    check1.setSelected(false);
                    ;
                } catch (Exception e) {
                }
            }
        });
    }

    boolean getValidateValues() {
        return check1.isSelected() || check2.isSelected();
    }

    boolean getCheck1() {
        return check1.isSelected();
    }

    boolean getCheck2() {
        return check2.isSelected();
    }

    void dispose() {
        check2.setSelected(false);
        check1.setSelected(false);
    }

}

/**
 * Tfmfld
 */
class Tfmfld extends JPanel {
    JTextField form = new JTextField();
    String titleGeneral = "";

    public Tfmfld(int boundX, int boundY, int width, int height, String title, boolean isnumber) {
        titleGeneral = title;
        this.setBounds(boundX, boundY, width, height);
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 1));

        HintTextListener focusAdapterForm2 = new HintTextListener(form, titleGeneral);
        DigitOnlyFormKeyListener keyListenersDigitOnly = new DigitOnlyFormKeyListener();
        NotDigitFormKeyListener keyListenersNotDigit = new NotDigitFormKeyListener();

        form.setText(titleGeneral);
        form.setToolTipText(titleGeneral);
        form.addFocusListener(focusAdapterForm2);

        if (isnumber) {
            form.addKeyListener(keyListenersDigitOnly);
        } else {
            form.addKeyListener(keyListenersNotDigit);
        }
        add(form);
    }

    int getFormValueInt() {
        if (form.getText().equals(titleGeneral)) {
            return 0;
        } else {
            return Integer.parseInt(form.getText().replace(".", "").replace(",", ""));
        }
    }

    String GetFormValue() {
        return form.getText();
    }

    boolean validateForm() {
        if (form.getText().equals(titleGeneral)) {
            return false;
        } else {
            return true;
        }
    }

    void dispose() {
        form.setText(titleGeneral);
    }
}


class Students {
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

class Student {
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
