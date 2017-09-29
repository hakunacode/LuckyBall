package com.KIL.Scene;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import com.KIL.Layer.LuckyBall_HighScoreLayer;
import com.KIL.object.Define;
import com.KIL.LuckyBall.R;

public class LuckyBall_HighScoreScene  extends CCScene {
	LuckyBall_HighScoreLayer highScoreLayer;

	public LuckyBall_HighScoreScene() {
		// TODO Auto-generated constructor stub
		super();
		highScoreLayer = new LuckyBall_HighScoreLayer();
		addChild(highScoreLayer);
		highScoreLayer.delegate = this;
	}
		
	public void gotoMain() {
		Define.playEffect(R.raw.luckyball_menusel);
		CCDirector.sharedDirector().replaceScene(new LuckyBall_MenuScene());
	}

}
