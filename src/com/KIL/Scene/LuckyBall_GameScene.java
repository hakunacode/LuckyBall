package com.KIL.Scene;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import com.KIL.LuckyBall.R;

import com.KIL.Layer.LuckyBall_GameLayer;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_GameScene extends CCScene {
	LuckyBall_GameLayer mainLayer;
	LuckyBall_DataManager dataManager;

	public LuckyBall_GameScene() {
		// TODO Auto-generated constructor stub
		dataManager = LuckyBall_DataManager.sharedManager();
		mainLayer = new LuckyBall_GameLayer();
		mainLayer.delegate = this;
		addChild(mainLayer);
	}
	
	public void gotoMenu() {
		CCDirector.sharedDirector().replaceScene(new LuckyBall_MenuScene());
	}

	public void restartGame() {
		if (mainLayer != null) {
			removeChild(mainLayer, true);
		}
		
		CCDirector.sharedDirector().resume();
		
		mainLayer = new LuckyBall_GameLayer();
		mainLayer.delegate = this;
		
		addChild(mainLayer);	
	}
	
	public void effect_Play(int effectPlayerNo) {
	    if (dataManager.volumeInfo == Define.OPTION_OFF)
	        return;

		if (dataManager.effectAudio == true)
		{
			switch (effectPlayerNo) {
				case Define.MENU_SEL:
					Define.playEffect(R.raw.luckyball_menusel);
					break;
				case Define.GLASSIN:
					Define.playEffect(R.raw.luckyball_glassin);
					break;
				case Define.GLASSHIT:
					Define.playEffect(R.raw.luckyball_glasshit);
					break;
				case Define.BALLDOWN:
					Define.playEffect(R.raw.luckyball_ball);
					break;
				default:
					break;
			}
		}
	}
}
