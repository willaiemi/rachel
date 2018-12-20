package willian.duarte.rachel.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import willian.duarte.rachel.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout flMainFrame;
    private FloatingActionsMenu fabMenu;
    private com.getbase.floatingactionbutton.FloatingActionButton fabAddEvent;
    private com.getbase.floatingactionbutton.FloatingActionButton fabAddClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fabAddEvent.setColorNormal(R.color.colorPrimaryDark);
        fabMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                toast(fabAddEvent.getTitle());
            }

            @Override
            public void onMenuCollapsed() {

            }
        });

    } //close onCreate();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ma_fab_add_event:
                toast("hell yeah!");
                return;
        }
    } // close onClick();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_menu_item_home:
                    android.support.v4.app.FragmentManager fgm = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft = fgm.beginTransaction();
                    FragCalendar fragCalendar = new FragCalendar();
                    ft.replace(R.id.ma_fl_mainframe,fragCalendar);
                    ft.commit();
                    return true;
                case R.id.nav_menu_item_wardrobe:
                    android.support.v4.app.FragmentManager fgm2 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft2 = fgm2.beginTransaction();
                    FragWardrobe fragWardrobe = new FragWardrobe();
                    ft2.replace(R.id.ma_fl_mainframe,fragWardrobe);
                    ft2.commit();
                    return true;
                case R.id.nav_menu_item_settings:
                    android.support.v4.app.FragmentManager fgm3 = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction ft3 = fgm3.beginTransaction();
                    FragWardrobe fragWardrobe2 = new FragWardrobe();
                    ft3.replace(R.id.ma_fl_mainframe,fragWardrobe2);
                    ft3.commit();
                    return true;
            }
            return false;
        }
    }; // close navigation onClickListeners

    private void init(){
        flMainFrame = findViewById(R.id.ma_fl_mainframe);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.ma_nav);
        navigation.setSelectedItemId(R.id.nav_menu_item_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager fgm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fgm.beginTransaction();
        FragCalendar fragCalendar = new FragCalendar();
        ft.add(R.id.ma_fl_mainframe,fragCalendar);
        ft.commit();

        fabMenu = findViewById(R.id.ma_fabm_menu);

        fabAddEvent = findViewById(R.id.ma_fab_add_event);
        fabAddEvent.setOnClickListener(this);
        fabAddEvent.setTitle("arroba");

        fabAddClothes = findViewById(R.id.ma_fab_add_clothes);
    }// close init();

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }//close toast();
}
