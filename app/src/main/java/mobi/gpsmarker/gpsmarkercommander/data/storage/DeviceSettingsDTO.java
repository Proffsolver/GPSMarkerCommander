package mobi.gpsmarker.gpsmarkercommander.data.storage;

import android.os.Parcel;
import android.os.Parcelable;

import mobi.gpsmarker.gpsmarkercommander.data.network.res.SettingsDeviceResM180;

public class DeviceSettingsDTO implements Parcelable {
    private String mDTOName_Device;
    private int mDTODisp_name_in_sms;
    private String mDTOPhone_1_device;
    private int mDTOPhone_1_device_on;
    private String mDTOPhone_2_device;
    private int mDTOPhone_2_device_on;
    private String mDTOPhone_3_device;
    private int mDTOPhone_3_device_on;
    private String mDTOPhone_4_device;
    private int mDTOPhone_4_device_on;
    private String mDTOPhone_5_device;
    private int mDTOPhone_5_device_on;
    private String mDTOPhone_6_device;
    private int mDTOPhone_6_device_on;
    private String mDTOPhone_7_device;
    private int mDTOPhone_7_device_on;
    private String mDTOPhone_8_device;
    private int mDTOPhone_8_device_on;
    private String mDTOPhone_9_device;
    private int mDTOPhone_9_device_on;
    private String mDTOUnsleep_Alarm_sms_device;
    private String mDTOAlarm_sms_1_device;
    private int mDTOAlarm_sms_1_device_on;
    private String mDTOAlarm_sms_2_device;
    private int mDTOAlarm_sms_2_device_on;
    private String mDTOAlarm_sms_3_device;
    private int mDTOAlarm_sms_3_device_on;
    private String mDTOAlarm_sms_4_device;
    private int mDTOAlarm_sms_4_device_on;
    private String mDTOAlarm_sms_5_device;
    private int mDTOAlarm_sms_5_device_on;
    private String mDTOAlarm_sms_6_device;
    private int mDTOAlarm_sms_6_device_on;
    private String mDTOAlarm_sms_7_device;
    private int mDTOAlarm_sms_7_device_on;
    private String mDTOAlarm_sms_8_device;
    private int mDTOAlarm_sms_8_device_on;
    private String mDTOAlarm_sms_9_device;
    private int mDTOAlarm_sms_9_device_on;
    private String mDTOTemp_device_1;
    private String mDTOTemp_device_2;
    private int mDTOTemp_relay_device;
    private String mDTOUrl_server_device;
    private int mDTOPort_sever_device;
    private String mDTOUrl_apn_device;
    private String mDTOLogin_apn_device;
    private String mDTOPassword_apn_device;
    private String mDTODate_device_data;
    private String mDTOBattery_device;
    private int mDTOLongitube_device_gps;
    private int mDTOLatitube_device_gps;
    private String mDTODate_device_gps;
    private String mDTOCount_device_gps;
    private int mDTOLongitube_device_lbs;
    private int mDTOLatitube_device_lbs;
    private String mDTODate_device_lbs;
    private String mDTOCount_device_lbs;
    private String mDTOBalance_device;
    private String mDTOTemp_device;
    private int mDTOLongitube_device;
    private int mDTOLatitube_device;
    private int mDTORadius_device;

