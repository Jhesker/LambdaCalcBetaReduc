package lambdacalcapp;

import javax.swing.JOptionPane;
import lambdaexpr.LambdaExpr;
import parser.Parser;
import simulator.Simulator;
/**
 *
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
        
        LambdaExpr expr; //Lambda value to be run through parser
        boolean run = true;   //exit loop value
        String term;  //Lambda expression entered by the user
        int again;   // JOptionPane run again value on error
        
        //main loop
        do{ 
            term = JOptionPane.showInputDialog("Please enter the Lambda Expression\n "  //basic initial output
                    + "you would like submit for Beta Reduce.");
            
            if(term != null){
                expr = parser.parseTerm(term);
                expr = sim.betaReduce(expr);
                
                
            }else{
                //error or close value encountered. Ask to continue 
                again = JOptionPane.showConfirmDialog(null, "Would you like to try running another expression?",
                        "No Value Entered",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                
                if(again == JOptionPane.YES_OPTION); //evaluate choice
                else System.exit(0);
            }
        }while(run);
    }
    
}
