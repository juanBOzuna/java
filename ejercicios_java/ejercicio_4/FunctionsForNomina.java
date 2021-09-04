package ejercicio_4;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FunctionsForNomina {

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

  public static void addContentResult(JFrame frameResult, JPanel paneResult, int width, int height, double hr1,
      double val1, double hr2, double val2, double hr3, double val3, double hr4, double val4, double hr5, double val5,
      double hr6, double val6, double hr7, double val7, double val8,double val9, double aporEps, double aporPension,
      double cuotaPrestamo,double val10,double val11,double val12,String name ) {
      frameResult.setVisible(true);
      frameResult.setLayout(null);
      frameResult.setBackground(Color.white);
      frameResult.setSize((int) (width * 0.5) + 15, (int) (height * 0.9));
      // frameResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      paneResult.setSize((int) (width * 0.5), (int) (height * 0.9));
      paneResult.setBackground(Color.white);
      paneResult.setLayout(null);
      FunctionsForNomina.addDividersFromResult(paneResult, width, height);

      JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height, "Nomina de empleados");
      paneResult.add(titleHeader);

      JPanelTitleSurchargues titleSurchargues = new JPanelTitleSurchargues(width, height);
      paneResult.add(titleSurchargues);

      JpanelContentSurchargues contentSurchargues = new JpanelContentSurchargues(width, height, hr1, val1, hr2, val2, hr3,
          val3, hr4, val4, hr5, val5, hr6, val6, hr7, val7, val8,val9);
      paneResult.add(contentSurchargues);

      JPanelTitleDeductions titleDeductions = new JPanelTitleDeductions(width, height);
      paneResult.add(titleDeductions);

      JPanelContentDeductions contentDeductions = new JPanelContentDeductions(width, height, aporEps, aporPension,
          cuotaPrestamo);
      paneResult.add(contentDeductions);

      JPanelImageDductions ImageDeductions = new JPanelImageDductions(width, height);
      paneResult.add(ImageDeductions);

      JPanelFooterResult footer = new JPanelFooterResult(width, height, name, val10, val11, val12);
      paneResult.add(footer);

      frameResult.add(paneResult);
  }
}
