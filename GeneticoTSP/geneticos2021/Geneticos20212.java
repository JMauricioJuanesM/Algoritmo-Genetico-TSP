/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package geneticos2021;

import data.LeerDatos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

import binario.GeneticoBinario;
import binario.Herramientas;
import binario.Individuo;

/**
 *
 * @author working
 */
public class Geneticos20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] matrizDistancias = LeerDatos.getMatriz();
        int[][] matrizInclinaciones = LeerDatos.getMatriz();
        int ciudadInicial = 0;
       
        //GeneticoBinario gb = new GeneticoBinario(500, 200, 0.12, 64, LeerDatos.getFenotipos());
        GeneticoBinario gb = new GeneticoBinario(250, 200, 0.12, 500, matrizDistancias, matrizInclinaciones, ciudadInicial);

        gb.evolucionar();
        System.out.println(Herramientas.mejorPoblacion(gb.getPoblacionActual(), matrizDistancias, ciudadInicial, matrizInclinaciones));
    }
}
