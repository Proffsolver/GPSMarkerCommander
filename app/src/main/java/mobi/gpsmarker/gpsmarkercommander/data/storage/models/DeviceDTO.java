package mobi.gpsmarker.gpsmarkercommander.data.storage.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceDTO implements Parcelable {
    private String mDTOIdDevice;
    private String mDTOIdDeviceType;
    private String mDTOImeiDevice;

    public DeviceDTO(String mIdDevice, String mIdDeviceType, String mImeiDevice) {
        mDTOIdDevice = mIdDevice;
        mDTOIdDeviceType = mIdDeviceType;
        mDTOImeiDevice = mImeiDevice;
    }

    protected DeviceDTO(Parcel in) {
        mDTOIdDevice = in.readString();
        mDTOIdDeviceType = in.readString();
        mDTOImeiDevice = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getDTOImeiDevice() {
        return mDTOImeiDevice;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDTOIdDevice);
        dest.writeString(mDTOIdDeviceType);
        dest.writeString(mDTOImeiDevice);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DeviceDTO> CREATOR = new Parcelable.Creator<DeviceDTO>() {
        @Override
        public DeviceDTO createFromParcel(Parcel in) {
            return new DeviceDTO(in);
        }

        @Override
        public DeviceDTO[] newArray(int size) {
            return new DeviceDTO[size];
        }
    };

    public String getDTOIdDevice() {
        return mDTOIdDevice;
    }

    public String getDTOIdDeviceType() {
        return mDTOIdDeviceType;
    }
}
