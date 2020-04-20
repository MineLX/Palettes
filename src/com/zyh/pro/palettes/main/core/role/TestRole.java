package com.zyh.pro.palettes.main.core.role;

import com.zyh.pro.animator.main.animators.valueanimator.ValueAnimator;
import com.zyh.pro.animator.main.animators.valueanimator.ValueAnimatorBuilder;
import com.zyh.pro.animator.main.animators.valueanimator.loopmodes.LoopMode;
import com.zyh.pro.palettes.main.core.Context;
import com.zyh.pro.palettes.main.core.IPalette;
import com.zyh.pro.palettes.main.core.IPalettesTarget;
import com.zyh.pro.palettes.main.shapebean.Oval;

public class TestRole extends Role {

	private Oval oval;

	public TestRole(Context context) {
		oval = getStart(context.width, context.height);

		ValueAnimator animator = new ValueAnimatorBuilder()
				.setLoopMode(LoopMode.infinity_reversed())
				.objectOrder(new Oval.OvalEvaluator(), getStart(context.width, context.height), getEnd(context.width, context.height), this::setOval)
				.build();
		context.addCleanUp(animator::stop);
		animator.start();
	}

	public TestRole(IPalettesTarget target) {
		oval = getStart(target.getWidth(), target.getHeight());

		ValueAnimator animator = new ValueAnimatorBuilder()
				.setLoopMode(LoopMode.infinity_reversed())
				.objectOrder(new Oval.OvalEvaluator(), getStart(target.getWidth(), target.getHeight()), getEnd(target.getWidth(), target.getHeight()), this::setOval)
				.build();
		target.addShutdownCleanUp(animator::stop);
		animator.start();
	}

	private void setOval(Oval oval) {
		this.oval = oval;
	}

	private Oval getStart(int width, int height) {
		return new Oval(width / 2, height / 2, 200, 200);
	}

	private Oval getEnd(int width, int height) {
		return new Oval(width / 2 - 100, height / 2 - 100, 100, 100);
	}

	@Override
	protected void onDraw(IPalette palette) {
		palette.clear(0x85C7FF);
		palette.fillOval(oval.getCenterX(), oval.getCenterY(), oval.getRadiusX(), oval.getRadiusY(), 0x775AC7);
	}
}
