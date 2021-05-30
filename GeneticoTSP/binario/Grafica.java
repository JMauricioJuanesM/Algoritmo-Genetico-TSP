/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author working
 */
public class Grafica {
    
    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY,titulo;

    public Grafica(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
    }
    
    public void agrearSerie(String nombre){
     XYSeries serie = new XYSeries(nombre);
     this.series.addSeries(serie);
    }
    
    public void agregarDatoASerie(String nombre, XYDataItem dato)   {
       this.series.getSeries(nombre).add(dato);
    }
     
    public void agregarSerie(String nombre, ArrayList<Integer> datos){
    
        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.size();x++){
            serie.add(x, datos.get(x));
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
     
    }

    public void agregarSerie2p(String nombre, double[] datos, String nombre2, double[] datos2){
    
        XYSeries serie = new XYSeries(nombre);
        XYSeries serie2 = new XYSeries(nombre2);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
            serie2.add(x, datos2[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
        this.series.addSeries(serie2);
     
    }
    public void agregarSerie3p(String nombre, double[] datos, String nombre2, double[] datos2, String nombre3, double[] datos3){
    
        XYSeries serie = new XYSeries(nombre);
        XYSeries serie2 = new XYSeries(nombre2);
        XYSeries serie3 = new XYSeries(nombre3);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
            serie2.add(x, datos2[x]);
            serie3.add(x, datos3[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
        this.series.addSeries(serie2);
        this.series.addSeries(serie3);
     
    }
    public void agregarSerie4p(String nombre, double[] datos, String nombre2, double[] datos2, String nombre3, double[] datos3, String nombre4, double[] datos4){
    
        XYSeries serie = new XYSeries(nombre);
        XYSeries serie2 = new XYSeries(nombre2);
        XYSeries serie3 = new XYSeries(nombre3);
        XYSeries serie4 = new XYSeries(nombre4);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
            serie2.add(x, datos2[x]);
            serie3.add(x, datos3[x]);
            serie4.add(x, datos4[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
        this.series.addSeries(serie2);
        this.series.addSeries(serie3);
        this.series.addSeries(serie4);
    }
    public void agregarSerie5p(String nombre, double[] datos, String nombre2, double[] datos2, String nombre3, double[] datos3, String nombre4, double[] datos4, String nombre5, double[] datos5){
    
        XYSeries serie = new XYSeries(nombre);
        XYSeries serie2 = new XYSeries(nombre2);
        XYSeries serie3 = new XYSeries(nombre3);
        XYSeries serie4 = new XYSeries(nombre4);
        XYSeries serie5 = new XYSeries(nombre5);
        // agregar cada uno de los datos en la serie 
        for (int x=0; x < datos.length;x++){
            serie.add(x, datos[x]);
            serie2.add(x, datos2[x]);
            serie3.add(x, datos3[x]);
            serie4.add(x, datos4[x]);
            serie5.add(x, datos5[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
        this.series.addSeries(serie2);
        this.series.addSeries(serie3);
        this.series.addSeries(serie4);
        this.series.addSeries(serie5);
    }
    
    public JFreeChart getGrafica(){
        return this.grafica;
    }
    public void crearGrafica(){
        this.grafica = ChartFactory.createXYAreaChart(titulo, ejeX, ejeY, series);
    }
    
     public void muestraGrafica(){
    
        ChartFrame frame = new ChartFrame("Histograma de color", grafica);
        frame.setVisible(true);
        frame.setSize(500,370);
        
    }

     
     
}
