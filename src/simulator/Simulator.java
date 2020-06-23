package simulator;

import exceptions.DivergentException;
import lambdaexpr.Abstraction;
import lambdaexpr.Application;
import lambdaexpr.LambdaExpr;
import lambdaexpr.ExprKind;

/**
 * @author jhesker
 */
public class Simulator {
    LambdaExpr expr2;
    public LambdaExpr betaReduce(LambdaExpr expr) throws DivergentException{
        
        switch (expr.type()) {
            case APPLICATION:
                
                Application app;
                app = (Application) expr;
                System.out.println(app.toString());
                if(app.getOperand1().type() == ExprKind.ABSTRACTION){
                    Abstraction abs = (Abstraction)app.getOperand1();
                    expr2 = abs.substitute(abs.getBoundVar(), app.getOperand2());
                }   break;
            case ABSTRACTION:
                Abstraction abs = (Abstraction) expr;
                expr2 = expr.substitute(abs.getBoundVar(), abs.getBody());
                
            default:
                expr2 = expr;
        }
        if(expr.equals(expr2)){
            return expr;
        }
        return expr;
    }
}
