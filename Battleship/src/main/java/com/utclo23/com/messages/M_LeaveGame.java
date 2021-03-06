/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.com.messages;

import com.utclo23.data.facade.IDataCom;
import com.utclo23.data.structure.PublicUser;

/**
 * M_LeaveGame is a Message generated when a user wants to leave a game.
 * @author Thibault CHICHE
 */
public class M_LeaveGame extends Message {
    
    /**
     * Constructor.
     * @param user is the message's sender
     */
    public M_LeaveGame(PublicUser user){
        super(user);
    }
    
    @Override
    public void callback(IDataCom iDataCom){
        iDataCom.opponentHasLeftGame();
    }
}
