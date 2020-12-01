package com.wowowo.util;

import com.wowowo.model.PokerLabel;

public class GameUtils {
    public static void move(PokerLabel pokerLabel,int x,int y) throws InterruptedException {
        pokerLabel.setLocation(x,y);
        Thread.sleep(10);
    }
}
