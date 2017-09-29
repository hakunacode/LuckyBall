package com.KIL.Scene;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import com.KIL.Layer.LuckyBall_HelpLayer;
import com.KIL.object.Define;
import com.KIL.LuckyBall.R;

public class LuckyBall_HelpScene extends CCScene {

	public LuckyBall_HelpScene() {
		// TODO Auto-generated constructor stub
		super();
		LuckyBall_HelpLayer helpLayer = new LuckyBall_HelpLayer();
		addChild(helpLayer);
		helpLayer.delegate = this;
	}

	public void gotoMain() {
		Define.playEffect(R.raw.luckyball_menusel);
		CCDirector.sharedDirector().replaceScene(new LuckyBall_MenuScene());
	}
}
