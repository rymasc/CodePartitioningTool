package ANTLR;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class CodeListener extends CBaseListener {

    public TokenStreamRewriter rewriter;

    public CodeListener(TokenStream tokenStream){
        rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        System.out.println("found a function def");
        System.out.println(ctx.getText());
        System.out.println(ctx.getChildCount());
        System.out.println(ctx.getChild(0).toStringTree());
    }
}
