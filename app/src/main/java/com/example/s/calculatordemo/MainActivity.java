package com.example.s.calculatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_0;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_clear;
    Button button_del;
    Button button_add;
    Button button_minus;
    Button button_multiply;
    Button button_divide;
    Button button_point;
    Button button_equle;
    EditText edx;
    boolean clear_flag;//清空标示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0=(Button) findViewById(R.id.button_0);
        button_1=(Button) findViewById(R.id.button_1);
        button_2=(Button) findViewById(R.id.button_2);
        button_3=(Button) findViewById(R.id.button_3);
        button_4=(Button) findViewById(R.id.button_4);
        button_5=(Button) findViewById(R.id.button_5);
        button_6=(Button) findViewById(R.id.button_6);
        button_7=(Button) findViewById(R.id.button_7);
        button_8=(Button) findViewById(R.id.button_8);
        button_9=(Button) findViewById(R.id.button_9);
        button_clear=(Button) findViewById(R.id.button_clear);
        button_del=(Button) findViewById(R.id.button_del);
        button_add=(Button) findViewById(R.id.button_add);
        button_minus=(Button) findViewById(R.id.button_minus);
        button_multiply=(Button) findViewById(R.id.button_multiply);
        button_divide=(Button) findViewById(R.id.button_divide);
        button_point=(Button) findViewById(R.id.button_point);
        button_equle=(Button) findViewById(R.id.button_equle);
        edx=(EditText)findViewById(R.id.input);

        //设置监听事件
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_equle.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        String str =edx.getText().toString();
        switch (v.getId()){
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.button_point:
                if (clear_flag){
                    clear_flag=false;
                    str ="";
                    edx.setText("");
                }
                edx.setText(str+((Button)v).getText());
                break;
            //获取输入的数字

            case R.id.button_add:
            case R.id.button_divide:
            case R.id.button_minus:
            case R.id.button_multiply:
                if (clear_flag){
                    clear_flag=false;
                    str ="";
                    edx.setText("");
                }
                edx.setText(str+" "+((Button)v).getText()+" ");
                break;
            //运算符

            case R.id.button_del:
                if (clear_flag){
                    clear_flag=false;
                    str = "";
                    edx.setText("");
                }else if(str!=null&&!str.equals("")){
                    if ((str.substring(str.length()-1,str.length())).equals(" ")) {
                        // 运算符左右有空格，所以要删除3个字符
                        edx.setText(str.substring(0, str.length() - 3));
                    }else
                    edx.setText(str.substring(0,str.length()-1));
                }
                break;
            //退格键

            case R.id.button_clear:
                edx.setText("");
                clear_flag = false;
                break;
            //清除按钮

            case R.id.button_equle:
                getResult();
                break;
            default:
                break;
        }
    }
        //    运算结果
    private void getResult(){
        String exp=edx.getText().toString();
        if(exp.equals("1 + 1")){
            Toast.makeText(getApplicationContext(), "逗比！这么简单还要用计算器",
                    Toast.LENGTH_SHORT
            ).show();
        }
        if (exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }if (clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));//运算符前面的字符
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//运算符
        String s2=exp.substring(exp.indexOf(" ")+3);//运算符后面的字符串
        if (s2.contains(" ")){
            // 连续输入运算符 使运算结果为0
            edx.setText("0");
        }else if (!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);//将S1转换成double类型
            double d2=Double.parseDouble(s2);
            if (op.equals("+")){
                result=d1+d2;
            }else if (op.equals("-")){
                result=d1-d2;
            }else if (op.equals("×")){
                BigDecimal D1=new BigDecimal(Double.toString(d1));// 浮点运算的缺陷，先转换为BigDecimal
                BigDecimal D2=new BigDecimal(Double.toString(d2));
                result =D1.multiply(D2).doubleValue();//两次相乘在将结果转化为double
            }else if (op.equals("÷")){
                if (d2==0){
                    result=0;
                }else {
                    result = d1 / d2;
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                if (exp.length()>10) {
                    edx.setText(result+"");
                }else {
                    String s = String.valueOf(result);
                    String newS = s.substring(0, s.indexOf("."));
                    edx.setText(newS + "");
                }
            }else {
                edx.setText(result+"");
            }
        }else if(!s1.equals("")&&!s2.equals("")){
            edx.setText(exp);
            }else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result=0+d2;
            }else if (op.equals("-")){
                result=0-d2;
            }else if (op.equals("×")){
                result=0;
            }else if (op.equals("÷")){
                result=0;
            }
            if(!s2.contains(".")){
                int r=(int)result;
                edx.setText(r+"");
            }else {
                edx.setText(result+"");
            }
        }else{
            edx.setText("");
        }

    }
}
