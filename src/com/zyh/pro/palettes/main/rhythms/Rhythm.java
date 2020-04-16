package com.zyh.pro.palettes.main.rhythms;

import com.zyh.pro.taskscheduler.main.SelfScheduled;

public class Rhythm implements SelfScheduled<Rhythm> {

	static final char DELIMITER_DETAIL = ':';

	static final char DELIMITER_PART = ',';

	private final long delay;

	private final String item;

	private final String command;

	private final String rate;

	public Rhythm(long delay, String item, String command, String rate) {
		this.delay = delay;
		this.item = item;
		this.command = command;
		this.rate = rate;
	}

	@Override
	public long getDelay() {
		return delay;
	}

	@Override
	public Rhythm self() {
		return this;
	}

	public String getItem() {
		return item;
	}

	public String getCommand() {
		return command;
	}

	public String getRate() {
		return rate;
	}

	@Override
	public String toString() {
		return String.valueOf(delay) +
				DELIMITER_PART +
				item +
				DELIMITER_DETAIL +
				command +
				DELIMITER_DETAIL +
				rate;
	}
}
