package mobi.gpsmarker.gpsmarkercommander.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceDTO;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceData;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.M180SettingsActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.MainActivity;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.viewtrack_activity;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager.DEVICE_TYPE;


public class DevicesExpListAdapter extends BaseExpandableListAdapter implements ExpandableListView.OnChildClickListener {

    private ArrayList<DeviceData> mDeviceData;
    private ArrayList<ArrayList<String>> mGroups;
    private Context mContext;

    public DevicesExpListAdapter (Context context,ArrayList<ArrayList<String>> groups, ArrayList<DeviceData> deviceData){
        mContext = context;
        mGroups = groups;
        mDeviceData = deviceData;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {

        DeviceNameViewHolder holderGr;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.device_list_group_view, null);
            holderGr = new DeviceNameViewHolder();
            holderGr.mDeviceName = (TextView) convertView.findViewById(R.id.device_name_list_tv);
            holderGr.mDeviceName.setText(mDeviceData.get(groupPosition).getsDDNameDevice().toString());
            holderGr.mDeviceType = (TextView) convertView.findViewById(R.id.device_type_list_tv);
            if (Integer.valueOf(mDeviceData.get(groupPosition).getsDDIdDeviceType().toString())==ConstantManager.M180){
                holderGr.mDeviceType.setText("Маркер m180");
            }

            convertView.setTag(holderGr);

        }
        else {
            holderGr = (DeviceNameViewHolder) convertView.getTag();
        }
        ImageView imgGroup = (ImageView) convertView.findViewById(R.id.group_view_iv);
        if (isExpanded){
            imgGroup.setImageResource(R.drawable.ic_remove_black_24dp);
        }
        else{
            //Изменяем что-нибудь, если текущая Group скрыта
            imgGroup.setImageResource(R.drawable.ic_add_black_24dp);
        }


        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

       // KeyItem childItem = (KeyItem) getChild(groupPosition, childPosition);
        DeviceStatusViewHolder holderCh;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.device_list_child_view, null);
            holderCh = new DeviceStatusViewHolder();
            holderCh.mDeviceBalance = (TextView) convertView.findViewById(R.id.device_curr_charge_tv);
            holderCh.mDeviceBattery = (TextView) convertView.findViewById(R.id.device_curr_balance_tv);
            holderCh.mDeviceTemp = (TextView) convertView.findViewById(R.id.device_curr_temp_tv);
            holderCh.mDeviceGSM = (TextView) convertView.findViewById(R.id.device_curr_gsm_tv);
            holderCh.mDeviceLBS = (TextView) convertView.findViewById(R.id.device_curr_lbs_tv);
            holderCh.mDeviceRefreshtData = (TextView) convertView.findViewById(R.id.device_last_date_transfer_tv);
            holderCh.mDeviceIMEI = (TextView) convertView.findViewById(R.id.device_imei_list_tv);
            holderCh.mDeviceChangeSettings = (ImageView) convertView.findViewById(R.id.device_change_list_tv);
            holderCh.mDeviceToMap = (ImageView) convertView.findViewById(R.id.device_map_list_tv);
            holderCh.mDeviceDelete = (ImageView) convertView.findViewById(R.id.device_delete_list_tv);
            holderCh.mDeviceRefresh = (ImageView) convertView.findViewById(R.id.device_refresh_list_tv);
            holderCh.mDeviceBalance.setText(mDeviceData.get(groupPosition).getsDDBalanceDevice());
            holderCh.mDeviceBattery.setText(mDeviceData.get(groupPosition).getsDDBatteryDevice());
            holderCh.mDeviceTemp.setText(mDeviceData.get(groupPosition).getsDDTempDevice());
            holderCh.mDeviceGSM.setText(mDeviceData.get(groupPosition).getsDDCountDeviceGps());
            holderCh.mDeviceLBS.setText(mDeviceData.get(groupPosition).getsDDCountDeviceLbs());
            holderCh.mDeviceRefreshtData.setText("Связь: "+mDeviceData.get(groupPosition).getsDDDateDeviceData());
            holderCh.mDeviceIMEI.setText("IMEI: "+mDeviceData.get(groupPosition).getsDDImeiDevice());


       //     holderCh.mDeviceDelete.setOnClickListener(DeviceStatusViewHolder);
            convertView.setTag(holderCh);
        } else
            {
                holderCh = (DeviceStatusViewHolder) convertView.getTag();
            }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public final class DeviceNameViewHolder{
        TextView mDeviceName, mDeviceType;

    }

    public final class DeviceStatusViewHolder{
        TextView mDeviceBattery, mDeviceBalance, mDeviceTemp, mDeviceGSM, mDeviceLBS, mDeviceIMEI, mDeviceRefreshtData;
        ImageView mDeviceDelete, mDeviceRefresh, mDeviceChangeSettings, mDeviceToMap;

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

}