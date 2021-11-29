package ru.netology;

public class Main {

    public static void main(String[] args) {

        System.out.println("Создаю потоки...");
        ThreadGroup threadGroup = new ThreadGroup("группа 1");
        Thread thread1 = new MyThread(threadGroup,"поток 1");
        Thread thread2 = new MyThread(threadGroup,"поток 2");
        Thread thread3 = new MyThread(threadGroup,"поток 3");
        Thread thread4 = new MyThread(threadGroup,"поток 4");
        System.out.println("Активных потоков в группе: " + threadGroup.activeCount());
        System.out.println("Стартую потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println("Активных потоков в группе: " + threadGroup.activeCount());

        try {
            Thread.sleep(15000);
            System.out.println("Завершаю все потоки...");
            threadGroup.interrupt();
            while(true){
                Thread.sleep(1000);
                System.out.println("Активных потоков в группе: " + threadGroup.activeCount());
                if (threadGroup.activeCount()==0){
                    System.out.println("Разрушаю группу");
                    threadGroup.destroy();
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
