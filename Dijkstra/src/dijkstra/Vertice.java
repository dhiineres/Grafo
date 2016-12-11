package dijkstra;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;

public class Vertice {
    private int numero;
    private boolean visitado;
    private Vertice pi;
    private int peso;
    private ArrayList<Vertice> adj;
    private ArrayList<Integer> dist;
    
    public Vertice (int num){
       this.numero = num;
       this.visitado = false;
       this.pi = null;
       this.peso = MAX_VALUE;
       this.adj = new ArrayList();
       this.dist = new ArrayList();
    }
    
    public int getPeso(){
        return peso;
    }
    
    public boolean Estado(){
        return visitado;
    }
    
    public void Visita(){
        this.visitado = true;
    }
    
    public void setPi(Vertice V){
        this.pi = V;
    }
    
    public Vertice getPi(){
        return pi;
    }
    
    public int getNum(){
        return numero;
    }
    
    public void setPeso(int peso){
        this.peso = peso;
    }
    
    public void addAdj(Vertice V, int dist){
        //System.out.println("adiciona adj: "+ V.getNum());
        this.adj.add(V);
        this.dist.add(dist);
    }
    
    public ArrayList getAdj(){
        return adj;
    }
    
    public ArrayList getDists(){
        return dist;
    }
}

