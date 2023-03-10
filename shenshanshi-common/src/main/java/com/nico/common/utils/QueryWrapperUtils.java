package com.nico.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;

public class QueryWrapperUtils<T> {
    public QueryWrapper<T> getByNotNullField(T t, Class<?> clazz)  {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            if("serialVersionUID".equals(field.getName())){
                continue;
            }

            field.setAccessible(true);
            try {
                if(field.get(t)!=null){
                    queryWrapper.eq(field.getName(),field.get(t));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return queryWrapper;
    }

}
