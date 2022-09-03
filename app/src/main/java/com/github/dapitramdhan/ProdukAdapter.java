package com.github.dapitramdhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder> {
	private Context mCtx;
	private List<Produk> produkList;

	public ProdukAdapter(Context mCtx, List<Produk> produkList) {
		this.mCtx = mCtx;
		this.produkList = produkList;
	}

	@Override
	public ProdukViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(mCtx);
		View view = inflater.inflate(R.layout.produk_layout, null);
		return new ProdukViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProdukViewHolder holder, int position) {
		Produk produk = produkList.get(position);
		
		// Panggil Nama produk , harga , image
		holder.textViewTitle.setText(produk.getTitle());
		holder.textViewPrice.setText(String.valueOf(produk.getPrice()));
		holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(produk.getImage()));
	}

	@Override
	public int getItemCount() {
		return produkList.size();

	}

	class ProdukViewHolder extends RecyclerView.ViewHolder {
		TextView textViewTitle;
		TextView textViewPrice;
		TextView textViewRating;
		ImageView imageView;

		public ProdukViewHolder(View itemView) {
			super(itemView);

			textViewTitle = itemView.findViewById(R.id.namaProduk);
			textViewPrice = itemView.findViewById(R.id.hargaProduk);
			imageView = itemView.findViewById(R.id.imageProduk);
		}
	}
}