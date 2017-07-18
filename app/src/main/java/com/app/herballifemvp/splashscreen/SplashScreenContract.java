package com.app.herballifemvp.splashscreen;

import com.app.herballifemvp.BasePresenter;
import com.app.herballifemvp.BaseView;

/**
 * Created by Taufik on 07/16/17.
 */

public interface SplashScreenContract {

    interface Presenter extends BasePresenter{
        void processSplashScreen();
    }

    interface View extends BaseView<Presenter>{
        public void navigateToMenu();
    }

}
