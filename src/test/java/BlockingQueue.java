import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {
    @Test
    public void ArrayListBlockingQueue(){
        ArrayBlockingQueue<String> arrays = new ArrayBlockingQueue<String>(3,true);
        arrays.add("李四");
        arrays.add("张军");
        arrays.add("张军");
        // 如果队列已满，就阻塞当前进程， 等在指定时间
        try {
            if(!arrays.offer("张三", 3, TimeUnit.SECONDS)){
                System.out.println("队列已满\n\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrays.peek());
        System.out.println(arrays.poll());
        System.out.println(arrays.poll());
        System.out.println(arrays.poll());
        try {
            System.out.println(arrays.poll(3, TimeUnit.SECONDS));//null
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            arrays.put("李1");
            arrays.put("李2");
            arrays.put("李3");
            arrays.put("李4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void LinkedListBlockingQueue(){
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);

        try {
            linkedBlockingQueue.put("1");
            linkedBlockingQueue.put("2");
            linkedBlockingQueue.put("3");
            linkedBlockingQueue.isEmpty();
            if(!linkedBlockingQueue.offer("4")){
                System.out.println("队列已满\n\n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
