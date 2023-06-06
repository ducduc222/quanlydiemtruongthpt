package com.mycompany.quanlydiemtruongthpt.DAO;

import com.mycompany.quanlydiemtruongthpt.Connection.MyConnection;
import com.mycompany.quanlydiemtruongthpt.Model.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DAO<T extends Model> {
    private Class<T> typeClass;
    private String tableName;
    private String IdColumeName;
    public DAO() {
        IdColumeName = this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length() - 3) + "_Id";
        tableName = this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length() - 3).toUpperCase();
        this.typeClass = getTypeClass();
    }
    public List<T> getAll() throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        return select(sql);
    }
    public List<T> findId(int id) throws SQLException {
        String sql = "SELECT * FROM " +tableName+ " WHERE " + IdColumeName+ " = " + id;

        return select(sql);
    }

    public void create (ArrayList<String> columeName, Object[] value) throws SQLException {
        String sql = "INSERT INTO "+tableName+" ("+String.join(", ", columeName)+") VALUES (";
        for (int i = 0; i<columeName.size()-1;i++) {
            sql += "?, ";
        }
        sql+="?)";
        MyConnection.executeUpdate(sql, value);

    }

    public void deleteId (int id) throws SQLException {
        String sql = "DELETE FROM "+tableName+" WHERE "+IdColumeName+" = ?";
        MyConnection.executeUpdate(sql,id);
    }

    private List<T> select (String sql, Object ... args) throws SQLException {
        List<T> models = new ArrayList<>();
        try {
            ResultSet resultSet = null;
            try {
                resultSet = MyConnection.executeQuery(sql, args);
                while (resultSet.next()) {
                    T model = readFromResultSet(resultSet);
                    models.add(model);
                }
            } finally {
                resultSet.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return models;
    }

    private T readFromResultSet (ResultSet resultSet) throws SQLException {
        T model = returnModel(typeClass.getSimpleName());

        // setId
        model.setId(resultSet.getInt(typeClass.getSimpleName()+"_Id"));
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 2; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            int columeType = metaData.getColumnType(i);
            Object columnValue;
            switch (columeType) {
                case Types.VARCHAR:
                case Types.CHAR:
                    model.setProperty(columnName, resultSet.getString(columnName));
                    break;
                case Types.INTEGER:
                    model.setProperty(columnName, resultSet.getInt(columnName));
                    break;
                case Types.REAL:
                    model.setProperty(columnName, resultSet.getFloat(columnName));
                    break;
                case Types.DATE:
                    model.setProperty(columnName, resultSet.getDate(columnName));
                    break;
                case Types.BIT:
                    model.setProperty(columnName, resultSet.getBoolean(columnName));
                    break;
                default:
                    columnValue = resultSet.getObject(columnName);
                    break;
            }

        }

        return model;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getTypeClass() {
        // Lấy đối tượng Class của lớp DAO
        Class<?> daoClass = getClass();

        // Lấy thông tin về kiểu tham số T
        Type genericSuperclass = daoClass.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length > 0) {
                Type typeArgument = typeArguments[0];
                if (typeArgument instanceof Class) {
                    return (Class<T>) typeArgument;
                }
            }
        }

        return null;
    }

    private T returnModel(String typeOfClass) {
        T model = null;
        switch (typeOfClass) {
            case "DanToc":
            return (T) new DanToc();
            case "User":
                return (T) new User();
            case "NamHoc":
                return (T) new NamHoc();
            case "HocKy":
                return (T) new HocKy();
            case "KhoiLop":
                return (T) new KhoiLop();
            case "Lop":
                return (T) new Lop();
            case "MonHoc":
                return (T) new MonHoc();
            case "DiemHocKyMonHoc":
                return (T) new DiemHocKyMonHoc();
            case "Diem":
                return (T) new Diem();
            case "LoaiDiem":
                return (T) new LoaiDiem();
            case "KetQuaHocKy":
                return (T) new KetQuaHocKy();
            case "DiemCaNam":
                return (T) new DiemCaNam();
            case "KetQua":
                return (T) new KetQua();
            case "HocLuc":
                return (T) new HocLuc();
            case "HanhKiem":
                return (T) new HanhKiem();
            case "HoSoHocSinh":
                return (T) new HoSoHocSinh();
            case "GiaoVien":
                return (T) new GiaoVien();
            case "TonGiao":
                return (T) new TonGiao();
            case "PhanLop":
                return (T) new PhanLop();
            case "KetQuaHocSinh":
                return (T) new KetQuaHocSinh();

            default:
                return (T) new Model();
        }
    }

    public void ExcuteQuerySetTable(String sql) {
        MyConnection.ExcuteQuerySetTable(sql);
    }

}
