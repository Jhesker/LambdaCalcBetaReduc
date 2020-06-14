package lambdacalcapp;

import exceptions.DivergentException;
import exceptions.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lambdaexpr.LambdaExpr;
import parser.Parser;
import simulator.Simulator;
/**
 * @author jhesker
 */
public class LambdaCalcApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instantiating Main Objects
        Parser parser = new Parser();
        Simulator sim = new Simulator();
        
        LambdaExpr expr = null; //Lambda value to be run through parser
        boolean run = true;   //exit loop value
        String term = null;  //Lambda expression entered by the user
        int again;   // JOptionPane run again value on error
        
        //main loop
        do{ 
            term = JOptionPane.showInputDialog("Please enter the Lambda Expression\n "  //basic initial output
                    + "you would like submit for Beta Reduce.");
            
            if(term != null){
                
                try {
                    expr = parser.parse(term);
                } catch (ParseException ex) {
                    Logger.getLogger(LambdaCalcApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    expr = sim.betaReduce(expr);
                } catch (DivergentException ex) {
                    Logger.getLogger(LambdaCalcApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //display output beta reduction
                again = JOptionPane.showConfirmDialog(null,
                        expr +
                        "\nWould you like to run Another?",
                        "Beta Reduction:",
                        JOptionPane.YES_NO_OPTION);
                if(again == JOptionPane.YES_OPTION);  //evaluate choice
                else run = false;
                
            }else{
                //error or close value encountered. Ask to continue 
                again = JOptionPane.showConfirmDialog(null, "Would you like to try running another expression?",
                        "No Value Entered",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                
                if(again == JOptionPane.YES_OPTION); //evaluate choice
                else run = false; 
                
            }
        }while(run);
    }
    
}
