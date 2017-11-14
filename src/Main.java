import IR.ProgramInfo;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start CPT");
        String filename;
        if(args[0] == null){
            return;
        }
        try{
            filename = args[0];
            ProgramInfo programInfo = ProgramInfo.getInstance();
            String s = filename.replace("src\\","" );
            programInfo.setProgramName(s.replace(".c", ""));
            CharStream in = CharStreams.fromPath(Paths.get(filename));
            Translator translator = new Translator(in);
            translator.translate();

        } catch (IOException e){
            System.out.println("The file " + e.getMessage() +" does not exist");
        }


    }
}
