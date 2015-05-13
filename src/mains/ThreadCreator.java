package mains;

import task.PrintTask;

public class ThreadCreator {
	public static void main(String[] args) throws InterruptedException {
		//Criando as threads
		Thread t1 = new Thread(new PrintTask("t1"));
		Thread t2 = new Thread(new PrintTask("t2"));
		Thread t3 = new Thread(new PrintTask("t3"));

		//iniciando as threads
		t1.start();
		t2.start();
		t3.start();
	}
}
