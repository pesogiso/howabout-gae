$(document).ready(function() {

	// channelTokenはindexで代入済み
	var channel = new goog.appengine.Channel(channelToken);
	//console.debug("token : " + channelToken);
    var socket = channel.open();
       
    socket.onmessage = function(msg) {
        var data = $.parseJSON(msg.data);
        if(data.operation == 'answer') {
        	if(data.btn == '0') {
        		$("#result1").html(data.count1);
        		$("#result2").html(data.count2);
        		$("#result3").html(data.count3);
        		$("#result4").html(data.count4);
        	}else if(data.btn == '1') {
        		$("#result1").html(data.count);
        	}else if(data.btn == '2') {
        		$("#result2").html(data.count);
        	}else if(data.btn == '3') {
        		$("#result3").html(data.count);
        	}else if(data.btn == '4') {
        		$("#result4").html(data.count);
        	}
        } else if(data.operation == 'question') {
        	window.alert('新しい質問があります！');
        	document.location = "/";
        }
      };
      
    // Global
    myapp2 = {
    		jump : function(){
        		document.location = "/";
        	}
    }
    myapp = {	
    	postMessage : function(){
			$.post(
					"message",
					{pushedNum:'-1', qtf:$('#qtf').val(), atf1:$('#atf1').val(), atf2:$('#atf2').val(), atf3:$('#atf3').val(), atf4:$('#atf4').val()},
					null,	
					'text'
				)
		}
    }
});
