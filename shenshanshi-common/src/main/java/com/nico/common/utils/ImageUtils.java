package com.nico.common.utils;

public class ImageUtils {

    private static String AVATAR_PRFIX = "http://121.36.210.108/static/shenshanshi/image/avatar/";

    public static String getAvatarURL(String avatar){
        return getImageURL(AVATAR_PRFIX, avatar);
    }


    public static String getImageURL(String perfix,String imageName){
        if (StringUtils.isNull(imageName)){
            return null;
        }
        return perfix + imageName;
    }





}
