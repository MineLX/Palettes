package com.zyh.pro.palettes.main;

import com.zyh.pro.animator.main.animators.Animator;
import com.zyh.pro.animator.main.animators.CompositeAnimatorBuilder;
import com.zyh.pro.animator.main.animators.GetterAnimatorBuilder;
import com.zyh.pro.animator.main.animators.ToggleAnimatorBuilder;

public class BallRole extends Role {

	private static final int START_RADIUS = 100;

	private static final int END_RADIUS = 170;

	private final Animator animator;

	private Oval ball;

	public BallRole(Context context) {
		ball = new Oval(context.width / 2, context.height / 2, START_RADIUS, START_RADIUS);

		animator = new ToggleAnimatorBuilder().addToggle( // FIXME 2020/4/11  wait for me!!!  getter for toggle operation
				new CompositeAnimatorBuilder()
						.with(new GetterAnimatorBuilder<>(this::cloneCurrentBall, this::createEnd, new Oval.OvalEvaluator())
								.addUpdater(oval -> ball = oval)
								.setDuration(150))
						.after(new GetterAnimatorBuilder<>(this::cloneCurrentBall, this::createStart, new Oval.OvalEvaluator())
								.addUpdater(oval -> ball = oval)
								.setDuration(300))
		).build();
	}

	@Override
	protected void onDraw(IPalette palette) {
		palette.fillOval(ball.getCenterX() + 2, ball.getCenterY() + 5, ball.getRadiusX(), ball.getRadiusY(), 0x992266);
		palette.fillOval(ball, 0xFC009C);
	}

	public void animate() {
		animator.start();
	}

	private Oval cloneCurrentBall() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), ball.getRadiusX(), ball.getRadiusY());
	}

	private Oval createStart() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), START_RADIUS, START_RADIUS);
	}

	private Oval createEnd() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), END_RADIUS, END_RADIUS);
	}
}
