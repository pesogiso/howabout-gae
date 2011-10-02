package gae.howabout.controller;

//import java.util.ArrayList;

import gae.howabout.model.SaveData;
import gae.howabout.service.Channel;

import java.util.HashMap;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

//import com.google.appengine.api.datastore.Key;

import net.arnx.jsonic.JSON;

public class MessageController extends Controller {

//    private Channel channel = new Channel();
    
    @Override
    public Navigation run() throws Exception {
        
        // テキストボックスの内容が送られてきたとき
        if(asString("pushedNum").equals("-1")) {
            // postされたときに呼ばれる
            String Question = asString("qtf");
            String Answer1 = asString("atf1");
            String Answer2 = asString("atf2");
            String Answer3 = asString("atf3");
            String Answer4 = asString("atf4");
            
            // テキストフィールドの入力内容保存
            SaveData question = new SaveData("Question", Question);
            Datastore.put(question);
            SaveData answer1 = new SaveData("Answer1", Answer1);
            Datastore.put(answer1);
            SaveData answer2 = new SaveData("Answer2", Answer2);
            Datastore.put(answer2);
            SaveData answer3 = new SaveData("Answer3", Answer3);
            Datastore.put(answer3);
            SaveData answer4 = new SaveData("Answer4", Answer4);
            Datastore.put(answer4);
            
            // カウントクリア
            SaveData count1 = new SaveData("Count1", "0");
            Datastore.put(count1);
            SaveData count2 = new SaveData("Count2", "0");
            Datastore.put(count2);
            SaveData count3 = new SaveData("Count3", "0");
            Datastore.put(count3);
            SaveData count4 = new SaveData("Count4", "0");
            Datastore.put(count4);
            
            Map<String, String> data = new HashMap<String, String>();
            data.put("operation", "question");
            Channel channel = new Channel();
            String channelId = "testchannel";
            channel.sendMessage(channelId, JSON.encode(data));
        } else {
            int cnt = 0;
            Map<String, String> data = new HashMap<String, String>();
            data.put("operation", "answer");
            // 保存されていた値に１を足し、再度保存
            switch(Integer.parseInt( asString("pushedNum") )) {
                case 0 : 
                    Key keyC1 = SaveData.createKey("Count1");
                    SaveData C1 = Datastore.get(SaveData.class, keyC1);
                    cnt = Integer.parseInt( C1.getMessage() ) + 1;
                    SaveData count1 = new SaveData("Count1", Integer.toString(cnt) );
                    Datastore.put(count1);
                    data.put("btn", "1");
                    break;
                    
                case 1 : 
                    Key keyC2 = SaveData.createKey("Count2");
                    SaveData C2 = Datastore.get(SaveData.class, keyC2);
                    cnt = Integer.parseInt( C2.getMessage() ) + 1;
                    SaveData count2 = new SaveData("Count2", Integer.toString(cnt) );
                    Datastore.put(count2);
                    data.put("btn", "2");
                    break;
                
                case 2 : 
                    Key keyC3 = SaveData.createKey("Count3");
                    SaveData C3 = Datastore.get(SaveData.class, keyC3);
                    cnt = Integer.parseInt( C3.getMessage() ) + 1;
                    SaveData count3 = new SaveData("Count3", Integer.toString(cnt) );
                    Datastore.put(count3);
                    data.put("btn", "3");
                    break;
                    
                case 3 : 
                    Key keyC4 = SaveData.createKey("Count4");
                    SaveData C4 = Datastore.get(SaveData.class, keyC4);
                    cnt = Integer.parseInt( C4.getMessage() ) + 1;
                    SaveData count4 = new SaveData("Count4", Integer.toString(cnt) );
                    Datastore.put(count4);
                    data.put("btn", "4");
                    break;
            }
            data.put("count", Integer.toString(cnt));            
             
            //////////////////////
            // クライアントへのPUSH
            // クライアント側ではサーバー側から送られてきたchannelIDを使い
            // goog.appengine.Channelをnewする
            String channelId = "testchannel";
            Channel channel = new Channel();
            channel.sendMessage(channelId, JSON.encode(data));
            //System.out.println(JSON.encode(data));
        }
        
        // POSTに対するリプライ
        return null; // htmlは返さない
    }
}


