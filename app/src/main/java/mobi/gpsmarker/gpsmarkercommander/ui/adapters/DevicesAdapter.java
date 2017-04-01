package mobi.gpsmarker.gpsmarkercommander.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {

    private Context mContext;
    private List<GetDevicesRes.Device> mDevices;
    private CustomClickListener mCustomClickListener;



    public DevicesAdapter(List<GetDevicesRes.Device> devices, CustomClickListener customClickListener) {
        mDevices = devices;
        mCustomClickListener = customClickListener;
    }

    public void setDevices(List<GetDevicesRes.Device> devices) {
        mDevices = devices;
        notifyDataSetChanged();
    }

    @Override
    public DevicesAdapter.DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_list, parent, false);
        return new DeviceViewHolder(convertView, mCustomClickListener);
    }

    @Override
    public void onBindViewHolder(DevicesAdapter.DeviceViewHolder holder, int position) {
        GetDevicesRes.Device device = mDevices.get(position);

        holder.mNameDevice.setText(device.getNameDevice());
        if (Integer.valueOf(device.getIdDeviceType())==1){
            holder.mTypeDevice.setText("m130");}
/*        holder.mIMEIDevice.setText(device.getImeiDevice());
        holder.mUniqDevice.setText(device.getIdDevice());
        holder.mDateRegDevice.setText(device.getDateRegDevice());*/
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }


    public static class DeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView mNameDevice, mTypeDevice, mIMEIDevice, mUniqDevice, mDateRegDevice;
        ImageView mSettings, mCommands, mTrack;

        public CustomClickListener mListener;

        public DeviceViewHolder(View itemView, CustomClickListener customClickListener) {
            super(itemView);
            this.mListener = customClickListener;
            mSettings = (ImageView) itemView.findViewById(R.id.settings_img);
           // mCommands = (ImageView) itemView.findViewById(R.id.commands_img);
            mTrack = (ImageView) itemView.findViewById(R.id.track_img);
            mNameDevice = (TextView) itemView.findViewById(R.id.name_device_txt);
            mTypeDevice = (TextView) itemView.findViewById(R.id.type_device_txt);
/*            mIMEIDevice = (TextView) itemView.findViewById(R.id.imei_device_txt);
            mUniqDevice = (TextView) itemView.findViewById(R.id.uniq_device_txt);
            mDateRegDevice = (TextView) itemView.findViewById(R.id.date_reg_device_txt);*/

            mSettings.setOnClickListener(this);
           // mCommands.setOnClickListener(this);
            mTrack.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener!=null){
                mListener.onDeviceItemClickListener(getAdapterPosition(),v);
            }
        }
    }

    public interface CustomClickListener{
        void onDeviceItemClickListener(int position, View view);    }

}