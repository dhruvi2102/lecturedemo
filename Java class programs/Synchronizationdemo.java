package core;

class Caller{
	
	public void call(String msg)
	{
		System.out.print("["+msg);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("]");
	}
}
class CallBack implements Runnable{

	Thread t;
	String tname;
	Caller c;


	public CallBack(String tname, Caller c) {
		
		this.tname = tname;
		this.c = c;
		t= new Thread(this);
		t.start();
	}


	public void run() {
	synchronized(c) {
		c.call(tname);
	}
		
		
	}
	
	
}
public class Synchronizationdemo {

	public static void main(String[] args) {
		Caller c= new Caller();
		CallBack c1=new CallBack("Hello",c);
		CallBack c2=new CallBack("World",c);
		CallBack c3=new CallBack("Synchronized",c);
		
		
	}
}
