package com.app.herballifemvp.listpenyakit;

/**
 * Created by Taufik on 07/17/17.
 */

public class ListPenyakitPresenter implements ListPenyakitContract.Presenter {

    String[] items = { "Batuk Pada Anak", "Sakit Perut","Diare","Mual",
            "Kembung","Wasir","Biduran",
            "Demam","Step","Kencing Batu","Radang Paru-paru","Asma","Mimisan","Hepatitis",
            "Prostat","Keputihan","Diabetes Melitus","Bisul","Jerawat","Gatal berupa bintik-bintik merah bergelembung air",
            "Gatal pada bekas luka yang sudah kering","Nyeri haid","Haid bau anyir","Batuk Kering","Sariawan","Campak",
            "Borok","Jantung Lemah","Gangguan saraf","Rematik","Demam Pada Anak","Masuk Angin","Disentri","Hipertensi",
            "Diabetes","Kutu Air","Sakit Kepala","Flu","Bronkitis","Cacingan","Migrain","Maag","Cantengan","Osteoporosis"};

    ListPenyakitContract.View view;

    public ListPenyakitPresenter(ListPenyakitContract.View view){
        this.view = view;
    }

    @Override
    public void onStart() {
        this.getItem();
    }

    @Override
    public void getItem() {
        this.view.setItem(this.items);
    }
}
