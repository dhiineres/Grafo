package br.inf.ufg.es.grafos.formiga;

import java.util.ArrayList;

/**
 *
 * @author Dhiogo
 */
public class Fila {
    private ArrayList<Integer> fila;
    
    public Fila(){
        this.fila = new ArrayList<>();
    }
    
    public int getSize(){
        return this.fila.size();
    }
    
    public int unQueue(){
        int i = fila.get(0);
        this.fila.remove(0);
        return i;
    }
    
    public void addItem(int v){
        fila.add(v);
    }
    
    
}
