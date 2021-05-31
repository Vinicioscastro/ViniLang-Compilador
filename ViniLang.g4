grammar ViniLang; 


@header{
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
        
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private ViniSymbolTable symbolTable = new ViniSymbolTable();
	private ViniSymbol symbol;
	private ViniProgram program = new ViniProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
    private String _exprRepetition;
    private ArrayList<String> VariaveisSemUso;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new ViniException("Simbolo "+id+" nao declarado");
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}

        public StringBuilder exibeVariaveisSemUsoWNG()
            {
                    StringBuilder varWNG = new StringBuilder();

                    varWNG.append("As seguintes variaveis foram declaradas e nao foram utilizadas no programa: ");
                    ArrayList<String> var = program.getVarSemUso();

                    if(var.isEmpty())return null;

                    int size = var.size();
                    if(size ==1)varWNG.append(var.get(0));

                    else if(size>1)
                    {
                         int i=0;
                         for(;i<=size-2;i++)
                         {
                             String w = var.get(i);
                             varWNG.append(w);
                             varWNG.append(",");
                         }
                         varWNG.append(var.get(size-1));
                    }

                return varWNG;
            }

        public void Warnings()
            {
                StringBuilder warn = new StringBuilder();
                StringBuilder var = exibeVariaveisSemUsoWNG();
                if(var==null)return;
                warn.append("WARNINGS: \n");
                warn.append(exibeVariaveisSemUsoWNG());
                System.out.println(warn);
            }
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' decl bloco  'fimprog.'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           } 
		;
		
decl    :  (declaravar)+
        ;
        
            
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new ViniVariavel(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new ViniException("Simbolo "+_varName+" ja foi declarado anteriormente");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new ViniVariavel(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new ViniException("Simbolo "+_varName+"ja foi declarado anteriormente");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = ViniVariavel.NUMBER;  }
           | 'texto'  { _tipo = ViniVariavel.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao  
                |  cmdenquanto
		;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	ViniVariavel var = (ViniVariavel)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID {
                 verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
                    if (_exprContent =="")
                    {
                       throw new ViniException("Variavel "+_exprID+" Não foi atribuida");
                    }
                    else{
                           CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
                           stack.peek().add(cmd);
                    }
               	
               }
			;
			
cmdenquanto :  'enquanto'
                    AP
                    ID{_exprRepetition = _input.LT(-1).getText(); }
                    OPREL { _exprRepetition += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprRepetition += _input.LT(-1).getText(); }
                    FP
                    ACH
                    {
                      curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                       CommandRepeticao cmd = new CommandRepeticao(_exprRepetition, listaTrue);
                   		stack.peek().add(cmd);
                    } 
                    ;
                    
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;
			
expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              (NUMBER | TEXTO)//Incluido TEXTO
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: '.'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : ':='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
TEXTO	: ['"']([a-z] | [A-Z] | [0-9] | ' ')*['"']
	;


WS	: (' ' | '\t' | '\n' | '\r') -> skip;