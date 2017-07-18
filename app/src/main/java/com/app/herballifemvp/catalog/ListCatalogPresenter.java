package com.app.herballifemvp.catalog;

import android.content.Context;

import com.app.herballifemvp.data.storage.CatalogRepository;

/**
 * Created by Taufik on 07/17/17.
 */

public class ListCatalogPresenter implements ListCatalogContract.Presenter {

    CatalogRepository repo;
    ListCatalogContract.View view;

    public ListCatalogPresenter(ListCatalogContract.View view, Context context){
        repo = new CatalogRepository(context);
        this.view = view;
//        this.view.setPresenter(this);
    }

    @Override
    public void getListTumbuhan() {
        view.setItem(this.repo.getAll());
    }

    @Override
    public void onStart() {
        getListTumbuhan();
    }
}
