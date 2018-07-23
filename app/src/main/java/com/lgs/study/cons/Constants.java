package com.lgs.study.cons;

import android.os.Environment;

import com.lgs.study.globe.App;
import com.lgs.study.view.reader.AppUtils;
import com.lgs.study.view.reader.FileUtils;

import java.io.File;

/**
 * Created by admin on 2018/4/19.
 */

public interface Constants {
    String SAVE_PATH = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data" + "/NetCache";
    String name = "name";
    String number = "userNumber";
    String logo = "logo";
    String phone = "phone";
    String pwd = "pwd";
    String ISNIGHT = "isNight";
    String SUFFIX_TXT = ".txt";
    String SUFFIX_PDF = ".pdf";
    String SUFFIX_EPUB = ".epub";
    String SUFFIX_ZIP = ".zip";
    String SUFFIX_CHM = ".chm";
}
