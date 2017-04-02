package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.CurrentCoordinateData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.CurrentCoordinateOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.CurrentCoordinateReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusData;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.CurrentCoordinateRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180StatusRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.CoordinateDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceData;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesExpListAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;

public class MainActivity extends BaseActivity implements View.OnClickListener  {

    private static final String TAG = ConstantManager.TAG_PREFIX+"Main Activity";
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private int mDrawerStart=0;
    private FloatingActionButton mFab;
    private DataManager mDataManager;
    private NavigationView mNavigationView;
    private TextView mHeaderEmail, mHeaderMobile;
    private List<GetDevicesRes.Device> mDevices;
    private CoordinateDTO mCoordinateDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate");
        mFab = (FloatingActionButton) findViewById(R.id.main_fab);
        mFab.setOnClickListener(this);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //mHeaderImage = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.image_header);
        mHeaderMobile = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_mobile_txt);
        mHeaderEmail = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_email_txt);
        mDataManager = DataManager.getInstance();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_ccordinator_container);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        setupToolbar();
        setupDrawer();
     //   loadUserInfo();
        if (savedInstanceState == null) {

        } else{

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_fab:
                Intent addDeviceIntent = new Intent(MainActivity.this, AddDeviceActivity.class);
                startActivity(addDeviceIntent);
                break;
        }
    }

