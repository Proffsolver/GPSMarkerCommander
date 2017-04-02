package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingsDeviceData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingsDeviceOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingsDeviceRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180StatusRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.M180DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeModeTempSignalActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180GeoPointActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListAlarmActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListPhonesActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeNameActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingMonitoringServerActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingAPNActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingTempIntervalActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class M180SettingsActivity extends BaseActivity implements View.OnClickListener{

    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DataManager mDataManager;
    private DeviceDTO mDeviceDTO;
    private M180DeviceSettingsDTO mM180DeviceSettingsDTO;
    private List<M180SettingsDeviceRes.Datum> mDevice;
    private EditText mM180_RADUIS_DEVICEEt, mM180_TIME_SEND_MESSAGE_DEVICEEt, mM180_TEMP_IMP_DEVICEEt, mM180_TIME_PARK_DEVICE_hour_Et, mM180_TIME_PARK_DEVICE_minute_Et, mM180_UTC_DEVICEEt, mM180_MIN_BALANCE_DEVICEEt, mM180_USSD_BALANCE_DEVICEEt, mM180_MOVE_DEVICEEt, mM180_SPEED_DEVICEEt, mM180_UNMOVE_DEVICEEt;
    private Spinner mM180_MODE_DEVICESp, mM180_LANGUAGE_DEVICESp, mM180_GPS_URL_DEVICESp, mM180_UNSLEEP_SMS_DEVICESp, mM180_WORRY_CALL_DEVICESp;
    private TextView mM180_NAME_DEVICETv, mListPnonesTv, mAlarmsTv, mTempvalTv, mTempsignalTv, mAddressMoniServerTv, mSettingInternetTv, mM180_POINTTv;
    private SwitchCompat mM180_GPS_DEVICE_ONSw, mM180_LBS_DEVICE_ONSw, mM180_BALANCE_DEVICE_ONSw,  mM180_BUTTON_DEVICE_ONSw, mM180_JACK_DEVICE_ONSw, mM180_MOVE_DEVICE_ONSw, mM180_UNMOVE_DEVICE_ONSw, mM180_SPEED_DEVICE_ONSw, mM180_TEMP_DEVICE_ONSw, mM180_TEMP_RELAY_SMS_DEVICESw, mM180_INTERNET_DEVICE_ONSw, mM180_ADTRACK_DEVICE_ONSw, mLinkViewSw;
    private Button mChangeSettingsSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setContentView(R.layout.m180_activity_settings);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.settings_ccordinator_container);
        mToolbar = (Toolbar) findViewById(R.id.M180_set_toolbar);
        setupToolbar();
        mChangeSettingsSaveBtn = (Button) findViewById(R.id.change_settinmgs_save_btn);

        mChangeSettingsSaveBtn.setOnClickListener(this);
        mDeviceDTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        if (Integer.valueOf(mDataManager.getPreferenceManager().getCurrentDeviceIdType())==1){
            mM180_NAME_DEVICETv = (TextView) findViewById(R.id.name_tv);
            ArrayAdapter<String> mmM180_MODE_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_MODE_STRINGS);
            mmM180_MODE_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_MODE_DEVICESp = (Spinner) findViewById(R.id.mode_sp);
            mM180_MODE_DEVICESp.setAdapter(mmM180_MODE_DEVICESpAdapter);
    //        mModeSp.setPrompt("Режим работы: Сон");
            mM180_MODE_DEVICESp.setSelection(2);
            mM180_MODE_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mM180_LANGUAGE_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LANG_STRINGS);
            mM180_LANGUAGE_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_LANGUAGE_DEVICESp = (Spinner) findViewById(R.id.lang_sp);
            mM180_LANGUAGE_DEVICESp.setAdapter(mM180_LANGUAGE_DEVICESpAdapter);
   //         mM180_LANGUAGE_DEVICESp.setPrompt("Язык SMS: Авто");
            mM180_LANGUAGE_DEVICESp.setSelection(0);
            mM180_LANGUAGE_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

