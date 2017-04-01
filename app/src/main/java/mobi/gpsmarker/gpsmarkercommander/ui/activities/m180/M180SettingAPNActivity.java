package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingAPNData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingAPNOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingAPNReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingAPNRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M180SettingAPNActivity extends BaseActivity implements View.OnClickListener{

    private EditText mApnEt, mOcLoginEt, mOcPassEt;
    private Button mSetAPNEt;
    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;
    private List<M180SettingAPNRes.Datum> mSettingAPN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setContentView(R.layout.m180_activity_setting_apn);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_apn_toolbar);
        setupToolbar();

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.set_apn_ccordinator_container);

        mOcLoginEt = (EditText) findViewById(R.id.oc_login_ed);
        mOcPassEt = (EditText)findViewById(R.id.oc_password_ed);
        mApnEt = (EditText)findViewById(R.id.apn_ed);
        mSetAPNEt = (Button) findViewById(R.id.set_operation_cellular_ed);
        mSetAPNEt.setOnClickListener(this);
        loadSettingAPNFromInternet();
    }

    @Override
    public void onClick(View v) {
        saveSettingAPNToInternet();
        finish();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    private void loadSettingAPNFromInternet(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180SettingAPNRes> call = mDataManager.getSettingAPN(new M180SettingAPNReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA], new M180SettingAPNOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(), new M180SettingAPNData(ConstantManager.M180_URL_APN_DEVICE, ConstantManager.M180_LOGIN_APN_DEVICE, ConstantManager.M180_PASSWORD_APN_DEVICE))));
            call.enqueue(new Callback<M180SettingAPNRes>() {
                @Override
                public void onResponse(Call<M180SettingAPNRes> call, Response<M180SettingAPNRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mSettingAPN = response.body().getData();
                            mApnEt.setText(mSettingAPN.get(2).getUrlApnDevice());
                            mOcLoginEt.setText(mSettingAPN.get(0).getLoginApnDevice());
                            mOcPassEt.setText(mSettingAPN.get(1).getPasswordApnDevice());
                        } else {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(), ConstantManager.GET_DEVICES_DATA));
                        }
                    } else if (response.code() == 404) {
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<M180SettingAPNRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveSettingAPNToInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setSettingAPN(
                    new M180SettingAPNReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180SettingAPNOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingAPNData(
                                            mOcLoginEt.getText().toString(),
                                            mOcPassEt.getText().toString(),
                                            mApnEt.getText().toString()))));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
                        } else {
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(), ConstantManager.SET_DEVICE_DATA));
                        }
                    } else if (response.code() == 404) {
                        showSnackbar("Что-то пошло не так!");
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

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }


}
