package com.github.dapitramdhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IconGridKategoryAdapter extends RecyclerView.Adapter<IconGridKategoryAdapter.ProdukViewHolder> {
	private Context mCtx;
	private List<IconGridKategory> iconList;

	public IconGridKategoryAdapter(Context mCtx, List<IconGridKategory> iconList) {
		this.mCtx = mCtx;
		this.iconList = iconList;
	}

	@Override
	public ProdukViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(mCtx);
		View view = inflater.inflate(R.layout.icon_grid_kategori, null);
		return new ProdukViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProdukViewHolder holder, int position) {
		IconGridKategory iconGridKategory = iconList.get(position);

		// Panggil Nama produk , harga , image
		holder.textViewTitle.setText(iconGridKategory.getTitle());
		holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(iconGridKategory.getImage()));
	}

	@Override
	public int getItemCount() {
		return iconList.size();

	}

	class ProdukViewHolder extends RecyclerView.ViewHolder {
		TextView textViewTitle;
		ImageView imageView;

		public ProdukViewHolder(View itemView) {
			super(itemView);

			textViewTitle = itemView.findViewById(R.id.namaIcon);
			imageView = itemView.findViewById(R.id.iconKategoriGrid);
		}
	}
}