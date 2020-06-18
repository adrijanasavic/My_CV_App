package com.example.my_cv_app.about;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.my_cv_app.R;


public class AboutFragment extends Fragment {

    public static final String TAG = "AboutFragment";
    private final String PHONE_NUMBER = "+381644917853";
    private final String EMAIL = "adrijana.jovicic@gmail.com";

    private Button call, message;
    private ImageView linkedin, github, cv;

    public AboutFragment() {
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_about, container, false );
        call = view.findViewById( R.id.call_me );
        message = view.findViewById( R.id.message_me );
        linkedin = view.findViewById( R.id.linkedIN );
        github = view.findViewById( R.id.GitHub );
        cv = view.findViewById( R.id.cv );

        call.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permissionAction( PermissionProvider.REQUEST_CALL_CODE );
            }
        } );
        message.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageAction();
            }
        } );
        linkedin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse( "https://www.linkedin.com/in/adrijana-savi%C4%87-50249176/" ) ) );
            }
        } );

        github.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse( "https://github.com/adrijanasavic" ) ) );
            }
        } );

        cv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( Intent.ACTION_VIEW, Uri.parse( "https://raw.githack.com/adrijanasavic/My_Portfolio/master/index.html" ) ) );
            }
        } );
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PermissionProvider.REQUEST_CALL_CODE) {
            if (PermissionProvider.arePermissionsProvided( grantResults ))
                callAction();
            else
                Toast.makeText( getContext(), R.string.accept_permissions, Toast.LENGTH_SHORT ).show();
        } else
            Toast.makeText( getContext(), R.string.accept_permissions, Toast.LENGTH_SHORT ).show();
    }


    private void permissionAction(int permissionCode) {
        if (PermissionProvider.arePermissionsGranted( getActivity(), permissionCode )) {
            if (permissionCode == PermissionProvider.REQUEST_CALL_CODE)
                callAction();

        } else if (PermissionProvider.isRequiredVersion()) {
            requestPermissions( PermissionProvider.requiredPermissions( getActivity(), permissionCode ), permissionCode );
        }
    }

    private void callAction() {
        Intent intent = new Intent( Intent.ACTION_CALL );
        intent.setData( Uri.parse( "tel:" + PHONE_NUMBER ) );
        startActivity( intent );
    }

    private void messageAction() {
        Intent intent = new Intent( Intent.ACTION_SENDTO, Uri.fromParts( "mailto", EMAIL, null ) );
        startActivity( Intent.createChooser( intent, getContext().getString( R.string.send_mail ) ) );
    }


}
