package edu.iis.mto.multithread;

public class Radar implements RadarIfc{
	private PatriotBattery battery;

	public Radar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					battery.launchPatriot();
				}
			}
		};

		Thread launchingThread = new Thread(launchPatriotTask);
		launchingThread.start();
	}
}
