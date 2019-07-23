package net.xu.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.xu.domian.WebSocketServer;

@RestController
@RequestMapping("/api/ws")
public class WebSocketController {
 
 
    /**
     * 群发消息内容
     * @param message
     * @return
     */
    @RequestMapping(value="/sendAll")
    public String sendAllMessage(@RequestParam(required=true) String message){
        try {
        	System.out.println("收到全局广播请求");
        	System.out.println("message:"+message);
        	WebSocketServer.BroadCastInfo(message+"表发生了改动");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //http://127.0.0.1:8080/api/ws/sendAll
        return "ok";
    }
    
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    @RequestMapping(value="/sendOne", method=RequestMethod.GET)
    public String sendOneMessage(@RequestParam(required=true) String message,@RequestParam(required=true) String id){
        try {
            WebSocketServer.SendMessage(message,id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
    
    
    public static void main(String[] args) {
		System.out.println("Hello,World");
	}
    
}
