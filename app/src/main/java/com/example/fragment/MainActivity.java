package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFlag.ItemSelected{
    TextView tvDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription = findViewById(R.id.tvDescription);


        descriptions= getResources().getStringArray(R.array.descriptions);

        //potrait mode
        if (findViewById(R.id.layout_portait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.flag))
                    .show(manager.findFragmentById(R.id.listflag))
                    .commit();
        }

        //landscape mode
        if (findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listflag))
                    .show(manager.findFragmentById(R.id.flag))
                    .commit();

        }
    }







    @Override
    public void onItemSelected(int index){
        tvDescription.setText(descriptions[index]);
        //potrait mode
        if (findViewById(R.id.layout_portait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.flag))
                    .hide(manager.findFragmentById(R.id.listflag))
                    .commit();
        }
    }
}