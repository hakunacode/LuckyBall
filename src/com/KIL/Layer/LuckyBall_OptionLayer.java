package com.KIL.Layer;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import android.view.MotionEvent;

import com.KIL.Scene.LuckyBall_OptionScene;
import com.KIL.object.Define;
import com.KIL.object.LuckyBall_DataManager;

public class LuckyBall_OptionLayer extends CCLayer {
	CCMenu returnMenu;
	public LuckyBall_OptionScene delegate;
	CCSprite backSprite;
	LuckyBall_DataManager dataManager;
	CCSprite volume;
	CCSprite twitter;


	public LuckyBall_OptionLayer() {
		// TODO Auto-generated constructor stub
        isTouchEnabled_ = true;
		dataManager = LuckyBall_DataManager.sharedManager();
		
        backSprite = CCSprite.sprite("Image/LuckyBall_Option.png");
        Define.setScale(backSprite);
		addChild(backSprite, 0);
		backSprite.setAnchorPoint(0f,0f);
		backSprite.setPosition(0f, 0f);
		
		CCMenuItemImage ret = CCMenuItemImage.item("Image/btn_highscore_menu.png", "Image/btn_highscore_menu.png", 
				this, "gotoMain");
		Define.setScale(ret);
        ret.setAnchorPoint(0f, 0f);
		ret.setPosition(5 * dataManager.screenWidth / 320, 415 * dataManager.screenHeight / 480);
		
		CCMenuItemImage restore = CCMenuItemImage.item("Image/btn_option_restore.png", "Image/btn_option_restore.png",
				this, "restore");
		Define.setScale(restore);
        restore.setAnchorPoint(0.5f, 0.5f);
		restore.setPosition(160 * dataManager.screenWidth / 320, 150 * dataManager.screenHeight / 480);
		
		returnMenu = CCMenu.menu(ret, restore);
		
		returnMenu.setPosition(0f, 0f);
		
		addChild(returnMenu, 1);	
        
        setVolume(dataManager.volumeInfo);
        setTwitter(dataManager.twitterInfo);
	}
	
	void setVolume(int volumeInfo) {
	    if (volume != null) {
	        volume.removeFromParentAndCleanup(true);
	    }
	    
	    if (volumeInfo == Define.OPTION_ON) {
	        volume = CCSprite.sprite("Image/btn_option_volume_on.png");
	    } else if (volumeInfo == Define.OPTION_OFF) {
	        volume = CCSprite.sprite("Image/btn_option_volume_off.png");
	    }
	    
	    Define.setScale(volume);
	    volume.setAnchorPoint(0.5f, 0.5f);
	    volume.setPosition(160 * dataManager.screenWidth / 320, 300 * dataManager.screenHeight / 480);
	    addChild(volume, 2);
	    dataManager.saveHighScoreInfo();
	}

	void setTwitter(int volumeInfo) {
	    if (twitter != null) {
	        twitter.removeFromParentAndCleanup(true);
	    }
	    
	    if (volumeInfo == Define.OPTION_ON) {
	        twitter = CCSprite.sprite("Image/btn_option_twitter.png");
	    } else if (volumeInfo == Define.OPTION_OFF) {
	        twitter = CCSprite.sprite("Image/btn_option_twitter_not.png");
	    }
	    
	    Define.setScale(twitter);
	    twitter.setAnchorPoint(0.5f, 0.5f);
	    twitter.setPosition(160 * dataManager.screenWidth / 320, 250 * dataManager.screenHeight / 480);
	    addChild(twitter, 2);
	    dataManager.saveHighScoreInfo();
	}

	public void restore(Object sender) {
	    dataManager.volumeInfo = Define.OPTION_ON;
	    dataManager.twitterInfo = Define.OPTION_OFF;
	    setVolume(dataManager.volumeInfo);
	    setTwitter(dataManager.twitterInfo);
	}

	public void gotoMain(Object sender) {
	    delegate.gotoMain();
	}

	@Override
	public boolean ccTouchesBegan(MotionEvent event) {
		// TODO Auto-generated method stub
		CGPoint touchLocation = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(event.getX(), event.getY()));
		if (CGRect.containsPoint(volume.getBoundingBox(), touchLocation)) {
	        if (dataManager.volumeInfo == Define.OPTION_ON) {
	            dataManager.volumeInfo = Define.OPTION_OFF;
	            setVolume(dataManager.volumeInfo);
	        }
	        else if (dataManager.volumeInfo == Define.OPTION_OFF) {
	            dataManager.volumeInfo = Define.OPTION_ON;
	            setVolume(dataManager.volumeInfo);
	        }

	        return true;
		}
		
		if (CGRect.containsPoint(twitter.getBoundingBox(), touchLocation)) {
	        if (dataManager.twitterInfo == Define.OPTION_ON) {
	            dataManager.twitterInfo = Define.OPTION_OFF;
	            setTwitter(dataManager.twitterInfo);
	        }
	        else if (dataManager.twitterInfo == Define.OPTION_OFF) {
	            dataManager.twitterInfo = Define.OPTION_ON;
	            setTwitter(dataManager.twitterInfo);
	        }
	        
	        return true;
	    }
		
		return super.ccTouchesBegan(event);
	}
}
