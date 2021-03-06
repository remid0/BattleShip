/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.com.messages;

import java.io.Serializable;
import com.utclo23.data.structure.PublicUser;
import java.net.Inet4Address;
import com.utclo23.data.facade.IDataCom;

/**
 * Message is the abstract base class that all Messages inherit from.
 * @author Rémi DI VITA
 */
public abstract class Message implements Serializable{
    protected PublicUser user;
    protected Inet4Address ipSender;
    
    /**
     * This function is called by the receptor when it receives a new Message
     * @param iDataCom is the facade of the data module on the recipient
     */
    public abstract void callback(IDataCom iDataCom);
    
    /**
     * Constructor.
     * @param user is the message's sender
     */
    public Message(PublicUser user){
        this.user = user;
    }
    
    public void setIpSender(Inet4Address ip){
        ipSender = ip;
    }
}