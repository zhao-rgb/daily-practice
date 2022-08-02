package com.zxl.dailypractice.card.two.august.august2;

/**
 * @author: zhaoxl
 * @date: 2022/8/2
 * @desc:
 **/
//设计循环队列   https://leetcode.cn/problems/design-circular-queue/
public class Solution {
    private int front;
    private int rear;
    private int capacity;
    private int[] elements;

    public Solution(int k) {
        capacity = k + 1;
        elements = new int[capacity];
        rear = front = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }
}
