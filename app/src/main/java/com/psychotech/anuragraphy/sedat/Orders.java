package com.psychotech.anuragraphy.sedat;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {


    DatabaseReference db;
    Firehelper helper;
    CustomAdapter adapter;
    ListView list;


    public class Firehelper{
        DatabaseReference ref;
        ArrayList<OrderNames> arrayList=new ArrayList<>();
        ListView listview;
        Context c;

        public Firehelper(DatabaseReference dr,Context context,ListView list){
        this.ref=dr;
        this.c=context;
        this.listview=list;
        this.retrieve();
        }

        private ArrayList<OrderNames> retrieve() {
            ref.child("Ordernames").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange( DataSnapshot dataSnapshot) {
                arrayList.clear();
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    OrderNames orderNames=ds.getValue(OrderNames.class);
                    arrayList.add(orderNames);
                }


                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        listview.smoothScrollToPosition(arrayList.size());
                    }
                });
                }
                }

                @Override
                public void onCancelled( DatabaseError databaseError) {

                }
            });

            return arrayList;
        }
    }

    class CustomAdapter extends BaseAdapter{
        Context c;
        ArrayList<OrderNames> orderNames;
        public CustomAdapter(Context c,ArrayList<OrderNames> ord){
            this.c=c;
            this.orderNames=ord;
        }

        @Override
        public int getCount() {
            return orderNames.size();
        }

        @Override
        public Object getItem(int position) {
            return orderNames.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
            }
            TextView dateview=convertView.findViewById(R.id.Date);
            TextView idview=convertView.findViewById(R.id.ID);
            TextView workview=convertView.findViewById(R.id.Work);


            final OrderNames o=(OrderNames) this.getItem(position);

            dateview.setText(o.getDate());
            idview.setText(o.getId());
            workview.setText(o.getWork());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open detail of the clicked order
                openDetailActivity(o.getDate(),o.getId(),o.getWork(),o.getName(),o.getAddress(),o.getRate(),o.getTax(),o.getDiscount(),o.getGrandtotal(),o.getStarttime(),o.getEndtime(),o.getTotaltime(),o.getFlag());
            }
        });
            return convertView;
        }
        //open detail activity
        private void openDetailActivity(String...details){
            Intent intent=new Intent(c,RecieveDetails.class);
            Bundle bun=new Bundle();
            bun.putString("Date_KEY",details[0]);
            bun.putString("ID_KEY",details[1]);
            bun.putString("WORK_KEY",details[2]);
            bun.putString("NAME_KEY",details[3]);
            bun.putString("ADDRESS_KEY",details[4]);
            bun.putString("RATE_KEY",details[5]);
            bun.putString("TAX_KEY",details[6]);
            bun.putString("DISCOUNT_KEY",details[7]);
            bun.putString("GRAND_KEY",details[8]);
            bun.putString("START_KEY",details[9]);
            bun.putString("END_KEY",details[10]);
            bun.putString("TOTAL_KEY",details[11]);
            bun.putString("FLAG_KEY",details[12]);
            intent.putExtras(bun);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        list=(ListView) findViewById(R.id.order_list);
        db=FirebaseDatabase.getInstance().getReference();
        helper=new Firehelper(db,this,list);
        adapter=new CustomAdapter(this,helper.retrieve());
        list.setAdapter(adapter);
    }


}
