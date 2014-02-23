package com.gnappworks.seagullcentury;

import android.content.Intent;
import android.net.Uri;
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
	
		Button sgc_website_button = (Button) rootView.findViewById(R.id.sgc_website_button);
		Button vendor_button = (Button) rootView.findViewById(R.id.vendor_button);
		
		
		
		sgc_website_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	
		    	Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.seagullcentury.org"));
		    	startActivity(i); 
		    	
		    }
		});
		
		vendor_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	
		    	Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://orgs.salisbury.edu/math/"));
		    	startActivity(i); 
		    	
		    }
		});
		
		return rootView;
	}
	
	
	
	
	
	
	
	
	
}
