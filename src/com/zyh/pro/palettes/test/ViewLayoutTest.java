package com.zyh.pro.palettes.test;

import com.zyh.pro.palettes.main.core.view.LinearLayout;
import com.zyh.pro.palettes.main.core.view.MotionEvent;
import com.zyh.pro.palettes.main.core.view.RectView;
import com.zyh.pro.palettes.main.core.view.View;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.zyh.pro.palettes.main.core.view.MotionEvent.MotionType.*;
import static com.zyh.pro.palettes.main.core.view.MotionEvent.get;
import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ViewLayoutTest {

	@Test
	public void edge_only_layout() {
		LinearLayout layout = getFullScreenLinearLayout(LinearLayout.HORIZONTAL);
		testMotion(layout, false, 0, 0, DOWN);
		testMotion(layout, false, 0, 0, MOVE);
		testMotion(layout, false, 0, 0, UP);
		testMotion(layout, false, 0, 0, DOWN);
		testMotion(layout, false, 0, 0, MOVE);
		testMotion(layout, false, 0, 0, UP);
	}

	@Test
	public void move_event() {
		LinearLayout layout = getEventTestLayout();

		testMotion(layout, true, 0, 0, DOWN);
		testMotion(layout, true, 0, 0, MOVE);
		testMotion(layout, true, 1, 1, MOVE);
		testMotion(layout, true, 4, 2, MOVE);
		testMotion(layout, true, 999, 999, MOVE);
		testMotion(layout, true, 6666, 6666, MOVE);
		testMotion(layout, true, 0, 0, UP);
		testMotion(layout, false, 0, 0, MOVE);
	}

	@Test
	public void down_event_out_of_viewBound() {
		LinearLayout linearLayout = getEventTestLayout();
		testMotion(linearLayout, true, 0, 0, DOWN);
		testMotion(linearLayout, true, 0, 0, UP);

		testMotion(linearLayout, false, 0, 51, DOWN);
		testMotion(linearLayout, false, 0, 50, UP);
	}

	@Test
	public void click_event() {
		LinearLayout verticalLayout = getEventTestLayout();

		testMotion(verticalLayout, true, 10, 20, DOWN);
		testMotion(verticalLayout, true, 10, 20, UP);
	}

	private void testMotion(LinearLayout linearLayout, boolean expected, int x, int y, MotionEvent.MotionType type) {
		assertThat(linearLayout.dispatchMotionEvent(get(type, x, y)), is(expected));
	}

	@Test
	public void layout_wrap_content_overflow() {
		HashMap<String, String> attributes = getAttributes("-2", "-2");
		attributes.put("orientation", "" + LinearLayout.HORIZONTAL);
		LinearLayout layout = new LinearLayout(attributes);

		View overflowView1 = getContentWidthView(999, "10", "0");
		layout.addChild(overflowView1);
		View overflowView2 = getContentWidthView(10, "10", "0");
		layout.addChild(overflowView2);

		layout.measure(50, 90);
		layout.layout(0, 0);

		verifyRect(overflowView2, 51, 0, 10, 10);
		verifyRect(overflowView1, 0, 0, 50, 10);
		verifyRect(layout, 0, 0, 50, 20);
	}

	@Test
	public void layout_contentSize_with_children() {
		HashMap<String, String> groupAttributes = getAttributes("-2", "-2");
		groupAttributes.put("margin", "2");
		groupAttributes.put("orientation", "" + LinearLayout.VERTICAL);
		LinearLayout layout = new LinearLayout(groupAttributes);

		View marginView = getMarginView("10", "20", "0");
		layout.addChild(marginView);
		View marginView2 = getMarginView("10", "20", "0");
		layout.addChild(marginView2);

		layout.measure(50, 90);
		layout.layout(0, 0);

		System.out.println("layout = " + layout);
		verifyRect(marginView, 0, 0, 10, 20);
		verifyRect(marginView2, 0, 21, 10, 20);
		verifyRect(layout, 2, 2, 16, 36);
	}

	@Test
	public void multi_groups() {
		String measureWidth = "100";
		String measureHeight = "170";
		LinearLayout listGroup = getFullScreenLinearLayout(LinearLayout.VERTICAL);
		Map<String, String> groupAttributes = getAttributes("-1", "-1");
		groupAttributes.put("orientation", "" + LinearLayout.HORIZONTAL);
		groupAttributes.put("margin", "20");
		LinearLayout bannerGroup = new LinearLayout(groupAttributes);

		View marginView = getMarginView("-1", "30", "5");

		bannerGroup.addChild(marginView);
		listGroup.addChild(bannerGroup);

		listGroup.measure(parseInt(measureWidth), parseInt(measureHeight));
		listGroup.layout(0, 0);

		verifyRect(listGroup, 0, 0, 100, 170);
		verifyRect(bannerGroup, 20, 20, 60, 130);
		verifyRect(marginView, 5, 5, 50, 30);
	}

	@Test
	public void margin() {
		View child1 = getMarginView("-1", "20", "5");
		View child2 = getMarginView("-1", "51", "5");

		LinearLayout group = getFullScreenLinearLayout(LinearLayout.VERTICAL);
		group.addChild(child1);
		group.addChild(child2);

		group.measure(50, 50);
		group.layout(0, 0);

		assertThat(child1.getX(), is(5));
		assertThat(child1.getY(), is(5));
		assertThat(child1.getWidth(), is(50 - 10));
		assertThat(child1.getHeight(), is(20));

		assertThat(child2.getX(), is(5));
		assertThat(child2.getY(), is(36));
		assertThat(child2.getWidth(), is(50 - 10));
		assertThat(child2.getHeight(), is(51));
	}

	@Test
	public void measure_match_parent() {
		View child = getMarginView("-1", "-1", "5");
		child.measure(50, 60);

		verifyBound(child, 40, 50, 50, 60);
	}

	@Test
	public void measure_wrap_content_beyond() {
		View child = getContentWidthView(66, "51", "5");
		child.measure(50, 60);

		verifyBound(child, 40, 51, 50, 61);
	}

	@Test
	public void measure_exactly() {
		View child = getMarginView("10", "20", "5");
		child.measure(50, 60);

		verifyBound(child, 10, 20, 20, 30);
	}

	@Test
	public void getBoundWidth_and_Height() {
		View child = getMarginView("-1", "20", "5");

		LinearLayout group = getFullScreenLinearLayout(LinearLayout.VERTICAL);
		group.addChild(child);

		group.measure(50, 60);
		group.layout(0, 0);

		assertThat(child.getX(), is(5));
		assertThat(child.getY(), is(5));
		verifyBound(child, 40, 20, 50, 30);
	}

	@Test
	public void layout() {
		LinearLayout group = getFullScreenLinearLayout(LinearLayout.VERTICAL);

		HashMap<String, String> childAttributes = getAttributes("-1", "66");
		View child = new View(childAttributes);
		View child2 = new View(childAttributes);

		group.addChild(child);
		group.addChild(child2);
		group.measure(50, 90);
		group.layout(0, 0);

		assertThat(group.getX(), is(0));
		assertThat(group.getY(), is(0));
		assertThat(child.getX(), is(0));
		assertThat(child.getY(), is(0));
		assertThat(child2.getX(), is(0));
		assertThat(child2.getY(), is(67));
	}

	@Test
	public void group_measure() {
		LinearLayout group = getFullScreenLinearLayout(LinearLayout.VERTICAL);

		HashMap<String, String> childAttributes = getAttributes("-1", "66");
		View child = new View(childAttributes);

		group.addChild(child);
		group.measure(50, 90);

		assertThat(group.getWidth(), is(50));
		assertThat(group.getHeight(), is(90));
		assertThat(child.getWidth(), is(50));
		assertThat(child.getHeight(), is(66));
	}

	@Test
	public void child_measure() {
		HashMap<String, String> map = getAttributes("-1", "-2");
		View view = new View(map);
		view.measure(50, 90);

		verifyRect(view, 0, 0, 50, 0);
	}

	private HashMap<String, String> getAttributes(String width, String height) {
		HashMap<String, String> childAttributes = new HashMap<>();
		childAttributes.put("widthSpec", width);
		childAttributes.put("heightSpec", height);
		return childAttributes;
	}

	private LinearLayout getFullScreenLinearLayout(int orientation) {
		Map<String, String> groupAttributes = getAttributes("-1", "-1");
		groupAttributes.put("orientation", "" + orientation);
		return new LinearLayout(groupAttributes);
	}

	private View getMarginView(String width, String height, String margin) {
		HashMap<String, String> attributes = getAttributes(width, height);
		attributes.put("margin", margin);
		return new View(attributes);
	}

	private View getContentWidthView(final int contentWidth, String height, String margin) {
		HashMap<String, String> attributes = getAttributes("-2", height);
		attributes.put("margin", margin);
		return new View(attributes) {
			@Override
			protected int getContentWidth(int remainderWidth) {
				return contentWidth;
			}
		};
	}

	private void verifyBound(View child, int width, int height, int boundWidth, int boundHeight) {
		assertThat(child.getWidth(), is(width));
		assertThat(child.getHeight(), is(height));
		assertThat(child.getBoundWidth(), is(boundWidth));
		assertThat(child.getBoundHeight(), is(boundHeight));
	}

	private void verifyRect(View view, int x, int y, int width, int height) {
		assertThat(view.getX(), is(x));
		assertThat(view.getY(), is(y));
		assertThat(view.getWidth(), is(width));
		assertThat(view.getHeight(), is(height));
	}

	private LinearLayout getEventTestLayout() {
		LinearLayout result = getFullScreenLinearLayout(LinearLayout.VERTICAL);
		RectView child = new RectView(getAttributes("-1", "50"), 0xff00ff);
		result.addChild(child);
		result.measure(60, 100);
		result.layout(0, 0);
		return result;
	}
}
