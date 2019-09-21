package com.surya.apiandrecyclerviewmvp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.surya.apiandrecyclerviewmvp.databinding.MainActivityBinding;
import com.surya.apiandrecyclerviewmvp.json_parson.EmployeeListActivity;
import com.surya.apiandrecyclerviewmvp.presenter.MainPresenter;
import com.surya.apiandrecyclerviewmvp.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        mainPresenter = new MainPresenter(this);
        binding.setPresenter(mainPresenter);
//        setContentView(R.layout.main_activity);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonClick() {
        startActivity(new Intent(this, EmployeeListActivity.class));
        finish();
    }
}
