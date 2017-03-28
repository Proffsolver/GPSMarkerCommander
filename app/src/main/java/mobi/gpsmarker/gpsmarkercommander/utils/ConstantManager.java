package mobi.gpsmarker.gpsmarkercommander.utils;

public interface ConstantManager {

    String TAG_PREFIX = "DEV ";
    String AUTH_TOKEN_KEY = "AUTH_TOKEN_KEY";
    String USER_ID_KEY = "USER_ID_KEY";
    String USER_ID_PHONE = "USER_ID_PHONE";
    String USER_ID_EMAIL = "USER_ID_EMAIL";
    String DEVICE_CURRENT_ID_TYPE = "DEVICE_CURRENT_ID_TYPE";
    String DEVICE_CURRENT_ID = "DEVICE_CURRENT_ID";
    String[] DEVICE_TYPE_STRINGS = {"m180"};
    String USER_CURRENT_ACTION_W_ACCOUNT = "USER_CURRENT_ACTION_W_ACCOUNT";
    //String LOGIN_METHOD = "LOGIN_METHOD";

    int CHANGE_NAME = 1;
    int CHANGE_PHONES = 2;
    int CHANGE_ALARMS_SMS = 3;
    int CHANGE_TEMPVAL = 4;
    int CHANGE_TEMPSIGNAL = 5;
    int CHANGE_ADD_MON_SERV = 6;
    int CHANGE_INTERNET = 7;
    int CHANGE_POINT = 8;

    //Methods JSON
    int AUTHORIZATION  = 0;
    int GET_DEVICES = 1;
    int GET_DEVICES_DATA = 2;
    int GET_USER_PASSWORD = 3;
    int GET_DEVICE_TYPE = 4;
    int GET_DEVICE_COORDINATE = 5;
    int USER_REGISTRATION = 6;
    int DEVICE_REGISTRATION = 7;
    int DEVICE_DELETE = 8;
    int SET_USER_DATA = 9;
    int SET_DEVICE_DATA = 10;
    int SET_DEVICE_COMMAND = 11;
    int GET_DEVICE_COMMAND = 12;
    int SET_USER_PASSWORD = 13;

    String NO_ERROR = "000000";
    String[] JSON_METHODS = {
            "authorization",            //0
            "get_devices",              //1
            "get_device_data",          //2
            "get_user_password",        //3
            "get_device_type",          //4
            "get_device_coordinate",    //5
            "user_registration",        //6
            "device_registration",      //7
            "device_delete",            //8
            "set_user_data",            //9
            "set_device_data",          //10
            "set_device_command",       //11
            "get_device_command",       //12
            "set_user_password"};       //13


