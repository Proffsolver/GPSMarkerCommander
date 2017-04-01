package mobi.gpsmarker.gpsmarkercommander.data.storage.models;

import android.os.Parcel;
import android.os.Parcelable;

public class M180DeviceSettingsDTO implements Parcelable {
    private String mDTOName_Device;
    private int mDTODisp_name_in_sms;
    private String mDTOLongitube_device;
    private String mDTOLatitube_device;
    private int mDTORadius_device;

    public M180DeviceSettingsDTO(
            String mName_Device,
            int mDisp_name_in_sms,
            String mLongitube_device,
            String mLatitube_device,
            int mRadius_device) {
        mDTOName_Device = mName_Device;
        mDTODisp_name_in_sms = mDisp_name_in_sms;
        mDTOLongitube_device = mLongitube_device;
        mDTOLatitube_device = mLatitube_device;
        mDTORadius_device = mRadius_device;

    }

    protected M180DeviceSettingsDTO(Parcel in) {
        mDTOName_Device = in.readString();
        mDTODisp_name_in_sms = in.readInt();
        mDTOLongitube_device = in.readString();
        mDTOLatitube_device = in.readString();
        mDTORadius_device = in.readInt();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDTOName_Device);
        dest.writeInt(mDTODisp_name_in_sms);
        dest.writeString(mDTOLongitube_device);
        dest.writeString(mDTOLatitube_device);
        dest.writeInt(mDTORadius_device);

    }

    @SuppressWarnings("unused")
    public static final Creator<M180DeviceSettingsDTO> CREATOR = new Creator<M180DeviceSettingsDTO>() {
        @Override
        public M180DeviceSettingsDTO createFromParcel(Parcel in) {
            return new M180DeviceSettingsDTO(in);
        }

        @Override
        public M180DeviceSettingsDTO[] newArray(int size) {
            return new M180DeviceSettingsDTO[size];
        }
    };


    public String getDTOName_Device() { return mDTOName_Device;}
    public int getDTODisp_name_in_sms() { return mDTODisp_name_in_sms;}
    public String  getDTOLongitube_device() { return mDTOLongitube_device;}
    public String  getDTOLatitube_device() { return mDTOLatitube_device;}
    public int  getDTORadius_device() { return mDTORadius_device;}

    public void setDTOName_Device(String DTOName_Device) {
        mDTOName_Device = DTOName_Device;
    }

    public void setDTODisp_name_in_sms(int DTODisp_name_in_sms) {
        mDTODisp_name_in_sms = DTODisp_name_in_sms;
    }

    public void setDTOLongitube_device(String DTOLongitube_device) {
        mDTOLongitube_device = DTOLongitube_device;
    }

    public void setDTOLatitube_device(String DTOLatitube_device) {
        mDTOLatitube_device = DTOLatitube_device;
    }

    public void setDTORadius_device(int DTORadius_device) {
        mDTORadius_device = DTORadius_device;
    }
}
