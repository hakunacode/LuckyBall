package com.KIL.Layer;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCLabel.TextAlignment;
import org.cocos2d.types.CGSize;

import android.view.MotionEvent;

import com.KIL.Scene.LuckyBall_HelpScene;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_HelpLayer extends CCLayer {
	public LuckyBall_HelpScene delegate;
	CCMenu returnMenu;
	int help_index;
	CCSprite backSprite;
	CCLabel helpLabel;
	LuckyBall_DataManager dataManager;
	String [] helpText = {"1. Please hold the device on one or both hands.",
	    "2. Tilt the device towards the direction you want to throw the ball",
	    "3. After you catch the target, shake the device vertically, and then release your finger to throw the ball.",
	    "4. To get your score, throw the ball in the cup as many times as you can within the limited time."};

	public LuckyBall_HelpLayer() {
		// TODO Auto-generated constructor stub
		super();
		this.isTouchEnabled_ = true;
		
		dataManager = LuckyBall_DataManager.sharedManager();
		help_index = 1;
		
		backSprite = CCSprite.sprite(String.format("Image/LuckyBall_Help%d.png", help_index));
		Define.setScale(backSprite);
		addChild(backSprite, 0);
		backSprite.setAnchorPoint(0f, 0f);
		backSprite.setPosition(0f, 0f);
		
		CCMenuItemImage ret = CCMenuItemImage.item("Image/btn_highscore_menu.png", 
				"Image/btn_highscore_menu.png", this, "gotoMain");
		Define.setScale(ret);
		ret.setAnchorPoint(0f, 0f);
		returnMenu = CCMenu.menu(ret);
		
		returnMenu.setAnchorPoint(0f, 0f);
		returnMenu.setPosition(5f * dataManager.screenWidth / 320f, 415f * dataManager.screenHeight / 480f);
		
		addChild(returnMenu, 1);
		helpLabel = CCLabel.makeLabel(helpText[0], 
				CGSize.make(250f * Define.DEFAULT_WIDTH / 320.0f, 500f * Define.DEFAULT_HEIGHT / 480.0f),
				TextAlignment.LEFT,
				"Georgia", 
				20f * Define.DEFAULT_HEIGHT / 480f);
		Define.setScale(helpLabel);
		helpLabel.setAnchorPoint(0f, 1f);
		helpLabel.setPosition(35f * dataManager.screenWidth / 320.0f, 155f * dataManager.screenHeight / 480f);
		addChild(helpLabel, 1);
	}
	
	public void gotoMain(Object sender) {
		delegate.gotoMain();
	}
	
	@Override
	public boolean ccTouchesBegan(MotionEvent event) {
		// TODO Auto-generated method stub
		backSprite.removeFromParentAndCleanup(true);
		help_index++;
		if (help_index > 4)
			help_index = 1;
		
		backSprite = CCSprite.sprite(String.format("Image/LuckyBall_Help%d.png", help_index));
		Define.setScale(backSprite);
		addChild(backSprite, 0);
		backSprite.setAnchorPoint(0f, 0f);
		backSprite.setPosition(0f, 0f);
		
	    if (help_index > 2) {
	        helpLabel.setPosition(35f * dataManager.screenWidth / 320f, 185f * dataManager.screenHeight / 480f);
	    } else {
	        helpLabel.setPosition(35f * dataManager.screenWidth / 320f, 155f * dataManager.screenHeight / 480f);
	    }
	    helpLabel.setString(helpText[help_index - 1]);
	    
	    return super.ccTouchesBegan(event);
	}
}
