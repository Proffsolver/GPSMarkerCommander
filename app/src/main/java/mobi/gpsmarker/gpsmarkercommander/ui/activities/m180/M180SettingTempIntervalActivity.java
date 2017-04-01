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
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingTempIntervalData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingTempIntervalOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingTempIntervalReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingTempIntervalRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M180SettingTempIntervalActivity extends BaseActivity implements View.OnClickListener{


    private EditText mTempInterval1Et, mTempInterval2Et;
    private Button mTempIntervalSaveBtn;
    private CoordinatorLayout mCoordinatorLayout;
    private DataManager mDataManager;
    private List<M180SettingTempIntervalRes.Datum> mTempInterval;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_setting_temp_interval);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_temp_inter_toolbar);
        setupToolbar();
        mDataManager = DataManager.getInstance();

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.set_temp_interval_ccordinator_container);
        mTempInterval1Et = (EditText) findViewById(R.id.setting_temp_interval_t1_ed);
        mTempInterval2Et = (EditText)findViewById(R.id.setting_temp_interval_t2_ed);
        mTempIntervalSaveBtn = (Button) findViewById(R.id.temp_interval_save_btn);
        mTempIntervalSaveBtn.setOnClickListener(this);
        loadTempIntervalFromInternet();
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadTempIntervalFromInternet(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180SettingTempIntervalRes> call = mDataManager.getTempInterval(
                    new M180SettingTempIntervalReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180SettingTempIntervalOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingTempIntervalData(
                                            ConstantManager.M180_TEMP_DEVICE_1,
                                            ConstantManager.M180_TEMP_DEVICE_2))));
            call.enqueue(new Callback<M180SettingTempIntervalRes>() {
                @Override
                public void onResponse(Call<M180SettingTempIntervalRes> call, Response<M180SettingTempIntervalRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mTempInterval = response.body().getData();
                            mTempInterval1Et.setText(mTempInterval.get(0).getTempDevice1());
                            mTempInterval2Et.setText(mTempInterval.get(1).getTempDevice2());
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
                public void onFailure(Call<M180SettingTempIntervalRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveTempIntervalToInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setTempInterval(
                    new M180SettingTempIntervalReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180SettingTempIntervalOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingTempIntervalData(
                                            mTempInterval1Et.getText().toString(),
                                            mTempInterval2Et.getText().toString()))));
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
