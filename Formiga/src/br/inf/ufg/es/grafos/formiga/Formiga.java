package br.inf.ufg.es.grafos.formiga;

import java.util.Scanner;

public class Formiga {
    public static Scanner scan = new Scanner(System.in);
    public static Matriz mat;
    public static ListaAdj lista;
    public static BFS busca;
    
    public static void getLista(int n){
        mat = new Matriz(n);
        for (int l = 0; l < n; l++){
            for(int c = 0; c < n; c++){
                if (c == 10){
                    int num = Integer.parseInt(scan.nextLine());
                    mat.addItem(num, l, c);
                }else{
                    int num = scan.nextInt();
                    mat.addItem(num, l, c);
                }
            }
        }
        lista = mat.getLista();
    }
    
    public static void buscar(int n){
        getLista(n);
        busca = new BFS(lista);
        System.out.println(busca.busca(n));
    } 
    
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(scan.nextLine());
        buscar(n);
    }
    
}
