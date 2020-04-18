package com.zyh.pro.palettes.main;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class View extends Role {

	private final OffsetPalette offsetPalette;

	protected final Params params;

	int x;

	int y;

	private int width;

	private int height;

	private final MeasureSpec widthSpec;

	private final MeasureSpec heightSpec;

	public View(Map<String, String> attributes) {
		offsetPalette = new OffsetPalette(this);

		params = new Params(attributes);

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
		width = widthSpec.measure(remainderWidth, getContentWidth(remainderWidth), params.widthSpecParam);
	}

	protected void measureHeight(int remainderHeight) {
		height = heightSpec.measure(remainderHeight, getContentHeight(remainderHeight), params.heightSpecParam);
	}

	protected int getContentHeight(int remainderHeight) {
		return 0;
	}

	protected int getContentWidth(int remainderWidth) {
		return 0;
	}

	protected void layout(int recommendedX, int recommendedY) {
		setLocation(recommendedX + params.marginParam, recommendedY + params.marginParam);
	}

	public int getBoundWidth() {
		return getWidth() + params.marginParam * 2;
	}

	public int getBoundHeight() {
		return getHeight() + params.marginParam * 2;
	}

	@Override
	public String toString() {
		return "View(" + x + ", " + y + ", " + getWidth() + ", " + getHeight() + ")";
	}

	public static class Params {
		// FIXME 2020/4/17  wait for me!!!  private and getters

		int widthSpecParam;

		int heightSpecParam;

		int marginParam;

		protected Params(Map<String, String> attributes) {
			initAttributes(attributes);
		}

		private void initAttributes(Map<String, String> attributes) { // FIXME 2020/4/16  wait for me!!!  LayoutParams  Reflection assign
			String widthAsText = attributes.get("width");
			String heightAsText = attributes.get("height");
			String marginAsText = attributes.get("margin");
			widthSpecParam = widthAsText != null ? parseInt(widthAsText) : -1;
			heightSpecParam = heightAsText != null ? parseInt(heightAsText) : -1;
			marginParam = marginAsText != null ? parseInt(marginAsText) : 0;
		}
	}
}
