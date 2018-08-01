package base.thread;

public class SwitchThreadRun {

	public static void main(String[] args) {
		SubWorker worker = new SubWorker();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i =0;i<10;i++) {
					worker.main();
				}
				
			}
			
		}) {
			
			
		}.start();
		
		for(int i =0;i<10;i++) {
			worker.sub();
		}

	}
	
	static class SubWorker {

		private  boolean subRun = false;
		public synchronized void sub() {
			while(!subRun) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=0;i<3;i++) {
				System.out.println("main " + i);
			}
			subRun =false;
			this.notify();
		}
		
		public synchronized void main() {
			while(subRun) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i=0;i<2;i++) {
				System.out.println("sub " + i);
			}
			subRun = true;
			this.notify();
		}
		
	}

}
