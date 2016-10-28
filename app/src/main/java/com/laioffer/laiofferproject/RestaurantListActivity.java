package com.laioffer.laiofferproject;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ArrayAdapter;



public class RestaurantListActivity extends FragmentActivity implements RestaurantListFragment.OnItemSelectListener
{
    RestaurantListFragment listFragment;
    RestaurantGridFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Log.e("Life cycle test", "We are at onCreate()");
        // Show different fragments based on screen size.
//        if (findViewById(R.id.fragment_container) != null) {
//            Fragment fragment = isTablet() ?
//                    new RestaurantGridFragment() : new RestaurantListFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//        }
        if(!isTablet()) {
            listFragment = new RestaurantListFragment();
            getSupportFragmentManager().beginTransaction().
                    add(R.id.fragment_list_container, listFragment).commit();
        } else{
            listFragment = new RestaurantListFragment();
            gridFragment = new RestaurantGridFragment();
            getSupportFragmentManager().beginTransaction().
                    add(R.id.fragment_list_container, listFragment).commit();
            getSupportFragmentManager().beginTransaction().
                    add(R.id.fragment_grid_container, gridFragment).commit();
        }

    }


    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * A dummy function to get fake restaurant names.
     *
     * @return an array of fake restaurant names.
     */
    private String[] getRestaurantNames() {
        String[] names= {
                "Restaurant1", "Restaurant2", "Restaurant3",
                "Restaurant4", "Restaurant5", "Restaurant6",
                "Restaurant7", "Restaurant8", "Restaurant9",
                "Restaurant10", "Restaurant11", "Restaurant12"};
        return names;
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

    @Override
    public void onItemSelected(int position){
        gridFragment.onItemSelected(position);
    }

}

// 描述各种操作, backend