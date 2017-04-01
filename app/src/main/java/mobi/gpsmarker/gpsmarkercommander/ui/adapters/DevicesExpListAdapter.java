package mobi.gpsmarker.gpsmarkercommander.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.storage.models.DeviceData;
import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;

import static mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager.DEVICE_TYPE;


public class DevicesExpListAdapter extends BaseExpandableListAdapter {

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

        DeviceNamneViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.device_list_group_view, null);
            holder = new DeviceNamneViewHolder();
            holder.mDeviceName = (TextView) convertView.findViewById(R.id.device_name_list_tv);
            holder.mDeviceName.setText(mDeviceData.get(0).toString());
            holder.mDeviceType = (TextView) convertView.findViewById(R.id.device_type_list_tv);
            if (Integer.valueOf(mDeviceData.get(0).toString())==ConstantManager.M180){
                holder.mDeviceType.setText("Маркер "+DEVICE_TYPE[Integer.valueOf(mDeviceData.get(0).toString())]);
            }

            convertView.setTag(holder);

        }
        else {
            holder = (DeviceNamneViewHolder) convertView.getTag();
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


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.device_list_child_view, null);
        }

/*        TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
        textChild.setText(mGroups.get(groupPosition).get(childPosition));

        Button button = (Button)convertView.findViewById(R.id.buttonChild);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"button is pressed",5000).show();
            }
        });*/
/*
        this.mListener = customClickListener;
        mSettings = (ImageView) itemView.findViewById(R.id.settings_img);
        // mCommands = (ImageView) itemView.findViewById(R.id.commands_img);
        mTrack = (ImageView) itemView.findViewById(R.id.track_img);
        mNameDevice = (TextView) itemView.findViewById(R.id.name_device_txt);
        mTypeDevice = (TextView) itemView.findViewById(R.id.type_device_txt);
        mIMEIDevice = (TextView) itemView.findViewById(R.id.imei_device_txt);
        mUniqDevice = (TextView) itemView.findViewById(R.id.uniq_device_txt);
        mDateRegDevice = (TextView) itemView.findViewById(R.id.date_reg_device_txt);*//**//*

        mSettings.setOnClickListener(this);

        mTrack.setOnClickListener(this);*/

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public final class DeviceNamneViewHolder {
        TextView mDeviceName, mDeviceType;
    }

    public final class DeviceStatusViewHolder {
        TextView mDeviceBattery, mDeviceBalance, mDeviceTemp, mDeviceGSM, mDeviceLBS, mDeviceIMEI, mDeviceRefreshtData;
        Button mDeviceDelete, mDeviceRefresh, mDeviceChangeSettings, mDeviceToMap;
    }

}