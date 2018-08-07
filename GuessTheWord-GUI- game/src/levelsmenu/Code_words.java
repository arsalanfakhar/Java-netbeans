/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levelsmenu;

/**
 *
 * @author Arsalan Fakhar
 */
public abstract class Code_words {
     private static String[] Words={"hello","Pakistan","shan","gamer","hacker","killer","none","dreamer","creative",
         "logic" 
     };
     private static final String[] easy={"HELLO","PAKISTAN","SHAN","GAMER","HACKER","KILLER","NONE","DREAMER","CREATIVE",
         "LOGIC" };
     private static final String[] medium={"CASE","FRAGMENT","PATTERN","PIECE","SAMPLING","SPECIMEN","BIT","BITE","KILL","ELEMENT"};
     private static final String[]hard={"MORSEL","PART","PORTION","KICK","UNIT","SIGN","FUCK","ATOM","DOSE","TRACE"};


    public Code_words() {
        
    }
     
    /**
     * @return the Words
     */
    public static String[] getWords() {
        
        return Words;
    }
    public static  void setWords(char c){
        if(c=='e'){
            Words=easy;
        }
        if(c=='m'){
            Words=medium;
        }
        if(c=='h'){
            Words=hard;
        }
    
    }
}
