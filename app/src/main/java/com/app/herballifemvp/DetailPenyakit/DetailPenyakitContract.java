package com.app.herballifemvp.DetailPenyakit;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;
import com.app.herballifemvp.data.Catalog;
import com.app.herballifemvp.data.Penyakit;

/**
 * Created by Taufik on 07/17/17.
 */

public interface DetailPenyakitContract {

    interface View extends BaseView{
        void setDetail(Penyakit data);
        void navigateToCatalog();
    }

    interface Presenter extends BasePresenter {
        void getDetail(String name);
    }

}