    // Параметры для m180
  //  String M180_ALL_PARAMETERS = "\"mode_device\",\"language_device\",\"name_device\",\"name_device_on\",\"gps_url_device\",\"gps_device_on\",\"unsleep_sms_device\",\"worry_call_device\",\"time_park_device\",\"utc_device\",\"lbs_device_on\",\"phone_1_device\",\t\"phone_1_device_on\",\t\"phone_2_device\",\t\"phone_2_device_on\",\t\"phone_3_device\",\"phone_3_device_on\",\"phone_4_device\",\"phone_4_device_on\",\"phone_5_device\",\"phone_5_device_on\",\"phone_6_device\",\"phone_6_device_on\",\"phone_7_device\",\"phone_7_device_on\",\"phone_8_device\",\"phone_8_device_on\",\"phone_9_device\",\"phone_9_device_on\",\"unsleep_alarm_device\",\"alarm_1_device\",\"alarm_1_device_on\",\"alarm_2_device\",\"alarm_2_device_on\",\"alarm_3_device\",\"alarm_3_device_on\",\"alarm_4_device\",\"alarm_4_device_on\",\"alarm_5_device\",\"alarm_5_device_on\",\"alarm_6_device\",\"alarm_6_device_on\",\"alarm_7_device\",\"alarm_7_device_on\",\"alarm_8_device\",\"alarm_8_device_on\",\"alarm_9_device\",\"alarm_9_device_on\",\"balance_device_on\",\"min_balance_device\",\"ussd_balance_device\",\"button_device_on\",\"move_device\",\"move_device_on\",\"unmove_device\",\"unmove_device_on\",\"speed_device\",\"speed_device_on\",\"jack_device_on\",\"temp_device_on\",\"temp_device_1\",\"temp_device_2\",\"temp_relay_device\",\"temp_relay_sms_device\",\"temp_imp_device\",\"internet_device_on\",\t\"url_server_device\",\t\"port_sever_device\",\t\"url_apn_device\",\t\"login_apn_device\",\"password_apn_device\",\"time_send_message_device\",\"adtrack_device_on\",\"date_device_data\",\"battery_device\",\"longitube_device_gps\",\"latitube_device_gps\",\"date_device_gps\",\"count_device_gps\",\"longitube_device_lbs\",\"latitube_device_lbs\",\"date_device_lbs\",\"count_device_lbs\",\"balance_device\",\"temp_device\"";
    String[] M180_MODE_STRINGS = {"Режим работы: Жду", "Режим работы: Трэкер", "Режим работы: Сон", "Режим работы: Поиск", "Режим работы: Охрана"};
    String[] M180_LANG_STRINGS = {"Язык SMS: Авто", "Язык SMS: RU", "Язык SMS: EN"};
    String[] M180_LINKVIEW_STRINGS = {"Вид ссылки: Геокоординаты", "Вид ссылки: Яндекс ссылка", "Вид ссылки: Гугл ссылка", "Вид ссылки: Ссылка на город"};
    String[] M180_ALARM_SMS_STRINGS = {"SMS: При пробуждение","SMS: При тревоге","SMS: Не отправлять"};
    String[] M180_ALARM_CALL_STRINGS = {"Звонок: При пробуждение","Звонок: При тревоге","Звонок: Не звонить"};



