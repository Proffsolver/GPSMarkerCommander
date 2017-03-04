package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180ListAlarmActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private SwitchCompat mAlarm_sms_1_Sw, mAlarm_sms_2_Sw, mAlarm_sms_3_Sw, mAlarm_sms_4_Sw, mAlarm_sms_5_Sw, mAlarm_sms_6_Sw, mAlarm_sms_7_Sw, mAlarm_sms_8_Sw, mAlarm_sms_9_Sw;
    private EditText mAlarmSmsPeriodDay, mAlarmSmsPeriodHour, mAlarmSmsPeriodMin, mAlarm_sms_1_Et, mAlarm_sms_2_Et, mAlarm_sms_3_Et, mAlarm_sms_4_Et, mAlarm_sms_5_Et, mAlarm_sms_6_Et, mAlarm_sms_7_Et, mAlarm_sms_8_Et, mAlarm_sms_9_Et;
    private Button mAlarm_sms_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_list_alarm);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        mAlarmSmsPeriodDay = (EditText) findViewById(R.id.alarm_sms_period_day_ed);
        mAlarmSmsPeriodHour = (EditText) findViewById(R.id.alarm_sms_period_hour_ed);
        mAlarmSmsPeriodMin = (EditText) findViewById(R.id.alarm_sms_period_minute_ed);
        mAlarmSmsPeriodDay.setText(mDeviceSettingsDTO.getDTOUnsleep_Alarm_sms_device().substring(0,mDeviceSettingsDTO.getDTOUnsleep_Alarm_sms_device().indexOf(":")));
//        int fDD = mDeviceSettingsDTO.getDTOUnsleep_Alarm_sms_device().indexOf(":");
        String afterFDD = mDeviceSettingsDTO.getDTOUnsleep_Alarm_sms_device().substring(0,mDeviceSettingsDTO.getDTOUnsleep_Alarm_sms_device().indexOf(":"));
        int sDD = afterFDD.indexOf(":");
        mAlarmSmsPeriodHour.setText(afterFDD.substring(0, sDD));
        mAlarmSmsPeriodMin.setText(afterFDD.substring(sDD));

        mAlarm_sms_1_Et = (EditText) findViewById(R.id.alarm_sms_1_ed);
        mAlarm_sms_1_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_1_device());

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
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_1_device_on())==1){
            mAlarm_sms_1_Sw.setText(getString(R.string.switchon));
            mAlarm_sms_1_Sw.setChecked(TRUE);
        }else{
            mAlarm_sms_1_Sw.setText(getString(R.string.switchoff));
            mAlarm_sms_1_Sw.setChecked(FALSE);
        }

        mAlarm_sms_2_Et = (EditText) findViewById(R.id.alarm_sms_2_ed);
        mAlarm_sms_2_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_2_device());

        mAlarm_sms_2_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_2_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_2_device_on())==1){
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
        mAlarm_sms_3_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_3_device());

        mAlarm_sms_3_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_3_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_3_device_on())==1){
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
        mAlarm_sms_4_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_4_device());

        mAlarm_sms_4_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_4_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_4_device_on())==1){
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
        mAlarm_sms_5_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_5_device());

        mAlarm_sms_5_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_5_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_5_device_on())==1){
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
        mAlarm_sms_6_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_6_device());

        mAlarm_sms_6_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_6_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_6_device_on())==1){
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
        mAlarm_sms_7_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_7_device());

        mAlarm_sms_7_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_7_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_7_device_on())==1){
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
        mAlarm_sms_8_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_8_device());

        mAlarm_sms_8_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_8_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_8_device_on())==1){
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
        mAlarm_sms_9_Et.setText(mDeviceSettingsDTO.getDTOAlarm_sms_9_device());

        mAlarm_sms_9_Sw = (SwitchCompat) findViewById(R.id.alarm_sms_9_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOAlarm_sms_9_device_on())==1){
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

        mAlarm_sms_btn = (Button) findViewById(R.id.phones_save_btn);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phones_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }
        
}
