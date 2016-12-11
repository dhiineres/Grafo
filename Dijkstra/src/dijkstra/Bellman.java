package dijkstra;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
import java.util.Scanner;

public class Bellman {
    private ArrayList<Vertice> verts = new ArrayList();
    private Matriz mat;
    private int[][] tabela;
    
    
    public Bellman(){
    }
    
    public String busca(){
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < size; i++)
            this.verts.add(new Vertice(i));
        this.mat = new Matriz(size);
        this.tabela = mat.getTabela();
        
//        for(int i = 0; i < size; i++){
//            for(int j = 0; j < size; j++){
                  //teste para ver se a matriz passou normalmente;
//                System.out.print(tabela[i][j] +" ");
//            }
//            System.out.println("");
//        }

        iSS();
        
        for (int i = 1; i < size - 1; i++){
            for(int u = 0; u < size; u++){
                for (int v = 0; v < size; v++){
                    
                    if (tabela[u][v] != 0){
                        relax(u, v, tabela[u][v]);
                    }
                }
            }
        }
        
//        por enquanto apresenta erro
//        for (int i = 0; i < size; i++){
//            for(int u = 0; u < size; u++){
//                for (int v = 0; v < size; v++){
//                    if (tabela[u][v] != 0){
//                        Vertice U = verts.get(u);
//                        Vertice V = verts.get(v);
//                        int w = tabela[u][v];
//                        if (V.getPeso() > U.getPeso() + w){
//                             return ("Erro");
//                        }
//                    }
//                }
//            } 
//        }
        
        StringBuilder out = new StringBuilder();
        out.append("BellmanFord");
        
        for(int i = 1; i < verts.size(); i++){
            out.append(" "+ verts.get(i).getPeso());
        }
        
        return out.toString();
    }

    public void relax(int u, int v, int w){
        if(verts.get(v).getPeso() > verts.get(u).getPeso() + w){
            this.verts.get(v).setPeso(verts.get(u).getPeso() + w);
            this.verts.get(v).setPi(verts.get(u));
            System.out.println("valor de w: "+ w);
            System.out.println("relaxando "+ u +" e "+ v +", novo peso "+ verts.get(v).getPeso());
        }
    }
    
    public void iSS(){
        for(int i = 0; i < verts.size(); i++){
            System.out.println("inicializa vertice "+ i);
            this.verts.get(i).setPeso(MAX_VALUE);
            this.verts.get(i).setPi(null);
        }
        this.verts.get(0).setPeso(0);
    }
}
