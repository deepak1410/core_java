package com.dpk.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class CallableThread implements Callable<String> {
    private final int id;
    CallableThread(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "id: " + id;
    }
}

public class CallableManager {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for(int i=0; i<10; i++) {
            Future<String> future = service.submit(new CallableThread(i +1));
            System.out.println("Thread executed id: " + future.get());
        }

        service.shutdown();
    }
}
