/**
 * 
 * @author adilemdobras
 *
 */
public class Practica1 {
	/**
	 * Lo que hice fue dejar todo como estaba. Las condiciones estaban correctas, el
	 * problema era que cuando usas un bucle for te va a recorrer todos los valores,
	 * por lo tanto si el bucle encontraba un valor en false lo que hacia era poner
	 * a false como debia pero el bucle seguia recorriendo asi que lo que hice fue
	 * que cuando encontrara un valor distinto se marcara la identidad como false,
	 * asi podiendo mantener el false en la estructura. Lo puse asi para no cambiar
	 * la estructura que pedian.
	 * 
	 * @param matriz, se introduce la matriz que se desea evaluar.
	 * @return devuelve un booleano que comprueba si la matriz es identidad.
	 */
	// Corregir esta funcion
	public static boolean esIdentidad_v1(int[][] matriz) {
		boolean identidad = true;

		for (int fila = 0; fila < matriz.length; fila++) { // No editar esta linea
			for (int col = 0; col < matriz[fila].length; col++) { // No editar esta li­nea
				if (fila == col) {
					if (matriz[fila][col] != 1) {
						identidad = false;
					}

				} else {
					if (matriz[fila][col] != 0) {
						identidad = false;
					}

				}

			} // for
		} // for
		return identidad;
	}

	/**
	 * Dentro de este codigo corrijo el codigo de arriba para que su orden de
	 * magnitud sea menor al que presenta el anterior en teoria uso un booleano que
	 * es el que se pueda realizar el mejor de los casos en la funcion es decir que
	 * me permitira parar cuando se sepa que no es una identidad. En el peor de los
	 * casos mi bucle funcionara como un bucle for regular, incluyendo que cuando
	 * termino de revisar las coluumnas por defecto, como estoy utilizando un bucle
	 * while me obligo a setear j a 0. i=filas j=columnas
	 * 
	 * @param matriz, se introduce la matriz que se desea evaluar.
	 * @return devuelve un booleano que comprueba si la matriz es identidad.
	 */

	public static boolean esIdentidad_v2(int[][] matriz) {
		boolean identidad = true;

		int i = 0;
		int j = 0;
		// declaro las verificaciones de tamaño de filas y compruebo que en las filas
		// que verifico no haya ningun valor q no sea identidad
		while ((i < matriz.length) && identidad) {
			// declaro las verificaciones de tamaño de columnas y compruebo que en las
			// coluumnas que verifico no haya ningun valor q no sea identidad

			while ((j < matriz[i].length) && identidad) {
				if (i == j) {

					if (matriz[i][j] != 1) {
						identidad = false;
					}

				} else {
					if (matriz[i][j] != 0) {
						identidad = false;
					}

				}

				j++;
			}
			// Seteo el valor de las columnas
			j = 0;
			i++;
		}
		return identidad;
	}

