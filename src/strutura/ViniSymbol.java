package strutura;


public abstract class ViniSymbol {
	
	protected String name;
	
	public abstract String generateJavaCode();
	public ViniSymbol(String name) {
		this.name = name;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ViniSymbol [name=" + name + "]";
	}	
}
