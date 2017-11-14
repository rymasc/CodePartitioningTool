package IR;

import java.util.ArrayList;

public class Function {

    private ArrayList<Variable> arguments;
    private String returnType;
    private String name;
    private boolean hasArgs;

    public Function(String functionName, String returnType){
        name = functionName;
        this.returnType = returnType;
    }

    public void addArgument(Variable v){
        arguments.add(v);
    }

    public ArrayList<Variable> getArguments() {
        return arguments;
    }

    public String getName(){
        return name;
    }

    public String getReturnType(){
        return returnType;
    }

    public boolean hasArgs() {
        return hasArgs;
    }

    public void hasArgs(boolean bool){
        hasArgs = bool;
    }
}
