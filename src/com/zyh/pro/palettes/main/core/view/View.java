package com.zyh.pro.palettes.main.core.view;

import com.zyh.pro.palettes.main.core.IPalette;
import com.zyh.pro.palettes.main.core.role.Role;
import com.zyh.pro.palettes.main.common.ReflectObject;

import java.util.Map;

import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.DOWN;
import static java.lang.Integer.parseInt;

public class View extends Role implements MotionEvent.MotionListener, I2D {

	private final OffsetPalette offsetPalette;

	private final Params params;

	int x;

	int y;

	protected final MeasureSpec widthSpec;

	protected final MeasureSpec heightSpec;

	private final Pointer pointer;

	public View(Map<String, String> attributes) {
		offsetPalette = new OffsetPalette(this);
		pointer = new Pointer();

		params = new Params(attributes);

		widthSpec = createSpec(new MeasureParams(params.getWidthSpec(), params.margin));
		heightSpec = createSpec(new MeasureParams(params.getHeightSpec(), params.margin));
	}

	protected MeasureSpec createSpec(MeasureParams measureParams) {
		return new MeasureSpec(measureParams);
	}

	@Override
	protected final void onDraw(IPalette palette) {
		offsetPalette.setDecorated(palette);
		onViewDraw(offsetPalette);
	}

	protected void onViewDraw(IPalette palette) {
	}

	public final void measure(int remainderWidth, int remainderHeight) {
		widthSpec.measure(remainderWidth);
		heightSpec.measure(remainderHeight);
	}

	public void layout(int recommendedX, int recommendedY) {
		layoutSelf(recommendedX, recommendedY);
	}

	protected void layoutSelf(int recommendedX, int recommendedY) {
		setLocation(recommendedX + params.getMargin(), recommendedY + params.getMargin());
	}

	@Override
	public boolean dispatchMotionEvent(MotionEvent event) {
		if ((event.getType() == DOWN)
				&& !collidedTo(event.getX(), event.getY()))
			return false;

		return event.getType().onMotion(event, this);
	}

	private boolean collidedTo(int x, int y) {
		return x >= getX()
				&& x <= getX() + getWidth()
				&& y >= getY()
				&& y <= getY() + getHeight();
	}

	@Override
	public final boolean motionUp(MotionEvent event) {
		if (pointer.up())
			return onMotionUp(event);
		return false;
	}

	@Override
	public final boolean motionDown(MotionEvent event) {
		return pointer.down() && onMotionDown(event);
	}

	@Override
	public final boolean motionMove(MotionEvent event) {
		return pointer.move() && onMotionMove(event);
	}

	protected boolean onMotionMove(MotionEvent event) {
		return true;
	}

	protected boolean onMotionUp(MotionEvent event) {
		return true;
	}

	protected boolean onMotionDown(MotionEvent event) {
		return true;
	}

	public Params getParams() {
		return params;
	}

	public int getBoundWidth() {
		return widthSpec.getBoundSize();
	}

	public int getBoundHeight() {
		return heightSpec.getBoundSize();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return widthSpec.getMeasuredValue();
	}

	@Override
	public int getHeight() {
		return heightSpec.getMeasuredValue();
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setWidth(int width) {
		widthSpec.setMeasuredValue(width);
	}

	@Override
	public void setHeight(int height) {
		heightSpec.setMeasuredValue(height);
	}

	@Override
	public String toString() {
		return "View(" + x + ", " + y + ", " + getWidth() + ", " + getHeight() + ")";
	}

	public static class Params {

		private int widthSpec;

		private int heightSpec;

		private int margin;

		Params(Map<String, String> attributes) {
			heightSpec = -1;
			widthSpec = -1;
			margin = 0;

			ReflectObject setter = new ReflectObject(this);
			setter.setWith(attributes);
		}

		public int getWidthSpec() {
			return widthSpec;
		}

		public int getHeightSpec() {
			return heightSpec;
		}

		public int getMargin() {
			return margin;
		}

		public void setWidthSpec(String widthSpec) {
			this.widthSpec = parseInt(widthSpec);
		}

		public void setHeightSpec(String heightSpec) {
			this.heightSpec = parseInt(heightSpec);
		}

		public void setMargin(String margin) {
			this.margin = parseInt(margin);
		}

	}
}