/*             ArrayAdapter<String> mM180_GPS_URL_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LINKVIEW_STRINGS);
            mM180_GPS_URL_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_GPS_URL_DEVICESp = (Spinner) findViewById(R.id.linkview_sp);
            mM180_GPS_URL_DEVICESp.setAdapter(mM180_GPS_URL_DEVICESpAdapter);
    //        mM180_GPS_URL_DEVICESp.setPrompt("Вид ссылки: Геокоординаты");
            mM180_GPS_URL_DEVICESp.setSelection(0);
            mM180_GPS_URL_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });*/

            ArrayAdapter<String> mM180_UNSLEEP_SMS_DEVICESpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_SMS_STRINGS);
            mM180_UNSLEEP_SMS_DEVICESpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_UNSLEEP_SMS_DEVICESp = (Spinner) findViewById(R.id.sms_sp);
            mM180_UNSLEEP_SMS_DEVICESp.setAdapter(mM180_UNSLEEP_SMS_DEVICESpAdapter);
    //        mM180_LANGUAGE_DEVICESp.setPrompt("Язык SMS: Авто");
            mM180_UNSLEEP_SMS_DEVICESp.setSelection(0);
            mM180_UNSLEEP_SMS_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mCallViewSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_CALL_STRINGS);
            mCallViewSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mM180_WORRY_CALL_DEVICESp = (Spinner) findViewById(R.id.call_sp);
            mM180_WORRY_CALL_DEVICESp.setAdapter(mCallViewSpAdapter);
    //        mM180_GPS_URL_DEVICESp.setPrompt("Вид ссылки: Геокоординаты");
            mM180_WORRY_CALL_DEVICESp.setSelection(0);
            mM180_WORRY_CALL_DEVICESp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            mM180_TIME_PARK_DEVICE_hour_Et = (EditText) findViewById(R.id.park_hour_ed);
            mM180_TIME_PARK_DEVICE_minute_Et = (EditText) findViewById(R.id.park_minute_ed);
            mM180_UTC_DEVICEEt = (EditText) findViewById(R.id.utc_ed);
            mM180_MIN_BALANCE_DEVICEEt = (EditText) findViewById(R.id.minbalance_ed);
            mM180_USSD_BALANCE_DEVICEEt = (EditText) findViewById(R.id.ussdcommand_ed);
            mM180_MOVE_DEVICEEt = (EditText) findViewById(R.id.move_ed);
            mM180_UNMOVE_DEVICEEt = (EditText) findViewById(R.id.unmove_ed);
            mM180_SPEED_DEVICEEt = (EditText) findViewById(R.id.speed_ed);
            mM180_TEMP_IMP_DEVICEEt = (EditText) findViewById(R.id.temprelayimp_ed);
            mM180_TIME_SEND_MESSAGE_DEVICEEt = (EditText) findViewById(R.id.intarvel_send_ed);
            mM180_RADUIS_DEVICEEt = (EditText) findViewById(R.id.distance_ed);
            mM180_LBS_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.lbs_defination_sw);
            mM180_GPS_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.gps_defination_sw);
            mListPnonesTv =(TextView) findViewById(R.id.listphones_tv);
            mAlarmsTv =(TextView) findViewById(R.id.alarms_sms_tv);
            mM180_BALANCE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.balance_sw);
            mM180_BUTTON_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.button_sw);
            mM180_MOVE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.move_sw);
            mM180_UNMOVE_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.unmove_sw);
            mM180_SPEED_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.speed_sw);
            mM180_JACK_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.jack_sw);
            mM180_TEMP_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.temp_sw);
            mTempvalTv =(TextView) findViewById(R.id.tempval_tv);
            mTempsignalTv =(TextView) findViewById(R.id.tempsignal_tv);
            mM180_TEMP_RELAY_SMS_DEVICESw = (SwitchCompat) findViewById(R.id.temprelaysms_sw);
            mM180_INTERNET_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.activate_internet_sw);
            mSettingInternetTv =(TextView) findViewById(R.id.setting_internet_tv);
            mM180_ADTRACK_DEVICE_ONSw =(SwitchCompat) findViewById(R.id.adaptivetrack_sw);
            mM180_POINTTv =(TextView) findViewById(R.id.point_tv);
            mAddressMoniServerTv =(TextView) findViewById(R.id.address_mon_server_tv);
            mM180_NAME_DEVICETv.setOnClickListener(this);
            mM180_GPS_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_GPS_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_GPS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }

                }
            });
            mM180_LBS_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }

                }
            });
