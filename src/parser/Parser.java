package parser;

import exceptions.ParseException;
import lambdaexpr.*;
/**
 * @author jhesker
 */
public class Parser {
    public LambdaExpr parse(String term) throws ParseException{
        int endPos;
        if(term.length() == 1) return parseVariable(term); // if it is only one char it is a variable parse variable
        
        if(term.charAt(0) == '('){  //if it starts with a '(' it can be any of the 3
            endPos = findBalancedRightParenPos(term.substring(1));
            
            if(endPos == term.length() - 1){  // balanced right paren is end of statement can be either a var or abs
                // 2nd char is 'L' then this must be a abs
                if(term.charAt(1) == 'L') return parseAbstraction(term);
                else return parseVariable(term.substring(1, endPos)); // not abs then must be a variable
            }else return parseApplication(term); //other two eliminated it must be application   
        }
        return null; //return here means the entered value was not a properly formatted Lambda Expr
    }
    /**
     * parsing of abstractions send the set bound variable to variable parser
     * also sends the body of the abstraction to be further parsed in main 
     * parser
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
     * @return Application
     * @throws ParseException 
     */
    private Application parseApplication(String term)throws ParseException{
        
        //instantiate the Application
        Application app = new Application();
        int startPos = 0;
        int endPos = 0;
        
        if(term.charAt(0) != '('){
            throw new ParseException(app.type(), term.charAt(0), '(');
        }
        endPos = findBalancedRightParenPos(term.substring(startPos + 1));
        app.setOperand1(parse(term.substring(startPos, endPos)));
        
        startPos = endPos + 1;
        app.setOperand2(parse(term.substring(startPos, term.length()-1)));

        return app;
    }
    /**
     * This handles the parsing of variables 
     * @param term
     * @return variable
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
                return i + 1;
            }
        }
        if(found != true)
            throw new ParseException("ERROR: No matching paren for " + term);
        return 0;
    }
}
