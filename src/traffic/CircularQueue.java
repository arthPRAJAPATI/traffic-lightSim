package traffic;

import java.io.IOException;

import static traffic.Main.clearConsole;

public class CircularQueue {

    private String[] arr;
    private int front;
    private int size;
    private int capacity;


    public CircularQueue(int capacity) {
        this.arr = new String[capacity];
        this.front = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    public void enqueue(String roadToAdd) {
        if(size == capacity) {
            System.out.println("queue is full");
        } else {
            int rear = (front + size) % capacity;
            arr[rear] = roadToAdd;
            size++;
            System.out.println(roadToAdd + " Added!");
        }
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("queue is empty");
        } else {
            front = (front + 1) % capacity;
            size--;
            System.out.println(arr[front] + " Deleted!");
        }
    }

    public void show() {
        for(int i = front; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println(arr[index]);
        }
    }
}
