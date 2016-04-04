package com.example.indianic.gridviewwithglideimage;

import com.example.indianic.gridviewwithglideimage.database.SqliteDBhelper;

/**
 * Created by indianic on 04/04/16.
 */
public class Application extends android.app.Application {

    private SqliteDBhelper sqliteDBhelper;
    @Override
    public void onCreate() {
        super.onCreate();
        sqliteDBhelper = new SqliteDBhelper(getApplicationContext());
    }

    public SqliteDBhelper getSqliteDBhelper() {
        return sqliteDBhelper;
    }
}
