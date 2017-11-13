package IR;

import java.util.ArrayList;

public class ProgramInfo {

    ArrayList<Variable> variables = new ArrayList<>();
    ArrayList<Function> functions = new ArrayList<>();
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

}
