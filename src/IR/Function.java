package IR;

import java.util.ArrayList;

public class Function {

    private ArrayList<Variable> parameters;
    private String returnType;
    private String name;
    private boolean hasArgs;
    private String sourceCode;

    public Function(String functionName, String returnType, String code){
        name = functionName;
        this.returnType = returnType;
        parameters = new ArrayList<>();
        sourceCode = code;
    }

    public void addParameter(Variable v){ parameters.add(v);}

    public ArrayList<Variable> getParameters() { return parameters; }

    public String getName() { return name; }

    public String getReturnType() { return returnType; }

    public boolean hasArgs() { return hasArgs; }

    public void hasArgs(boolean bool) { hasArgs = bool; }
}
