/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.Parentesisinvalidoexception;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author eriss
 */
public class Caracteres {
    private ArrayList<Character> caracteres;
    private ArrayList<Character> stack;
    private ArrayList<Character> result;

    public Caracteres() {
        caracteres=new ArrayList<>();
    }
    
    public void agregar(Character caractere){
        caracteres.add(caractere);
    }
    
    public String convertir(){
        StringBuilder buider=new StringBuilder(this.caracteres.size());
        for(Character ch:this.caracteres){
            buider.append(ch);
        }
        return buider.toString();
    }
    
    public void borra(){
        this.caracteres.clear();
    }
    
    public void borraruno(){
        int a=caracteres.size()-1;
        if(a>=0){
            caracteres.remove(a);
        }
    }
    
    public String shuntingYard(){
        stack = new ArrayList<>();
        result = new ArrayList<>();
        int a=0;
        
        Iterator<Character> it = this.caracteres.iterator();
        
        while(it.hasNext()){
            if(this.caracteres.get(a)=='A' || this.caracteres.get(a)=='T' || this.caracteres.get(a)=='X' || this.caracteres.get(a)=='Y' || this.caracteres.get(a)=='Z'){
                this.result.add(this.caracteres.get(a));
            }
            else if(this.caracteres.get(a)=='^'){
                this.stack.add(this.caracteres.get(a));
            }else if(this.caracteres.get(a)==')'){
                while(this.stack.get(this.stack.size()-1) != '('){
                    this.result.add(this.stack.get(this.stack.size()-1));
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.remove(this.stack.size()-1);
            }else if(this.stack.size() > 0 && (this.caracteres.get(a)=='+' || this.caracteres.get(a)=='-')&&(this.stack.get(this.stack.size()-1)=='*' || 
                    this.stack.get(this.stack.size()-1)=='/' || this.stack.get(this.stack.size()-1)=='^')){
                while( this.stack.size() > 0 && (this.stack.get(this.stack.size()-1)=='*' || this.stack.get(this.stack.size()-1)== '/' || this.stack.get(this.stack.size()-1)=='^') ){
                    this.result.add(this.stack.get(this.stack.size()-1));
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.add(this.caracteres.get(a));
            }else if(this.caracteres.get(a)=='('){
                this.stack.add(this.caracteres.get(a));
            }else if(this.stack.size()>0 &&(this.caracteres.get(a)=='*'|| this.caracteres.get(a)=='/')&& this.stack.get(this.stack.size()-1)=='^'){
                while(this.stack.size() > 1 || this.stack.get(this.stack.size()-1)=='^'){
                    this.result.add(this.stack.get(this.stack.size()-1));
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.add(this.caracteres.get(a));
            }else{
                this.stack.add(this.caracteres.get(a));
            }
            
            a++;
            it.next();
        }
        
        while(this.stack.size()>0){
            this.result.add(this.stack.get(this.stack.size()-1));
            this.stack.remove(this.stack.size()-1);
        }
        
        StringBuilder builder = new StringBuilder(this.result.size());
        
        for(Character ch: this.result){
            builder.append(ch);
        }
        
        return builder.toString();
    }
    
    public boolean comprobar(){
        int a=0,b=0;
        for(int i=0;i<this.caracteres.size();i++){
            if(this.caracteres.get(i)=='('){
                a++;
            }else{
                if(this.caracteres.get(i)==')'){
                    b++;
                }
            }
        }
        return b==a;
    }
}



