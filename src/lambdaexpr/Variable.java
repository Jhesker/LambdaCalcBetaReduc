package lambdaexpr;

/**
 * @author jhesker
 */
public class Variable implements LambdaExpr {
    
    
    private char name;
    
    //Constructor
    public Variable(char name) {
        this.name = name;
    }
    
    //getter for name
    public char getName() {
        return name;
    }
    
    //LambdaExpr implementation methods
    
    @Override
    public LambdaExpr copy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExprKind type() {
       return ExprKind.VARIABLE;
    }
    
    
    //Override Statements
    
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
