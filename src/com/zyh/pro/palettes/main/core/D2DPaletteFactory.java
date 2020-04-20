package com.zyh.pro.palettes.main.core;

import javax.swing.*;

public class D2DPaletteFactory extends FramePaletteFactory {
	@Override
	protected IPalette createPaletteByFrame(Context context, JFrame frame) {
		return new D2DPalette(context, frame);
	}
}
