package com.example.samar.stackview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by samar on 4/15/2016.
 */
public class StackAdapter extends ArrayAdapter<StackItem> {
    private ArrayList<StackItem> items;
    private Context ctx;

    public StackAdapter(Context context, int textViewResourceId,
                        ArrayList<StackItem> objects) {
        super(context, textViewResourceId, objects);

        this.items = objects;
        this.ctx = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item, null);
        }

        StackItem m = items.get(position);

        if (m != null) {
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);


            if (img != null) {
                img.setImageDrawable(m.img);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Position", "" + position);
                        Intent intent = new Intent(ctx, MainActivity.class);
                        intent.putExtra("pos", position);
                        ctx.startActivity(intent);
                    }
                });
            }

        }

        viewHolder = new ViewHolder();


        return v;


    }

    static class ViewHolder {

        ImageView imageView;
    }
}