    String M180_MODE_DEVICE = "mode_device";
    String M180_LANGUAGE_DEVICE = "language_device";
    String M180_NAME_DEVICE = "name_device";
    String M180_NAME_DEVICE_ON = "name_device_on";
    String M180_GPS_URL_DEVICE = "gps_url_device";
    String M180_GPS_DEVICE_ON = "gps_device_on";
    String M180_UNSLEEP_SMS_DEVICE = "unsleep_sms_device";
    String M180_WORRY_CALL_DEVICE = "worry_call_device";
    String M180_TIME_PARK_DEVICE = "time_park_device";
    String M180_UTC_DEVICE = "utc_device";
    String M180_LBS_DEVICE_ON = "lbs_device_on";
    String M180_PHONE_1_DEVICE = "phone_1_device";
    String M180_PHONE_1_DEVICE_ON = "phone_1_device_on";
    String M180_PHONE_2_DEVICE = "phone_2_device";
    String M180_PHONE_2_DEVICE_ON = "phone_2_device_on";
    String M180_PHONE_3_DEVICE = "phone_3_device";
    String M180_PHONE_3_DEVICE_ON = "phone_3_device_on";
    String M180_PHONE_4_DEVICE = "phone_4_device";
    String M180_PHONE_4_DEVICE_ON = "phone_4_device_on";
    String M180_PHONE_5_DEVICE = "phone_5_device";
    String M180_PHONE_5_DEVICE_ON = "phone_5_device_on";
    String M180_PHONE_6_DEVICE = "phone_6_device";
    String M180_PHONE_6_DEVICE_ON = "phone_6_device_on";
    String M180_PHONE_7_DEVICE = "phone_7_device";
    String M180_PHONE_7_DEVICE_ON = "phone_7_device_on";
    String M180_PHONE_8_DEVICE = "phone_8_device";
    String M180_PHONE_8_DEVICE_ON = "phone_8_device_on";
    String M180_PHONE_9_DEVICE = "phone_9_device";
    String M180_PHONE_9_DEVICE_ON = "phone_9_device_on";
    String M180_UNSLEEP_ALARM_DEVICE = "unsleep_alarm_device";
    String M180_ALARM_1_DEVICE = "alarm_1_device";
    String M180_ALARM_1_DEVICE_ON = "alarm_1_device_on";
    String M180_ALARM_2_DEVICE = "alarm_2_device";
    String M180_ALARM_2_DEVICE_ON = "alarm_2_device_on";
    String M180_ALARM_3_DEVICE = "alarm_3_device";
    String M180_ALARM_3_DEVICE_ON = "alarm_3_device_on";
    String M180_ALARM_4_DEVICE = "alarm_4_device";
    String M180_ALARM_4_DEVICE_ON = "alarm_4_device_on";
    String M180_ALARM_5_DEVICE = "alarm_5_device";
    String M180_ALARM_5_DEVICE_ON = "alarm_5_device_on";
    String M180_ALARM_6_DEVICE = "alarm_6_device";
    String M180_ALARM_6_DEVICE_ON = "alarm_6_device_on";
    String M180_ALARM_7_DEVICE = "alarm_7_device";
    String M180_ALARM_7_DEVICE_ON = "alarm_7_device_on";
    String M180_ALARM_8_DEVICE = "alarm_8_device";
    String M180_ALARM_8_DEVICE_ON = "alarm_8_device_on";
    String M180_ALARM_9_DEVICE = "alarm_9_device";
    String M180_ALARM_9_DEVICE_ON = "alarm_9_device_on";
    String M180_BALANCE_DEVICE_ON = "balance_device_on";
    String M180_MIN_BALANCE_DEVICE = "min_balance_device";
    String M180_USSD_BALANCE_DEVICE = "ussd_balance_device";
    String M180_BUTTON_DEVICE_ON = "button_device_on";
    String M180_MOVE_DEVICE = "move_device";
    String M180_MOVE_DEVICE_ON = "move_device_on";
    String M180_UNMOVE_DEVICE = "unmove_device";
    String M180_UNMOVE_DEVICE_ON = "unmove_device_on";
    String M180_SPEED_DEVICE = "speed_device";
    String M180_SPEED_DEVICE_ON = "speed_device_on";
    String M180_JACK_DEVICE_ON = "jack_device_on";
    String M180_TEMP_DEVICE_ON = "temp_device_on";
    String M180_TEMP_DEVICE_1 = "temp_device_1";
    String M180_TEMP_DEVICE_2 = "temp_device_2";
    String M180_TEMP_RELAY_DEVICE = "temp_relay_device";
    String M180_TEMP_RELAY_SMS_DEVICE = "temp_relay_sms_device";
    String M180_TEMP_IMP_DEVICE = "temp_imp_device";
    String M180_INTERNET_DEVICE_ON = "internet_device_on";
    String M180_URL_SERVER_DEVICE = "url_server_device";
    String M180_PORT_SEVER_DEVICE = "port_sever_device";
    String M180_URL_APN_DEVICE = "url_apn_device";
    String M180_LOGIN_APN_DEVICE = "login_apn_device";
    String M180_PASSWORD_APN_DEVICE = "password_apn_device";
    String M180_TIME_SEND_MESSAGE_DEVICE = "time_send_message_device";
    String M180_ADTRACK_DEVICE_ON = "adtrack_device_on";
    String M180_DATE_DEVICE_DATA = "date_device_data";
    String M180_BATTERY_DEVICE = "battery_device";
    String M180_LONGITUBE_DEVICE_GPS = "longitube_device_gps";
    String M180_LATITUBE_DEVICE_GPS = "latitube_device_gps";
    String M180_DATE_DEVICE_GPS = "date_device_gps";
    String M180_COUNT_DEVICE_GPS = "count_device_gps";
    String M180_LONGITUBE_DEVICE_LBS = "longitube_device_lbs";
    String M180_LATITUBE_DEVICE_LBS = "latitube_device_lbs";
    String M180_DATE_DEVICE_LBS = "date_device_lbs";
    String M180_COUNT_DEVICE_LBS = "count_device_lbs";
    String M180_BALANCE_DEVICE = "balance_device";
    String M180_TEMP_DEVICE = "temp_device";
    String M180_LONGITUBE_DEVICE = "longitube_device";
    String M180_LATITUBE_DEVICE = "latitube_device";
    String M180_RADUIS_DEVICE = "radius_device";

    String PARCELABLE_KEY = "PARCELABLE_KEY";
    String PARCELABLE_SETTINGS_KEY = "PARCELABLE_SETTINGS_KEY";
}
