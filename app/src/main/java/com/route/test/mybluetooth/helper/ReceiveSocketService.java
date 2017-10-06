package com.route.test.mybluetooth.helper;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收消息的服务
 */
public class ReceiveSocketService {
    public static int after = 0;
    public static void receiveMessage(Handler handler,InputStream inputStream) {
        if (handler == null) return;
        Log.e("iiiiiiiiiiiii","inputStream");
           byte[] temp = new byte[1024];
           int size = 0;
            while (true) {
                try {
                    while ((size = inputStream.read(temp)) !=-1) {
                        StringBuffer sb=new StringBuffer();
//                        byte[] bytes=new byte[size];
                        for(int i=0;i<size;i++){
                            //这个temp数组中的值就是血压计返回的所有值（只有数字，每个数字代表什么在文档中都有
                            sb.append(temp[i] + ",");
                        }
                        //-128(运行中)，64（停止），0（未运行）
                        byte b = temp[2];
                        if(b==-128){
                            int shu = after;
                            int shou = temp[4];
                            after = shou;
                            Map<String,Integer> map2=new HashMap<>();
                            map2.put("shou",shou);
                            map2.put("shu",shu);

                            System.out.println("===="+shu+"==="+shou);
                            Message message = new Message();
                            message.obj = map2;
                            message.what = 1;
                            handler.sendMessage(message);
                        }else if(b==64){
                            int b1 = temp[6];
                            int b2 = temp[8];
                            int b3 = temp[10];
                            Map<String,Integer> map=new HashMap<>();
                            map.put("b1",b1);
                            map.put("b2",b2);
                            map.put("b3",b3);


                            System.out.println("===="+b1+"==="+b2+"===="+b3);
                            Message message = new Message();
                            message.obj = map;
                            message.what = 2;
                            handler.sendMessage(message);
                            return;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
