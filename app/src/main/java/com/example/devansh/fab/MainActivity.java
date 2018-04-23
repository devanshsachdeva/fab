package com.example.devansh.fab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton Fab_toy , Fab_mail , Fab_call;
    Animation Fabopen,Fabclose,Fabcl,Fabancl;
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fab_toy =(FloatingActionButton)findViewById(R.id.fab_toys);
        Fab_mail =(FloatingActionButton)findViewById(R.id.fab_email);
        Fab_call =(FloatingActionButton)findViewById(R.id.fab_phone);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Fab_toy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        Fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        Fabcl = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        Fabancl = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        Fab_toy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isopen)
                {
                    Fab_call.startAnimation(Fabclose);
                    Fab_mail.startAnimation(Fabclose);
                    Fab_toy.startAnimation(Fabancl);
                    Fab_call.setClickable(false);
                    Fab_mail.setClickable(false);
                    isopen = false;
                }

                else
                {
                    Fab_call.startAnimation(Fabopen);
                    Fab_mail.startAnimation(Fabopen);
                    Fab_toy.startAnimation(Fabcl);
                    Fab_call.setClickable(true);
                    Fab_mail.setClickable(true);
                    isopen = true;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