    public DeviceSettingsDTO(
            String mName_Device, int mDisp_name_in_sms,
            String mPhone_1_device,
            int mPhone_1_device_on, String mPhone_2_device,
            int mPhone_2_device_on, String mPhone_3_device,
            int mPhone_3_device_on, String mPhone_4_device,
            int mPhone_4_device_on, String mPhone_5_device,
            int mPhone_5_device_on, String mPhone_6_device,
            int mPhone_6_device_on, String mPhone_7_device,
            int mPhone_7_device_on, String mPhone_8_device,
            int mPhone_8_device_on, String mPhone_9_device,
            int mPhone_9_device_on, String mUnsleep_Alarm_sms_device,
            String mAlarm_sms_1_device, int mAlarm_sms_1_device_on,
            String mAlarm_sms_2_device, int mAlarm_sms_2_device_on,
            String mAlarm_sms_3_device, int mAlarm_sms_3_device_on,
            String mAlarm_sms_4_device, int mAlarm_sms_4_device_on,
            String mAlarm_sms_5_device, int mAlarm_sms_5_device_on,
            String mAlarm_sms_6_device, int mAlarm_sms_6_device_on,
            String mAlarm_sms_7_device, int mAlarm_sms_7_device_on,
            String mAlarm_sms_8_device, int mAlarm_sms_8_device_on,
            String mAlarm_sms_9_device, int mAlarm_sms_9_device_on,
            String mTemp_device_1,
            String mTemp_device_2, int mTemp_relay_device,
            String mUrl_server_device, int mPort_sever_device,
            String mUrl_apn_device, String mLogin_apn_device,
            String mPassword_apn_device, String mDate_device_data,
            String mBattery_device, int mLongitube_device_gps,
            int mLatitube_device_gps, String mDate_device_gps,
            String mCount_device_gps, int mLongitube_device_lbs,
            int mLatitube_device_lbs, String mDate_device_lbs,
            String mCount_device_lbs, String mBalance_device,
            String mTemp_device, int mLongitube_device,
            int mLatitube_device, int mRadius_device) {
        mDTOName_Device = mName_Device;
        mDTODisp_name_in_sms = mDisp_name_in_sms;
        mDTOPhone_1_device = mPhone_1_device;
        mDTOPhone_1_device_on = mPhone_1_device_on;
        mDTOPhone_2_device = mPhone_2_device;
        mDTOPhone_2_device_on = mPhone_2_device_on;
        mDTOPhone_3_device = mPhone_3_device;
        mDTOPhone_3_device_on = mPhone_3_device_on;
        mDTOPhone_4_device = mPhone_4_device;
        mDTOPhone_4_device_on = mPhone_4_device_on;
        mDTOPhone_5_device = mPhone_5_device;
        mDTOPhone_5_device_on = mPhone_5_device_on;
        mDTOPhone_6_device = mPhone_6_device;
        mDTOPhone_6_device_on = mPhone_6_device_on;
        mDTOPhone_7_device = mPhone_7_device;
        mDTOPhone_7_device_on = mPhone_7_device_on;
        mDTOPhone_8_device = mPhone_8_device;
        mDTOPhone_8_device_on = mPhone_8_device_on;
        mDTOPhone_9_device = mPhone_9_device;
        mDTOPhone_9_device_on = mPhone_9_device_on;
        mDTOUnsleep_Alarm_sms_device = mUnsleep_Alarm_sms_device;
        mDTOAlarm_sms_1_device = mAlarm_sms_1_device;
        mDTOAlarm_sms_1_device_on = mAlarm_sms_1_device_on;
        mDTOAlarm_sms_2_device = mAlarm_sms_2_device;
        mDTOAlarm_sms_2_device_on = mAlarm_sms_2_device_on;
        mDTOAlarm_sms_3_device = mAlarm_sms_3_device;
        mDTOAlarm_sms_3_device_on = mAlarm_sms_3_device_on;
        mDTOAlarm_sms_4_device = mAlarm_sms_4_device;
        mDTOAlarm_sms_4_device_on = mAlarm_sms_4_device_on;
        mDTOAlarm_sms_5_device = mAlarm_sms_5_device;
        mDTOAlarm_sms_5_device_on = mAlarm_sms_5_device_on;
        mDTOAlarm_sms_6_device = mAlarm_sms_6_device ;
        mDTOAlarm_sms_6_device_on = mAlarm_sms_6_device_on;
        mDTOAlarm_sms_7_device = mAlarm_sms_7_device;
        mDTOAlarm_sms_7_device_on = mAlarm_sms_7_device_on;
        mDTOAlarm_sms_8_device = mAlarm_sms_8_device;
        mDTOAlarm_sms_8_device_on = mAlarm_sms_8_device_on;
        mDTOAlarm_sms_9_device = mAlarm_sms_9_device;
        mDTOAlarm_sms_9_device_on = mAlarm_sms_9_device_on;
        mDTOTemp_device_1 = mTemp_device_1;
        mDTOTemp_device_2 = mTemp_device_2;
        mDTOTemp_relay_device = mTemp_relay_device;
        mDTOUrl_server_device = mUrl_server_device;
        mDTOPort_sever_device = mPort_sever_device;
        mDTOUrl_apn_device = mUrl_apn_device;
        mDTOLogin_apn_device = mLogin_apn_device;
        mDTOPassword_apn_device = mPassword_apn_device;
        mDTODate_device_data = mDate_device_data;
        mDTOBattery_device = mBattery_device;
        mDTOLongitube_device_gps = mLongitube_device_gps;
        mDTOLatitube_device_gps = mLatitube_device_gps;
        mDTODate_device_gps = mDate_device_gps;
        mDTOCount_device_gps = mCount_device_gps;
        mDTOLongitube_device_lbs = mLongitube_device_lbs;
        mDTOLatitube_device_lbs = mLatitube_device_lbs;
        mDTODate_device_lbs = mDate_device_lbs;
        mDTOCount_device_lbs = mCount_device_lbs;
        mDTOBalance_device = mBalance_device;
        mDTOTemp_device = mTemp_device;
        mDTOLongitube_device = mLongitube_device;
        mDTOLatitube_device = mLatitube_device;
        mDTORadius_device = mRadius_device;

    }

