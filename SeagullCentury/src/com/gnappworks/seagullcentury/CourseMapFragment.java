package com.gnappworks.seagullcentury;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
		String url;
		url = "http://apps.esrgc.org/maps/seagullcentury/index.html?route="+HomeFragment.routeNumber;
		View rootView = (View) inflater.inflate(R.layout.course_map_fragment, container, false);
		webView= (WebView) rootView.findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
	    webView.setWebChromeClient(new WebChromeClient());
	    webView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
		webView.loadUrl(url);
		return rootView;
	}
	
	public void onResume() 
	{
	    super.onResume();
	    String url;
		url = "http://apps.esrgc.org/maps/seagullcentury/index.html?route="+HomeFragment.routeNumber;
	    webView.loadUrl(url);
	}
	public void onPause() 
	{
	     super.onPause();
	}
}
