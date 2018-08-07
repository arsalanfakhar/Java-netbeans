/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesstheword.gui;

/**
 *
 * @author Arsalan Fakhar
 */
public abstract class loadclass {
    
    public static void main(String[] args) {
        loadingscreen ss=new loadingscreen();
        ss.setVisible(true);
        try{
            for(int i=0;i<=100;i++){
                Thread.sleep(35);
                ss.percentlbl.setText(Integer.toString(i)+"%");
                if(i==100){
                    ss.dispose();
                    filingpanel fp=new filingpanel();
                    fp.setVisible(true);
                }
            }
        }
        catch(Exception e){
        
        }
    }
    
    
}
