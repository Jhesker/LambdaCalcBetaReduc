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
        // instantiate Abstraction
        Abstraction abs = new Abstraction();
        
        // catching all Parse Errors:
        if(term.charAt(0) != '(') 
            throw new ParseException(abs.type(),term.charAt(0),'(');
        if(term.charAt(1) != 'L') 
            throw new ParseException(abs.type(),term.charAt(1),'L'); 
        if(term.charAt(2) != '.') 
            throw new ParseException(abs.type(),term.charAt(2),'.');
        if(term.charAt(4) != ' ') 
            throw new ParseException(abs.type(),term.charAt(4),' ');
        
        //setting the variables for Abstraction
        abs.setBoundVar(parseVariable(term.substring(3, 4)));
        abs.setBody(parse(term.substring(5, term.length() - 1)));
        
        return abs; //TO CHANGE
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
        
        //catching errors in the parsing of the variable
        if(term.length() != 1) 
            throw new ParseException("There are too many characters in the String " + term + " this is not a variable");
        if(term.charAt(0) == '(' || term.charAt(0) == ')' || term.charAt(0) == '.' || term.charAt(0) == 'L')
            throw new ParseException(term.charAt(0) + " is not a valid variable");
        
        //instantiating the new variable
        Variable var = new Variable(term.charAt(0));
        
        return var;
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
