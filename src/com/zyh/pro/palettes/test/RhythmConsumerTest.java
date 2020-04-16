package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.Chain;
import com.zyh.pro.palettes.main.RhythmConsumer;
import com.zyh.pro.palettes.main.rhythms.Rhythm;
import com.zyh.pro.taskscheduler.main.CallbackTask;
import org.junit.Test;

import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RhythmConsumerTest {
	@Test
	public void custom_chain() throws InterruptedException {
		CallbackTask task = new CallbackTask(2);
		Consumer<Rhythm> taskConsumer = rhythm -> task.done();
		Chain<Rhythm> chain = new Chain.Builder<Rhythm>()
				.next(new RhythmConsumer("ball", taskConsumer))
				.next(new RhythmConsumer("notBall", taskConsumer))
				.build();
		assertThat(chain.consume(new Rhythm(1000, "ball", "fadeTo", "50%")), is(true));
		assertThat(chain.consume(new Rhythm(1000, "notBall", "fadeTo", "50%")), is(true));
		task.waitForCompletion();
	}
}
