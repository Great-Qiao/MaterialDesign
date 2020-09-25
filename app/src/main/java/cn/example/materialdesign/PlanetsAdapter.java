package cn.example.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder> {
    private Context mContext;
    private List<Planets> mPlanetsList;

    public PlanetsAdapter(List<Planets> planetsList) {
        mPlanetsList = planetsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.planets_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Planets planet = mPlanetsList.get(position);
                Intent intent = new Intent(mContext,PlanetActivity.class);
                intent.putExtra(PlanetActivity.PLANET_NAME,planet.getName());
                intent.putExtra(PlanetActivity.PLANET_IMAGE_ID,planet.getImgId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Planets planets = mPlanetsList.get(position);
        holder.planetName.setText(planets.getName());
        Glide.with(mContext).load(planets.getImgId()).into(holder.planetImg);
    }

    @Override
    public int getItemCount() {
        return mPlanetsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView planetImg;
        TextView planetName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView =(CardView) itemView;
            planetImg = itemView.findViewById(R.id.planets_image);
            planetName = itemView.findViewById(R.id.planets_name);
        }
    }


}
