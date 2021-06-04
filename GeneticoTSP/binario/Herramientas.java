/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 *
 * @author working
 */
public class Herramientas {
    
    public static int[] generarArregloBinarios(int n ){
        int[] arreglo = new int[n];
        Random ran = new Random();
        for(int x=0; x< n ;x++){
            arreglo[x]= ran.nextInt(2);
        }
        return arreglo;
    }

    public static int[] generarArregloDivisor(int n ){
        int[] arreglo = new int[n];
        Random ran = new Random();
        int divisor = Herramientas.getRandomNumber(2, n-1);
        int bin = 1;
        int bin2 = 0;

        for(int x=0; x< divisor ;x++){
            arreglo[x]= bin;
        }
        for(int x=divisor; x<n ;x++){
            arreglo[x]= bin2;
        }
        return arreglo;
    }

    public static int[] generarArregloSec(int n ){
        int[] arreglo = new int[n];
        int divisor1 = Herramientas.getRandomNumber(1,(int) n/2);
        int divisor2 = Herramientas.getRandomNumber((int) n/2, n-1);

        arreglo[0]= 1;
        for(int x=1; x< divisor1 ;x++){
            arreglo[x]= 0;
        }
        for(int x=divisor1; x<divisor2;x++){
            arreglo[x]= 1;
        }

        for(int x=divisor2; x<n;x++){
            arreglo[x]= 0;
        }
        return arreglo;
    }

    public static int[] generarArregloDecimal(int n){
        int[] arreglo = new int[n];
        Random ran = new Random();
        for(int x=0; x< n ;x++){
            arreglo[x]= ran.nextInt(10);
        }
        return arreglo;
    }

    public static int[][] generarTableroAleatorio(int n){
        int[][] tablero = new int[n][n];

        for(int i =0;i<n;i++){
            Random ran = new Random();
            int rand = ran.nextInt(n);

            tablero[i][rand] = 1;
        }
        return tablero;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Individuo mejorPoblacion(ArrayList<Individuo> pob, double[][] matrizDistancias, int ciudadInicial, double[][] matrizInclinaciones){
        Individuo mejor = new Individuo(pob.get(0),matrizDistancias, ciudadInicial, matrizInclinaciones);
        for(Individuo aux: pob){
            if (aux.getFitness()< mejor.getFitness()){
                mejor = new Individuo(aux, matrizDistancias, ciudadInicial, matrizInclinaciones);
            }
        }
        /*System.out.print("Fenotipo: ");
        String fenotipo = "";
        for(int i = 0;i<mejor.getFenotipo().length;i++){
            System.out.print(mejor.getFenotipo()[i]);
            if(i==mejor.getFenotipo().length-1){
                fenotipo+=mejor.getFenotipo()[i]+",";
            }else{
                fenotipo+=mejor.getFenotipo()[i]+",";
            }
        }*/

        // try {
        //     bw.write(fenotipo+"\n");
        //     //bw.close();
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }

        System.out.print(" Fitness: "+mejor.getFitness());
        System.out.print("\n");
        //bestFitness.add(mejor.getFitness());
        return mejor;
    }

    public static int mejorFitness(ArrayList<Individuo> pob, double[][] matrizDistancias, int ciudadInicial, double[][] matrizInclinaciones){
        Individuo mejor = new Individuo(pob.get(0),matrizDistancias, ciudadInicial, matrizInclinaciones);
        for(Individuo aux: pob){
            if (aux.getFitness()< mejor.getFitness()){
                mejor = new Individuo(aux,matrizDistancias, ciudadInicial, matrizInclinaciones);
            }
        }
        return mejor.getFitness();
    }
}
