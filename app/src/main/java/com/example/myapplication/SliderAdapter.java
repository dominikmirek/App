package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>
{
    private List<SlidersItam> slidersItams;

    private ViewPager2 viewPager2;

     SliderAdapter(List<SlidersItam> slidersItams, ViewPager2 viewPager2) {
        this.slidersItams = slidersItams;
        this.viewPager2 = viewPager2;

    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_contain,
                        parent,
                        false
                )
        );
    }



    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(slidersItams.get(position));
        if(position == slidersItams.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slidersItams.size();
    }
class SliderViewHolder extends RecyclerView.ViewHolder  {


    private RoundedImageView imageView;
    private TextView opis;
     SliderViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageSlide);
       // this.opis = itemView.findViewById(R.id.opis);

    }
    void setImage(SlidersItam slidersItam){
        imageView.setImageResource(slidersItam.getImage());

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