/*    private void loadNameDevices(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.getDeviceType(new DeviceTypeReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICE_TYPE], new DeviceTypeOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<UserAccoutActionRes>() {
                @Override
                public void onResponse(Call<UserAccoutActionRes> call, Response<UserAccoutActionRes> response) {
                    if (response.code() == 200){
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICE_TYPE));
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICE_TYPE));
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
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            mNavigationDrawer.openDrawer(GravityCompat.START);
            mDrawerStart = 1;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSnackbar(String message){
        Snackbar.make(mCoordinatorLayout, message,Snackbar.LENGTH_LONG).show();
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerStart == 1){
            mDrawerStart = 0;
            mNavigationDrawer.closeDrawer(GravityCompat.START);
        } else {super.onBackPressed();}
    }



    private void setupDrawer(){
        // Функция установки дровера
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem item){
                item.setChecked(true);
                if (item.getItemId() == R.id.change_pass_menu){
                    Intent userChangePassIntent = new Intent(MainActivity.this, UserChangePasswordActivity.class);
                    mDataManager.getPreferenceManager().saveUserCurrentActionWAccount("3");
                    startActivity(userChangePassIntent);
                    mNavigationDrawer.closeDrawer(GravityCompat.START);}
                if (item.getItemId() == R.id.change_user_data_menu){
                    Intent userDataChangeIntent = new Intent(MainActivity.this, UserChangeDataActivity.class);
                    mDataManager.getPreferenceManager().saveUserCurrentActionWAccount("4");
                    startActivity(userDataChangeIntent);
                    mNavigationDrawer.closeDrawer(GravityCompat.START);}
                return false;
            }
        });
    }


    private void restartAdapter(){
        loadDeviceDataNetwork((ExpandableListView)findViewById(R.id.exListView));
    }

    @Override
    protected void onResume() {
        loadDeviceDataNetwork((ExpandableListView)findViewById(R.id.exListView));
        super.onResume();
    }

    private void loadDeviceDataNetwork(final ExpandableListView listView){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<GetDevicesRes> call = mDataManager.getDevicesFromNetwork(new GetDevicesReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES], new GetDevicesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<GetDevicesRes>() {
                @Override
                public void onResponse(Call<GetDevicesRes> call, Response<GetDevicesRes> response) {
                    if (response.code() == 200){
                        mDevices = response.body().getDevices();
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));
                            final ArrayList<DeviceData> deviceData = new ArrayList<DeviceData>();
                            ArrayList<String> children = new ArrayList<String>();
                            ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
                            for (int i = 0 ; i<mDevices.size(); i++){
                                children.add(mDevices.get(i).getIdDevice());
                                groups.add(children);
                                ArrayList forStatus = new ArrayList(loadStatusSyncFromInternet(mDevices.get(i).getIdDevice()));
                                deviceData.add(0, new DeviceData(mDevices.get(i).getIdDevice(),
                                        mDevices.get(i).getIdDeviceType(),
                                        mDevices.get(i).getNameDevice(),
                                        mDevices.get(i).getImeiDevice(),
                                        forStatus.get(0).toString(),
                                        forStatus.get(1).toString(),
                                        forStatus.get(2).toString(),
                                        forStatus.get(3).toString(),
                                        forStatus.get(4).toString(),
                                        forStatus.get(5).toString()));
                                children = new ArrayList<String>();
                            }
                            final DevicesExpListAdapter adapter = new DevicesExpListAdapter(getApplicationContext(), groups, deviceData);
                            listView.setAdapter(adapter);
                            listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                @Override
                                public boolean onChildClick(final ExpandableListView parent, View v, final int groupPosition, int childPosition, long id) {
                                    ImageView mDeviceRefresh = (ImageView) v.findViewById(R.id.device_refresh_list_tv);
                                    ImageView mDeviceDelete = (ImageView) v.findViewById(R.id.device_delete_list_tv);
                                    ImageView mDeviceToMap = (ImageView) v.findViewById(R.id.device_map_list_tv);
                                    ImageView mDeviceChangeSettings = (ImageView) v.findViewById(R.id.device_change_list_tv);
                                    final TextView mDeviceBalance = (TextView) findViewById(R.id.device_curr_charge_tv);
                                    final TextView mDeviceBattery = (TextView) findViewById(R.id.device_curr_balance_tv);
                                    final TextView mDeviceTemp = (TextView) findViewById(R.id.device_curr_temp_tv);
                                    final TextView mDeviceGSM = (TextView) findViewById(R.id.device_curr_gsm_tv);
                                    final TextView mDeviceLBS = (TextView) findViewById(R.id.device_curr_lbs_tv);
                                    final TextView mDeviceRefreshtData = (TextView) findViewById(R.id.device_last_date_transfer_tv);
                                    final String idDevice = adapter.getGroup(groupPosition).toString().substring(1, adapter.getGroup(groupPosition).toString().length() - 1);
                                    showSnackbar(idDevice);
                                    View.OnClickListener click = new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            switch (v.getId()){
                                                case R.id.device_refresh_list_tv:
                                                    ArrayList refreshDeviceData = loadStatusSyncFromInternet(idDevice);
                                                    mDeviceBalance.setText(refreshDeviceData.get(0).toString());
                                                    mDeviceBattery.setText(refreshDeviceData.get(1).toString());
                                                    mDeviceTemp.setText(refreshDeviceData.get(5).toString());
                                                    mDeviceGSM.setText(refreshDeviceData.get(2).toString());
                                                    mDeviceLBS.setText(refreshDeviceData.get(3).toString());
                                                    mDeviceRefreshtData.setText("Связь: "+refreshDeviceData.get(4).toString());
                                                    break;
                                                case R.id.device_delete_list_tv:
                                                    if (deleteDevice(idDevice) == true){
                                                        restartAdapter();
                                                    }
                                                    else {showSnackbar("Удалить устройство не удалось, обратитесь к разработчикам!");}
                                                    break;
                                                case R.id.device_map_list_tv:
                                                    loadCurrentCoordinateSyncFromInternet(idDevice);
                                                    Intent trackIntent = new Intent(MainActivity.this, viewtrack_activity.class);
                                                    trackIntent.putExtra(ConstantManager.PARCELABLE_KEY, mCoordinateDTO);
                                                    startActivity(trackIntent);
                                                    showSnackbar("Есть контакт map");
                                                    break;
                                                case R.id.device_change_list_tv:
                                                    DeviceDTO deviceDTO = new DeviceDTO(deviceData.get(groupPosition).getsDDIdDevice(), deviceData.get(groupPosition).getsDDIdDeviceType(), deviceData.get(groupPosition).getsDDImeiDevice());
                                                    mDataManager.getPreferenceManager().saveCurrentDeviceIdType(deviceData.get(groupPosition).getsDDIdDeviceType());
                                                    mDataManager.getPreferenceManager().saveCurrentDeviceId(deviceData.get(groupPosition).getsDDIdDevice());
                                                    Intent settingsIntent = new Intent(MainActivity.this, M180SettingsActivity.class);
                                                    settingsIntent.putExtra(ConstantManager.PARCELABLE_KEY, deviceDTO);
                                                    startActivity(settingsIntent);
                                                    showSnackbar("Есть контакт change");
                                                    break;
                                            }
                                        }};
                                    mDeviceRefresh.setOnClickListener(click);
                                    mDeviceDelete.setOnClickListener(click);
                                    mDeviceToMap.setOnClickListener(click);
                                    mDeviceChangeSettings.setOnClickListener(click);
                                    return false;
                                }
                            });
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));
                        }
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }
                @Override
                public void onFailure(Call<GetDevicesRes> call, Throwable t) {
                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }


/*    private void loadDeviceDataNetwork(){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<GetDevicesRes> call = mDataManager.getDevicesFromNetwork(new GetDevicesReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES], new GetDevicesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<GetDevicesRes>() {
                @Override
                public void onResponse(Call<GetDevicesRes> call, Response<GetDevicesRes> response) {
                    if (response.code() == 200){
                        mDevices = response.body().getDevices();
                        if (response.body().getCode().equals(ConstantManager.NO_ERROR)){
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));
                            mDevicesAdapter = new DevicesAdapter(mDevices, new DevicesAdapter.CustomClickListener() {
                                @Override
                                public void onDeviceItemClickListener(int position, View v) {
                                    if (Integer.valueOf(mDevices.get(position).getIdDeviceType())==1){
                                        switch (v.getId()) {
                                            case R.id.settings_img:
                                                //showSnackbar("Настройки");
                                                DeviceDTO deviceDTO = new DeviceDTO(mDevices.get(position).getIdDevice(), mDevices.get(position).getIdDeviceType(), mDevices.get(position).getImeiDevice());
                                                mDataManager.getPreferenceManager().saveCurrentDeviceIdType(mDevices.get(position).getIdDeviceType());
                                                mDataManager.getPreferenceManager().saveCurrentDeviceId(mDevices.get(position).getIdDevice());
                                                Intent settingsIntent = new Intent(MainActivity.this, M180SettingsActivity.class);
                                                settingsIntent.putExtra(ConstantManager.PARCELABLE_KEY, deviceDTO);
                                                startActivity(settingsIntent);
                                                break;
                                            case R.id.track_img:
                                                //showSnackbar("Трэки");
                                                loadCurrentCoordinateSyncFromInternet(mDevices.get(position).getIdDevice());
                                                Intent trackIntent = new Intent(MainActivity.this, viewtrack_activity.class);
                                                trackIntent.putExtra(ConstantManager.PARCELABLE_KEY, mCoordinateDTO);
                                                startActivity(trackIntent);
                                                break;
                                                }
                                        }
                                }
                            });
                            mRecyclerView.setAdapter(mDevicesAdapter);
                            mDevicesAdapter.notifyDataSetChanged();
                        }else{
                            showSnackbar(ErrorHandler.getErrorHandler(response.body().getCode(),ConstantManager.GET_DEVICES));

                        }
                    } else if (response.code() == 404){
                        showSnackbar("Что-то пошло не так!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }

                @Override
                public void onFailure(Call<GetDevicesRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
    }*/


    private ArrayList loadStatusSyncFromInternet(String currentDeviceID){
        ArrayList forStatus = new ArrayList();
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<M180StatusRes> call = mDataManager.getM180Status(
                    new M180StatusReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new M180StatusOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), currentDeviceID,
                                    new M180StatusData(ConstantManager.M180_BATTERY_DEVICE,
                                            ConstantManager.M180_BALANCE_DEVICE,
                                            ConstantManager.M180_COUNT_DEVICE_GPS,
                                            ConstantManager.M180_COUNT_DEVICE_LBS,
                                            ConstantManager.M180_DATE_DEVICE_DATA,
                                            ConstantManager.M180_TEMP_DEVICE))));
            try {
                Response<M180StatusRes> mStatus = call.execute();
                for (int i=0; i<mStatus.body().getData().size(); i++){forStatus.add(i,"0");}
                for (int i=0; i<mStatus.body().getData().size(); i++){
                    if (mStatus.body().getData().get(i).getBalanceDevice()!=null){
                        forStatus.set(0,mStatus.body().getData().get(i).getBalanceDevice());
                    }
                    if (mStatus.body().getData().get(i).getBatteryDevice()!=null){
                        forStatus.set(1,mStatus.body().getData().get(i).getBatteryDevice());
                    }
                    if (mStatus.body().getData().get(i).getCountDeviceGps()!=null){
                        forStatus.set(2,mStatus.body().getData().get(i).getCountDeviceGps());
                    }
                    if (mStatus.body().getData().get(i).getCountDeviceLbs()!=null){
                        forStatus.set(3,mStatus.body().getData().get(i).getCountDeviceLbs());
                    }
                    if (mStatus.body().getData().get(i).getDateDeviceData()!=null){
                        forStatus.set(4, mStatus.body().getData().get(i).getDateDeviceData());
                    }
                    if (mStatus.body().getData().get(i).getTempDevice()!=null){
                        forStatus.set(5,mStatus.body().getData().get(i).getTempDevice());
                    }
                }
                //   mCoordinateDTO = new CoordinateDTO(forStatus.get(0).toString(),forStatus.get(1).toString(),forStatus.get(2).toString(),forStatus.get(3).toString(),forStatus.get(4).toString(),forStatus.get(5).toString(),));
            } catch (IOException e) {
            }
        }
        return forStatus;
    }
    private void loadCurrentCoordinateSyncFromInternet(String currentDeviceID){
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<CurrentCoordinateRes> call = mDataManager.getCurrentCoordinate(
                    new CurrentCoordinateReq(ConstantManager.JSON_METHODS[ConstantManager.GET_DEVICES_DATA],
                            new CurrentCoordinateOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), currentDeviceID,
                                    new CurrentCoordinateData(
                                            ConstantManager.M180_GPS_DEVICE_ON,
                                            ConstantManager.M180_LBS_DEVICE_ON,
                                            ConstantManager.M180_LONGITUBE_DEVICE_GPS,
                                            ConstantManager.M180_LATITUBE_DEVICE_GPS,
                                            ConstantManager.M180_DATE_DEVICE_GPS,
                                            ConstantManager.M180_LONGITUBE_DEVICE_LBS,
                                            ConstantManager.M180_LATITUBE_DEVICE_LBS,
                                            ConstantManager.M180_DATE_DEVICE_LBS))));
            try {
                Response<CurrentCoordinateRes> mCurrentCoordinate = call.execute();
                ArrayList forDTOCurrCoord = new ArrayList();
                for (int i=0; i<mCurrentCoordinate.body().getData().size(); i++){forDTOCurrCoord.add(i,"0");}
                for (int i=0; i<mCurrentCoordinate.body().getData().size(); i++){
                    if (mCurrentCoordinate.body().getData().get(i).getDateDeviceGps()!=null){
                        forDTOCurrCoord.set(0,mCurrentCoordinate.body().getData().get(i).getDateDeviceGps());
                    }
                    if (mCurrentCoordinate.body().getData().get(i).getDateDeviceLbs()!=null){
                        //    mCoordinateDTO.setDTODate_device_lbs(mCurrentCoordinate.body().getData().get(i).getDateDeviceLbs());
                        forDTOCurrCoord.set(1,mCurrentCoordinate.body().getData().get(i).getDateDeviceLbs());
                    }
                    if (mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceGps()!=null){
                        //             mCoordinateDTO.setDTOLatitube_device_gps(mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceGps());
                        forDTOCurrCoord.set(2,mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceGps());
                    }
                    if (mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceLbs()!=null){
                        //            mCoordinateDTO.setDTOLatitube_device_lbs(mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceLbs());
                        forDTOCurrCoord.set(3,mCurrentCoordinate.body().getData().get(i).getLatitubeDeviceLbs());
                    }
                    if (mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceGps()!=null){
                        String str = mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceGps();
                        forDTOCurrCoord.set(4, mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceGps());
                    }
                    if (mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceLbs()!=null){
                        //             mCoordinateDTO.setDTOLongitube_device_lbs(mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceLbs());
                        forDTOCurrCoord.set(5,mCurrentCoordinate.body().getData().get(i).getLongitubeDeviceLbs());
                    }
                    if ((mCurrentCoordinate.body().getData().get(i).getGpsDeviceOn()!=0)&&(Integer.valueOf(forDTOCurrCoord.get(6).toString())==0)){
                        //           mCoordinateDTO.setDTOgps_device_on(mCurrentCoordinate.body().getData().get(i).getGpsDeviceOn());
                        forDTOCurrCoord.set(6,String.valueOf(mCurrentCoordinate.body().getData().get(i).getGpsDeviceOn()));
                    } else {
                        forDTOCurrCoord.set(6,"0");
                    }
                    if ((mCurrentCoordinate.body().getData().get(i).getLbsDeviceOn()!=0)&&(Integer.valueOf(forDTOCurrCoord.get(7).toString())==0)){
                        //         mCoordinateDTO.setDTOlbs_device_on(mCurrentCoordinate.body().getData().get(i).getLbsDeviceOn());
                        forDTOCurrCoord.set(7,String.valueOf(mCurrentCoordinate.body().getData().get(i).getLbsDeviceOn()));}
                    else {
                        //       mCoordinateDTO.setDTOlbs_device_on(0);
                        forDTOCurrCoord.set(7,"0");
                    }
                }
                mCoordinateDTO = new CoordinateDTO(forDTOCurrCoord.get(0).toString(),forDTOCurrCoord.get(1).toString(),forDTOCurrCoord.get(2).toString(),forDTOCurrCoord.get(3).toString(),forDTOCurrCoord.get(4).toString(),forDTOCurrCoord.get(5).toString(),Integer.valueOf(forDTOCurrCoord.get(6).toString()),Integer.valueOf(forDTOCurrCoord.get(7).toString()));
            } catch (IOException e) {
            }
        }
    }

    private void loadUserInfo(){
        mHeaderMobile.setText(mDataManager.getPreferenceManager().getUserMobile());
        mHeaderEmail.setText(mDataManager.getPreferenceManager().getUserEmail());
    }

    private boolean deleteDevice(String currentDeviceID){
        boolean acceptDelete = false;
        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<UserAccoutActionRes> call = mDataManager.deviceDelete(new DeviceDeleteReq(ConstantManager.JSON_METHODS[ConstantManager.DEVICE_DELETE], new DeviceDeleteOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken(), currentDeviceID)));
            try {
                Response<UserAccoutActionRes> mDeviceDelete = call.execute();
                if (mDeviceDelete.body().getCode().equals(ConstantManager.NO_ERROR)){
                    acceptDelete = true;
                    showSnackbar(ErrorHandler.getErrorHandler(mDeviceDelete.body().getCode(),ConstantManager.DEVICE_DELETE));
                }else{
                    showSnackbar(ErrorHandler.getErrorHandler(mDeviceDelete.body().getCode(),ConstantManager.DEVICE_DELETE));
                    acceptDelete = false;
                }
            } catch (IOException e) {

            }
/*            call.enqueue(new Callback<UserAccoutActionRes>() {
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
            });*/
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }
        return acceptDelete;
    }
}