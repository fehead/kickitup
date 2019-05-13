package fehead.im.stage;

public interface IStage {
	void gotoPrevStage();
	void gotoNextStage();
	void render();
	
	void getIn();
	void getOut();
}
