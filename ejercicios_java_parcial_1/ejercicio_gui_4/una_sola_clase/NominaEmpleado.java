package ejercicios_java_parcial_1. ejercicio_gui_4.una_sola_clase;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;
import java.awt.*;

public class NominaEmpleado {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
}

class Ventana extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana() {

        // setLayout(null);
        setBackground(Color.white);
        setSize((int) (width * 0.5), (int) (height * 0.9));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panePrincipal = new JPanel();
        JScrollPane panelScroll = new JScrollPane();
        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelScroll.setBounds(10, 10, (int) (width * 0.5), (int) (height * 0.9));

        // panePrincipal.setSize((int) (width * 0.5), (int) (height * 0.9));
        panePrincipal.setPreferredSize(new DimensionUIResource((int) (width * 0.48), (int) (height * 0.85)));
        panePrincipal.setBackground(Color.white);
        panePrincipal.setLayout(null);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height, "Nomina de empleados");
        panePrincipal.add(titleHeader);

        addDividers(panePrincipal, width, height);

        JpanelCheckJornada checkJornada = new JpanelCheckJornada(width, height);
        panePrincipal.add(checkJornada);

        JPanelCheckLoan checkLoan = new JPanelCheckLoan(width, height);
        panePrincipal.add(checkLoan);

        int WIDTH_DEFAULT = (int) (width * 0.5 / 2) - 100;
        int HEIGHT_DEFAULT = (int) (height * 0.05);
        int BOUND_X_DEFAULT = (int) ((width * 0.5 / 2) + 50);

        Tfmfld salarioMinimo = new Tfmfld(50, (int) (height * 0.22) + 30, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " ** Salario minimo Actual", true);
        panePrincipal.add(salarioMinimo);

        Tfmfld salaryEmployee = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.22) + 30, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " ** Salario del empleado", true);
        panePrincipal.add(salaryEmployee);

        Tfmfld workedDays = new Tfmfld(50, (int) (height * 0.27) + 50, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " ** Dias trabajados", true);
        panePrincipal.add(workedDays);

        Tfmfld hoursNight = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.27) + 50, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " Horas nocturas", true);
        panePrincipal.add(hoursNight);

        Tfmfld hoursDominicalsDay = new Tfmfld(50, (int) (height * 0.32) + 70, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " Horas dominicales diurnas", true);
        panePrincipal.add(hoursDominicalsDay);

        Tfmfld hoursDominicalsNight = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.32) + 70, WIDTH_DEFAULT,
                HEIGHT_DEFAULT, " Horas Dominicales nocturnas", true);
        panePrincipal.add(hoursDominicalsNight);

        Tfmfld overtimeDayHours = new Tfmfld(50, (int) (height * 0.37) + 90, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " Horas extras diurnas", true);
        panePrincipal.add(overtimeDayHours);

        Tfmfld overtimeNightHours = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.37) + 90, WIDTH_DEFAULT,
                HEIGHT_DEFAULT, " Horas extras nocturnas", true);
        panePrincipal.add(overtimeNightHours);

        Tfmfld overtimeDominicalDay = new Tfmfld(50, (int) (height * 0.42) + 110, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " Horas extras dominicales diurnas", true);
        panePrincipal.add(overtimeDominicalDay);

        Tfmfld overtimeDominicalNight = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.42) + 110, WIDTH_DEFAULT,
                HEIGHT_DEFAULT, " Horas extras dominicales nocturnas", true);
        panePrincipal.add(overtimeDominicalNight);

        Tfmfld bonus = new Tfmfld(50, (int) (height * 0.47) + 130, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " Bonificacion para el cliente", true);
        panePrincipal.add(bonus);

        Tfmfld nameEmployee = new Tfmfld(BOUND_X_DEFAULT, (int) (height * 0.47) + 130, WIDTH_DEFAULT, HEIGHT_DEFAULT,
                " ** Nombre del empleado", false);
        panePrincipal.add(nameEmployee);

        JpanelButton button = new JpanelButton(height, width, checkLoan, checkJornada, bonus, salarioMinimo,
                salaryEmployee, workedDays, hoursNight, hoursDominicalsDay, hoursDominicalsNight, overtimeDayHours,
                overtimeNightHours, overtimeDominicalDay, overtimeDominicalNight, nameEmployee);
        panePrincipal.add(button);

        panelScroll.setViewportView(panePrincipal);

        add(panelScroll);
    }

    void addDividers(JPanel panel, int width, int height) {

        int primaryBoundY = (int) (height * 0.12);
        int primaryHeightSize = (int) (height * 0.20);
        DividerPrincipal divider1 = new DividerPrincipal(width, height, primaryBoundY, primaryHeightSize, 1);
        panel.add(divider1);

        int secunBoundY = primaryHeightSize + primaryBoundY + 20;
        int secunHeightSize = (int) (height * 0.018);
        DividerPrincipal divider2 = new DividerPrincipal(width, height, secunBoundY, secunHeightSize, 2);
        panel.add(divider2);

        int tercBoundY = secunHeightSize + secunBoundY + 20;
        int tercHeightSize = (int) (height * 0.03);
        DividerPrincipal divider3 = new DividerPrincipal(width, height, tercBoundY, tercHeightSize, 2);
        panel.add(divider3);

        int fourBoundY = tercHeightSize + tercBoundY + 20;
        int fourHeightSize = (int) (height * 0.018);
        DividerPrincipal divider4 = new DividerPrincipal(width, height, fourBoundY, fourHeightSize, 2);
        panel.add(divider4);

        int fiveBoundY = fourHeightSize + fourBoundY + 20;
        int fiveHeightSize = (int) (height * 0.20);
        DividerPrincipal divider5 = new DividerPrincipal(width, height, fiveBoundY, fiveHeightSize, 1);
        panel.add(divider5);
    }

    static void disposeForms(JPanelCheckLoan checkLoan, JpanelCheckJornada jornada, Tfmfld bonus, Tfmfld smlvg,
            Tfmfld salario, Tfmfld diasTrabajo, Tfmfld horasnoct, Tfmfld horasdominicfestdia,
            Tfmfld horasdominicfestnoct, Tfmfld horextradia, Tfmfld horextranoct, Tfmfld horextradomfesdia,
            Tfmfld horextradomfesnoct, Tfmfld nombre) {

        checkLoan.dispose();
        jornada.dispose();
        smlvg.cleanForm();
        salario.cleanForm();
        diasTrabajo.cleanForm();
        horasnoct.cleanForm();
        horasdominicfestdia.cleanForm();
        horasdominicfestnoct.cleanForm();
        horextradia.cleanForm();
        horextranoct.cleanForm();
        horextradomfesdia.cleanForm();
        horextradomfesnoct.cleanForm();
        nombre.cleanForm();
        bonus.cleanForm();
    }

}

