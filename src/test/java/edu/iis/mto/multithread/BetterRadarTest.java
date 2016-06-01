package edu.iis.mto.multithread;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.concurrent.Executor;

import org.junit.Test;

public class BetterRadarTest {

	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		
		Executor executor = new Executor(){
			@Override
			public void execute(Runnable command) {
				command.run();
				
			}
		};
		
		RadarIfc radar = new BetterRadar(batteryMock, executor);
		radar.notice(new Scud());
		verify(batteryMock, times(10)).launchPatriot();
	}

}
