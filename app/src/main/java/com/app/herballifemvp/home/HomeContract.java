package com.app.herballifemvp.home;

import android.content.Intent;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;

/**
 * Created by Taufik on 07/16/17.
 */

public interface HomeContract {

    interface Presenter extends BasePresenter{
        void navigate(int id);
    }

    interface View extends BaseView{

        void navigateToSearch();
        void navigateToCatalog();
        void naviagetToHelp();
        void navigateToExit();
        void showExitDialog();
        void naviagetToActivity(Intent intent);
    }

}
