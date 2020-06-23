package lambdaexpr;

import exceptions.DivergentException;
import java.util.logging.Level;
import java.util.logging.Logger;
import simulator.Simulator;

/**
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
        Abstraction abs = new Abstraction();
        abs.setBody(body);
        abs.setBoundVar(boundVar);
        return abs;
    }

    /**
     *
     * @param var
     * @param value
     * @return
     */
    @Override
    public LambdaExpr substitute(Variable var, LambdaExpr value) {
        if(body.type() == ExprKind.VARIABLE){
            if(body.equals(var)){
                if(value.type() == ExprKind.APPLICATION){
                   Simulator sim = new Simulator();
                    try {
                        return sim.betaReduce(value);
                    } catch (DivergentException ex) {
                        Logger.getLogger(Abstraction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    return value;
               
                }
                
            }else return body;  
        }
        if(body.type() == ExprKind.APPLICATION){
            return body.substitute(var, value);    
        }
        if(body.type() == ExprKind.ABSTRACTION){
            return value;
        }
        return value;
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
       Abstraction obj2 = (Abstraction) obj;
        return obj2.body == body && obj2.boundVar == boundVar;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode(){
        return 0; //To Change
    }

    @Override
    public String toString(){
        return "(L" + boundVar.toString() + ". " + body.toString() + ")";
    }
    
}
