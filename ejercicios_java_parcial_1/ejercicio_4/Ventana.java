package ejercicio_4;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import methods.DigitOnlyFormKeyListener;
import methods.HintTextListener;
import methods.NotDigitFormKeyListener;

import java.awt.*;

public class Ventana extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana() {

        // setLayout(null);
        setBackground(Color.white);
        setSize((int) (width * 0.5) , (int) (height * 0.9));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panePrincipal = new JPanel();
        JScrollPane panelScroll = new JScrollPane();
        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelScroll.setBounds(10, 10,(int) (width * 0.5), (int) (height * 0.9));

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
