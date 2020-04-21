package com.zyh.pro.palettes.main.core.role;

import com.zyh.pro.palettes.main.core.IPalette;
import com.zyh.pro.palettes.main.core.view.MotionEvent;

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

	protected void onBackground(IPalette palette) {
	}

	public void addRole(Role role) {
		children.add(role);
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		if (onDispatchMotionEvent()) return true;

		return children.stream().anyMatch(role -> role.dispatchMotionEvent(event));
	}

	protected boolean onDispatchMotionEvent() {
		return false;
	}
}
