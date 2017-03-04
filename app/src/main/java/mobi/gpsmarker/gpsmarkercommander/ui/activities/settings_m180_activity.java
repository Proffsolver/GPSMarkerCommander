package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.SettingsDeviceM180Data;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.SettingsDeviceOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.SettingsDeviceResM180;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceM180DTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceSettingsDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeModeTempSignalActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180GeoPointActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListAlarmActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ListPhonesActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180ChangeNameActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingMonitoringServerActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingOperationCellularActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.m180.M180SettingTempIntervalActivity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class settings_m180_activity extends BaseActivity implements View.OnClickListener{

    int SETTINGS_DEVICE_DIALOG = 0;
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DataManager mDataManager;
 //   private LinearLayout mLinearLayout;
    private DeviceM180DTO mDeviceM180DTO;
    private DeviceSettingsDTO mDeviceSettingsDTO;
    private SettingsDeviceResM180.Datum mDevice;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private EditText mDistanceEt, mTimeSendMessageDeviceEt, mTempRelayImpEt, mParkHourEt, mParkMinEt, mUTCEt, mMinBalanceEt, mUssdCommandEt, mMoveEt, mSpeedEt, mUnMoveEt;
    private Spinner mModeSp, mLangSp, mLinkViewSp, mSMSSp, mCallSp;
    private TextView mNameTv, mListPnonesTv, mAlarmsTv, mTempvalTv, mTempsignalTv, mAddressMoniServerTv, mSettingInternetTv, mPointTv;
    private SwitchCompat mLBSSw, mBalanceSw,  mButtonSw, mJackSw, mMoveSw, mUnMoveSw, mSpeedSw, mTempSw, mTemprelaySMSSw, mActivateInternetSw, mAdaptivetrackSw, mLinkViewSw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
        setContentView(R.layout.activity_settings_m180);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.settings_ccordinator_container);
        // mImageView.setOnClickListener(this);
        mToolbar = (Toolbar) findViewById(R.id.set_toolbar);
       // mNavigationView = (NavigationView) findViewById(R.id.set_navigation_view);
        //mHeaderImage = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.image_header);
        setupToolbar();
        mDeviceM180DTO = getIntent().getParcelableExtra((ConstantManager.PARCELABLE_KEY));
        if (Integer.valueOf(mDeviceM180DTO.getDTOIdDeviceType())==1){

            ArrayAdapter<String> mModeSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_MODE_STRINGS);
            mModeSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mModeSp = (Spinner) findViewById(R.id.mode_sp);
            mModeSp.setAdapter(mModeSpAdapter);
    //        mModeSp.setPrompt("Режим работы: Сон");
            mModeSp.setSelection(2);
            mModeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mLangSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LANG_STRINGS);
            mModeSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mLangSp = (Spinner) findViewById(R.id.lang_sp);
            mLangSp.setAdapter(mLangSpAdapter);
   //         mLangSp.setPrompt("Язык SMS: Авто");
            mLangSp.setSelection(0);
            mLangSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mLinkViewSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_LINKVIEW_STRINGS);
            mModeSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mLinkViewSp = (Spinner) findViewById(R.id.linkview_sp);
            mLinkViewSp.setAdapter(mLinkViewSpAdapter);
    //        mLinkViewSp.setPrompt("Вид ссылки: Геокоординаты");
            mLinkViewSp.setSelection(0);
            mLinkViewSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mSMSSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_SMS_STRINGS);
            mModeSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSMSSp = (Spinner) findViewById(R.id.lang_sp);
            mSMSSp.setAdapter(mSMSSpAdapter);
    //        mLangSp.setPrompt("Язык SMS: Авто");
            mSMSSp.setSelection(0);
            mSMSSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            ArrayAdapter<String> mCallViewSpAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ConstantManager.M180_ALARM_CALL_STRINGS);
            mModeSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mCallSp = (Spinner) findViewById(R.id.linkview_sp);
            mCallSp.setAdapter(mCallViewSpAdapter);
    //        mLinkViewSp.setPrompt("Вид ссылки: Геокоординаты");
            mCallSp.setSelection(0);
            mCallSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });

            mParkHourEt = (EditText) findViewById(R.id.park_hour_ed);
            mParkMinEt = (EditText) findViewById(R.id.park_minute_ed);
            mUTCEt = (EditText) findViewById(R.id.utc_ed);
            mMinBalanceEt = (EditText) findViewById(R.id.minbalance_ed);
            mUssdCommandEt = (EditText) findViewById(R.id.ussdcommand_ed);
            mMoveEt = (EditText) findViewById(R.id.move_ed);
            mUnMoveEt = (EditText) findViewById(R.id.unmove_ed);
            mSpeedEt = (EditText) findViewById(R.id.speed_ed);
            mTempRelayImpEt = (EditText) findViewById(R.id.temprelayimp_ed);
            mTimeSendMessageDeviceEt = (EditText) findViewById(R.id.intarvel_send_ed);
            mDistanceEt = (EditText) findViewById(R.id.distance_ed);
            mLBSSw =(SwitchCompat) findViewById(R.id.lbs_defination_sw);
            mLinkViewSw =(SwitchCompat) findViewById(R.id.linkview_sw);
            mListPnonesTv =(TextView) findViewById(R.id.listphones_tv);
            mAlarmsTv =(TextView) findViewById(R.id.alarms_sms_tv);
            mBalanceSw =(SwitchCompat) findViewById(R.id.balance_sw);
            mButtonSw =(SwitchCompat) findViewById(R.id.button_sw);
            mMoveSw =(SwitchCompat) findViewById(R.id.move_sw);
            mUnMoveSw =(SwitchCompat) findViewById(R.id.unmove_sw);
            mSpeedSw =(SwitchCompat) findViewById(R.id.speed_sw);
            mJackSw =(SwitchCompat) findViewById(R.id.jack_sw);
            mTempSw =(SwitchCompat) findViewById(R.id.temp_sw);
            mTempvalTv =(TextView) findViewById(R.id.tempval_tv);
            mTempsignalTv =(TextView) findViewById(R.id.tempsignal_tv);
            mTemprelaySMSSw = (SwitchCompat) findViewById(R.id.temprelaysms_sw);
            mActivateInternetSw =(SwitchCompat) findViewById(R.id.activate_internet_sw);
            mSettingInternetTv =(TextView) findViewById(R.id.setting_internet_tv);
            mAdaptivetrackSw =(SwitchCompat) findViewById(R.id.adaptivetrack_sw);
            mPointTv =(TextView) findViewById(R.id.point_tv);
            mAddressMoniServerTv =(TextView) findViewById(R.id.address_mon_server_tv);
            mNameTv.setOnClickListener(this);
            mLBSSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mLBSSw.setText(getString(R.string.switchon));
                    }else{
                        mLBSSw.setText(getString(R.string.switchoff));
                    }

                }
            });
            mLinkViewSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mLinkViewSw.setText(getString(R.string.switchon));
                    }else{
                        mLinkViewSw.setText(getString(R.string.switchoff));
                    }

                }
            });
            mListPnonesTv.setOnClickListener(this);
            mAlarmsTv.setOnClickListener(this);
            mBalanceSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mBalanceSw.setText(getString(R.string.switchon));
                    }else{
                        mBalanceSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mButtonSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mButtonSw.setText(getString(R.string.switchon));
                    }else{
                        mButtonSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mJackSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mJackSw.setText(getString(R.string.switchon));
                    }else{
                        mJackSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mMoveSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mMoveSw.setText(getString(R.string.switchon));
                    }else{
                        mMoveSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mUnMoveSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mUnMoveSw.setText(getString(R.string.switchon));
                    }else{
                        mUnMoveSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mSpeedSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mSpeedSw.setText(getString(R.string.switchon));
                    }else{
                        mSpeedSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mTempSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mTempSw.setText(getString(R.string.switchon));
                    }else{
                        mTempSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mTemprelaySMSSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mTemprelaySMSSw.setText(getString(R.string.switchon));
                    }else{
                        mTemprelaySMSSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mTempvalTv.setOnClickListener(this);
            mTempsignalTv.setOnClickListener(this);
            mActivateInternetSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mActivateInternetSw.setText(getString(R.string.switchon));
                    }else{
                        mActivateInternetSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mSettingInternetTv.setOnClickListener(this);
            mAdaptivetrackSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        mAdaptivetrackSw.setText(getString(R.string.switchon));
                    }else{
                        mAdaptivetrackSw.setText(getString(R.string.switchoff));
                    }
                }
            });
            mAddressMoniServerTv.setOnClickListener(this);
            mPointTv.setOnClickListener(this);
            loadDeviceM180SettingsDataFromInternet();
        }

        if (savedInstanceState == null) {

        } else{

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name_tv:
                Intent nameSetIntent = new Intent(settings_m180_activity.this, M180ChangeNameActivity.class);
                nameSetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(nameSetIntent);
                break;
            case R.id.listphones_tv:
                Intent listPhonesIntent = new Intent(settings_m180_activity.this, M180ListPhonesActivity.class);
                listPhonesIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(listPhonesIntent);
                break;
            case R.id.alarms_sms_tv:
                Intent listAlarmsIntent = new Intent(settings_m180_activity.this, M180ListAlarmActivity.class);
                listAlarmsIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(listAlarmsIntent);
                break;
            case R.id.tempval_tv:
                Intent setTempIntervalIntent = new Intent(settings_m180_activity.this, M180SettingTempIntervalActivity.class);
                setTempIntervalIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(setTempIntervalIntent);
                break;
            case R.id.tempsignal_tv:
                Intent chModeTempSignalIntent = new Intent(settings_m180_activity.this, M180ChangeModeTempSignalActivity.class);
                chModeTempSignalIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
               startActivity(chModeTempSignalIntent);
                break;
            case R.id.address_mon_server_tv:
                Intent addressMoniServerIntent = new Intent(settings_m180_activity.this, M180SettingMonitoringServerActivity.class);
                addressMoniServerIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(addressMoniServerIntent);
                break;
            case R.id.setting_internet_tv:
                Intent settingInternetIntent = new Intent(settings_m180_activity.this, M180SettingOperationCellularActivity.class);
                settingInternetIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(settingInternetIntent);
                break;
            case R.id.point_tv:
                Intent geoPointIntent = new Intent(settings_m180_activity.this, M180GeoPointActivity.class);
                geoPointIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(geoPointIntent);
                break;
/*            case R.id.go_set_control_tv:
                Intent goSetControlIntent = new Intent(settings_m180_activity.this, control_activity.class);
                goSetControlIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(goSetControlIntent);
                break;
            case R.id.go_track_tv:
                Intent goTrackIntent = new Intent(settings_m180_activity.this, viewtrack_activity.class);
                goTrackIntent.putExtra(ConstantManager.PARCELABLE_SETTINGS_KEY, mDeviceSettingsDTO);
                startActivity(goTrackIntent);
                break;*/
        }
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadDeviceM180SettingsDataFromInternet(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<SettingsDeviceResM180> call = mDataManager.getSettingsDevice(new SettingsDeviceReq("get_device_data",
                    new SettingsDeviceOption(mDataManager.getPreferenceManager().getUserId(),
                            mDataManager.getPreferenceManager().getAuthToken(), mDeviceM180DTO.getDTOIdDevice(),
                            new SettingsDeviceM180Data(ConstantManager.M180_MODE_DEVICE, ConstantManager.M180_LANGUAGE_DEVICE,
                                    ConstantManager.M180_NAME_DEVICE, ConstantManager.M180_NAME_DEVICE_ON,
                                    ConstantManager.M180_GPS_URL_DEVICE, ConstantManager.M180_GPS_DEVICE_ON,
                                    ConstantManager.M180_UNSLEEP_SMS_DEVICE, ConstantManager.M180_WORRY_CALL_DEVICE,
                                    ConstantManager.M180_TIME_PARK_DEVICE, ConstantManager.M180_UTC_DEVICE,
                                    ConstantManager.M180_LBS_DEVICE_ON, ConstantManager.M180_PHONE_1_DEVICE,
                                    ConstantManager.M180_PHONE_1_DEVICE_ON, ConstantManager.M180_PHONE_2_DEVICE,
                                    ConstantManager.M180_PHONE_2_DEVICE_ON, ConstantManager.M180_PHONE_3_DEVICE,
                                    ConstantManager.M180_PHONE_3_DEVICE_ON, ConstantManager.M180_PHONE_4_DEVICE,
                                    ConstantManager.M180_PHONE_4_DEVICE_ON, ConstantManager.M180_PHONE_5_DEVICE,
                                    ConstantManager.M180_PHONE_5_DEVICE_ON, ConstantManager.M180_PHONE_6_DEVICE,
                                    ConstantManager.M180_PHONE_6_DEVICE_ON, ConstantManager.M180_PHONE_7_DEVICE,
                                    ConstantManager.M180_PHONE_7_DEVICE_ON, ConstantManager.M180_PHONE_8_DEVICE,
                                    ConstantManager.M180_PHONE_8_DEVICE_ON, ConstantManager.M180_PHONE_9_DEVICE,
                                    ConstantManager.M180_PHONE_9_DEVICE_ON, ConstantManager.M180_UNSLEEP_ALARM_DEVICE,
                                    ConstantManager.M180_ALARM_1_DEVICE, ConstantManager.M180_ALARM_1_DEVICE_ON,
                                    ConstantManager.M180_ALARM_2_DEVICE, ConstantManager.M180_ALARM_2_DEVICE_ON,
                                    ConstantManager.M180_ALARM_3_DEVICE, ConstantManager.M180_ALARM_3_DEVICE_ON,
                                    ConstantManager.M180_ALARM_4_DEVICE, ConstantManager.M180_ALARM_4_DEVICE_ON,
                                    ConstantManager.M180_ALARM_5_DEVICE, ConstantManager.M180_ALARM_5_DEVICE_ON,
                                    ConstantManager.M180_ALARM_6_DEVICE, ConstantManager.M180_ALARM_6_DEVICE_ON,
                                    ConstantManager.M180_ALARM_7_DEVICE, ConstantManager.M180_ALARM_7_DEVICE_ON,
                                    ConstantManager.M180_ALARM_8_DEVICE, ConstantManager.M180_ALARM_8_DEVICE_ON,
                                    ConstantManager.M180_ALARM_9_DEVICE, ConstantManager.M180_ALARM_9_DEVICE_ON,
                                    ConstantManager.M180_BALANCE_DEVICE_ON, ConstantManager.M180_MIN_BALANCE_DEVICE,
                                    ConstantManager.M180_USSD_BALANCE_DEVICE, ConstantManager.M180_BUTTON_DEVICE_ON,
                                    ConstantManager.M180_MOVE_DEVICE, ConstantManager.M180_MOVE_DEVICE_ON,
                                    ConstantManager.M180_UNMOVE_DEVICE, ConstantManager.M180_UNMOVE_DEVICE_ON,
                                    ConstantManager.M180_SPEED_DEVICE, ConstantManager.M180_SPEED_DEVICE_ON,
                                    ConstantManager.M180_JACK_DEVICE_ON, ConstantManager.M180_TEMP_DEVICE_ON,
                                    ConstantManager.M180_TEMP_DEVICE_1, ConstantManager.M180_TEMP_DEVICE_2,
                                    ConstantManager.M180_TEMP_RELAY_DEVICE, ConstantManager.M180_TEMP_RELAY_SMS_DEVICE,
                                    ConstantManager.M180_TEMP_IMP_DEVICE, ConstantManager.M180_INTERNET_DEVICE_ON,
                                    ConstantManager.M180_URL_SERVER_DEVICE, ConstantManager.M180_PORT_SEVER_DEVICE,
                                    ConstantManager.M180_URL_APN_DEVICE, ConstantManager.M180_LOGIN_APN_DEVICE,
                                    ConstantManager.M180_PASSWORD_APN_DEVICE, ConstantManager.M180_TIME_SEND_MESSAGE_DEVICE,
                                    ConstantManager.M180_ADTRACK_DEVICE_ON, ConstantManager.M180_DATE_DEVICE_DATA,
                                    ConstantManager.M180_BATTERY_DEVICE, ConstantManager.M180_LONGITUBE_DEVICE_GPS,
                                    ConstantManager.M180_LATITUBE_DEVICE_GPS, ConstantManager.M180_DATE_DEVICE_GPS,
                                    ConstantManager.M180_COUNT_DEVICE_GPS, ConstantManager.M180_LONGITUBE_DEVICE_LBS,
                                    ConstantManager.M180_LATITUBE_DEVICE_LBS, ConstantManager.M180_DATE_DEVICE_LBS,
                                    ConstantManager.M180_COUNT_DEVICE_LBS, ConstantManager.M180_BALANCE_DEVICE,
                                    ConstantManager.M180_TEMP_DEVICE, ConstantManager.M180_LONGITUBE_DEVICE,
                                    ConstantManager.M180_LATITUBE_DEVICE, ConstantManager.M180_RADUIS_DEVICE))));
            call.enqueue(new Callback<SettingsDeviceResM180>() {
                @Override
                public void onResponse(Call<SettingsDeviceResM180> call, Response<SettingsDeviceResM180> response) {
                    if (response.code() == 200){
                        mDevice = response.body().getSettingsDevice();
                        mModeSp.setSelection(mDevice.getModeDevice()-1);
                        mLangSp.setSelection(mDevice.getLanguageDevice()-1);
                        mNameTv.setText(mDevice.nameDevice);
                        mLinkViewSp.setSelection(mDevice.getGpsUrlDevice()-1);
                        mSMSSp.setSelection(mDevice.getUnsleepSmsDevice()-1);
                        mCallSp.setSelection(mDevice.getWorryCallDevice()-1);
                        mParkHourEt.setText(mDevice.getTimeParkDevice().substring(0,mDevice.getTimeParkDevice().indexOf(":")));
                        mParkMinEt.setText(mDevice.getTimeParkDevice().substring(mDevice.getTimeParkDevice().indexOf(":")));
                        mUTCEt.setText(mDevice.getUtcDevice());
                        if (Integer.valueOf(mDevice.getLbsDeviceOn())==1){
                            mLBSSw.setText(getString(R.string.switchon));
                            mLBSSw.setChecked(TRUE);
                        }else{
                            mLBSSw.setText(getString(R.string.switchoff));
                            mLBSSw.setChecked(FALSE);
                        }
                        if (Integer.valueOf(mDevice.getBalanceDeviceOn())==1){
                            mBalanceSw.setText(getString(R.string.switchon));
                            mBalanceSw.setChecked(TRUE);
                        }else{
                            mBalanceSw.setText(getString(R.string.switchoff));
                            mBalanceSw.setChecked(FALSE);
                        }
                        mMinBalanceEt.setText(mDevice.getMinBalanceDevice());
                        mUssdCommandEt.setText(mDevice.getUssdBalanceDevice());
                        if (Integer.valueOf(mDevice.getButtonDeviceOn())==1){
                            mButtonSw.setText(getString(R.string.switchon));
                            mButtonSw.setChecked(TRUE);
                        }else{
                            mButtonSw.setText(getString(R.string.switchoff));
                            mButtonSw.setChecked(FALSE);
                        }
                        mMoveEt.setText(mDevice.getMoveDevice());
                        if (Integer.valueOf(mDevice.getMoveDeviceOn())==1){
                            mMoveSw.setText(getString(R.string.switchon));
                            mMoveSw.setChecked(TRUE);
                        }else{
                            mMoveSw.setText(getString(R.string.switchoff));
                            mMoveSw.setChecked(FALSE);
                        }
                        mUnMoveEt.setText(mDevice.getUnmoveDevice());
                        if (Integer.valueOf(mDevice.getUnmoveDeviceOn())==1){
                            mUnMoveSw.setText(getString(R.string.switchon));
                            mUnMoveSw.setChecked(TRUE);
                        }else{
                            mUnMoveSw.setText(getString(R.string.switchoff));
                            mUnMoveSw.setChecked(FALSE);
                        }
                        mSpeedEt.setText(mDevice.getSpeedDevice());
                        if (Integer.valueOf(mDevice.getSpeedDeviceOn())==1){
                            mSpeedSw.setText(getString(R.string.switchon));
                            mSpeedSw.setChecked(TRUE);
                        }else{
                            mSpeedSw.setText(getString(R.string.switchoff));
                            mSpeedSw.setChecked(FALSE);
                        }
                        if (Integer.valueOf(mDevice.getJackDeviceOn())==1){
                            mJackSw.setText(getString(R.string.switchon));
                            mJackSw.setChecked(TRUE);
                        }else{
                            mJackSw.setText(getString(R.string.switchoff));
                            mJackSw.setChecked(FALSE);
                        }
                        if (Integer.valueOf(mDevice.getTempDeviceOn())==1){
                            mTempSw.setText(getString(R.string.switchon));
                            mTempSw.setChecked(TRUE);
                        }else{
                            mTempSw.setText(getString(R.string.switchoff));
                            mTempSw.setChecked(FALSE);
                        }
                        if (Integer.valueOf(mDevice.getTempRelaySmsDevice())==1){
                            mTemprelaySMSSw.setText(getString(R.string.switchon));
                            mTemprelaySMSSw.setChecked(TRUE);
                        }else{
                            mTemprelaySMSSw.setText(getString(R.string.switchoff));
                            mTemprelaySMSSw.setChecked(FALSE);
                        }
                        mTempRelayImpEt.setText(mDevice.getTempImpDevice());
                        if (Integer.valueOf(mDevice.getInternetDeviceOn())==1){
                            mActivateInternetSw.setText(getString(R.string.switchon));
                            mActivateInternetSw.setChecked(TRUE);
                        }else{
                            mActivateInternetSw.setText(getString(R.string.switchoff));
                            mActivateInternetSw.setChecked(FALSE);
                        }
                        mTimeSendMessageDeviceEt.setText(mDevice.getTimeSendMessageDevice());
                        if (Integer.valueOf(mDevice.getAdtrackDeviceOn())==1){
                            mAdaptivetrackSw.setText(getString(R.string.switchon));
                            mAdaptivetrackSw.setChecked(TRUE);
                        }else{
                            mAdaptivetrackSw.setText(getString(R.string.switchoff));
                            mAdaptivetrackSw.setChecked(FALSE);
                        }
                        mDistanceEt.setText(mDevice.getRadiusDevice());
                        mDeviceSettingsDTO = new DeviceSettingsDTO(
                                mDevice.getNameDevice(), mDevice.getNameDeviceOn(),
                                mDevice.getPhone1Device(), Integer.valueOf(mDevice.getPhone1DeviceOn()),
                                mDevice.getPhone2Device(), mDevice.getPhone2DeviceOn(),
                                mDevice.getPhone3Device(), mDevice.getPhone3DeviceOn(),
                                mDevice.getPhone4Device(), mDevice.getPhone4DeviceOn(),
                                mDevice.getPhone5Device(), mDevice.getPhone5DeviceOn(),
                                mDevice.getPhone6Device(), mDevice.getPhone6DeviceOn(),
                                mDevice.getPhone7Device(), mDevice.getPhone7DeviceOn(),
                                mDevice.getPhone8Device(), mDevice.getPhone8DeviceOn(),
                                mDevice.getPhone9Device(), mDevice.getPhone9DeviceOn(),
                                mDevice.getUnsleepAlarmDevice(),
                                mDevice.getAlarm1Device(), mDevice.getAlarm1DeviceOn(),
                                mDevice.getAlarm2Device(), mDevice.getAlarm2DeviceOn(),
                                mDevice.getAlarm3Device(), mDevice.getAlarm3DeviceOn(),
                                mDevice.getAlarm4Device(), mDevice.getAlarm4DeviceOn(),
                                mDevice.getAlarm5Device(), mDevice.getAlarm5DeviceOn(),
                                mDevice.getAlarm6Device(), mDevice.getAlarm6DeviceOn(),
                                mDevice.getAlarm7Device(), mDevice.getAlarm7DeviceOn(),
                                mDevice.getAlarm8Device(), mDevice.getAlarm8DeviceOn(),
                                mDevice.getAlarm9Device(), mDevice.getAlarm9DeviceOn(),
                                mDevice.getTempDevice1(),
                                mDevice.getTempDevice2(), mDevice.getTempRelayDevice(),
                                mDevice.getUrlServerDevice(), mDevice.getPortSeverDevice(),
                                mDevice.getUrlApnDevice(), mDevice.getLoginApnDevice(),
                                mDevice.getPasswordApnDevice(), mDevice.getDateDeviceData(),
                                mDevice.getBatteryDevice(), mDevice.getLongitubeDeviceGps(),
                                mDevice.getLatitubeDeviceLbs(), mDevice.getDateDeviceGps(),
                                mDevice.getCountDeviceGps(), mDevice.getLongitubeDeviceLbs(),
                                mDevice.getLatitubeDeviceLbs(), mDevice.getDateDeviceLbs(),
                                mDevice.getCountDeviceLbs(), mDevice.getBalanceDevice(),
                                mDevice.getTempDevice(), mDevice.getLongitubeDevice(),
                                mDevice.getLatitubeDevice(), mDevice.getRadiusDevice());
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<SettingsDeviceResM180> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }

}
