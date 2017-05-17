package com.example.prashant.calculator;

import org.javia.arity.Symbol;
import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

/**
 * Created by prashant on 15/5/17.
 */

public class Calculation {

    private final Symbols symbols;
    private CalcResult calculationResult;
    private static String currentExp;

    interface CalcResult{
        void onExpressionChange(String result,boolean successful);
    }

    public Calculation(){
        symbols = new Symbols();
    }

    public void setCalculationResultListener(CalcResult calculationResult){

        this.calculationResult = calculationResult;
        currentExp = "";

    }
    /**
     * Delete a single character from currentExpression,unless its empty
     * ** - Invalid
     * 543 - valid
     * 45*65 - valid
     */
    public void deleteCharacter(){
        if(currentExp.length()>0){
            currentExp = currentExp.substring(0,currentExp.length()-1);
        }
        else{
            calculationResult.onExpressionChange("Invalid Input",false);
        }

    }

    /**
     * Delete entire expression unless empty
     *  **- invalid
     */
    public void deleteExpression(){

        if(currentExp.equals("")){
            calculationResult.onExpressionChange("Invalid Input",false);
        }
        currentExp = "";
        calculationResult.onExpressionChange(currentExp,true);

    }

    /**
     * Append number to currentExpression if it is valid
     * "0" & number = 0 -- invalid
     * "1234569874452123" -- invalid
     * @param number
     */
    public void appendNumber(String number){
        if(currentExp.startsWith("0")&&number.equals("0")){
            calculationResult.onExpressionChange("Invalid Input",false);
        }
        else{
            if(currentExp.length()<=16){
                calculationResult.onExpressionChange(currentExp,true);
            }
            else{
                calculationResult.onExpressionChange("Expression is too long",false);
            }
        }

    }

    /**
     * 56 - valid
     * 56 + 2- valid
     * 56* -invalid
     * ** - invalid
     * @param operator one of:
     *                 -"+"
     *                 -"/"
     *                 -"-"
     *                 -"*"
     */

    public void appendOperator(String operator){
        if(validateExp(currentExp)){
            currentExp+=operator;
        }
    }
    public void appendDecimal(){
        if(currentExp.equals("")){
            currentExp = "0.";
        }
        else {
            if (validateExp(currentExp)) {
                currentExp += ".";
                calculationResult.onExpressionChange(currentExp, true);
            }
        }

    }

    /**
     *  if currentExpression passes checks,pass currentExpression to symbols object.
     */
    public void performEvaluation(){
        if(validateExp(currentExp)){
            try {
                Double result = symbols.eval(currentExp);
                currentExp = Double.toString(result);
                calculationResult.onExpressionChange(currentExp,true);
            }catch (SyntaxException e) {
                calculationResult.onExpressionChange("Invalid Input",false);
                e.printStackTrace();
            }
        }

    }

    /**
     * Helper function to validate expressions against the following checks:
     *
     * @param expression
     * @return
     */

    public boolean validateExp(String expression){
        if(expression.endsWith("*")||
                expression.endsWith("+")||
                expression.endsWith("-")||
                expression.endsWith("/")){
            calculationResult.onExpressionChange("Invalid Input",false);
            return false;
        }
        else if(expression.equals("")){
            calculationResult.onExpressionChange("Invalid Input",false);
            return false;
        }
        else if(expression.length()>16){
            calculationResult.onExpressionChange("Invalid Input",false);
            return false;
        }
        else{
            return true;
        }
    }

}