package com.passion.coding.java;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerWaitNotify implements Serializable {

    private static final long serialVersionUID = -7139050220602792952L;
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Thread producer = new Thread(new ProducerThread(queue, 10));
        Thread consumer = new Thread(new ConsumerThread(queue, 10));
        producer.start();
        consumer.start();

    }
}

class ProducerThread implements Runnable {
    Queue<Integer> queue;
    int size;

    public ProducerThread(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (queue) {
                if (queue.size() == size) {
                    System.out.println("Queue is full Producer thread waiting for consumer to consume");
                    try {
                        queue.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }

                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing Value " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}

class ConsumerThread implements Runnable {
    Queue<Integer> queue;
    int size;

    public ConsumerThread(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() == 0) {
                    System.out.println("Queue is Empty Consumer thread waiting for Producer to Produce");
                    try {
                        queue.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println("Consuming Value " + queue.poll());
                queue.notifyAll();
            }
        }
    }
}


