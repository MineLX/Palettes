package com.zyh.pro.palettes.main.core;

import javax.swing.*;

public class D2DPalettesFactory extends FramePalettesFactory {

	public D2DPalettesFactory(int width, int height) {
		super(width, height);
	}

	@Override
	protected IPalette createPaletteByFrame(IPalettesTarget target, JFrame frame) {
		return new D2DPalette(target, frame);
	}

}
