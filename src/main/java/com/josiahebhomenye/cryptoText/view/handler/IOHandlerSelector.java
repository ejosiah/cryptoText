package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.ReflectionUtils;
import com.josiahebhomenye.cryptoText.view.GUI;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josiah on 12/12/2015.
 */
public class IOHandlerSelector {

    public final Map<String, Class<? extends IOHandler>> handlerTypes = new HashMap<>();
    public final Map<String, IOHandler> handlers = new HashMap<>();
    public final GUI gui;

    public IOHandlerSelector(GUI gui){
        handlerTypes.put("txt", TextFileHandler.class);
        this.gui = gui;
    }


    public IOHandler forFile(File file){
         String ext = extractExention(file);
        if(handlers.containsKey(ext)){
            return handlers.get(ext);
        }else{
            IOHandler handler = findexistingInstance(handlerTypes.get(ext));
            if(handler == null){
                handler = ReflectionUtils.createInstance(handlerTypes.get(ext), gui, file);
            }
            handlers.put(ext, handler);
        }
        return handlers.get(ext);
    }

    public IOHandler findexistingInstance(Class<? extends IOHandler> type){
        for(IOHandler handler : handlers.values()){
            if(type.isAssignableFrom(handler.getClass())){
                return handler;
            }
        }
        return null;
    }

    private String extractExention(File name){
        int atThisIndex = name.getName().lastIndexOf('.') + 1;
        return name.getName().substring(atThisIndex);
    }

}
