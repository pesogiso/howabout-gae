package gae.howabout.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import com.google.appengine.api.datastore.Key;

import gae.howabout.model.SaveData;
import gae.howabout.service.Channel;

import java.util.ArrayList;

public class IndexController extends Controller {

    private Channel channel = new Channel();
   
    public String Question = "質問";
    public String Answer1 = "回答１";
    public String Answer2 = "回答２";
    public String Answer3 = "回答３";
    public String Answer4 = "回答４";
    
    @Override
    public Navigation run() throws Exception {
       
        // チャンネル新規作成
        String channelId = "testchannel"; 
        String channelToken = channel.getChannel(channelId); 
        
        // リクエストにチャンネルのトークンを入れる(hiddenパラメータ)
        requestScope("channelToken", channelToken);
          
        // データベースから取得
        Key keyQ = SaveData.createKey("Question");
        SaveData Q = Datastore.get(SaveData.class, keyQ);        
        
        Key keyA1 = SaveData.createKey("Answer1");
        SaveData A1 = Datastore.get(SaveData.class, keyA1);
        Key keyA2 = SaveData.createKey("Answer2");
        SaveData A2 = Datastore.get(SaveData.class, keyA2);
        Key keyA3 = SaveData.createKey("Answer3");
        SaveData A3 = Datastore.get(SaveData.class, keyA3);
        Key keyA4 = SaveData.createKey("Answer4");
        SaveData A4 = Datastore.get(SaveData.class, keyA4);
        
        ArrayList<String> dataList;
        dataList = new ArrayList<String>();
        dataList.add(A1.getMessage());
        dataList.add(A2.getMessage());
        dataList.add(A3.getMessage());
        dataList.add(A4.getMessage());
        
        Key keyC1 = SaveData.createKey("Count1");
        SaveData C1 = Datastore.get(SaveData.class, keyC1);
        Key keyC2 = SaveData.createKey("Count2");
        SaveData C2 = Datastore.get(SaveData.class, keyC2);
        Key keyC3 = SaveData.createKey("Count3");
        SaveData C3 = Datastore.get(SaveData.class, keyC3);
        Key keyC4 = SaveData.createKey("Count4");
        SaveData C4 = Datastore.get(SaveData.class, keyC4);
        
        ArrayList<String> dataList2;
        dataList2 = new ArrayList<String>();
        dataList2.add(C1.getMessage());
        dataList2.add(C2.getMessage());
        dataList2.add(C3.getMessage());
        dataList2.add(C4.getMessage());
        
        // HTMLに渡す　
        requestScope("Question", Q.getMessage());
        requestScope("Answer", dataList);
        requestScope("Count", dataList2);
        
        // index.jspにリダイレクト
        return forward("index.jsp");
    }
}
