package strutura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ViniSymbolTable {
	
	private HashMap<String, ViniSymbol> map;
	
	public ViniSymbolTable() {
		map = new HashMap<String, ViniSymbol>();		
	}

	public void add(ViniSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public ViniSymbol get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<ViniSymbol> getAll(){
		ArrayList<ViniSymbol> lista = new ArrayList<ViniSymbol>();
		for (ViniSymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}	
}
