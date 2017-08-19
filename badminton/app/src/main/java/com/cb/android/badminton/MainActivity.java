package com.cb.android.badminton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.button;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity  {

    EditText player;
    EditText country;
    EditText record ;
    EditText rank ;
    Button enter ;

    public static final String TAG="MainActivity";

    ArrayList<badminton> data = new ArrayList<>();
    BadmintonAdapter adapter;
    RecyclerView badminton_recyclerView;

    public static String p,c,r;
    public static int rk;
    public static int k;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player= (EditText) findViewById(R.id.et_player);
        country = (EditText) findViewById(R.id.et_country);
        record = (EditText) findViewById(R.id.et_record);
        rank = (EditText) findViewById(R.id.et_rank);
        enter = (Button) findViewById(R.id.bv_enter);
        badminton_recyclerView=(RecyclerView) findViewById(R.id.rv_badminton);

        adapter=new BadmintonAdapter(data,this);
        badminton_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        badminton_recyclerView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p= player.getText().toString();
                c=country.getText().toString();
                r=record.getText().toString();
                rk=Integer.valueOf(rank.getText().toString());
//                if(k==0)
//                {
//                    data=generate();
//                    k=1;
//                }
                    data.add(new badminton(p, c, r, rk));
                adapter.notifyDataSetChanged();

            }
        });


    }


    static ArrayList<badminton> generate(){

        ArrayList<badminton> d = new ArrayList<>();
        d.add(new badminton(p,c,r,rk));

        return d;
    }

//    class badminton_adapter extends BaseAdapter{
//        @Override
//        public int getCount() {
//            return data.size();
//        }
//
//        @Override
//        public badminton getItem(int position) {
//            return data.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View view, ViewGroup viewGroup) {
//
//            LayoutInflater li =getLayoutInflater();
//
//            badminton b=getItem(position);
//
//
//            View itemView = li.inflate(R.layout.display, null);
//
//            ((TextView)itemView.findViewById(R.id.tv_playerName))
//                    .setText(b.getPlayer());
//            ((TextView)itemView.findViewById(R.id.tv_countryName))
//                    .setText(b.getCountry());
//            ((TextView)itemView.findViewById(R.id.tv_record))
//                    .setText(String.valueOf(b.getRecord()));
//            ((TextView)itemView.findViewById(R.id.tv_rank))
//                    .setText(String.valueOf(b.getRank()));
//
//
//            return itemView;
//        }
//    }


}


