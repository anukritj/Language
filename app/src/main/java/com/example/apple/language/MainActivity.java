package com.example.apple.language;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

import java.util.Locale;

public class MainActivity extends LocalizationActivity implements View.OnClickListener {

    String lang;
    Locale myLocale;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportActionBar().setTitle(R.string.app_name);  // provide compatibility to all the versions

        findViewById(R.id.btn_change_language_toHindi).setOnClickListener(this);
        findViewById(R.id.btn_change_languagetoEnglish).setOnClickListener(this);
    }

    private View.OnClickListener onIndianLanguageSelected() {
        lang="Hindi";
        makeToast();
        return view -> setLanguage("hi");
    }

    private View.OnClickListener onEnglishLanguageSelected() {
        lang="English";
        makeToast();

        return view -> setLanguage("en");
    }

    public void makeToast(){
        Toast.makeText(getApplicationContext(),"Changed to "+lang,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_change_languagetoEnglish) {
            setLocale("en");
        }
        else if (id == R.id.btn_change_language_toHindi) {
            setLocale("hi");
        }
    }
    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }
}
