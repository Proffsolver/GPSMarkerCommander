package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserDataChangeData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserDataChangeOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserDataChangeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserRegOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserRegReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserResetPasswordOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserResetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserSetPasswordOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserSetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.GPSMarkerCommanderApp;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import mobi.gpsmarker.gpsmarkercommander.utils.UserInputChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserChangeDataActivity extends BaseActivity implements View.OnClickListener {


    private EditText mUserMailEt, mUserPhoneEt;
    private Button mButton;
    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_change_data);
        mToolbar = (Toolbar) findViewById(R.id.user_data_change_toolbar);
        setupToolbar();
        mDataManager = DataManager.getInstance();
        mUserMailEt = (EditText) findViewById(R.id.user_email_et);
        mUserPhoneEt = (EditText) findViewById(R.id.user_phone_et);
        //mUserPhoneEt.setOnClickListener(this);
        mButton = (Button) findViewById(R.id.user_data_change_btn);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.user_ch_data_coordinator_container);
        mButton.setOnClickListener(this);
        mUserMailEt.setText(mDataManager.getPreferenceManager().getUserEmail());
        mUserPhoneEt.setText(mDataManager.getPreferenceManager().getUserMobile());
        mUserPhoneEt.addTextChangedListener(new UserInputChecker(getBaseContext(), mUserPhoneEt, (TextInputLayout) findViewById(R.id.user_phone_til), mButton));
        mUserMailEt.addTextChangedListener(new UserInputChecker(getBaseContext(), mUserMailEt, (TextInputLayout) findViewById(R.id.user_email_til), mButton));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_data_change_btn:
                changeUserData();
                break;
        }
    }
    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void changeUserData(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.userDataChange(new UserDataChangeReq(ConstantManager.JSON_METHODS[ConstantManager.SET_USER_DATA], new UserDataChangeOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), new UserDataChangeData(mUserMailEt.getText().toString(), mUserPhoneEt.getText().toString()))));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_USER_DATA));
                            mDataManager.getPreferenceManager().saveUserEmail(mUserMailEt.getText().toString());
                            mDataManager.getPreferenceManager().saveUserMobile(mUserPhoneEt.getText().toString());
                            UserChangeDataActivity.this.finish();
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_USER_DATA));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<UserAccoutActionRes> call, Throwable t) {
                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
