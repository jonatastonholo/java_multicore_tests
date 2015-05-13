package mains;

public class MyThread extends Thread{
	int threadID;

	MyThread (int ID) {
		threadID = ID;
	}

	@Override
	public void run () {
		int i ;

		for (i = 0; i< 100 ; i++)
			System.out.println ("Hello from t" + threadID + "!") ;
	}

	public static void main (String args[]) {
		MyThread t1 = new MyThread (1);
		MyThread t2 = new MyThread (2);
		MyThread t3 = new MyThread (3);

		t1.start();
		t2.start();
		t3.start();
	}
}
