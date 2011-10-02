package gae.howabout.service;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class Channel {

   public String getChannel(String channelId){
       ChannelService cs = ChannelServiceFactory.getChannelService();
       return  cs.createChannel(channelId);
   }
    
   public void sendMessage(String channelID, String content) {
       ChannelService cs = ChannelServiceFactory.getChannelService();
       ChannelMessage cm = new ChannelMessage(channelID, content);
       cs.sendMessage(cm);
   }
}
