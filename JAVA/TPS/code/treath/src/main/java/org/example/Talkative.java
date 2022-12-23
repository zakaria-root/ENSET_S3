package org.example;

public class Talkative implements Runnable {
    int number;

    public Talkative() {
    }

    public Talkative(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("attribut number " + i + "= " + number);
        }
    }
}
