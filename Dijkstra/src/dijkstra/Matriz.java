package dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private ArrayList<Vertice> lista = new ArrayList();
    private int size;
    public Scanner scan = new Scanner(System.in);
    
    
    public Matriz(int size){
        this.size = size;
        this.matriz = new int[size][size];
        for(int l = 0; l < size; l++){
            lista.add(new Vertice(l));
            for (int c = 0; c < size; c++){
                if (c != size - 1)
                    this.matriz[l][c] = scan.nextInt();
                else
                    this.matriz[l][c] = Integer.parseInt(scan.nextLine());
            }
        }
    }
    
    public int getDist(int l, int c){
        if (l >= 0 && l < size && c >= 0 && c < size){
            return matriz[l][c];
        }else 
            return -1;
    }
    
    public ArrayList getLista(){
        return this.lista;
    }
    
    public int getSize(){
        return size;
    }
}
