package game.mechanics;

import java.io.Serializable;

public class Tick extends Thread implements Runnable,Serializable {

	
	private static final long serialVersionUID = 1L;
	private boolean paused;
	private int tickCount;

	public Tick() {
		tickCount = 0;
		paused = false;
	}

	@Override
	public void run() {
		while(true) {
	
			try {
				Thread.sleep(1000);
				
				if (!paused) {
					tickCount++;
				System.out.println("tickCount: " + tickCount);
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		} 
		
		
		
	}

	public int getTickCount() {
		return tickCount;
	}

	public void setTickCount(int tickCount) {
		this.tickCount = tickCount;
	}
	public void pause() {
		this.paused = true;
	}
	public void unPause() {
		this.paused = false;

	}
	public boolean isPaused() {
		return this.paused;
	}
	public void setPause(boolean p) {
		this.paused = p;
	}
}
