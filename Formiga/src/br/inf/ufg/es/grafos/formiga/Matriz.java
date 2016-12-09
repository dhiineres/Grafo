package br.inf.ufg.es.grafos.formiga;

public class Matriz {
    private ItemMatriz[][] grade;
    private int cont;
    private int n;
    private ListaAdj lista;
    
    public Matriz(int n){
        this.grade = new ItemMatriz[n][n];
        this.cont = 1;
        this.n = n;
    }
    
    public void addItem(int n, int l, int c){
        if(n == 0){
            this.grade[l][c] = new ItemMatriz(n, cont);
            this.cont ++;
        }else{
            this.grade[l][c] = new ItemMatriz(n, -1);
        }
    }
    
    public ItemMatriz getItem(int l, int c){
        if (l >= 0 && l < this.n && c >=0 && c < n )
            return this.grade[l][c];
        else
            return null;
    }
    
    public void setLista(){
        int l, c;
        this.lista = new ListaAdj();
        for (l = 0; l < n; l++){
            for (c = 0; c < n; c++){
                if (this.getItem(l, c).getVal() == 0){
                    Vertice v = new Vertice(this.getItem(l, c).getNum(), l, c);
                    if (l - 1 >= 0 && grade[l-1][c].getVal() == 0){
                        v.addAdj(grade[l-1][c].getNum());
                    }if (c - 1 >= 0 && grade[l][c - 1].getVal() == 0){
                        v.addAdj(grade[l][c-1].getNum());
                    }if (l + 1 < n && grade[l+1][c].getVal() == 0){
                        v.addAdj(grade[l+1][c].getNum());
                    }if (c + 1 < n && grade[l][c+1].getVal() == 0){
                        v.addAdj(grade[l][c+1].getNum());
                    }
                    lista.addVertice(v);
                }
            }
        }
    }
    
    public ListaAdj getLista(){
        this.setLista();
        return this.lista;
    }
}
