package ANTLR;

import IR.Function;
import IR.ProgramInfo;
import IR.Variable;
import org.antlr.v4.codegen.model.decl.Decl;
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
    public void enterDeclarator(CParser.DeclaratorContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        if(programInfo.currentlyReadingFunction){
            System.out.println("Declarator: " + ctx.getText());
            System.out.println(ctx.getParent().getText());
        }
    }

    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        if(programInfo.currentlyReadingFunction){
            System.out.println("Compound Statement: " + ctx.getText());
        }
    }

    @Override
    public void enterDeclarationList(CParser.DeclarationListContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        if(programInfo.currentlyReadingFunction){
            System.out.println("DeclarationList: " + ctx.getText());
        }
    }

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        ProgramInfo programInfo = ProgramInfo.getInstance();
        programInfo.currentlyReadingFunction = false;
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
        if(sizeOfFunTree < 4){
            function.hasArgs(false);
        } else{
            function.hasArgs(true);
        }
        programInfo.addFunction(function);
    }
}
