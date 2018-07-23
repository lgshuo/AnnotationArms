/**
 * Copyright 2016 JustWayward Team
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lgs.study.view.reader;

import com.lgs.study.cons.Constants;
import com.lgs.study.utils.SPUtils;
import com.lgs.study.utils.ShowUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyh.
 * @date 2016/9/23.
 */
public class SettingManager {

    private volatile static SettingManager manager;

    public static SettingManager getInstance() {
        return manager != null ? manager : (manager = new SettingManager());
    }

    /**
     * 保存书籍阅读字体大小
     *
     * @param bookId     需根据bookId对应，避免由于字体大小引起的分页不准确
     * @param fontSizePx
     * @return
     */
    public void saveFontSize(String bookId, int fontSizePx) {
        // 书籍对应
        SPUtils.put(getFontSizeKey(bookId), fontSizePx);
    }

    /**
     * 保存全局生效的阅读字体大小
     *
     * @param fontSizePx
     */
    public void saveFontSize(int fontSizePx) {
        saveFontSize("", fontSizePx);
    }

    public int getReadFontSize(String bookId) {
        return (int) SPUtils.get(getFontSizeKey(bookId), ScreenUtils.dpToPxInt(16));
    }

    public int getReadFontSize() {
        return getReadFontSize("");
    }

    private String getFontSizeKey(String bookId) {
        return bookId + "-readFontSize";
    }

    public int getReadBrightness() {
        return ScreenUtils.getScreenBrightness();
    }

    /**
     * 保存阅读界面屏幕亮度
     *
     * @param percent 亮度比例 0~100
     */
    public void saveReadBrightness(int percent) {
        if (percent > 100) {
            ShowUtils.showToast("saveReadBrightnessErr CheckRefs");
            percent = 100;
        }
        SPUtils.put(getLightnessKey(), percent);
    }

    private String getLightnessKey() {
        return "readLightness";
    }

    public synchronized void saveReadProgress(String bookId, int currentChapter, int m_mbBufBeginPos, int m_mbBufEndPos) {
        SPUtils.put(getChapterKey(bookId), currentChapter);
        SPUtils.put((getStartPosKey(bookId)), m_mbBufBeginPos);
        SPUtils.put((getEndPosKey(bookId)), m_mbBufEndPos);
    }

    /**
     * 获取上次阅读章节及位置
     *
     * @param bookId
     * @return
     */
    public int[] getReadProgress(String bookId) {
        int lastChapter = (int) SPUtils.get(getChapterKey(bookId), 1);
        int startPos = (int) SPUtils.get(getStartPosKey(bookId), 0);
        int endPos = (int) SPUtils.get(getEndPosKey(bookId), 0);

        return new int[]{lastChapter, startPos, endPos};
    }

    public void removeReadProgress(String bookId) {
        SPUtils.remove(getChapterKey(bookId));
        SPUtils.remove(getStartPosKey(bookId));
        SPUtils.remove(getEndPosKey(bookId));

    }

    private String getChapterKey(String bookId) {
        return bookId + "-chapter";
    }

    private String getStartPosKey(String bookId) {
        return bookId + "-startPos";
    }

    private String getEndPosKey(String bookId) {
        return bookId + "-endPos";
    }


    public boolean addBookMark(String bookId, BookMark mark) {
        List<BookMark> marks = (List<BookMark>) SPUtils.get(getBookMarksKey(bookId), ArrayList.class);
        if (marks != null && marks.size() > 0) {
            for (BookMark item : marks) {
                if (item.chapter == mark.chapter && item.startPos == mark.startPos) {
                    return false;
                }
            }
        } else {
            marks = new ArrayList<>();
        }
        marks.add(mark);
        SPUtils.put(getBookMarksKey(bookId), marks);
        return true;
    }

    public List<BookMark> getBookMarks(String bookId) {
        return (List<BookMark>) SPUtils.get(getBookMarksKey(bookId), ArrayList.class);
    }

    public void clearBookMarks(String bookId) {
        SPUtils.remove(getBookMarksKey(bookId));
    }

    private String getBookMarksKey(String bookId) {
        return bookId + "-marks";
    }

    public void saveReadTheme(int theme) {
        SPUtils.put("readTheme", theme);
    }

    public int getReadTheme() {
        if ((Boolean) SPUtils.get(Constants.ISNIGHT, false)) {
            return ThemeManager.NIGHT;
        }
        return (int) SPUtils.get("readTheme", 3);
    }

    /**
     * 是否可以使用音量键翻页
     *
     * @param enable
     */
    public void saveVolumeFlipEnable(boolean enable) {
        SPUtils.put("volumeFlip", enable);
    }

    public boolean isVolumeFlipEnable() {
        return (Boolean) SPUtils.get("volumeFlip", true);
    }

    public void saveAutoBrightness(boolean enable) {
        SPUtils.put("autoBrightness", enable);
    }

    public boolean isAutoBrightness() {
        return (Boolean) SPUtils.get("autoBrightness", false);
    }


    /**
     * 保存用户选择的性别
     *
     * @param sex male female
     */
    public void saveUserChooseSex(String sex) {
        SPUtils.put("userChooseSex", sex);
    }
}
