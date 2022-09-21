package com.github.dapitramdhan;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FeedFragment extends Fragment {

	private Toolbar feedToolbar;
	BottomSheetBehavior bottomSheetBehavior;
	BottomSheetDialog bottomSheetDialog;
	View bottom_sheet;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.feed_fragment, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		feedToolbar = view.findViewById(R.id.feedToolbar);
		feedToolbar.setTitle("Feed");
		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(feedToolbar);

		}

}