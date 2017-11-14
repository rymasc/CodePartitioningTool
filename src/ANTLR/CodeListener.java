package ANTLR;

import IR.Function;
import IR.ProgramInfo;
import IR.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

public class CodeListener extends CBaseListener {

    public TokenStreamRewriter rewriter;

    public CodeListener(TokenStream tokenStream){
        rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();

        String type = ctx.getChild(0).getText();
        ParseTree functionTree = ctx.getChild(1).getChild(0);
        int sizeOfFunTree = functionTree.getChildCount();
        String functionName = functionTree.getChild(0).getText();
        System.out.println(functionName + "()");
        Function function = new Function(functionName, type);

        if(sizeOfFunTree < 4){
            function.hasArgs(false);
        } else{
            
            ParseTree parameterTree = functionTree.getChild(2).getChild(0);
            int parameterCount = parameterTree.getChildCount();
            ArrayList<ParseTree> parameters = new ArrayList<>();

            for (int i=0; i<parameterCount;i++){
               if(i%2 == 0){
                   parameters.add(parameterTree.getChild(i));
               }
            }

        }

        programInfo.addFunction(function);
        System.out.println("\n ----------- \n");
    }
}
