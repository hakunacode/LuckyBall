package com.KIL.Layer;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemFont;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import com.KIL.Scene.LuckyBall_MenuScene;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_MenuLayer extends CCLayer {
	CCMenu menu;
	public LuckyBall_MenuScene delegate;
	public LuckyBall_DataManager dataManager;

	public LuckyBall_MenuLayer() {
		dataManager = LuckyBall_DataManager.sharedManager();
		dataManager.screenWidth = CCDirector.sharedDirector().winSize().width;
		dataManager.screenHeight = CCDirector.sharedDirector().winSize().height;
		CCSprite background = CCSprite.sprite("Image/LuckyBall_MenuBack.png");
		Define.setScale(background);
		background.setAnchorPoint(0, 0);
		background.setPosition(0, 0);
		addChild(background);
	}
	
	@Override public void onEnterTransitionDidFinish() {
		// TODO Auto-generated method stub
		super.onEnterTransitionDidFinish();
		CCMenuItemImage start = CCMenuItemImage.item("Image/btn_play_up.png", "Image/btn_play_down.png", this, "restartGame");
		CCMenuItemImage gamecenter = CCMenuItemImage.item("Image/btn_achievement_up.png", "Image/btn_achievement_down.png", this, "gameCenter");
		CCMenuItemImage highscores = CCMenuItemImage.item("Image/btn_highscores_up.png", "Image/btn_highscores_down.png", this, "highScores");
		CCMenuItemImage howtoplay = CCMenuItemImage.item("Image/btn_help_up.png", "Image/btn_help_down.png", this, "about");
		CCMenuItemImage option = CCMenuItemImage.item("Image/btn_option_up.png", "Image/btn_option_down.png", this, "onOption");
		Define.setScale(start);
		Define.setScale(highscores);
		Define.setScale(gamecenter);
		Define.setScale(howtoplay);
		Define.setScale(option);
		//menu = CCMenu.menu(start, highscores, gamecenter, howtoplay, option);
		menu = CCMenu.menu(start, highscores, howtoplay, option);
		menu.setAnchorPoint(0.5f, 0.5f);
		//menu.setPosition(160 * dataManager.screenWidth / 320, 180 * dataManager.screenHeight / 480);
		menu.setPosition(160 * dataManager.screenWidth / 320, 200 * dataManager.screenHeight / 480);
		menu.alignItemsVertically(0.0f);
		this.addChild(menu);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////Selector Methods /////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public void onOption(Object sender) {
		delegate.onOption();
	}
	
	public void about(Object sender) {
		delegate.aboutGame();
	}
	
	public void gameCenter(Object sender) {
		delegate.gameCenter();
	}
	
	public void highScores(Object sender) {
		delegate.highScores();
	}
	
	public void restartGame(Object sender) {
		delegate.startGame();
	}
	
	public CCMenuItemFont getSpacerItem() {
		CCMenuItemFont.setFontSize(2);
		return CCMenuItemFont.item(" ", this, null);
	}
}
