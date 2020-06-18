package com.example.my_cv_app.expirience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.my_cv_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private Context context;
    private List<Experience> list;

    public ExperienceAdapter(Context context) {
        this.context = context;
        this.list = setDefaultData();
    }

    public ExperienceAdapter(Context context, List<Experience> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.experience_item, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText( list.get( position ).getTitle() );
        holder.subtitle.setText( list.get( position ).getSubtitle() );
        holder.date.setText( list.get( position ).getDate() );
        holder.city.setText( list.get( position ).getCity() );
        Picasso.with( context ).load( list.get( position ).getImage() ).resize( 80, 80 ).centerInside().into( holder.image );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private List<Experience> setDefaultData() {
        List<Experience> list = new ArrayList<>();

        list.add( new Experience( "Montop",
                "Account Assistant ",
                "06/2018 – 01/2019",
                "Novi Sad",
                R.drawable.experience ) );

        list.add( new Experience( "Edukino",
                "Entrepreneur",
                "06/2018 – 07/2019",
                "Novi Sad",
                R.drawable.experience ) );

        list.add( new Experience( "Studio Moderna",
                "Sales Consultant",
                "01/2012 – 01/2017",
                "Novi Sad",
                R.drawable.experience ) );

        list.add( new Experience( "NS Group",
                "Sales Agent",
                "08/2005 – 10/2007",
                "Novi Sad",
                R.drawable.experience ) );


        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final View item;
        private final TextView title, subtitle, date, city;
        private final ImageView image;

        ViewHolder(View view) {
            super( view );
            item = view;
            title = view.findViewById( R.id.experience_title );
            subtitle = view.findViewById( R.id.experience_description );
            date = view.findViewById( R.id.experience_date );
            city = view.findViewById( R.id.experience_city );
            image = view.findViewById( R.id.experience_logo );
        }
    }
}
