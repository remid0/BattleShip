/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utclo23.ihmtable;

import java.rmi.server.UID;

/**
 *
 * @author pjeannot
 */
public interface IIHMTableToIHMMain {
    public void showSavedGameWithId(int id);
    public void createInGameGUI();
    public void stopTimer();
    public void showGame(UID guid);
}
