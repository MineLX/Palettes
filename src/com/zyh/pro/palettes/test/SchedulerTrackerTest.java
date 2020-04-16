package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.Chain;
import com.zyh.pro.palettes.main.RhythmConsumer;
import com.zyh.pro.palettes.main.rhythms.Rhythm;
import com.zyh.pro.palettes.main.rhythms.RhythmChain;
import com.zyh.pro.taskscheduler.main.CallbackTask;
import com.zyh.pro.taskscheduler.main.Schedulers;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SchedulerTrackerTest {
	@Test
	public void simple_test() throws InterruptedException, FileNotFoundException {
		CallbackTask task = new CallbackTask(7);

		RhythmChain chain = RhythmChain.load(Files.toString("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\test\\second.rhy"));

		Chain<Rhythm> consumerChain = new Chain.Builder<Rhythm>()
				.next(new RhythmConsumer("ball", rhythm -> task.done()))
				.build();

		Schedulers.track(chain.getRhythms(), consumerChain::consume).start();

		task.waitForCompletion();
	}
}
