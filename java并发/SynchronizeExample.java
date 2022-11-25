package java并发;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeExample {
    public void func1(){
        synchronized(SynchronizeExample.class/*this*/){
            for(int i=0;i<10;i++){
                System.out.println(i+"");
            
            }
        }
    }
    public static void main(String[] args){
        SynchronizeExample e1=new SynchronizeExample();
        SynchronizeExample e2=new SynchronizeExample();
        ExecutorService executorService=Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        // executorService.execute(()-> e1.func1());
        executorService.execute(()-> e2.func1());
    }
    
}
