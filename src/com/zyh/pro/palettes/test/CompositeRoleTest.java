package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.AwtPalettesFactory;
import com.zyh.pro.palettes.main.core.D2DPalettesFactory;
import com.zyh.pro.palettes.main.core.Stage;
import com.zyh.pro.palettes.main.core.role.ClearRole;
import com.zyh.pro.palettes.main.core.role.CompositeRole;
import com.zyh.pro.palettes.main.core.role.LineRole;
import com.zyh.pro.palettes.main.core.role.RectRole;

public class CompositeRoleTest {
	public static void main(String[] args) throws InterruptedException {
		LineRole line = new LineRole(0, 0, 900, 500, 0x7053FF);
		RectRole rect = new RectRole(0, 0, 900, 500, 0x85C7FF);

		CompositeRole compositeRole = new ClearRole(0xFF009E);
		compositeRole.addRole(rect);
		compositeRole.addRole(line);

		Stage stage = new Stage(new AwtPalettesFactory(1000, 600), 0);
		stage.addRole(compositeRole);

		Thread.sleep(5000);
		rect.hide();
		Thread.sleep(2000);
		rect.show();
	}
}
