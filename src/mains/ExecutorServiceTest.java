package mains;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import task.Task;

public class ExecutorServiceTest {
   private static int NUM_OF_TASKS = 500;

   public ExecutorServiceTest() {}

   public void run() {
      long begTest = new java.util.Date().getTime();

      List< Future > futuresList = new ArrayList< Future >();
      int nrOfProcessors = Runtime.getRuntime().availableProcessors();
      ExecutorService eservice = Executors.newFixedThreadPool(nrOfProcessors);

      for(int index = 0; index < NUM_OF_TASKS; index++)
         futuresList.add(eservice.submit(new Task(index)));

         Object taskResult;
         for(Future future:futuresList) {
            try {
               taskResult = future.get();
               System.out.println("result "+taskResult);
         }
         catch (InterruptedException e) {}
         catch (ExecutionException e) {}
      }
      Double secs = new Double((new java.util.Date().getTime() - begTest)*0.001);
      System.out.println("run time " + secs + " secs");
    }

    public static void main(String[] args) {
       new ExecutorServiceTest().run();
       System.exit(0);
    }
}