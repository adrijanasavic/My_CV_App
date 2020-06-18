package com.example.my_cv_app.expirience;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_cv_app.R;
import com.example.my_cv_app.about.AboutFragment;


public class ExperienceFragment extends Fragment {

    public static final String TAG = "EexperienceFragment";

    private RecyclerView recyclerView;
    private ExperienceAdapter adapter;

    public ExperienceFragment() {
    }

    public static ExperienceFragment newInstance() {
        ExperienceFragment fragment = new ExperienceFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        adapter = new ExperienceAdapter( getContext() );
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_experience, container, false );
        recyclerView = view.findViewById( R.id.experience_container );
        recyclerView.setAdapter( adapter );
        return view;
    }
}
