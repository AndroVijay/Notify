package app.example.rationalheads.vijay.notify.notify.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.example.rationalheads.vijay.notify.R;

public class ActivityB extends AppCompatActivity implements View.OnClickListener{

    private String TAG = this.getClass().getSimpleName();
    private Button Activity_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.e(TAG,"OnCreate Call");
        Activity_B=findViewById(R.id.button2);
        Activity_B.setOnClickListener(this);
        int id=getTaskId();
        Log.e("Task id:", String.valueOf(id));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.button2:

                Intent gotoc=new Intent(this,ActivityC.class);
                startActivity(gotoc);
                break;
        }


    }
}
