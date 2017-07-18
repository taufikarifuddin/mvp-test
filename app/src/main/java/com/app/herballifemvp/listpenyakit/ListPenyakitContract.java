package com.app.herballifemvp.listpenyakit;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;

/**
 * Created by Taufik on 07/17/17.
 */

public interface ListPenyakitContract {

    interface  View extends BaseView{
        void setItem(String[] data);
        void navigateToDetailPenyakit(String data);
    }

    interface Presenter extends BasePresenter{
        void getItem();
    }

}
