package com.example.mx.ivics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ivics.lib.communicatetools.Communicate;
import com.ivics.lib.communicatetools.OnDataReceiveListener;
import com.ivics.lib.data.Data;
import com.ivics.lib.dataprocess.HostFrame;
import com.ivics.lib.protocol.DataProtocol;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.fillAfter;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity{
    private TextView tv;
    DataProtocol mDataProtocol;
    private Button Host;
    private Button Obu;
    private Button Participant;
    private Button Rsu;
    private Button MapResult;
    private Button BoxSetting;
    private Button RsiResult;
    private Button Target;
    private Button TrafficLightResult;
    private Button TrafficLight;
    private Button Register;
    private Button TrafficIncident;
    private Button Permission;
    private Button LogicMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataProtocol=DataProtocol.getInstance();
        mDataProtocol.start();

        tv= (TextView) findViewById(R.id.tv);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

        Host=(Button)findViewById(R.id.host);
        Obu=(Button)findViewById(R.id.obu);
        Participant=(Button)findViewById(R.id.participant);
        Rsu=(Button)findViewById(R.id.rsu);
        MapResult=(Button)findViewById(R.id.mapResult);
        BoxSetting=(Button)findViewById(R.id.boxSetting);
        RsiResult=(Button)findViewById(R.id.rsiResult);
        Target=(Button)findViewById(R.id.target);
        TrafficLightResult=(Button)findViewById(R.id.trafficLightResult);
        TrafficLight=(Button) findViewById(R.id.trafficLight);
        Register=(Button)findViewById(R.id.register);
        TrafficIncident=(Button)findViewById(R.id.trafficIncident);
        Permission=(Button)findViewById(R.id.permission);
        LogicMap=(Button)findViewById(R.id.logicMap);


        Host.setOnClickListener(new MyClickListener());
        Obu.setOnClickListener(new MyClickListener());

    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.host:
                    mDataProtocol.setOnDataRefreshListener(new Communicate.OnDataRefreshListener() {
                        @Override
                        public void onDataRefresh(final Data data) {

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                            String s=data.toString();
//                            tv.setText(s);
                                    double a=0;
                                    if(data.getHostFrame()!=null&&data.getHostFrame().hostobu!=null){
                                        a=data.getHostFrame().hostobu.latitude;
                                        Field[] fields = data.getHostFrame().hostobu.getClass().getDeclaredFields();

                                        tv.setText(fields.length+"");
                                        String s="";
                                        for (int i=0;i<fields.length;i++) {
                                            try {
                                                s+=fields[i].getName()+":   "+fields[i].get(data.getHostFrame().hostobu)+"\n";
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        tv.setText(s);



                                    }
//                            tv.setText(a+"");


                                }
                            });
                        }



                    });
                    break;
                case R.id.obu:
                    mDataProtocol.setOnDataRefreshListener(new Communicate.OnDataRefreshListener() {
                        @Override
                        public void onDataRefresh(final Data data) {

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                            String s=data.toString();
//                            tv.setText(s);
                                    double a=0;
                                    if(data.getObuFrame()!=null&&data.getObuFrame().objectList!=null){
                                        a=data.getHostFrame().hostobu.latitude;
                                        Field[] fields = data.getObuFrame().objectList.getClass().getClass().getDeclaredFields();

                                        tv.setText(fields.length+"");
                                        String s="";
                                        for (int i=0;i<fields.length;i++) {
                                            try {
                                                s+=fields[i].getName()+":   "+fields[i].get(data.getObuFrame().objectList.getClass())+"\n";
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        tv.setText(s);



                                    }
//                            tv.setText(a+"");


                                }
                            });
                        }



                    });
                    break;
                default:
                    break;
            }
        }
    }

    private Communicate.OnDataRefreshListener listener=new Communicate.OnDataRefreshListener() {
        @Override
        public void onDataRefresh(final Data data) {

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            String s=data.toString();
//                            tv.setText(s);
                            double a=0;
                            if(data.getHostFrame()!=null&&data.getHostFrame().hostobu!=null){
                                a=data.getHostFrame().hostobu.latitude;
                                Field[] fields = data.getHostFrame().hostobu.getClass().getDeclaredFields();

                                tv.setText(fields.length+"");
                                String s="";
                                for (int i=0;i<fields.length;i++) {
                                    try {
                                        s+=fields[i].getName()+":   "+fields[i].get(data.getHostFrame().hostobu)+"\n";
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                                tv.setText(s);



                            }
//                            tv.setText(a+"");


                        }
                    });
                }



    };
}
