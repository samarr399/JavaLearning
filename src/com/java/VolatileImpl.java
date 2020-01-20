package com.java;

class Shared {
	private int i = 0;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}

class Thread1 extends Thread {

	private Shared shared;

	public Thread1(Shared shared) {
		this.shared = shared;
	}

	@Override
	public void run() {
		shared.setI(shared.getI() + 1);
		System.out.println(shared.getI());
	}
}

class Thread2 extends Thread {

	private Shared shared;

	public Thread2(Shared shared) {
		this.shared = shared;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		shared.setI(shared.getI() + 1);
		System.out.println(shared.getI());
	}
}

public class VolatileImpl {
	public static void main(String[] args) {
		Shared shared = new Shared();
		Thread th1 = new Thread1(shared);
		Thread th2 = new Thread2(shared);
		th2.start();
		th1.start();

	}
}
