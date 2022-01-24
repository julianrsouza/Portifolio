package recursao;

public class Main {

	public static boolean temInt(int[] array, int n) {
		if (array.length > 0) {
			return temInt(array, n, 0);
		}

		return false;
	}

	private static boolean temInt(int[] array, int n, int i) {
		if (i < array.length) {
			if (n == array[i]) {
				return true;
			} else {
				return temInt(array, n, ++i);
			}
		}
		return false;
	}

	public static boolean ehPrimo(int n) {
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return false;
		}
		return ehPrimo(n, 2);
	}

	private static boolean ehPrimo(int n, int i) {
		if (i < n) {
			if (n % i == 0) {
				return false;
			} else {
				return ehPrimo(n, ++i);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arrayInt = { 1, 3, 5, 7, 9, 11, 13, 15 };
		int n = 9;
		int n1 = 4;
		int primo = 11;

		System.out.println("Teste temInt1: " + Main.temInt(arrayInt, n));
		System.out.println("Teste temInt2: " + Main.temInt(arrayInt, n1));
		System.out.println("Teste ehPrimo1: " + Main.ehPrimo(primo));
		System.out.println("Teste ehPrimo2: " + Main.ehPrimo(n));

	}

}
