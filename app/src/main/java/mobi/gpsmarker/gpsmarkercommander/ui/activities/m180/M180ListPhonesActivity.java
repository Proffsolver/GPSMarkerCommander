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

public class M180ListPhonesActivity extends BaseActivity implements View.OnClickListener{

    private DeviceSettingsDTO mDeviceSettingsDTO;
    private SwitchCompat mPhone1_Sw, mPhone2_Sw, mPhone3_Sw, mPhone4_Sw, mPhone5_Sw, mPhone6_Sw, mPhone7_Sw, mPhone8_Sw, mPhone9_Sw;
    private EditText mPhone1_Et, mPhone2_Et, mPhone3_Et, mPhone4_Et, mPhone5_Et, mPhone6_Et, mPhone7_Et, mPhone8_Et, mPhone9_Et;
    private Button mPhonesSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_M180_list_phones);
        mDeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));

        mPhone1_Et = (EditText) findViewById(R.id.phone_1_ed);
        mPhone1_Et.setText(mDeviceSettingsDTO.getDTOPhone_1_device());

        mPhone1_Sw = (SwitchCompat) findViewById(R.id.phone_1_sw);
        mPhone1_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone1_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone1_Sw.setText(getString(R.string.switchoff));
                }

            }
        });
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_1_device_on())==1){
            mPhone1_Sw.setText(getString(R.string.switchon));
            mPhone1_Sw.setChecked(TRUE);
        }else{
            mPhone1_Sw.setText(getString(R.string.switchoff));
            mPhone1_Sw.setChecked(FALSE);
        }

        mPhone2_Et = (EditText) findViewById(R.id.phone_2_ed);
        mPhone2_Et.setText(mDeviceSettingsDTO.getDTOPhone_2_device());

        mPhone2_Sw = (SwitchCompat) findViewById(R.id.phone_2_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_2_device_on())==1){
            mPhone2_Sw.setText(getString(R.string.switchon));
            mPhone2_Sw.setChecked(TRUE);
        }else{
            mPhone2_Sw.setText(getString(R.string.switchoff));
            mPhone2_Sw.setChecked(FALSE);
        }
        mPhone2_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone2_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone2_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone3_Et = (EditText) findViewById(R.id.phone_3_ed);
        mPhone3_Et.setText(mDeviceSettingsDTO.getDTOPhone_3_device());

        mPhone3_Sw = (SwitchCompat) findViewById(R.id.phone_3_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_3_device_on())==1){
            mPhone3_Sw.setText(getString(R.string.switchon));
            mPhone3_Sw.setChecked(TRUE);
        }else{
            mPhone3_Sw.setText(getString(R.string.switchoff));
            mPhone3_Sw.setChecked(FALSE);
        }
        mPhone3_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone3_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone3_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone4_Et = (EditText) findViewById(R.id.phone_4_ed);
        mPhone4_Et.setText(mDeviceSettingsDTO.getDTOPhone_4_device());

        mPhone4_Sw = (SwitchCompat) findViewById(R.id.phone_4_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_4_device_on())==1){
            mPhone4_Sw.setText(getString(R.string.switchon));
            mPhone4_Sw.setChecked(TRUE);
        }else{
            mPhone4_Sw.setText(getString(R.string.switchoff));
            mPhone4_Sw.setChecked(FALSE);
        }
        mPhone4_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone4_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone4_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone5_Et = (EditText) findViewById(R.id.phone_5_ed);
        mPhone5_Et.setText(mDeviceSettingsDTO.getDTOPhone_5_device());

        mPhone5_Sw = (SwitchCompat) findViewById(R.id.phone_5_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_5_device_on())==1){
            mPhone5_Sw.setText(getString(R.string.switchon));
            mPhone5_Sw.setChecked(TRUE);
        }else{
            mPhone5_Sw.setText(getString(R.string.switchoff));
            mPhone5_Sw.setChecked(FALSE);
        }
        mPhone5_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone5_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone5_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone6_Et = (EditText) findViewById(R.id.phone_6_ed);
        mPhone6_Et.setText(mDeviceSettingsDTO.getDTOPhone_6_device());

        mPhone6_Sw = (SwitchCompat) findViewById(R.id.phone_6_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_6_device_on())==1){
            mPhone6_Sw.setText(getString(R.string.switchon));
            mPhone6_Sw.setChecked(TRUE);
        }else{
            mPhone6_Sw.setText(getString(R.string.switchoff));
            mPhone6_Sw.setChecked(FALSE);
        }
        mPhone6_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone6_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone6_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone7_Et = (EditText) findViewById(R.id.phone_7_ed);
        mPhone7_Et.setText(mDeviceSettingsDTO.getDTOPhone_7_device());

        mPhone7_Sw = (SwitchCompat) findViewById(R.id.phone_7_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_7_device_on())==1){
            mPhone7_Sw.setText(getString(R.string.switchon));
            mPhone7_Sw.setChecked(TRUE);
        }else{
            mPhone7_Sw.setText(getString(R.string.switchoff));
            mPhone7_Sw.setChecked(FALSE);
        }
        mPhone7_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone7_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone7_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone8_Et = (EditText) findViewById(R.id.phone_8_ed);
        mPhone8_Et.setText(mDeviceSettingsDTO.getDTOPhone_8_device());

        mPhone8_Sw = (SwitchCompat) findViewById(R.id.phone_8_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_8_device_on())==1){
            mPhone8_Sw.setText(getString(R.string.switchon));
            mPhone8_Sw.setChecked(TRUE);
        }else{
            mPhone8_Sw.setText(getString(R.string.switchoff));
            mPhone8_Sw.setChecked(FALSE);
        }
        mPhone8_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone8_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone8_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

        mPhone9_Et = (EditText) findViewById(R.id.phone_9_ed);
        mPhone9_Et.setText(mDeviceSettingsDTO.getDTOPhone_9_device());

        mPhone9_Sw = (SwitchCompat) findViewById(R.id.phone_9_sw);
        if (Integer.valueOf(mDeviceSettingsDTO.getDTOPhone_9_device_on())==1){
            mPhone9_Sw.setText(getString(R.string.switchon));
            mPhone9_Sw.setChecked(TRUE);
        }else{
            mPhone9_Sw.setText(getString(R.string.switchoff));
            mPhone9_Sw.setChecked(FALSE);
        }
                mPhonesSaveBtn = (Button) findViewById(R.id.phones_save_btn);
        mPhone9_Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mPhone9_Sw.setText(getString(R.string.switchon));
                }else{
                    mPhone9_Sw.setText(getString(R.string.switchoff));
                }

            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phones_save_btn:
                // TODO: Сделать сохранение данных и закрытие активити
                break;
        }
    }
}
