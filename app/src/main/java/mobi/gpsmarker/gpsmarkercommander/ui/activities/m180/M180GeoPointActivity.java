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

public class M180GeoPointActivity extends BaseActivity implements View.OnClickListener{

    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private EditText mPointLongEt, mPointLantEt;
    private Toolbar mToolbar;
    private Button mPointSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_geo_point);
        mToolbar = (Toolbar) findViewById(R.id.M180_geo_point_toolbar);
        setupToolbar();
        mM180DeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_SETTINGS_KEY ));
        mPointLantEt = (EditText) findViewById(R.id.point_lant_ed);
        mPointLongEt = (EditText)findViewById(R.id.point_long_ed);
        mPointSaveBtn = (Button) findViewById(R.id.point_save_btn);
        mPointSaveBtn.setOnClickListener(this);
        mPointLantEt.setText(mM180DeviceSettingsDTO.getDTOLatitube_device());
        mPointLantEt.setText(mM180DeviceSettingsDTO.getDTOLongitube_device());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(ConstantManager.M180_LONGITUBE_DEVICE, mPointLantEt.getText().toString());
        intent.putExtra(ConstantManager.M180_LATITUBE_DEVICE, mPointLantEt.getText().toString());
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
