package com.app.herballifemvp.detailcatalog;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;
import com.app.herballifemvp.catalog.ListCatalogContract;
import com.app.herballifemvp.data.Catalog;

/**
 * Created by Taufik on 07/17/17.
 */

public interface DetailCatalogContract {

    interface View extends BaseView<Presenter>{
        void setDetail(Catalog data);
        void setErrorMessage(String error);
    }

    interface Presenter extends BasePresenter{
        void getDetail(String name);
    }

}
