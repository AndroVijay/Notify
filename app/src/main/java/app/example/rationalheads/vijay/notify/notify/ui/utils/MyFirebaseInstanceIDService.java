package app.example.rationalheads.vijay.notify.notify.ui.utils;

import android.util.Log;

import app.example.rationalheads.vijay.notify.notify.ui.base.constance.AppConstants;
import app.example.rationalheads.vijay.notify.notify.ui.persistence.NotifyPreference;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService  extends FirebaseInstanceIdService{

    private static  final String TAG="MyFirebaseInstanceId";

    @Override
    public void onTokenRefresh() {


        String token= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refreshed Token:"+token);

        NotifyPreference.getInstance(getApplicationContext()).setString(AppConstants.KEY_FCM_ID,token);
        NotifyPreference.getInstance(getApplicationContext()).setBoolean(AppConstants.KEY_FCM_ID_UPDATED,true);

    }
}
