package com.taliano.option_menu_dinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 1, "MENU 1");
        menu.add(Menu.NONE, 2, 2, "MENU 2").setCheckable(true).setChecked(true);
        menu.add(Menu.NONE, 3, 3, "MENU 3");
        MenuItem menuItem = menu.add(Menu.NONE, 4, 4, "MENU 4");
        menuItem.setCheckable(true);
        menu.add(Menu.NONE, 5, 5, "MENU 5").setEnabled(false);

        final int GRUPPO = 5;
        SubMenu subMenu = menu.addSubMenu(Menu.NONE, 6, 6, "Opzioni");
        subMenu.add(GRUPPO, 20, 1, "Opzione 1");
        subMenu.add(GRUPPO, 21, 2, "Opzione 2");
        subMenu.add(GRUPPO, 22, 3, "Opzione 3");
        subMenu.setGroupCheckable(GRUPPO, true, true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        alert((String) item.getTitle());

        if(item.isCheckable()){
            item.setChecked(!item.isChecked());
        }

        return super.onOptionsItemSelected(item);
    }

    public void alert(String s){
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }
}
