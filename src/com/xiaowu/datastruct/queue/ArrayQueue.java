package com.xiaowu.datastruct.queue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author chutaojing
 * @version 1.0
 * @description 使用数组实现一个简单队列(注:该队列不能循环使用)
 * @date 2021-01-22
 * @see
 * @since 1.0
 */
public class ArrayQueue<T> {
    //队列头,空队列时head=-1
    private int head;
    //队列尾,空队列时head=-1
    private int tail;
    //队列长度
    private int capacity;
    private Object[] queueData;
    
    /**
     * @param capacity
     * @return null
     * @Description 构造函数初始化指定长度的队列
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/22
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queueData = new Object[capacity];
        head = -1;
        tail = -1;
    }
    
    /**
     * @param element
     * @return boolean
     * @Description 向队列中添加元素
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/22
     */
    public boolean addElement(T element) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满,不能再添加元素了!");
            return false;
        }
        queueData[++this.tail] = element;
        return true;
    }
    
    /**
     * @param
     * @return int 返回队首元素
     * @Description 从队列中获取元素
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/22
     */
    public T getElement() {
        if (isEmpty()) {
            System.out.println("此队列是空队列,无法获取元素!");
            return null;
        }
        return (T) this.queueData[++this.head];
    }
    
    /**
     * @param
     * @return int
     * @Description 获取队首元素
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/22
     */
    
    public T getHeadElement() {
        if (isEmpty()) {
            System.out.println("此队列是空队列,无法获取元素!");
            return null;
        }
        return (T) this.queueData[this.head + 1];
    }
    
    /**
     * @param
     * @return boolean true:队列为空,false:队列不为空
     * @Description 判断队列是否为空
     * @Author chutaojing
     * @Exception
     * @Date 2021/01/22
     */
    private boolean isEmpty() {
        return this.head == this.tail;
    }
    
    /**
     * @param
     * @return boolean
     * @Description 判断队列是否已满
     * @Author chutaojing
     * @Exception true:队列已满,false:队列没满
     * @Date 2021/01/22
     */
    private boolean isFull() {
        return this.tail == this.capacity - 1;
    }
    
    public static void main(String[] args) {
        System.out.println("请输入要初始化的队列的长度:");
        Scanner scanner = new Scanner(System.in);
        ArrayQueue<Integer> arrayQueue = null;
        while (true) {
            if (scanner.hasNextInt()) {
                int length = scanner.nextInt();
                arrayQueue = new ArrayQueue<Integer>(length);
                System.out.println("长度为" + length + "的队列已初始化完成");
                break;
            } else {
                System.out.println("请输入正确的要初始化的队列的长度:");
            }
        }
        while (true) {
            System.out.println("========================");
            System.out.println("请输入你想要对该队列的操作");
            System.out.println("队列添加元素请输入:add");
            System.out.println("获取队列中的元素请输入:get");
            System.out.println("获取队首的元素请输入:head");
            System.out.println("你想要的操作是:");
            if (scanner.hasNext()) {
                String operate = scanner.next();
                switch (operate) {
                    case "add":
                        System.out.println("请输入要添加的数字:");
                        if (scanner.hasNextInt()) {
                            int ele = scanner.nextInt();
                            boolean flag = arrayQueue.addElement(ele);
                            if (flag) {
                                System.out.println("数字:" + ele + "添加成功");
                            }
                            
                        }
                        break;
                    case "get":
                        Object object = arrayQueue.getElement();
                        if (object != null) {
                            System.out.println("获取到队里中的数字是:" + object.toString());
                        }
                        break;
                    case "head":
                        Object headEle = arrayQueue.getHeadElement();
                        if (headEle != null) {
                            System.out.println("队首的数字是:" + headEle.toString());
                        }
                        
                        break;
                    default:
                        System.out.println("请输入正确的操作!");
                        break;
                }
                
            }
        }
        
    }
}
