package com.openclassrooms.swingtutorial;

import com.openclassrooms.swingtutorial.threads.CompteEnBanque;
import com.openclassrooms.swingtutorial.threads.MyThread;
import com.openclassrooms.swingtutorial.threads.RunImpl;

public class MainThread {
    public static void main(String[] args) {
        //execThreads();

        CompteEnBanque cb = new CompteEnBanque();
        CompteEnBanque cb2 = new CompteEnBanque();

        Thread t3 = new Thread(new RunImpl(cb, "Cysboy"));
        Thread t4 = new Thread(new RunImpl(cb, "Zéro"));
        t3.start();
        t4.start();
    }

    private static void execThreads() {
        MyThread t = new MyThread("A");
        MyThread t2 = new MyThread("  B", t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("statut du thread " + t.getName() + " = " + t.getState());
        System.out.println("statut du thread " + t2.getName() + " = " + t2.getState());
    }
}
