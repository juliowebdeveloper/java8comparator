package com.java8.examples;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
	
	
	public int compare(T t1, T t2);
	
	public default Comparator<T> thenComparing(Comparator<T> cmp){
		//Se a comparação for eigual a seguro ele retornar um comparator de p1, p2
		//Se não apenas retorna a comparação
		//Esse metodo irá comparar duas pessoas, P1 e p2 de acordo com o primeiro comparator
		//e se os dois objetos forem iguais no sentido do primeiro comparator 
		//Ele irá para o segundo comparator passado como parametro.
		return (p1, p2) ->  compare(p1, p2)== 0 ? cmp.compare(p1, p2): compare(p1, p2);
	}
	
	
	//Recebe uma Function que por sua vez recebe um parametro genercio e retorna um comparable 
	public default Comparator<T> thenComparing(Function<T, Comparable> f){
		//Chamando o then comparing acima que retorna um Comparator<T> passando a chamada do comparingGeneric passando a function
		return thenComparing(comparingGeneric(f));
	}
	
	
	public static Comparator<Person> comparing(Function<Person, Integer> f){ //Esse metodo recebe uma function como parametro
						//Essa function por si só recebe um Person e retorna um integer
		//Retorna a function aplicada aos Persons que será passada como parametro 
		return (p1, p2) -> f.apply(p1) - f.apply(p2);
	}
	
	
	//Deixando o retorno generico
	public static <U>Comparator<U> comparingGeneric(Function<U, Comparable> f){ //Esse metodo recebe uma function como parametro
		//Essa function por si só recebe um Person e retorna um Comparable Object
			//Retorna a function aplicada aos Persons que será passada como parametro 
			return (u1, u2) -> f.apply(u1).compareTo(f.apply(u2));
		}

}
