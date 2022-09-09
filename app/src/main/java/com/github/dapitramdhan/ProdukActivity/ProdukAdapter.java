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

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ExampleViewHolder> {

	private Context mContext;
	private ArrayList<Produk> mExampleList;
	private OnItemClickListener mListener;
	
	public interface OnItemClickListener{
		void onItemClick(int position);
	}
	
	public void setOnItemClickListener(OnItemClickListener listener){
		mListener = listener;
		
	}
	
	public ProdukAdapter (Context context, ArrayList<Produk> exampleList){
		mContext = context;
		mExampleList = exampleList;
	}
	
	@Override
	public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
		View v = LayoutInflater.from(mContext).inflate(R.layout.produk_layout, parent , false);
			return new ExampleViewHolder(v);
			
		
	}
	
	@Override
	public void onBindViewHolder(ExampleViewHolder holder, int position){
		Produk currentItem = mExampleList.get(position);
		
		String imageUrl = currentItem.getImageUrl();
		String creatorName = currentItem.getCreator();
		int likeCount = currentItem.getLikesCount();
		
		holder.mTextViewCreator.setText(creatorName);
		holder.mTextViewLikes.setText("Rp." + likeCount);
		Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
	}
	
	@Override
	public int getItemCount(){
		return mExampleList.size();
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
			
			mImageView = itemView.findViewById(R.id.imageProduk);
			mTextViewCreator = itemView.findViewById(R.id.namaProduk);
			mTextViewLikes = itemView.findViewById(R.id.hargaProduk);
			
			itemView.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					if(mListener != null){
						int position = getAdapterPosition();
						if(position != RecyclerView.NO_POSITION){
							mListener.onItemClick(position);
						}
					}
				}
			});
		}

	}
}