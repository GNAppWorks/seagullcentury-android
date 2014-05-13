package com.gnappworks.seagullcentury;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Locale;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	public static int vendors = 1;
	public static int speed = 1;
	public static int waypoints = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);

		// Create the adapter that will return a fragment for each of the two
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		//Remove title bar
		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		//sets starting tab
		mViewPager.setCurrentItem(0);

		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();
		}
		else{
			showGPSDisabledAlertToUser();
		}
	}

	private void showGPSDisabledAlertToUser(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
		.setCancelable(false)
		.setPositiveButton("Goto Settings Page To Enable GPS", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id){
				Intent callGPSSettingIntent = new Intent(
						android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(callGPSSettingIntent);
			}
		});
		alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id){
				dialog.cancel();
			}
		});
		AlertDialog alert = alertDialogBuilder.create();
		alert.show();
	}


	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.vendor_settings:
			if (item.isChecked()){
				item.setChecked(false);
				vendors=0;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			else{
				item.setChecked(true);
				vendors=1;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			return true;	
		case R.id.speed_settings:
			if (item.isChecked()){
				item.setChecked(false);
				speed=0;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			else{
				item.setChecked(true);
				speed=1;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			return true;	
		case R.id.waypoints_settings:
			if (item.isChecked()){
				item.setChecked(false);
				waypoints=0;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			else{
				item.setChecked(true);
				waypoints=1;
				CourseMapFragment fragment = new CourseMapFragment();
				getSupportFragmentManager().beginTransaction().replace(R.id.course_map_fragment, fragment).commit();
			}
			return true;	    
		case R.id.sagWagon:
			//call sag wagon phone number
			new AlertDialog.Builder(this)
			.setTitle("Call the SAG Wagon?")
			.setMessage("If you are having a medical emergency, please call 911. If you have an urgent need and cannot continue, please hit OK to call the SAG Wagon.\n\nPLEASE NOTE: Due to the size of the course, it may take a SAG vehicle over an hour to reach you. Your patience is appreciated.")
			.setIcon(android.R.drawable.ic_dialog_alert)
			.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:4439073258"));
					startActivity(callIntent);
				}})
				.setNegativeButton(android.R.string.no, null).show();
			return true;
		case R.id.facebook:

			return true;
		case R.id.twitter:
			Intent intent = null;
			try {
			    // get the Twitter app if possible
			    this.getPackageManager().getPackageInfo("com.twitter.android", 0);
			    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=USERID"));
			    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			} catch (Exception e) {
			    // no Twitter app, revert to browser
			    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/USERID_OR_PROFILENAME"));
			}
			this.startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/*
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	    case R.id.sagWagon:
            //call sag wagon phone number
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
        	callIntent.setData(Uri.parse("tel:4439073258"));
        	startActivity(callIntent);
            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		//mViewPager.setCurrentItem(tab.getPosition());
		mViewPager.setCurrentItem(tab.getPosition());		
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.

			Fragment fragment = null;
			Bundle args = new Bundle();
			switch(position){
			case 0:
				fragment = new HomeFragment();
				break;
			case 1:
				fragment = new CourseMapFragment();
				break;
			default:
				Log.wtf(getPackageName(), "Fragment creation failed while initializing fragment classes");
			}

			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_home_tab).toUpperCase(l);
			case 1:
				return getString(R.string.title_course_map_tab).toUpperCase(l);
			}
			return null;
		}
	}




}