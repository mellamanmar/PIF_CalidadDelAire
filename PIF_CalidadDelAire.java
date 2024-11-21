/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pif_calidaddelaire;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author marim
 */
public class PIF_CalidadDelAire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double resultado = 0, x = 0, y = 0, z = 0;
        double liInicial = 0;
        double COverdeLS = 5094, COamarilloLI = 5095, COamarilloLS = 10819, COnaranjaLI = 10820, COnaranjaLS = 14254, 
                COrojoLI = 14255, COrojoLS = 17688, COpurpuraLI = 17689, COpurpuraLS = 2349;
        double NO2verdeLS = 100, NO2amarilloLI = 101, NO2amarilloLS = 189, NO2naranjaLI = 190, NO2naranjaLS = 677, NO2rojoLI = 678, 
                NO2rojoLS = 1221, NO2purpuraLI = 1222, NO2purpuraLS = 2349;
        double verdeLS = 50, amarilloLI = 51, amarilloLS = 100, naranjaLI = 101, naranajaLS = 150, rojoLI = 151, rojoLS = 200, purpuraLI = 201, purpuraLS = 300;
        String[] contaminante = {"Monóxido de carbono (CO)", "Dióxido de nitrógeno (NO2)"};

        JOptionPane.showMessageDialog(null, "El siguiente programa calculará el índice de la calidad del aire (ICA) con base al contaminante escogido");
        var opcionContaminante = (String) (JOptionPane.showInputDialog(null, "Selecciona el contaminante", "Contaminantes", JOptionPane.INFORMATION_MESSAGE, 
                null, contaminante, contaminante[0]));
        double CP = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad medida del contaminante seleccionado"));

        switch (opcionContaminante) {
            case "Monóxido de carbono (CO)":
                if (CP >= liInicial && CP <= COverdeLS) {
                    x = verdeLS - liInicial;
                    y = COverdeLS - liInicial;
                    z = CP - liInicial;
                    resultado = ((x / y) * z) + liInicial;
                    //System.out.println(x + "----" + y + "-----" + "----"+ z + CP);
                } else if (CP >= COamarilloLI && CP <= COamarilloLS) {
                    x = amarilloLS - amarilloLI;
                    y = COamarilloLS - COamarilloLI;
                    z = CP - COamarilloLI;
                    resultado = ((x / y) * z) + amarilloLI;
                } else if (CP >= COnaranjaLI && CP <= COnaranjaLS) {
                    x = naranajaLS - naranjaLI;
                    y = COnaranjaLS - COnaranjaLI;
                    z = CP - COnaranjaLI;
                    resultado = ((x / y) * z) + naranjaLI;
                } else if (CP >= COrojoLI && CP <= COrojoLS) {
                    x = rojoLS - rojoLI;
                    y = COrojoLS - COrojoLI;
                    z = CP - COrojoLI;
                    resultado = ((x / y) * z) + rojoLI;
                } else if (CP >= COpurpuraLI && CP <= COpurpuraLS) {
                    x = purpuraLS - purpuraLI;
                    y = COpurpuraLS - COpurpuraLI;
                    z = CP - COpurpuraLI;
                    resultado = ((x / y) * z) + purpuraLI;
                }
                System.out.println(resultado);
                break;

            case "Dióxido de nitrógeno (NO2)":
                if (CP >= liInicial && CP <= NO2verdeLS) {
                    x = verdeLS - liInicial;
                    y = NO2verdeLS - liInicial;
                    z = CP - liInicial;
                    resultado = ((x / y) * z) + liInicial;
                } else if (CP >= NO2amarilloLI && CP <= NO2amarilloLS) {
                    x = amarilloLS - amarilloLI;
                    y = NO2amarilloLS - NO2amarilloLI;
                    z = CP - NO2amarilloLI;
                    resultado = ((x / y) * z) + amarilloLI;
                } else if (CP >= NO2naranjaLI && CP <= NO2naranjaLS) {
                    x = naranajaLS - naranjaLI;
                    y = NO2naranjaLS - NO2naranjaLI;
                    z = CP - NO2naranjaLI;
                    resultado = ((x / y) * z) + naranjaLI;
                } else if (CP >= NO2rojoLI && CP <= NO2rojoLS) {
                    x = rojoLS - rojoLI;
                    y = NO2rojoLS - NO2rojoLI;
                    z = CP - NO2rojoLI;
                    resultado = ((x / y) * z) + rojoLI;
                } else if (CP >= NO2purpuraLI && CP <= NO2purpuraLS) {
                    x = purpuraLS - purpuraLI;
                    y = NO2purpuraLS - NO2purpuraLI;
                    z = CP - NO2purpuraLI;
                    resultado = ((x / y) * z) + purpuraLI;
                }
                System.out.println(resultado);
                break;
        }

        try {
                       
            StringBuilder buil = new StringBuilder();

            String calidad = "";
            if (resultado >= liInicial && resultado <= verdeLS) {
                calidad = """
                          La calidad del aire es buena 
                           SIGNIFICADO 
                           La calidad del aire es satisfactoria y existe poco o ningún riesgo para la salud.
                          RECOMENDACIONES 
                           Se puede realizar cualquier actividad al aire libre.""";
                JOptionPane.showMessageDialog(null, calidad);
            } else if (resultado >= amarilloLI && resultado <= amarilloLS) {
                calidad = """
                          La calidad del aire es aceptable
                          SIGNIFICADO
                          La calidad del aire es aceptable, sin embargo, en el caso de algunos contaminantes, las personas parte de los grupos sensibles pueden presentar síntomas moderados
                          RECOMENDACIONES 
                          Los grupos sensibles deben considerar limitar los esfuerzos prolongados al aire libre.
                            """;
                JOptionPane.showMessageDialog(null, calidad);
            } else if (resultado >= naranjaLI && resultado <= naranajaLS) {
                calidad = """
                          La calidad del aire es dañina para grupos sensibles
                          SIGNIFICADO
                          Quienes pertenecen a los grupos sensibles pueden experimentar efectos en la salud. El público en general usualmente no es afectado.
                          RECOMENDACIONES
                          Los grupos sensibles deben limitar los esfuerzos prolongados al aire libre.
                          """;
                JOptionPane.showMessageDialog(null, calidad);
            } else if (resultado >= rojoLI && resultado <= rojoLS) {
                calidad = """
                          La calidad del aire es dañina para la salud
                          SIGNIFICADO
                          Todos puedes experimentar efectos en la salud. Quienes pertenecen a los grupos sensibles pueden experimentar efectos graves en la salud.
                          RECOMENDACIONES
                          Los grupos sensibles deben evitar el esfuerzo prolongado al aire libre. La población en general debe limitar el esfuerzo prolongado al aire libre.""";
                JOptionPane.showMessageDialog(null, calidad);
            } else if (resultado >= purpuraLI && resultado <= purpuraLS) {
                calidad = """
                          La calidad del aire es muy dañina para la salud
                          SIGNIFICADO
                          Representa una condición de emergencia. Toda la población tiene probabilidades de ser afectada.
                          RECOMENDACIONES
                          La población en general debe suspender los esfuerzos al aire libre.""";
                JOptionPane.showMessageDialog(null, calidad);
            }
            
            File file = new File("C:\\Users\\marim\\OneDrive\\Documentos\\NetBeansProjects\\PIF_CalidadDelAire\\src\\pif_calidaddelaire\\pif.txt");
            
            buil.append(LocalDate.now().toString());
            buil.append(":\n");
            buil.append(calidad);
            buil.append("\n");
            buil.append(String.valueOf(resultado));
            buil.append("\n");
            FileWriter fl = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fl);
            bw.write(buil.toString());
            bw.close();
        } catch (IOException e) {
            System.err.println("File writing may have failed... " + e.getMessage());
        }

    }

}
