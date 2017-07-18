package com.app.herballifemvp.DetailPenyakit;

import android.content.Context;

import com.app.herballifemvp.data.storage.PenyakitRepository;

/**
 * Created by Taufik on 07/17/17.
 */

public class DetailPenyakitPresenter implements DetailPenyakitContract.Presenter {

    DetailPenyakitContract.View view;
    PenyakitRepository repo;

    DetailPenyakitPresenter(DetailPenyakitContract.View view, Context ctx){
        this.view = view;
        repo = new PenyakitRepository(ctx);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void getDetail(String name) {
        this.view.setDetail( repo .getDetail(name) );
    }
}
