package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Создаю потоки...");
        Callable<Integer> thread1 = new myCallable(3);
        Callable<Integer> thread2 = new myCallable(1);
        Callable<Integer> thread3 = new myCallable(5);
        Callable<Integer> thread4 = new myCallable(4);

        final ExecutorService threadPool  = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Стартую потоки...");
        final Future<Integer> future1 = threadPool.submit(thread1);
        final Future<Integer> future2 = threadPool.submit(thread2);
        final Future<Integer> future3 = threadPool.submit(thread3);
        final Future<Integer> future4 = threadPool.submit(thread4);

        final Integer resultOfTask1 = future1.get();
        System.out.println("Результат выполнения задачи 1: "+ resultOfTask1);
        final Integer resultOfTask2 = future2.get();
        System.out.println("Результат выполнения задачи 2: "+ resultOfTask2);
        final Integer resultOfTask3 = future3.get();
        System.out.println("Результат выполнения задачи 3: "+ resultOfTask3);
        final Integer resultOfTask4 = future4.get();
        System.out.println("Результат выполнения задачи 4: "+ resultOfTask4);

        System.out.println("============== Самый быстрый ===================");
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(thread1);
        callables.add(thread2);
        callables.add(thread3);
        callables.add(thread4);
        System.out.println("Стартую потоки...");
        final Integer resultAny = threadPool.invokeAny(callables);
        System.out.println("Результат выполнения самой быстрой: "+ resultAny);
    }
}
