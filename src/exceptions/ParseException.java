package exceptions;

import lambdaexpr.ExprKind;

/**
 * @author jhesker
 */
public class ParseException extends Exception{
     public ParseException(ExprKind type, int lineNo) {
        this("Expecting " + type + " at " + lineNo);
    }
    public ParseException(String msg){
        super(msg);
    }
}
