package com.gnappworks.seagullcentury;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {
	public HomeFragment() {
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);

	
		
		Button home_button = (Button) rootView.findViewById(R.id.home_button);
		home_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	
		    	Intent intent = new Intent(v.getContext(), SUWebsite.class);
	            startActivity(intent); 
		    	
		    }
		});
		
		
		return rootView;
	}
	
	
	
	
	
	
	
	
	
}
