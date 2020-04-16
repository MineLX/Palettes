package com.zyh.pro.palettes.main.rhythms;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class RhythmChain {

	private final List<Rhythm> rhythms;

	public RhythmChain() {
		rhythms = new ArrayList<>();
	}

	public void add(long delay, String item, String command, String rate) {
		rhythms.add(new Rhythm(delay, item, command, rate));
	}

	public void add(Rhythm rhythm) {
		rhythms.add(rhythm);
	}

	public String dump() {
		StringBuilder result = new StringBuilder();
		rhythms.forEach(rhythm -> {
			result.append(rhythm.toString());
			result.append("\r\n");
		});
		return result.toString();
	}

	public void dump(PrintStream stream) {
		rhythms.forEach(stream::println);
	}

	public List<Rhythm> getRhythms() {
		return rhythms;
	}

	public static RhythmChain load(String target) {
		RhythmChain result = new RhythmChain();
		for (String line : target.split("\r\n")) {
			String[] info = line.split(valueOf(Rhythm.DELIMITER_PART));
			String[] detail = info[1].split(valueOf(Rhythm.DELIMITER_DETAIL));
			result.add(Long.parseLong(info[0]), detail[0], detail[1], detail[2]);
		}
		return result;
	}
}
