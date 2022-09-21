package com.github.dapitramdhan;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

public class FragmentAkun extends Fragment {

	private Toolbar akunToolbar;
	private Drawable drawableToolbar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_akun, container, false);
	//	getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.colorPrimary));
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		akunToolbar = view.findViewById(R.id.akunToolbar);
		akunToolbar.setTitle("Akun");
		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(akunToolbar);
		((ToolbarFadeOnScrolling) view.findViewById(R.id.scrollview_akun)).setOnScrollChangedListener(mScroll);
		
		drawableToolbar = getResources().getDrawable(R.drawable.warna_utama);
		akunToolbar.setBackgroundDrawable(drawableToolbar);
		drawableToolbar.setAlpha(0);
	}
	private ToolbarFadeOnScrolling.OnScrollChangedListener mScroll = new ToolbarFadeOnScrolling.OnScrollChangedListener(){
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt){
			final int headerHeight = akunToolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			drawableToolbar.setAlpha(newAlpha);
		}
	};
}