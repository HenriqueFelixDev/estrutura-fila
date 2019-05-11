package main;

public class Queue<T>{
	
	/* Armazena os elementos presentes na fila
	 * Seu tipo ser� definido no momento da cria��o 
	 * da inst�ncia da classe 						*/
	T[] queueElements;
	
	/* Armazena o tamnho atual da fila 
	 * (indice do �ltimo elemento adicionado +1)		*/
	int queueSize;
	
	// Construtor da classe Fila inicializando as vari�veis
	@SuppressWarnings("unchecked")
	public Queue(int queueMaxSize) {
		queueElements = (T[]) new Object[queueMaxSize];
		queueSize = 0;
	}
	
	// Insere um novo elemento na fila
	public void add(T elemento) {
		queueElements[queueSize++] = elemento;
	}
	
	// Remove o primeiro elemento da fila e o retorna
	public T remove() {
		
		T objetoRemovido = queueElements[0];
		
		/* Verifica��o para evitar a tentativa de remover
		 * um elemento em uma fila vazia 					*/
		if(!this.empty()) {
			
			for(int i = 0; i < queueSize - 1; i++) {
				queueElements[i] = queueElements[i+1];
			}
			
			queueElements[--queueSize] = null;
		}
		
		return objetoRemovido;
	}
	
	// Retorna o primeiro elemento da fila, mas sem remov�-lo
	public T front() {
		return queueElements[0];
	}
	
	// Retorna o tamanho atual da fila
	public int size() {
		return queueSize;
	}
	
	// Retorna se a fila est� vazia
	public boolean empty() {
		return queueSize <= 0;
	}
	
	/* Retorna uma String contendo todos os elementos da fila,
	 * listados na ordem em que est�o na fila 					*/
	@Override
	public String toString() {
		String elements = "[";
		
		for(int i = 0; i < queueSize; i++) {
			elements += queueElements[i];
			
			if(i != queueSize - 1) elements += ", ";
		}
		
		elements += "]";
		
		return elements;
	}
	
	// Teste do funcionamento da fila
	public static void main(String[] args) {
		Queue<String> fila = new Queue<String>(10);
		System.out.println("Fila est� vazia? " + fila.empty());
		System.out.println(fila.remove());
		fila.add("Jo�o");
		fila.add("Pedro");
		fila.add("Maria");
		System.out.println("Pessoa removida: " + fila.remove());
		System.out.println("Pr�ximo da Fila: " + fila.front());
		System.out.println("Fila est� vazia? " + fila.empty());
		System.out.println("O tamanho da fila � " + fila.size());
		System.out.println(fila.toString());
	}
}