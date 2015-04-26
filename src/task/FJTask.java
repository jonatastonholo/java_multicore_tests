package task;

import java.util.concurrent.RecursiveTask;

public class FJTask extends RecursiveTask {
	   private int seq;

	   public FJTask(int n) { this.seq = n; }

	   @Override
	public Integer compute() {
	      String str = "";
	      long begTest = new java.util.Date().getTime();
	      System.out.println("start - Task "+seq);
	      try {
	         Thread.sleep(1000);
	         for(int index = 0; index < 20000; index++)
	            str = str + 't';
	      } catch (InterruptedException e) {}
	      Double secs = new Double((new java.util.Date().getTime() - begTest)*0.001);
	      System.out.println("run time " + secs + " secs");
	      return seq;
	   }
	}