package main;

public class Fila<T> {
	
	T[] pessoasNaFila;
	int tamanhoFila;
	
	@SuppressWarnings("unchecked")
	public Fila(int tamanhoMaximo) {
		pessoasNaFila = (T[]) new Object[tamanhoMaximo];
		tamanhoFila = 0;
	}
	
	public void add(T elemento) {
		pessoasNaFila[tamanhoFila++] = elemento;
	}
	
	public T remove() {
		
		T objetoRemovido = pessoasNaFila[0];
		
		for(int i = 0; i < tamanhoFila - 1; i++) {
			pessoasNaFila[i] = pessoasNaFila[i+1];
		}
		
		pessoasNaFila[--tamanhoFila] = null;
		
		return objetoRemovido;
	}
	
	public T front() {
		return pessoasNaFila[0];
	}
	
	public int size() {
		return tamanhoFila;
	}
	
	public boolean empty() {
		return tamanhoFila <= 0;
	}
	
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
	
	public static void main(String[] args) {
		Fila<String> fila = new Fila<String>(10);
		System.out.println("Fila está vazia? " + fila.empty());
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
