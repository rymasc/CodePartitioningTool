package IR;

import java.util.ArrayList;

public class ProgramInfo {

    private ArrayList<Variable> variables;
    private ArrayList<Function> functions;
    private ArrayList<FunctionCall> functionCalls;
    private static ProgramInfo instance = null;
    private String programName;
    public Boolean currentlyReadingFunction;
    public Function currentFunction;

    private ProgramInfo(){
        programName = "";
        currentlyReadingFunction = false;
        variables = new ArrayList<>();
        functions = new ArrayList<>();
        functionCalls = new ArrayList<>();
    }

    public static ProgramInfo getInstance(){
        if (instance == null){
            instance = new ProgramInfo();
        }

        return instance;
    }

    public void setProgramName(String name){
        programName = name;
    }

    public String getProgramName() { return programName; }

    public void addGlobalVar(Variable v) { variables.add(v); }

    public void addFunction(Function f) { functions.add(f); }

    public void updateFunction(Function function){
        for (Function f:functions) {
            if(function.getName().equals(f.getName())){
                f = function;
            }
        }
    }

    public ArrayList<Function> getFunctions() { return functions; }

    public ArrayList<Variable> getVariables() { return variables; }
}
