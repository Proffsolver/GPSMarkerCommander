package mobi.gpsmarker.gpsmarkercommander.utils;


import android.content.Context;

import mobi.gpsmarker.gpsmarkercommander.R;
import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import mobi.gpsmarker.gpsmarkercommander.ui.activities.BaseActivity;
import okhttp3.internal.http2.ErrorCode;

public class ErrorHandler extends BaseActivity {

    public static String getErrorHandler(String ErrorCode, int method) {
        String answerErrorHandler = " ";
        if (ErrorCode.equals("000000")){
            switch (method){
                case 0:
                    answerErrorHandler = "Авторизация прошла успешно...";
                    break;
                case 1:
                    answerErrorHandler = "Загрузка устройств";
                    break;
                case 2:
                    answerErrorHandler = "Настройки устройства загружены";
                    break;
                case 3:
                    answerErrorHandler = "Пароль выслан на Ваш email";
                    break;
                case 4:
                    answerErrorHandler = "Типы устройств выгружены";
                    break;
                case 5:
                    answerErrorHandler = "Координаты получены";
                    break;
                case 6:
                    answerErrorHandler = "Регистрация прошла успешн, пароль выслан на email";
                    break;
                case 7:
                    answerErrorHandler = "Устройство зарегистрировано";
                    break;
                case 8:
                    answerErrorHandler = "Устройство удалено";
                    break;
                case 9:
                    answerErrorHandler = "Ваши изменения сохранены";
                    break;
                case 10:
                    answerErrorHandler = "Ваши изменения сохранены";
                    break;
                case 11:
                    answerErrorHandler = "Команда отправлена";
                    break;
                case 12:
                    answerErrorHandler = "Команда получена";
                    break;
                case 13:
                    answerErrorHandler = "Пароль изменен";
                    break;
            }
        }else if (ErrorCode.equals("000001")){
            answerErrorHandler = "Ошибка выполнения запроса к БД";
        }else if (ErrorCode.equals("000002")){
            answerErrorHandler = "Неверно введен логин или пароль";
        }else if (ErrorCode.equals("000003")){
            answerErrorHandler = "Устройства не обнаружены";
        }else if (ErrorCode.equals("000004")){
            answerErrorHandler = "Параметр не найден или не применяется в данном методе";
        }else if (ErrorCode.equals("000005")){
            answerErrorHandler = "Токен введен не верно";
        }else if (ErrorCode.equals("000006")){
            answerErrorHandler = "Значение задано некорректно";
        }else if (ErrorCode.equals("000007")){
            answerErrorHandler = "Указанное устройство не найдено";
        }else if (ErrorCode.equals("000008")){
            answerErrorHandler = "Метод не обнаружен";
        }else if (ErrorCode.equals("000009")){
            answerErrorHandler = "Старый пароль введен некорректно";
        }else if (ErrorCode.equals("000010")){
            answerErrorHandler = "Новый пароль введен некорректно";
        }else if (ErrorCode.equals("000011")){
            answerErrorHandler = "Введенные пароли совпадают";
        }else if (ErrorCode.equals("000012")){
            answerErrorHandler = "Старый пароль пароль введен неверно";
        }else if (ErrorCode.equals("000013")){
            answerErrorHandler = "Запрашиваемое устройство не принадлежит данному пользователю";
        }else if (ErrorCode.equals("000014")){
            answerErrorHandler = "Недопустимое значение параметра";
        }else if (ErrorCode.equals("000015")){
            answerErrorHandler = "Не задан параметр идентификатора устройства";
        }else if (ErrorCode.equals("000016")){
            answerErrorHandler = "Не задан параметр логина пользователя";
        }else if (ErrorCode.equals("000017")){
            answerErrorHandler = "Не задан параметр пароля пользователя";
        }else if (ErrorCode.equals("000018")){
            answerErrorHandler = "Не задан параметр email пользователя";
        }else if (ErrorCode.equals("000019")){
            answerErrorHandler = "Не задан параметр идентификатора пользователя";
        }else if (ErrorCode.equals("000020")){
            answerErrorHandler = "Не задан параметр токена";
        }else if (ErrorCode.equals("000021")){
            answerErrorHandler = "Не задан параметр типа устройства";
        }else if (ErrorCode.equals("000022")){
            answerErrorHandler = "Не задан параметр imei устройства";
        }else if (ErrorCode.equals("000023")){
            answerErrorHandler = "Устройство уже зарегистрировано";
        }else if (ErrorCode.equals("000024")){
            answerErrorHandler = "Пользователь с такой почтой уже зарегистрирован";
        }else if (ErrorCode.equals("000025")){
            answerErrorHandler = "Пользователь с таким телефоном уже зарегистрирован";
        }else {
            answerErrorHandler = "Неопознанная ошибка";
        }
        return answerErrorHandler;
    }

}
