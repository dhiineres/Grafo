package dijkstra;

import static java.lang.Integer.MAX_VALUE;

public class Vertice {
    private int numero;
    private boolean visitado;
    private Vertice pi;
    private int peso;
    
    public Vertice (int num){
       this.numero = num;
       this.visitado = false;
       this.pi = null;
       this.peso = MAX_VALUE;
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
        this.peso = 0;
    }
}

