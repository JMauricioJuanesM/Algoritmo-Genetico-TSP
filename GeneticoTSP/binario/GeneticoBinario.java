/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import data.LeerDatos;

/**
 *
 * @author working
 */
public class GeneticoBinario {
    
    private int tamanoPob;
    private int numGeneraciones;
    private double probMuta;
    private int bits;
    private int ciudadInicial;
    private ArrayList<Individuo> poblacionActual;
    private ArrayList<Integer> bestFitness = new ArrayList<Integer>(numGeneraciones);
    private Boolean poblacionFromFile = false;
    private int[][] matrizDistancias;
    private int[][] matrizInclinaciones;
    

    public GeneticoBinario(int tamanoPob, int numGeneraciones, double probMuta,int bits, int[][] matrizDistancias, int[][] matrizInclinaciones, int ciudadInicial) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.matrizInclinaciones = matrizInclinaciones;
        this.poblacionActual = new ArrayList<>();
        this.matrizDistancias = matrizDistancias;
        this.ciudadInicial = ciudadInicial;
    }

    public GeneticoBinario(int tamanoPob, int numGeneraciones, double probMuta,int bits, ArrayList<Individuo> poblacionActual) {
        this.tamanoPob = tamanoPob;
        this.numGeneraciones = numGeneraciones;
        this.probMuta = probMuta;
        this.bits =bits;
        this.poblacionActual = new ArrayList<>();
        getPoblacionFile2(poblacionActual);
        poblacionFromFile = true;
    }
    
    public void evolucionar(){
    
    if(!poblacionFromFile){
        generarPoblacionInicial();
    }
    // proceso evolutivo que tiene relación con el numero de generaciones
    for(int g=1;g<this.numGeneraciones;g++){
        ArrayList<Individuo> nuevaPob = new ArrayList<>();
        // garantizar que se va a generar una población nueva 
        for (int i=0; i<this.tamanoPob;i++){
            // Seleccion de una madre 
            Individuo madre = Seleccion.seleccionAleatoria(this.getPoblacionActual(), matrizDistancias, ciudadInicial, matrizInclinaciones);
            // Seleccion de un padre
            Individuo padre = Seleccion.seleccionAleatoria(this.getPoblacionActual(), matrizDistancias, ciudadInicial, matrizInclinaciones);
            // cruza (Retornar el mejor ind de la cruza)
            int[] mask = Herramientas.generarArregloSec(madre.getGenotipo().length);
            Individuo hijo = Cruza.cruzaPorMascaraBinaria(madre, padre, mask, matrizDistancias, ciudadInicial, matrizInclinaciones);
            // Se aplica una muta evaluando una probabilidad
            if (generarProbabilidadMuta()){
               Muta.mutaSimple(hijo);
            }

            nuevaPob.add(hijo);
        }
        //Individuo ind;
        Herramientas.mejorPoblacion(nuevaPob, matrizDistancias, ciudadInicial, matrizInclinaciones);
        bestFitness.add(Herramientas.mejorFitness(nuevaPob, matrizDistancias, ciudadInicial, matrizInclinaciones));

        // actualización de la población
        sustituirPoblacion(nuevaPob);
    }
    Grafica g1 = new Grafica("Generación","Fitness","Mejores Fitness");
       g1.agregarSerie("Fitness",bestFitness);
       g1.crearGrafica();
       g1.muestraGrafica();
    }

    private void generarPoblacionInicial() {
       // generar un población aleatoria de individuos
       for(int i=0; i < this.tamanoPob;i++){
           this.getPoblacionActual().add(new Individuo(this.bits, matrizDistancias, ciudadInicial, matrizInclinaciones));
       }
       
    }

    private void getPoblacionFile(ArrayList<Individuo> poblacionActual){
        int contador = -1;
        for(int i=poblacionActual.size(); contador < i;i--){
            this.getPoblacionActual().add(new Individuo(poblacionActual.get(i-1).getFenotipo(), matrizDistancias, ciudadInicial, matrizInclinaciones));
            //if(contador < this.tamanoPob-1){
                contador++;
            //}
        }
    }

    private void getPoblacionFile2(ArrayList<Individuo> poblacionActual){
        // for(int i=0; i < this.tamanoPob|| i < poblacionActual.size();i++){
        //     this.getPoblacionActual().add(new Individuo(poblacionActual.get(i)));
        // }
        int i = 0;
        while(i < this.tamanoPob && i < poblacionActual.size()){
            this.getPoblacionActual().add(new Individuo(poblacionActual.get(i), matrizDistancias, ciudadInicial, matrizInclinaciones));
        }
    }

    private boolean generarProbabilidadMuta() {
       
        if (this.probMuta>Math.random()){
           return true;
       } else{ return false;}
        
    }

    private void sustituirPoblacion(ArrayList<Individuo> nuevaPob) {
        this.getPoblacionActual().clear();
       for(Individuo aux:nuevaPob){
           this.getPoblacionActual().add(new Individuo(aux, matrizDistancias, ciudadInicial, matrizInclinaciones));
       }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<Individuo> getPoblacionActual() {
        return poblacionActual;
    } 
}
