package com.zyh.pro.palettes.main.rhythms;

import java.util.function.Consumer;

public class RhythmConsumer extends Chain<Rhythm> {

	private final String item;

	private final Consumer<Rhythm> consumer;

	public RhythmConsumer(String item, Consumer<Rhythm> consumer) {
		this.item = item;
		this.consumer = consumer;
	}

	@Override
	protected boolean isConsumable(Rhythm rhythm) {
		return item.equals(rhythm.getItem());
	}

	@Override
	protected void onConsume(Rhythm rhythm) {
		consumer.accept(rhythm);
	}
}
