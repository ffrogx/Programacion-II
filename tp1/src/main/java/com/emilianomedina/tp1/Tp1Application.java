package com.emilianomedina.tp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Tp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);

		Scanner sc = new Scanner(System.in);

		// 1. Nota
		System.out.print("Ingrese nota: ");
		int nota = sc.nextInt();

		if (nota < 4) {
			System.out.println("Desaprobado");
		} else if (nota == 10) {
			System.out.println("Sobresaliente");
		} else {
			System.out.println("Aprobado");
		}

		// 2. Promedio
		System.out.println("\nIngrese 3 notas:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();

		double promedio = (n1 + n2 + n3) / 3.0;

		if (promedio >= 8) {
			System.out.println("Promocionado");
		} else {
			System.out.println("No promocionado");
		}

		// 3. Digitos
		System.out.print("\nIngrese numero (1-99): ");
		int num = sc.nextInt();

		if (num < 10) {
			System.out.println("Tiene 1 digito");
		} else {
			System.out.println("Tiene 2 digitos");
		}

		// 4. Trimestre
		System.out.print("\nIngrese dia: ");
		int dia = sc.nextInt();
		System.out.print("Ingrese mes: ");
		int mes = sc.nextInt();
		System.out.print("Ingrese año: ");
		int anio = sc.nextInt();

		if (mes >= 1 && mes <= 3) {
			System.out.println("Primer trimestre");
		} else if (mes >= 4 && mes <= 6) {
			System.out.println("Segundo trimestre");
		} else if (mes >= 7 && mes <= 9) {
			System.out.println("Tercer trimestre");
		} else {
			System.out.println("Cuarto trimestre");
		}

		// 5. Cuadrante
		System.out.print("\nIngrese X: ");
		int x = sc.nextInt();
		System.out.print("Ingrese Y: ");
		int y = sc.nextInt();

		if (x > 0 && y > 0) {
			System.out.println("Primer cuadrante");
		} else if (x < 0 && y > 0) {
			System.out.println("Segundo cuadrante");
		} else if (x < 0 && y < 0) {
			System.out.println("Tercer cuadrante");
		} else if (x > 0 && y < 0) {
			System.out.println("Cuarto cuadrante");
		}

		// 6. Triangulos
		System.out.print("\nCantidad de triangulos: ");
		int n = sc.nextInt();

		int equilateros = 0;
		int isosceles = 0;
		int escalenos = 0;

		for (int i = 1; i <= n; i++) {
			System.out.println("\nTriangulo " + i);

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == b && b == c) {
				System.out.println("Equilatero");
				equilateros++;
			} else if (a == b || a == c || b == c) {
				System.out.println("Isosceles");
				isosceles++;
			} else {
				System.out.println("Escaleno");
				escalenos++;
			}
		}

		System.out.println("\nCantidad:");
		System.out.println("Equilateros: " + equilateros);
		System.out.println("Isosceles: " + isosceles);
		System.out.println("Escalenos: " + escalenos);

		// menor cantidad
		if (equilateros < isosceles && equilateros < escalenos) {
			System.out.println("Menor cantidad: Equilateros");
		} else if (isosceles < escalenos) {
			System.out.println("Menor cantidad: Isosceles");
		} else {
			System.out.println("Menor cantidad: Escalenos");
		}

		sc.close();
	}
}