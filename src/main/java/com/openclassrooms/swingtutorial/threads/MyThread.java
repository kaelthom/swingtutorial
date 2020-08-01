package com.openclassrooms.swingtutorial.threads;

public class MyThread extends Thread {
    Thread t;

    public MyThread(String name) {
        super(name);
        System.out.println("statut du thread " + name + " = " + this.getState());
        this.start();
        System.out.println("statut du thread " + name + " = " + this.getState());
    }

    public MyThread(String name, Thread t) {
        super(name);
        this.t = t;
        System.out.println("statut du thread " + name + " = " + this.getState());
        this.start();
        System.out.println("statut du thread " + name + " = " + this.getState());
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("statut " + this.getName() + " = " + this.getState());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (t != null)
                System.out.println("statut de " + t.getName() + " pendant le thread " + this.getName() + " = " + t.getState());
        }
    }

    public void setThread(Thread t) {
        this.t = t;
    }
}
