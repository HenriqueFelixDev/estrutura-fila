package main;

public class Queue<T>{
	
	/* Armazena os elementos presentes na fila
	 * Seu tipo será definido no momento da criação 
	 * da instância da classe 						*/
	private T[] queueElements;
	
	/* Armazena o tamanho atual da fila 
	 * (índice do último elemento adicionado +1)		*/
	private int queueSize;
	
	// Construtor da classe Fila inicializando as variáveis
	@SuppressWarnings("unchecked")
	public Queue(int queueMaxSize) {
		queueElements = (T[]) new Object[queueMaxSize];
		queueSize = 0;
	}
	
	// Insere um novo elemento na fila
	public void add(T element) {
		queueElements[queueSize++] = element;
	}
	
	// Remove o primeiro elemento da fila e o retorna
	public T remove() {
		
		T removedElement = queueElements[0];
		
		/* Verificação para evitar a tentativa de remover
		 * um elemento em uma fila vazia 					*/
		if(!this.empty()) {
			
			for(int i = 0; i < queueSize - 1; i++) {
				queueElements[i] = queueElements[i+1];
			}
			
			queueElements[--queueSize] = null;
		}
		
		return removedElement;
	}
	
	// Retorna o primeiro elemento da fila, mas sem removê-lo
	public T front() {
		return queueElements[0];
	}
	
	// Retorna o tamanho atual da fila
	public int size() {
		return queueSize;
	}
	
	// Retorna se a fila está vazia
	public boolean empty() {
		return queueSize <= 0;
	}
	
	/* Retorna uma String contendo todos os elementos da fila,
	 * listados na ordem em que estão na fila 					*/
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
		System.out.println("A fila está vazia? " + fila.empty());
		System.out.println(fila.remove());
		fila.add("João");
		fila.add("Pedro");
		fila.add("Maria");
		System.out.println("Pessoa removida: " + fila.remove());
		System.out.println("Próximo da Fila: " + fila.front());
		System.out.println("A fila está vazia? " + fila.empty());
		System.out.println("O tamanho da fila é " + fila.size());
		System.out.println(fila.toString());
	}
}