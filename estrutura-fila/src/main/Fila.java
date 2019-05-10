package main;

public class Fila<T>{
	
	/* Armazena os elementos presentes na fila
	 * Seu tipo será definido no momento da criação 
	 * da instância da classe 						*/
	T[] pessoasNaFila;
	
	/* Armazena o tamnho atual da fila 
	 * (indice do último elemento adicionado +1)		*/
	int tamanhoFila;
	
	// Construtor da classe Fila inicializando as variáveis
	@SuppressWarnings("unchecked")
	public Fila(int tamanhoMaximo) {
		pessoasNaFila = (T[]) new Object[tamanhoMaximo];
		tamanhoFila = 0;
	}
	
	// Insere um novo elemento na fila
	public void add(T elemento) {
		pessoasNaFila[tamanhoFila++] = elemento;
	}
	
	// Remove o primeiro elemento da fila e o retorna
	public T remove() {
		
		T objetoRemovido = pessoasNaFila[0];
		
		/* Verificação para evitar a tentativa de remover
		 * um elemento em uma fila vazia 					*/
		if(!this.empty()) {
			
			for(int i = 0; i < tamanhoFila - 1; i++) {
				pessoasNaFila[i] = pessoasNaFila[i+1];
			}
			
			pessoasNaFila[--tamanhoFila] = null;
		}
		
		return objetoRemovido;
	}
	
	// Retorna o primeiro elemento da fila, mas sem removê-lo
	public T front() {
		return pessoasNaFila[0];
	}
	
	// Retorna o tamanho atual da fila
	public int size() {
		return tamanhoFila;
	}
	
	// Retorna se a fila está vazia
	public boolean empty() {
		return tamanhoFila <= 0;
	}
	
	/* Retorna uma String contendo todos os elementos da fila,
	 * listados na ordem em que estão na fila 					*/
	@Override
	public String toString() {
		String lista = "[";
		
		for(int i = 0; i < tamanhoFila; i++) {
			lista += pessoasNaFila[i];
			
			if(i != tamanhoFila - 1) lista += ", ";
		}
		
		lista += "]";
		
		return lista;
	}
	
	// Teste do funcionamento da fila
	public static void main(String[] args) {
		Fila<String> fila = new Fila<String>(10);
		System.out.println("Fila está vazia? " + fila.empty());
		System.out.println(fila.remove());
		fila.add("João");
		fila.add("Pedro");
		fila.add("Maria");
		System.out.println("Pessoa removida: " + fila.remove());
		System.out.println("Próximo da Fila: " + fila.front());
		System.out.println("Fila está vazia? " + fila.empty());
		System.out.println("O tamanho da fila é " + fila.size());
		System.out.println(fila.toString());
	}
}