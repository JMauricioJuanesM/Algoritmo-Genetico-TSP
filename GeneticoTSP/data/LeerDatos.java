
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import binario.Individuo;

public class LeerDatos {
    public static ArrayList<Individuo> getFenotipos(){
        ArrayList<Individuo> instancias = new ArrayList<>();
        LinkedList<String> fenotipos = new LinkedList();
        String texto, aux;

        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    fenotipos.add(texto);// Aqui agrega todo el data set
                }
                lee.close();//cierra el archivo

                ArrayList<Integer> fenotipos2 = new ArrayList();
                for (int i = 0; i < fenotipos.size(); i++) {
                    StringTokenizer st = new StringTokenizer(fenotipos.get(i), ",");
                    //int[] auxArray = new int[fenotipos2.get(0).length];
                    while (st.hasMoreTokens()) {
                        //auxArray[]
                        fenotipos2.add(Integer.parseInt(st.nextToken()));
                    }

                    int[] fen = new int[fenotipos2.size()];

                    for(int y=0;i<fenotipos2.size();i++){
                        fen[y] = fenotipos2.get(y);
                    }
                    //instancias.add(new Individuo(fen));
                    fenotipos2.clear();
                }
            }
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);            
        }
        return instancias;
    }

    public static double[][] getMatriz(){
        ArrayList<Individuo> instancias = new ArrayList<>();
        LinkedList<String> fenotipos = new LinkedList();
        double[][] fen = null;
        String texto, aux;

        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    fenotipos.add(texto);// Aqui agrega todo el data set
                }
                lee.close();//cierra el archivo

                ArrayList<Double> fenotipos2 = new ArrayList();
                int tam = fenotipos.size();
                fen = new double[tam][tam];
                for (int i = 0; i < tam; i++) {
                    StringTokenizer st = new StringTokenizer(fenotipos.get(i), ",");
                    while (st.hasMoreTokens()) {
                        fenotipos2.add(Double.parseDouble(st.nextToken()));
                    }

                    for(int y=0;y<tam;y++){
                        fen[i][y] = fenotipos2.get(y);
                    }

                    fenotipos2.clear();
                }
            }
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);            
        }
        return fen;
    }
}
