package dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private ArrayList<Vertice> lista = new ArrayList();
    private int size;
    public Scanner scan = new Scanner(System.in);
    
    
    public Matriz(int size){
        int dist;
        this.size = size;
        this.matriz = new int[size][size];
        for (int i = 0; i < size; i++){
            //System.out.println(i);
            lista.add(new Vertice(i));
        }
        for(int l = 0; l < size; l++){
            for (int c = 0; c < size; c++){
                if (c == size){
                    dist = Integer.parseInt(scan.nextLine());
                }else {
                    dist = scan.nextInt();
                }
                this.matriz[l][c] = dist;
                if(dist > 0){
                    lista.get(l).addAdj(lista.get(c), dist);
                }
                
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
    
    public int[][] getTabela(){
        return this.matriz;
    }
}
