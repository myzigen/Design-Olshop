package com.github.dapitramdhan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class FragmentFeed extends Fragment {

	private Toolbar feedToolbar;

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