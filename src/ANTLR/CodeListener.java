package ANTLR;

import IR.Function;
import IR.ProgramInfo;
import IR.Variable;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

public class CodeListener extends CBaseListener {

    public TokenStreamRewriter rewriter;

    public CodeListener(TokenStream tokenStream){
        rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        programInfo.currentlyReadingFunction = false;
    }

    @Override
    public void enterParameterDeclaration(CParser.ParameterDeclarationContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        Function currentFunction = programInfo.currentFunction;
        String type = ctx.getChild(0).getText();
        String name = ctx.getChild(1).getText();
        Variable parameter = new Variable(type, name);
        currentFunction.addParameter(parameter);
        //System.out.println(currentFunction.getName() + " has " + currentFunction.getParameters().size() + " parameters");
        programInfo.updateFunction(currentFunction);
    }

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();

        String type = ctx.getChild(0).getText();
        ParseTree functionTree = ctx.getChild(1).getChild(0);
        int sizeOfFunTree = functionTree.getChildCount();
        String functionName = functionTree.getChild(0).getText();
        Function function = new Function(functionName, type);
        programInfo.currentlyReadingFunction = true;
        programInfo.currentFunction = function;
        if(sizeOfFunTree < 4){
            function.hasArgs(false);
        } else{
            function.hasArgs(true);
        }
        programInfo.addFunction(function);
    }

}
