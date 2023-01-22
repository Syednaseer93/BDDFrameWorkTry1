package WaitConcept.WaitConcept;

public class MainMethodOverlaoding {

	public static void main(String[] args) {
		main(10);
	}
	public static void main(int x) {
		System.out.println("Overloaded method");
	}
	public static void main(int y, int z) {
		System.out.println("Overloaded method");
	}
}
