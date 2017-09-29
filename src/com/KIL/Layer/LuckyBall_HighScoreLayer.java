package com.KIL.Layer;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;

import com.KIL.LuckyBall.R;
import com.KIL.Scene.LuckyBall_HighScoreScene;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_HighScoreLayer extends CCLayer {
	public LuckyBall_HighScoreScene delegate;
	CCMenu returnMenu;

	public LuckyBall_HighScoreLayer() {
		// TODO Auto-generated constructor stub
		super();
		LuckyBall_DataManager dataManager = LuckyBall_DataManager.sharedManager();			
		
		CCSprite backSprite = CCSprite.sprite("Image/LuckyBall_HighScores.png");
		Define.setScale(backSprite);
		addChild(backSprite, 0);
		backSprite.setAnchorPoint(0f, 0f);
		backSprite.setPosition(0f, 0f);
		
		CCMenuItemImage ret = CCMenuItemImage.item("Image/btn_highscore_menu.png", "Image/btn_highscore_menu.png", 
				this, "gotoMain");
		Define.setScale(ret);
		ret.setAnchorPoint(0f, 0f);
		
		returnMenu = CCMenu.menu(ret);
		
		returnMenu.setAnchorPoint(0f, 0f);
		returnMenu.setPosition(5 * dataManager.screenWidth / 320, 415 * dataManager.screenHeight / 480);
		
		addChild(returnMenu, 1);	
		
		CCLabel easyScoreLabel = CCLabel.makeLabel(String.format("%d", dataManager.easyScore),
				"Times New Roman", 20f * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(easyScoreLabel);
		easyScoreLabel.setAnchorPoint(1, 0);
		easyScoreLabel.setPosition(265 * dataManager.screenWidth / 320, 292 * dataManager.screenHeight / 480);
		addChild(easyScoreLabel, 1);
		
		CCLabel normalScoreLabel = CCLabel.makeLabel(String.format("%d", dataManager.normalScore), 
				"Times New Roman", 20f * Define.DEFAULT_HEIGHT / 480f);
		Define.setScale(normalScoreLabel);
		normalScoreLabel.setAnchorPoint(1, 0);
		normalScoreLabel.setPosition(265 * dataManager.screenWidth / 320, 268 * dataManager.screenHeight / 480);
		addChild(normalScoreLabel, 1);
		
		CCLabel hardScoreLabel = CCLabel.makeLabel(String.format("%d", dataManager.hardScore), 
				"Times New Roman", 20 * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(hardScoreLabel);
		hardScoreLabel.setAnchorPoint(1, 0);
		hardScoreLabel.setPosition(265 * dataManager.screenWidth / 320, 244 * dataManager.screenHeight / 480);
		addChild(hardScoreLabel, 1);
		
		CCLabel playCountLabel = CCLabel.makeLabel(String.format("%d", dataManager.playCount),
				"Times New Roman", 20 * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(playCountLabel);
		playCountLabel.setAnchorPoint(1, 0);
		playCountLabel.setPosition(265 * dataManager.screenWidth / 320, 194 * dataManager.screenHeight / 480);
		addChild(playCountLabel, 1);
		
		CCLabel glassInLabel = CCLabel.makeLabel(String.format("%d/%d", dataManager.glassIn, dataManager.throwCount), 
				"Times New Roman", 20 * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(glassInLabel);
		glassInLabel.setAnchorPoint(1, 0);
		glassInLabel.setPosition(265 * dataManager.screenWidth / 320, 168 * dataManager.screenHeight / 480);
		addChild(glassInLabel, 1);
		
		CCLabel maxComboLabel = CCLabel.makeLabel(String.format("%d", dataManager.maxCombo), 
				"Times New Roman", 20 * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(maxComboLabel);
		maxComboLabel.setAnchorPoint(1, 0);
		maxComboLabel.setPosition(265 * dataManager.screenWidth / 320, 142 * dataManager.screenHeight / 480);
		addChild(maxComboLabel, 1);
		
		CCLabel maxBounceLabel = CCLabel.makeLabel(String.format("%d", dataManager.maxBounce), 
				"Times New Roman", 20 * Define.DEFAULT_HEIGHT / 480);
		Define.setScale(maxBounceLabel);
		maxBounceLabel.setAnchorPoint(1, 0);
		maxBounceLabel.setPosition(265 * dataManager.screenWidth / 320, 116 * dataManager.screenHeight / 480);
		addChild(maxBounceLabel, 1);
	}
	
	public void gotoMain(Object sender) {
		Define.playEffect(R.raw.luckyball_menusel);
		delegate.gotoMain();
	}
}
