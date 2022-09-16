package com.github.dapitramdhan;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.internal.BaselineLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigationrail.NavigationRailView;
import com.google.android.material.textview.MaterialTextView;

public class FragmentKategori extends Fragment {

	private Toolbar feedToolbar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.kategori_fragment, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		feedToolbar = view.findViewById(R.id.feedToolbar);
		feedToolbar.setTitle("Kategori");
		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(feedToolbar);
		
	

	
	}
}