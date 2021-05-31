// Generated from ViniLang.g4 by ANTLR 4.4

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
        

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ViniLangParser}.
 */
public interface ViniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(@NotNull ViniLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(@NotNull ViniLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull ViniLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull ViniLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull ViniLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull ViniLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(@NotNull ViniLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(@NotNull ViniLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(@NotNull ViniLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(@NotNull ViniLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(@NotNull ViniLangParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(@NotNull ViniLangParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(@NotNull ViniLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(@NotNull ViniLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull ViniLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull ViniLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(@NotNull ViniLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(@NotNull ViniLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull ViniLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull ViniLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(@NotNull ViniLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(@NotNull ViniLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(@NotNull ViniLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(@NotNull ViniLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ViniLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(@NotNull ViniLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ViniLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(@NotNull ViniLangParser.CmdleituraContext ctx);
}