/**
 * JpanelHeaderTitle
 */
class JpanelHeaderTitle extends JPanel {
    public JpanelHeaderTitle(int width, int height, String title) {
        this.setBounds(155, 15, (int) (width * 0.3 - 60), (int) (height * 0.09));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));

        JLabel text = new JLabel();
        text.setText(title);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("bahnschrift", 1, 31));
        add(text);
    }
}

/**
 * JpanelCheckJornada
 */
class JpanelCheckJornada extends JPanel {
    JCheckBox FullTime = new JCheckBox();
    JCheckBox halfDay = new JCheckBox();

    public JpanelCheckJornada(int width, int height) {
        this.setBounds(50, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));

        JLabel text = new JLabel();
        text.setText(" *Jornada Laboral");
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JPanel checks = new JPanel();
        checks.setBounds(50, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.5));
        checks.setBackground(Color.white);
        checks.setLayout(new GridLayout(1, 2));

        FullTime.setText("Completa");
        FullTime.setBackground(Color.white);
        checks.add(FullTime);

        halfDay.setText("Media");
        halfDay.setBackground(Color.white);
        checks.add(halfDay);

        add(checks);

        FullTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    halfDay.setSelected(false);
                    ;
                } catch (Exception e) {
                }
            }
        });

        halfDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    FullTime.setSelected(false);
                    ;
                } catch (Exception e) {
                }
            }
        });
    }

    boolean getValidateValues() {
        return FullTime.isSelected() || halfDay.isSelected();
    }

    boolean getFullTime() {
        return FullTime.isSelected();
    }

    boolean getHalfDay() {
        return halfDay.isSelected();
    }

    void dispose() {
        halfDay.setSelected(false);
        FullTime.setSelected(false);
    }

}

