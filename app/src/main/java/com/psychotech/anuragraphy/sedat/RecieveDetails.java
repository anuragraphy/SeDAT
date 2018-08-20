package com.psychotech.anuragraphy.sedat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveDetails extends AppCompatActivity {

    TextView worktext,idtext,datetext,nametext,addresstext,ratetext,taxtext,discounttext,grandtext,starttext,endtext,totaltext,flagtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_details);
        worktext=(TextView)findViewById(R.id.work_2);
        idtext=(TextView)findViewById(R.id.id_2);
        datetext=(TextView)findViewById(R.id.date_2);
        nametext=(TextView)findViewById(R.id.name_id);
        addresstext=(TextView)findViewById(R.id.address_id);
        ratetext=(TextView)findViewById(R.id.rate_id);
        taxtext=(TextView)findViewById(R.id.tax_id);
        discounttext=(TextView)findViewById(R.id.discount_id);
        grandtext=(TextView)findViewById(R.id.grand_id);
        starttext=(TextView)findViewById(R.id.start_id);
        endtext=(TextView)findViewById(R.id.end_id);
        totaltext=(TextView)findViewById(R.id.total_id);
        flagtext=(TextView)findViewById(R.id.flag_id);

        Bundle bundle=getIntent().getExtras();

        String date=bundle.getString("DATE_KEY");
        String id=bundle.getString("ID_KEY");
        String work=bundle.getString("WORK_KEY");
        String name=bundle.getString("NAME_KEY");
        String address=bundle.getString("ADDRESS_KEY");
        String rate=bundle.getString("RATE_KEY");
        String tax=bundle.getString("TAX_KEY");
        String discount=bundle.getString("DISCOUNT_KEY");
        String grand=bundle.getString("GRAND_KEY");
        String start=bundle.getString("START_KEY");
        String end=bundle.getString("END_KEY");
        String total=bundle.getString("TOTAL_KEY");
        String flag=bundle.getString("FLAG_KEY");
        worktext.setText(work);
        idtext.setText(id);
        datetext.setText(date);
        nametext.setText(name);
        addresstext.setText(address);
        ratetext.setText(rate);
        taxtext.setText(tax);
        discounttext.setText(discount);
        grandtext.setText(grand);
        starttext.setText(start);
        endtext.setText(end);
        totaltext.setText(total);
        flagtext.setText(flag);
    }
}
