package fr.aelion.java2012.multithreadingintro.exo3;

public class Exo3 {

	public static void main(String[] args) {
		Account account = new Account();
	    for (int i = 0; i < 20; i++) {
	      Operation operation = new Operation("operation " + i, account);
	      new Thread(operation).start();
	    }

	}

}