package com.gnappworks.seagullcentury;

import java.util.List;
import android.graphics.PorterDuff;

import android.app.TabActivity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class HomeFragment extends Fragment {

	public static int routeNumber = 0;
		
	public HomeFragment() {}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);
	
		Button route1_button = (Button) rootView.findViewById(R.id.route1_button);
		Button route2_button = (Button) rootView.findViewById(R.id.route2_button);
		Button route3_button = (Button) rootView.findViewById(R.id.route3_button);
		Button sgc_website_button = (Button) rootView.findViewById(R.id.sgc_website_button);
		
		route1_button.getBackground().setColorFilter(0xFF800000, PorterDuff.Mode.MULTIPLY);
		route2_button.getBackground().setColorFilter(0xFF800000, PorterDuff.Mode.MULTIPLY);
		route3_button.getBackground().setColorFilter(0xFF800000, PorterDuff.Mode.MULTIPLY);
		sgc_website_button.getBackground().setColorFilter(0xFF800000, PorterDuff.Mode.MULTIPLY);

		sgc_website_button.setTextColor(Color.parseColor("#FFFFFF")); 
		
		route1_button.setTextColor(Color.parseColor("#FFFFFF")); 
		route2_button.setTextColor(Color.parseColor("#FFFFFF")); 
		route3_button.setTextColor(Color.parseColor("#FFFFFF")); 
		
		sgc_website_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	
		    	Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.seagullcentury.org"));
		    	startActivity(i); 
		    	
		    }
		});
		
		route1_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	if(HomeFragment.routeNumber!=0){
			    	HomeFragment.routeNumber = 0;
			    	refreshWebview();
		    	}
		    	getActivity().getActionBar().setSelectedNavigationItem(1);
		    }
		});
		
		route2_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	if(HomeFragment.routeNumber!=1){
			    	HomeFragment.routeNumber = 1;
			    	refreshWebview();
		    	}
		    	getActivity().getActionBar().setSelectedNavigationItem(1);
		    }
		});
		
		route3_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	if(HomeFragment.routeNumber!=2){
			    	HomeFragment.routeNumber = 2;
			    	refreshWebview();
		    	}
		    	getActivity().getActionBar().setSelectedNavigationItem(1);
		    }
		});
		
		return rootView;
	}
	
	public void refreshWebview(){
    	CourseMapFragment fragment = new CourseMapFragment();
    	getFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
	}
}