    protected DeviceSettingsDTO(Parcel in) {
        mDTOName_Device = in.readString();
        mDTODisp_name_in_sms = in.readInt();
        mDTOPhone_1_device = in.readString();
        mDTOPhone_1_device_on = in.readInt();
        mDTOPhone_2_device = in.readString();
        mDTOPhone_2_device_on = in.readInt();
        mDTOPhone_3_device = in.readString();
        mDTOPhone_3_device_on = in.readInt();
        mDTOPhone_4_device = in.readString();
        mDTOPhone_4_device_on = in.readInt();
        mDTOPhone_5_device = in.readString();
        mDTOPhone_5_device_on = in.readInt();
        mDTOPhone_6_device = in.readString();
        mDTOPhone_6_device_on = in.readInt();
        mDTOPhone_7_device = in.readString();
        mDTOPhone_7_device_on = in.readInt();
        mDTOPhone_8_device = in.readString();
        mDTOPhone_8_device_on = in.readInt();
        mDTOPhone_9_device = in.readString();
        mDTOPhone_9_device_on = in.readInt();
        mDTOUnsleep_Alarm_sms_device = in.readString();
        mDTOAlarm_sms_1_device = in.readString();
        mDTOAlarm_sms_1_device_on = in.readInt();
        mDTOAlarm_sms_2_device = in.readString();
        mDTOAlarm_sms_2_device_on = in.readInt();
        mDTOAlarm_sms_3_device = in.readString();
        mDTOAlarm_sms_3_device_on = in.readInt();
        mDTOAlarm_sms_4_device = in.readString();
        mDTOAlarm_sms_4_device_on = in.readInt();
        mDTOAlarm_sms_5_device = in.readString();
        mDTOAlarm_sms_5_device_on = in.readInt();
        mDTOAlarm_sms_6_device = in.readString();
        mDTOAlarm_sms_6_device_on = in.readInt();
        mDTOAlarm_sms_7_device = in.readString();
        mDTOAlarm_sms_7_device_on = in.readInt();
        mDTOAlarm_sms_8_device = in.readString();
        mDTOAlarm_sms_8_device_on = in.readInt();
        mDTOAlarm_sms_9_device = in.readString();
        mDTOAlarm_sms_9_device_on = in.readInt();
        mDTOTemp_device_1 = in.readString();
        mDTOTemp_device_2 = in.readString();
        mDTOTemp_relay_device = in.readInt();
        mDTOUrl_server_device = in.readString();
        mDTOPort_sever_device = in.readInt();
        mDTOUrl_apn_device = in.readString();
        mDTOLogin_apn_device = in.readString();
        mDTOPassword_apn_device = in.readString();
        mDTODate_device_data = in.readString();
        mDTOBattery_device = in.readString();
        mDTOLongitube_device_gps = in.readInt();
        mDTOLatitube_device_gps = in.readInt();
        mDTODate_device_gps = in.readString();
        mDTOCount_device_gps = in.readString();
        mDTOLongitube_device_lbs = in.readInt();
        mDTOLatitube_device_lbs = in.readInt();
        mDTODate_device_lbs = in.readString();
        mDTOCount_device_lbs = in.readString();
        mDTOBalance_device = in.readString();
        mDTOTemp_device = in.readString();
        mDTOLongitube_device = in.readInt();
        mDTOLatitube_device = in.readInt();
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
        dest.writeString(mDTOPhone_1_device);
        dest.writeInt(mDTOPhone_1_device_on);
        dest.writeString(mDTOPhone_2_device);
        dest.writeInt(mDTOPhone_2_device_on);
        dest.writeString(mDTOPhone_3_device);
        dest.writeInt(mDTOPhone_3_device_on);
        dest.writeString(mDTOPhone_4_device);
        dest.writeInt(mDTOPhone_4_device_on);
        dest.writeString(mDTOPhone_5_device);
        dest.writeInt(mDTOPhone_5_device_on);
        dest.writeString(mDTOPhone_6_device);
        dest.writeInt(mDTOPhone_6_device_on);
        dest.writeString(mDTOPhone_7_device);
        dest.writeInt(mDTOPhone_7_device_on);
        dest.writeString(mDTOPhone_8_device);
        dest.writeInt(mDTOPhone_8_device_on);
        dest.writeString(mDTOPhone_9_device);
        dest.writeInt(mDTOPhone_9_device_on);
        dest.writeString(mDTOUnsleep_Alarm_sms_device);
        dest.writeString(mDTOAlarm_sms_1_device);
        dest.writeInt(mDTOAlarm_sms_1_device_on);
        dest.writeString(mDTOAlarm_sms_2_device);
        dest.writeInt(mDTOAlarm_sms_2_device_on);
        dest.writeString(mDTOAlarm_sms_3_device);
        dest.writeInt(mDTOAlarm_sms_3_device_on);
        dest.writeString(mDTOAlarm_sms_4_device);
        dest.writeInt(mDTOAlarm_sms_4_device_on);
        dest.writeString(mDTOAlarm_sms_5_device);
        dest.writeInt(mDTOAlarm_sms_5_device_on);
        dest.writeString(mDTOAlarm_sms_6_device);
        dest.writeInt(mDTOAlarm_sms_6_device_on);
        dest.writeString(mDTOAlarm_sms_7_device);
        dest.writeInt(mDTOAlarm_sms_7_device_on);
        dest.writeString(mDTOAlarm_sms_8_device);
        dest.writeInt(mDTOAlarm_sms_8_device_on);
        dest.writeString(mDTOAlarm_sms_9_device);
        dest.writeInt(mDTOAlarm_sms_9_device_on);
        dest.writeString(mDTOTemp_device_1);
        dest.writeString(mDTOTemp_device_2);
        dest.writeInt(mDTOTemp_relay_device);
        dest.writeString(mDTOUrl_server_device);
        dest.writeInt(mDTOPort_sever_device);
        dest.writeString(mDTOUrl_apn_device);
        dest.writeString(mDTOLogin_apn_device);
        dest.writeString(mDTOPassword_apn_device);
        dest.writeString(mDTODate_device_data);
        dest.writeString(mDTOBattery_device);
        dest.writeInt(mDTOLongitube_device_gps);
        dest.writeInt(mDTOLatitube_device_gps);
        dest.writeString(mDTODate_device_gps);
        dest.writeString(mDTOCount_device_gps);
        dest.writeInt(mDTOLongitube_device_lbs);
        dest.writeInt(mDTOLatitube_device_lbs);
        dest.writeString(mDTODate_device_lbs);
        dest.writeString(mDTOCount_device_lbs);
        dest.writeString(mDTOBalance_device);
        dest.writeString(mDTOTemp_device);
        dest.writeInt(mDTOLongitube_device);
        dest.writeInt(mDTOLatitube_device);
        dest.writeInt(mDTORadius_device);

    }

