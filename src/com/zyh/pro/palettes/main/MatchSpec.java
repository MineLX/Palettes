package com.zyh.pro.palettes.main;

public class MatchSpec {

	protected final View.Params params;

	MatchSpec(View.Params params) {
		this.params = params;
	}

	public int measure(int remainder) {
		return remainder - params.marginParam * 2;
	}
}
