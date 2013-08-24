package com.kyler.mbq.mbqscpuguide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CPUGovernors extends Fragment {

    final String[] items = new String[] 
    		{ 		
    		"Ondemand",
    		"Interactive",
    		"InteractiveX",
    		"Performance",
    		"Powersave",
    		"Conservative",
    		"Userspace",
    		"Lagfree",
    		"Min Max",
    		"Hotplug",
    		"PegasusQ",
    		"Lazy",
    		"Nightmare",
    		"HotplugX",
    		"Lulzactive",
    		"Smartass",
    		"SmartassV2",
    		"Lionheart",
    		"BrazilianWax",
    		"Savagedzen",
    		"Scary",
    		"Sakuractive",
    		"OndemandPlus",
    		"DynInteractive" };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.governors, container,false);
        ListView list = (ListView)view.findViewById(R.id.GovLV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
		return view; 
    }
}
