package com.github.dapitramdhan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.github.dapitramdhan.productlist.ModelPerson;
import com.google.android.material.snackbar.Snackbar;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;
import java.util.List;

public class HomeUtama extends Fragment {

	private Toolbar toolbar;
	private Drawable mActionBarBackgroundDrawable;
	private View mHeader;
	String url1 = "https://lh3.googleusercontent.com/-UyYKaDd0-ng/YxMr7W7gFWI/AAAAAAAACeQ/j8dJJ2hbWuovtVgHGl8nxTFrmVlrIzT4wCNcBGAsYHQ/s1600/IMG_ORG_1662200804074.png";
	String url2 = "https://lh3.googleusercontent.com/-eV3UaXmz6Ks/YxM2ZxScNHI/AAAAAAAACec/-IdeYuBOldMW8kvy_OXT1uU_2JP9q2t5QCNcBGAsYHQ/s1600/IMG_1662203478357.jpg";
	String url3 = "https://lh3.googleusercontent.com/-UOSehD-FDiA/YxM2avcDSHI/AAAAAAAACeg/6dVp6RMnPW06tWlyz8tLKkLXwW90K3s6ACNcBGAsYHQ/s1600/IMG_1662203478431.jpg";
	String url4 = "https://lh3.googleusercontent.com/-6euIj2a2tx0/YxM2e5KtOgI/AAAAAAAACew/h-bQQB0EYMs3J28w0vS8UK99MB3RXGW6ACNcBGAsYHQ/s1600/IMG_1662203478689.jpg";

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

		// setting produk

		List<Produk> produkList;
		RecyclerView recyclerView;

		recyclerView = view.findViewById(R.id.recylerView);
		recyclerView.setHasFixedSize(true);
		produkList = new ArrayList<>();
		produkList.add(new Produk(1, "Apple Macbook", 60000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		produkList.add(new Produk(2, "dell", 5000, 5, R.drawable.images));
		ProdukAdapter adapter1 = new ProdukAdapter(getActivity(), produkList);
		recyclerView.setAdapter(adapter1);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Toolbar Fade
		toolbar = view.findViewById(R.id.toolbar);
		getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.colorPrimary));
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
			final int headerHeight = toolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			mActionBarBackgroundDrawable.setAlpha(newAlpha);

		}
	};

}