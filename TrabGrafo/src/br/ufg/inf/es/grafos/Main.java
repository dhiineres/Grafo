package br.ufg.inf.es.grafos;

import java.util.Scanner;

public class Main {
    public static Grafo grafo;
    public static Scanner input = new Scanner(System.in);
    
    public static void iniciaGrafo(){
        System.out.println("Digite a quantidade de Vértices do grafo:");
        System.out.print(" - ");
        int numV = Integer.parseInt(input.nextLine());
        grafo = new Grafo(numV);
        for (int i = 1; i <= numV; i++){
            for (int j = 1; j<= i; j++){
                if (i == j){
                    grafo.addAresta(false);
                }else{
                    System.out.println("Os vértices ["+ i +"]["+ j +
                            "] são vizinhos? S/N");
                    System.out.print(" - ");
                    String resp = input.nextLine();
                    grafo.addAresta(resp.charAt(0) == 'S' || resp.charAt(0) == 's');
                }
            }
        }
        grafo.setOrdemGraus();
    }
    
    public static int menu(){
        System.out.println("--------------MENU--------------");
        System.out.println("|1. Determinar Grau            |");
        System.out.println("|2. Graus Máximo e Mínimo      |");
        System.out.println("|3. Determinar Vizinhos        |");
        System.out.println("|4. Obter sequencia de graus   |");
        System.out.println("|5. Determinar classe          |");
        System.out.println("|6. Obter k-regularidade       |");
        System.out.println("|7. Obter centro               |");
        System.out.println("|0. Sair                       |");
        System.out.println("--------------------------------\n");
        
        return Integer.parseInt(input.nextLine());
    }
    
    public static void printGrau(){
        System.out.print("Entre com o vértice: ");
        int v = Integer.parseInt(input.nextLine());
        System.out.println("Grau de "+ v +": "+ grafo.getGrau(v));
    }
    
    public static void printVizinhos(){
        System.out.print("Entre com o vértice: ");
        int v = Integer.parseInt(input.nextLine());
        System.out.println(grafo.getVizinhos(v));
    }
    
    public static void printClasse(){
        boolean flag = false;
        if (grafo.isCaminho()){
            System.out.println("O grafo é um caminho.");
            flag = true;
        }if (grafo.isCiclo()){
            System.out.println("O grafo é um ciclo.");
            flag = true;
        }if (grafo.isCompleto()){
            System.out.println("O grafo é completo.");
            flag = true;
        }
        if (!flag){
            System.out.println("O grafo não pertence a nenhuma classe");
        }
    }
    
    public static void printKRegular(){
        System.out.print("Entre com k: ");
        int k = Integer.parseInt(input.nextLine());
        if(grafo.isKRegular(k)){
            System.out.println("O grafo é K-Regular de "+ k);
        }else{
            System.out.println("O grago não é k-Regular de "+ k);
        }
    }
    
    public static void main(String[] args){
        iniciaGrafo();
        boolean flag = true;
        do{
            System.out.println("\n");
            switch (menu()){
                case 1:
                    printGrau();
                    break;
                case 2:
                    System.out.println(grafo.getVerticeMaior());
                    System.out.println(grafo.getVerticeMenor());
                    break;
                case 3:
                    printVizinhos();
                    break;
                case 4:
                    System.out.println(grafo.getOrdemGraus());
                    break;
                case 5:
                    printClasse();
                    break;
                case 6:
                    printKRegular();
                    break;
                case 7:
                    //Não funcionou ;-;
                    break;
                case 0:
                    flag = false;
                    break;
            } 
        }while (flag);  
    }
}
