package com.app.herballifemvp.catalog;

import android.widget.ArrayAdapter;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;

import java.util.ArrayList;

/**
 * Created by Taufik on 07/16/17.
 */

public interface ListCatalogContract {

    interface View extends BaseView<Presenter>{
        void setItem(ArrayList<String> data);
        void navigateToDetailCatalog(String tumbuhan);
    }

    interface Presenter extends BasePresenter{
        void getListTumbuhan();
    }

}
