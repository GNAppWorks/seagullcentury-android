package com.gnappworks.seagullcentury;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class HomeFragment extends Fragment {
	public HomeFragment() {
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);

	
		
		Button home_button = (Button) rootView.findViewById(R.id.home_button);
		home_button.setOnClickListener (new View.OnClickListener() {
		    public void onClick(View v) {
		    	
		    	View webPanel = getView().findViewById(R.id.su_website);
		    	webPanel.setVisibility(View.VISIBLE);
		    	
		    	WebView myWebView = (WebView)webPanel;
	            myWebView.setWebViewClient(new WebViewClient());
	            myWebView.loadUrl("http://www.seagullcentury.org");
	            
		    }
		});
		
		
		
		return rootView;
	}
	
	
	
	
	
	
	
	
	
}
