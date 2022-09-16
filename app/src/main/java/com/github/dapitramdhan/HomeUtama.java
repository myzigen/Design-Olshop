package com.github.dapitramdhan;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.github.dapitramdhan.ProdukActivity.Produk;
import com.github.dapitramdhan.ProdukActivity.ProdukAdapter;
import com.google.android.material.button.MaterialButton;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeUtama extends Fragment implements ProdukAdapter.OnItemClickListener {

	private Toolbar toolbar;
	private Drawable mActionBarBackgroundDrawable, searchDrawable;
	private MaterialButton searchButton;
	private View mHeader;

	public static final String EXTRA_URL = "imageUrl";
	public static final String EXTRA_CREATOR = "creatorName";
	public static final String EXTRA_LIKES = "likeCount";

	private RecyclerView mRecylerView;
	private ProdukAdapter mExampleAdapter;
	private ArrayList<Produk> mExampleList;
	private RequestQueue mRequestQueue;

	String url1 = "https://lh3.googleusercontent.com/-UyYKaDd0-ng/YxMr7W7gFWI/AAAAAAAACeQ/j8dJJ2hbWuovtVgHGl8nxTFrmVlrIzT4wCNcBGAsYHQ/s1600/IMG_ORG_1662200804074.png";
	String url2 = "https://lh3.googleusercontent.com/-TZnz6NygqXM/YxM2Y1vckGI/AAAAAAAACeY/NnyDCgKcVE8OZKToX-G682kHEw-jvTXzwCNcBGAsYHQ/s1600/IMG_ORG_1662203445042.png";
	String url3 = "https://lh3.googleusercontent.com/-TZnz6NygqXM/YxM2Y1vckGI/AAAAAAAACeY/NnyDCgKcVE8OZKToX-G682kHEw-jvTXzwCNcBGAsYHQ/s1600/IMG_ORG_1662203445042.png";
	String url4 = "https://lh3.googleusercontent.com/-TZnz6NygqXM/YxM2Y1vckGI/AAAAAAAACeY/NnyDCgKcVE8OZKToX-G682kHEw-jvTXzwCNcBGAsYHQ/s1600/IMG_ORG_1662203445042.png";
	String url5 = "https://lh3.googleusercontent.com/-TZnz6NygqXM/YxM2Y1vckGI/AAAAAAAACeY/NnyDCgKcVE8OZKToX-G682kHEw-jvTXzwCNcBGAsYHQ/s1600/IMG_ORG_1662203445042.png";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_utama, container, false);
		// we are creating array list for storing our image urls.
		ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
		// initializing the slider view.
		SliderView sliderView = view.findViewById(R.id.slider);
		// adding the urls inside array list
		sliderDataArrayList.add(new SliderData(url1));
		sliderDataArrayList.add(new SliderData(url2));
		sliderDataArrayList.add(new SliderData(url3));
		sliderDataArrayList.add(new SliderData(url4));
		sliderDataArrayList.add(new SliderData(url5));
		// passing this array list inside our adapter class.
		SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);
		// below method is used to set auto cycle direction in left to
		// right direction you can change according to requirement.
		sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
		// Indicator Style (WORM, THIN_WORM, DROP, SWAP, FILL)
		sliderView.setIndicatorAnimation(IndicatorAnimationType.SWAP);
		// below method is used to
		// setadapter to sliderview.
		sliderView.setSliderAdapter(adapter);
		// below method is use to set
		// scroll time in seconds.
		sliderView.setScrollTimeInSec(3);
		// to set it scrollable automatically
		// we use below method.
		sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
		sliderView.setAutoCycle(true);
		// to start autocycle below method is used.
		sliderView.startAutoCycle();

		// seting icon kategori
		List<IconGridKategory> iconList;
		RecyclerView recyclerView1;
		recyclerView1 = view.findViewById(R.id.recylerIconKategori);
		recyclerView1.setHasFixedSize(true);
		iconList = new ArrayList<>();
		iconList.add(new IconGridKategory(1, "satu", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "dua", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "tiga", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "empat", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "lima", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "enam", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "tujuh", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "delapan", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "sembilan", R.drawable.ic_home));
		iconList.add(new IconGridKategory(1, "sepuluh", R.drawable.ic_home));
		IconGridKategoryAdapter adapter2 = new IconGridKategoryAdapter(getActivity(), iconList);
		recyclerView1.setAdapter(adapter2);

		// setting produk
		mRecylerView = view.findViewById(R.id.recylerView);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
		mRecylerView.setLayoutManager(staggeredGridLayoutManager);
		mRecylerView.setHasFixedSize(true);
		mExampleList = new ArrayList<>();
		mRequestQueue = Volley.newRequestQueue(getActivity());
		parseJSON();
		return view; 
	}

	private void parseJSON() {
		String url = "https://pixabay.com/api/?key=29711244-53ea363d58d608d7b5cd3010d&q=product&image_type=photo&pretty=true";
		// "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true"

		JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {

						try {
							JSONArray jsonArray = response.getJSONArray("hits");
							for (int i = 0; i < jsonArray.length(); i++) {
								JSONObject hit = jsonArray.getJSONObject(i);

								String creatorName = hit.getString("tags");
								String imageUrl = hit.getString("webformatURL");
								int likeCount = hit.getInt("likes");
								mExampleList.add(new Produk(imageUrl, creatorName, likeCount));

							}
							mExampleAdapter = new ProdukAdapter(getActivity(), mExampleList);
							mRecylerView.setAdapter(mExampleAdapter);
							mExampleAdapter.notifyDataSetChanged();
							mExampleAdapter.setOnItemClickListener(HomeUtama.this);

						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						error.printStackTrace();
					}
				});
		mRequestQueue.add(request);
	}

	// item click produk detail

	@Override
	public void onItemClick(int position) {
		Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
		Produk clickedItem = mExampleList.get(position);
		detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
		detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getCreator());
		detailIntent.putExtra(EXTRA_LIKES, clickedItem.getLikesCount());
		startActivity(detailIntent);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Toolbar Fade
		toolbar = view.findViewById(R.id.toolbar);
		searchButton = view.findViewById(R.id.search_home);
		mHeader = view.findViewById(R.id.slider);

		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(toolbar);
		mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.warna_utama);
		toolbar.setBackgroundDrawable(mActionBarBackgroundDrawable);
		mActionBarBackgroundDrawable.setAlpha(0);

		((ToolbarFadeOnScrolling) view.findViewById(R.id.scrollview))
				.setOnScrollChangedListener(mOnScrollChangedListener);
	}

	// github dapitramdhan Toolbar Fade

	private ToolbarFadeOnScrolling.OnScrollChangedListener mOnScrollChangedListener = new ToolbarFadeOnScrolling.OnScrollChangedListener() {
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt) {
			View decor = getActivity().getWindow().getDecorView();
			final int headerHeight = mHeader.getHeight() - toolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);

			if (t + ratio == 0) {
				//searchDrawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
				//decor.setSystemUiVisibility(0);
			} else {
				//searchDrawable.setColorFilter(getResources().getColor(R.color.colorLight), PorterDuff.Mode.SRC_ATOP);
				//decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			}
			mActionBarBackgroundDrawable.setAlpha(newAlpha);
		}
	};

}