/*            mLinkViewSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mLinkViewSw.setText(getString(R.string.switchon));
                    }else{
                        mLinkViewSw.setText(getString(R.string.switchoff));
                    }

                }
            });*/
            mListPnonesTv.setOnClickListener(this);
            mAlarmsTv.setOnClickListener(this);
            mM180_BALANCE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_BUTTON_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_JACK_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_MOVE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_UNMOVE_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_SPEED_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_TEMP_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mM180_TEMP_RELAY_SMS_DEVICESw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchon));
                    }else{
                        mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mTempvalTv.setOnClickListener(this);
            mTempsignalTv.setOnClickListener(this);
            mM180_INTERNET_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mSettingInternetTv.setOnClickListener(this);
            mM180_ADTRACK_DEVICE_ONSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                    }else{
                        mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mAddressMoniServerTv.setOnClickListener(this);
            mM180_POINTTv.setOnClickListener(this);
            loadDeviceM180SettingsDataFromInternet();
        }

        if (savedInstanceState == null) {

        } else{

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantManager.CHANGE_NAME) {
            if (resultCode == RESULT_OK) {
                 mM180_NAME_DEVICETv.setText(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mDevice.get(25).setNameDevice(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mM180DeviceSettingsDTO.setDTOName_Device(data.getStringExtra(ConstantManager.M180_NAME_DEVICE));
                 mDevice.get(26).setNameDevice(data.getStringExtra(ConstantManager.M180_NAME_DEVICE_ON));
                 mM180DeviceSettingsDTO.setDTODisp_name_in_sms(Integer.valueOf(data.getStringExtra(ConstantManager.M180_NAME_DEVICE_ON)));
            }
        }
        if (requestCode == ConstantManager.CHANGE_POINT) {
            if (resultCode == RESULT_OK) {
                mDevice.get(14).setLongitubeDevice(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE));
                mM180DeviceSettingsDTO.setDTOLongitube_device(String.valueOf(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE)));
                mDevice.get(18).setLatitubeDevice(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE));
                mM180DeviceSettingsDTO.setDTOLatitube_device(String.valueOf(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE)));
                mM180_POINTTv.setText(String.valueOf(data.getStringExtra(ConstantManager.M180_LATITUBE_DEVICE)+"::"+String.valueOf(data.getStringExtra(ConstantManager.M180_LONGITUBE_DEVICE))));
            }}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name_tv:
                Intent nameSetIntent = new Intent(M180SettingsActivity.this, M180ChangeNameActivity.class);
                nameSetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(nameSetIntent, 1);
                break;
            case R.id.listphones_tv:
                Intent listPhonesIntent = new Intent(M180SettingsActivity.this, M180ListPhonesActivity.class);
                startActivity(listPhonesIntent);
                break;
            case R.id.alarms_sms_tv:
                Intent listAlarmsIntent = new Intent(M180SettingsActivity.this, M180ListAlarmActivity.class);
                startActivity(listAlarmsIntent);
                break;
            case R.id.tempval_tv:
                Intent setTempIntervalIntent = new Intent(M180SettingsActivity.this, M180SettingTempIntervalActivity.class);
                setTempIntervalIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(setTempIntervalIntent, 4);
                break;
            case R.id.tempsignal_tv:
                Intent chModeTempSignalIntent = new Intent(M180SettingsActivity.this, M180ChangeModeTempSignalActivity.class);
                startActivity(chModeTempSignalIntent);
                break;
            case R.id.address_mon_server_tv:
                Intent addressMoniServerIntent = new Intent(M180SettingsActivity.this, M180SettingMonitoringServerActivity.class);
                addressMoniServerIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(addressMoniServerIntent, 6);
                break;
            case R.id.setting_internet_tv:
                Intent settingInternetIntent = new Intent(M180SettingsActivity.this, M180SettingAPNActivity.class);
                settingInternetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(settingInternetIntent, 7);
                break;
            case R.id.point_tv:
                Intent geoPointIntent = new Intent(M180SettingsActivity.this, M180GeoPointActivity.class);
                geoPointIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivityForResult(geoPointIntent, 8);
                break;
            case R.id.change_settinmgs_save_btn:
                saveDeviceM180SettingsDataToInternet();
                break;
