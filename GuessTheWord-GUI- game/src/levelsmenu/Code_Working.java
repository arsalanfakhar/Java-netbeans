/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levelsmenu;

import guesstheword.gui.MainPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Arsalan Fakhar
 */
public class Code_Working extends Code_words{
     private String[] Wordarray=super.getWords();
    
     Scanner input=new Scanner(System.in);
    
    private  ArrayList<Integer> indexes=new  ArrayList<>();
    private String origstring;
    private char userchar;
    private char[] origch;
    private char[] naklich;
    private char[] indexarraywords;
    
     static int wordcount=0;
     static int level=0;
     private static  int noofstars=3;
     
    public static void setNoofstars(int aNoofstars) {
        noofstars = aNoofstars;
     }
     
    public static int getNoofstars() {
        return noofstars;
    }
//    private final int nofolevels=9;
//    Levels[] l=new Levels[nofolevels];
    
    
    private  int  numberoftries=3;
//    private int noofstars=3;        
    
    public Code_Working() {
//        this.origstring=Wordarray[wordcount];   //or Wordarray[0]
        startGame();
    }
    public Code_Working(int level){
        this.level=level;
        this.wordcount=level;
        startGame();
    
    }
    public Code_Working(char c){
        setWords(c);
    
    }
//    public Working(int n){
//        
//    }
    public void levelStatus(){ 
        System.out.println("You are on level "+(this.level+1));       //beacause array starts from 0
    }

    public void startGame(){
         this.origstring=Wordarray[wordcount];
        levelStatus();
        boolean b=false;
        Checker();
//         while(b!=true){
//                System.out.println("Enter a character you think ");
//                char c=input.next().charAt(0);
//                b=setcharacter(c);
//
//            }    
    }
//    public void nextlevel(){
//        
//        if(level<9){
//            System.out.println("Sucess move onto next level");
//            level++;
//            wordcount++;
//            startGame();
//        
//        }
//        else{
//            System.out.println("You won");
//            System.exit(0);
//        }
//        
//    }
    public void Checker(){
        
        this.origch=getOrigstring().toCharArray();
        this.naklich=getOrigstring().toCharArray();
        
        FindIndexToRemove(getOrigstring().length()); //length bheji jis word ke index pata karne hai
        
        //Ab word ke given indexes ko blank kiya
        for(int i=0;i<getIndexes().size();i++){
            naklich[getIndexes().get(i)]='_';
        }
        System.out.print("Dashes wali string: ");
        System.out.println(naklich);
        System.out.println(naklich.length);
        indexarraywords=new char[getIndexes().size()];
        
    }
    public char[] getNaklich(){
        return this.naklich;
    }
    public boolean setcharacter(char c){
        this.userchar=c;
        return Wordchecker(this.userchar, this.getOrigch(),this.naklich);
    }
    
    public void FindIndexToRemove(int wordlength){
        
        //kitni dafa aur konse indexes 
        //ye hame index nikal kar de dega
        int length=wordlength;
        Random r=new Random();
        int kitneindex=r.nextInt(length-2)+1;
        System.out.println("Kitne index karne hai ghayab:"+kitneindex);
        
        //kitne index
        ArrayList<Integer> listofnumbers=new ArrayList<>();
        for(int i=0;i<length;i++){
            listofnumbers.add(i);
        }
        
        ////konse index
        for(int i=0;i<kitneindex;i++){
            Random r1=new Random();
            int index=r1.nextInt(listofnumbers.size()-1);
            System.out.println("Selected index ki value is:"+listofnumbers.get(index));
            getIndexes().add(listofnumbers.remove(index));
            
        }
        
        System.out.println(Arrays.toString(listofnumbers.toArray()));
        System.out.println("Index array"+Arrays.toString(getIndexes().toArray()));
    }
    public boolean Wordchecker(char c,char[] origch,char[] naklich){
        System.out.println("CHARACTER:"+c);
        int flag=0;
        for(int i=0;i<getIndexes().size();i++){
            if(c==origch[getIndexes().get(i)]){
                
                naklich[getIndexes().remove(i)]=c;
                flag++;
                break;
            }
                
        }
        
        if(flag==0)
        {
            System.out.println("Wrong character entered");
            numberoftries--;
            noofstars--;
            
            System.out.println("You have "+numberoftries+"tries left");
        }
        if(numberoftries==0){
            System.out.println("\t\t\tGAME OVER");
            System.out.println("stars obtained:0");
            System.exit(0);
            
            
        }
        
        System.out.print("Dashes wali string: ");
        System.out.println(naklich);
        
        
        String naklichstring=new String(naklich);
        if(getOrigstring().equals(naklichstring))
        {
            System.out.println("Riddle is solved");
            wordcount++;level++;
            return true;
        }
        return false;
    }

    
    public char[] getIndexarraywords() {
        for(int i=0;i<getIndexes().size();i++){
            indexarraywords[i]=getOrigch()[getIndexes().get(i)];
        }
        
        System.out.println("indexarraywords:"+Arrays.toString(indexarraywords));
        return indexarraywords;
    }
    

    /**
     * @return the indexes
     */
    public ArrayList<Integer> getIndexes() {
        return indexes;
    }

    /**
     * @return the origstring
     */
    public String getOrigstring() {
        return origstring;
    }

    /**
     * @return the origch
     */
    public char[] getOrigch() {
        return origch;
    }

    
    
}
