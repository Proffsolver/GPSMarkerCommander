package mobi.gpsmarker.gpsmarkercommander.data.storage.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CoordinateDTO implements Parcelable {
        private String mDTOLongitube_device_gps;
        private String mDTOLatitube_device_gps;
        private String mDTODate_device_gps;
        private String mDTOLongitube_device_lbs;
        private String mDTOLatitube_device_lbs;
        private String mDTODate_device_lbs;
        private int mDTOgps_device_on;
        private int mDTOlbs_device_on;

        public CoordinateDTO(
                                    String mLongitube_device_gps,
                                    String mLatitube_device_gps,
                                    String mDate_device_gps,
                                    String mLongitube_device_lbs,
                                    String mLatitube_device_lbs,
                                    String mDate_device_lbs,
                                    int mGps_device_on,
                                    int mLbs_device_on) {
            mDTOLongitube_device_gps = mLongitube_device_gps;
            mDTOLatitube_device_gps = mLatitube_device_gps;
            mDTODate_device_gps = mDate_device_gps;
            mDTOLongitube_device_lbs = mLongitube_device_lbs;
            mDTOLatitube_device_lbs = mLatitube_device_lbs;
            mDTODate_device_lbs = mDate_device_lbs;
            mDTOgps_device_on = mGps_device_on;
            mDTOlbs_device_on = mLbs_device_on;

        }

        protected CoordinateDTO(Parcel in) {
            mDTOLongitube_device_gps = in.readString();
            mDTOLatitube_device_gps = in.readString();
            mDTODate_device_gps = in.readString();
            mDTOLongitube_device_lbs = in.readString();
            mDTOLatitube_device_lbs = in.readString();
            mDTODate_device_lbs = in.readString();
            mDTOgps_device_on = in.readInt();
            mDTOlbs_device_on = in.readInt();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mDTOLongitube_device_gps);
            dest.writeString(mDTOLatitube_device_gps);
            dest.writeString(mDTODate_device_gps);
            dest.writeString(mDTOLongitube_device_lbs);
            dest.writeString(mDTOLatitube_device_lbs);
            dest.writeString(mDTODate_device_lbs);
            dest.writeInt(mDTOgps_device_on);
            dest.writeInt(mDTOlbs_device_on);

        }

        @SuppressWarnings("unused")
        public static final Creator<CoordinateDTO> CREATOR = new Creator<CoordinateDTO>() {
            @Override
            public CoordinateDTO createFromParcel(Parcel in) {
                return new CoordinateDTO(in);
            }

            @Override
            public CoordinateDTO[] newArray(int size) {
                return new CoordinateDTO[size];
            }
        };

        public String  getDTOLongitube_device_gps() { return mDTOLongitube_device_gps;}
        public String  getDTOLatitube_device_gps() { return mDTOLatitube_device_gps;}
        public String  getDTODate_device_gps() { return mDTODate_device_gps;}
        public String  getDTOLongitube_device_lbs() { return mDTOLongitube_device_lbs;}
        public String  getDTOLatitube_device_lbs() { return mDTOLatitube_device_lbs;}
        public String  getDTODate_device_lbs() { return mDTODate_device_lbs;}
        public int  getDTOgps_device_on() { return mDTOgps_device_on;}
        public int  getDTOlbs_device_on() { return mDTOlbs_device_on;}


        public void setDTOLongitube_device_gps(String DTOLongitube_device_gps) {
            mDTOLongitube_device_gps = DTOLongitube_device_gps;
        }

        public void setDTOLatitube_device_gps(String DTOLatitube_device_gps) {
            mDTOLatitube_device_gps = DTOLatitube_device_gps;
        }

        public void setDTODate_device_gps(String DTODate_device_gps) {
            mDTODate_device_gps = DTODate_device_gps;
        }
        public void setDTOLongitube_device_lbs(String DTOLongitube_device_lbs) {
            mDTOLongitube_device_lbs = DTOLongitube_device_lbs;
        }

        public void setDTOLatitube_device_lbs(String DTOLatitube_device_lbs) {
            mDTOLatitube_device_lbs = DTOLatitube_device_lbs;
        }

        public void setDTODate_device_lbs(String DTODate_device_lbs) {
            mDTODate_device_lbs = DTODate_device_lbs;    }


        public void setDTOlbs_device_on(int DTOlbs_device_on) {
            mDTOlbs_device_on = DTOlbs_device_on;    }
        public void setDTOgps_device_on(int DTOgps_device_on) {
            mDTOgps_device_on = DTOgps_device_on;    }

}
