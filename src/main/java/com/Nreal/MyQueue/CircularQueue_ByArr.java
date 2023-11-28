package com.Nreal.MyQueue;

public class CircularQueue_ByArr<E> {
    private Object[] arrays;
    private int front;
    private int rear;//rear=(rear+1)%length

    private int maxSize;

    public CircularQueue_ByArr(int initSize) {
        this.maxSize = initSize;
        this.front = 0;
        this.rear = 0;
        this.arrays = new Object[initSize];
    }

    public boolean isFull(){
        if((rear+1)%arrays.length==front){
            return true;
        }else{
            return false;
        }
    }

    public void enq(E e){
        if(!isFull()){
            //新元素插入队尾
            arrays[rear] = e;
            rear = (rear+1)%arrays.length;
        }
    }

    public E poll(){
        if(!isEmpty()){
            front = (front+1)%arrays.length;
        }
        return (E)arrays[front];
    }

    public boolean isEmpty(){
        if(rear == front){
            return true;
        }else{
            return false;
        }
    }

    public void traverse(){
        int i= front;
        while(i!=rear){
            System.out.println(arrays[i]);
            i = (i+1)%arrays.length;
        }
    }

    public static void main(String[] args) {
        //数组中需要一个空闲位置 作为队列已满的标志
        CircularQueue_ByArr<String> que = new CircularQueue_ByArr<String>(4);
        que.enq("rui");
        que.enq("kk");
        que.enq("vdd");
        que.traverse();
    }
}