/**
 * JPanelCheckLoan
 */
class JPanelCheckLoan extends JPanel {
    protected static Boolean isTicket = true;
    String title = " Valor de la cuota";
    JTextField form = new JTextField();
    static JCheckBox check = new JCheckBox();

    public JPanelCheckLoan(int width, int height) {
        this.setBounds((int) ((width * 0.5 / 2) + 50), (int) (height * 0.12), (int) (width * 0.5 / 2) - 100,
                (int) (height * 0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));

        DigitOnlyFormKeyListener keyListenersDigitOnly = new DigitOnlyFormKeyListener();
        HintTextListener focusAdapterForm2 = new HintTextListener(form, title);

        JPanel checks = new JPanel();
        checks.setBounds(50, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.5));
        checks.setBackground(Color.white);
        checks.setLayout(new GridLayout(1, 2));
        check.setText(" Tiene un prestamo");
        check.setBackground(Color.white);
        checks.add(check);
        add(checks);

        form.setText(title);
        form.setSize(100, 100);
        form.setEditable(false);
        form.setToolTipText(title);
        form.addFocusListener(focusAdapterForm2);
        form.addKeyListener(keyListenersDigitOnly);
        add(form);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    form.setEditable(isTicket);
                    isTicket = !isTicket;
                } catch (Exception e) {
                }
            }
        });
    }

    boolean getIsDebtor() {
        return check.isSelected();
    }

    Double getAmountToBePaid() {
        if (form.getText().equals(title)) {
            return 0.0;
        } else {
            return Double.parseDouble(form.getText());
        }
    }

    void dispose() {
        check.setSelected(false);
        form.setText(title);
        form.setEditable(false);
        isTicket = true;
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

    double getFormValueDouble() {
        if (form.getText().equals(titleGeneral)) {
            return 0.0;
        } else {
            return Double.parseDouble(form.getText().replace(".", "").replace(",", ""));
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

    void cleanForm() {
        form.setText(titleGeneral);
    }
}

/**
 * JpanelButton
 */
class JpanelButton extends JPanel {
    public JpanelButton(int height, int width, JPanelCheckLoan checkLoan, JpanelCheckJornada jornada, Tfmfld bonus,
            Tfmfld smlvg, Tfmfld salario, Tfmfld diasTrabajo, Tfmfld horasnoct, Tfmfld horasdominicfestdia,
            Tfmfld horasdominicfestnoct, Tfmfld horextradia, Tfmfld horextranoct, Tfmfld horextradomfesdia,
            Tfmfld horextradomfesnoct, Tfmfld nombre) {

        this.setBounds(0, (int) (height * 0.73), (int) (width * 0.5), 80);
        this.setBackground(Color.white);
        this.setLayout(null);

        JButton button = new JButton("CALCULAR");
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBounds((int) (width * 0.25) - 100 + 130, 10, 100, 50);
        buttonPanel.add(button);
        buttonPanel.setBackground(Color.white);
        add(buttonPanel);

        JButton button2 = new JButton("Formatear ");
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setBounds((int) (width * 0.25) - 130, 10, 100, 50);
        buttonPanel2.add(button2);
        buttonPanel2.setBackground(Color.white);
        add(buttonPanel2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                Ventana.disposeForms(checkLoan, jornada, bonus, smlvg, salario, diasTrabajo, horasnoct,
                        horasdominicfestdia, horasdominicfestnoct, horextradia, horextranoct, horextradomfesdia,
                        horextradomfesnoct, nombre);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                boolean validator = true;

                double VALOR_DIA = 0, VALOR_HORA = 0;
                double saldiastrabjo = 0, salrecarnoct = 0, totalauxtransp = 0, salhordominicfestdia = 0,
                        salhordominicfestnoct = 0, salhorextrdia = 0, salhorextrnoct = 0, salhorextradomfesdia = 0,
                        salhorextradomfesnoct = 0, totalsalrecargo = 0, totalsalneto = 0, aporeps = 0, aporpension = 0,
                        totalsaldevengado = 0, totaldeduccion = 0;

                if (jornada.getValidateValues() && nombre.validateForm()) {

                    VALOR_DIA = salario.getFormValueDouble() / 30;

                    // Principales validaciones despues de la validacion generAL
                    if (salario.getFormValueDouble() > 0.0 && smlvg.getFormValueDouble() > 0
                            && smlvg.getFormValueDouble() > 0) {
                        validator = true;

                        // tiempo de trabajo para el valor de la hora
                        if (jornada.getFullTime()) {
                            validator = true;

                            // asignacion del valor hora y validacion del valor smlvg
                            if (salario.getFormValueDouble() >= smlvg.getFormValueDouble()) {
                                validator = true;
                                VALOR_HORA = VALOR_DIA / 8;
                            } else {
                                validator = false;
                                JOptionPane.showMessageDialog(null,
                                        "El Sueldo no puede ser menor al salario minimo legal vigente");
                            }
                            // -- asignacion del valor hora y validacion del valor smlvg

                        } else {
                            if (salario.getFormValueDouble() >= smlvg.getFormValueDouble() / 2) {
                                VALOR_HORA = VALOR_DIA / 4;
                                validator = true;
                            } else {
                                validator = false;
                                JOptionPane.showMessageDialog(null,
                                        "El Sueldo no puede ser menor a la mitad del salario minimo legal vigente"
                                                + Double.toString(smlvg.getFormValueDouble()));
                            }
                        }
                        // -- tiempo de trabajo para el valor de la hora

                    } else {
                        validator = false;
                        JOptionPane.showMessageDialog(null,
                                "Los dias de trabajo, El salario minimo y el sueldo deben ser mayor a 0");
                    }

                    // -- Principales validaciones despues de la validacion generAL

                    if (validator) {

                        // valor auxilio de transporte
                        if (salario.getFormValueDouble() < smlvg.getFormValueDouble() * 2) {
                            totalauxtransp = (smlvg.getFormValueDouble() * 10) / 100;
                        } else {
                            totalauxtransp = 0;
                        }
                        // --valor auxilio de transporte

                        saldiastrabjo = VALOR_DIA * diasTrabajo.getFormValueDouble();

                        // calculo recargos
                        salrecarnoct = percentage(VALOR_HORA * horasnoct.getFormValueDouble(), 35);
                        salhordominicfestdia = percentage(VALOR_HORA * horasdominicfestdia.getFormValueDouble(), 75);
                        salhordominicfestnoct = percentage(VALOR_HORA * horasdominicfestnoct.getFormValueDouble(), 110);
                        salhorextrdia = percentage(VALOR_HORA * horextradia.getFormValueDouble(), 25);
                        salhorextrnoct = percentage(VALOR_HORA * horextranoct.getFormValueDouble(), 75);
                        salhorextradomfesdia = (VALOR_HORA * horextradomfesdia.getFormValueDouble()) * 2;
                        salhorextradomfesnoct = percentage(VALOR_HORA * horextradomfesnoct.getFormValueDouble(), 150);
                        // --calculo recargos

                        totalsalrecargo = totalauxtransp + salrecarnoct + salhordominicfestdia + salhordominicfestnoct
                                + salhorextrdia + salhorextrnoct + salhorextradomfesdia + salhorextradomfesnoct
                                + bonus.getFormValueDouble();

                        totalsalneto = saldiastrabjo + totalsalrecargo;
                        aporeps = (totalsalneto * 4) / 100;
                        aporpension = aporeps;
                        totaldeduccion = aporeps + aporpension + checkLoan.getAmountToBePaid();
                        totalsaldevengado = totalsalneto - totaldeduccion;

                        Result result = new Result(width, height, horasnoct.getFormValueDouble(), salrecarnoct,
                                horasdominicfestdia.getFormValueDouble(), salhordominicfestdia,
                                horasdominicfestnoct.getFormValueDouble(), salhordominicfestnoct,
                                horextradia.getFormValueDouble(), salhorextrdia, horextranoct.getFormValueDouble(),
                                salhorextrnoct, horextradomfesdia.getFormValueDouble(), salhorextradomfesdia,
                                horextradomfesnoct.getFormValueDouble(), salhorextradomfesnoct,
                                bonus.getFormValueDouble(), totalauxtransp, aporeps, aporpension,
                                checkLoan.getAmountToBePaid(), totalsalrecargo, totalsalneto, totalsaldevengado,
                                nombre.GetFormValue());

                        result.setVisible(true);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Rellene todos los campos");
                }
            }
        });

    }

    double percentage(double cantidad, double percen) {

        return (cantidad * percen) / 100 + cantidad;
    }
}

/**
 * DividerPrincipal
 */
class DividerPrincipal extends JPanel {
    public DividerPrincipal(int width, int height, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) ((width * 0.5 / 2) - 2) - (widthSize / 2), boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}

// clase result

class Result extends JFrame {
    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Result(int width, int height, double hr1, double val1, double hr2, double val2, double hr3, double val3,
            double hr4, double val4, double hr5, double val5, double hr6, double val6, double hr7, double val7,
            double val8, double val9, double aporEps, double aporPension, double cuotaPrestamo, double val10,
            double val11, double val12, String name) {
        // setLayout(null);
        setBackground(Color.white);
        setSize((int) (width * 0.5) + 15, (int) (height * 0.9));
        JPanel panelResult = new JPanel();

        JScrollPane panelScroll = new JScrollPane();
        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelScroll.setBounds(10, 10, (int) (width * 0.5), (int) (height * 0.9));

        // panelResult.setSize((int) (width * 0.5), (int) (height * 0.9));
        panelResult.setPreferredSize(new DimensionUIResource((int) (width * 0.48), (int) (height * 0.85)));
        panelResult.setBackground(Color.white);
        panelResult.setLayout(null);
        addDividersFromResult(panelResult, width, height);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height, "Nomina de empleados");
        panelResult.add(titleHeader);

        JPanelTitleSurchargues titleSurchargues = new JPanelTitleSurchargues(width, height);
        panelResult.add(titleSurchargues);

        JpanelContentSurchargues contentSurchargues = new JpanelContentSurchargues(width, height, hr1, val1, hr2, val2,
                hr3, val3, hr4, val4, hr5, val5, hr6, val6, hr7, val7, val8, val9);
        panelResult.add(contentSurchargues);

        JPanelContentDeductions contentDeductions = new JPanelContentDeductions(width, height, aporEps, aporPension,
                cuotaPrestamo);
        panelResult.add(contentDeductions);

        JPanelFooterResult footer = new JPanelFooterResult(width, height, name, val10, val11, val12);
        panelResult.add(footer);

        JPanelTitleDeductions titleDeductions = new JPanelTitleDeductions(width, height);
        panelResult.add(titleDeductions);

        JPanelImageDductions ImageDeductions = new JPanelImageDductions(width, height);
        panelResult.add(ImageDeductions);

        panelScroll.setViewportView(panelResult);

        add(panelScroll);

    }

    public static void addDividersFromResult(JPanel panel, int width, int height) {
        int primaryBoundY = (int) (height * 0.12);
        int primaryHeightSize = (int) (height * 0.218);
        DividerResult divider1 = new DividerResult(width, height, primaryBoundY, primaryHeightSize, 1);
        panel.add(divider1);

        int secundBoundY = primaryHeightSize + primaryBoundY + 20;
        int secunHeightSize = (int) (height * 0.03);
        DividerResult divider3 = new DividerResult(width, height, secundBoundY, secunHeightSize, 2);
        panel.add(divider3);

        int trheeBoundY = secunHeightSize + secundBoundY + 20;
        int trheeHegihtSize = (int) (height * 0.218);
        DividerResult divider5 = new DividerResult(width, height, trheeBoundY, trheeHegihtSize, 1);
        panel.add(divider5);

    }
}

