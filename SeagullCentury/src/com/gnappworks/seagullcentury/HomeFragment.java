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
private Adview adView;

	public HomeFragment() {
	}

	public void onCreate(Bundle savedInstanaceState){ 
		
		
		
	}
	
	
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);
	
		// Create the adView.
	    adView = new AdView(this);
	    adView.setAdUnitId(MY_AD_UNIT_ID);
	    adView.setAdSize(AdSize.BANNER);
		
		 // Add the adView to it.
	    layout.addView(adView);

	    // Initiate a generic request.
	    AdRequest adRequest = new AdRequest.Builder().build();

	    // Load the adView with the ad request.
	    adView.loadAd(adRequest);
		
		
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
	
	
	
	@Override
	  public void onPause() {
	    adView.pause();
	    super.onPause();
	  }

	 @Override
	  public void onResume() {
	    super.onResume();
	    adView.resume();
	  }
	 
	 @Override
	  public void onDestroy() {
	    adView.destroy();
	    super.onDestroy();
	  }
	 

}
