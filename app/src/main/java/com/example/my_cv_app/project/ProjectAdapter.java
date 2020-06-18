package com.example.my_cv_app.project;

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


public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private Context context;
    private List<Project> list;

    public ProjectAdapter(Context context) {
        this.context = context;
        this.list = setDefaultData();
    }

    public ProjectAdapter(Context context, List<Project> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.project_item, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText( list.get( position ).getTitle() );
        holder.description.setText( list.get( position ).getDescription() );
        Picasso.with( context ).load( list.get( position ).getLogo() ).resize( 80, 80 ).centerInside().into( holder.logo );
        Picasso.with( context ).load( list.get( position ).getImages()[0] ).fit().centerCrop().into( holder.image1 );
        Picasso.with( context ).load( list.get( position ).getImages()[1] ).fit().centerCrop().into( holder.image2 );
        Picasso.with( context ).load( list.get( position ).getImages()[2] ).fit().centerCrop().into( holder.image3 );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Project> setDefaultData() {
        List<Project> list = new ArrayList<>();

        int[] placetagImages = { R.drawable.ns2, R.drawable.ns3, R.drawable.ns4, R.drawable.ns5, R.drawable.ns6, R.drawable.ns7};
        list.add( new Project( "My city",
                "Application about the city of Novi Sad",
                R.drawable.ns1,
                placetagImages ) );

        int[] songbookImages = {R.drawable.ma2, R.drawable.ma3, R.drawable.ma4};
        list.add( new Project( "Movies and Actors",
                "Movie app - JSON",
                R.drawable.ma1,
                songbookImages ) );

        int[] kindleImages = {R.drawable.t2, R.drawable.t3, R.drawable.t4};
        list.add( new Project( "Thyristic guide",
                "Enter, edit and delete tourist attractions",
                R.drawable.t1,
                kindleImages ) );

        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final View item;
        private final TextView title, description;
        private final ImageView logo, image1, image2, image3;

        ViewHolder(View view) {
            super( view );
            item = view;
            title = view.findViewById( R.id.project_title );
            description = view.findViewById( R.id.project_description );
            logo = view.findViewById( R.id.project_logo );
            image1 = view.findViewById( R.id.image_1 );
            image2 = view.findViewById( R.id.image_2 );
            image3 = view.findViewById( R.id.image_3 );
        }
    }
}
