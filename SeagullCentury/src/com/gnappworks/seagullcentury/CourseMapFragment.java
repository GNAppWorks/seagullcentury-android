package com.gnappworks.seagullcentury;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions;

public class CourseMapFragment extends Fragment 
{
	WebView webView;
	
	public CourseMapFragment() {}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		String url;
		url = "file:///android_asset/index.html?route="+HomeFragment.routeNumber+"&vendors="+MainActivity.vendors+"&speed="+MainActivity.speed+"&distance="+MainActivity.waypoints;
		View rootView = (View) inflater.inflate(R.layout.course_map_fragment, container, false);
		webView= (WebView) rootView.findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
	    webView.setWebChromeClient(new WebChromeClient(){
	    	//Default behavior is that the "Do you want to use location?" doesn't pop up in a WebView. This
	    	//overrides it and makes that box pop up.
	    	public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
	    		callback.invoke(origin, true, false);
	    	}
	    });
	    //Sets the geolocation database path which allows for location caching
	    webView.getSettings().setGeolocationDatabasePath(getActivity().getFilesDir().getPath() );
	    webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
		webView.loadUrl(url);
		return rootView;
	}
	
	public void onResume() 
	{
		super.onResume();
	}
	
	public void onPause() 
	{
	     super.onPause();
	}
}
