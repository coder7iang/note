package lock.synchronize.�̰߳�ȫ;

class ThreadA extends Thread {
	 
    private HasSelfPrivateNum numRef;
 
    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }
 
    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
 
}