/**
 * JPanelTitleSurchargues
 */
class JPanelTitleSurchargues extends JPanel {

    public JPanelTitleSurchargues(int width, int height) {
        this.setBounds(20, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.05));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        text.setText("RECARGOS ");
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));
        add(text);
    }
}

/**
 * JPanelTitleDeductions
 */
class JPanelTitleDeductions extends JPanel {

    public JPanelTitleDeductions(int width, int height) {
        this.setBounds((int) ((width * 0.5 / 2) + 50), (int) (height * 0.12), (int) (width * 0.5 / 2) - 50,
                (int) (height * 0.05));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        text.setText("DEDUCCIONES ");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));
        add(text);
    }
}

/**
 * JpanelContentSurchargues
 */
class JpanelContentSurchargues extends JPanel {

    public JpanelContentSurchargues(int width, int height, double hr1, double val1, double hr2, double val2, double hr3,
            double val3, double hr4, double val4, double hr5, double val5, double hr6, double val6, double hr7,
            double val7, double val8, double val9) {
        this.setBounds(20, (int) (height * 0.17), (int) (width * 0.5 / 2) + 10, (int) (height * 0.466));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(16, 1));

        JLabel text = new JLabel();
        text.setText("Horas nocturnas: " + String.format("%.02f", hr1));
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JLabel text1 = new JLabel();
        text1.setText("recargo nocturno: $" + String.format("%.02f", val1));
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));

        add(text1);
        JLabel text2 = new JLabel();
        text2.setText("Horas dominic. fest. dia: " + String.format("%.02f", hr2));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Recargo por hrs dominic. fest. dia: $" + String.format("%.02f", val2));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);

        JLabel text4 = new JLabel();
        text4.setText("Horas dominic. fest. noche: " + String.format("%.02f", hr3));
        text4.setHorizontalAlignment(SwingConstants.LEFT);
        text4.setVerticalAlignment(SwingConstants.CENTER);
        text4.setFont(new Font("bahnschrift", 0, 15));
        add(text4);
        JLabel text5 = new JLabel();
        text5.setText("Recargo por hrs dominic. fest. noche: $" + String.format("%.02f", val3));
        text5.setHorizontalAlignment(SwingConstants.LEFT);
        text5.setVerticalAlignment(SwingConstants.CENTER);
        text5.setFont(new Font("bahnschrift", 0, 15));
        add(text5);
        JLabel text6 = new JLabel();
        text6.setText("Horas extras dia: " + String.format("%.02f", hr4));
        text6.setHorizontalAlignment(SwingConstants.LEFT);
        text6.setVerticalAlignment(SwingConstants.CENTER);
        text6.setFont(new Font("bahnschrift", 0, 15));
        add(text6);
        JLabel text7 = new JLabel();
        text7.setText("Recargo por horas extras dia: $" + String.format("%.02f", val4));
        text7.setHorizontalAlignment(SwingConstants.LEFT);
        text7.setVerticalAlignment(SwingConstants.CENTER);
        text7.setFont(new Font("bahnschrift", 0, 15));
        add(text7);
        JLabel text8 = new JLabel();
        text8.setText("Horas extras noche: " + String.format("%.02f", hr5));
        text8.setHorizontalAlignment(SwingConstants.LEFT);
        text8.setVerticalAlignment(SwingConstants.CENTER);
        text8.setFont(new Font("bahnschrift", 0, 15));
        add(text8);
        JLabel text9 = new JLabel();
        text9.setText("Recargo por horas extras noche: $" + String.format("%.02f", val5));
        text9.setHorizontalAlignment(SwingConstants.LEFT);
        text9.setVerticalAlignment(SwingConstants.CENTER);
        text9.setFont(new Font("bahnschrift", 0, 15));
        add(text9);
        JLabel text10 = new JLabel();
        text10.setText("Horas extras festivas dia: " + String.format("%.02f", hr6));
        text10.setHorizontalAlignment(SwingConstants.LEFT);
        text10.setVerticalAlignment(SwingConstants.CENTER);
        text10.setFont(new Font("bahnschrift", 0, 15));
        add(text10);
        JLabel text11 = new JLabel();
        text11.setText("Recargo por hrs extras fest. dia: $" + String.format("%.02f", val6));
        text11.setHorizontalAlignment(SwingConstants.LEFT);
        text11.setVerticalAlignment(SwingConstants.CENTER);
        text11.setFont(new Font("bahnschrift", 0, 15));
        add(text11);
        JLabel text12 = new JLabel();
        text12.setText("Horas extras festivas noche: " + String.format("%.02f", hr7));
        text12.setHorizontalAlignment(SwingConstants.LEFT);
        text12.setVerticalAlignment(SwingConstants.CENTER);
        text12.setFont(new Font("bahnschrift", 0, 15));
        add(text12);
        JLabel text13 = new JLabel();
        text13.setText("Recargo por hrs extras fest. noche: $" + String.format("%.02f", val7));
        text13.setHorizontalAlignment(SwingConstants.LEFT);
        text13.setVerticalAlignment(SwingConstants.CENTER);
        text13.setFont(new Font("bahnschrift", 0, 15));
        add(text13);
        JLabel text14 = new JLabel();
        text14.setText("Bonficaciones: $" + String.format("%.02f", val8));
        text14.setHorizontalAlignment(SwingConstants.LEFT);
        text14.setVerticalAlignment(SwingConstants.CENTER);
        text14.setFont(new Font("bahnschrift", 0, 15));
        add(text14);
        JLabel text15 = new JLabel();
        text15.setText("Aux de transporte: $" + String.format("%.02f", val9));
        text15.setHorizontalAlignment(SwingConstants.LEFT);
        text15.setVerticalAlignment(SwingConstants.CENTER);
        text15.setFont(new Font("bahnschrift", 0, 15));
        add(text15);

    }
}

