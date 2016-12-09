package br.inf.ufg.es.grafos.formiga;

/**
 *
 * @author Dhiogo
 */
public class ListaAdj {
    private Vertice raiz;
    int tamanho;
    
    public ListaAdj(){
        this.raiz = null;
        this.tamanho = 0;
    }
    
    public void setRaiz(Vertice v){
        this.raiz = v;
    }
    
    public void addVertice(Vertice v){
        if (raiz == null){
            this.setRaiz(v);
            this.tamanho++;
        }else{
            Vertice p = this.raiz;
            while (p.getProx() != null){
                p = p.getProx();
            }
            
            p.setProx(v);
            this.tamanho++;
        }
    }
     
    public Vertice getVertice(int n){
        Vertice p = this.raiz;
        if(raiz == null){
            return null;
        }else{
            while(p.getProx() != null && p.getNum() != n){
                p = p.getProx();
            }
            if(p.getNum() == n){
                return p;
            }else{
                return null;
            }
        }
    }
    
    public int getDist(int n){
        n--;
        Vertice p = this.raiz;
        if(raiz == null){
            return -1;
        }else{
            while(p.getProx() != null && p.getLinha() != n &&
                    p.getColuna() != n){
                p = p.getProx();
            }
           
            return p.getDist();
        }
    }
}
