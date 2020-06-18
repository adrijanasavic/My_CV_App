package com.example.my_cv_app.project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_cv_app.R;


public class ProjectFragment extends Fragment {

    public static final String TAG = "AboutFragment";
    private RecyclerView recyclerView;
    private ProjectAdapter adapter;

    public ProjectFragment() {
    }

    public static ProjectFragment newInstance() {
        ProjectFragment fragment = new ProjectFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        adapter = new ProjectAdapter( getContext() );
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_project, container, false );
        recyclerView = view.findViewById( R.id.project_container );
        recyclerView.setAdapter( adapter );
        return view;
    }
}
