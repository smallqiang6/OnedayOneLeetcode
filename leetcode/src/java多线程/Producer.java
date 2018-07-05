package java∂‡œﬂ≥Ã;

import java.lang.System.Logger;

import java.util.logging.Level;  
import java.util.Vector;

public class Producer implements Runnable{
	private final Vector sharedQueue;  
    private final int SIZE;  
      
    public Producer(Vector sharedQueue, int size) {  
        this.sharedQueue = sharedQueue;  
        this.SIZE = size;  
    }  
      
   @Override  
    public void run() {  
        // TODO Auto-generated method stub  
        for (int i = 0; i < 10000; i++) {  
            System.out.println("Produced:" + i);  
            try {  
                produce(i);  
            } catch (InterruptedException ex) {  

            }  
        }  
    }  
  
    private void produce(int i) throws InterruptedException {  
          
        //wait if queue is full  
        while (sharedQueue.size() == SIZE) {  
            synchronized (sharedQueue) {  
                System.out.println("Queue is full " + Thread.currentThread().getName()  
                        + " is waiting , size: " + sharedQueue.size());  
                sharedQueue.wait();  
            }  
        }  
          
        //producing element and notify consumers  
        synchronized (sharedQueue) {  
            sharedQueue.add(i);  
            sharedQueue.notifyAll();  
        }  
    } 
}
