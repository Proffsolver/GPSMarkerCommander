package mobi.gpsmarker.gpsmarkercommander.data.storage.models;

import android.os.Parcel;
import android.os.Parcelable;

public class M180DeviceSettingsDTO implements Parcelable {
    private String mDTOName_Device;
    private int mDTODisp_name_in_sms;
    private String mDTOTemp_device_1;
    private String mDTOTemp_device_2;
    private String mDTOUrl_server_device;
    private int mDTOPort_sever_device;
    private String mDTOUrl_apn_device;
    private String mDTOLogin_apn_device;
    private String mDTOPassword_apn_device;
    private String mDTODate_device_data;
    private String mDTOBattery_device;
/*    private int mDTOLongitube_device_gps;
    private int mDTOLatitube_device_gps;
    private String mDTODate_device_gps;
    private String mDTOCount_device_gps;
    private int mDTOLongitube_device_lbs;
    private int mDTOLatitube_device_lbs;
    private String mDTODate_device_lbs;
    private String mDTOCount_device_lbs;*/
    private String mDTOBalance_device;
    private String mDTOTemp_device;
    private String mDTOLongitube_device;
    private String mDTOLatitube_device;
    private int mDTORadius_device;

    public M180DeviceSettingsDTO(
            String mName_Device, int mDisp_name_in_sms,
            String mTemp_device_1,
            String mTemp_device_2,
            String mUrl_server_device, int mPort_sever_device,
            String mUrl_apn_device, String mLogin_apn_device,
            String mPassword_apn_device, String mDate_device_data,
            String mBattery_device, /*int mLongitube_device_gps,
            int mLatitube_device_gps, String mDate_device_gps,
            String mCount_device_gps, int mLongitube_device_lbs,
            int mLatitube_device_lbs, String mDate_device_lbs,
            String mCount_device_lbs, */String mBalance_device,
            String mTemp_device, String mLongitube_device,
            String mLatitube_device, int mRadius_device) {
        mDTOName_Device = mName_Device;
        mDTODisp_name_in_sms = mDisp_name_in_sms;
        mDTOTemp_device_1 = mTemp_device_1;
        mDTOTemp_device_2 = mTemp_device_2;
        mDTOUrl_server_device = mUrl_server_device;
        mDTOPort_sever_device = mPort_sever_device;
        mDTOUrl_apn_device = mUrl_apn_device;
        mDTOLogin_apn_device = mLogin_apn_device;
        mDTOPassword_apn_device = mPassword_apn_device;
        mDTODate_device_data = mDate_device_data;
        mDTOBattery_device = mBattery_device;
/*        mDTOLongitube_device_gps = mLongitube_device_gps;
        mDTOLatitube_device_gps = mLatitube_device_gps;
        mDTODate_device_gps = mDate_device_gps;
        mDTOCount_device_gps = mCount_device_gps;
        mDTOLongitube_device_lbs = mLongitube_device_lbs;
        mDTOLatitube_device_lbs = mLatitube_device_lbs;
        mDTODate_device_lbs = mDate_device_lbs;
        mDTOCount_device_lbs = mCount_device_lbs;*/
        mDTOBalance_device = mBalance_device;
        mDTOTemp_device = mTemp_device;
        mDTOLongitube_device = mLongitube_device;
        mDTOLatitube_device = mLatitube_device;
        mDTORadius_device = mRadius_device;

    }

