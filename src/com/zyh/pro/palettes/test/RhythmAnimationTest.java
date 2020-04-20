package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.D2DPaletteFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.role.ColorRole;
import com.zyh.pro.palettes.main.core.role.RhythmBallRole;
import com.zyh.pro.palettes.main.rhythms.Chain;
import com.zyh.pro.palettes.main.rhythms.Rhythm;
import com.zyh.pro.palettes.main.rhythms.RhythmChain;
import com.zyh.pro.taskscheduler.main.Schedulers;
import com.zyh.pro.taskscheduler.main.TaskScheduler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import static com.zyh.pro.palettes.main.rhythms.RhythmChain.load;

public class RhythmAnimationTest {

	private static RhythmBallRole ball;

	public static void main(String[] args) throws FileNotFoundException {
		D2DPaletteFactory paletteFactory = new D2DPaletteFactory();
		paletteFactory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ball.animate();
			}
		});
		Stage stage = new Stage(paletteFactory, 1000, 600, 0);
		ColorRole container = new ColorRole(0x063A66);
		stage.addRole(container);

		ball = new RhythmBallRole(stage.getContext());
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
