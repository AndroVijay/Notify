package app.example.rationalheads.vijay.notify.notify.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.example.rationalheads.vijay.notify.R;

public class ActivityD extends AppCompatActivity implements View.OnClickListener {

    private String TAG = this.getClass().getSimpleName();
    private Button Activity_D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        Log.e(TAG, "OnCreate Call");
        Activity_D = findViewById(R.id.button4);
        Activity_D.setOnClickListener(this);
        int id=getTaskId();
        Log.e("Task id:", String.valueOf(id));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button4:

                Intent gotob = new Intent(this, ActivityB.class);
                startActivity(gotob);
                break;
        }

    }
}
