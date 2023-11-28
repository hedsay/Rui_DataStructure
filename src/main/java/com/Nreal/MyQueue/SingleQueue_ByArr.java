package com.Nreal.MyQueue;

public class SingleQueue_ByArr<E> {
    private Object[] queue;
    private int head;
    private int tail;
    private int size;
    private int maxSize;

    public SingleQueue_ByArr(int initSize) {
        this.maxSize = initSize;
        this.head = 0;
        this.tail = -1;
        this.size = 0;
        this.queue = new Object[maxSize];
    }

    //查询队头元素
    public E peek() throws Exception{
        if(size == 0){
            throw new Exception("队列中无数据");
        }
        return (E) this.queue[head];
    }

    //入队
    public boolean offer(E e) throws Exception{
        if(tail>=(maxSize-1)){
            throw new Exception("添加失败，队列已满");
        }
        this.queue[++tail] = e;
        size++;
        return true;
    }

    //出队
    public E poll() throws Exception{
        if(size==0){
            throw new Exception("删除失败，队列为空");
        }
        size--;
        return (E) this.queue[head++];
    }

    public static void main(String[] args) throws Exception {
        SingleQueue_ByArr<String> que = new SingleQueue_ByArr<String>(2);
        que.offer("rui");
        que.offer("kk");
        System.out.println(que.peek());
        que.poll();
        System.out.println(que.peek());
    }
}
