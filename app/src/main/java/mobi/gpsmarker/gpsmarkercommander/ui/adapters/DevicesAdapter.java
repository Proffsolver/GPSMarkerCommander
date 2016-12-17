package mobi.gpsmarker.gpsmarkercommander.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobi.gpsmarker.gpsmarkercommander.R;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {

    Context mContext;
    List<GetDevicesRes.Device> mDevices;

    public DevicesAdapter(List<GetDevicesRes.Device> devices) {
        mDevices = devices;
    }

    @Override
    public DevicesAdapter.DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_list, parent, false);
        return new DeviceViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(DevicesAdapter.DeviceViewHolder holder, int position) {
        GetDevicesRes.Device device = mDevices.get(position);

        holder.mNameDevice.setText(device.getNameDevice());
        holder.mTypeDevice.setText(device.getIdDeviceType());
        holder.mIMEIDevice.setText(device.getImeiDevice());
        holder.mUniqDevice.setText(device.getIdDevice());
        holder.mDateRegDevice.setText(device.getDateRegDevice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        protected TextView mNameDevice, mTypeDevice, mIMEIDevice, mUniqDevice, mDateRegDevice;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            mNameDevice = (TextView) itemView.findViewById(R.id.name_device_txt);
            mTypeDevice = (TextView) itemView.findViewById(R.id.type_device_txt);
            mIMEIDevice = (TextView) itemView.findViewById(R.id.imei_device_txt);
            mUniqDevice = (TextView) itemView.findViewById(R.id.uniq_device_txt);
            mDateRegDevice = (TextView) itemView.findViewById(R.id.date_reg_device_txt);
        }
    }
}
