package com.gnappworks.seagullcentury;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

	    public class SUWebsite extends Activity {

	        WebView myWebView;
	        @Override
	        protected void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	                    setContentView(R.layout.su_website);


	            WebView myWebView = (WebView) findViewById(R.id.su_website);
	            myWebView.loadUrl("http://www.salisbury.edu");

	        }
	    
}