/**
 * JPanelContentDeductions
 */
class JPanelContentDeductions extends JPanel {

    public JPanelContentDeductions(int width, int height, double aporEps, double aporPension, double cuotaPrestamo) {
        this.setBounds((int) ((width * 0.5 / 2) + 65), (int) (height * 0.17), (int) (width * 0.5 / 2) - 70,
                (int) (height * 0.466 / 2));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(4, 1));

        JLabel text = new JLabel();
        text.setText("Aporte a EPS: $" + String.format("%.03f", aporEps));
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JLabel text1 = new JLabel();
        text1.setText("Aporte a Pension: $" + String.format("%.03f", aporPension));
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));

        add(text1);
        JLabel text2 = new JLabel();
        text2.setText("Cuota de prestamos: $" + String.format("%.03f", cuotaPrestamo));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Total Deducciones: -$" + String.format("%.03f", aporEps + aporPension + cuotaPrestamo));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);
    }
}

/**
 * JPanelImageDductions
 */
class JPanelImageDductions extends JPanel {

    public JPanelImageDductions(int width, int height) {

        this.setBackground(Color.white);
        setLayout(new GridLayout(1, 1));
        this.setBounds((int) ((width * 0.5 / 2) + 55), (int) (height * 0.17) + (int) (height * 0.466 / 2),
                (int) (width * 0.5 / 2) - 70, (int) (height * 0.466 / 2));

        Image img = new ImageIcon("ejercicios_java_parcial_1/ejercicio_4/assets/deduction.png").getImage();
        ImageIcon img2 = new ImageIcon(
                img.getScaledInstance((int) (width * 0.5 / 2) - 70, (int) (height * 0.466 / 2), Image.SCALE_SMOOTH));

        JLabel picLabel = new JLabel(img2);

        add(picLabel);
    }

}

