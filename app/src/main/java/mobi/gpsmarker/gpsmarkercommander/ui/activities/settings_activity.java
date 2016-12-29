package mobi.gpsmarker.gpsmarkercommander.ui.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesOption;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.ui.adapters.DevicesAdapter;
import mobi.gpsmarker.gpsmarkercommander.utils.NetworkStatusChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static mobi.gpsmarker.gpsmarkercommander.R.id.navigation_view;

public class settings_activity extends BaseActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private int mDrawerStart=0;
    private NavigationView mNavigationView;
    private TextView mHeaderEmail, mHeaderMobile;
    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mDataManager = DataManager.getInstance();
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.settings_ccordinator_container);
        // mImageView.setOnClickListener(this);
        mToolbar = (Toolbar) findViewById(R.id.set_toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.set_navigation_drawer);

        mNavigationView = (NavigationView) findViewById(R.id.set_navigation_view);
        //mHeaderImage = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.image_header);
        mHeaderMobile = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_mobile_txt);
        mHeaderEmail = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.user_email_txt);
        setupToolbar();
        setupDrawer();

        loadUserInfo();

        if (savedInstanceState == null) {

        } else{

        }
    }

    private void setupDrawer(){
        // Функция установки дровера
        NavigationView navigationView = (NavigationView) findViewById(R.id.set_navigation_view);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            mNavigationDrawer.openDrawer(GravityCompat.START);
            mDrawerStart = 1;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadUserInfo(){
        mHeaderMobile.setText(mDataManager.getPreferenceManager().getUserMobile());
        mHeaderEmail.setText(mDataManager.getPreferenceManager().getUserEmail());
    }

    private String loadActiveDeviceId(){
        return mDataManager.getPreferenceManager().getActiveDeviceId();
    }


    private void loadDeviceDataSettings(){

/*        if (NetworkStatusChecker.isNetworkAvailable(this)) {
            Call<GetDevicesRes> call = mDataManager.getDevices(new GetDevicesReq("get_device_data", new GetDevicesOption(mDataManager.getPreferenceManager().getUserId(), mDataManager.getPreferenceManager().getAuthToken())));
            call.enqueue(new Callback<GetDevicesRes>() {
                @Override
                public void onResponse(Call<GetDevicesRes> call, Response<GetDevicesRes> response) {
                    if (response.code() == 200){
                        mDevices = response.body().getDevices();
                        mDevicesAdapter = new DevicesAdapter(mDevices, new DevicesAdapter.CustomClickListener() {
                            @Override
                            public void onDeviceItemClickListener(int position, View v) {
                                //  showSnackbar("Устройство с индексом "+ position);
                                switch (v.getId()) {
                                    case R.id.settings_img:
                                        showSnackbar("Настройки");
                                        //  mDevices.get(position).
                                        saveActiveDeviceId(mDevices.get(position).);
                                        Intent settingsIntent = new Intent(MainActivity.this, settings_activity.class);
                                        // profileIntent.putExtra(ConstantManager.PARCELABLE_KEY, userDTO);
                                        startActivity(settingsIntent);
                                        break;
                                    case R.id.commands_img:
                                        showSnackbar("Команды");
                                        saveActiveDeviceId(mDevices.get(position).getIdDevice());
                                        Intent commandsIntent = new Intent(MainActivity.this, control_activity.class);
                                        // profileIntent.putExtra(ConstantManager.PARCELABLE_KEY, userDTO);
                                        startActivity(commandsIntent);
                                        break;
                                    case R.id.track_img:
                                        showSnackbar("Трэки");
                                        saveActiveDeviceId(mDevices.get(position).getIdDevice());
                                        Intent trackIntent = new Intent(MainActivity.this, viewtrack_activity.class);
                                        // profileIntent.putExtra(ConstantManager.PARCELABLE_KEY, userDTO);
                                        startActivity(trackIntent);
                                        break;
                                }
                            }
                        });
                        mRecyclerView.setAdapter(mDevicesAdapter);
                        mDevicesAdapter.notifyDataSetChanged();
                    } else if (response.code() == 404){
                        showSnackbar("Неверный логин или пароль!");
                    } else {
                        showSnackbar("Что-то пошло не так!");
                    }
                }*/

/*                @Override
                public void onFailure(Call<GetDevicesRes> call, Throwable t) {

                }
            });
        }else{
            showSnackbar("Сеть на данный момент не доступна, попробуйте позже.");
        }*/
    }
}
