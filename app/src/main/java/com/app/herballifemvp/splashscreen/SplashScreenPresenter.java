package com.app.herballifemvp.splashscreen;

/**
 * Created by Taufik on 07/16/17.
 */

public class SplashScreenPresenter implements SplashScreenContract.Presenter {

    SplashScreenContract.View view;

    public SplashScreenPresenter(SplashScreenContract.View view){
        this.view = view;
//        view.setPresenter(this);
    }

    @Override
    public void processSplashScreen() {
        Thread background = new Thread(new Runnable() {

            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                    }
                } catch (Throwable t) {

                }
                view.navigateToMenu();
            }
        });

        // start the background thread
        background.start();
    }

    @Override
    public void onStart() {
        processSplashScreen();
    }
}
