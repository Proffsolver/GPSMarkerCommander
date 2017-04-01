package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import okhttp3.internal.http2.ErrorCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends BaseActivity implements View.OnClickListener {

    private Button mSignIn;
    private TextView mRememberPassword, mRegistration, mtest;
    private EditText mLogin, mPassword;
    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mDataManager = DataManager.getInstance();

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.auth_coordinator_container);
        mSignIn = (Button) findViewById(R.id.login_btn);
        mRememberPassword = (TextView) findViewById(R.id.remember_tv);
        mRegistration = (TextView) findViewById(R.id.registration_tv);
        mtest = (TextView) findViewById(R.id.test_tv);
        mLogin = (EditText) findViewById(R.id.login_email_et);
        mPassword = (EditText) findViewById(R.id.login_password_et);
        mtest.setOnClickListener(this);
        mRememberPassword.setOnClickListener(this);
        mRegistration.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                //loginSuccess();
                showSnackbar("Авторизация...");
                signIn();
                break;
            case R.id.remember_tv:
                Intent rememberIntent = new Intent(AuthActivity.this, UserRememberPasswordActivity.class);
                startActivity(rememberIntent);
                break;
            case R.id.registration_tv:
                Intent registrationIntent = new Intent(AuthActivity.this, UserRegistrationActivity.class);
                startActivity(registrationIntent);
                break;
            case R.id.test_tv:
                test();
                break;
        }
    }


    private void test(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserLoginRes>  call = mDataManager.loginUser(new UserLoginReq(ConstantManager.JSON_METHODS[ConstantManager.AUTHORIZATION], new UserLoginOption(mLogin.getText().toString(), mPassword.getText().toString())));
            call.enqueue(new Callback<UserLoginRes>() {
                @Override
                public void onResponse(Call<UserLoginRes> call, Response<UserLoginRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.AUTHORIZATION));
                            mDataManager.getPreferenceManager().saveAuthToken(response.body().getToken());
                            mDataManager.getPreferenceManager().saveUserId(response.body().getIdUser());
                            mDataManager.getPreferenceManager().saveUserMobile(response.body().getPhoneUser());
                            mDataManager.getPreferenceManager().saveUserEmail(response.body().getEmailUser());
                            Intent testIntent = new Intent(AuthActivity.this, TestExpandableActivity.class);
                            startActivity(testIntent);
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.AUTHORIZATION));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<UserLoginRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }


    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    private void loginSuccess(Response<UserLoginRes> response)
    {
        mDataManager.getPreferenceManager().saveAuthToken(response.body().getToken());
        mDataManager.getPreferenceManager().saveUserId(response.body().getIdUser());
        mDataManager.getPreferenceManager().saveUserMobile(response.body().getPhoneUser());
        mDataManager.getPreferenceManager().saveUserEmail(response.body().getEmailUser());
        Intent loginIntent = new Intent(AuthActivity.this, MainActivity.class);
        startActivity(loginIntent);

    }

    private void signIn(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserLoginRes>  call = mDataManager.loginUser(new UserLoginReq(ConstantManager.JSON_METHODS[ConstantManager.AUTHORIZATION], new UserLoginOption(mLogin.getText().toString(), mPassword.getText().toString())));
            call.enqueue(new Callback<UserLoginRes>() {
                @Override
                public void onResponse(Call<UserLoginRes> call, Response<UserLoginRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.AUTHORIZATION));
                            loginSuccess(response);
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.AUTHORIZATION));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<UserLoginRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }
}
