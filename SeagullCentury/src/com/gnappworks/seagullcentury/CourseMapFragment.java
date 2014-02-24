package com.gnappworks.seagullcentury;
import java.util.Locale;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;



public class CourseMapFragment extends android.support.v4.app.FragmentActivity {
	static final LatLng SALISBURYUNIV = new LatLng(38.3456,-75.6058);
	private GoogleMap map;
	
	public CourseMapFragment() {
		attemptCreate();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
	    // inflate and return the layout
		View rootView = inflater.inflate(R.layout.course_map_fragment, container, false);
		
	    return rootView;
	}
	
	// Will check to see if the map has not been instantiated yet. 
	private void attemptCreate() {
		if (map == null) {
			// attempt to get map from SupportMapFragment
			map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.courseMapFragment)).getMap();
			if (map != null)
				// if we got the map then it will set up a next
				setUp();
		}
	}
	
	// If everything is good to go then... 
	private void setUp() {
		map.addMarker(new MarkerOptions()
			.position(SALISBURYUNIV)
			.title("Salisbury University")
			.snippet("Starting Point for Sea Gull Century"));
	}
}
