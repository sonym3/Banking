package com.example.asmar.shp;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView nbalance, obalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nbalance = (TextView) findViewById(R.id.nbalance);
        obalance = (TextView) findViewById(R.id.obalance);


        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);

        String old_balance = sp.getString("ob", "Not Applicable");
        String new_balane = sp.getString("nb", "Not Applicable");


        nbalance.setText(new_balane);
        obalance.setText(old_balance);

        SharedPreferences.Editor editor5 = sp.edit();
        editor5.putString("ob", new_balane);
        editor5.apply();


        Button btn = (Button) findViewById(R.id.exit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });
    }
}


