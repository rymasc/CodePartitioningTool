package IR;

import java.util.ArrayList;

public class FunctionCall {
    private Variable returnVariable;
    private ArrayList<Variable> arguments;
    private Function functionDefinition;

    public FunctionCall(Function function){
        functionDefinition = function;
    }

}
