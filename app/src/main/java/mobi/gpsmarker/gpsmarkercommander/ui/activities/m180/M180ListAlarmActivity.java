package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListAlarmsData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListAlarmsOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListAlarmsReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180DeviceListAlarmRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180ListAlarmActivity extends BaseActivity implements View.OnClickListener{

    private SwitchCompat mAlarm_sms_1_Sw, mAlarm_sms_2_Sw, mAlarm_sms_3_Sw, mAlarm_sms_4_Sw, mAlarm_sms_5_Sw, mAlarm_sms_6_Sw, mAlarm_sms_7_Sw, mAlarm_sms_8_Sw, mAlarm_sms_9_Sw;
    private EditText mAlarmSmsPeriodDay, mAlarmSmsPeriodHour, mAlarmSmsPeriodMin, mAlarm_sms_1_Et, mAlarm_sms_2_Et, mAlarm_sms_3_Et, mAlarm_sms_4_Et, mAlarm_sms_5_Et, mAlarm_sms_6_Et, mAlarm_sms_7_Et, mAlarm_sms_8_Et, mAlarm_sms_9_Et;
    private Button mAlarm_sms_btn;
    private Toolbar mToolbar;
    private DataManager mDataManager;
    private List<M180DeviceListAlarmRes.Datum> mDeviceListAlarms;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_list_alarm);
        mToolbar = (Toolbar) findViewById(R.id.M180_sms_list_alarm_toolbar);
        mDataManager = DataManager.getInstance();
        setupToolbar();

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.device_list_alarms_coordinator_layout);
        mAlarmSmsPeriodDay = (EditText) findViewById(R.id.alarm_sms_period_day_ed);
        mAlarmSmsPeriodHour = (EditText) findViewById(R.id.alarm_sms_period_hour_ed);
        mAlarmSmsPeriodMin = (EditText) findViewById(R.id.alarm_sms_period_minute_ed);


        mAlarm_sms_btn = (Button) findViewById(R.id.alarm_sms_save_btn);
        mAlarm_sms_btn.setOnClickListener(this);
        loadListPhonesFromInternet();
    }

    public void onClick(View v) {
        saveListPhonesToInternet();
        finish();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadListPhonesFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180DeviceListAlarmRes> call = mDataManager.getDeviceListAlarms(
                    new M180GetDeviceListAlarmsReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180GetDeviceListAlarmsOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180GetDeviceListAlarmsData(
                                            ConstantManager.M180_ALARM_1_DEVICE, //11
                                            ConstantManager.M180_ALARM_1_DEVICE_ON,
                                            ConstantManager.M180_ALARM_2_DEVICE,
                                            ConstantManager.M180_ALARM_2_DEVICE_ON,
                                            ConstantManager.M180_ALARM_3_DEVICE, //15
                                            ConstantManager.M180_ALARM_3_DEVICE_ON,
                                            ConstantManager.M180_ALARM_4_DEVICE,
                                            ConstantManager.M180_ALARM_4_DEVICE_ON,
                                            ConstantManager.M180_ALARM_5_DEVICE,
                                            ConstantManager.M180_ALARM_5_DEVICE_ON, //20
                                            ConstantManager.M180_ALARM_6_DEVICE,
                                            ConstantManager.M180_ALARM_6_DEVICE_ON,
                                            ConstantManager.M180_ALARM_7_DEVICE,
                                            ConstantManager.M180_ALARM_7_DEVICE_ON,
                                            ConstantManager.M180_ALARM_8_DEVICE, //25
                                            ConstantManager.M180_ALARM_8_DEVICE_ON,
                                            ConstantManager.M180_ALARM_9_DEVICE,
                                            ConstantManager.M180_ALARM_9_DEVICE_ON,
                                            ConstantManager.M180_UNSLEEP_ALARM_DEVICE))));
            call.enqueue(new Callback<M180DeviceListAlarmRes>() {
                @Override
                public void onResponse(Call<M180DeviceListAlarmRes> call, Response<M180DeviceListAlarmRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)) {
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            mDeviceListAlarms = response.body().getData();
/*                            for (M180DeviceListAlarmRes.Datum deviceDatum: mDeviceListAlarms){
                                if (deviceDatum != null) ||
                            }*/
                            mAlarmSmsPeriodDay.setText(mDeviceListAlarms.get(17).getUnsleepAlarmDevice().substring(0, mDeviceListAlarms.get(17).getUnsleepAlarmDevice().indexOf(".")));
                            String afterFDD = mDeviceListAlarms.get(17).getUnsleepAlarmDevice().substring(mDeviceListAlarms.get(17).getUnsleepAlarmDevice().indexOf(".")+1);
                            int sDD = afterFDD.indexOf(":");
                            mAlarmSmsPeriodHour.setText(afterFDD.substring(0, sDD));
                            mAlarmSmsPeriodMin.setText(afterFDD.substring(sDD+1));
                            mAlarm_sms_1_Et = (EditText) findViewById(R.id.alarm_sms_1_ed);
                            mAlarm_sms_1_Et.setText(mDeviceListAlarms.get(18).getAlarm1Device());

                            mAlarm_sms_1_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_1_sw);
                            mAlarm_sms_1_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_1_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_1_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });
                            if (Integer.valueOf(mDeviceListAlarms.get(0).getAlarm1DeviceOn())==1){
                                mAlarm_sms_1_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_1_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_1_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_1_Sw.setChecked(FALSE);
                            }

                            mAlarm_sms_2_Et = (EditText) findViewById(R.id.alarm_sms_2_ed);
                            mAlarm_sms_2_Et.setText(mDeviceListAlarms.get(1).getAlarm2Device());

                            mAlarm_sms_2_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_2_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(2).getAlarm2DeviceOn())==1){
                                mAlarm_sms_2_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_2_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_2_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_2_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_2_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_2_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_2_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_3_Et = (EditText) findViewById(R.id.alarm_sms_3_ed);
                            mAlarm_sms_3_Et.setText(mDeviceListAlarms.get(3).getAlarm3Device());

                            mAlarm_sms_3_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_3_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(4).getAlarm3DeviceOn())==1){
                                mAlarm_sms_3_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_3_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_3_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_3_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_3_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_3_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_3_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_4_Et = (EditText) findViewById(R.id.alarm_sms_4_ed);
                            mAlarm_sms_4_Et.setText(mDeviceListAlarms.get(5).getAlarm4Device());

                            mAlarm_sms_4_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_4_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(6).getAlarm4DeviceOn())==1){
                                mAlarm_sms_4_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_4_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_4_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_4_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_4_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_4_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_4_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_5_Et = (EditText) findViewById(R.id.alarm_sms_5_ed);
                            mAlarm_sms_5_Et.setText(mDeviceListAlarms.get(7).getAlarm5Device());

                            mAlarm_sms_5_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_5_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(8).getAlarm5DeviceOn())==1){
                                mAlarm_sms_5_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_5_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_5_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_5_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_5_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_5_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_5_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_6_Et = (EditText) findViewById(R.id.alarm_sms_6_ed);
                            mAlarm_sms_6_Et.setText(mDeviceListAlarms.get(9).getAlarm6Device());

                            mAlarm_sms_6_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_6_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(10).getAlarm6DeviceOn())==1){
                                mAlarm_sms_6_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_6_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_6_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_6_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_6_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_6_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_6_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_7_Et = (EditText) findViewById(R.id.alarm_sms_7_ed);
                            mAlarm_sms_7_Et.setText(mDeviceListAlarms.get(11).getAlarm7Device());

                            mAlarm_sms_7_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_7_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(12).getAlarm7DeviceOn())==1){
                                mAlarm_sms_7_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_7_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_7_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_7_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_7_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_7_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_7_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_8_Et = (EditText) findViewById(R.id.alarm_sms_8_ed);
                            mAlarm_sms_8_Et.setText(mDeviceListAlarms.get(13).getAlarm8Device());

                            mAlarm_sms_8_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_8_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(14).getAlarm8DeviceOn())==1){
                                mAlarm_sms_8_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_8_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_8_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_8_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_8_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_8_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_8_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });

                            mAlarm_sms_9_Et = (EditText) findViewById(R.id.alarm_sms_9_ed);
                            mAlarm_sms_9_Et.setText(mDeviceListAlarms.get(15).getAlarm9Device());

                            mAlarm_sms_9_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_9_sw);
                            if (Integer.valueOf(mDeviceListAlarms.get(16).getAlarm9DeviceOn())==1){
                                mAlarm_sms_9_Sw.setText(getString(R.string.switchon));
                                mAlarm_sms_9_Sw.setChecked(TRUE);
                            }else{
                                mAlarm_sms_9_Sw.setText(getString(R.string.switchoff));
                                mAlarm_sms_9_Sw.setChecked(FALSE);
                            }
                            mAlarm_sms_9_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if(isChecked){
                                        mAlarm_sms_9_Sw.setText(getString(R.string.switchon));
                                    }else{
                                        mAlarm_sms_9_Sw.setText(getString(R.string.switchoff));
                                    }

                                }
                            });
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
                public void onFailure(Call<M180DeviceListAlarmRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveListPhonesToInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setDeviceListAlarms(
                    new M180GetDeviceListAlarmsReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180GetDeviceListAlarmsOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180GetDeviceListAlarmsData(
                                            String.valueOf(mAlarm_sms_1_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_1_Sw)),
                                            String.valueOf(mAlarm_sms_2_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_2_Sw)),
                                            String.valueOf(mAlarm_sms_3_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_3_Sw)),
                                            String.valueOf(mAlarm_sms_4_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_4_Sw)),
                                            String.valueOf(mAlarm_sms_5_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_5_Sw)),
                                            String.valueOf(mAlarm_sms_6_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_6_Sw)),
                                            String.valueOf(mAlarm_sms_7_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_7_Sw)),
                                            String.valueOf(mAlarm_sms_8_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_8_Sw)),
                                            String.valueOf(mAlarm_sms_9_Et.getText().toString()),
                                            String.valueOf(checkerSW(mAlarm_sms_9_Sw)),
                                            mAlarmSmsPeriodDay.getText().toString()+":"+mAlarmSmsPeriodHour.getText().toString()+":"+mAlarmSmsPeriodMin.getText().toString()))));
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

    private int checkerSW(SwitchCompat sw){
        int iCh;
        if(sw.isChecked()){
            iCh=1;
        }
        else{
            iCh=0;
        }
        return iCh;
    }
        
}
