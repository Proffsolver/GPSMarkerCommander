package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceTypeOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceTypeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.ErrorHandler;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private Spinner mSpinner;
    private List<GetDevicesRes.Device> mDevices;
    private DevicesAdapter mDevicesAdapter;
    private RecyclerView mRecyclerView;
    private DevicesAdapter.CustomClickListener mCustomClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

/*    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }*/

    @Override
    protected void onResume() {
        mRecyclerView = (RecyclerView) findViewById(R.id.device_list);
        List<GetDevicesRes.Device> mDevices  = new ArrayList();
//        loadDeviceDataNetwork();
        mRecyclerView.setAdapter(new DevicesAdapter(mDevices, mCustomClickListener));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        loadDeviceDataNetwork();
        loadUserInfo();
        super.onResume();

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
/*                if (item.getItemId() == R.id.commands_menu){
                    mNavigationDrawer.closeDrawer(GravityCompat.START);}*/
/*                if (item.getItemId() == R.id.events_menu){
                   // Intent teamIntent = new Intent(MainActivity.this, UserListActivity.class);
                  //  startActivity(teamIntent);
                    mNavigationDrawer.closeDrawer(GravityCompat.START);}*/
/*                if (item.getItemId() == R.id.maps_menu){
                        mNavigationDrawer.closeDrawer(GravityCompat.START);}*/
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


    private void loadDeviceDataNetwork(){

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
                                                Intent trackIntent = new Intent(MainActivity.this, viewtrack_activity.class);
                                                // profileIntent.putExtra(ConstantManager.PARCELABLE_KEY, trackDTO);
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
    }

    private void loadUserInfo(){
        mHeaderMobile.setText(mDataManager.getPreferenceManager().getUserMobile());
        mHeaderEmail.setText(mDataManager.getPreferenceManager().getUserEmail());
    }
}