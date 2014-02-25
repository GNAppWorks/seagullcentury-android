package com.gnappworks.seagullcentury;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CourseMapFragment extends Fragment {
	static final LatLng SALISBURYUNIV = new LatLng(38.3456,-75.6058);
	private GoogleMap map;
	private View rootView;
	
	public CourseMapFragment() {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    // inflate and return the layout
		if(rootView == null){
			rootView = inflater.inflate(R.layout.course_map_fragment, container, false);
		}
		else{
			//If the view has already been created, we remove it from the parent so that we can add it again
			//This covers the case when the tab is destroyed (i.e. when we switch from tab 3 to tab 1 and then
			//back to tab 3 again) so that it doesn't try to add a view that's already there, thus creating a
			//duplicate id and and error, and this implementation also preserves the map state (screen location,
			//attached objects, etc) by saving the state in a persistant rootView and returning it if it's not null
			ViewGroup parent = (ViewGroup) rootView.getParent();
            parent.removeView(rootView);
		}
		
		attemptCreate();
		
	    return rootView;
	}
	
	// Will check to see if the map has not been instantiated yet. 
	private void attemptCreate() {
		if (map == null) {
			// attempt to get map from SupportMapFragment
			map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.courseMapFragment)).getMap();
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
		
		// Construct a CameraPosition focusing on SU and animate the camera to that position.
		CameraPosition cameraPosition = new CameraPosition.Builder()
		    .target(SALISBURYUNIV)      // Sets the center of the map to Salisbury University
		    .zoom(17)                   // Sets the zoom
		    .tilt(55)                   // Sets the tilt of the camera to 30 degrees
		    .build();                   // Creates a CameraPosition from the builder
		map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}
}
