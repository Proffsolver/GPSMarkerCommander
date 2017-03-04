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
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.SettingsDeviceResM180;
import mobi.gpsmarker.gpsmarkercommander.data.storage.DeviceM180DTO;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity /*implements View.OnClickListener*/  {

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
    private SettingsDeviceResM180.Datum mDevice;
    private DevicesAdapter mDevicesAdapter;
    private RecyclerView mRecyclerView;
    private DevicesAdapter.CustomClickListener mCustomClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate");

        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //mHeaderImage = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.image_header);
        mHeaderMobile = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_mobile_txt);
        mHeaderEmail = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_email_txt);
/*        mSpinner = (Spinner) findViewById(R.id.mode_sp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Mode_m180, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        mSpinner.setAdapter(adapter)*/;
        mDataManager = DataManager.getInstance();
   //     mImageView = (ImageView)findViewById(R.id.settings_img);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_ccordinator_container);
       // mImageView.setOnClickListener(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        //mFab = (FloatingActionButton) findViewById(R.id.main_fab);
    //    mLoadButton = (Button) findViewById(R.id.load_data);
        mRecyclerView = (RecyclerView) findViewById(R.id.device_list);
        List<GetDevicesRes.Device> mDevices  = new ArrayList();
        loadDeviceDataNetwork();
        mRecyclerView.setAdapter(new DevicesAdapter(mDevices, mCustomClickListener));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        setupToolbar();
        setupDrawer();
        loadUserInfo();
        //loadUserInfoValue();
       // mLoadButton.setOnClickListener(this);

        if (savedInstanceState == null) {

        } else{

        }

    }

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }*/

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
        // Обработка BackPress
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
                if (item.getItemId() == R.id.events_menu){
                   // Intent teamIntent = new Intent(MainActivity.this, UserListActivity.class);
                  //  startActivity(teamIntent);
                    mNavigationDrawer.closeDrawer(GravityCompat.START);}
/*                if (item.getItemId() == R.id.maps_menu){
                        mNavigationDrawer.closeDrawer(GravityCompat.START);}*/
                if (item.getItemId() == R.id.settings_menu){
                        mNavigationDrawer.closeDrawer(GravityCompat.START);}
                return false;
            }
        });
    }

    private void loadDeviceDataNetwork(){

        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<GetDevicesRes> call = mDataManager.getDevices(new GetDevicesReq("get_devices", new GetDevicesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<GetDevicesRes>() {
                @Override
                public void onResponse(Call<GetDevicesRes> call, Response<GetDevicesRes> response) {
                    if (response.code() == 200){
                        mDevices = response.body().getDevices();
                        mDevicesAdapter = new DevicesAdapter(mDevices, new DevicesAdapter.CustomClickListener() {
                            @Override
                            public void onDeviceItemClickListener(int position, View v) {
                              //  showSnackbar("Устройство с индексом "+ position);
                                if (Integer.valueOf(mDevices.get(position).getIdDeviceType())==1){
                                    switch (v.getId()) {
                                        case R.id.settings_img:
                                            showSnackbar("Настройки");
                                            DeviceM180DTO deviceM180DTO = new DeviceM180DTO(mDevices.get(position).getIdDevice(), mDevices.get(position).getIdDeviceType(), mDevices.get(position).getImeiDevice());
                                            Intent settingsIntent = new Intent(MainActivity.this, settings_m180_activity.class);
                                            settingsIntent.putExtra(ConstantManager.PARCELABLE_KEY, deviceM180DTO);
                                            startActivity(settingsIntent);
                                            break;
                                        case R.id.track_img:
                                            showSnackbar("Трэки");
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