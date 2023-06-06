package com.mycompany.quanlydiemtruongthpt.Model;

import java.lang.reflect.Method;

public abstract class BaseModel {
    public abstract Object getProperty (String propertyName);
    public abstract void setProperty (String propertyName, Object value);
    public Object invokeMethod(String methodName) throws Exception {
        String property = methodName.substring(3); // Bỏ qua "get" hoặc "set"
        Method method = getClass().getMethod(methodName);

        return method.invoke(this);
    }
}
