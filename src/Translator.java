import ANTLR.CLexer;
import ANTLR.CParser;
import ANTLR.CodeListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Translator {

    private CharStream input;
    private TokenStream tokens;
    private ParseTree parseTree;
    private ParseTreeWalker walker;
    private String parsedCode;


    public Translator(CharStream inputStream){
        input = inputStream;
        CLexer lexer = new CLexer(input);
        tokens = new CommonTokenStream(lexer);
        CParser parser = new CParser(tokens);
        parseTree = parser.compilationUnit();

    }

    public void translate(){
        walker = new ParseTreeWalker();
        CodeListener listener = new CodeListener(tokens);
        walker.walk(listener, parseTree);
        parsedCode = listener.rewriter.getText();
    }
}
