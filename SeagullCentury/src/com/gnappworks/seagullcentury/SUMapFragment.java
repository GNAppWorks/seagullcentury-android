package com.gnappworks.seagullcentury;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SUMapFragment extends Fragment {

		public static final String ARG_SECTION_NUMBER = "section_number";
			public SUMapFragment(){	
			
			}
			
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				View rootView = inflater.inflate(R.layout.su_map_fragment,
						container, false);
				
				return rootView;
				
				
			}
		
		
}
