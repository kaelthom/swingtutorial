package com.openclassrooms.swingtutorial.threads;

public class RunImpl implements Runnable {
    private final String name;
    private CompteEnBanque cb;

    public RunImpl(CompteEnBanque cb, String name) {
        this.name = name;
        this.cb = cb;
    }

    public void run() {
        for (int i = 0; i < 25; i++) {
            if (cb.getSolde() > 0) {
                cb.retraitArgent(2);
                System.out.println("Retrait effectué");
            }
        }
    }
}
