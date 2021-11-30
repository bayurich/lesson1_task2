package ru.netology;

import java.util.concurrent.Callable;

public class myCallable implements Callable<Integer> {

    private int maxCountMessages = 0;

    public myCallable(int maxCountMessages) {
        this.maxCountMessages = maxCountMessages;
    }

    @Override
    public Integer call() throws Exception {
        int currentCountMessages = 0;
        for (int i=1; i<=maxCountMessages; i++){
            Thread.sleep(2500);
            currentCountMessages++;
            System.out.printf("Поток: %s. Сообщение № %d: Всем привет!\n", Thread.currentThread().getName(), currentCountMessages);
        }

        return currentCountMessages;
    }
}