/*            case R.id.go_set_control_tv:
                Intent goSetControlIntent = new Intent(M180SettingsActivity.this, control_activity.class);
                goSetControlIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivity(goSetControlIntent);
                break;
            case R.id.go_track_tv:
                Intent goTrackIntent = new Intent(M180SettingsActivity.this, viewtrack_activity.class);
                goTrackIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mM180DeviceSettingsDTO);
                startActivity(goTrackIntent);
                break;*/
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_toolbar_menu, menu);
        return true;
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();
        switch (id) {
            case R.id.action_remove:
                deleteDevice();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void deleteDevice(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.deviceDelete(new DeviceDeleteReq(ConstantManager.JSON_METHODS[ConstantManager.DEVICE_DELETE], new DeviceDeleteOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDeviceDTO.getDTOIdDevice())));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_DELETE));
                         }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.DEVICE_DELETE));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
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

    private void loadDeviceM180SettingsDataFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180SettingsDeviceRes> call = mDataManager.getM180SettingsDeviceFromNetwork(
                    new M180SettingsDeviceReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                    new M180SettingsDeviceOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                    new M180SettingsDeviceData(
                            ConstantManager.M180_ADTRACK_DEVICE_ON, //1
                            ConstantManager.M180_BALANCE_DEVICE_ON, //2
                            ConstantManager.M180_BUTTON_DEVICE_ON, //3
                            ConstantManager.M180_GPS_DEVICE_ON, //4
                            ConstantManager.M180_INTERNET_DEVICE_ON, //5
                            ConstantManager.M180_JACK_DEVICE_ON, //6
                            ConstantManager.M180_LANGUAGE_DEVICE, //7
                            ConstantManager.M180_LATITUBE_DEVICE, //8
                            ConstantManager.M180_LBS_DEVICE_ON,  //9
                            ConstantManager.M180_LONGITUBE_DEVICE,//10
                            ConstantManager.M180_MIN_BALANCE_DEVICE, //11
                            ConstantManager.M180_MODE_DEVICE, //12
                            ConstantManager.M180_MOVE_DEVICE,//13
                            ConstantManager.M180_MOVE_DEVICE_ON, //14
                            ConstantManager.M180_NAME_DEVICE, //15
                            ConstantManager.M180_NAME_DEVICE_ON, //16
                            ConstantManager.M180_RADUIS_DEVICE, //17
                            ConstantManager.M180_SPEED_DEVICE, //18
                            ConstantManager.M180_SPEED_DEVICE_ON, //19
                            ConstantManager.M180_TEMP_DEVICE_ON, //20
                            ConstantManager.M180_TEMP_IMP_DEVICE,  //21
                            ConstantManager.M180_TEMP_RELAY_SMS_DEVICE, //22
                            ConstantManager.M180_TIME_PARK_DEVICE, //23
                            ConstantManager.M180_TIME_SEND_MESSAGE_DEVICE, //24
                            ConstantManager.M180_UNMOVE_DEVICE,  //25
                            ConstantManager.M180_UNMOVE_DEVICE_ON, //26
                            ConstantManager.M180_UNSLEEP_SMS_DEVICE, //27
                            ConstantManager.M180_USSD_BALANCE_DEVICE, //28
                            ConstantManager.M180_UTC_DEVICE, //29
                            ConstantManager.M180_WORRY_CALL_DEVICE)))); //30
            try {
                Response<M180SettingsDeviceRes> mDeviceSettings = call.execute();

/*            call.enqueue(new Callback<M180SettingsDeviceRes>() {
                @Override
                public void onResponse(Call<M180SettingsDeviceRes> call, Response<M180SettingsDeviceRes> response) {
                    if (response.code() == 200){*/
                        if (mDeviceSettings.body().getCode().equals(ConstantManager.NO_ERROR)){
                            //showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                            ArrayList forDeviceSettings = new ArrayList();
                            mDevice = mDeviceSettings.body().getData();
                            for (int i=0; i<mDevice.size(); i++){forDeviceSettings.add(i,"0");}
                            for (int i=0; i<mDevice.size(); i++){
                                if ((mDevice.get(i).getAdtrackDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(0).toString())==0)){
                                    forDeviceSettings.set(0,String.valueOf(mDevice.get(i).getAdtrackDeviceOn()));}
                                else {
                                    forDeviceSettings.set(0,"0");
                                }
                                if ((mDevice.get(i).getBalanceDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(1).toString())==0)){
                                    forDeviceSettings.set(1,String.valueOf(mDevice.get(i).getBalanceDeviceOn()));}
                                else {
                                    forDeviceSettings.set(1,"0");
                                }
                                if ((mDevice.get(i).getButtonDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(2).toString())==0)){
                                    forDeviceSettings.set(2,String.valueOf(mDevice.get(i).getButtonDeviceOn()));}
                                else {
                                    forDeviceSettings.set(2,"0");
                                }
                                if ((mDevice.get(i).getGpsDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(3).toString())==0)){
                                    forDeviceSettings.set(3,String.valueOf(mDevice.get(i).getGpsDeviceOn()));}
                                else {
                                    forDeviceSettings.set(3,"0");
                                }
                                if ((mDevice.get(i).getInternetDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(4).toString())==0)){
                                    forDeviceSettings.set(4,String.valueOf(mDevice.get(i).getInternetDeviceOn()));}
                                else {
                                    forDeviceSettings.set(4,"0");
                                }
                                if ((mDevice.get(i).getJackDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(5).toString())==0)){
                                    forDeviceSettings.set(5,String.valueOf(mDevice.get(i).getJackDeviceOn()));}
                                else {
                                    forDeviceSettings.set(5,"0");
                                }
                                if ((mDevice.get(i).getLanguageDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(6).toString())==0)){
                                    forDeviceSettings.set(6,String.valueOf(mDevice.get(i).getLanguageDevice()));}
                                else {
                                    forDeviceSettings.set(6,"0");
                                }
                               if (mDevice.get(i).getLatitubeDevice()!=null){
                                    forDeviceSettings.set(7,mDevice.get(i).getLatitubeDevice());
                               }
                               if ((mDevice.get(i).getLbsDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(8).toString())==0)){
                                    forDeviceSettings.set(8,String.valueOf(mDevice.get(i).getLbsDeviceOn()));}
                               else {
                                    forDeviceSettings.set(8,"0");
                               }
                               if (mDevice.get(i).getLongitubeDevice()!=null){
                                    forDeviceSettings.set(9,mDevice.get(i).getLongitubeDevice());
                               }
                               if (mDevice.get(i).getMinBalanceDevice()!=null){
                                    forDeviceSettings.set(10,mDevice.get(i).getMinBalanceDevice());
                               }
                               if ((mDevice.get(i).getModeDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(11).toString())==0)){
                                   forDeviceSettings.set(11,String.valueOf(mDevice.get(i).getModeDevice()));}
                               else {
                                   forDeviceSettings.set(11,"0");
                               }
                               if ((mDevice.get(i).getMoveDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(12).toString())==0)){
                                   forDeviceSettings.set(12,String.valueOf(mDevice.get(i).getMoveDevice()));}
                               else {
                                   forDeviceSettings.set(12,"0");
                               }
                               if ((mDevice.get(i).getMoveDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(13).toString())==0)){
                                   forDeviceSettings.set(13,String.valueOf(mDevice.get(i).getMoveDeviceOn()));}
                               else {
                                   forDeviceSettings.set(13,"0");
                               }
                               if (mDevice.get(i).getNameDevice()!=null){
                                   forDeviceSettings.set(14,mDevice.get(i).getNameDevice());
                               }
                               if ((mDevice.get(i).getNameDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(15).toString())==0)){
                                   forDeviceSettings.set(15,String.valueOf(mDevice.get(i).getNameDeviceOn()));}
                               else {
                                   forDeviceSettings.set(15,"0");
                               }
                               if ((mDevice.get(i).getRadiusDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(16).toString())==0)){
                                   forDeviceSettings.set(16,String.valueOf(mDevice.get(i).getRadiusDevice()));}
                               else {
                                   forDeviceSettings.set(16,"0");
                               }
                               if ((mDevice.get(i).getSpeedDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(17).toString())==0)){
                                   forDeviceSettings.set(17,String.valueOf(mDevice.get(i).getSpeedDevice()));}
                               else {
                                   forDeviceSettings.set(17,"0");
                               }
                               if ((mDevice.get(i).getSpeedDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(18).toString())==0)){
                                   forDeviceSettings.set(18,String.valueOf(mDevice.get(i).getSpeedDeviceOn()));}
                               else {
                                   forDeviceSettings.set(18,"0");
                               }
                               if ((mDevice.get(i).getTempDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(19).toString())==0)){
                                   forDeviceSettings.set(19,String.valueOf(mDevice.get(i).getTempDeviceOn()));}
                               else {
                                   forDeviceSettings.set(19,"0");
                               }
                               if ((mDevice.get(i).getTempImpDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(20).toString())==0)){
                                   forDeviceSettings.set(20,String.valueOf(mDevice.get(i).getTempImpDevice()));}
                               else {
                                   forDeviceSettings.set(20,"0");
                               }
                               if ((mDevice.get(i).getTempRelaySmsDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(21).toString())==0)){
                                   forDeviceSettings.set(21,String.valueOf(mDevice.get(i).getTempRelaySmsDevice()));}
                               else {
                                   forDeviceSettings.set(21,"0");
                               }
                               if (mDevice.get(i).getTimeParkDevice()!=null){
                                   forDeviceSettings.set(22,mDevice.get(i).getTimeParkDevice());
                               }
                               if ((mDevice.get(i).getTimeSendMessageDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(23).toString())==0)){
                                   forDeviceSettings.set(23,String.valueOf(mDevice.get(i).getTimeSendMessageDevice()));}
                               else {
                                   forDeviceSettings.set(23,"0");
                               }
                               if ((mDevice.get(i).getUnmoveDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(24).toString())==0)){
                                   forDeviceSettings.set(24,String.valueOf(mDevice.get(i).getUnmoveDevice()));}
                               else {
                                   forDeviceSettings.set(24,"0");
                               }
                               if ((mDevice.get(i).getUnmoveDeviceOn()!=0)&&(Integer.valueOf(forDeviceSettings.get(25).toString())==0)){
                                   forDeviceSettings.set(25,String.valueOf(mDevice.get(i).getUnmoveDeviceOn()));}
                               else {
                                   forDeviceSettings.set(25,"0");
                               }
                               if ((mDevice.get(i).getUnsleepSmsDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(26).toString())==0)){
                                   forDeviceSettings.set(26,String.valueOf(mDevice.get(i).getUnsleepSmsDevice()));}
                               else {
                                   forDeviceSettings.set(26,"0");
                               }
                               if (mDevice.get(i).getUssd_balance_device()!=null){
                                   forDeviceSettings.set(27,mDevice.get(i).getUssd_balance_device());
                               }
                               if (mDevice.get(i).getUtcDevice()!=null){
                                   forDeviceSettings.set(28,mDevice.get(i).getUtcDevice());
                               }
                               if ((mDevice.get(i).getWorryCallDevice()!=0)&&(Integer.valueOf(forDeviceSettings.get(29).toString())==0)){
                                   forDeviceSettings.set(29,String.valueOf(mDevice.get(i).getWorryCallDevice()));}
                               else {
                                   forDeviceSettings.set(29,"0");
                               }
                             }
                            if (Integer.valueOf(forDeviceSettings.get(0).toString())==1){
                                mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_ADTRACK_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_ADTRACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_ADTRACK_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(forDeviceSettings.get(1).toString())==1){
                                mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_BALANCE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_BALANCE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_BALANCE_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(forDeviceSettings.get(2).toString())==1){
                                mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_BUTTON_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_BUTTON_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_BUTTON_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(forDeviceSettings.get(3).toString())==1){
                                mM180_GPS_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_GPS_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_GPS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_GPS_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(forDeviceSettings.get(4).toString())==1){
                                mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_INTERNET_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_INTERNET_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_INTERNET_DEVICE_ONSw.setChecked(FALSE);
                            }
                            if (Integer.valueOf(forDeviceSettings.get(5).toString())==1){
                                mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_JACK_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_JACK_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_JACK_DEVICE_ONSw.setChecked(FALSE);
                            }

                            mM180_LANGUAGE_DEVICESp.setSelection(Integer.valueOf(forDeviceSettings.get(6).toString()));

                            if (Integer.valueOf(forDeviceSettings.get(8).toString())==1){
                                mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_LBS_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_LBS_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_LBS_DEVICE_ONSw.setChecked(FALSE);
                            }

                            mM180_MODE_DEVICESp.setSelection(Integer.valueOf(forDeviceSettings.get(11).toString()));
                            mM180_MIN_BALANCE_DEVICEEt.setText(forDeviceSettings.get(10).toString());
                            mM180_MOVE_DEVICEEt.setText(forDeviceSettings.get(12).toString());
                            if (Integer.valueOf(forDeviceSettings.get(13).toString())==1){
                                mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_MOVE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_MOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_MOVE_DEVICE_ONSw.setChecked(FALSE);
                            }

                            mM180_NAME_DEVICETv.setText("Имя: "+forDeviceSettings.get(14).toString());
                            mM180_RADUIS_DEVICEEt.setText(forDeviceSettings.get(15).toString());

                            mM180_SPEED_DEVICEEt.setText(forDeviceSettings.get(17).toString());
                            if (Integer.valueOf(forDeviceSettings.get(18).toString())==1){
                                mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_SPEED_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_SPEED_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_SPEED_DEVICE_ONSw.setChecked(FALSE);
                            }

                            if (Integer.valueOf(forDeviceSettings.get(20).toString())==1){
                                mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_TEMP_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_TEMP_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_TEMP_DEVICE_ONSw.setChecked(FALSE);
                            }

                            mM180_TEMP_IMP_DEVICEEt.setText(forDeviceSettings.get(19).toString());
                            if (Integer.valueOf(forDeviceSettings.get(21).toString())==1){
                                mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchon));
                                mM180_TEMP_RELAY_SMS_DEVICESw.setChecked(TRUE);
                            }else{
                                mM180_TEMP_RELAY_SMS_DEVICESw.setText(getString(R.string.switchoff));
                                mM180_TEMP_RELAY_SMS_DEVICESw.setChecked(FALSE);
                            }
                            mM180_TIME_PARK_DEVICE_hour_Et.setText(forDeviceSettings.get(22).toString().substring(0,forDeviceSettings.get(22).toString().indexOf(":")));
                            mM180_TIME_PARK_DEVICE_minute_Et.setText(forDeviceSettings.get(22).toString().substring(forDeviceSettings.get(22).toString().indexOf(":")));
                            mM180_TIME_SEND_MESSAGE_DEVICEEt.setText(forDeviceSettings.get(23).toString());

                            mM180_UNMOVE_DEVICEEt.setText(forDeviceSettings.get(24).toString());
                            if (Integer.valueOf(forDeviceSettings.get(25).toString())==1){
                                mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchon));
                                mM180_UNMOVE_DEVICE_ONSw.setChecked(TRUE);
                            }else{
                                mM180_UNMOVE_DEVICE_ONSw.setText(getString(R.string.switchoff));
                                mM180_UNMOVE_DEVICE_ONSw.setChecked(FALSE);
                            }
                            mM180_UNSLEEP_SMS_DEVICESp.setSelection(Integer.valueOf(forDeviceSettings.get(26).toString())-1);
                            mM180_USSD_BALANCE_DEVICEEt.setText(forDeviceSettings.get(27).toString());
                            mM180_UTC_DEVICEEt.setText(forDeviceSettings.get(28).toString());
                            mM180_WORRY_CALL_DEVICESp.setSelection(Integer.valueOf(forDeviceSettings.get(29).toString())-1);
                            forDeviceSettings.set(7, forDeviceSettings.get(7).toString().substring(1, forDeviceSettings.get(7).toString().length() - 1));
                            forDeviceSettings.set(9, forDeviceSettings.get(9).toString().substring(1, forDeviceSettings.get(9).toString().length() - 1));
                            mM180_POINTTv.setText(forDeviceSettings.get(7).toString()+"::"+forDeviceSettings.get(9).toString());
                            mM180DeviceSettingsDTO = new M180DeviceSettingsDTO(
                                    forDeviceSettings.get(14).toString(),
                                    Integer.valueOf(forDeviceSettings.get(15).toString()),
                                    forDeviceSettings.get(9).toString(),
                                    forDeviceSettings.get(7).toString(),
                                    Integer.valueOf(forDeviceSettings.get(16).toString()));}
