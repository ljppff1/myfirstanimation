package com.example.zmyanimationfirsttodo;


import java.util.ArrayList;
import java.util.List;

import com.example.fragment.Fragmentf1;
import com.example.fragment.Fragmentf2;
import com.example.fragment.Fragmentf3;
import com.example.fragment.Fragmentf4;
import com.example.utils.Content;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

	private com.example.view.MyViewpager vp;
	private ArrayList<Fragment> list;
	private Fragmentf1 fa;
	private Fragmentf2 fb;
	private Fragmentf3 fc;
	private Fragmentf4 fd;
    private int mfirst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vp=(com.example.view.MyViewpager)this.findViewById(R.id.vp1);
		list = new ArrayList<Fragment>();
		for(int i=0;i<100;i++){
			 Fragmentf3 fc1 = new Fragmentf3();
			list.add(fc1);

		}
		ZxzcAdapter zxzc = new ZxzcAdapter(getSupportFragmentManager(), list);
		vp.setAdapter(zxzc);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {

				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
				findViewById(R.id.shake_img5).setVisibility(View.GONE);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			
				if(	Content.mfirst){
				findViewById(R.id.shake_img5).setVisibility(View.VISIBLE);
				}
			}
		});
		zxzc.notifyDataSetChanged();


		
		
	}
class ZxzcAdapter extends FragmentStatePagerAdapter {
		   
		
		List<Fragment> list;			
		public ZxzcAdapter(FragmentManager fm,List<Fragment> list) {
			super(fm);
			this.list=list;			
		}
		@SuppressLint("ResourceAsColor")
		@Override
		public Fragment getItem(int arg0) {		
			return list.get(arg0);
		}
		@Override
		public int getCount() {
		
			return list.size();
		}

	}


}
