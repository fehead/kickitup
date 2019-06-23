package fehead.im.stage;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Stages {
	private	IStage	curStage;
	private	Map<String, IStage>	stageMap = new HashMap<>();
	
	public Stages(SpriteBatch batch) {
		stageMap.put("title", new TitleStage(batch, this));
		stageMap.put("select", new SelectStage(batch, this));
		stageMap.put("normal", new NormalStage(batch, this));
	}
	
	public void setStage(String stage) {
		if(curStage != null)
			curStage.getOut();
		curStage = stageMap.get(stage);
		curStage.getIn();
	}
	
	public void render() {
		curStage.render();
	}
}
