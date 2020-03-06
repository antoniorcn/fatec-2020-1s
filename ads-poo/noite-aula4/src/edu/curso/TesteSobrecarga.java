package edu.curso;

public class TesteSobrecarga {
	
	public void soma(int n1, int n2) { 
		System.out.println("Soma2 : " + (n1 + n2));
	}
	
	public void soma(int n1, int n2, int n3) { 
		System.out.println("Soma3 : " + (n1 + n2 + n3));
	}
	
	public void soma(int ... numeros) {
		int s = 0;
		for (int n : numeros) { 
			s += n;
		}
		System.out.println("SomaN : " + s);
	}
	
	public static void main(String[] args) {
		TesteSobrecarga ts = new TesteSobrecarga();
		ts.soma(5, 6, 1, 5);
	}

}