	/**
	 * En este metodo trate de ser lo mas optima posible, por lo que esta es una funcion con la que hago la llamada a la 
	 * funcion recursiva para no perder la consistencia de los datos.
	 * @param matriz se introduce la matriz que se desea evaluar.
	 * @return devuelve un booleano que comprueba si la matriz es identidad.
	 */
	public static boolean esIdentidad_DyV(int[][] matriz) {

		boolean x = divideYvenceras(matriz, 0, matriz.length - 1, 0, matriz[0].length - 1);

		return x; // sentencia insertara para poder compilar
	}
/**
 * Explicacion lo que hace esta funcion es partir la matriz en 4 pedazos, en donde cuento el primer cuarante que va desde
 * en filas:(0-1) y columnas: (0-1), sucesivamente sera filas:(2-3) y columnas: (2-3) y asi sucesivamente hasta que llegue a su mayor tamaño
 * que es 3-3. Dentro de la funcion utilizo booleanos para comprobar si el valor es identidad cuando finalizo la funcion
 * devuelvo la multiplicacion de todos los booleans y si se encuentra uno en false me retornara false.
 * Tambien utilizo unos if que me sirven de condicionantes a la recursividad, es decir, este es un recursivo con vista de bucle for
 * porque pongo dos if que me funcionan como bucle for.
 * En esta funcion avanzo y divido como se ve en la funcion...avanzo j cada vez que divido.
 * @param matriz, se introduce la matriz que se desea evaluar.
 * @param i, este donde comienza la matriz por filas(su inicio)
 * @param iaux, este es donde finalizan las filas.
 * @param j, aqui declaro donde iniciaremos a contar las columnas
 * @param jaux, aqui declaro donde finalizaremos de contar las columnas
 * @return devuelve un booleano que comprueba si la matriz es identidad.
 */
	public static boolean divideYvenceras(int[][] matriz, int i, int iaux, int j, int jaux) {
		boolean z = true;
		boolean x = true;
		boolean w = true;
		boolean y = true;
		if (iaux < matriz.length && jaux < matriz[0].length && (i == iaux) && (j == jaux)) {
			if (i == j) {
				if (matriz[i][j] != 1) {

					return false;
				}
			} else {
				if (matriz[i][j] != 0) {

					return false;
				}

			}

		} else {

			if (i < (iaux + 1)) {

				if (j < jaux) {
					// primera mitad

					x = divideYvenceras(matriz, i, (((i + iaux) / 2)), j + 1, ((j + jaux)) / 2);

					y = divideYvenceras(matriz, (((i + iaux) / 2)), iaux, ((j + jaux) / 2) + 1, jaux);

				}
				// primera mitad

				int jnueva = 0;

				z = divideYvenceras(matriz, i + 1, (((i + iaux)) / 2), jnueva, (((jnueva + jaux)) / 2));

				w = divideYvenceras(matriz, (((i + iaux)) / 2) + 1, iaux, (((jnueva + jaux)) / 2) + 1,
						(matriz.length - 1));

			}

		}

		return z && x && w && y;

	}
/**
 * Para calcular si un valor es potencia de 2 hay varias formas, se puede sacar en binario, logaritmo y un bucle while.
 * Seleccione el logaritmo porque es el mas eficiente, no me trae bucles infinitos.
 * @param numero, aqui colocare el tamaño de la matriz
 * @return me dice si el valor es potencia de 2
 */
	public static boolean esPotenciaDe2(int numero) {
		return ((Math.log10(numero) / Math.log10(2)) % 1) == 0;
		// Si después de dividir entre dos el número es 1, es una potencia de dos

	}
/**
 * Simulando la consistencia que han tenido todas las funciones anteriores me creo una funcion de media Divide y venceras 
 * en el que verifico si el tamaño N es potencia de 2 y se concluye la media dividiendo entre el tamaño de los valores o su cantidad.
 * @param array, aqui colocare los valores que les calculare la media.
 * @return devuelve la media.
 */
	private static double mediaDyV(int[] array) {
		double x = 0;
		if (esPotenciaDe2(array.length) == true) {
			x = mediaDyV(array, 0, array.length - 1);
		} else {
			System.out.println("No se puede operar, no es potencia de 2");
		}
		double media = x / array.length;
		return media;
	}
/**
 * Basicamente en este problema segui la misma ejecucion que tienen siempre los divide y venceras.
 * en donde i sera la posicion en donde inicio mi array y j sera la posicion en donde termino. La diferencia del divide y 
 * venceras anterior es que aqui no avanzo ya que no tengo que verificar en dos dimensiones.
 * @param array, aqui colocare los valores que les calculare la media.
 * @param i, i sera la posicion en donde inicio mi array
 * @param j, j sera la posicion en donde termino.
 * @return
 */
	private static double mediaDyV(int[] array, int i, int j) {

		if (i == j) {
			double media = array[i];

			return media;
		} else {
			int mitad = ((i + j) / 2);
			double x = mediaDyV(array, i, mitad);
			double y = mediaDyV(array, mitad + 1, j);

			return ((x + y));
		}

	}

	public static void main(String[] args) {

		int[][] m1 = { { 1, 0, 0, 0 }, { 0, 6, 0, 0 }, { 0, 0, 3, 0 }, { 0, 0, 0, 8 } };

		int[][] m2 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

		int[][] m3 = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } };
		int[] valores = { 1, 2, 1, 1 };
		// CORREGIDO

		System.out.println("PRUEBA 1:");
		System.out.println(" * esIdentidad_v1 (m1): " + esIdentidad_v1(m1));
		System.out.println(" * esIdentidad_v1 (m2): " + esIdentidad_v1(m2));
		System.out.println(" * esIdentidad_v1 (m3): " + esIdentidad_v1(m3));

		System.out.println("\nPRUEBA 2:");
		System.out.println(" * esIdentidad_v2 (m1): " + esIdentidad_v2(m1));
		System.out.println(" * esIdentidad_v2 (m2): " + esIdentidad_v2(m2));
		System.out.println(" * esIdentidad_v2 (m3): " + esIdentidad_v2(m3));

		System.out.println("\nPRUEBA 3:");
		System.out.println(" * esIdentidad_DyV (m1): " + esIdentidad_DyV(m1));
		System.out.println(" * esIdentidad_DyV (m2): " + esIdentidad_DyV(m2));
		System.out.println(" * esIdentidad_DyV (m3): " + esIdentidad_DyV(m3));
		System.out.println("\nPRUEBA 4:");
		System.out.println("* Media (valores): " + mediaDyV(valores));
		/* ****** DATOS PERSONALES ****** */

		String miNombre = "Adilem";
		String misApellidos = "Dobras Castillo";
		String miExpediente = "21911633";

		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + miNombre);
		System.out.println(" * Nombre:\t" + misApellidos);
		System.out.println(" * Expediente:\t" + miExpediente);

		System.out.println("\n*** FIN ***");

	}

}
