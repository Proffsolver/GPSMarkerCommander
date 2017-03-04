package mobi.gpsmarker.gpsmarkercommander.data.storage;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceM180DTO implements Parcelable {
    private String mDTOIdDevice;
    private String mDTOIdDeviceType;
    private String mDTOImeiDevice;

    public DeviceM180DTO(String mIdDevice, String mIdDeviceType, String mImeiDevice) {
        mDTOIdDevice = mIdDevice;
        mDTOIdDeviceType = mIdDeviceType;
        mDTOImeiDevice = mImeiDevice;
    }

    protected DeviceM180DTO(Parcel in) {
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
    public static final Parcelable.Creator<DeviceM180DTO> CREATOR = new Parcelable.Creator<DeviceM180DTO>() {
        @Override
        public DeviceM180DTO createFromParcel(Parcel in) {
            return new DeviceM180DTO(in);
        }

        @Override
        public DeviceM180DTO[] newArray(int size) {
            return new DeviceM180DTO[size];
        }
    };

    public String getDTOIdDevice() {
        return mDTOIdDevice;
    }

    public String getDTOIdDeviceType() {
        return mDTOIdDeviceType;
    }
}
