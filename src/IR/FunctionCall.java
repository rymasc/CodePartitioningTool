package IR;

import java.util.ArrayList;

public class FunctionCall {
    private boolean hasArgs;
    private Variable returnVariable;
    private ArrayList<Variable> arguments;
    private Function functionDefinition;

    public FunctionCall(Function function){
        functionDefinition = function;
        hasArgs = functionDefinition.hasArgs();
    }

}
