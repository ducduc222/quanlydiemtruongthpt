package com.mycompany.quanlydiemtruongthpt.Model;

import java.lang.reflect.Method;

public class Model extends BaseModel{
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public Object getProperty(String propertyName) {
        try {
            Method method = getClass().getMethod("get" + propertyName);
            return method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setProperty(String propertyName, Object value) {
        try {
            Method method = getClass().getMethod("set" + propertyName, value.getClass());
            method.invoke(this, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTenDanToc(String str) {
        System.out.println(1+str);
    }
}