/*                        else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES_DATA));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<M180SettingsDeviceRes> call, Throwable t) {

                }
            });*/
            }catch (IOException e) {
            }
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

    private void saveDeviceM180SettingsDataToInternet() {
        ArrayList test = new ArrayList();
        for (int i=0; i<30; i++){test.add(i,"0");}
        test.set(0, String.valueOf(checkerSW(mM180_ADTRACK_DEVICE_ONSw))); //ConstantManager.M180_ADTRACK_DEVICE_ON, //1
        test.set(1, String.valueOf(checkerSW(mM180_BALANCE_DEVICE_ONSw))); //ConstantManager.M180_BALANCE_DEVICE_ON, //2
        test.set(2, String.valueOf(checkerSW(mM180_BUTTON_DEVICE_ONSw))); //ConstantManager.M180_BUTTON_DEVICE_ON, //3
        test.set(3, String.valueOf(checkerSW(mM180_GPS_DEVICE_ONSw))); //ConstantManager.M180_GPS_DEVICE_ON, //4
        test.set(4, String.valueOf(checkerSW(mM180_INTERNET_DEVICE_ONSw))); //ConstantManager.M180_INTERNET_DEVICE_ON, //5
        test.set(5, String.valueOf(checkerSW(mM180_JACK_DEVICE_ONSw))); //ConstantManager.M180_JACK_DEVICE_ON, //6
        test.set(6, String.valueOf(mM180_LANGUAGE_DEVICESp.getSelectedItemPosition())); //ConstantManager.M180_LANGUAGE_DEVICE, //7
        test.set(7, mM180_POINTTv.getText().toString().substring(0,mM180_POINTTv.getText().toString().indexOf(":"))); //ConstantManager.M180_LATITUBE_DEVICE, //8
        test.set(8, String.valueOf(checkerSW(mM180_LBS_DEVICE_ONSw))); //ConstantManager.M180_LBS_DEVICE_ON,  //9
        test.set(9, mM180_POINTTv.getText().toString().substring(mM180_POINTTv.getText().toString().indexOf(":")+1));  //ConstantManager.M180_LONGITUBE_DEVICE,//10
        test.set(10, mM180_MIN_BALANCE_DEVICEEt.getText().toString());  //ConstantManager.M180_MIN_BALANCE_DEVICE, //11
        test.set(11, String.valueOf(mM180_MODE_DEVICESp.getSelectedItemPosition()));  //ConstantManager.M180_MODE_DEVICE, //12
        test.set(12, mM180_MOVE_DEVICEEt.getText().toString());  //ConstantManager.M180_MOVE_DEVICE,//13
        test.set(13, String.valueOf(checkerSW(mM180_MOVE_DEVICE_ONSw)));  //ConstantManager.M180_MOVE_DEVICE_ON, //14
        test.set(14, mM180DeviceSettingsDTO.getDTOName_Device());  //ConstantManager.M180_NAME_DEVICE, //15
        test.set(15, String.valueOf(mM180DeviceSettingsDTO.getDTODisp_name_in_sms()));  //ConstantManager.M180_NAME_DEVICE_ON, //16
        test.set(16, mM180_RADUIS_DEVICEEt.getText().toString());  //ConstantManager.M180_RADUIS_DEVICE, //17
        test.set(17, mM180_SPEED_DEVICEEt.getText().toString()); //ConstantManager.M180_SPEED_DEVICE, //18
        test.set(18, String.valueOf(checkerSW(mM180_SPEED_DEVICE_ONSw))); //ConstantManager.M180_SPEED_DEVICE_ON, //19
        test.set(19, String.valueOf(checkerSW(mM180_TEMP_DEVICE_ONSw))); //ConstantManager.M180_TEMP_DEVICE_ON, //20
        test.set(20, mM180_TEMP_IMP_DEVICEEt.getText().toString());//ConstantManager.M180_TEMP_IMP_DEVICE,  //21
        test.set(21, String.valueOf(checkerSW(mM180_TEMP_RELAY_SMS_DEVICESw)));//ConstantManager.M180_TEMP_RELAY_SMS_DEVICE, //22
        test.set(22, mM180_TIME_PARK_DEVICE_hour_Et.getText()+":"+mM180_TIME_PARK_DEVICE_minute_Et.getText()); //ConstantManager.M180_TIME_PARK_DEVICE, //23
        test.set(23, mM180_TIME_SEND_MESSAGE_DEVICEEt.getText().toString()); //ConstantManager.M180_TIME_SEND_MESSAGE_DEVICE, //24
        test.set(24, mM180_UNMOVE_DEVICEEt.getText().toString()); //ConstantManager.M180_UNMOVE_DEVICE,  //25
        test.set(25, String.valueOf(checkerSW(mM180_UNMOVE_DEVICE_ONSw))); //ConstantManager.M180_UNMOVE_DEVICE_ON, //26
        test.set(26, String.valueOf(mM180_UNSLEEP_SMS_DEVICESp.getSelectedItemPosition())); //ConstantManager.M180_UNSLEEP_SMS_DEVICE, //27
        test.set(27, mM180_USSD_BALANCE_DEVICEEt.getText().toString()); //ConstantManager.M180_USSD_BALANCE_DEVICE, //28
        test.set(28, mM180_UTC_DEVICEEt.getText().toString()); //ConstantManager.M180_UTC_DEVICE, //29
        test.set(29, String.valueOf(mM180_WORRY_CALL_DEVICESp.getSelectedItemPosition()));
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.setM180SettingsDevice(
                    new M180SettingsDeviceReq(ConstantManager.JSON_METHODS[ConstantManager.SET_DEVICE_DATA],
                            new M180SettingsDeviceOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), mDataManager.getPreferenceManager().getCurrentDeviceId(),
                                    new M180SettingsDeviceData(
                                            String.valueOf(checkerSW(mM180_ADTRACK_DEVICE_ONSw)), //ConstantManager.M180_ADTRACK_DEVICE_ON, //1
                                            String.valueOf(checkerSW(mM180_BALANCE_DEVICE_ONSw)), //ConstantManager.M180_BALANCE_DEVICE_ON, //2
                                            String.valueOf(checkerSW(mM180_BUTTON_DEVICE_ONSw)), //ConstantManager.M180_BUTTON_DEVICE_ON, //3
                                            String.valueOf(checkerSW(mM180_GPS_DEVICE_ONSw)), //ConstantManager.M180_GPS_DEVICE_ON, //4
                                            String.valueOf(checkerSW(mM180_INTERNET_DEVICE_ONSw)), //ConstantManager.M180_INTERNET_DEVICE_ON, //5
                                            String.valueOf(checkerSW(mM180_JACK_DEVICE_ONSw)), //ConstantManager.M180_JACK_DEVICE_ON, //6
                                            String.valueOf(mM180_LANGUAGE_DEVICESp.getSelectedItemPosition()), //ConstantManager.M180_LANGUAGE_DEVICE, //7
                                            mM180_POINTTv.getText().toString().substring(0,mM180_POINTTv.getText().toString().indexOf(":")), //ConstantManager.M180_LATITUBE_DEVICE, //8
                                            String.valueOf(checkerSW(mM180_LBS_DEVICE_ONSw)), //ConstantManager.M180_LBS_DEVICE_ON,  //9
                                            mM180_POINTTv.getText().toString().substring(mM180_POINTTv.getText().toString().indexOf(":")+1), //ConstantManager.M180_LONGITUBE_DEVICE,//10
                                            mM180_MIN_BALANCE_DEVICEEt.getText().toString(), //ConstantManager.M180_MIN_BALANCE_DEVICE, //11
                                            String.valueOf(mM180_MODE_DEVICESp.getSelectedItemPosition()), //ConstantManager.M180_MODE_DEVICE, //12
                                            mM180_MOVE_DEVICEEt.getText().toString(), //ConstantManager.M180_MOVE_DEVICE,//13
                                            String.valueOf(checkerSW(mM180_MOVE_DEVICE_ONSw)), //ConstantManager.M180_MOVE_DEVICE_ON, //14
                                            mM180DeviceSettingsDTO.getDTOName_Device(), //ConstantManager.M180_NAME_DEVICE, //15
                                            String.valueOf(mM180DeviceSettingsDTO.getDTODisp_name_in_sms()), //ConstantManager.M180_NAME_DEVICE_ON, //16
                                            mM180_RADUIS_DEVICEEt.getText().toString(), //ConstantManager.M180_RADUIS_DEVICE, //17
                                            mM180_SPEED_DEVICEEt.getText().toString(), //ConstantManager.M180_SPEED_DEVICE, //18
                                            String.valueOf(checkerSW(mM180_SPEED_DEVICE_ONSw)), //ConstantManager.M180_SPEED_DEVICE_ON, //19
                                            String.valueOf(checkerSW(mM180_TEMP_DEVICE_ONSw)), //ConstantManager.M180_TEMP_DEVICE_ON, //20
                                            mM180_TEMP_IMP_DEVICEEt.getText().toString(), //ConstantManager.M180_TEMP_IMP_DEVICE,  //21
                                            String.valueOf(checkerSW(mM180_TEMP_RELAY_SMS_DEVICESw)), //ConstantManager.M180_TEMP_RELAY_SMS_DEVICE, //22
                                            mM180_TIME_PARK_DEVICE_hour_Et.getText()+":"+mM180_TIME_PARK_DEVICE_minute_Et.getText(), //ConstantManager.M180_TIME_PARK_DEVICE, //23
                                            mM180_TIME_SEND_MESSAGE_DEVICEEt.getText().toString(), //ConstantManager.M180_TIME_SEND_MESSAGE_DEVICE, //24
                                            mM180_UNMOVE_DEVICEEt.getText().toString(), //ConstantManager.M180_UNMOVE_DEVICE,  //25
                                            String.valueOf(checkerSW(mM180_UNMOVE_DEVICE_ONSw)), //ConstantManager.M180_UNMOVE_DEVICE_ON, //26
                                            String.valueOf(mM180_UNSLEEP_SMS_DEVICESp.getSelectedItemPosition()), //ConstantManager.M180_UNSLEEP_SMS_DEVICE, //27
                                            mM180_USSD_BALANCE_DEVICEEt.getText().toString(), //ConstantManager.M180_USSD_BALANCE_DEVICE, //28
                                            mM180_UTC_DEVICEEt.getText().toString(), //ConstantManager.M180_UTC_DEVICE, //29
                                            String.valueOf(mM180_WORRY_CALL_DEVICESp.getSelectedItemPosition()))))); //ConstantManager.M180_WORRY_CALL_DEVICE
            try {
                Response<UserAccoutActionRes> mResponse = call.execute();
                showSnackbar(ErrorHandler.getErrorHandler(mResponse.body().getCode(),ConstantManager.SET_DEVICE_DATA));
            }catch (IOException e) {
            }
            /*call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200) {
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.SET_DEVICE_DATA));
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
            });*/
        } else {
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
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
