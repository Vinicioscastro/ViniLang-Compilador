package ast;

import strutura.ViniVariavel;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private ViniVariavel var;
	
	public CommandLeitura (String id, ViniVariavel var) {
		this.id = id;
		this.var = var;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id +"= _key." + (var.getType()==ViniVariavel.NUMBER? "nextDouble();": "nextLine();");
	}
	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
        @Override
        public String getId()
        {
            return "";
        }
        @Override
        public String getCommand()
        {
            return this.getClass().getName();
        }

}
