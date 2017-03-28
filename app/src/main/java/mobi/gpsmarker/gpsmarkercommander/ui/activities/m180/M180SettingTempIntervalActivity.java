package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

public class M180SettingTempIntervalActivity extends BaseActivity implements View.OnClickListener{

    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private EditText mTempInterval1Et, mTempInterval2Et;
    private Button mTempIntervalSaveBtn;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_setting_temp_interval);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_temp_inter_toolbar);
        setupToolbar();
        mM180DeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_SETTINGS_KEY ));
        mTempInterval1Et = (EditText) findViewById(R.id.setting_temp_interval_t1_ed);
        mTempInterval2Et = (EditText)findViewById(R.id.setting_temp_interval_t2_ed);
        mTempIntervalSaveBtn = (Button) findViewById(R.id.temp_interval_save_btn);
        mTempInterval1Et.setText(mM180DeviceSettingsDTO.getDTOTemp_device_1());
        mTempInterval2Et.setText(mM180DeviceSettingsDTO.getDTOTemp_device_2());
        mTempIntervalSaveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(ConstantManager.M180_TEMP_DEVICE_1, mTempInterval1Et.getText().toString());
        intent.putExtra(ConstantManager.M180_TEMP_DEVICE_2, mTempInterval2Et.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


}
