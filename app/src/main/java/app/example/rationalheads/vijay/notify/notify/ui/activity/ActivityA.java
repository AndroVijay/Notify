package app.example.rationalheads.vijay.notify.notify.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import app.example.rationalheads.vijay.notify.R;
import app.example.rationalheads.vijay.notify.notify.ui.utils.MyFirebaseMessagingService;

public class ActivityA extends AppCompatActivity implements View.OnClickListener {

    private String TAG = this.getClass().getSimpleName();
    private Button Activity_A;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"OnCreate Call ");
        Activity_A=findViewById(R.id.button1);
        Activity_A.setOnClickListener(this);
        int id=getTaskId();
        Log.e("Task id:", String.valueOf(id));




//        Intent intent=new Intent(this,MyFirebaseMessagingService.class);
//        startService(intent);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button1:

                Intent go=new Intent(this,ActivityB.class);
                startActivity(go);
                break;
        }


    }
}
