package br.inf.ufg.es.grafos.formiga;
/**
 *
 * @author Dhiogo
 */
public class ItemMatriz {
    private int val;
    private int num;
    
    public ItemMatriz(int val, int cont){
        if(val == 0){
            this.val = 0;
            this.num = cont;
        }else{
            this.val = -1;
            this.num  = -1;
        }
    }
    
    public int getVal(){
        return this.val;
    }
    
    public int getNum(){
        return this.num;
    }
}
