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

public class M180SettingOperationCellularActivity extends BaseActivity implements View.OnClickListener{

    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private EditText mApnEt, mOcLoginEt, mOcPassEt;
    private Button mSetOperationCellularEt;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_setting_operation_cellular);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_apn_toolbar);
        setupToolbar();
        mM180DeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_SETTINGS_KEY ));
        mOcLoginEt = (EditText) findViewById(R.id.oc_login_ed);
        mOcPassEt = (EditText)findViewById(R.id.oc_password_ed);
        mApnEt = (EditText)findViewById(R.id.apn_ed);
        mSetOperationCellularEt = (Button) findViewById(R.id.set_operation_cellular_ed);

        mApnEt.setText(mM180DeviceSettingsDTO.getDTOUrl_apn_device());
        mOcLoginEt.setText(mM180DeviceSettingsDTO.getDTOLogin_apn_device());
        mOcPassEt.setText(mM180DeviceSettingsDTO.getDTOPassword_apn_device());
        mSetOperationCellularEt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(ConstantManager.M180_URL_APN_DEVICE, mApnEt.getText().toString());
        intent.putExtra(ConstantManager.M180_LOGIN_APN_DEVICE, mOcLoginEt.getText().toString());
        intent.putExtra(ConstantManager.M180_PASSWORD_APN_DEVICE, mOcPassEt.getText().toString());
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
