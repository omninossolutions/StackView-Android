package com.example.samar.stackview;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.StackView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public RelativeLayout relativeLayout;
    StackView stk;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stk.setVisibility(View.VISIBLE);

            }
        });

        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos", 0);

        stk = (StackView) this.findViewById(R.id.stackView1);
        ArrayList<StackItem> items = new ArrayList<StackItem>();

        items.add(new StackItem(this.getResources().getDrawable(R.drawable.a)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.b)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.c)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.d)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.e)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.f)));
        items.add(new StackItem(this.getResources().getDrawable(R.drawable.g)));

        StackAdapter stackAdapter = new StackAdapter(this, R.layout.item, items);

        stk.setAdapter(stackAdapter);


        relativeLayout = (RelativeLayout) findViewById(R.id.relativLyaout);
        relativeLayout.setBackground(items.get(pos).img);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
