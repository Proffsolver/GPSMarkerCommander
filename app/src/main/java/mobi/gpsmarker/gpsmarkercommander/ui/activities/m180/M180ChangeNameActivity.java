package mobi.gpsmarker.gpsmarkercommander.ui.activities.m180;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180ChangeNameActivity extends BaseActivity implements View.OnClickListener{

    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private SwitchCompat mDispNameInSmsSw;
    private EditText mChangeNameEt;
    private Toolbar mToolbar;
    private Button mChangeNameSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m180_activity_change_name);
        mM180DeviceSettingsDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_SETTINGS_KEY ));
        mToolbar = (Toolbar) findViewById(R.id.M180_change_name_toolbar);
        setupToolbar();
        mDispNameInSmsSw = (SwitchCompat) findViewById(R.id.disp_name_in_sms_sw);
        mChangeNameEt = (EditText)findViewById(R.id.change_name_ed);
        mChangeNameSaveBtn = (Button) findViewById(R.id.change_name_save_btn);
        mChangeNameEt.setText(mM180DeviceSettingsDTO.getDTOName_Device());

        if (Integer.valueOf(mM180DeviceSettingsDTO.getDTODisp_name_in_sms())==1){
            mDispNameInSmsSw.setText("Отображать");
            mDispNameInSmsSw.setChecked(TRUE);
        }else{
            mDispNameInSmsSw.setText("Скрывать");
            mDispNameInSmsSw.setChecked(FALSE);
        }
        mDispNameInSmsSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mDispNameInSmsSw.setText("Отображать");
                }else{
                    mDispNameInSmsSw.setText("Скрывать");
                }
            }
        });
        mChangeNameSaveBtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ConstantManager.M180_NAME_DEVICE, mChangeNameEt.getText().toString());
                int iCh;
                if(mDispNameInSmsSw.isChecked()){iCh=1;}else{iCh=0;}
                intent.putExtra(ConstantManager.M180_NAME_DEVICE_ON, String.valueOf(iCh));
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
