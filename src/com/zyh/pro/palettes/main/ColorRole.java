package com.zyh.pro.palettes.main;

import com.zyh.pro.animator.main.animators.valueanimator.ValueAnimatorBuilder;
import com.zyh.pro.animator.main.animators.valueanimator.evaluations.ColorEvaluator;
import com.zyh.pro.palettes.main.rhythms.Rhythm;

import java.awt.*;

public class ColorRole extends CompositeRole {

	private int color;

	public ColorRole(int color) {
		this.color = color;
	}

	@Override
	protected void onBackground(IPalette palette) {
		palette.clear(color);
	}

	public void fadeTo(int toColor) {
		new ValueAnimatorBuilder()
				.objectOrder(new ColorEvaluator(), new Color(color), new Color(toColor), this::setColor)
				.build().start();
	}

	private void setColor(Color color) {
		this.color = color.getRGB();
	}

	public Chain<Rhythm> getChainConsumer() {
		return new Chain<Rhythm>() {
			@Override
			protected boolean isConsumable(Rhythm rhythm) {
				return rhythm.getItem().equals("background");
			}

			@Override
			protected void onConsume(Rhythm rhythm) {
				fadeTo((int) Long.parseLong(rhythm.getRate().substring(2), 16));
			}
		};
	}
}
