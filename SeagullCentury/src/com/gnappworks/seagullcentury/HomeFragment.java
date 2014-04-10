package com.gnappworks.seagullcentury;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeFragment extends Fragment {

	public static int routeNumber = 0;
	RadioButton route1_button, route2_button, route3_button;
	
	public HomeFragment() {
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);
	
		Button sgc_website_button = (Button) rootView.findViewById(R.id.sgc_website_button);
		Button vendor_button = (Button) rootView.findViewById(R.id.vendor_button);
		route1_button = (RadioButton) rootView.findViewById(R.id.route1_button);
		route2_button = (RadioButton) rootView.findViewById(R.id.route2_button);
		route3_button = (RadioButton) rootView.findViewById(R.id.route3_button);
		
		sgc_website_button.setTextColor(Color.parseColor("#000000")); 
		vendor_button.setTextColor(Color.parseColor("#000000")); 
		//#FFFF00 yellow
		route1_button.setTextColor(Color.parseColor("#FFFF00")); 
		route2_button.setTextColor(Color.parseColor("#FFFF00")); 
		route3_button.setTextColor(Color.parseColor("#FFFF00")); 
		
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
		
		route1_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	HomeFragment.routeNumber = 0;
		    }
		});
		
		route2_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	HomeFragment.routeNumber = 1;
		    }
		});
		
		route3_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	HomeFragment.routeNumber = 2;
		    }
		});
		
		return rootView;
	}
}