    @SuppressWarnings("unused")
    public static final Creator<DeviceSettingsDTO> CREATOR = new Creator<DeviceSettingsDTO>() {
        @Override
        public DeviceSettingsDTO createFromParcel(Parcel in) {
            return new DeviceSettingsDTO(in);
        }

        @Override
        public DeviceSettingsDTO[] newArray(int size) {
            return new DeviceSettingsDTO[size];
        }
    };


    public String getDTOName_Device() { return mDTOName_Device;}
    public int getDTODisp_name_in_sms() { return mDTODisp_name_in_sms;}
    public String getDTOPhone_1_device() { return mDTOPhone_1_device;}
    public int getDTOPhone_1_device_on() { return mDTOPhone_1_device_on;}
    public String  getDTOPhone_2_device() { return mDTOPhone_2_device;}
    public int  getDTOPhone_2_device_on() { return mDTOPhone_2_device_on;}
    public String  getDTOPhone_3_device() { return mDTOPhone_3_device;}
    public int  getDTOPhone_3_device_on() { return mDTOPhone_3_device_on;}
    public String  getDTOPhone_4_device() { return mDTOPhone_4_device;}
    public int  getDTOPhone_4_device_on() { return mDTOPhone_4_device_on;}
    public String  getDTOPhone_5_device() { return mDTOPhone_5_device;}
    public int  getDTOPhone_5_device_on() { return mDTOPhone_5_device_on;}
    public String  getDTOPhone_6_device() { return mDTOPhone_6_device;}
    public int  getDTOPhone_6_device_on() { return mDTOPhone_6_device_on;}
    public String  getDTOPhone_7_device() { return mDTOPhone_7_device;}
    public int  getDTOPhone_7_device_on() { return mDTOPhone_7_device_on;}
    public String  getDTOPhone_8_device() { return mDTOPhone_8_device;}
    public int  getDTOPhone_8_device_on() { return mDTOPhone_8_device_on;}
    public String  getDTOPhone_9_device() { return mDTOPhone_9_device;}
    public int  getDTOPhone_9_device_on() { return mDTOPhone_9_device_on;}
    public String  getDTOUnsleep_Alarm_sms_device() { return mDTOUnsleep_Alarm_sms_device;}
    public String  getDTOAlarm_sms_1_device() { return mDTOAlarm_sms_1_device;}
    public int  getDTOAlarm_sms_1_device_on() { return mDTOAlarm_sms_1_device_on;}
    public String  getDTOAlarm_sms_2_device() { return mDTOAlarm_sms_2_device;}
    public int  getDTOAlarm_sms_2_device_on() { return mDTOAlarm_sms_2_device_on;}
    public String  getDTOAlarm_sms_3_device() { return mDTOAlarm_sms_3_device;}
    public int  getDTOAlarm_sms_3_device_on() { return mDTOAlarm_sms_3_device_on;}
    public String  getDTOAlarm_sms_4_device() { return mDTOAlarm_sms_4_device;}
    public int  getDTOAlarm_sms_4_device_on() { return mDTOAlarm_sms_4_device_on;}
    public String  getDTOAlarm_sms_5_device() { return mDTOAlarm_sms_5_device;}
    public int  getDTOAlarm_sms_5_device_on() { return mDTOAlarm_sms_5_device_on;}
    public String  getDTOAlarm_sms_6_device() { return mDTOAlarm_sms_6_device;}
    public int  getDTOAlarm_sms_6_device_on() { return mDTOAlarm_sms_6_device_on;}
    public String  getDTOAlarm_sms_7_device() { return mDTOAlarm_sms_7_device;}
    public int  getDTOAlarm_sms_7_device_on() { return mDTOAlarm_sms_7_device_on;}
    public String  getDTOAlarm_sms_8_device() { return mDTOAlarm_sms_8_device;}
    public int  getDTOAlarm_sms_8_device_on() { return mDTOAlarm_sms_8_device_on;}
    public String  getDTOAlarm_sms_9_device() { return mDTOAlarm_sms_9_device;}
    public int  getDTOAlarm_sms_9_device_on() { return mDTOAlarm_sms_9_device_on;}
    public String  getDTOTemp_device_1() { return mDTOTemp_device_1;}
    public String  getDTOTemp_device_2() { return mDTOTemp_device_2;}
    public int  getDTOTemp_relay_device() { return mDTOTemp_relay_device;}
    public String  getDTOUrl_server_device() { return mDTOUrl_server_device;}
    public int  getDTOPort_sever_device() { return mDTOPort_sever_device;}
    public String  getDTOUrl_apn_device() { return mDTOUrl_apn_device;}
    public String  getDTOLogin_apn_device() { return mDTOLogin_apn_device;}
    public String  getDTOPassword_apn_device() { return mDTOPassword_apn_device;}
    public String  getDTODate_device_data() { return mDTODate_device_data;}
    public String  getDTOBattery_device() { return mDTOBattery_device;}
    public int  getDTOLongitube_device_gps() { return mDTOLongitube_device_gps;}
    public int  getDTOLatitube_device_gps() { return mDTOLatitube_device_gps;}
    public String  getDTODate_device_gps() { return mDTODate_device_gps;}
    public String  getDTOCount_device_gps() { return mDTOCount_device_gps;}
    public int  getDTOLongitube_device_lbs() { return mDTOLongitube_device_lbs;}
    public int  getDTOLatitube_device_lbs() { return mDTOLatitube_device_lbs;}
    public String  getDTODate_device_lbs() { return mDTODate_device_lbs;}
    public String  getDTOCount_device_lbs() { return mDTOCount_device_lbs;}
    public String  getDTOBalance_device() { return mDTOBalance_device;}
    public String  getDTOTemp_device() { return mDTOTemp_device;}
    public int  getDTOLongitube_device() { return mDTOLongitube_device;}
    public int  getDTOLatitube_device() { return mDTOLatitube_device;}
    public int  getDTORadius_device() { return mDTORadius_device;}
}
