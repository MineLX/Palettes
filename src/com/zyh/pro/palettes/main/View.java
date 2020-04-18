package com.zyh.pro.palettes.main;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class View extends Role {

	private final OffsetPalette offsetPalette;

	private final ViewParams params;

	int x;

	int y;

	private int width;

	private int height;

	private final MeasureSpec widthSpec;

	private final MeasureSpec heightSpec;

	public View(Map<String, String> attributes) {
		offsetPalette = new OffsetPalette(this);

		params = new ViewParams(attributes);

		widthSpec = createWidthSpec();
		heightSpec = createHeightSpec();
	}

	protected MeasureSpec createHeightSpec() {
		return new MeasureSpec(params);
	}

	protected MeasureSpec createWidthSpec() {
		return new MeasureSpec(params);
	}

	@Override
	protected final void onDraw(IPalette palette) {
		offsetPalette.setDecorated(palette);
		onViewDraw(offsetPalette);
	}

	protected void onViewDraw(IPalette palette) {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ViewParams getParams() {
		return params;
	}

	public void setBound(int x, int y, int width, int height) {
		setLocation(x, y);
		setSize(width, height);
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void measure(int remainderWidth, int remainderHeight) {
		measureWidth(remainderWidth);
		measureHeight(remainderHeight);
	}

	protected void measureWidth(int remainderWidth) {
		width = widthSpec.measure(remainderWidth, getContentWidth(remainderWidth), params.getWidthSpec());
	}

	protected void measureHeight(int remainderHeight) {
		height = heightSpec.measure(remainderHeight, getContentHeight(remainderHeight), params.getHeightSpec());
	}

	protected int getContentHeight(int remainderHeight) {
		return 0;
	}

	protected int getContentWidth(int remainderWidth) {
		return 0;
	}

	protected void layout(int recommendedX, int recommendedY) {
		setLocation(recommendedX + params.getMargin(), recommendedY + params.getMargin());
	}

	public int getBoundWidth() {
		return getWidth() + params.getMargin() * 2;
	}

	public int getBoundHeight() {
		return getHeight() + params.getMargin() * 2;
	}

	@Override
	public String toString() {
		return "View(" + x + ", " + y + ", " + getWidth() + ", " + getHeight() + ")";
	}

	public static class ViewParams {

		private int widthSpec;

		private int heightSpec;

		private int margin;

		ViewParams(Map<String, String> attributes) {
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
