package parser;

import exceptions.ParseException;
import lambdaexpr.*;
/**
 * @author jhesker
 */
public class Parser {
    public LambdaExpr parse(String term){
        
        return null; // TO CHANGE
    }
    /**
     * 
     * @param term
     * @return
     * @throws ParseException 
     */
    private Abstraction parseAbstraction(String term) throws ParseException{
        
        return null; //TO CHANGE
    }
    /**
     * 
     * @param term
     * @return
     * @throws ParseException 
     */
    private Application parseApplication(String term)throws ParseException{
        return null; // TO CHANGE
    }
    /**
     * 
     * @param term
     * @return
     * @throws ParseException 
     */
    private Variable parseVariable(String term)throws ParseException{
        return null; // TO CHANGE
    }
    /**
     * Takes in substring of original term starting with the char after the ( 
     * it is matching
     * "(x z y)" is sent to method as "x y z)"
     * @param term
     * @return the integer of the char position of balanced parenthesis
     * @throws ParseException 
     */
    private int findBalancedRightParenPos(String term)throws ParseException{
        char currChar;
        int parenToClose = 0; // used in the testing 
        boolean found = false;
        
        for(int i = 0; i < term.length(); i++){
            currChar = term.charAt(i);
            if(currChar == '(') parenToClose += 1;
            if(currChar == ')' && parenToClose != 0 ) parenToClose -= 1;
            if(currChar == ')' && parenToClose == 0 ){
                found = true; // used in test for debugging
                return i;
            }
            
        }
        
        if(found != true) System.out.println("ERROR: No matching paren for " + term); // testing output
        return 0; // TO CHANGE
    }
}
