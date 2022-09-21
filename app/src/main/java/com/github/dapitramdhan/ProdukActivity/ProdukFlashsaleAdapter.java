package com.github.dapitramdhan.ProdukActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.dapitramdhan.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ProdukFlashsaleAdapter extends RecyclerView.Adapter<ProdukFlashsaleAdapter.ExampleViewHolder> {

	private Context mContext;
	private ArrayList<ProdukFlashsale> flashsaleList;

/*	private OnItemClickListener mListener;
	
	public interface OnItemClickListener{
		void onItemClick(int position);
	}
	
	public void setOnItemClickListener(OnItemClickListener listener){
		mListener = listener;
		
	}
	*/
	
	public ProdukFlashsaleAdapter (Context context, ArrayList<ProdukFlashsale> exampleList){
		mContext = context;
		flashsaleList = exampleList;
	}
	
	@Override
	public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
		View v = LayoutInflater.from(mContext).inflate(R.layout.produk_flashsale, parent , false);
			return new ExampleViewHolder(v);
			
		
	}
	
	@Override
	public void onBindViewHolder(ExampleViewHolder holder, int position){
		ProdukFlashsale currentItem = flashsaleList.get(position);
		
		String imageUrlFlashsale = currentItem.getImageUrlFlashsale();
		String namaProdukFlashsale = currentItem.getNamaProdukFlashsale();
		int likeCount = currentItem.getLikesCount();
		
		holder.mTextViewCreator.setText(namaProdukFlashsale);
		holder.mTextViewLikes.setText("Rp." + likeCount);
		Picasso.with(mContext).load(imageUrlFlashsale).fit().centerInside().into(holder.mImageView);
	}
	
	@Override
	public int getItemCount(){
		return flashsaleList.size();
	}
	
	@Override
    public int getItemViewType(int position)
    {
        return position;
    }
 
    @Override
    public long getItemId(int position)
    {
        return position;
    }
	
		
	public class ExampleViewHolder extends RecyclerView.ViewHolder{
		
		public ImageView mImageView;
		public TextView mTextViewCreator;
		public TextView mTextViewLikes;
		
		public ExampleViewHolder(View itemView){
			super(itemView);
			
			mImageView = itemView.findViewById(R.id.image_flashsale);
			mTextViewCreator = itemView.findViewById(R.id.nama_produk_flashsale);
			mTextViewLikes = itemView.findViewById(R.id.harga_produk_flashsale);
			
			/*itemView.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					if(mListener != null){
						int position = getAdapterPosition();
						if(position != RecyclerView.NO_POSITION){
							mListener.onItemClick(position);
						}
					}
				}
			});*/
			
		}

	}
}