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
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class CourseMapFragment extends Fragment 
{
	WebView webView;
	
	public CourseMapFragment() {}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View rootView = (View) inflater.inflate(R.layout.course_map_fragment, container, false);
		webView= (WebView) rootView.findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
	    webView.setWebChromeClient(new WebChromeClient());
	    webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
		webView.loadUrl("file:///android_asset/courseMap.html");
		return rootView;
	}
}
