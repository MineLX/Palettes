package com.zyh.pro.palettes.main;

import com.zyh.pro.palettes.main.rhythms.Rhythm;

import java.util.function.Consumer;

public class RhythmConsumer extends Chain<Rhythm> {

	private final String item;

	private Consumer<Rhythm> consumer;

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
		if (consumer != null)
			consumer.accept(rhythm);
	}
}
