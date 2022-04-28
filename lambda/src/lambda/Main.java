package lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		List<Integer> enteros = List.of(1,11,2,12,3,13);
		
		int count = 0;
		
		for(int numero : enteros) {
			if(numero>10) {
				count++;
			}
		}
		
		System.out.println(count);
		
		System.out.println("============================");
		
		IVisualizar vs = lista -> {
			enteros.forEach(n -> System.out.println(n));
		};
		
		vs.visualizarElementos(enteros);
		
		System.out.println("============================");
		
		IContarMayoresDiez cmd = (list) -> enteros.stream().filter(num -> num > 10).count();
		System.out.println("Números mayores de 10: " + cmd.contarMayoresDiez(enteros));
		
		System.out.println("============================");
		
		List<String> colores = List.of("azul","amarillo", "rojo","verde","rosa");
		
		IColor col = (secuencia) -> colores.stream().filter(color -> color != "rojo").map(color -> color.toString().toUpperCase()).collect(Collectors.toList());
		System.out.println("Resultado: " + col.filtroColor(colores));		
		
		
	}
}
