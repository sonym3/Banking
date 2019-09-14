package com.example.asmar.shp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String old_balance = "5000";

    String new_balance ="0";
    EditText u_name,pass,e_money;
    Button login,add,sub;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        u_name=(EditText) findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.pass);
        e_money =(EditText)findViewById(R.id.money);

        //Setting old balance to Zero
        sp=getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor1=sp.edit();
        editor1.putString("ob",old_balance);
        editor1.commit();



        //Setting New_balance to Zero

        sp=getSharedPreferences("mydata",MODE_PRIVATE);
        SharedPreferences.Editor editor4=sp.edit();
        editor4.putString("nb",new_balance);
        editor4.commit();


        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int x = Integer.parseInt(e_money.getText().toString());
                String y =sp.getString("ob","Not Applicable");
                int z = x + Integer.parseInt(y);
                String temp;
                temp = Integer.toString(z);


                sp=getSharedPreferences("mydata",MODE_PRIVATE);
                SharedPreferences.Editor editor4=sp.edit();
                editor4.putString("nb",temp);
                editor4.apply();



            }
        });

        sub=(Button)findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = Integer.parseInt(e_money.getText().toString());
                String y =sp.getString("ob","Not Applicable");
                int z = Integer.parseInt(y) - x;
                String temp;
                temp = Integer.toString(z);


                sp=getSharedPreferences("mydata",MODE_PRIVATE);
                SharedPreferences.Editor editor4=sp.edit();
                editor4.putString("nb",temp);
                editor4.apply();



            }
        });

        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }

        });









    }
}

