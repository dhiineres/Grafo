package br.inf.ufg.es.grafos.formiga;

import java.util.ArrayList;

/**
 *
 * @author Dhiogo
 */
public class BFS {
    private ListaAdj lista;
    private ArrayList<Integer> f = new ArrayList<>();
    
    public BFS(ListaAdj lista){
        this.lista = lista;
    }
    
    public int busca(int doce){
        Vertice vert;
        lista.getVertice(1).setCor(2);
        lista.getVertice(1).setDist(1);
        lista.getVertice(1).setPi(null);
        //System.out.print(".");
        f.add(1);
        while(f.size() > 0){
            int u = f.get(0);
            f.remove(0);
            //System.out.print("teste?.");
            vert = lista.getVertice(u);
            int adj[] = lista.getVertice(u).getAdj();
            int i=0;
            while(adj[i] != -1 && i < 4){
                //System.out.println("e aqui?");
                int v = adj[i];
                if(lista.getVertice(v) != null && lista.getVertice(v).getCor() == 1){
                    lista.getVertice(v).setCor(2);
                    lista.getVertice(v).setDist(vert.getDist()+1);
                    lista.getVertice(v).setPi(vert);
                    f.add(v);
                    //System.out.print(v +"Entrou aqui?\n");
                }
                i++;
            }
            
            lista.getVertice(u).setCor(3);
            //System.out.println("setou "+ u);
        }
        return lista.getDist(doce + 1);
    }
}
