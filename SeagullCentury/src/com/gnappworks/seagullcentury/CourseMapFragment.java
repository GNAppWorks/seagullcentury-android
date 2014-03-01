package com.gnappworks.seagullcentury;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.content.res.AssetManager;

public class CourseMapFragment extends Fragment 
{
	public CourseMapFragment() {}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View rootView = (View) inflater.inflate(R.layout.course_map_fragment, container, false);
		WebView webView= (WebView) rootView.findViewById(R.id.webview);
		webView.loadUrl("file:///android_asset/courseMap.html");
		return rootView;
	}

}