/**
 * JPanelFooter
 */
class JPanelFooterResult extends JPanel {
    public JPanelFooterResult(int width, int height, String nombre, Double val1, Double val2, Double val3) {
        this.setBounds(20, (int) (height * 0.586) + 70, (int) (width * 0.5) - 50, (int) (height * 0.15));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(4, 1));
        JLabel text1 = new JLabel();
        text1.setText("Nombre: " + nombre);
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));
        add(text1);

        JLabel text2 = new JLabel();
        text2.setText("Total Aux por recargo " + String.format("%.02f", val1));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Total salario neto " + String.format("%.02f", val2));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);

        JLabel text4 = new JLabel();
        text4.setText("Total salario Devengado " + String.format("%.02f", val3));
        text4.setHorizontalAlignment(SwingConstants.LEFT);
        text4.setVerticalAlignment(SwingConstants.CENTER);
        text4.setFont(new Font("bahnschrift", 0, 15));
        add(text4);

    }

}

/**
 * DividerResult
 */
class DividerResult extends JPanel {
    public DividerResult(int width, int height, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) ((width * 0.5 / 2) + 50) - (widthSize / 2), boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}

// fin clase result

class DigitOnlyFormKeyListener extends KeyAdapter {

    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '.')
                && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
            evt.consume();
        }
    }
}

class HintTextListener extends FocusAdapter {
    JTextField form = new JTextField();
    String titleGeneral;

    public HintTextListener(JTextField f, String t) {
        form = f;
        titleGeneral = t;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (form.getText().equals(titleGeneral)) {
            form.setText("");
        } else {
            form.setText(form.getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (form.getText().equals(titleGeneral) || form.getText().length() == 0) {
            form.setText(titleGeneral);
        } else {
            form.setText(form.getText());
        }
    }
}

class NotDigitFormKeyListener extends KeyAdapter {

    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }
}
