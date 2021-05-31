// Generated from ViniLang.g4 by ANTLR 4.9.2
package analisador;

	import strutura.ViniSymbol;
	import strutura.ViniVariavel;
	import strutura.ViniSymbolTable;
	import execoes.ViniException;
	import ast.ViniProgram;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandDecisao;
    import ast.CommandRepeticao;
	import java.util.ArrayList;
	import java.util.Stack;
        

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ViniLangParser}.
 */
public interface ViniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ViniLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ViniLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ViniLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ViniLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(ViniLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(ViniLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(ViniLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(ViniLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(ViniLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(ViniLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(ViniLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(ViniLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(ViniLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(ViniLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(ViniLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(ViniLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(ViniLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(ViniLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(ViniLangParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(ViniLangParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(ViniLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(ViniLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ViniLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ViniLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(ViniLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(ViniLangParser.TermoContext ctx);
}