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
    
    public Busca(){
        this.Q = null;
        this.S = null;
        this.saida = null;
        this.matriz = null;
    }
    
    public void busca(){
        System.out.println("Tamanho:");
        int size = Integer.parseInt(scan.nextLine());
        matriz = new Matriz(size);
        System.out.println("Define listas:");
        S = new ArrayList();
        Q = matriz.getLista();
        Q.get(0).setPeso(0);
        while (Q.size() > 0){
            System.out.println("tamanho de Q: "+ Q.size());
            Vertice u = min();
            S.add(u);
            relax(u);
        }
        setSaida();
    }
    
    public void setSaida(){
        StringBuilder build = new StringBuilder();
//        Vertice temp;
//        for (int i = 0; i < matriz.getSize(); i ++){
//            for (int j = 1; j < matriz.getSize() - 1; j++){
//                if (S.get(j - 1).getNum() > S.get(j).getNum()){
//                    temp = S.get(j - 1);
//                    S.set(j - 1, S.get(j));
//                    S.set(j, temp);
//                }
//            }
//        }
        build.append("Dijkstra ");
        for (int i = 1; i < S.size() - 1; i++){
            build.append(S.get(i).getPeso()+ " ");
            if (i++ == S.size() - 1){
                build.append(S.get(i++).getPeso());
            }
        }
        this.saida = build.toString();
    }
    
    public String getSaida(){
        return this.saida;
    }
    
    public Vertice min(){
        Vertice min = new Vertice(MAX_VALUE);
        int index = 0;
        for (int i = 0; i < Q.size(); i++){
            if (min.getPeso() < Q.get(i).getPeso()){
                min = Q.get(i);
                index = i;
            }   
        }
        Q.remove(index);
        min.Visita();
        return min;
    }
    
    public void relax(Vertice V){
       int[][] tabela = matriz.getTabela();
       int index = V.getNum();
       for (int c = 0; c < matriz.getSize(); c++){
           System.out.println("relax?");
           if (tabela[index][c] > 0){
               int j = 0;
               do{
                   j++;
               }while(j < Q.size() && Q.get(j).getNum() != c);
               if(Q.get(j).getPeso() > V.getPeso() + tabela[index][c]){
                   Q.get(j).setPeso(V.getPeso() + tabela[index][c]);
                   Q.get(j).setPi(V);
               }
           }
       }
    }
}
