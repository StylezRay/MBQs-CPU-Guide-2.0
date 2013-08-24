package com.kyler.mbq.mbqscpuguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tips extends Fragment {

    final String[] items = new String[] 
    		{ 		
    		"Developer options",
    		"Force GPU Rendering",
    		"WiFi sleep policy",
    		"WiFi Scan Interval",
    		"Better Battery Life",
    		"StatusBar Trick",
    		"Autobrightness Sucks",
    		"Change DPI",
    		"Change Bootanimation",
    		"Block Ads",
    		"4x MSAA",
    		"zRAM Information" };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.tips, container,false);
        ListView list = (ListView)view.findViewById(R.id.tLV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
        return view;
    }
}
