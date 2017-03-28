package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180ChangeModeTempSignalData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180ChangeModeTempSignalOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180ChangeModeTempSignalReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180GetDeviceListAlarmsData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180GetDeviceListAlarmsOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180GetDeviceListAlarmsReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180ChangeModeTempSignalRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180DeviceListAlarmRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M180ChangeModeTempSignalActivity extends BaseActivity implements View.OnClickListener{

    private TextView mModeTemp1Et, mModeTemp2Et, mModeTemp3Et, mModeTemp4Et;
    private ImageView mModeTemp1Img, mModeTemp2Img, mModeTemp3Img, mModeTemp4Img;
    private Toolbar mToolbar;
    private Button mChTempModeSaveBtn;
    private CoordinatorLayout mCoordinatorLayout;
    private List<M180ChangeModeTempSignalRes.Datum> mTempSignal;
    private DataManager mDataManager;
    int iChTemp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_change_mode_temp_signal);
        mToolbar = (Toolbar) findViewById(R.id.M180_change_mode_temp_toolbar);
        setupToolbar();
        mDataManager = DataManager.getInstance();
        loadTempRelayFromInternet();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.set_temp_signal_ccordinator_container);
        mModeTemp1Et = (TextView) findViewById(R.id.mode_temp_1_tv);
        mModeTemp2Et = (TextView) findViewById(R.id.mode_temp_2_tv);
        mModeTemp3Et = (TextView) findViewById(R.id.mode_temp_3_tv);
        mModeTemp4Et = (TextView) findViewById(R.id.mode_temp_4_tv);
        mModeTemp1Img = (ImageView) findViewById(R.id.mode_temp_1_iv);
        mModeTemp2Img = (ImageView) findViewById(R.id.mode_temp_2_iv);
        mModeTemp3Img = (ImageView) findViewById(R.id.mode_temp_3_iv);
        mModeTemp4Img = (ImageView) findViewById(R.id.mode_temp_4_iv);
        mChTempModeSaveBtn = (Button) findViewById(R.id.ch_temp_mode_save_btn);
        mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
        mChTempModeSaveBtn.setOnClickListener(this);
        switch (Integer.valueOf(mTempSignal.get(0).getTempRelayDevice())) {
            case 1:
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                iChTemp = 1;
                break;
            case 2:
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                iChTemp = 2;
                break;
            case 3:
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                iChTemp = 3;
                break;
            case 4:
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                iChTemp = 4;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mode_temp_1_tv:
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                iChTemp = 1;
                break;
            case R.id.mode_temp_2_tv:
                iChTemp = 2;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                break;
            case R.id.mode_temp_3_tv:
                iChTemp = 3;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                break;
            case R.id.mode_temp_4_tv:
                iChTemp = 4;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
            case R.id.mode_temp_1_iv:
                iChTemp = 1;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                break;
            case R.id.mode_temp_2_iv:
                iChTemp = 2;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                break;
            case R.id.mode_temp_3_iv:
                iChTemp = 3;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                break;
            case R.id.mode_temp_4_iv:
                iChTemp = 4;
                mModeTemp1Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp1Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp2Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Et.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp3Img.setBackgroundColor(getResources().getColor(R.color.grey_light_light));
                mModeTemp4Et.setBackgroundColor(getResources().getColor(R.color.grey_light));
                mModeTemp4Img.setBackgroundColor(getResources().getColor(R.color.grey_light));
                break;
            case R.id.point_save_btn:
                saveTempRelayToInternet();
                finish();
                break;
        }
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadTempRelayFromInternet(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180ChangeModeTempSignalRes> call = mDataManager.getTempSignal(
                    new M180ChangeModeTempSignalReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180ChangeModeTempSignalOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180ChangeModeTempSignalData(
                                            ConstantManager.M180_TEMP_RELAY_DEVICE))));
            call.enqueue(new Callback<M180ChangeModeTempSignalRes>() {
                @Override
                public void onResponse(Call<M180ChangeModeTempSignalRes> call, Response<M180ChangeModeTempSignalRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mTempSignal = response.body().getData();

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
                public void onFailure(Call<M180ChangeModeTempSignalRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveTempRelayToInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setTempSignal(
                    new M180ChangeModeTempSignalReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180ChangeModeTempSignalOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180ChangeModeTempSignalData(
                                            String.valueOf(iChTemp)))));
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
