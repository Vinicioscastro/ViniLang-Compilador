package ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import strutura.ViniSymbol;
import strutura.ViniSymbolTable;

public class ViniProgram {
	private ViniSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
        private ArrayList<String> varSemAtrib = new ArrayList<String>();
	private String programName;

	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]){\n ");
		str.append("      Scanner _key = new Scanner(System.in);\n");
		for (ViniSymbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
                        varSemAtrib.add(symbol.getName());
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
                        
                        if(command.getCommand().equals("CommandAtribuicao"))
                        {
                            if(varSemAtrib.contains(command.getId()))
                            {
                                varSemAtrib.remove(command.getId());
                            }
                        }
		}
                
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	public ViniSymbolTable getVarTable() {
		return varTable;
	}

	public void setVarTable(ViniSymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
        
        public ArrayList<String> getVarSemUso()
        {
            return this.varSemAtrib;
        }
}
