package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    PlayFragment playFragment=new PlayFragment();
HistoryFragment historyFragment=new HistoryFragment();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView a=findViewById(R.id.bottom_navigation);
        a.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Game:
                    replaceFragment(playFragment);
                    return true;
                case R.id.History:
                   replaceFragment(historyFragment);
                    return true;
            }
            return false;
        });
    }
    public void replaceFragment(Fragment fragment){
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containers,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opinion:
                Intent feedback = new Intent(Intent.ACTION_SEND);
              feedback.setType("text/email");
                feedback.putExtra(Intent.EXTRA_EMAIL, new String[] { "20021513@vnu.edu.vn" });
                feedback.putExtra(Intent.EXTRA_SUBJECT, "Góp ý");
                startActivity(feedback);
                break;
            case R.id.information:
                Intent intent=new Intent(this,Information.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}