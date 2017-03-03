package com.arny.myapidemo;//Package name

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.arny.myapidemo.activities.*;

public class HomeActivity extends AppCompatActivity {
    private final Class[] sActivities = new Class[] {
            TabsActivity.class,
            XmlActivity.class,
            ScrollViewActivity.class,
            DialogActivity.class,
            SqlLiteActivity.class,
            AnimActivity.class,
            FragmentActivity.class,
            AlertCustomActivity.class,
            SimpleUIActivity.class,
            RandomLoaderActivity.class,
            CoordinatorActivity.class,
            TimerTaskActivity.class,
            StartAlarmActivity.class,
            VolleyTestActivity.class,
            IntentServiceActivity.class,
            ChronosTestActivity.class,
            LocationActivity.class,
    };
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        ListView listView = (ListView) findViewById(R.id.main_list);
        String[] classesNames = getClassesNames();

        if (classesNames.length>0){
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classesNames));
            listView.setOnItemClickListener(onListItemClick);
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            setTitle(getString(R.string.res_main_title));
        }
    }

    private String[] getClassesNames() {
        String[] names = new String[sActivities.length];
        for (int i = 0; i < sActivities.length; i++) {
            names[i] = sActivities[i].getSimpleName();
        }
        return names;
    }

    AdapterView.OnItemClickListener onListItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startActivity(new Intent(getBaseContext(), sActivities[position]));
        }
    };

    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(getBaseContext(), SettingsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                HomeActivity.this);
        quitDialog.setTitle(getString(R.string.exit_question));
        quitDialog.setNegativeButton(getString(R.string.no_answer), null);
        quitDialog.setPositiveButton(getString(R.string.yes_answer),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog alert = quitDialog.create();
        alert.show();
    }

}