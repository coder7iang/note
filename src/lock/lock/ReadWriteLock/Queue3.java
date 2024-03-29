package lock.lock.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Queue3 {
    //共享数据，只能有一个线程 写数据，但可以 多个线程读数据
    private Object data = null;
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get() {
        rwl.readLock().lock();//上读锁，其他线程只能读。
        System.out.println(Thread.currentThread().getName() +
                "准备好读取 data！");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() +
                    "已经读到了data  "+data);
            rwl.readLock().unlock();//释放读锁，最好放在finally里面
        }
    }

    public void put(Object data) {
        rwl.writeLock().lock();//加上写锁，不允许其他线程 读写
        System.out.println(Thread.currentThread().getName() +
                "准备好写 data!!");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.data=data;
            System.out.println(Thread.currentThread().getName() +
                    "已经写好了 data！！ "+data);
            rwl.writeLock().unlock();//释放锁
        }
    }
}
