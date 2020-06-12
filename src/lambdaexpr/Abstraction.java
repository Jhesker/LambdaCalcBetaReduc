package lambdaexpr;

/**
 *
 * @author jhesker
 */
public class Abstraction implements LambdaExpr{
    
    private Variable boundVar;
    private LambdaExpr body;
    
    
    //contructor
    public Abstraction() {
    }

    
    //Getters and setters
    public Variable getBoundVar() {
        return boundVar;
    }

    public void setBoundVar(Variable boundVar) {
        this.boundVar = boundVar;
    }

    public LambdaExpr getBody() {
        return body;
    }

    public void setBody(LambdaExpr body) {
        this.body = body;
    }
    
    
    
    //LambdaExpr implimentation methods

    /**
     *
     * @return
     */
    
    @Override
    public LambdaExpr copy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param var
     * @param value
     * @return
     */
    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return ABSTRACTION
     */
    @Override
    public ExprKind type() {
        return ExprKind.ABSTRACTION;
    }
    
        /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        return false; //To Change 
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode(){
        return 0; //To Change
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return ""; // To Change
    }
    
}
