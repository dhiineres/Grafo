package dijkstra;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Scanner;

public class Busca {
    private ArrayList<Vertice> Q;
    private ArrayList<Vertice> S;
    private String saida;
    private Matriz matriz;
    
    public Scanner scan = new Scanner(System.in);
    
    public void busca(){
        int size = Integer.parseInt(scan.nextLine());
        matriz = new Matriz(size);
        S = new ArrayList();
        Q = matriz.getLista();
        Q.get(0).setPeso(0);
        while (Q.size() > 0){
            Vertice u = min();
            S.add(u);
        }
    }
    
    public void setSaida(){
        StringBuilder build = new StringBuilder();
        Vertice temp;
        for (int i = 0; i < matriz.getSize(); i ++){
            for (int j = 1; j < matriz.getSize() - 1; j++){
                if (S.get(j - 1).getNum() > S.get(j).getNum()){
                    temp = S.get(j - 1);
                    S.set(j - 1, S.get(j));
                    S.set(j, temp);
                }
            }
        }
        build.append("Dijkstra ");
        for (int i = 1; i < S.size() - 1; i++){
            build.append(S.get(i)+ " ");
            if (i++ == S.size() - 1){
                build.append(S.get(i++));
            }
        }
        this.saida = build.toString();
    }
    
    public String getSaida(){
        return this.saida;
    }
    
    public Vertice min(){
        Vertice min = new Vertice(MAX_VALUE);
        for (int i = 0; i < Q.size(); i++){
            if (min.getPeso() < Q.get(i).getPeso())
                min = Q.get(i);
        }
        Q.remove(min);
        min.Visita();
        return min;
    }
    
    public void relax(){
        
    }
}
