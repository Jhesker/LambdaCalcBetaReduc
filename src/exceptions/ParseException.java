package exceptions;

import lambdaexpr.ExprKind;

/**
 * @author jhesker
 */
public class ParseException extends Exception{
     public ParseException(ExprKind type, char found, char charExp ) {
        this(type + "Expects a "  + charExp + " at " + found);
    }
    public ParseException(String msg){
        super(msg);
    }
}
