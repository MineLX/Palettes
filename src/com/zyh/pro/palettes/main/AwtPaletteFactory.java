package com.zyh.pro.palettes.main;

import javax.swing.*;

public class AwtPaletteFactory extends FramePaletteFactory {

	@Override
	protected IPalette createPaletteByFrame(Context context, JFrame frame) {
		return new AWTPalette(context, frame);
	}
}
