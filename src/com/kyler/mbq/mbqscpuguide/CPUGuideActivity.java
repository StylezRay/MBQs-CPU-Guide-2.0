package com.kyler.mbq.mbqscpuguide;

import de.cketti.library.changelog.ChangeLog;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CPUGuideActivity extends Activity {

	private String[] mWelcomePage;
	private String[] mCategories;
	private String[] mGovernors;
	private String[] mIOSchedulers;
	private String[] mTCPAlgorithms;
	private String[] mAndroidTips;
	
	private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpuguide);
        
        ChangeLog cl = new ChangeLog(this);
        if (cl.isFirstRun()) {
            cl.getLogDialog().show();        
        
        mWelcomePage = getResources().getStringArray(R.array.Welcome_Page);
        mGovernors = getResources().getStringArray(R.array.CPU_Governors);
        mIOSchedulers = getResources().getStringArray(R.array.IO_Schedulers);
        mTCPAlgorithms = getResources().getStringArray(R.array.TCP_Algorithms);
        mAndroidTips = getResources().getStringArray(R.array.Android_Tips);
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mCategories));

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerTitle(this, mDrawerLayout,
        		R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
        	
        }
        
        }    
    }
    
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
    	
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }

		private void selectItem(int position) {
			Fragment fragment = new Category();
			Bundle args = new Bundle();
			
			args.putInt(Category.ARG_CATEGORY,  position);
			
			fragment.setArguments(args);
			
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
							.replace(R.id.content_frame, fragment)
							.commit();
			
			mDrawerList.setItemChecked(position,  true);
			setTitle(mCategories(position));
			mDrawerLayout.closeDrawer(mDrawerList);			
		}
		
		public void setTitle(CharSequence title) {
			mTitle = title;
			getActionBar().setTitle(mTitle);
		}

		private CharSequence mCategories(int position) {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
    public static class Category extends Fragment {
    	
    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.cpuguide, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_whats_new: {
                    new ChangeLog(this).getLogDialog().show();
                    break;
                }
                case R.id.menu_full_changelog: {
                    new ChangeLog(this).getFullLogDialog().show();
                    break;
                }
            }

            return true;
        }
    }
