package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.app.VoiceInteractor;
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
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class AuthActivity extends BaseActivity implements View.OnClickListener {

    private Button mSignIn;
    private TextView mRemeberPassword;
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
        mRemeberPassword = (TextView) findViewById(R.id.remember_txt);
        mLogin = (EditText) findViewById(R.id.login_email_et);
        mPassword = (EditText) findViewById(R.id.login_password_et);

        mRemeberPassword.setOnClickListener(this);
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
            case R.id.remember_txt:
                rememberPassword();
                break;
        }
    }

    private void showSnackbar(String message){
       /* Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    /*    Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/
    }

    private void rememberPassword(){
       // Intent rememberIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"));
        //startActivity(rememberIntent);
    }


    private void loginSuccess(Response<UserLoginRes> response)
    {
   //     response.body().getToken();
   //     showSnackbar(response.body().getToken());

        mDataManager.getPreferenceManager().saveAuthToken(response.body().getToken());
        mDataManager.getPreferenceManager().saveUserId(response.body().getIdUser());
        mDataManager.getPreferenceManager().saveUserMobile(response.body().getPhoneUser());
        mDataManager.getPreferenceManager().saveUserEmail(response.body().getEmailUser());
        Intent loginIntent = new Intent(AuthActivity.this, MainActivity.class);
        startActivity(loginIntent);

    }

    private void signIn(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserLoginRes>  call = mDataManager.loginUser(new UserLoginReq("authorization", new UserLoginOption(mLogin.getText().toString(), mPassword.getText().toString())));
            call.enqueue(new Callback<UserLoginRes>() {
                @Override
                public void onResponse(Call<UserLoginRes> call, Response<UserLoginRes> response) {
                    if (response.code() == 200){
                        loginSuccess(response);
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
