package com.KIL.Scene;


import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import com.KIL.LuckyBall.R;

import com.KIL.Layer.*;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_MenuScene extends CCScene {
	private LuckyBall_MenuLayer menuLayer;
	private LuckyBall_DataManager dataManager;

	public LuckyBall_MenuScene() {
		super();
		
		dataManager = LuckyBall_DataManager.sharedManager();
		
		menuLayer = new LuckyBall_MenuLayer();
		menuLayer.delegate = this;
		addChild(menuLayer);
		back_Play(true);
	}
	
	public void effect_Play() {
		if (dataManager.volumeInfo == Define.OPTION_OFF)
			return;
		if (dataManager.backAudio == true) {
			Define.playEffect(R.raw.luckyball_menusel);
			Define.stopSound();
		}
	}
	
	public void back_Play(boolean replay) {
	    if (dataManager.volumeInfo == Define.OPTION_OFF)
	        return;
		if (dataManager.backAudio == true)
		{
			Define.playSound();
		}
	}
	
	public void loadRegInfo() {
		effect_Play();
		
	}
	
	public void highScores() {
		effect_Play();
		CCDirector.sharedDirector().replaceScene(new LuckyBall_HighScoreScene());
	}
	
	public void aboutGame() {
		effect_Play();
		CCDirector.sharedDirector().replaceScene(new LuckyBall_HelpScene());
	}
	
	public void startGame() {
		effect_Play();
		CCDirector.sharedDirector().replaceScene(new LuckyBall_GameScene());
	}
	
	public void onOption() {
		effect_Play();
		CCDirector.sharedDirector().replaceScene(new LuckyBall_OptionScene());
	}
	
	public void gameCenter() {
		effect_Play();
	}
}
