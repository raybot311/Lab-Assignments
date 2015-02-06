package com.example.thegrid.basiccalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {

    private EditText screen;
    private float number;
    private String operation;
    private ButtonClickListener btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (EditText)findViewById(R.id.editText);
        int idList[]={R.id.button,R.id.buttonZero,R.id.button2,R.id.button3,R.id.button4,
                R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.buttonDecimal,
                R.id.buttonEqual,R.id.buttonC,R.id.buttonAdd,R.id.buttonSub};

        for(int id: idList){
            btnClick = new ButtonClickListener();
            View v = (View)findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void nMath(String str){
        number = Float.parseFloat(screen.getText().toString());
        operation = str;    //save operation
        screen.setText("");//clear screen
    }

    public void getKeyboard(String str){
        String screenCurrent = screen.getText().toString();
        screenCurrent += str;
        screen.setText(screenCurrent);
    }

    public void mResult(){
        float numberAfter = Float.parseFloat(screen.getText().toString());
        float result = 0;
        if(operation.equals("+")){
            result = numberAfter + number;
        }
        if(operation.equals("-")){
            result = number - numberAfter;
        }
        screen.setText(String.valueOf(result));
    }

    //New class btnclicklistener
    public class ButtonClickListener implements OnClickListener{
        public void onClick(View v){
            switch(v.getId()){
                case R.id.buttonC:      //clear screen
                    screen.setText("0");
                    number = 0;
                    operation = "";
                    break;
                case R.id.buttonAdd:
                    nMath("+");
                    break;
                case R.id.buttonSub:
                    nMath("-");
                    break;
                case R.id.buttonEqual:
                    mResult();
                    break;
                default:
                    String numb =((Button)v).getText().toString();
                    getKeyboard(numb);
                    break;

            }
        }
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
