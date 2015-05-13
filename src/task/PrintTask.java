package task;

import java.util.Random;

public class PrintTask implements Runnable{

	private final int sleepTime;
	private final String taskName;
	private final static Random generator = new Random();

	public PrintTask(String taskName) {
		this.taskName = taskName;
		// tempo de adormecimento
		this.sleepTime = this.generator.nextInt(5000); // 0 - 5 sec
	}

	@Override
	public void run() {
		try {
			// colocar a thread para dormir
			System.out.println(taskName + " dormirá por " + sleepTime + "s");
			Thread.sleep(sleepTime);
			String str = "";
			for(int i = 0; i < 200000; i++)
	            str = str + 't';

		} catch(InterruptedException e) {
			System.out.println(taskName + " Interrompida");
		}

		System.out.println(taskName + " terminou de dormir");
	}

}
