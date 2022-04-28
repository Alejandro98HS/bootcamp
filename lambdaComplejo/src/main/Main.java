package main;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		 
		List<Producto> shopping = List.of(
		            new Producto("Clothes", new BigDecimal("15.90"), Impuesto.NORMAL),
		            new Producto("Bread", new BigDecimal("1.5"), Impuesto.SUPERREDUCED),
		            new Producto("Meat", new BigDecimal("13.99"), Impuesto.REDUCED),
		            new Producto("Cheese", new BigDecimal("3.59"), Impuesto.SUPERREDUCED),
		            new Producto("Coke", new BigDecimal("1.89"), Impuesto.REDUCED),
		            new Producto("Whiskey", new BigDecimal("19.90"), Impuesto.NORMAL));
		 
//		for( Producto elemento : shopping) {
//			if(elemento.name.charAt(0) == 'C') {
//				System.out.println(elemento.name);
//			}
//		}
		
		String lc = shopping.stream()
				.filter(l -> l.name.startsWith("C"))
				.map(i -> i.name)
				.collect(Collectors.joining(",","[","]"));
		
		System.out.println(lc);
		
		BigDecimal ct = shopping.stream()
				.map(x -> x.price.add(x.price.multiply(BigDecimal.valueOf(x.impuesto.getPercent()*0.01))))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
				//.collect(Collectors.toList());
				
		System.out.println(ct);		
				
		//66.

	}
}
