package metodoMain;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import analisador.ViniLangLexer;
import analisador.ViniLangParser;
import execoes.ViniException;


public class MainClass {
	public static void main(String[] args) {
		try {
			ViniLangLexer lexer;
			ViniLangParser parser;

			lexer = new ViniLangLexer(CharStreams.fromFileName("input.vini"));
						
                        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			
			parser = new ViniLangParser(tokenStream);
			
			parser.prog();
			System.out.println("Compilation Successful");
			
			parser.exibeComandos();                      
			parser.generateCode();
                        parser.Warnings();
			
		}
		catch(ViniException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("ERROR "+ex.getMessage());
		}
		
	}

}
