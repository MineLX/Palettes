package com.zyh.pro.palettes.main;

import com.zyh.pro.animator.main.animators.*;
import com.zyh.pro.animator.main.animators.valueanimator.ValueAnimatorBuilder;
import com.zyh.pro.palettes.main.rhythms.Rhythm;

public class RhythmBallRole extends Role {

	private static final int START_RADIUS = 100;

	private static final int END_RADIUS = 170;

	private final Animator animator;

	private Oval ball;

	public RhythmBallRole(Context context) {
		ball = new Oval(context.width / 2, context.height / 2, START_RADIUS, START_RADIUS);

		animator = new ToggleAnimatorBuilder()
				.addToggle(new RepeatableAnimator(() ->
						new CompositeAnimatorBuilder()
								.with(getStartAnimator())
								.after(getEndAnimator())
								.build()))
				.build();
		int centerX = ball.getCenterX();
		int centerY = ball.getCenterY();
		Animator animator = Animators.justDoIt(() -> ball.rotate(centerX - 100, centerY, 1));
		context.addCleanUp(animator::stop);
		animator.start();
	}

	private DurationAnimatorBuilder getStartAnimator() {
		return new ValueAnimatorBuilder()
				.setDuration(150)
				.getterOrder(new Oval.OvalEvaluator(), this::cloneCurrentBall, this::createEnd, oval -> ball = oval);
	}

	private DurationAnimatorBuilder getEndAnimator() {
		return new ValueAnimatorBuilder()
				.setDuration(300)
				.getterOrder(new Oval.OvalEvaluator(), this::cloneCurrentBall, this::createStart, oval -> ball = oval);
	}

	@Override
	protected void onDraw(IPalette palette) {
		// FIXME 2020/4/15  wait for me!!!   rectangle fillRect should be a 4 points params method.
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

	public Chain<Rhythm> getChainConsumer() {
		return new Chain<Rhythm>() {
			@Override
			protected boolean isConsumable(Rhythm rhythm) {
				return rhythm.getItem().equals("ball");
			}

			@Override
			protected void onConsume(Rhythm rhythm) {
				animate();
			}
		};
	}
}
