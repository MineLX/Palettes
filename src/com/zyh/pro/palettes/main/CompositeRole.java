package com.zyh.pro.palettes.main;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeRole extends Role {

	private final List<Role> children;

	public CompositeRole() {
		children = new ArrayList<>();
	}

	@Override
	protected final void onDraw(IPalette palette) {
		onBackground(palette);
		for (Role child : children)
			child.draw(palette);
	}

	protected abstract void onBackground(IPalette palette);

	public void addRole(Role role) {
		children.add(role);
	}
}
