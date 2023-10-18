package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder>
{
    private List<SlidersItam> slidersItams;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SlidersItam> slidersItams, ViewPager2 viewPager2) {
        this.slidersItams = slidersItams;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.viewpager2,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            SlidersItam slidersItam = slidersItams.get(position);
            holder.imgID.setImageResource(slidersItam.getImage());
            holder.opis.setText(slidersItam.getDescripiotn());
        if(position == slidersItams.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slidersItams.size();
    }
class ViewHolder extends RecyclerView.ViewHolder  {


    ImageView imgID;
    TextView opis;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imgID = itemView.findViewById(R.id.imageView);
        opis = itemView.findViewById(R.id.opis);
    }


}
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slidersItams.addAll(slidersItams);
            notifyDataSetChanged();
        }
    };


}
