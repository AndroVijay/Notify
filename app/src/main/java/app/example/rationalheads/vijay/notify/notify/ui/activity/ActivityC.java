package app.example.rationalheads.vijay.notify.notify.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.example.rationalheads.vijay.notify.R;

public class ActivityC extends AppCompatActivity  implements View.OnClickListener{

    private String TAG = this.getClass().getSimpleName();
    private Button Actvity_C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Log.e(TAG,"OnCreate Call");
        Actvity_C=findViewById(R.id.button3);
        Actvity_C.setOnClickListener(this);
        int id=getTaskId();
        Log.e("Task id:", String.valueOf(id));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button3:

                Intent gotod=new Intent(this,ActivityD.class);
                startActivity(gotod);
                break;
        }

    }
}
