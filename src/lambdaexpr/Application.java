package lambdaexpr;



/**
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
        if(operand1.equals(var)){
            this.operand1 = value;
        }
        if(operand2.equals(var)){
            this.operand2 = value;
        }
        //add handiling of the abstraction type.
        if(operand2.type() == ExprKind.APPLICATION){
            operand2.substitute(var, value);
        }
        
        if(operand1.type() == ExprKind.ABSTRACTION){
            Abstraction op1 = (Abstraction) operand1;
            return op1.substitute(op1.getBoundVar(), operand2);
        }
        return this;
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
        return " " + operand1.toString() + " " + operand2.toString();
    }
    
}
