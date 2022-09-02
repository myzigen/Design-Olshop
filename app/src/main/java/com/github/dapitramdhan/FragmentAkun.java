package com.github.dapitramdhan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class FragmentAkun extends Fragment {

	private Toolbar akunToolbar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_akun, container, false);
		getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.colorPrimary));
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		akunToolbar = view.findViewById(R.id.akunToolbar);
		akunToolbar.setTitle("Akun");
		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(akunToolbar);
	}
}