package com.zyh.pro.palettes.main.core;

import javax.swing.*;

public class AwtPalettesFactory extends FramePalettesFactory {

	public AwtPalettesFactory(int width, int height) {
		super(width, height);
	}

	@Override
	protected IPalette createPaletteByFrame(IPalettesTarget target, JFrame frame) {
		return new AWTPalette(target, frame);
	}

}
