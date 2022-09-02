package com.github.dapitramdhan;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import android.view.WindowInsets;
import android.widget.RelativeLayout;

public class WindowInsetsFrameLayout extends RelativeLayout {
	public WindowInsetsFrameLayout(Context context) {
		super(context);
	}

	public WindowInsetsFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public WindowInsetsFrameLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
	@Override
	public WindowInsets onApplyWindowInsets(WindowInsets insets) {
		int childCount = getChildCount();
		for (int index = 0; index < childCount; index++)
			getChildAt(index).dispatchApplyWindowInsets(insets); // let children know about WindowInsets

		return insets;
	}

}