package lock.synchronize.多个对象多个锁;

public class Run {
	 
    public static void main(String[] args) {
 
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
 
        ThreadA athread = new ThreadA(numRef1);
        athread.start();
 
        ThreadB bthread = new ThreadB(numRef2);
        bthread.start();
 
    }
 
}
