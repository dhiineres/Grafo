package dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int size;
    public Scanner scan = new Scanner(System.in);
    
    
    public Matriz(int size){
        this.matriz = new int[size][size];
        int dist;
        this.size = size;
        for(int l = 0; l < size; l++){
            for (int c = 0; c < size; c++){
                if (c == size){
                    dist = Integer.parseInt(scan.nextLine());
                }else {
                    dist = scan.nextInt();
                }
                this.matriz[l][c] = dist;
            }
        }
    }
    
    public int getDist(int l, int c){
        if (l >= 0 && l < size && c >= 0 && c < size){
            return matriz[l][c];
        }else 
            return -1;
    }
    
//    public ArrayList getLista(){
//        return this.lista;
//    }
    
    public int getSize(){
        return size;
    }
    
    public int[][] getTabela(){
        return this.matriz;
    }
}
