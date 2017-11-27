package IR;

import java.util.ArrayList;

public class FunctionCall {
    private Variable returnVariable;
    private ArrayList<Variable> arguments;
    String functionName;
    public Position position;
    private int lineNumber;
    private int charNumber;

    public FunctionCall(String name){
        functionName = name;
    }

    public void setArguments(ArrayList<Variable> arguments) {
        this.arguments = arguments;
    }

    public void setPosition(int linePosition, int charPosition){
        lineNumber = linePosition;
        charNumber = charPosition;
        position = new Position(lineNumber, charNumber);
    }

    public boolean isSameFunctionCall(int linePosition, int charPosition){
        if(linePosition != lineNumber || charPosition != charNumber){
            return false;
        } else {
            return true;
        }
    }
}
