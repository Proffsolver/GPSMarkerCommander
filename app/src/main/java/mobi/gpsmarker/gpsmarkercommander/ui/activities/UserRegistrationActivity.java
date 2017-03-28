package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistrationActivity extends BaseActivity implements View.OnClickListener  {

    private TextView mDescription;
    private EditText mUserReg;
    private Button mButton;
    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;
    private Toolbar mToolbar;
    private int iActFin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        mToolbar = (Toolbar) findViewById(R.id.user_reg_toolbar);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.reg_user_coordinator_container);
        setupToolbar();
        mDataManager = DataManager.getInstance();
        mUserReg = (EditText) findViewById(R.id.user_reg_et);
        mButton = (Button) findViewById(R.id.user_reg_btn);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_reg_btn:
                userRegistration();
                break;
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void userRegistration(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.userRegistration(new UserRegReq(ConstantManager.JSON_METHODS[ConstantManager.USER_REGISTRATION], new UserRegOption(mUserReg.getText().toString())));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.USER_REGISTRATION));
                            UserRegistrationActivity.this.finish();
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.USER_REGISTRATION));
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
