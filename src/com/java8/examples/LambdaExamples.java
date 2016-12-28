package com.java8.examples;

import java.util.function.Function;

public class LambdaExamples {

	
	
	//Comparator Example
	public static void main(String[] args) {
		
		//chama o metodo compare e traz como retorno -1 
		//(p1,p2) = parametros já implicitos que são de Person
		// após -> logica do metodo compare
		Comparator<Person> comparatorAge = (p1, p2) -> p2.getAge() - p1.getAge();
		Comparator<Person> comparatorFirstName = (p1, p2) -> p1.getName().compareTo(p2.getName());
		Comparator<Person> comparatorLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
			
		Function<Person, Integer> f1 = p -> p.getAge() ; //Function que recebe uma person e retorna o integer sua idade
		Function<Person, String> f2 = p -> p.getName() ; 
		Function<Person, String> f3 = p -> p.getLastName() ; 
		
		
		Comparator<Person> cmpPerson = Comparator.comparing(f1); //Static method, recebe uma function como parametro
		Comparator<Person> cmpPerson2 = Comparator.comparing(p->p.getAge()); //Escrevendo a expressão lambda diretamente
		Comparator<Person> cmpPersonAge = Comparator.comparingGeneric(Person::getAge); //Tanto int como String são comparables objects
		Comparator<Person> cmpPersonName = Comparator.comparingGeneric(Person::getName); //Utilizando method reference ao inves da lambda
		
		
		Comparator<Person> cmp = Comparator.comparingGeneric(Person::getName)
										.thenComparing(Person::getLastName)
										.thenComparing(Person::getAge);
		
		
		
	}
	
}
