/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author working
 */
public class Cruza {

    public static Individuo cruzaPorMascaraBinaria(Individuo madre, Individuo padre, int[] mask,
            int[][] matrizDistancias, int ciudadInicial, int[][] matrizInclinaciones) {
        int n = madre.getFenotipo().length;
        int[] gen1 = new int[n];
        ArrayList<Integer> g1 = new ArrayList<Integer>();
        int[] gen2 = new int[n];
        ArrayList<Integer> g2 = new ArrayList<Integer>();
        int aux = 0;

        for(int i=0;i<n;i++){
            if(mask[i]==1){
                g1.add(madre.getFenotipo()[i]);
                gen1[i]=madre.getFenotipo()[i];
            }
        }

        for(int i=0;i<n;i++){
            if(mask[i]==0){
                aux=diferentNumArray(g1, n, padre.getFenotipo()[i]);
                gen1[i]= aux;
                g1.add(aux);
            }
        }
        for(int i=0;i<n;i++){
            if(mask[i]==1){
                g2.add(padre.getFenotipo()[i]);
                gen2[i]=padre.getFenotipo()[i];
            }
        }

        for(int i=0;i<n;i++){
            if(mask[i]==0){
                aux=diferentNumArray(g2, n, madre.getFenotipo()[i]);
                gen2[i]= aux;
                g2.add(aux);
            }
        }

        Individuo i1 = new Individuo(gen1, matrizDistancias, ciudadInicial, matrizInclinaciones);
        Individuo i2 = new Individuo(gen2, matrizDistancias, ciudadInicial, matrizInclinaciones);

        if (i1.getFitness() < i2.getFitness()) {
            return i1;
        } else {
            return i2;
        }
    }

    public static int diferentNum(ArrayList<Integer> arr, int n){
        int out = 1;
        Boolean dif = false;

        for(int i=0;i<n;i++){
            for(int j=0;j<arr.size();j++){
                if(arr.get(j)==i){
                    dif=false;
                    break;
                }else{
                    dif=true;
                }
            }
            if(dif){
                out=i;
                break;
            }
        }
        return out;
    }

    public static int diferentNumArray(ArrayList<Integer> arr, int n, int pama){
        int out = -1;
        Boolean dif = false;

        for(int j=0;j<arr.size();j++){
            if(arr.get(j)==pama){
                dif=false;
                break;
            }else{
                dif=true;
            }
        }
        if(dif){
            out=pama;
        }

        if(out==-1){
            for(int i=0;i<n;i++){
                for(int j=0;j<arr.size();j++){
                    if(arr.get(j)==i){
                        dif=false;
                        break;
                    }else{
                        dif=true;
                    }
                }
                if(dif){
                    out=i;
                    break;
                }
            }
        }
        return out;
    }
}
