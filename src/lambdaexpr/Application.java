package lambdaexpr;
import lambdaexpr.*;

/**
 *
 * @author jhesker
 */
public class Application implements LambdaExpr{
    private LambdaExpr operand1;
    private LambdaExpr operand2;


    //constructor
    public Application() {
    }
    //getters and setters for application 
    public LambdaExpr getOperand1() {
        return operand1;
    }

    public void setOperand1(LambdaExpr operand1) {
        this.operand1 = operand1;
    }

    public LambdaExpr getOperand2() {
        return operand2;
    }

    public void setOperand2(LambdaExpr operand2) {
        this.operand2 = operand2;
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
     * @return APPLICATION
     */
    @Override
    public ExprKind type() {
        return ExprKind.APPLICATION;
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
