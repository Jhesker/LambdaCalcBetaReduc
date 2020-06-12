/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpr;

/**
 *
 * @author jhesker
 */
public interface LambdaExpr {
    
    public LambdaExpr copy();
    public LambdaExpr substitute(Variable var, LambdaExpr value);
    public ExprKind type();
    
    
}
