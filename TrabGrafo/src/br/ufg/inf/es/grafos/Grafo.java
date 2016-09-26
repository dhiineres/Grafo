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
   
    public String getVizinhos(int v){
        StringBuilder out = new StringBuilder();
        out.append("Vértices vizinhos a "+ v +":\n");
        for (int i = 1; i <= this.numVertices; i++){
            if (this.arestas.get(getIndex(i, v))){
                out.append(" - "+ i +"\n");
            }
        }
        
        return out.toString();
    }
    
    public void setOrdemGraus(){
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
    
    public String getOrdemGraus(){
        StringBuilder out = new StringBuilder();
        out.append("\tV - d\n");
        for(int i = 0; i < this.numVertices; i++){
            out.append("\t"+ this.ordVertices.get(i)+" - ");
            out.append( this.grauVertices.get(i) +"\n");
        }
        return out.toString();
    }
    
    public String getVerticeMaior(){
        StringBuilder out = new StringBuilder();
        out.append("Vértice de Maior Grau:");
        out.append("\nV - "+ this.ordVertices.get(0));
        out.append("\nd(V) - "+ this.grauVertices.get(0));
        return out.toString();
    }
    
    public String getVerticeMenor(){
        StringBuilder out = new StringBuilder();
        out.append("Vértice de Menor Grau:");
        out.append("\nV - "+ this.ordVertices.get(this.numVertices - 1));
        out.append("\nd(V) - "+ this.grauVertices.get(this.numVertices - 1));
        return out.toString();
    }
    
    public boolean isCompleto(){
        for (int i = 0; i < this.numVertices; i++){
            if (this.grauVertices.get(i) < this.numVertices - 1){
                return false;
            }
        }
        return true;
    }
    
    public boolean isCiclo(){
        for (int i = 0; i < this.numVertices; i++){
            if (this.grauVertices.get(i) != 2){
                return false;
            }
        }
        return true;
    }
    
    public boolean isKRegular(int k){
        for (int i = 0; i < this.numVertices; i++){
            if (this.grauVertices.get(i) != k){
                return false;
            }
        }
        return true;
    }
    
    public boolean isCaminho(){
        int ponta = 0, meio = 0;
        for (int i = 0; i < this.numVertices; i++){
            if (this.grauVertices.get(i) == 2){
                meio ++;
            }else if (this.grauVertices.get(i) == 1){
                ponta ++;
            }else{
                return false;
            }
        }
        if (ponta == 2){
            return true;
        }else{
            return false;
        }
    }
}