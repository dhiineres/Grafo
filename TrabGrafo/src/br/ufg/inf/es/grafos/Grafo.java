package br.ufg.inf.es.grafos;

import java.awt.List;
import java.util.ArrayList;

public class Grafo {
    
    private int numVertices;
    private ArrayList<Boolean> arestas;
    private ArrayList<Integer> ordVertices;
    private ArrayList<Integer> grauVertices;
    
    
    public Grafo(int size){
        if (size > 0){
            this.numVertices = size;
            this.arestas = new ArrayList();
            this.ordVertices = new ArrayList();
            this.grauVertices = new ArrayList();
        }
    }
    
    public void addAresta(Boolean is){
        arestas.add(is);
    }
    
    public int getIndex(int i, int j){
        if (i > this.numVertices || i <= 0 || j > this.numVertices || j <= 0){
            return -1;
        }else{
            if (i > j){
                return (((i * i - i) / 2) + j - 1);
            }
            return (((j * j - j) / 2) + j - 1);
        }
    }
    
    public int getGrau(int i){
        int grau = 0;
        for (int j = 1; j < this.numVertices; j++){
            if (this.arestas.get(getIndex(i, j))){
                grau++;
            }
        }
        return grau;
    }
    
    public void getOrdemGraus(){
        for(int i = 1; i <= this.numVertices; i++){
            this.ordVertices.add(i);
            this.grauVertices.add(getGrau(i));
        }
        
        int j;
        boolean flag = true;
        int auxGrau, auxVertice;
        
        while(flag){
            flag = false;
            for (j = 0; j < this.numVertices - 1; j++){
                if (this.grauVertices.get(j) < this.grauVertices.get(j + 1)){
                    auxGrau = this.grauVertices.get(j);
                    auxVertice = this.ordVertices.get(j);
                    this.ordVertices.set(j, this.ordVertices.get(j + 1));
                    this.grauVertices.set(j, this.grauVertices.get(j + 1));
                    this.ordVertices.set(j + 1, auxVertice);
                    this.grauVertices.set(j + 1, auxGrau);
                    flag = true;
                }
            }
        }
    }
    
}