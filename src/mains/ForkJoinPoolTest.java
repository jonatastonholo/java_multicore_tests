package mains;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

import task.FJTask;


public class ForkJoinPoolTest {

   public ForkJoinPoolTest() {}
   private static int numOfTasks = 1000;

   public void run() {
      long begTest = new java.util.Date().getTime();

      List<ForkJoinTask> futuresList = new ArrayList();
      ForkJoinPool fjPool = new ForkJoinPool(numOfTasks);

      for(int index = 0; index < numOfTasks; index++)
         futuresList.add(fjPool.submit(new FJTask(index)));

      Object taskResult;
      for(Future future:futuresList) {
         try {
            taskResult = future.get();
            System.out.println("result ForkJoin "+taskResult);
         }
         catch (InterruptedException e) {}
         catch (ExecutionException e) {}
      }
      Double secs = new Double((new java.util.Date().getTime() - begTest)*0.001);
      System.out.println("run time " + secs + " secs");
   }

   public static void main(String[] args) {
      new ForkJoinPoolTest().run();
      System.exit(0);
   }
}