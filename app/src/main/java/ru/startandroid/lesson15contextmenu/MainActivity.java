package ru.startandroid.lesson15contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        final int MENU_COLOR_RED = 1;
        final int MENU_COLOR_GREEN = 2;
        final int MENU_COLOR_BLUE = 3;

        final int MENU_SIZE_22 = 4;
        final int MENU_SIZE_26 = 5;
        final int MENU_SIZE_30 = 6;

        TextView tvColor, tvSize;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //находим вьюхи
            tvColor = (TextView) findViewById(R.id.tvColor);
            tvSize = (TextView) findViewById(R.id.tvSize);

            // для tvColor и tvSize необходимо создавать контекстное меню
            registerForContextMenu(tvColor);
            registerForContextMenu(tvSize);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {

            switch (v.getId()) {
                //кейсы для цветов и размеров шрифта
                case R.id.tvColor:
                    menu.add(0, MENU_COLOR_RED, 0, "Red");
                    menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                    menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                    break;
                case R.id.tvSize:
                    menu.add(0, MENU_SIZE_22, 0, "22");
                    menu.add(0, MENU_SIZE_26, 0, "26");
                    menu.add(0, MENU_SIZE_30, 0, "30");
                    break;
            }
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            
            switch (item.getItemId()) {
                // пункты меню для tvColor
                case MENU_COLOR_RED:
                    tvColor.setTextColor(Color.RED); //меняем цвет
                    tvColor.setText("Text color = red");//меняем текст
                    break;
                case MENU_COLOR_GREEN:
                    tvColor.setTextColor(Color.GREEN);//меняем цвет
                    tvColor.setText("Text color = green");//меняем текст
                    break;
                case MENU_COLOR_BLUE:
                    tvColor.setTextColor(Color.BLUE);//меняем цвет
                    tvColor.setText("Text color = blue");//меняем текст
                    break;
                // пункты меню для tvSize
                case MENU_SIZE_22:
                    tvSize.setTextSize(22); // меняем размер шрифта
                    tvSize.setText("Text size = 22");// меняем текст
                    break;
                case MENU_SIZE_26:
                    tvSize.setTextSize(26);// меняем размер шрифта
                    tvSize.setText("Text size = 26");// меняем текст
                    break;
                case MENU_SIZE_30:
                    tvSize.setTextSize(30);// меняем размер шрифта
                    tvSize.setText("Text size = 30");// меняем текст
                    break;
            }
            return super.onContextItemSelected(item);
        }
    }
