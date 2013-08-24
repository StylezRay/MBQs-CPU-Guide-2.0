package com.kyler.mbq.mbqscpuguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TCP_Algorithms extends Fragment {

    final String[] items = new String[] 
    		{ 		
    		"Tahoe",
    		"Reno",
    		"Vegas",
    		"Hybla",
    		"Cubic",
    		"Westwood" };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.tcp, container,false);
        ListView list = (ListView)view.findViewById(R.id.tcpLV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
        return view;
    }
}