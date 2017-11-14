package IR;

import java.util.ArrayList;

public class ProgramInfo {

    private ArrayList<Variable> variables = new ArrayList<>();
    private ArrayList<Function> functions = new ArrayList<>();
    private static ProgramInfo instance = null;
    private String programName;


    private ProgramInfo(){
        programName = "";
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

    public String getProgramName() {
        return programName;
    }

    public void addGlobalVar(Variable v){
        variables.add(v);
    }

    public void addFunction(Function f){
        functions.add(f);
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }
}
