package com.ahmadtakkoush.source;

public class SettingsItem {

    //for settings page
    private int mImageResource;
    private String mText1;
    private String mText2;

    public SettingsItem(int imageResource,String text1,String text2){

        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;

    }

    //get our image back (settings)
    public int getmImageResource(){
        return mImageResource;
    }

    public String getText1(){
        return mText1;
    }

    public String getText2(){
        return mText2;
    }
}
