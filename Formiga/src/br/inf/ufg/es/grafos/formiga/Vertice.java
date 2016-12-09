package br.inf.ufg.es.grafos.formiga;
/**
 *
 * @author Dhiogo
 */
public class Vertice {
    private int num;
    private int[] pos;
    private Vertice prox;
    private int adj[] = new int[4];
    private int cor; //1- branco; 2 - cinza; 3-preto
    private int distancia;
    private Vertice pi;
    
    public Vertice(int num, int l, int c){
        this.num = num;
        this.pos = new int[2];
        this.pos[0] = l;
        this.pos[1] = c;
        this.prox = null;
        this.adj[0] = -1;
        this.adj[1] = -1;
        this.adj[2] = -1;
        this.adj[3] = -1;
        this.cor = 1;
        this.distancia = -1;
        this.pi = null;
    }
    
    public void setCor(int n){
        this.cor = n;
    }
    
    public int getCor(){
        return this.cor;
    }
    
    public void setDist(int n){
        this.distancia = n;
    }
    
    public int getDist(){
        return this.distancia;
    }
    
    public void setPi(Vertice v){
        this.pi = v;
    }
    
    public Vertice getPi(){
        return this.pi;
    }
    
    public int getNum(){
        return this.num;
    }
    
    public int[] getPos(){
        return this.pos;
    }
    
    public int getLinha(){
        return this.pos[0];
    }
    
    public int getColuna(){
        return this.pos[1];
    }
    
    public Vertice getProx(){
        return this.prox;
    }
    
    public void setProx(Vertice p){
        this.prox = p;
    }
    
    public void addAdj(int n){
        int i = 0;
        while(this.adj[i] != -1 && i < 4){
            i++;
        }
        if(i < 4){
            this.adj[i] = n;
        } 
    }
    
    public int[] getAdj(){
        return this.adj;
    }
}