    protected M180DeviceSettingsDTO(Parcel in) {
        mDTOName_Device = in.readString();
        mDTODisp_name_in_sms = in.readInt();
        mDTOTemp_device_1 = in.readString();
        mDTOTemp_device_2 = in.readString();
        mDTOUrl_server_device = in.readString();
        mDTOPort_sever_device = in.readInt();
        mDTOUrl_apn_device = in.readString();
        mDTOLogin_apn_device = in.readString();
        mDTOPassword_apn_device = in.readString();
        mDTODate_device_data = in.readString();
        mDTOBattery_device = in.readString();
/*        mDTOLongitube_device_gps = in.readInt();
        mDTOLatitube_device_gps = in.readInt();
        mDTODate_device_gps = in.readString();
        mDTOCount_device_gps = in.readString();
        mDTOLongitube_device_lbs = in.readInt();
        mDTOLatitube_device_lbs = in.readInt();
        mDTODate_device_lbs = in.readString();
        mDTOCount_device_lbs = in.readString();*/
        mDTOBalance_device = in.readString();
        mDTOTemp_device = in.readString();
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
        dest.writeString(mDTOTemp_device_1);
        dest.writeString(mDTOTemp_device_2);
        dest.writeString(mDTOUrl_server_device);
        dest.writeInt(mDTOPort_sever_device);
        dest.writeString(mDTOUrl_apn_device);
        dest.writeString(mDTOLogin_apn_device);
        dest.writeString(mDTOPassword_apn_device);
        dest.writeString(mDTODate_device_data);
        dest.writeString(mDTOBattery_device);
/*        dest.writeInt(mDTOLongitube_device_gps);
        dest.writeInt(mDTOLatitube_device_gps);
        dest.writeString(mDTODate_device_gps);
        dest.writeString(mDTOCount_device_gps);
        dest.writeInt(mDTOLongitube_device_lbs);
        dest.writeInt(mDTOLatitube_device_lbs);
        dest.writeString(mDTODate_device_lbs);
        dest.writeString(mDTOCount_device_lbs);*/
        dest.writeString(mDTOBalance_device);
        dest.writeString(mDTOTemp_device);
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
    public String  getDTOTemp_device_1() { return mDTOTemp_device_1;}
    public String  getDTOTemp_device_2() { return mDTOTemp_device_2;}
    public String  getDTOUrl_server_device() { return mDTOUrl_server_device;}
    public int  getDTOPort_sever_device() { return mDTOPort_sever_device;}
    public String  getDTOUrl_apn_device() { return mDTOUrl_apn_device;}
    public String  getDTOLogin_apn_device() { return mDTOLogin_apn_device;}
    public String  getDTOPassword_apn_device() { return mDTOPassword_apn_device;}
    public String  getDTODate_device_data() { return mDTODate_device_data;}
    public String  getDTOBattery_device() { return mDTOBattery_device;}
/*    public int  getDTOLongitube_device_gps() { return mDTOLongitube_device_gps;}
    public int  getDTOLatitube_device_gps() { return mDTOLatitube_device_gps;}
    public String  getDTODate_device_gps() { return mDTODate_device_gps;}
    public String  getDTOCount_device_gps() { return mDTOCount_device_gps;}
    public int  getDTOLongitube_device_lbs() { return mDTOLongitube_device_lbs;}
    public int  getDTOLatitube_device_lbs() { return mDTOLatitube_device_lbs;}
    public String  getDTODate_device_lbs() { return mDTODate_device_lbs;}
    public String  getDTOCount_device_lbs() { return mDTOCount_device_lbs;}*/
    public String  getDTOBalance_device() { return mDTOBalance_device;}
    public String  getDTOTemp_device() { return mDTOTemp_device;}
    public String  getDTOLongitube_device() { return mDTOLongitube_device;}
    public String  getDTOLatitube_device() { return mDTOLatitube_device;}
    public int  getDTORadius_device() { return mDTORadius_device;}

    public void setDTOName_Device(String DTOName_Device) {
        mDTOName_Device = DTOName_Device;
    }

    public void setDTODisp_name_in_sms(int DTODisp_name_in_sms) {
        mDTODisp_name_in_sms = DTODisp_name_in_sms;
    }

    public void setDTOTemp_device_1(String DTOTemp_device_1) {
        mDTOTemp_device_1 = DTOTemp_device_1;
    }

    public void setDTOTemp_device_2(String DTOTemp_device_2) {
        mDTOTemp_device_2 = DTOTemp_device_2;
    }

    public void setDTOUrl_server_device(String DTOUrl_server_device) {
        mDTOUrl_server_device = DTOUrl_server_device;
    }

    public void setDTOPort_sever_device(int DTOPort_sever_device) {
        mDTOPort_sever_device = DTOPort_sever_device;
    }

    public void setDTOUrl_apn_device(String DTOUrl_apn_device) {
        mDTOUrl_apn_device = DTOUrl_apn_device;
    }

    public void setDTOLogin_apn_device(String DTOLogin_apn_device) {
        mDTOLogin_apn_device = DTOLogin_apn_device;
    }

    public void setDTOPassword_apn_device(String DTOPassword_apn_device) {
        mDTOPassword_apn_device = DTOPassword_apn_device;
    }

    public void setDTODate_device_data(String DTODate_device_data) {
        mDTODate_device_data = DTODate_device_data;
    }

    public void setDTOBattery_device(String DTOBattery_device) {
        mDTOBattery_device = DTOBattery_device;
    }

/*    public void setDTOLongitube_device_gps(int DTOLongitube_device_gps) {
        mDTOLongitube_device_gps = DTOLongitube_device_gps;
    }

    public void setDTOLatitube_device_gps(int DTOLatitube_device_gps) {
        mDTOLatitube_device_gps = DTOLatitube_device_gps;
    }

    public void setDTODate_device_gps(String DTODate_device_gps) {
        mDTODate_device_gps = DTODate_device_gps;
    }

    public void setDTOCount_device_gps(String DTOCount_device_gps) {
        mDTOCount_device_gps = DTOCount_device_gps;
    }

    public void setDTOLongitube_device_lbs(int DTOLongitube_device_lbs) {
        mDTOLongitube_device_lbs = DTOLongitube_device_lbs;
    }

    public void setDTOLatitube_device_lbs(int DTOLatitube_device_lbs) {
        mDTOLatitube_device_lbs = DTOLatitube_device_lbs;
    }

    public void setDTODate_device_lbs(String DTODate_device_lbs) {
        mDTODate_device_lbs = DTODate_device_lbs;
    }

    public void setDTOCount_device_lbs(String DTOCount_device_lbs) {
        mDTOCount_device_lbs = DTOCount_device_lbs;
    }

    public void setDTOBalance_device(String DTOBalance_device) {
        mDTOBalance_device = DTOBalance_device;
    }*/

    public void setDTOTemp_device(String DTOTemp_device) {
        mDTOTemp_device = DTOTemp_device;
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
