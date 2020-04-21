package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.RoleStage;
import com.zyh.pro.palettes.main.core.role.ClearRole;
import com.zyh.pro.palettes.main.core.role.FadeRole;
import com.zyh.pro.palettes.main.core.role.CompositeRole;
import com.zyh.pro.palettes.main.core.role.RhythmBallRole;
import com.zyh.pro.palettes.main.core.view.KeyEvent;
import com.zyh.pro.palettes.main.core.view.KeyEvent.KeyListener;
import com.zyh.pro.palettes.main.rhythms.Chain;
import com.zyh.pro.palettes.main.rhythms.Rhythm;
import com.zyh.pro.palettes.main.rhythms.RhythmChain;
import com.zyh.pro.taskscheduler.main.Schedulers;
import com.zyh.pro.taskscheduler.main.TaskScheduler;

import java.io.FileNotFoundException;

import static com.zyh.pro.palettes.main.rhythms.RhythmChain.load;

public class RhythmAnimationTest {

	private static RhythmBallRole ball;

	public static void main(String[] args) throws FileNotFoundException {
		CompositeRole role = new ClearRole(0);
		RoleStage stage = new RoleStage(new D2DPalettesFactory(1000, 600), role);
		stage.addKeyListener(new KeyListener() {
			@Override
			public void onDown(KeyEvent keyEvent) {
				ball.animate();
			}
			@Override
			public void onUp(KeyEvent keyEvent) {

			}
		});
		FadeRole container = new FadeRole(0x063A66);
		stage.addRole(container);

		ball = new RhythmBallRole(stage.getTarget());
		container.addRole(ball);

		Chain<Rhythm> rhythmChain = new Chain.Builder<Rhythm>()
				.next(ball.getChainConsumer())
				.next(container.getChainConsumer())
				.build();

		RhythmChain chain = load(Files.toString("C:\\Users\\Remain\\IdeaProjects\\Palettes\\src\\com\\zyh\\pro\\palettes\\test\\second.rhy"));

		TaskScheduler scheduler = Schedulers.track(chain.getRhythms(), rhythmChain::consume);
		scheduler.shutdown();
		scheduler.start();
	}
}
