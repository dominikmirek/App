package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>
{
    private List<SlidersItam> slidersItams;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<SlidersItam> slidersItams, ViewPager2 viewPager2) {
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
    }

    @Override
    public int getItemCount() {
        return slidersItams.size();
    }
class SliderViewHolder extends RecyclerView.ViewHolder  {


    private RoundedImageView imageView;
     SliderViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = imageView.findViewById(R.id.imageSlide);
    }
    void setImage(SlidersItam slidersItam){
        imageView.setImageResource(slidersItam.getImage());
    }

}


}
