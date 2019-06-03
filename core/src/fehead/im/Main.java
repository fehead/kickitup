package fehead.im;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;

import fehead.im.song.Song;

public class Main {
	////////////////////////////////////////////////////////
	// 임의로 만들어낸 변수
	private static final int DDBLTFAST_SRCCOLORKEY = 0;
	private static final int DDBLTFAST_NOCOLORKEY = 1;
	private static final int DDFLIP_WAIT = 3;
	private static final int DDBLT_WAIT = 4;
	private static final int DDBLTFAST_WAIT = 5;
	private static final int DDBLT_KEYSRC = 6;
	private static final int DSSCL_NORMAL = 7;
	private static final int WM_CLOSE = 8;
	private static final int MB_OK = 9;
	private static final int CS_HREDRAW = 10;
	private static final int CS_VREDRAW = 11;
	private static final int WM_MOVE = 12;
	private static final int WM_ACTIVATEAPP = 13;
	private static final int VK_F12 = 14;
	private static final int VK_F2 = 15;
	private static final int VK_UP = 16;
	private static final int VK_DOWN = 17;
	private static final int VK_LEFT = 18;
	private static final int VK_RIGHT = 19;
	private static final int VK_RETURN = 20;
	private static final int VK_ESCAPE = 21;
	private static final int WM_DESTROY = 22;
	private static final int WM_SETCURSOR = 23;
	private static final int WM_KEYDOWN = 24;
	private static final int IDI_ICON = 25;
	private static final int IDC_ARROW = 26;
	private static final long WS_EX_APPWINDOW = 27;
	private static final long WS_POPUP = 28;
	private static final long WS_EX_WINDOWEDGE = 29;
	private static final long WS_CAPTION = 30;
	private static final long WS_SYSMENU = 31;
	private static final int DDSCL_EXCLUSIVE = 32;
	private static final int DDSCL_FULLSCREEN = 33;
	private static final int DDSCL_ALLOWREBOOT = 34;
	private static final int DDSCL_NORMAL = 35;
	private static final int CLR_INVALID = 36;
	private static final int IDB_ARROW1 = 37;
	private static final int IDB_ARROW2 = 38;
	private static final int ID_ARROW = 39;
	private static final int IDB_PARROW1 = 40;
	private static final String IDB_PARROW3 = null;
	private static final String IDB_PARROW5 = null;
	private static final String IDB_PARROW7 = null;
	private static final String IDB_PARROW9 = null;
	private static final String IDB_CARROW1 = null;
	private static final String IDB_CARROW3 = null;
	private static final String IDB_CARROW5 = null;
	private static final String IDB_CARROW7 = null;
	private static final String IDB_CARROW9 = null;
	private static final int PM_NOREMOVE = 41;
	private static final int DDLOCK_WAIT = 42;

	////////////////////////////////////////////////////////

	static Random generator = new Random();
	static private int rand() {
		return generator.nextInt();
	}

	static final	int	NORMAL		=	0;
	static final	int	PRESS		=	1;

	static final	int	GAMETITLE	=	0;
	static final	int	MODESELECT	=	1;
	static final	int	SELECTSONG	=	2;
	static final	int	STAGE1		=	3;
	static final	int	DOUBLE		=	4;
	static final	int	COUPLE		=	5;
	static final	int	DEAD		=	6;
	static final	int	CONFIG		=	7;
	static final	int	RESULT		=	8;
	static final	int	GAMEOVER	=	9;

	static final	int	MODE_EASY	=	0;
	static final	int	MODE_HARD	=	1;
	static final	int	MODE_DOUBLE	=	2;
	static final	int	MODE_CRAZY	=	3;
	static final	int	MODE_REMIX	=	4;

	static final	int	END			=	99;

	static final	int	MAX_DATA	=	2048;

	static final	int	NONE		=	0;
	static final	int	PERFECT		=	1;
	static final	int	GREAT		=	2;
	static final	int	GOOD		=	3;
	static final	int	BAD			=	4;
	static final	int	MISS		=	5;

	static final	int	ARROW_X		=	50;

	static final	int	PUMP_SPRITE	=	50;
	static final	int	PUMP_SPRITE_Y	=	55;
	static final	int	PUMP_SPRITE_NEW	=	60;

	static final	int	LP1_X		=	30;
	static final	int	LP7_X		=	30+PUMP_SPRITE;
	static final	int	LP5_X		=	32+PUMP_SPRITE*2;
	static final	int	LP9_X		=	35+PUMP_SPRITE*3;
	static final	int	LP3_X		=	35+PUMP_SPRITE*4;

	static final	int	LP1_X1		=	350;
	static final	int	LP7_X1		=	350+PUMP_SPRITE;
	static final	int	LP5_X1		=	352+PUMP_SPRITE*2;
	static final	int	LP9_X1		=	355+PUMP_SPRITE*3;
	static final	int	LP3_X1		=	355+PUMP_SPRITE*4;
	static final	int	JUDGE_SIZE_X	=	250;
	static final	int	JUDGE_SIZE_Y	=	50;

	static final	String	VER_NUM	= "0.4b";
	static final	String	PRGNAME = "Kick It UP!";

	static final	int	MAX_PATH = 255;

	static private String	TITLE;


	// 일반 하드 데이터 부분
	static private char [][] 			Data	= new char[MAX_DATA+1][14];
	static private char [][]			Data_Judge	= new char[MAX_DATA+1][14];
	static private double []			Data_y = new double[MAX_DATA+1];

	static private char [][]			Data1	= new char[MAX_DATA+1][14];
	static private char [][]			Data_Judge1	= new char[MAX_DATA+1][14];
	static private double []			Data_y1 = new double[MAX_DATA+1];
	// 여기까지

	// 더블 데이터 시작
	static private char [][]			Data_Double	= new char[MAX_DATA+1][14];
	static private char [][]			Data_Double_Judge	= new char[MAX_DATA+1][14];
	static private double []			Data_Double_y = new double[MAX_DATA+1];//족보 데이터의 Y값을 가지고 있는 배열
	// 더블 데이터 끝


	static private char []				SongName	= new char[MAX_PATH+1];
	static private char []				SongName2	= new char[MAX_PATH+1];
	static private char []				SongName3	= new char[MAX_PATH+1];

	static private char []				LogoTitleName	= new char[MAX_PATH];

	static private double				bpm;
	static private double				bpm2;
	static private double				bpm3;

	static private int					start,start2,start3;
	static private long				bunki,bunki2;

	static private int					tick;

	static private char []				Title	= new char[MAX_PATH+1];

	static private int					g_programState=GAMETITLE;
	static private char []				ArrowState1p	= new char[10];
	static private char []				ArrowState2p	= new char[10];

	static private char []				ArrowState_Joy	= new char[10];

	static private long []				PressedKey1p = new long[10];
	static private long []				PressedKey2p = new long[10];
	static private long []				PressedKey_Joy = new long[10];

	static private char				Judgement1p;
	static private char				Judgement2p;
	static private long				Combo1p;
	static private long				Combo2p;
	static private long				dwState;
	static private long				dwState2;
	static private boolean				g_bActive;

	static private long				Score1p;
	static private long				Score2p;

	static private int					Gauge1p=10;
	static private int					Gauge2p=10;

	static private char				GameMode=MODE_HARD;

	static private boolean				Couple=false;
	static private boolean				Double=false;

	static private char				First;
	static private int 				start1;

	static private boolean				Start1p;
	static private boolean				Start2p;

	static private HWND hWnd;
	static private HINSTANCE	g_hInst;

	static private LPDIRECTDRAW g_pDD                = null;
	static private LPDIRECTDRAWSURFACE	g_pDDSPrimary = null;
	static public	LPDIRECTDRAWSURFACE g_pDDSBack    = null;

	static private LPDIRECTDRAWSURFACE	GameTITLE		= null;
	static private LPDIRECTDRAWSURFACE	background		= null;
	static private LPDIRECTDRAWSURFACE	songTitle 		= null;
	static private LPDIRECTDRAWSURFACE	songBack 		= null;
	static private LPDIRECTDRAWSURFACE	SelectBack		= null;
	static private LPDIRECTDRAWSURFACE	JudgeFont		= null;
	static private LPDIRECTDRAWSURFACE	NumberFont		= null;
	static private LPDIRECTDRAWSURFACE	ComboFont		= null;
	static private LPDIRECTDRAWSURFACE NoDISC			= null;
	static private LPDIRECTDRAWSURFACE	ShiftLeft		= null;
	static private LPDIRECTDRAWSURFACE	ShiftRight		= null;
	static private LPDIRECTDRAWSURFACE	GaugeWaku		= null;
	static private LPDIRECTDRAWSURFACE Gauge			= null;
	static private LPDIRECTDRAWSURFACE Score			= null;
	static private LPDIRECTDRAWSURFACE DeadScreen		= null;
	static private LPDIRECTDRAWSURFACE GameOver		= null;
	static private LPDIRECTDRAWSURFACE Logo			= null;
	static private LPDIRECTDRAWSURFACE	Diff			= null;
	static private LPDIRECTDRAWSURFACE	DoubleIcon		= null;
	static private LPDIRECTDRAWSURFACE	CrazyIcon		= null;
	static private LPDIRECTDRAWSURFACE	EasyIcon		= null;
	static private LPDIRECTDRAWSURFACE	HardIcon		= null;

	static private LPDIRECTDRAWSURFACE	SmallFont		= null;
	static private LPDIRECTDRAWSURFACE	Arrow1			= null;
	static private LPDIRECTDRAWSURFACE	Arrow2			= null;
	static private LPDIRECTDRAWSURFACE	wArrow			= null;

	static private LPDIRECTDRAWSURFACE	pArrow1			= null;
	static private LPDIRECTDRAWSURFACE	pArrow3			= null;
	static private LPDIRECTDRAWSURFACE	pArrow5			= null;
	static private LPDIRECTDRAWSURFACE	pArrow7			= null;
	static private LPDIRECTDRAWSURFACE	pArrow9			= null;

	static private LPDIRECTDRAWSURFACE	cArrow1			= null;
	static private LPDIRECTDRAWSURFACE	cArrow3			= null;
	static private LPDIRECTDRAWSURFACE	cArrow5			= null;
	static private LPDIRECTDRAWSURFACE	cArrow7			= null;
	static private LPDIRECTDRAWSURFACE	cArrow9			= null;

	static private LPDIRECTDRAWSURFACE	ModeIcon		= null;
	static private LPDIRECTDRAWSURFACE	g_cFont			= null;

	static private LPDIRECTDRAWSURFACE	ResultFont		= null;
	static private LPDIRECTDRAWSURFACE	ResultBack		= null;
	static private LPDIRECTDRAWSURFACE	StageCount		= null;

	static private LPDIRECTSOUND		lpds			= null;
	static private LPDIRECTSOUNDBUFFER	lpdsbd			= null;

	static private LPDIRECTSOUNDBUFFER				g_dsOpening	= null;
	static private LPDIRECTSOUNDBUFFER				g_dsDead		= null;
	static private LPDIRECTSOUNDBUFFER				g_dsMode		= null;
	static private LPDIRECTSOUNDBUFFER				g_dsCancel		= null;
	static private LPDIRECTSOUNDBUFFER				g_dsMove		= null;
	static private LPDIRECTSOUNDBUFFER				g_dsBeat		= null;
	static private LPDIRECTSOUNDBUFFER				g_dsSelectSong	= null;

	static private Song []				CSONG = new Song[512];

	static private boolean	SongFlag;
	static private boolean	IntroFlag;

	static private int		HighSpeed1p=1;
	static private int		HighSpeed2p=1;

	static private int		HighSpeed1p_1;
	static private int		HighSpeed1p_3;
	static private int		HighSpeed1p_5;
	static private int		HighSpeed1p_7;
	static private int		HighSpeed1p_9;

	static private int		HighSpeed2p_1;
	static private int		HighSpeed2p_3;
	static private int		HighSpeed2p_5;
	static private int		HighSpeed2p_7;
	static private int		HighSpeed2p_9;

	static private int		MaxSpeed;
	static private int		MinSpeed;

	static private int[] 	JudgeArray = new int[110];

	static private boolean	bModeMirror1p;
	static private boolean	bModeNonstep1p;
	static private boolean	bModeSynchro;
	static private boolean	bModeUnion1p;
	static private boolean	bModeRandom1p;
	static private boolean	b4dMix1p;			// 1p 4DMIX mode.
	static private boolean	bModeVanish1p;
	static private boolean	bModeCrazy1p;
	static private boolean	bModeSuddenR1p;
	static private boolean	bModeRandomS1p;

	static private boolean	bModeMirror2p;
	static private boolean	bModeNonstep2p;
	static private boolean	bModeUnion2p;
	static private boolean	bModeRandom2p;
	static private boolean	b4dMix2p;
	static private boolean	bModeVanish2p;
	static private boolean	bModeCrazy2p;
	static private boolean	bModeSuddenR2p;
	static private boolean	bModeRandomS2p;

	static private int	ALPHA=0;
	static private int	inc=20;
	static private long	CKey_CFont;
	static private long	CKey_Arr;

	static private long	cPerfect1p;
	static private long	cGreat1p;
	static private long	cGood1p;
	static private long	cBad1p;
	static private long	cMiss1p;
	static private long	cMaxCombo1p;

	static private long	cPerfect2p;
	static private long	cGreat2p;
	static private long	cGood2p;
	static private long	cBad2p;
	static private long	cMiss2p;
	static private long	cMaxCombo2p;

	// Data of configuration
	static private KIUConfig	KCFG;

	static private long		dwGameCount;

	static private boolean debugflag=true;
	static private char [] g_szDebugName = new char[MAX_PATH];

	static private boolean	g_fullscreen=false;

	static private RECT                    g_rcViewport;           // Pos. & size to blt from
	static private RECT                    g_rcScreen;             // Screen pos. for blt


	static private void	DebugPrintf(String fmt, Object... args) {
		Gdx.app.log("", String.format(fmt, args));
	}

	static private void	JudgementSet()	{
		int i;

		for(i=50;i<110;i++) JudgeArray[i] = BAD;
		for(i=57;i<104;i++) JudgeArray[i] = GOOD;
		for(i=64;i<96;i++)	JudgeArray[i] = GREAT;
		for(i=73;i<88;i++)	JudgeArray[i] = PERFECT;
	}

	static private void	DisplayStageCount(long Count) {
		RECT	sssRect = new RECT();

		sssRect.top=0;
		sssRect.left=Count*80;
		sssRect.right=sssRect.left+80;
		sssRect.bottom=46;

		g_pDDSBack.BltFast(280, 0, StageCount, sssRect, DDBLTFAST_SRCCOLORKEY);
	}


	static private void ClearMode() {
			HighSpeed1p=1;
			bModeMirror1p=false;
			bModeNonstep1p=false;
			bModeSynchro=false;
			bModeUnion1p=false;
			bModeRandom1p=false;
			b4dMix1p=false;
			HighSpeed1p_1=1;
			HighSpeed1p_3=1;
			HighSpeed1p_5=1;
			HighSpeed1p_7=1;
			HighSpeed1p_9=1;
			bModeVanish1p=false;
			bModeRandomS1p=false;
			bModeSuddenR1p=false;

			HighSpeed2p=1;
			bModeMirror2p=false;
			bModeNonstep2p=false;
			bModeUnion2p=false;
			bModeRandom2p=false;
			b4dMix2p=false;
			HighSpeed2p_1=1;
			HighSpeed2p_3=1;
			HighSpeed2p_5=1;
			HighSpeed2p_7=1;
			HighSpeed2p_9=1;
			bModeVanish2p=false;
			Double=false;
			bModeRandomS2p=false;
			bModeSuddenR2p=false;
	}


	static private int GameOver1_count = 0;
	static private void	GameOver1()	{
		if(First==0) {
			GameOver1_count=0;
			First++;
		}
		GameOver1_count++;
		g_pDDSBack.BltFast(0,0, GameOver, null, DDBLTFAST_NOCOLORKEY);
		if(GameOver1_count==60){
			First=0;
			g_programState=GAMETITLE;
		}
		Flipp();
	}

	// void DrawBackground(char[][14] Data, long i, int temp)
	static private void DrawBackground(char[][] Data, long i, int temp)	{
		g_pDDSBack.BltFast(0,0,songBack,null, DDBLTFAST_WAIT | DDBLTFAST_NOCOLORKEY);
	}

	static private void DrawScore1p() {
		RECT	cRect = new RECT();
		int Loop;

		char [] chScore = String.format("%07d",Score1p).toCharArray();
		for(Loop=0;;Loop++)	{
			if(chScore[Loop] == 0)
				break;
			chScore[Loop]-=48;
			cRect.left=chScore[Loop]*22;
			cRect.right=cRect.left+21;
			cRect.top=0;
			cRect.bottom=35;
			g_pDDSBack.BltFast(20+Loop*22,444,Score, cRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}/* 여기까지 */
	}

	static private void DrawScore2p()	{
		RECT	cRect = new RECT();
		int Loop;

		char [] chScore = String.format("%07d",Score2p).toCharArray();

		for(Loop=0;;Loop++)	{
			if(chScore[Loop] == 0)break;
			chScore[Loop]-=48;
			cRect.left=chScore[Loop]*22;
			cRect.right=cRect.left+21;
			cRect.top=0;
			cRect.bottom=35;
			g_pDDSBack.BltFast(463+Loop*22,444,Score,cRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}/* 여기까지 */
	}

	static private void DrawGauge1p() {
		int CurG;
		int i;
//		static	int	Phase;

		RECT sRect = new RECT();

		CurG=Gauge1p;

		if(CurG<0)CurG=0;

		g_pDDSBack.BltFast(32,0,GaugeWaku,null, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

	/*	if(Phase==1)
		{
			Phase=0;
			return;
		}
		else Phase++;*/

		sRect.top=0;
		sRect.left=0;
		sRect.right=6;
		sRect.bottom=20;

		for(i=0;i<7;i++)
		{
			if(i>CurG)break;
			g_pDDSBack.BltFast(280-(i*6),20,Gauge,sRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}

		sRect.top=0;
		sRect.left=6;
		sRect.right=12;
		sRect.bottom=20;

		for(i=7;i<21;i++)
		{
			if(i>CurG)break;
			g_pDDSBack.BltFast(280-(i*6),20,Gauge,sRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}

		sRect.top=0;
		sRect.left=12;
		sRect.right=18;
		sRect.bottom=20;

		for(i=21;i<42;i++) {
			if(i>CurG)break;
			g_pDDSBack.BltFast(280-(i*6),20,Gauge,sRect,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}
	}

	static private void DrawGauge2p() {
		int CurG;
		int i;
		RECT sRect = new RECT();
//		static	int	Phase;

		CurG=Gauge2p;

		if(CurG<0)CurG=0;

		g_pDDSBack.BltFast(352,0,GaugeWaku,null,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

	/*	if(Phase==1)
		{
			Phase=0;
			return;
		}
		else Phase++;*/

		sRect.top=0;
		sRect.left=0;
		sRect.right=6;
		sRect.bottom=20;

		for(i=0;i<7;i++)
		{
			if(i>CurG)break;
			g_pDDSBack.BltFast(352+(i*6),20,Gauge,sRect,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}

		sRect.top=0;
		sRect.left=6;
		sRect.right=12;
		sRect.bottom=20;

		for(i=7;i<21;i++)
		{
			if(i>CurG)break;
			g_pDDSBack.BltFast(352+(i*6),20,Gauge,sRect,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}

		sRect.top=0;
		sRect.left=12;
		sRect.right=18;
		sRect.bottom=20;

		for(i=21;i<42;i++)
		{
			if(i>CurG)break;
			g_pDDSBack.BltFast(352+(i*6),20,Gauge,sRect,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		}
	}

	static private void WaveSet_Loading() {
		g_dsOpening=DSLoadSoundBuffer(lpds, "wave\\Opening.wav");
		g_dsDead=DSLoadSoundBuffer(lpds,"wave\\Dead.wav");
		g_dsMode=DSLoadSoundBuffer(lpds,"wave\\Mode.wav");
		g_dsCancel=DSLoadSoundBuffer(lpds,"wave\\Cancel.wav");
		g_dsMove=DSLoadSoundBuffer(lpds,"wave\\Move.wav");
		g_dsBeat=DSLoadSoundBuffer(lpds,"wave\\Beat.wav");
		g_dsSelectSong=DSLoadSoundBuffer(lpds, "wave\\MusicSelect.wav");
	}

	static private void DisplayMessage(int x, int y, String msg) {
		final int FONT_SIZE	= 8;
		final int FONT_HEIGHT = 16;

		RECT sRect = new RECT();

		char [] message = msg.toCharArray();
		for(int i = 0 ; ; i++) {
			if(message[i] == 0)
				break;

			char msg1 = Character.toUpperCase(message[i]);

			sRect.top = 0;
			sRect.bottom = FONT_HEIGHT;
			sRect.left = FONT_SIZE * (msg1-' ');
			sRect.right = sRect.left + FONT_SIZE;

			g_pDDSBack.BltFast(x, y, SmallFont, sRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
			x += FONT_SIZE;
		}
	}

	// static RECT sRect = new RECT();
	static private RECT ClpBlt_sRect;
	static private HRESULT	ClpBlt(int x ,int y ,LPDIRECTDRAWSURFACE ds,RECT srect,int mode){
		HRESULT	hRet = HRESULT.DD_OK;
		ClpBlt_sRect = new RECT(srect);

		if(x>640 || y>480)
			return HRESULT.DD_OK;

		if(y+(srect.bottom-srect.top)>480)
			srect.bottom = srect.bottom-(y+(srect.bottom-srect.top)-480);
		if(y<0) {
			srect.top-=y;
			y=0;
		}

		if(x+(srect.right-srect.left)>640)
			srect.right=srect.right-(x+(srect.right-srect.left)-640);
		if(x<0)	{
			srect.left-=x;
			x=0;
		}

		if(g_programState==DOUBLE) {
			if(bModeVanish1p || bModeVanish2p) {
				if(y<150) {
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				if(y<250)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-150)*2,CKey_Arr,16);
				if(y>250)
					hRet= g_pDDSBack.BltFast(x,y,ds,srect,mode);
			} else if(bModeSuddenR1p || bModeSuddenR2p)	{
				if(y<=100)
					hRet = g_pDDSBack.BltFast(x,y,ds,srect,mode);
				else if(y>100 && y<=200)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(200-y)*2,CKey_Arr,16);
				else if(y>200 && y<320)	{
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				else if(y<420)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-320)*2,CKey_Arr,16);
				else if(y>420)
					hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
			}
			else
				hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
		} else if(x<320) {
			if(bModeVanish1p) {
				if(y<150) {
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				if(y<250)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-150)*2,CKey_Arr,16);
				if(y>250)
					hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
			} else if(bModeSuddenR1p) {
				if(y<=100)hRet = g_pDDSBack.BltFast(x,y,ds,srect,mode);
				else if(y>100 && y<=200)TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(200-y)*2,CKey_Arr,16);
				else if(y>200 && y<320)	{
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				else if(y<420)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-320)*2,CKey_Arr,16);
				else if(y>420)
					hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
			}
			else
				hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
		} else if(x>320) {
			if(bModeVanish2p) {
				if(y<150) {
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				if(y<250)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-150)*2,CKey_Arr,16);
				if(y>250)
					hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
			}
			else if(bModeSuddenR2p)
			{
				if(y<=100)
					hRet = g_pDDSBack.BltFast(x,y,ds,srect,mode);
				else if(y>100 && y<=200)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(200-y)*2,CKey_Arr,16);
				else if(y>200 && y<320)	{
					srect = new RECT(ClpBlt_sRect);
					return HRESULT.DD_OK;
				}
				else if(y<420)
					TransAlphaImproved(ds,g_pDDSBack,x,y,ClpBlt_sRect,(y-320)*2,CKey_Arr,16);
				else if(y>420)
					hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
			} else
				hRet=g_pDDSBack.BltFast(x,y,ds,srect,mode);
		}

		srect = new RECT(ClpBlt_sRect);
		return hRet;
	}

	static private void StageTitle() {
		RECT	lRect = new RECT();
		if(First==0) {
			ClearMode();

			Start1p=false;
			Start2p=false;
			First++;
			if(g_dsOpening != null)
				g_dsOpening.Play(0,0,0);
		}

		ReadGameInput();

		if(PressedKey1p[5] == 1)
			Start1p=true;

		if(PressedKey2p[5]==1)
			Start2p=true;

		// Draw background image. "KICK IT UP"
		g_pDDSBack.BltFast(0,0,GameTITLE, null, DDBLTFAST_WAIT | DDBLTFAST_NOCOLORKEY);

		// Check Start.
		if(Start1p || Start2p) {
			if(Start1p && Start2p) {
				PressedKey2p[0]=3;
			} else if(Start1p) {
				if(PressedKey1p[5]==1)
					PressedKey2p[0]=3;
			} else if(Start2p) {
				if(PressedKey2p[5]==1)
					PressedKey2p[0]=3;
			}
		}

		// if start button is pressed.
		if(PressedKey2p[0]==3)
		{
			Couple = Start1p && Start2p;

			First=0;
			if(g_dsOpening != null)
				g_dsOpening.Stop();
			PressedKey2p[0]=0;

			// Change ProgramState to SelectSong Stage
			g_programState=SELECTSONG;
		}

		// Draw to screen "FREE PLAY!"
		lRect.top=46;
		lRect.left=0;
		lRect.right=220;
		lRect.bottom=69;

		g_pDDSBack.BltFast(210,450,g_cFont, lRect, DDBLTFAST_SRCCOLORKEY);

		if(Start1p==false)
		{
			// Draw to screen (10, 450) "PRESS CENTER BUTTON"
			lRect.top=0;
			lRect.left=0;
			lRect.right=220;
			lRect.bottom=23;

			TransAlphaImproved(g_cFont, g_pDDSBack, 10, 450, lRect, ALPHA, CKey_CFont, 16);
		}
		if(Start2p==false)//DisplayMessage(320,480-20,"PRESS CENTER STEP");
		{
			// Draw to screen (410, 450) "PRESS CENTER BUTTON"
			lRect.top=0;
			lRect.left=0;
			lRect.right=220;
			lRect.bottom=23;

			TransAlphaImproved(g_cFont, g_pDDSBack, 410, 450, lRect, ALPHA, CKey_CFont, 16);
		}

		ALPHA += inc;
		if (ALPHA > 256)
		{
			ALPHA = 256;
			inc = -20;
		}
		else if (ALPHA < 0)
		{
			ALPHA = 0;
			inc = 20;
		}

		Flipp();

	}


	// DrawJudge1p
	static private char DrawJudge1p_LastJudge;
	static private long DrawJudge1p_sec,DrawJudge1p_delta;
	static private void DrawJudge1p()
	{
		/*
		 * 	static long cur, last;
		 *  static char LastJudge;
		 *  static long sec,delta;
		 */
		char [] chCombo1p = new char[255];

		RECT rRect = new RECT(), cRect = new RECT(), destRect = new RECT();
		int Loop;

		if(Judgement1p != 0) {
			dwState=0;
		} else if(dwState != 0)	{
			Judgement1p=DrawJudge1p_LastJudge;

			DrawJudge1p_delta=timeGetTime()-DrawJudge1p_sec;
			if(DrawJudge1p_delta>16) {
				DrawJudge1p_sec=timeGetTime();
				if(dwState>=40) {
					dwState=0;
					Judgement1p=NONE;
				} else {
					if(DrawJudge1p_delta >16 && DrawJudge1p_delta <32)
						dwState+=2;
					else if(DrawJudge1p_delta >=32)
						dwState+=4;
				}
			}
		}

		switch(Judgement1p) {
			case NONE:DrawJudge1p_LastJudge=NONE;
				break;
			case PERFECT:
				DrawJudge1p_LastJudge=PERFECT;
				rRect.top=0;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y;
				if(dwState==0)dwState++;
				break;
			case GREAT:
				DrawJudge1p_LastJudge=GREAT;
				rRect.top=JUDGE_SIZE_Y;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*2;
				if(dwState==0)dwState++;
				break;
			case GOOD:
				DrawJudge1p_LastJudge=GOOD;
				rRect.top=JUDGE_SIZE_Y*2;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*3;
				if(dwState==0)dwState++;
				break;
			case BAD:
				DrawJudge1p_LastJudge=BAD;
				rRect.top=JUDGE_SIZE_Y*3;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*4;
				if(dwState==0)dwState++;
				break;
			case MISS:
				DrawJudge1p_LastJudge=MISS;
				rRect.top=JUDGE_SIZE_Y*4;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*5;
				if(dwState==0)dwState++;
				break;
		}

		if(dwState>15)
		{
			destRect.top=200;
			destRect.left=40;
			destRect.right=40+JUDGE_SIZE_X;
			destRect.bottom=200+JUDGE_SIZE_Y;
		}
		else
		{
			destRect.top=200-30+(dwState*2);
			destRect.left=40-60+(dwState*4);
			destRect.right=40+JUDGE_SIZE_X+60-(dwState*4);
			destRect.bottom=200+JUDGE_SIZE_Y+30-(dwState*2);
		}

		if(Judgement1p != 0) {
			//g_pDDSBack.BltFast(40,200+dwState/2,JudgeFont,&rRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

			g_pDDSBack.Blt(destRect, JudgeFont, rRect,DDBLT_WAIT | DDBLT_KEYSRC , null);

			/* 콤보 출력부 입니다. */
			if((Judgement1p==PERFECT || Judgement1p==GREAT) && Combo1p>3) {
				chCombo1p = String.format("%03d",Combo1p).toCharArray();
				for(Loop=0;;Loop++) {
					if(chCombo1p[Loop]==0)
						break;
					chCombo1p[Loop]-=48;
					cRect.left=chCombo1p[Loop]*50;
					cRect.right=cRect.left+50;
					cRect.top=0;
					cRect.bottom=65;
					if(dwState>10)
						g_pDDSBack.BltFast(80+Loop*50,250+dwState*2-dwState*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);
					else
						g_pDDSBack.BltFast(80+Loop*50,250+dwState*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);

					cRect.left=0;
					cRect.right=150;
					cRect.top=65;
					cRect.bottom=100;

					if(dwState>10)
						g_pDDSBack.BltFast(80,320+dwState*2-dwState*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);
					else
						g_pDDSBack.BltFast(80,320+dwState*2,ComboFont, cRect, DDBLTFAST_SRCCOLORKEY);
				}/* 여기까지 */
			}
		}

		Judgement1p=NONE;
	}

	static private char DrawJudge2p_LastJudge;
	static private long DrawJudge2p_sec,DrawJudge2p_delta;
	static private void DrawJudge2p() {
		//		static long cur, last;
		//		static char LastJudge;
		//		static long sec,delta;

		char [] chCombo2p = new char[255];

		RECT rRect = new RECT(), cRect = new RECT(), destRect = new RECT();
		int Loop;

		if(Judgement2p != 0) {
			dwState2=0;
		} else if(dwState2 != 0) {
			Judgement2p=DrawJudge2p_LastJudge;

			DrawJudge2p_delta=timeGetTime()-DrawJudge2p_sec;

			if(DrawJudge2p_delta>16) {
				DrawJudge2p_sec=timeGetTime();
				if(dwState2>=40) {
					dwState2=0;
					Judgement2p=NONE;
				} else {
					if(DrawJudge2p_delta >16 && DrawJudge2p_delta <32)dwState2+=2;
					else if(DrawJudge2p_delta >=32)dwState2+=4;
				}
			}
		}

		switch(Judgement2p){
			case NONE:DrawJudge2p_LastJudge=NONE;
				break;
			case PERFECT:
				DrawJudge2p_LastJudge=PERFECT;
				rRect.top=0;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y;
				if(dwState2==0)dwState2++;
				break;
			case GREAT:
				DrawJudge2p_LastJudge=GREAT;
				rRect.top=JUDGE_SIZE_Y;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*2;
				if(dwState2==0)dwState2++;
				break;
			case GOOD:
				DrawJudge2p_LastJudge=GOOD;
				rRect.top=JUDGE_SIZE_Y*2;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*3;
				if(dwState2==0)dwState2++;
				break;
			case BAD:
				DrawJudge2p_LastJudge=BAD;
				rRect.top=JUDGE_SIZE_Y*3;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*4;
				if(dwState2==0)dwState2++;
				break;
			case MISS:
				DrawJudge2p_LastJudge=MISS;
				rRect.top=JUDGE_SIZE_Y*4;
				rRect.right=JUDGE_SIZE_X;
				rRect.left=0;
				rRect.bottom=JUDGE_SIZE_Y*5;
				if(dwState2==0)dwState2++;
				break;
		}

		if(dwState2>15)
		{
			destRect.top=200;
			destRect.left=350;
			destRect.right=350+JUDGE_SIZE_X;
			destRect.bottom=200+JUDGE_SIZE_Y;
		}
		else
		{
			destRect.top=200-30+(dwState2*2);
			destRect.left=350-60+(dwState2*4);
			destRect.right=350+JUDGE_SIZE_X+60-(dwState2*4);
			destRect.bottom=200+JUDGE_SIZE_Y+30-(dwState2*2);
		}

		if(Judgement2p != 0) {
//			g_pDDSBack.BltFast(400,200+dwState22/2,JudgeFont,&rRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

			g_pDDSBack.Blt(destRect, JudgeFont, rRect,DDBLT_WAIT | DDBLT_KEYSRC , null);

			/* 콤보 출력부 입니다. */
			if((Judgement2p==PERFECT || Judgement2p==GREAT) && Combo2p>3)
			{
				chCombo2p = String.format("%03d",Combo2p).toCharArray();

				for(Loop=0;;Loop++)	{
					if(chCombo2p[Loop]==0)break;
					chCombo2p[Loop]-=48;
					cRect.left=chCombo2p[Loop]*50;
					cRect.right=cRect.left+50;
					cRect.top=0;
					cRect.bottom=65;
//					g_pDDSBack.BltFast(380+Loop*30+dwState22*2,250,NumberFont,&cRect, DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
					if(dwState2>10)
						g_pDDSBack.BltFast(400+Loop*50,250+dwState2*2-dwState2*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);
					else
						g_pDDSBack.BltFast(400+Loop*50,250+dwState2*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);

					cRect.left=0;
					cRect.right=150;
					cRect.top=65;
					cRect.bottom=100;

					if(dwState2>10)
						g_pDDSBack.BltFast(400,320+dwState2*2-dwState2*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);
					else
						g_pDDSBack.BltFast(400,320+dwState2*2,ComboFont,cRect, DDBLTFAST_SRCCOLORKEY);
				}/* 여기까지 */
			}
		}

		Judgement2p=NONE;
	}



	static private int [] DrawArrow1p_arrow_l = new int[]{0,0,72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648};
	static private int [] DrawArrow1p_arrow_r = new int[]{72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648,720,720};

	static private int [] DrawArrow1p_Carrow_l = new int[]{0,0,80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640};
	static private int [] DrawArrow1p_Carrow_r = new int[]{80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640,720,720};

	static private char DrawArrow1p_s1,DrawArrow1p_s3,DrawArrow1p_s5,DrawArrow1p_s7,DrawArrow1p_s9;
	static private int DrawArrow1p_stat1,DrawArrow1p_stat3,DrawArrow1p_stat5,DrawArrow1p_stat7,DrawArrow1p_stat9;
	static private int DrawArrow1p_cur2;
	static private int DrawArrow1p_beat;

	static private boolean DrawArrow1p_Crash1, DrawArrow1p_Crash3, DrawArrow1p_Crash5, DrawArrow1p_Crash7, DrawArrow1p_Crash9;
	static private boolean	DrawArrow1p_On1, DrawArrow1p_On3, DrawArrow1p_On5, DrawArrow1p_On7, DrawArrow1p_On9;
	static private RECT DrawArrow1p_pArr1,DrawArrow1p_pArr3,DrawArrow1p_pArr5,DrawArrow1p_pArr7,DrawArrow1p_pArr9;
	static private RECT DrawArrow1p_cArr1,DrawArrow1p_cArr3,DrawArrow1p_cArr5,DrawArrow1p_cArr7,DrawArrow1p_cArr9;
	static private void DrawArrow1p(int cur)
	{
		/*
		static int arrow_l[20]={0,0,72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648};
		static int arrow_r[20]={72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648,720,720};

		static int Carrow_l[20]={0,0,80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640};
		static int Carrow_r[20]={80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640,720,720};

		static byte s1,s3,s5,s7,s9;
		static long stat1,stat3,stat5,stat7,stat9;
		static long cur2;
		static int beat;

		static BOOL Crash1, Crash3, Crash5, Crash7, Crash9;
		static BOOL	On1, On3, On5, On7, On9;

		static RECT pArr1,pArr3,pArr5,pArr7,pArr9;
		static RECT cArr1,cArr3,cArr5,cArr7,cArr9;
		*/


		char	JudgeTemp=0;
		char	count;

		if(DrawArrow1p_cur2!=cur)
		{
			if(bModeRandomS1p) {
				HighSpeed1p_1 = HighSpeed1p_3 = HighSpeed1p_5 = HighSpeed1p_7 = HighSpeed1p_9 = 1 + rand() % 8 ;
			}
			DrawArrow1p_cur2=cur;
			DrawArrow1p_beat=4;
		}
		else
		{
			DrawArrow1p_beat--;
			if(DrawArrow1p_beat<=0)DrawArrow1p_beat=0;
		}

		ReadGameInput();
	// 오토 버튼 지원 부분
		if(KCFG.auto1_1p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y[(int) (cur+count)]<50)
				{
					if(Data_Judge[(int) (cur+count)][0]=='1')
					{
						Data_Judge[(int) (cur+count)][0]='0';
						DrawArrow1p_stat1=cur+count;
						DrawArrow1p_s1=1;
						DrawArrow1p_Crash1=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto7_1p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y[(int) (cur+count)]<50)
				{
					if(Data_Judge[(int) (cur+count)][1]=='1')
					{
						Data_Judge[(int) (cur+count)][1]='0';
						DrawArrow1p_stat7=cur+count;
						DrawArrow1p_s7=1;
						DrawArrow1p_Crash7=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto5_1p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y[(int) (cur+count)]<50)
				{
					if(Data_Judge[(int) (cur+count)][2]=='1')
					{
						Data_Judge[(int) (cur+count)][2]='0';
						DrawArrow1p_stat5=cur+count;
						DrawArrow1p_s5=1;
						DrawArrow1p_Crash5=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto9_1p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y[(int) (cur+count)]<50)
				{
					if(Data_Judge[(int) (cur+count)][3]=='1')
					{
						Data_Judge[(int) (cur+count)][3]='0';
						DrawArrow1p_stat9=cur+count;
						DrawArrow1p_s9=1;
						DrawArrow1p_Crash9=true;
						break;
					}
				}
			}
		}

		if(KCFG.auto3_1p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y[(int) (cur+count)]<50)
				{
					if(Data_Judge[(int) (cur+count)][4]=='1')
					{
						Data_Judge[(int) (cur+count)][4]='0';
						DrawArrow1p_stat3=cur+count;
						DrawArrow1p_s3=1;
						DrawArrow1p_Crash3=true;
						break;
					}
				}

			}
		}

		if(DrawArrow1p_s1 != 0 || (PressedKey1p[1] != 0) )
		{
			if(DrawArrow1p_s1==20)
			{
				DrawArrow1p_s1=0;
				DrawArrow1p_Crash1=false;
			}
			else
			{
				DrawArrow1p_s1++;
			}
			if(PressedKey1p[1] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed1p_1 < Data_y[(int) (cur+count)] &&
						KDouble.ZONE_D*HighSpeed1p_1 > Data_y[(int) (cur+count)]  )
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed1p_1 < Data_y[(int) (cur+count)] &&
							KDouble.PERFECT_ZONE_D*HighSpeed1p_1 > Data_y[(int) (cur+count)])
					{
						if(Data_Judge[(int) (cur+count)][0]=='1')
						{
							Data_Judge[(int) (cur+count)][0]='0';
							DrawArrow1p_stat1=cur+count;
							DrawArrow1p_On1=true;
							DrawArrow1p_s1=1;
							if(Data_Judge[(int) DrawArrow1p_stat1][0]=='0' && Data_Judge[(int) DrawArrow1p_stat1][1]=='0' && Data_Judge[(int) DrawArrow1p_stat1][2]=='0' && Data_Judge[(int) DrawArrow1p_stat1][3]=='0' && Data_Judge[(int) DrawArrow1p_stat1][4]=='0' )
							{
								DrawArrow1p_Crash1=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed1p_1 < Data_y[(int) (cur+count)] &&
							KDouble.GREAT_ZONE_D*HighSpeed1p_1 > Data_y[(int) (cur+count)]  )
					{
						if(Data_Judge[(int) (cur+count)][0]=='1')
						{
							Data_Judge[(int) (cur+count)][0]='0';
							DrawArrow1p_stat1=cur+count;
							DrawArrow1p_On1=true;
							DrawArrow1p_s1=1;
							if(Data_Judge[(int) DrawArrow1p_stat1][0]=='0' && Data_Judge[(int) DrawArrow1p_stat1][1]=='0' && Data_Judge[(int) DrawArrow1p_stat1][2]=='0' && Data_Judge[(int) DrawArrow1p_stat1][3]=='0' && Data_Judge[(int) DrawArrow1p_stat1][4]=='0' )
							{
								DrawArrow1p_Crash1=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed1p_1 < Data_y[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed1p_1 > Data_y[cur+count] )
					{
						if(Data_Judge[cur+count][0]=='1')
						{
							Data_Judge[cur+count][0]='0';
							DrawArrow1p_stat1=cur+count;
							DrawArrow1p_s1=1;
							if(Data_Judge[DrawArrow1p_stat1][0]=='0' && Data_Judge[DrawArrow1p_stat1][1]=='0' && Data_Judge[DrawArrow1p_stat1][2]=='0' && Data_Judge[DrawArrow1p_stat1][3]=='0' && Data_Judge[DrawArrow1p_stat1][4]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed1p_1 < Data_y[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed1p_1 > Data_y[cur+count] )
					{
						if(Data_Judge[cur+count][0]=='1')
						{
							Data_Judge[cur+count][0]='0';
							DrawArrow1p_stat1=cur+count;
							DrawArrow1p_s1=1;
							if(Data_Judge[DrawArrow1p_stat1][0]=='0' && Data_Judge[DrawArrow1p_stat1][1]=='0' && Data_Judge[DrawArrow1p_stat1][2]=='0' && Data_Judge[DrawArrow1p_stat1][3]=='0' && Data_Judge[DrawArrow1p_stat1][4]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}
		}

		if(DrawArrow1p_s3 != 0 || (PressedKey1p[3] != 0))
		{
			if(DrawArrow1p_s3==20)
			{
				DrawArrow1p_s3=0;
				DrawArrow1p_Crash3=false;
			}
			else
			{
				DrawArrow1p_s3++;
			}
			if(PressedKey1p[3] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed1p_3 < Data_y[cur+count] &&
						KDouble.ZONE_D*HighSpeed1p_3 > Data_y[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed1p_3 < Data_y[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed1p_3 > Data_y[cur+count])
					{
						if(Data_Judge[cur+count][4]=='1')
						{
							Data_Judge[cur+count][4]='0';
							DrawArrow1p_stat3=cur+count;
							DrawArrow1p_On3=true;
							DrawArrow1p_s3=1;
							if(Data_Judge[DrawArrow1p_stat3][0]=='0' && Data_Judge[DrawArrow1p_stat3][1]=='0' && Data_Judge[DrawArrow1p_stat3][2]=='0' && Data_Judge[DrawArrow1p_stat3][3]=='0' && Data_Judge[DrawArrow1p_stat3][4]=='0' )
							{
								DrawArrow1p_Crash3=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed1p_3<Data_y[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed1p_3>Data_y[cur+count] )
					{
						if(Data_Judge[cur+count][4]=='1')
						{
							Data_Judge[cur+count][4]='0';
							DrawArrow1p_stat3=cur+count;
							DrawArrow1p_On3=true;
							DrawArrow1p_s3=1;
							if(Data_Judge[DrawArrow1p_stat3][0]=='0' && Data_Judge[DrawArrow1p_stat3][1]=='0' && Data_Judge[DrawArrow1p_stat3][2]=='0' && Data_Judge[DrawArrow1p_stat3][3]=='0' && Data_Judge[DrawArrow1p_stat3][4]=='0' )
							{
								DrawArrow1p_Crash3=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed1p_3 < Data_y[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed1p_3 > Data_y[cur+count])
					{
						if(Data_Judge[cur+count][4]=='1')
						{
							Data_Judge[cur+count][4]='0';
							DrawArrow1p_stat3=cur+count;
							DrawArrow1p_s3=1;
							if(Data_Judge[DrawArrow1p_stat3][0]=='0' && Data_Judge[DrawArrow1p_stat3][1]=='0' && Data_Judge[DrawArrow1p_stat3][2]=='0' && Data_Judge[DrawArrow1p_stat3][3]=='0' && Data_Judge[DrawArrow1p_stat3][4]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed1p_3<Data_y[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed1p_3>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][4]=='1')
						{
							Data_Judge[cur+count][4]='0';
							DrawArrow1p_stat3=cur+count;
							DrawArrow1p_s3=1;
							if(Data_Judge[DrawArrow1p_stat3][0]=='0' && Data_Judge[DrawArrow1p_stat3][1]=='0' && Data_Judge[DrawArrow1p_stat3][2]=='0' && Data_Judge[DrawArrow1p_stat3][3]=='0' && Data_Judge[DrawArrow1p_stat3][4]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}
		}

		if(DrawArrow1p_s5 != 0 || (PressedKey1p[5] != 0)) {
			if(DrawArrow1p_s5==20) {
				DrawArrow1p_s5=0;
				DrawArrow1p_Crash5=false;
			} else {
				DrawArrow1p_s5++;
			}
			if(PressedKey1p[5] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed1p_5<Data_y[cur+count] &&
						KDouble.ZONE_D*HighSpeed1p_5>Data_y[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed1p_5<Data_y[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed1p_5>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][2]=='1')
						{
							Data_Judge[cur+count][2]='0';
							DrawArrow1p_stat5=cur+count;
							DrawArrow1p_On5=true;
							DrawArrow1p_s5=1;
							if(Data_Judge[DrawArrow1p_stat5][0]=='0' && Data_Judge[DrawArrow1p_stat5][1]=='0' && Data_Judge[DrawArrow1p_stat5][2]=='0' && Data_Judge[DrawArrow1p_stat5][3]=='0' && Data_Judge[DrawArrow1p_stat5][4]=='0' )
							{
								DrawArrow1p_Crash5=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed1p_5<Data_y[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed1p_5>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][2]=='1')
						{
							Data_Judge[cur+count][2]='0';
							DrawArrow1p_stat5=cur+count;
							DrawArrow1p_On5=true;
							DrawArrow1p_s5=1;
							if(Data_Judge[DrawArrow1p_stat5][0]=='0' && Data_Judge[DrawArrow1p_stat5][1]=='0' && Data_Judge[DrawArrow1p_stat5][2]=='0' && Data_Judge[DrawArrow1p_stat5][3]=='0' && Data_Judge[DrawArrow1p_stat5][4]=='0' )
							{
								DrawArrow1p_Crash5=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed1p_5<Data_y[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed1p_5>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][2]=='1')
						{
							Data_Judge[cur+count][2]='0';
							DrawArrow1p_stat5=cur+count;
							DrawArrow1p_s5=1;
							if(Data_Judge[DrawArrow1p_stat5][0]=='0' && Data_Judge[DrawArrow1p_stat5][1]=='0' && Data_Judge[DrawArrow1p_stat5][2]=='0' && Data_Judge[DrawArrow1p_stat5][3]=='0' && Data_Judge[DrawArrow1p_stat5][4]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed1p_5<Data_y[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed1p_5>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][2]=='1')
						{
							Data_Judge[cur+count][2]='0';
							DrawArrow1p_stat5=cur+count;
							DrawArrow1p_s5=1;
							if(Data_Judge[DrawArrow1p_stat5][0]=='0' && Data_Judge[DrawArrow1p_stat5][1]=='0' && Data_Judge[DrawArrow1p_stat5][2]=='0' && Data_Judge[DrawArrow1p_stat5][3]=='0' && Data_Judge[DrawArrow1p_stat5][4]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}

				}
			}

		}

		if(DrawArrow1p_s7 != 0|| (PressedKey1p[7] != 0) )
		{
			if(DrawArrow1p_s7==20)
			{
				DrawArrow1p_s7=0;
				DrawArrow1p_Crash7=false;
			}
			else
			{
				DrawArrow1p_s7++;
			}
			if(PressedKey1p[7] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed1p_7 < Data_y[cur+count] &&
						KDouble.ZONE_D*HighSpeed1p_7 > Data_y[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed1p_7 < Data_y[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed1p_7 > Data_y[cur+count])
					{
						if(Data_Judge[cur+count][1]=='1')
						{
							Data_Judge[cur+count][1]='0';
							DrawArrow1p_stat7=cur+count;
							DrawArrow1p_On7=true;
							DrawArrow1p_s7=1;
							if(Data_Judge[DrawArrow1p_stat7][0]=='0' && Data_Judge[DrawArrow1p_stat7][1]=='0' && Data_Judge[DrawArrow1p_stat7][2]=='0' && Data_Judge[DrawArrow1p_stat7][3]=='0' && Data_Judge[DrawArrow1p_stat7][4]=='0' )
							{
								DrawArrow1p_Crash7=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed1p_7<Data_y[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed1p_7>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][1]=='1')
						{
							Data_Judge[cur+count][1]='0';
							DrawArrow1p_stat7=cur+count;
							DrawArrow1p_On7=true;
							DrawArrow1p_s7=1;
							if(Data_Judge[DrawArrow1p_stat7][0]=='0' && Data_Judge[DrawArrow1p_stat7][1]=='0' && Data_Judge[DrawArrow1p_stat7][2]=='0' && Data_Judge[DrawArrow1p_stat7][3]=='0' && Data_Judge[DrawArrow1p_stat7][4]=='0' )
							{
								DrawArrow1p_Crash7=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed1p_7<Data_y[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed1p_7>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][1]=='1')
						{
							Data_Judge[cur+count][1]='0';
							DrawArrow1p_stat7=cur+count;
							DrawArrow1p_s7=1;
							if(Data_Judge[DrawArrow1p_stat7][0]=='0' && Data_Judge[DrawArrow1p_stat7][1]=='0' && Data_Judge[DrawArrow1p_stat7][2]=='0' && Data_Judge[DrawArrow1p_stat7][3]=='0' && Data_Judge[DrawArrow1p_stat7][4]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed1p_7<Data_y[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed1p_7>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][1]=='1')
						{
							Data_Judge[cur+count][1]='0';
							DrawArrow1p_stat7=cur+count;
							DrawArrow1p_s7=1;
							if(Data_Judge[DrawArrow1p_stat7][0]=='0' && Data_Judge[DrawArrow1p_stat7][1]=='0' && Data_Judge[DrawArrow1p_stat7][2]=='0' && Data_Judge[DrawArrow1p_stat7][3]=='0' && Data_Judge[DrawArrow1p_stat7][4]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}

				}
			}
		}

		if(DrawArrow1p_s9 != 0 || (PressedKey1p[9] != 0))
		{
			if(DrawArrow1p_s9==20)
			{

				DrawArrow1p_s9=0;
				DrawArrow1p_Crash9=false;
			}
			else
			{
				DrawArrow1p_s9++;
			}
			if(PressedKey1p[9] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed1p_9<Data_y[cur+count] &&
						KDouble.ZONE_D*HighSpeed1p_9>Data_y[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed1p_9<Data_y[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed1p_9>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][3]=='1')
						{
							Data_Judge[cur+count][3]='0';
							DrawArrow1p_stat9=cur+count;
							DrawArrow1p_On9=true;
							DrawArrow1p_s9=1;
							if(Data_Judge[DrawArrow1p_stat9][0]=='0' && Data_Judge[DrawArrow1p_stat9][1]=='0' && Data_Judge[DrawArrow1p_stat9][2]=='0' && Data_Judge[DrawArrow1p_stat9][3]=='0' && Data_Judge[DrawArrow1p_stat9][4]=='0' )
							{
								DrawArrow1p_Crash9=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed1p_9<Data_y[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed1p_9>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][3]=='1')
						{
							Data_Judge[cur+count][3]='0';
							DrawArrow1p_stat9=cur+count;
							DrawArrow1p_On9=true;
							DrawArrow1p_s9=1;
							if(Data_Judge[DrawArrow1p_stat9][0]=='0' && Data_Judge[DrawArrow1p_stat9][1]=='0' && Data_Judge[DrawArrow1p_stat9][2]=='0' && Data_Judge[DrawArrow1p_stat9][3]=='0' && Data_Judge[DrawArrow1p_stat9][4]=='0' )
							{
								DrawArrow1p_Crash9=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed1p_9<Data_y[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed1p_9>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][3]=='1')
						{
							Data_Judge[cur+count][3]='0';
							DrawArrow1p_stat9=cur+count;
							DrawArrow1p_s9=1;
							if(Data_Judge[DrawArrow1p_stat9][0]=='0' && Data_Judge[DrawArrow1p_stat9][1]=='0' && Data_Judge[DrawArrow1p_stat9][2]=='0' && Data_Judge[DrawArrow1p_stat9][3]=='0' && Data_Judge[DrawArrow1p_stat9][4]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed1p_9<Data_y[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed1p_9>Data_y[cur+count])
					{
						if(Data_Judge[cur+count][3]=='1')
						{
							Data_Judge[cur+count][3]='0';
							DrawArrow1p_stat9=cur+count;
							DrawArrow1p_s9=1;
							if(Data_Judge[DrawArrow1p_stat9][0]=='0' && Data_Judge[DrawArrow1p_stat9][1]=='0' && Data_Judge[DrawArrow1p_stat9][2]=='0' && Data_Judge[DrawArrow1p_stat9][3]=='0' && Data_Judge[DrawArrow1p_stat9][4]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}

		}

		Judgement1p=JudgeTemp;

		// 미스처리입니다.
		for(count=0;count<10;count++)
		if(Data_y[cur+count] < KDouble.ZONE_U
			&& (Data_Judge[cur+count][0]!='0' || Data_Judge[cur+count][1]!='0' || Data_Judge[cur+count][2]!='0' || Data_Judge[cur+count][3]!='0' || Data_Judge[cur+count][4]!='0')
			&& (Data[cur+count][0]!='0' || Data[cur+count][1]!='0' || Data[cur+count][2]!='0' || Data[cur+count][3]!='0' || Data[cur+count][4]!='0' ))
		{
			if(Data[cur+count][0]=='2')break;
			Data_Judge[cur+count][0]=Data_Judge[cur+count][1]=Data_Judge[cur+count][2]=Data_Judge[cur+count][3]=Data_Judge[cur+count][4]='0';
			Judgement1p=MISS;
			Combo1p=0;
		}


		if(DrawArrow1p_Crash1)
		{
			if(DrawArrow1p_s1==2)if(Data_Judge[DrawArrow1p_stat1][0]=='0' && Data_Judge[DrawArrow1p_stat1][1]=='0' && Data_Judge[DrawArrow1p_stat1][2]=='0' && Data_Judge[DrawArrow1p_stat1][3]=='0' && Data_Judge[DrawArrow1p_stat1][4]=='0' )
			{
				Data[DrawArrow1p_stat1][0]=Data[DrawArrow1p_stat1][1]=Data[DrawArrow1p_stat1][2]=Data[DrawArrow1p_stat1][3]=Data[DrawArrow1p_stat1][4]='0';
				//Judgement1p=PERFECT;
				Judgement1p=JudgeTemp;
			}
			else Judgement1p=NONE;
		}
		if(DrawArrow1p_Crash7)
		{
			if(DrawArrow1p_s7==2)if(Data_Judge[DrawArrow1p_stat7][0]=='0' && Data_Judge[DrawArrow1p_stat7][1]=='0' && Data_Judge[DrawArrow1p_stat7][2]=='0' && Data_Judge[DrawArrow1p_stat7][3]=='0' && Data_Judge[DrawArrow1p_stat7][4]=='0' )
			{
				Data[DrawArrow1p_stat7][0]=Data[DrawArrow1p_stat7][1]=Data[DrawArrow1p_stat7][2]=Data[DrawArrow1p_stat7][3]=Data[DrawArrow1p_stat7][4]='0';
				//Judgement1p=PERFECT;
				Judgement1p=JudgeTemp;
			}
			else Judgement1p=NONE;
		}
		if(DrawArrow1p_Crash5)
		{
			if(DrawArrow1p_s5==2)if(Data_Judge[DrawArrow1p_stat5][0]=='0' && Data_Judge[DrawArrow1p_stat5][1]=='0' && Data_Judge[DrawArrow1p_stat5][2]=='0' && Data_Judge[DrawArrow1p_stat5][3]=='0' && Data_Judge[DrawArrow1p_stat5][4]=='0' )
			{
				Data[DrawArrow1p_stat5][0]=Data[DrawArrow1p_stat5][1]=Data[DrawArrow1p_stat5][2]=Data[DrawArrow1p_stat5][3]=Data[DrawArrow1p_stat5][4]='0';
				//Judgement1p=PERFECT;
				Judgement1p=JudgeTemp;
			}
			else Judgement1p=NONE;
		}
		if(DrawArrow1p_Crash9)
		{
			if(DrawArrow1p_s9==2)if(Data_Judge[DrawArrow1p_stat9][0]=='0' && Data_Judge[DrawArrow1p_stat9][1]=='0' && Data_Judge[DrawArrow1p_stat9][2]=='0' && Data_Judge[DrawArrow1p_stat9][3]=='0' && Data_Judge[DrawArrow1p_stat9][4]=='0' )
			{
				Data[DrawArrow1p_stat9][0]=Data[DrawArrow1p_stat9][1]=Data[DrawArrow1p_stat9][2]=Data[DrawArrow1p_stat9][3]=Data[DrawArrow1p_stat9][4]='0';
				//Judgement1p=PERFECT;
				Judgement1p=JudgeTemp;
			}
			else Judgement1p=NONE;
		}
		if(DrawArrow1p_Crash3)
		{
			if(DrawArrow1p_s3==2)if(Data_Judge[DrawArrow1p_stat3][0]=='0' && Data_Judge[DrawArrow1p_stat3][1]=='0' && Data_Judge[DrawArrow1p_stat3][2]=='0' && Data_Judge[DrawArrow1p_stat3][3]=='0' && Data_Judge[DrawArrow1p_stat3][4]=='0' )
			{
				Data[DrawArrow1p_stat3][0]=Data[DrawArrow1p_stat3][1]=Data[DrawArrow1p_stat3][2]=Data[DrawArrow1p_stat3][3]=Data[DrawArrow1p_stat3][4]='0';
				//Judgement1p=PERFECT;
				Judgement1p=JudgeTemp;
			}
			else Judgement1p=NONE;
		}

		if(Judgement1p==PERFECT || Judgement1p==GREAT)
		{
			if(g_dsBeat != null) {
				g_dsBeat.Stop();
				g_dsBeat.SetCurrentPosition(0);
				g_dsBeat.Play(0,0,0);
			}
			if(Judgement1p==PERFECT)
				cPerfect1p++;
			if(Judgement1p==GREAT)
				cGreat1p++;

			Combo1p++;
			if(Combo1p>cMaxCombo1p)cMaxCombo1p=Combo1p;
			if(Combo1p>10)
			{
				if(Gauge1p<0)Gauge1p=1;
				else Gauge1p++;
				if(Gauge1p>42)Gauge1p=41;
			}
			DrawArrow1p_Crash1=DrawArrow1p_On1;
			DrawArrow1p_Crash3=DrawArrow1p_On3;
			DrawArrow1p_Crash5=DrawArrow1p_On5;
			DrawArrow1p_Crash7=DrawArrow1p_On7;
			DrawArrow1p_Crash9=DrawArrow1p_On9;

			DrawArrow1p_On1=DrawArrow1p_On3=DrawArrow1p_On5=DrawArrow1p_On7=DrawArrow1p_On9=false;
		}
		else if(Judgement1p==GOOD || Judgement1p==BAD || Judgement1p==MISS)
		{
			if(Judgement1p==GOOD)cGood1p++;
			else if(Judgement1p==BAD)cBad1p++;
			else if(Judgement1p==MISS)cMiss1p++;
			Combo1p=0;
		}

		if(Combo1p != 0)
		{
			if(Judgement1p==PERFECT)Score1p+=2000;
			else if(Judgement1p==GREAT)Score1p+=1500;
		}
		else
		{
			if(Judgement1p==PERFECT)Score1p+=1000;
			else if(Judgement1p==GREAT)Score1p+=500;
		}

		if(Judgement1p==GOOD)Score1p+=100;
		else if(Judgement1p==BAD)
		{
			Score1p-=700;
			Gauge1p-=2;
		}
		else if(Judgement1p==MISS)
		{
			Score1p-=1000;
			Gauge1p-=5;
		}

		if(KCFG.bcDead)
		{
			if(Couple)
			{
				if(Gauge1p<-40 && Gauge2p<-40)
				{
					if(SongFlag)
					{
						SongFlag=false;
					}
					g_programState=DEAD;
				}
			}
			else
			{
				if(Gauge1p<-40)
				{
					if(SongFlag)
					{
						SongFlag=false;
					}
					g_programState=DEAD;
				}
			}
		}

		if(Score1p<0)Score1p=0;

		if(DrawArrow1p_beat != 0)
			g_pDDSBack.BltFast(32,50,Arrow2,null,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else
			g_pDDSBack.BltFast(32,50,Arrow1,null,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		DrawArrow1p_pArr1.top=0;
		DrawArrow1p_pArr1.left=DrawArrow1p_arrow_l[DrawArrow1p_s1];
		DrawArrow1p_pArr1.right=DrawArrow1p_arrow_r[DrawArrow1p_s1];
		DrawArrow1p_pArr1.bottom=70;

		DrawArrow1p_pArr3.top=0;
		DrawArrow1p_pArr3.left=DrawArrow1p_arrow_l[DrawArrow1p_s3];
		DrawArrow1p_pArr3.right=DrawArrow1p_arrow_r[DrawArrow1p_s3];
		DrawArrow1p_pArr3.bottom=70;

		DrawArrow1p_pArr5.top=0;
		DrawArrow1p_pArr5.left=DrawArrow1p_arrow_l[DrawArrow1p_s5];
		DrawArrow1p_pArr5.right=DrawArrow1p_arrow_r[DrawArrow1p_s5];
		DrawArrow1p_pArr5.bottom=70;

		DrawArrow1p_pArr7.top=0;
		DrawArrow1p_pArr7.left=DrawArrow1p_arrow_l[DrawArrow1p_s7];
		DrawArrow1p_pArr7.right=DrawArrow1p_arrow_r[DrawArrow1p_s7];
		DrawArrow1p_pArr7.bottom=70;

		DrawArrow1p_pArr9.top=0;
		DrawArrow1p_pArr9.left=DrawArrow1p_arrow_l[DrawArrow1p_s9];
		DrawArrow1p_pArr9.right=DrawArrow1p_arrow_r[DrawArrow1p_s9];
		DrawArrow1p_pArr9.bottom=70;

		DrawArrow1p_cArr1.top=0;
		DrawArrow1p_cArr1.left=DrawArrow1p_Carrow_l[DrawArrow1p_s1];
		DrawArrow1p_cArr1.right=DrawArrow1p_Carrow_r[DrawArrow1p_s1];
		DrawArrow1p_cArr1.bottom=80;

		DrawArrow1p_cArr3.top=0;
		DrawArrow1p_cArr3.left=DrawArrow1p_Carrow_l[DrawArrow1p_s3];
		DrawArrow1p_cArr3.right=DrawArrow1p_Carrow_r[DrawArrow1p_s3];
		DrawArrow1p_cArr3.bottom=80;

		DrawArrow1p_cArr5.top=0;
		DrawArrow1p_cArr5.left=DrawArrow1p_Carrow_l[DrawArrow1p_s5];
		DrawArrow1p_cArr5.right=DrawArrow1p_Carrow_r[DrawArrow1p_s5];
		DrawArrow1p_cArr5.bottom=80;

		DrawArrow1p_cArr7.top=0;
		DrawArrow1p_cArr7.left=DrawArrow1p_Carrow_l[DrawArrow1p_s7];
		DrawArrow1p_cArr7.right=DrawArrow1p_Carrow_r[DrawArrow1p_s7];
		DrawArrow1p_cArr7.bottom=80;

		DrawArrow1p_cArr9.top=0;
		DrawArrow1p_cArr9.left=DrawArrow1p_Carrow_l[DrawArrow1p_s9];
		DrawArrow1p_cArr9.right=DrawArrow1p_Carrow_r[DrawArrow1p_s9];
		DrawArrow1p_cArr9.bottom=80;

		if(DrawArrow1p_Crash1)g_pDDSBack.BltFast(25,43,cArrow1,DrawArrow1p_cArr1,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow1p_s1!=0)g_pDDSBack.BltFast(27,45,pArrow1,DrawArrow1p_pArr1,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow1p_Crash7)g_pDDSBack.BltFast(75,43,cArrow7,DrawArrow1p_cArr7,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow1p_s7!=0)g_pDDSBack.BltFast(77,45,pArrow7,DrawArrow1p_pArr7,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow1p_Crash5)g_pDDSBack.BltFast(125,43,cArrow5,DrawArrow1p_cArr5,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow1p_s5!=0)g_pDDSBack.BltFast(127,45,pArrow5,DrawArrow1p_pArr5,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow1p_Crash9)g_pDDSBack.BltFast(175,43,cArrow9,DrawArrow1p_cArr9,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow1p_s9!=0)g_pDDSBack.BltFast(177,45,pArrow9,DrawArrow1p_pArr9,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow1p_Crash3)g_pDDSBack.BltFast(225,43,cArrow3,DrawArrow1p_cArr3,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow1p_s3!=0)g_pDDSBack.BltFast(227,45,pArrow3,DrawArrow1p_pArr3,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
	}


	static int [] DrawArrow2p_arrow_l = new int[]{0,0,72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648};
	static int [] DrawArrow2p_arrow_r = new int[]{72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648,720,720};
	static int [] DrawArrow2p_Carrow_l= new int[]{0,0,80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640};
	static int [] DrawArrow2p_Carrow_r= new int[]{80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640,720,720};
	static char DrawArrow2p_s1,DrawArrow2p_s3,DrawArrow2p_s5,DrawArrow2p_s7,DrawArrow2p_s9;
	static int DrawArrow2p_stat1,DrawArrow2p_stat3,DrawArrow2p_stat5,DrawArrow2p_stat7,DrawArrow2p_stat9;
	static int DrawArrow2p_cur2;
	static int DrawArrow2p_beat;
	static boolean DrawArrow2p_Crash1, DrawArrow2p_Crash3, DrawArrow2p_Crash5, DrawArrow2p_Crash7, DrawArrow2p_Crash9;
	static boolean	DrawArrow2p_On1, DrawArrow2p_On3, DrawArrow2p_On5, DrawArrow2p_On7, DrawArrow2p_On9;

	static RECT DrawArrow2p_pArr1,DrawArrow2p_pArr3,DrawArrow2p_pArr5,DrawArrow2p_pArr7,DrawArrow2p_pArr9;
	static RECT DrawArrow2p_cArr1,DrawArrow2p_cArr3,DrawArrow2p_cArr5,DrawArrow2p_cArr7,DrawArrow2p_cArr9;
	static private void DrawArrow2p(int cur)
	{
		/*
		static int arrow_l[20]={0,0,72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648};
		static int arrow_r[20]={72,72,144,144,216,216,288,288,360,360,432,432,504,504,576,576,648,648,720,720};

		static int Carrow_l[20]={0,0,80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640};
		static int Carrow_r[20]={80,80,160,160,240,240,320,320,400,400,480,480,560,560,640,640,720,720};

		static char s1,s3,s5,s7,s9;
		static int stat1,stat3,stat5,stat7,stat9;
		static int cur2;
		static int beat;

		static boolean Crash1, Crash3, Crash5, Crash7, Crash9;
		static boolean	On1, On3, On5, On7, On9;

		static RECT pArr1,pArr3,pArr5,pArr7,pArr9;
		static RECT cArr1,cArr3,cArr5,cArr7,cArr9;
		*/


		char JudgeTemp=0;
		int	count;


		if(Start2p==true && Start1p==false)ReadGameInput();
		if(DrawArrow2p_cur2!=cur)
		{
			if(bModeRandomS2p ==true)
				HighSpeed2p_1 = HighSpeed2p_3 = HighSpeed2p_5 = HighSpeed2p_7 = HighSpeed2p_9 = 1 + rand() % 8 ;
			DrawArrow2p_cur2=cur;
			DrawArrow2p_beat=4;
		}
		else
		{
			DrawArrow2p_beat--;
			if(DrawArrow2p_beat<=0)DrawArrow2p_beat=0;
		}
	// 오토 버튼 지원 부분
		if(KCFG.auto1_2p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y1[cur+count]<50)
				{
					if(Data_Judge1[cur+count][5]=='1')
					{
						Data_Judge1[cur+count][5]='0';
						DrawArrow2p_stat1=cur+count;
						DrawArrow2p_s1=1;
						DrawArrow2p_Crash1=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto7_2p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y1[cur+count]<50)
				{
					if(Data_Judge1[cur+count][6]=='1')
					{
						Data_Judge1[cur+count][6]='0';
						DrawArrow2p_stat7=cur+count;
						DrawArrow2p_s7=1;
						DrawArrow2p_Crash7=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto5_2p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y1[cur+count]<50)
				{
					if(Data_Judge1[cur+count][7]=='1')
					{
						Data_Judge1[cur+count][7]='0';
						DrawArrow2p_stat5=cur+count;
						DrawArrow2p_s5=1;
						DrawArrow2p_Crash5=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto9_2p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y1[cur+count]<50)
				{
					if(Data_Judge1[cur+count][8]=='1')
					{
						Data_Judge1[cur+count][8]='0';
						DrawArrow2p_stat9=cur+count;
						DrawArrow2p_s9=1;
						DrawArrow2p_Crash9=true;
						break;
					}
				}

			}
		}

		if(KCFG.auto3_2p==true)
		{
			for(count=0;count<10;count++)
			{
				if(Data_y1[cur+count]<50)
				{
					if(Data_Judge1[cur+count][9]=='1')
					{
						Data_Judge1[cur+count][9]='0';
						DrawArrow2p_stat3=cur+count;
						DrawArrow2p_s3=1;
						DrawArrow2p_Crash3=true;
						break;
					}
				}

			}
		}

		if(DrawArrow2p_s1 != 0|| (PressedKey2p[1] != 0) )
		{
			if(DrawArrow2p_s1==20)
			{
				DrawArrow2p_s1=0;
				DrawArrow2p_Crash1=false;
			}
			else
			{
				DrawArrow2p_s1++;
			}
			if(PressedKey2p[1] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed2p_1 < Data_y1[cur+count] &&
						KDouble.ZONE_D*HighSpeed2p_1 > Data_y1[cur+count]  )
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed2p_1 < Data_y1[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed2p_1 > Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][5]=='1')
						{
							Data_Judge1[cur+count][5]='0';
							DrawArrow2p_stat1=cur+count;
							DrawArrow2p_On1=true;
							DrawArrow2p_s1=1;
							if(Data_Judge1[DrawArrow2p_stat1][5]=='0' && Data_Judge1[DrawArrow2p_stat1][6]=='0' && Data_Judge1[DrawArrow2p_stat1][7]=='0' && Data_Judge1[DrawArrow2p_stat1][8]=='0' && Data_Judge1[DrawArrow2p_stat1][9]=='0' )
							{
								DrawArrow2p_Crash1=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed2p_1 < Data_y1[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed2p_1 > Data_y1[cur+count]  )
					{
						if(Data_Judge1[cur+count][5]=='1')
						{
							Data_Judge1[cur+count][5]='0';
							DrawArrow2p_stat1=cur+count;
							DrawArrow2p_On1=true;
							DrawArrow2p_s1=1;
							if(Data_Judge1[DrawArrow2p_stat1][5]=='0' && Data_Judge1[DrawArrow2p_stat1][6]=='0' && Data_Judge1[DrawArrow2p_stat1][7]=='0' && Data_Judge1[DrawArrow2p_stat1][8]=='0' && Data_Judge1[DrawArrow2p_stat1][9]=='0' )
							{
								DrawArrow2p_Crash1=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if(KDouble.GOOD_ZONE_U*HighSpeed2p_1 < Data_y1[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed2p_1 > Data_y1[cur+count] )
					{
						if(Data_Judge1[cur+count][5]=='1')
						{
							Data_Judge1[cur+count][5]='0';
							DrawArrow2p_stat1=cur+count;
							DrawArrow2p_s1=1;
							if(Data_Judge1[DrawArrow2p_stat1][5]=='0' && Data_Judge1[DrawArrow2p_stat1][6]=='0' && Data_Judge1[DrawArrow2p_stat1][7]=='0' && Data_Judge1[DrawArrow2p_stat1][8]=='0' && Data_Judge1[DrawArrow2p_stat1][9]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed2p_1 < Data_y1[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed2p_1 > Data_y1[cur+count] )
					{
						if(Data_Judge1[cur+count][5]=='1')
						{
							Data_Judge1[cur+count][5]='0';
							DrawArrow2p_stat1=cur+count;
							DrawArrow2p_s1=1;
							if(Data_Judge1[DrawArrow2p_stat1][5]=='0' && Data_Judge1[DrawArrow2p_stat1][6]=='0' && Data_Judge1[DrawArrow2p_stat1][7]=='0' && Data_Judge1[DrawArrow2p_stat1][8]=='0' && Data_Judge1[DrawArrow2p_stat1][9]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}
		}

		if(DrawArrow2p_s3 !=0 || (PressedKey2p[3] != 0))
		{
			if(DrawArrow2p_s3==20)
			{
				DrawArrow2p_s3=0;
				DrawArrow2p_Crash3=false;
			}
			else
			{
				DrawArrow2p_s3++;
			}
			if(PressedKey2p[3] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed2p_3 < Data_y1[cur+count] &&
						KDouble.ZONE_D*HighSpeed2p_3 > Data_y1[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed2p_3 < Data_y1[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed2p_3 > Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][9]=='1')
						{
							Data_Judge1[cur+count][9]='0';
							DrawArrow2p_stat3=cur+count;
							DrawArrow2p_On3=true;
							DrawArrow2p_s3=1;
							if(Data_Judge1[DrawArrow2p_stat3][5]=='0' && Data_Judge1[DrawArrow2p_stat3][6]=='0' && Data_Judge1[DrawArrow2p_stat3][7]=='0' && Data_Judge1[DrawArrow2p_stat3][8]=='0' && Data_Judge1[DrawArrow2p_stat3][9]=='0' )
							{
								DrawArrow2p_Crash3=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed2p_3<Data_y1[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed2p_3>Data_y1[cur+count] )
					{
						if(Data_Judge1[cur+count][9]=='1')
						{
							Data_Judge1[cur+count][9]='0';
							DrawArrow2p_stat3=cur+count;
							DrawArrow2p_On3=true;
							DrawArrow2p_s3=1;
							if(Data_Judge1[DrawArrow2p_stat3][5]=='0' && Data_Judge1[DrawArrow2p_stat3][6]=='0' && Data_Judge1[DrawArrow2p_stat3][7]=='0' && Data_Judge1[DrawArrow2p_stat3][8]=='0' && Data_Judge1[DrawArrow2p_stat3][9]=='0' )
							{
								DrawArrow2p_Crash3=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed2p_3 < Data_y1[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed2p_3 > Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][9]=='1')
						{
							Data_Judge1[cur+count][9]='0';
							DrawArrow2p_stat3=cur+count;
							DrawArrow2p_s3=1;
							if(Data_Judge1[DrawArrow2p_stat3][5]=='0' && Data_Judge1[DrawArrow2p_stat3][6]=='0' && Data_Judge1[DrawArrow2p_stat3][7]=='0' && Data_Judge1[DrawArrow2p_stat3][8]=='0' && Data_Judge1[DrawArrow2p_stat3][9]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if(KDouble.BAD_ZONE_U*HighSpeed2p_3<Data_y1[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed2p_3>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][9]=='1')
						{
							Data_Judge1[cur+count][9]='0';
							DrawArrow2p_stat3=cur+count;
							DrawArrow2p_s3=1;
							if(Data_Judge1[DrawArrow2p_stat3][5]=='0' && Data_Judge1[DrawArrow2p_stat3][6]=='0' && Data_Judge1[DrawArrow2p_stat3][7]=='0' && Data_Judge1[DrawArrow2p_stat3][8]=='0' && Data_Judge1[DrawArrow2p_stat3][9]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}
		}

		if(DrawArrow2p_s5 != 0 || (PressedKey2p[5] != 0))
		{
			if(DrawArrow2p_s5==20)
			{
				DrawArrow2p_s5=0;
				DrawArrow2p_Crash5=false;
			}
			else
			{
				DrawArrow2p_s5++;
			}
			if(PressedKey2p[5] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed2p_5<Data_y1[cur+count] &&
						KDouble.ZONE_D*HighSpeed2p_5>Data_y1[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed2p_5<Data_y1[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed2p_5>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][7]=='1')
						{
							Data_Judge1[cur+count][7]='0';
							DrawArrow2p_stat5=cur+count;
							DrawArrow2p_On5=true;
							DrawArrow2p_s5=1;
							if(Data_Judge1[DrawArrow2p_stat5][5]=='0' && Data_Judge1[DrawArrow2p_stat5][6]=='0' && Data_Judge1[DrawArrow2p_stat5][7]=='0' && Data_Judge1[DrawArrow2p_stat5][8]=='0' && Data_Judge1[DrawArrow2p_stat5][9]=='0' )
							{
								DrawArrow2p_Crash5=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed2p_5<Data_y1[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed2p_5>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][7]=='1')
						{
							Data_Judge1[cur+count][7]='0';
							DrawArrow2p_stat5=cur+count;
							DrawArrow2p_On5=true;
							DrawArrow2p_s5=1;
							if(Data_Judge1[DrawArrow2p_stat5][5]=='0' && Data_Judge1[DrawArrow2p_stat5][6]=='0' && Data_Judge1[DrawArrow2p_stat5][7]=='0' && Data_Judge1[DrawArrow2p_stat5][8]=='0' && Data_Judge1[DrawArrow2p_stat5][9]=='0' )
							{
								DrawArrow2p_Crash5=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed2p_5<Data_y1[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed2p_5>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][7]=='1')
						{
							Data_Judge1[cur+count][7]='0';
							DrawArrow2p_stat5=cur+count;
							DrawArrow2p_s5=1;
							if(Data_Judge1[DrawArrow2p_stat5][5]=='0' && Data_Judge1[DrawArrow2p_stat5][6]=='0' && Data_Judge1[DrawArrow2p_stat5][7]=='0' && Data_Judge1[DrawArrow2p_stat5][8]=='0' && Data_Judge1[DrawArrow2p_stat5][9]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed2p_5<Data_y1[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed2p_5>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][7]=='1')
						{
							Data_Judge1[cur+count][7]='0';
							DrawArrow2p_stat5=cur+count;
							DrawArrow2p_s5=1;
							if(Data_Judge1[DrawArrow2p_stat5][5]=='0' && Data_Judge1[DrawArrow2p_stat5][6]=='0' && Data_Judge1[DrawArrow2p_stat5][7]=='0' && Data_Judge1[DrawArrow2p_stat5][8]=='0' && Data_Judge1[DrawArrow2p_stat5][9]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}

				}
			}

		}

		if(DrawArrow2p_s7 !=0 || (PressedKey2p[7] != 0) )
		{
			if(DrawArrow2p_s7==20)
			{
				DrawArrow2p_s7=0;
				DrawArrow2p_Crash7=false;
			}
			else
			{
				DrawArrow2p_s7++;
			}
			if(PressedKey2p[7] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed2p_7 < Data_y1[cur+count] &&
						KDouble.ZONE_D*HighSpeed2p_7 > Data_y1[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed2p_7 < Data_y1[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed2p_7 > Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][6]=='1')
						{
							Data_Judge1[cur+count][6]='0';
							DrawArrow2p_stat7=cur+count;
							DrawArrow2p_On7=true;
							DrawArrow2p_s7=1;
							if(Data_Judge1[DrawArrow2p_stat7][5]=='0' && Data_Judge1[DrawArrow2p_stat7][6]=='0' && Data_Judge1[DrawArrow2p_stat7][7]=='0' && Data_Judge1[DrawArrow2p_stat7][8]=='0' && Data_Judge1[DrawArrow2p_stat7][9]=='0' )
							{
								DrawArrow2p_Crash7=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed2p_7<Data_y1[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed2p_7>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][6]=='1')
						{
							Data_Judge1[cur+count][6]='0';
							DrawArrow2p_stat7=cur+count;
							DrawArrow2p_On7=true;
							DrawArrow2p_s7=1;
							if(Data_Judge1[DrawArrow2p_stat7][5]=='0' && Data_Judge1[DrawArrow2p_stat7][6]=='0' && Data_Judge1[DrawArrow2p_stat7][7]=='0' && Data_Judge1[DrawArrow2p_stat7][8]=='0' && Data_Judge1[DrawArrow2p_stat7][9]=='0' )
							{
								DrawArrow2p_Crash7=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed2p_7<Data_y1[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed2p_7>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][6]=='1')
						{
							Data_Judge1[cur+count][6]='0';
							DrawArrow2p_stat7=cur+count;
							DrawArrow2p_s7=1;
							if(Data_Judge1[DrawArrow2p_stat7][5]=='0' && Data_Judge1[DrawArrow2p_stat7][6]=='0' && Data_Judge1[DrawArrow2p_stat7][7]=='0' && Data_Judge1[DrawArrow2p_stat7][8]=='0' && Data_Judge1[DrawArrow2p_stat7][9]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed2p_7<Data_y1[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed2p_7>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][6]=='1')
						{
							Data_Judge1[cur+count][6]='0';
							DrawArrow2p_stat7=cur+count;
							DrawArrow2p_s7=1;
							if(Data_Judge1[DrawArrow2p_stat7][5]=='0' && Data_Judge1[DrawArrow2p_stat7][6]=='0' && Data_Judge1[DrawArrow2p_stat7][7]=='0' && Data_Judge1[DrawArrow2p_stat7][8]=='0' && Data_Judge1[DrawArrow2p_stat7][9]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}

				}
			}
		}

		if(DrawArrow2p_s9 != 0 || (PressedKey2p[9] != 0))
		{
			if(DrawArrow2p_s9==20)
			{

				DrawArrow2p_s9=0;
				DrawArrow2p_Crash9=false;
			}
			else
			{
				DrawArrow2p_s9++;
			}
			if(PressedKey2p[9] != 0)
			for(count=0;count<18;count++)
			{
				if( KDouble.ZONE_U*HighSpeed2p_9<Data_y1[cur+count] &&
						KDouble.ZONE_D*HighSpeed2p_9>Data_y1[cur+count])
				{
					if( KDouble.PERFECT_ZONE_U*HighSpeed2p_9<Data_y1[cur+count] &&
							KDouble.PERFECT_ZONE_D*HighSpeed2p_9>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][8]=='1')
						{
							Data_Judge1[cur+count][8]='0';
							DrawArrow2p_stat9=cur+count;
							DrawArrow2p_On9=true;
							DrawArrow2p_s9=1;
							if(Data_Judge1[DrawArrow2p_stat9][5]=='0' && Data_Judge1[DrawArrow2p_stat9][6]=='0' && Data_Judge1[DrawArrow2p_stat9][7]=='0' && Data_Judge1[DrawArrow2p_stat9][8]=='0' && Data_Judge1[DrawArrow2p_stat9][9]=='0' )
							{
								DrawArrow2p_Crash9=true;
								JudgeTemp=PERFECT;
							}
							break;
						}
					}
					else if( KDouble.GREAT_ZONE_U*HighSpeed2p_9<Data_y1[cur+count] &&
							KDouble.GREAT_ZONE_D*HighSpeed2p_9>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][8]=='1')
						{
							Data_Judge1[cur+count][8]='0';
							DrawArrow2p_stat9=cur+count;
							DrawArrow2p_On9=true;
							DrawArrow2p_s9=1;
							if(Data_Judge1[DrawArrow2p_stat9][5]=='0' && Data_Judge1[DrawArrow2p_stat9][6]=='0' && Data_Judge1[DrawArrow2p_stat9][7]=='0' && Data_Judge1[DrawArrow2p_stat9][8]=='0' && Data_Judge1[DrawArrow2p_stat9][9]=='0' )
							{
								DrawArrow2p_Crash9=true;
								JudgeTemp=GREAT;
							}
							break;
						}
					}
					else if( KDouble.GOOD_ZONE_U*HighSpeed2p_9<Data_y1[cur+count] &&
							KDouble.GOOD_ZONE_D*HighSpeed2p_9>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][8]=='1')
						{
							Data_Judge1[cur+count][8]='0';
							DrawArrow2p_stat9=cur+count;
							DrawArrow2p_s9=1;
							if(Data_Judge1[DrawArrow2p_stat9][5]=='0' && Data_Judge1[DrawArrow2p_stat9][6]=='0' && Data_Judge1[DrawArrow2p_stat9][7]=='0' && Data_Judge1[DrawArrow2p_stat9][8]=='0' && Data_Judge1[DrawArrow2p_stat9][9]=='0' )
							{
								JudgeTemp=GOOD;
							}
							break;
						}
					}
					else if( KDouble.BAD_ZONE_U*HighSpeed2p_9<Data_y1[cur+count] &&
							KDouble.BAD_ZONE_D*HighSpeed2p_9>Data_y1[cur+count])
					{
						if(Data_Judge1[cur+count][8]=='1')
						{
							Data_Judge1[cur+count][8]='0';
							DrawArrow2p_stat9=cur+count;
							DrawArrow2p_s9=1;
							if(Data_Judge1[DrawArrow2p_stat9][5]=='0' && Data_Judge1[DrawArrow2p_stat9][6]=='0' && Data_Judge1[DrawArrow2p_stat9][7]=='0' && Data_Judge1[DrawArrow2p_stat9][8]=='0' && Data_Judge1[DrawArrow2p_stat9][9]=='0' )
							{
								JudgeTemp=BAD;
							}
							break;
						}
					}
				}
			}

		}

		Judgement2p=JudgeTemp;

		// 미스처리입니다.
		for(count=0;count<10;count++)
		if(Data_y1[cur+count] < 40
			&& (Data_Judge1[cur+count][5]!='0' || Data_Judge1[cur+count][6]!='0' || Data_Judge1[cur+count][7]!='0' || Data_Judge1[cur+count][8]!='0' || Data_Judge1[cur+count][9]!='0')
			&& (Data1[cur+count][5]!='0' || Data1[cur+count][6]!='0' || Data1[cur+count][7]!='0' || Data1[cur+count][8]!='0' || Data1[cur+count][9]!='0' ))
		{
			if(Data1[cur+count][5]=='2')break;
			Data_Judge1[cur+count][5]=Data_Judge1[cur+count][6]=Data_Judge1[cur+count][7]=Data_Judge1[cur+count][8]=Data_Judge1[cur+count][9]='0';
			Judgement2p=MISS;
			Combo2p=0;
		}

		if(DrawArrow2p_Crash1)
		{
			if(DrawArrow2p_s1==2)if(Data_Judge1[DrawArrow2p_stat1][5]=='0' && Data_Judge1[DrawArrow2p_stat1][6]=='0' && Data_Judge1[DrawArrow2p_stat1][7]=='0' && Data_Judge1[DrawArrow2p_stat1][8]=='0' && Data_Judge1[DrawArrow2p_stat1][9]=='0' )
			{
				Data1[DrawArrow2p_stat1][5]=Data1[DrawArrow2p_stat1][6]=Data1[DrawArrow2p_stat1][7]=Data1[DrawArrow2p_stat1][8]=Data1[DrawArrow2p_stat1][9]='0';
				//Judgement2p=PERFECT;
				Judgement2p=JudgeTemp;
			}
			else Judgement2p=NONE;
		}
		if(DrawArrow2p_Crash7)
		{
			if(DrawArrow2p_s7==2)if(Data_Judge1[DrawArrow2p_stat7][5]=='0' && Data_Judge1[DrawArrow2p_stat7][6]=='0' && Data_Judge1[DrawArrow2p_stat7][7]=='0' && Data_Judge1[DrawArrow2p_stat7][8]=='0' && Data_Judge1[DrawArrow2p_stat7][9]=='0' )
			{
				Data1[DrawArrow2p_stat7][5]=Data1[DrawArrow2p_stat7][6]=Data1[DrawArrow2p_stat7][7]=Data1[DrawArrow2p_stat7][8]=Data1[DrawArrow2p_stat7][9]='0';
				//Judgement2p=PERFECT;
				Judgement2p=JudgeTemp;
			}
			else Judgement2p=NONE;
		}
		if(DrawArrow2p_Crash5)
		{
			if(DrawArrow2p_s5==2)if(Data_Judge1[DrawArrow2p_stat5][5]=='0' && Data_Judge1[DrawArrow2p_stat5][6]=='0' && Data_Judge1[DrawArrow2p_stat5][7]=='0' && Data_Judge1[DrawArrow2p_stat5][8]=='0' && Data_Judge1[DrawArrow2p_stat5][9]=='0' )
			{
				Data1[DrawArrow2p_stat5][5]=Data1[DrawArrow2p_stat5][6]=Data1[DrawArrow2p_stat5][7]=Data1[DrawArrow2p_stat5][8]=Data1[DrawArrow2p_stat5][9]='0';
				//Judgement2p=PERFECT;
				Judgement2p=JudgeTemp;
			}
			else Judgement2p=NONE;
		}
		if(DrawArrow2p_Crash9)
		{
			if(DrawArrow2p_s9==2)if(Data_Judge1[DrawArrow2p_stat9][5]=='0' && Data_Judge1[DrawArrow2p_stat9][6]=='0' && Data_Judge1[DrawArrow2p_stat9][7]=='0' && Data_Judge1[DrawArrow2p_stat9][8]=='0' && Data_Judge1[DrawArrow2p_stat9][9]=='0' )
			{
				Data1[DrawArrow2p_stat9][5]=Data1[DrawArrow2p_stat9][6]=Data1[DrawArrow2p_stat9][7]=Data1[DrawArrow2p_stat9][8]=Data1[DrawArrow2p_stat9][9]='0';
				//Judgement2p=PERFECT;
				Judgement2p=JudgeTemp;
			}
			else Judgement2p=NONE;
		}
		if(DrawArrow2p_Crash3)
		{
			if(DrawArrow2p_s3==2)if(Data_Judge1[DrawArrow2p_stat3][5]=='0' && Data_Judge1[DrawArrow2p_stat3][6]=='0' && Data_Judge1[DrawArrow2p_stat3][7]=='0' && Data_Judge1[DrawArrow2p_stat3][8]=='0' && Data_Judge1[DrawArrow2p_stat3][9]=='0' )
			{
				Data1[DrawArrow2p_stat3][5]=Data1[DrawArrow2p_stat3][6]=Data1[DrawArrow2p_stat3][7]=Data1[DrawArrow2p_stat3][8]=Data1[DrawArrow2p_stat3][9]='0';
				//Judgement2p=PERFECT;
				Judgement2p=JudgeTemp;
			}
			else Judgement2p=NONE;
		}

		if(Judgement2p==PERFECT || Judgement2p==GREAT)
		{
			if(g_dsBeat != null)
			{
				g_dsBeat.Stop();
				g_dsBeat.SetCurrentPosition(0);
				g_dsBeat.Play(0,0,0);
			}
			Combo2p++;
			if(Judgement2p==PERFECT)cPerfect2p++;
			else if(Judgement2p==GREAT)cGreat2p++;

			if(Combo2p>cMaxCombo2p)cMaxCombo2p=Combo2p;
			if(Combo2p>10)
			{
				if(Gauge2p<0)Gauge2p=1;
				else Gauge2p++;
				if(Gauge2p>42)Gauge2p=41;
			}
			DrawArrow2p_Crash1=DrawArrow2p_On1;
			DrawArrow2p_Crash3=DrawArrow2p_On3;
			DrawArrow2p_Crash5=DrawArrow2p_On5;
			DrawArrow2p_Crash7=DrawArrow2p_On7;
			DrawArrow2p_Crash9=DrawArrow2p_On9;

			DrawArrow2p_On1=DrawArrow2p_On3=DrawArrow2p_On5=DrawArrow2p_On7=DrawArrow2p_On9=false;
		}
		else if(Judgement2p==GOOD || Judgement2p==BAD || Judgement2p==MISS)
		{
			if(Judgement2p==GOOD)cGood2p++;
			else if(Judgement2p==BAD)cBad2p++;
			else if(Judgement2p==MISS)cMiss2p++;
			Combo2p=0;
		}

		if(Combo2p != 0)
		{
			if(Judgement2p==PERFECT)Score2p+=2000;
			else if(Judgement2p==GREAT)Score2p+=1500;
		}
		else
		{
			if(Judgement2p==PERFECT)Score2p+=1000;
			else if(Judgement2p==GREAT)Score2p+=500;
		}

		if(Judgement2p==GOOD)Score2p+=100;
		else if(Judgement2p==BAD)
		{
			Score2p-=700;
			Gauge2p-=2;
		}
		else if(Judgement2p==MISS)
		{
			Score2p-=1000;
			Gauge2p-=5;
		}

		if(KCFG.bcDead)
		{
			if(Couple)
			{
				if(Gauge1p<-40 && Gauge2p<-40)
				{
					if(SongFlag)
					{
						SongFlag=false;
					}
					g_programState=DEAD;
				}
			}
			else
			{
				if(Gauge2p<-40)
				{
					if(SongFlag)
					{
						SongFlag=false;
					}
					g_programState=DEAD;
				}
			}
		}

		if(Score2p<0)Score2p=0;

		if (DrawArrow2p_beat != 0)
			g_pDDSBack.BltFast(352,50,Arrow2,null,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else
			g_pDDSBack.BltFast(352,50,Arrow1,null,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		DrawArrow2p_pArr1.top=0;
		DrawArrow2p_pArr1.left=DrawArrow2p_arrow_l[DrawArrow2p_s1];
		DrawArrow2p_pArr1.right=DrawArrow2p_arrow_r[DrawArrow2p_s1];
		DrawArrow2p_pArr1.bottom=70;

		DrawArrow2p_pArr3.top=0;
		DrawArrow2p_pArr3.left=DrawArrow2p_arrow_l[DrawArrow2p_s3];
		DrawArrow2p_pArr3.right=DrawArrow2p_arrow_r[DrawArrow2p_s3];
		DrawArrow2p_pArr3.bottom=70;

		DrawArrow2p_pArr5.top=0;
		DrawArrow2p_pArr5.left=DrawArrow2p_arrow_l[DrawArrow2p_s5];
		DrawArrow2p_pArr5.right=DrawArrow2p_arrow_r[DrawArrow2p_s5];
		DrawArrow2p_pArr5.bottom=70;

		DrawArrow2p_pArr7.top=0;
		DrawArrow2p_pArr7.left=DrawArrow2p_arrow_l[DrawArrow2p_s7];
		DrawArrow2p_pArr7.right=DrawArrow2p_arrow_r[DrawArrow2p_s7];
		DrawArrow2p_pArr7.bottom=70;

		DrawArrow2p_pArr9.top=0;
		DrawArrow2p_pArr9.left=DrawArrow2p_arrow_l[DrawArrow2p_s9];
		DrawArrow2p_pArr9.right=DrawArrow2p_arrow_r[DrawArrow2p_s9];
		DrawArrow2p_pArr9.bottom=70;

		DrawArrow2p_cArr1.top=0;
		DrawArrow2p_cArr1.left=DrawArrow2p_Carrow_l[DrawArrow2p_s1];
		DrawArrow2p_cArr1.right=DrawArrow2p_Carrow_r[DrawArrow2p_s1];
		DrawArrow2p_cArr1.bottom=80;

		DrawArrow2p_cArr3.top=0;
		DrawArrow2p_cArr3.left=DrawArrow2p_Carrow_l[DrawArrow2p_s3];
		DrawArrow2p_cArr3.right=DrawArrow2p_Carrow_r[DrawArrow2p_s3];
		DrawArrow2p_cArr3.bottom=80;

		DrawArrow2p_cArr5.top=0;
		DrawArrow2p_cArr5.left=DrawArrow2p_Carrow_l[DrawArrow2p_s5];
		DrawArrow2p_cArr5.right=DrawArrow2p_Carrow_r[DrawArrow2p_s5];
		DrawArrow2p_cArr5.bottom=80;

		DrawArrow2p_cArr7.top=0;
		DrawArrow2p_cArr7.left=DrawArrow2p_Carrow_l[DrawArrow2p_s7];
		DrawArrow2p_cArr7.right=DrawArrow2p_Carrow_r[DrawArrow2p_s7];
		DrawArrow2p_cArr7.bottom=80;

		DrawArrow2p_cArr9.top=0;
		DrawArrow2p_cArr9.left=DrawArrow2p_Carrow_l[DrawArrow2p_s9];
		DrawArrow2p_cArr9.right=DrawArrow2p_Carrow_r[DrawArrow2p_s9];
		DrawArrow2p_cArr9.bottom=80;

		if(DrawArrow2p_Crash1)g_pDDSBack.BltFast(345,43,cArrow1,DrawArrow2p_cArr1,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow2p_s1 != 0)g_pDDSBack.BltFast(347,45,pArrow1,DrawArrow2p_pArr1,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow2p_Crash7)g_pDDSBack.BltFast(395,43,cArrow7,DrawArrow2p_cArr7,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow2p_s7 != 0)g_pDDSBack.BltFast(397,45,pArrow7,DrawArrow2p_pArr7,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow2p_Crash5)g_pDDSBack.BltFast(445,43,cArrow5,DrawArrow2p_cArr5,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow2p_s5 != 0)g_pDDSBack.BltFast(447,45,pArrow5,DrawArrow2p_pArr5,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow2p_Crash9)g_pDDSBack.BltFast(495,43,cArrow9,DrawArrow2p_cArr9,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow2p_s9 != 0)g_pDDSBack.BltFast(497,45,pArrow9,DrawArrow2p_pArr9,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);

		if(DrawArrow2p_Crash3)g_pDDSBack.BltFast(545,43,cArrow3,DrawArrow2p_cArr3,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
		else if(DrawArrow2p_s3 != 0)g_pDDSBack.BltFast(547,45,pArrow3,DrawArrow2p_pArr3,DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY);
	}

	static private HRESULT	RestoreAll() {
		HRESULT	hRet;
		hRet=g_pDDSPrimary.Restore();
		return hRet;
	}

	static private void Flipp() {
		HRESULT hRet;

		while(true)	{
			if(g_fullscreen)
				hRet=g_pDDSPrimary.Flip(null,DDFLIP_WAIT);
			else
				hRet = g_pDDSPrimary.Blt(g_rcScreen, g_pDDSBack,
	                                                  g_rcViewport, DDBLT_WAIT,
	                                                  null);
			if(hRet==HRESULT.DD_OK)
				break;

			if(hRet == HRESULT.DDERR_SURFACELOST) {
				hRet=RestoreAll();
				if(hRet != HRESULT.DD_OK)
					break;
			}
			if(hRet != HRESULT.DDERR_WASSTILLDRAWING)
				break;
		}
	}

	static private boolean InitDSound(HWND hWnd, int Samples, int Bits, int nChannels)
	{
		HRESULT			hRet;

		hRet=DirectSoundCreate(null,lpds,null);

		if(hRet != HRESULT.DD_OK)
			InitFail(hWnd,hRet,"Cannot create Dsound");

		hRet=lpds.SetCooperativeLevel(hWnd,DSSCL_NORMAL);

		if(hRet != HRESULT.DD_OK)
			InitFail(hWnd,hRet,"Cannot cooperative (sound)");

		DisplayMessage(0,16,"Loading Music Intro File.. please Wait...");
		return true;

	}

	static private void ReleaseDSound() {
		/*
		int i;
		for(i=0;i<512;i++)
		{
			if(CSONG[i].Int_Song != null)
			{
				CSONG[i].Int_Song.Release();
				CSONG[i].Int_Song = null;
			}
		}

		if (lpdsbd != NULL)
		{
			lpdsbd->Release();
			lpdsbd = NULL;
		}
		if (g_DJVOICE_BUFFER != NULL)
		{
			g_DJVOICE_BUFFER->Release();
			g_DJVOICE_BUFFER = NULL;
		}
		if (g_PUMPSONG_BUFFER != NULL)
		{
			g_PUMPSONG_BUFFER->Release();
			g_PUMPSONG_BUFFER = NULL;
		}
		if (g_dsOpening != NULL)
		{
			g_dsOpening->Release();
			g_dsOpening = NULL;
		}
		if (g_Select_Song != NULL)
		{
			g_Select_Song->Release();
			g_Select_Song = NULL;
		}
		if (g_Cur_Song != NULL)
		{
			g_Cur_Song->Release();
			g_Cur_Song = NULL;
		}
		if (g_dsDead != NULL)
		{
			g_dsDead->Release();
			g_dsDead = NULL;
		}
	*/
		if(lpds != null)
			lpds.Release();
	}

	static private void ReleaseAllObjects()
	{
	    if (g_pDD != null)
	    {
	        if (g_pDDSPrimary != null)
	        {
	            g_pDDSPrimary.Release();
	            g_pDDSPrimary = null;
	        }
			if (GameTITLE != null)
			{
				GameTITLE.Release();
				GameTITLE = null;
			}
			if (background != null)
			{
				background.Release();
				background = null;
			}
			if (songTitle != null)
			{
				songTitle.Release();
				songTitle = null;
			}

			if (songBack != null)
			{
				songBack.Release();
				songBack = null;
			}
			if (SelectBack != null)
			{
				SelectBack.Release();
				SelectBack = null;
			}
			if (JudgeFont != null)
			{
				JudgeFont.Release();
				JudgeFont = null;
			}
			if (NumberFont != null)
			{
				NumberFont.Release();
				NumberFont = null;
			}
			if (ComboFont != null)
			{
				ComboFont.Release();
				ComboFont = null;
			}
			if (NoDISC != null)
			{
				NoDISC.Release();
				NoDISC = null;
			}
			if (ShiftLeft != null)
			{
				ShiftLeft.Release();
				ShiftRight = null;
			}
			if (ShiftRight != null)
			{
				ShiftRight.Release();
				ShiftRight = null;
			}
			if (GaugeWaku != null)
			{
				GaugeWaku.Release();
				GaugeWaku = null;
			}
			if (Gauge != null)
			{
				Gauge.Release();
				Gauge = null;
			}
			if (SmallFont != null)
			{
				SmallFont.Release();
				SmallFont = null;
			}
			if (Arrow1 != null)
			{
				Arrow1.Release();
				Arrow1 = null;
			}
			if (Arrow2 != null)
			{
				Arrow2.Release();
				Arrow2 = null;
			}
			if (wArrow != null)
			{
				wArrow.Release();
				wArrow = null;
			}
			if (pArrow1 != null)
			{
				pArrow1.Release();
				pArrow1 = null;
			}
			if (pArrow3 != null)
			{
				pArrow3.Release();
				pArrow3 = null;
			}
			if (pArrow5 != null)
			{
				pArrow5.Release();
				pArrow5 = null;
			}
			if (pArrow7 != null)
			{
				pArrow7.Release();
				pArrow7 = null;
			}
			if (pArrow9 != null)
			{
				pArrow9.Release();
				pArrow9 = null;
			}
			if(	cArrow1	!= null)
			{
				cArrow1.Release();
				cArrow1 = null;
			}
			if(	cArrow3	!= null)
			{
				cArrow3.Release();
				cArrow3 = null;
			}
			if(	cArrow5	!= null)
			{
				cArrow5.Release();
				cArrow5 = null;
			}
			if(	cArrow7	!= null)
			{
				cArrow7.Release();
				cArrow7 = null;
			}
			if(	cArrow9	!= null)
			{
				cArrow9.Release();
				cArrow9 = null;
			}
			if(	ModeIcon != null)
			{
				ModeIcon.Release();
				ModeIcon = null;
			}
			if( g_cFont != null)
			{
				g_cFont.Release();
				g_cFont = null;
			}
			if( ResultFont != null)
			{
				ResultFont.Release();
				ResultFont = null;
			}
			if( ResultBack != null)
			{
				ResultBack.Release();
				ResultBack = null;
			}
			if( StageCount != null)
			{
				StageCount.Release();
				StageCount = null;
			}
			if( Score != null)
			{
				Score.Release();
				Score = null;
			}
			if( DeadScreen != null)
			{
				DeadScreen.Release();
				DeadScreen = null;
			}
			if( GameOver != null)
			{
				GameOver.Release();
				GameOver=null;
			}
			if( Logo != null)
			{
				Logo.Release();
				Logo=null;
			}
			if( Diff != null)
			{
				Diff.Release();
				Diff=null;
			}
			if( DoubleIcon != null)
			{
				DoubleIcon.Release();
				DoubleIcon=null;
			}
			if( CrazyIcon != null)
			{
				CrazyIcon.Release();
				CrazyIcon=null;
			}
			if( EasyIcon != null)
			{
				EasyIcon.Release();
				EasyIcon=null;
			}
			if( HardIcon != null)
			{
				HardIcon.Release();
				HardIcon=null;
			}
	        g_pDD.Release();
	        g_pDD = null;

			ReleaseDSound();
			CleanupInput();
		}
	}


	static private long UpdateFrame_lastTime, UpdateFrame_fpsTime,UpdateFrame_framesRendered,UpdateFrame_fps;
	static private void UpdateFrame()	{
		// FPS count start
		// static long lastTime, fpsTime,framesRendered,fps;

		long	cur = timeGetTime();
		long	deltaTime = cur - UpdateFrame_lastTime;
		UpdateFrame_lastTime = cur;

		UpdateFrame_fpsTime += deltaTime;

		++UpdateFrame_framesRendered;

		if(UpdateFrame_fpsTime>1000) {
			UpdateFrame_fps = UpdateFrame_framesRendered;
			UpdateFrame_framesRendered = 0;
			UpdateFrame_fpsTime = 0;
		}

		// FPS count & print end
		DisplayMessage(583,463,String.format("FPS:%3d",UpdateFrame_fps));

		switch(g_programState)
		{
			case GAMETITLE:
				StageTitle();
				break;
			case SELECTSONG:
				SelectSong();
				break;
			case STAGE1:
				KIU_STAGE();
				break;
			case DOUBLE:
				KIU_STAGE_DOUBLE();
				break;
			case COUPLE:
				KIU_STAGE();
				break;
			case DEAD:
				Dead();
				break;
			case CONFIG:
				Configuration();
				break;
			case RESULT:
				Result();
				break;
			case GAMEOVER:
				GameOver1();
				break;
			case END:
				PostMessage(hWnd, WM_CLOSE, 0, 0);
				break;
			default:
				break;
		}

	}

	static private long WindowProc(HWND hWnd, int message, long wParam, long lParam)
	{
		switch (message)
	    {
				case WM_MOVE:
					if(!g_fullscreen)
					{
						GetClientRect(hWnd, g_rcViewport);
						GetClientRect(hWnd, g_rcScreen);
						ClientToScreen(hWnd, g_rcScreen.left);
						ClientToScreen(hWnd, g_rcScreen.right);
					}
					break;
				/*case WM_PAINT:
					UpdateFrame();
					break;*/

				case WM_ACTIVATEAPP:
					g_bActive=wParam != 0;
					break;

				case WM_KEYDOWN:
	            // Handle any non-accelerated key commands
	            switch ((int)wParam)
	            {
					case VK_F12:
						PostMessage(hWnd, WM_CLOSE, 0, 0);
						return 0L;
	/* SelectSong, StageTitle에서 참조합니다.
	   추후에 바꿔주어야 합니다.
	   */
					case VK_F2:
						First=0;
						switch(g_programState)
						{
							case GAMETITLE:
								First=0;
								if(g_dsOpening != null)
									g_dsOpening.Stop();
								g_programState=CONFIG;

								break;

							case SELECTSONG:
								g_programState=CONFIG;
								if(IntroFlag){
									IntroFlag=false;
								}
								if(g_dsSelectSong != null)
									g_dsSelectSong.Stop();
								First=0;
								break;

							case STAGE1:
								if(SongFlag)
								{
									SongFlag=false;
								}
								g_programState=CONFIG;
								break;
							case DOUBLE:
								if(SongFlag)
								{
									SongFlag=false;
								}
								g_programState=CONFIG;
								break;
							case COUPLE:
								if(SongFlag)
								{
									SongFlag=false;
								}
								g_programState=CONFIG;
								break;
							case CONFIG:
								g_programState=CONFIG;
								break;
						}
						break;

					case VK_UP:
						switch(g_programState)
						{
							case GAMETITLE:
								PressedKey2p[0]=8;
								break;
							case SELECTSONG:
								PressedKey2p[0]=8;
								break;
							case CONFIG:
								PressedKey2p[0]=8;
								break;
						}
						break;
					case VK_DOWN:
						switch(g_programState)
						{
							case GAMETITLE:
								PressedKey2p[0]=2;
								break;
							case SELECTSONG:
								PressedKey2p[0]=2;
							case CONFIG:
								PressedKey2p[0]=2;
								break;
						}
						break;

					case VK_LEFT:
						switch(g_programState)
						{
							case SELECTSONG:
								PressedKey2p[0]=4;
								break;
							case CONFIG:
								PressedKey2p[0]=4;
								break;
						}
						break;
					case VK_RIGHT:
						switch(g_programState)
						{
							case SELECTSONG:
								PressedKey2p[0]=6;
								break;
							case CONFIG:
								PressedKey2p[0]=6;
								break;
						}
						break;

					case VK_RETURN:
						switch(g_programState)
						{
							case SELECTSONG:
								PressedKey2p[0]=3;
								break;
							case CONFIG:
								PressedKey2p[0]=3;
								break;
						}
						break;

	/* 여기까지 입니다. */

					case VK_ESCAPE:
					{
						switch(g_programState)
						{
							case GAMETITLE:
								CFGWrite();
								PostMessage(hWnd, WM_CLOSE, 0, 0);
								return 0L;

							case SELECTSONG:
								g_programState=GAMETITLE;
								if(IntroFlag){
									IntroFlag=false;
								}
								if(g_dsSelectSong != null)
									g_dsSelectSong.Stop();
								First=0;
								break;

							case STAGE1:
								if(SongFlag) {
									SongFlag=false;
								}
								First=0;
								g_programState=RESULT;
								break;
							case DOUBLE:
								if(SongFlag) {
									SongFlag=false;
								}
								First=0;
								g_programState=RESULT;
								break;
							case COUPLE:
								if(SongFlag)
								{
									SongFlag=false;
								}
								First=0;
								g_programState=RESULT;
								break;
							case CONFIG:
								First=0;
								CFGWrite();
								g_programState=GAMETITLE;
								break;
							case RESULT:
								First=0;
								g_programState=SELECTSONG;
								break;
						}
					}

				}
	            break;

				case WM_DESTROY:
					ReleaseAllObjects();
					PostQuitMessage(0);
					return 0L;
				case WM_SETCURSOR:
	            // Turn off the cursor since this is a full-screen app
		            SetCursor(null);
	            return 1;
	    }
	    return DefWindowProc(hWnd, message, wParam, lParam);
	}

	HRESULT InitFail(HWND hWnd, HRESULT hRet, String szError, Object... args) {
		ReleaseAllObjects();
		MessageBox(hWnd, String.format(szError, args), TITLE, MB_OK);
		DestroyWindow(hWnd);
		return hRet;
	}

	static private HRESULT	InitWin(HINSTANCE hInstance, long Width, long Height, int nCmdShow)
	{
		WNDCLASS	wc = new WNDCLASS();

		long		dwExStyle;				// Window Extended Style
		long		dwStyle;				// Window Style

		RECT		WindowRect = new RECT();				// Grabs Rectangle Upper Left / Lower Right Values
		WindowRect.left=(long)0;			// Set Left Value To 0
		WindowRect.right=(long)Width;		// Set Right Value To Requested Width
		WindowRect.top=(long)0;				// Set Top Value To 0
		WindowRect.bottom=(long)Height;		// Set Bottom Value To Requested Height

	// Detect os version (for title bar)
		OSVERSIONINFO osver = new OSVERSIONINFO();

		// osver.dwOSVersionInfoSize=sizeof(osver);
		GetVersionEx(osver);
	// Os ver detect finished.

		// Set up and register window class
	    wc.style = CS_HREDRAW | CS_VREDRAW;
	    wc.lpfnWndProc = null;		    // TODO wc.lpfnWndProc = WindowProc;
	    wc.cbClsExtra = 0;
	    wc.cbWndExtra = 0;
	    wc.hInstance = hInstance;
	    wc.hIcon = LoadIcon(0, IDI_ICON);
	    wc.hCursor = LoadCursor(null, IDC_ARROW);
	    // wc.hbrBackground = (HBRUSH )GetStockObject(BLACK_BRUSH);
	    wc.lpszMenuName = PRGNAME;
	    wc.lpszClassName = PRGNAME;

	    RegisterClass(wc);

		if (g_fullscreen)												// Are We Still In Fullscreen Mode?
		{
			dwExStyle=WS_EX_APPWINDOW;								// Window Extended Style
			dwStyle=WS_POPUP;										// Windows Style
			ShowCursor(false);										// Hide Mouse Pointer
		}
		else
		{
			dwExStyle=WS_EX_APPWINDOW | WS_EX_WINDOWEDGE;			// Window Extended Style
			dwStyle=WS_POPUP | WS_SYSMENU | WS_CAPTION;							// Windows Style
		}

		AdjustWindowRectEx(WindowRect, dwStyle, false, dwExStyle);		// Adjust Window To True Requested Size

		TITLE = String.format("KICK IT UP! beta version v%s - Minor release" ,VER_NUM);

	    // Create a window
	    hWnd = CreateWindowEx(dwExStyle ,
								PRGNAME,
								TITLE,
								dwStyle,
								0, 0,								// Window Position
								WindowRect.right-WindowRect.left,	// Calculate Window Width
								WindowRect.bottom-WindowRect.top,	// Calculate Window Height
								null,
								null,
								hInstance,
								null);
	    if (hWnd != null)
	        return HRESULT.DDERR_SURFACELOST;
	    ShowWindow(hWnd, nCmdShow);
	    UpdateWindow(hWnd);
	    SetFocus(hWnd);

		g_hInst=hInstance;
		return HRESULT.DD_OK;

	}

	static private HRESULT InitDD() {
		DDSURFACEDESC			ddsd = new DDSURFACEDESC();
		DDSCAPS					ddscaps = new DDSCAPS();

		HRESULT					hRet;

		LPDIRECTDRAWCLIPPER		pClipper = new LPDIRECTDRAWCLIPPER();

		hRet=DirectDrawCreate(null,g_pDD,null);
		if(hRet != HRESULT.DD_OK)
			return	InitFail(hWnd,hRet,"Cannot Creat DirectDraw");

		if(g_fullscreen) {
			hRet=g_pDD.SetCooperativeLevel(hWnd,DDSCL_EXCLUSIVE|DDSCL_FULLSCREEN|DDSCL_ALLOWREBOOT);
			if(hRet != HRESULT.DD_OK)
				return InitFail(hWnd,hRet,"Cannot set cooperative");

			hRet=g_pDD.SetDisplayMode(640,480,16);
			if(hRet != HRESULT.DD_OK)
				return InitFail(hWnd,hRet,"Cannot set display mode");

			// Create the primary surface
//			ddsd.dwSize = sizeof(ddsd);
//			ddsd.dwFlags = DDSD_CAPS | DDSD_BACKBUFFERCOUNT;
//			ddsd.ddsCaps.dwCaps = DDSCAPS_PRIMARYSURFACE |
//								  DDSCAPS_FLIP |
//								  DDSCAPS_COMPLEX;
//			ddsd.dwBackBufferCount = 2;
			g_pDD.CreateSurface(ddsd,g_pDDSPrimary,null);

//			ddsd.ddsCaps.dwCaps=DDSCAPS_OFFSCREENPLAIN;

			// Get a pointer to the back buffer
//			ddscaps.dwCaps = DDSCAPS_BACKBUFFER;
			hRet=g_pDDSPrimary.GetAttachedSurface(ddscaps, g_pDDSBack);
			if(hRet != HRESULT.DD_OK)
			{
				return InitFail(hWnd,hRet,"Cannot Attached surface");
			}
		}
		else
		{
			hRet=g_pDD.SetCooperativeLevel(hWnd,DDSCL_NORMAL);
			if(hRet != HRESULT.DD_OK)
				return InitFail(hWnd,hRet,"Cannot set cooperative");

	    	GetClientRect(hWnd, g_rcViewport);
	    	GetClientRect(hWnd, g_rcScreen);
	    	ClientToScreen(hWnd, g_rcScreen.left);
	    	ClientToScreen(hWnd, g_rcScreen.right);

			// Create the primary surface
//			ddsd.dwSize = sizeof(ddsd);
//			ddsd.dwFlags = DDSD_CAPS ;
//			ddsd.ddsCaps.dwCaps = DDSCAPS_PRIMARYSURFACE;

			g_pDD.CreateSurface(ddsd,g_pDDSPrimary,null);

			hRet=g_pDD.CreateClipper(0, pClipper, null);

			if(hRet != HRESULT.DD_OK)
			return InitFail(hWnd,hRet,"CreateClipper() : FAILED");

			pClipper.SetHWnd(0, hWnd);
//		MessageBox(hWnd, "hi","hi", MB_OK);

			g_pDDSPrimary.SetClipper(pClipper);

			pClipper.Release();
			pClipper=null;

//	        ddsd.dwFlags        = DDSD_WIDTH | DDSD_HEIGHT | DDSD_CAPS;
//	        ddsd.dwWidth        = 640;
//	        ddsd.dwHeight       = 480;
//			ddsd.ddsCaps.dwCaps=DDSCAPS_OFFSCREENPLAIN;

			// Get a pointer to the back buffer
			//ddscaps.dwCaps = DDSCAPS_BACKBUFFER;
	        hRet = g_pDD.CreateSurface(ddsd, g_pDDSBack, null);
			if(hRet != HRESULT.DD_OK)
				return InitFail(hWnd,hRet,"Cannot Attached surface");
		}
		return	hRet;
	}

	static public HRESULT KLoadImage()
	{
		// Loading image here

		SmallFont=DDLoadBitmap(g_pDD,"images\\sfont.bmp",0,0);
		if(SmallFont==null)
		{
			MessageBox(hWnd,"Cannot Load Font.","ERROR",0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(SmallFont,CLR_INVALID);

		DisplayMessage(0,0,"Loading Image");

		GameTITLE = DDLoadBitmap(g_pDD,"images\\Title.bmp",0,0);
		if(GameTITLE == null)
		{
			MessageBox(hWnd,"Cannot Load GAMETITLE","ERROR",0);
			return HRESULT.DD_ERROR;
		}

		background = DDLoadBitmap(g_pDD,"images\\back.bmp",0,0);
		if(background==null)
		{
			MessageBox(hWnd,"Cannot Load background.","ERROR",0);
			return HRESULT.DD_ERROR;
		}

		SelectBack = DDLoadBitmap(g_pDD,"images\\SelectBack.bmp",0,0);
		if(SelectBack==null)
		{
			MessageBox(hWnd,"Cannot Load Select background.","ERROR",0);
			return HRESULT.DD_ERROR;
		}

		JudgeFont = DDLoadBitmap(g_pDD,"images\\Judgement.bmp",0,0);
		if(JudgeFont==null)
		{
			MessageBox(hWnd,"Cannot Load Judgement Font.","ERROR",0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(JudgeFont,CLR_INVALID);

		NumberFont = DDLoadBitmap(g_pDD,"images\\Number.bmp",0,0);
		if(NumberFont==null)
		{
			MessageBox(hWnd,"Cannot Load Number Font.","ERROR",0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(NumberFont,CLR_INVALID);

		ComboFont = DDLoadBitmap(g_pDD,"images\\Combo.bmp",0,0);
		if(ComboFont==null)
		{
			MessageBox(hWnd,"Cannot Load Combo Font.","ERROR",0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(ComboFont,CLR_INVALID);

		NoDISC=DDLoadBitmap(g_pDD,"images\\nodisc.bmp",0,0);
		if(NoDISC==null)
		{
			MessageBox(hWnd,"Cannot Load NoDISC.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(NoDISC,CLR_INVALID);

		ShiftLeft=DDLoadBitmap(g_pDD,"images\\Shiftl.bmp",0,0);
		if(ShiftLeft==null)
		{
			MessageBox(hWnd,"Cannot Load Shiftl.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(ShiftLeft,CLR_INVALID);

		ShiftRight=DDLoadBitmap(g_pDD,"images\\Shiftr.bmp",0,0);
		if(ShiftRight==null)
		{
			MessageBox(hWnd,"Cannot Load Shiftr.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(ShiftRight,CLR_INVALID);

		GaugeWaku=DDLoadBitmap(g_pDD,"images\\GaugeWaku.bmp",0,0);
		if(GaugeWaku==null)
		{
			MessageBox(hWnd,"Cannot Load GaugeWaku.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(GaugeWaku,CLR_INVALID);

		Gauge=DDLoadBitmap(g_pDD,"images\\Gauge.bmp",0,0);
		if(Gauge==null)
		{
			MessageBox(hWnd,"Cannot Load Gauge.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Gauge,CLR_INVALID);

		Arrow1=DDLoadBitmap(g_pDD,IDB_ARROW1,0,0);
		if(Arrow1==null)
		{
			MessageBox(hWnd,"Cannot Load Arrow1.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Arrow1,CLR_INVALID);
		Arrow2=DDLoadBitmap(g_pDD,IDB_ARROW2,0,0);
		if(Arrow2==null)
		{
			MessageBox(hWnd,"Cannot Load arrow2.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Arrow2,CLR_INVALID);

		wArrow=DDLoadBitmap(g_pDD,ID_ARROW,0,0);
		if(wArrow==null)
		{
			MessageBox(hWnd,"Cannot Load arrow.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(wArrow,CLR_INVALID);
		CKey_Arr=DDColorMatch(wArrow,CLR_INVALID);

		pArrow1=DDLoadBitmap(g_pDD,IDB_PARROW1,0,0);
		if(pArrow1==null)
		{
			MessageBox(hWnd,"Cannot Load pArrow.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(pArrow1,CLR_INVALID);

		pArrow3=DDLoadBitmap(g_pDD,IDB_PARROW3,0,0);
		if(pArrow3==null)
		{
			MessageBox(hWnd,"Cannot Load pArrow.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(pArrow3,CLR_INVALID);

		pArrow5=DDLoadBitmap(g_pDD,IDB_PARROW5,0,0);
		if(pArrow5==null)
		{
			MessageBox(hWnd,"Cannot Load pArrow5.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(pArrow5,CLR_INVALID);

		pArrow7=DDLoadBitmap(g_pDD,IDB_PARROW7,0,0);
		if(pArrow7==null)
		{
			MessageBox(hWnd,"Cannot Load pArrow7.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(pArrow7,CLR_INVALID);
		pArrow9=DDLoadBitmap(g_pDD,IDB_PARROW9,0,0);
		if(pArrow9==null)
		{
			MessageBox(hWnd,"Cannot Load pArrow9.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(pArrow9,CLR_INVALID);

		cArrow1=DDLoadBitmap(g_pDD,IDB_CARROW1,0,0);
		if(cArrow1==null)
		{
			MessageBox(hWnd,"Cannot Load cArrow.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(cArrow1,CLR_INVALID);
		cArrow3=DDLoadBitmap(g_pDD,IDB_CARROW3,0,0);
		if(cArrow3==null)
		{
			MessageBox(hWnd,"Cannot Load cArrow.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(cArrow3,CLR_INVALID);

		cArrow5=DDLoadBitmap(g_pDD,IDB_CARROW5,0,0);
		if(cArrow5==null)
		{
			MessageBox(hWnd,"Cannot Load cArrow5.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(cArrow5,CLR_INVALID);

		cArrow7=DDLoadBitmap(g_pDD,IDB_CARROW7,0,0);
		if(cArrow7==null)
		{
			MessageBox(hWnd,"Cannot Load cArrow7.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(cArrow7,CLR_INVALID);
		cArrow9=DDLoadBitmap(g_pDD,IDB_CARROW9,0,0);
		if(cArrow9==null)
		{
			MessageBox(hWnd,"Cannot Load cArrow9.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(cArrow9,CLR_INVALID);
		ModeIcon=DDLoadBitmap(g_pDD, "images\\ModeIcon.bmp",0,0);
		if(ModeIcon==null)
		{
			MessageBox(hWnd,"Cannot Load ModeIcon.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(ModeIcon, CLR_INVALID);
		g_cFont=DDLoadBitmap(g_pDD, "images\\CFont.bmp",0,0);
		if(g_cFont==null)
		{
			MessageBox(hWnd,"Cannot Load CFont.bmp",0,0);
			return	HRESULT.DD_ERROR;
		}
		DDSetColorKey(g_cFont, CLR_INVALID);
		CKey_CFont=DDColorMatch(g_cFont,CLR_INVALID);

		ResultFont=DDLoadBitmap(g_pDD, "images\\ResFont.bmp",0,0);
		if(ResultFont==null)
		{
			MessageBox(hWnd,"Cannot Load ResFont.bmp",0,0);
			return	HRESULT.DD_ERROR;
		}
		DDSetColorKey(ResultFont, CLR_INVALID);
		ResultBack=DDLoadBitmap(g_pDD, "images\\ResBack.bmp",0,0);
		if(ResultBack==null)
		{
			MessageBox(hWnd,"Cannot Load ResBack.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		StageCount=DDLoadBitmap(g_pDD, "images\\StageCount.bmp",0,0);
		if(StageCount==null)
		{
			MessageBox(hWnd,"Cannot Load StageCount.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(StageCount, CLR_INVALID);

		Score=DDLoadBitmap(g_pDD,"images\\Score.bmp",0,0);
		if(Score==null)
		{
			MessageBox(hWnd,"Cannot Load Score.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Score,CLR_INVALID);

		DeadScreen=DDLoadBitmap(g_pDD,"images\\Dead.bmp",0,0);
		if(DeadScreen==null)
		{
			MessageBox(hWnd,"Cannot Load DeadScreen.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		GameOver=DDLoadBitmap(g_pDD,"images\\GameOver.bmp",0,0);
		if(GameOver==null)
		{
			MessageBox(hWnd,"Cannot Load GameOver.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		Logo=DDLoadBitmap(g_pDD,"images\\Logo.bmp",0,0);
		if(Logo==null)
		{
			MessageBox(hWnd,"Cannot Load Logo.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Logo,CLR_INVALID);
		Diff=DDLoadBitmap(g_pDD,"images\\Diff.bmp",0,0);
		if(Diff==null)
		{
			MessageBox(hWnd,"Cannot Load Diff.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(Diff,CLR_INVALID);
		DoubleIcon=DDLoadBitmap(g_pDD,"images\\DoubleIcon.bmp",0,0);
		if(DoubleIcon==null)
		{
			MessageBox(hWnd,"Cannot Load DoubleIcon.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(DoubleIcon,CLR_INVALID);
		CrazyIcon=DDLoadBitmap(g_pDD,"images\\CrazyIcon.bmp",0,0);
		if(CrazyIcon==null)
		{
			MessageBox(hWnd,"Cannot Load CrazyIcon.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(CrazyIcon,CLR_INVALID);
		EasyIcon=DDLoadBitmap(g_pDD,"images\\EasyIcon.bmp",0,0);
		if(EasyIcon==null)
		{
			MessageBox(hWnd,"Cannot Load EasyIcon.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(EasyIcon,CLR_INVALID);
		HardIcon=DDLoadBitmap(g_pDD,"images\\HardIcon.bmp",0,0);
		if(HardIcon==null)
		{
			MessageBox(hWnd,"Cannot Load HardIcon.bmp",0,0);
			return HRESULT.DD_ERROR;
		}
		DDSetColorKey(HardIcon,CLR_INVALID);

		return HRESULT.DD_OK;
	}

	static private int WinMain(HINSTANCE hInstance,HINSTANCE hPrevInstance, String lpCmdLine,int nCmdShow)
	{
	    MSG	msg = MSG.wParam;

	    /*
	// Debug File name definition
		long	ltime;
		long 	today;

		time(ltime);
		today=localtime(&ltime);
		g_szDebugName = String.format("%d%d%d.txt",today->tm_year+1900, today->tm_mon+1, today->tm_mday);
	// define end :)
	 *
	 */

		CoInitialize(null);

		if(InitWin(hInstance, 640, 480, nCmdShow) != HRESULT.DD_OK)
			return 1;

		if(InitDD() != HRESULT.DD_OK)return 1;
		if(KLoadImage() != HRESULT.DD_OK)return 1;

		Read();
	 	if(InitDSound(hWnd,22050,8,2))return 1;

		WaveSet_Loading();
	 	if(InitDI(hInstance) != HRESULT.DD_OK)return 1;

		CFGInitialize();

		while (true)
	    {
	        if (PeekMessage(msg, null, 0, 0, PM_NOREMOVE))
	        {
	            if (!GetMessage(msg, null, 0, 0))
	            	return -1;//return msg.wParam;
	            TranslateMessage(msg);
	            DispatchMessage(msg);
	        }
	        else if (g_bActive)
	        {
	            UpdateFrame();
	        }
	        else
	        {
	            // Make sure we go to sleep if we have nothing else to do
	            WaitMessage();
	        }
	    }

	}

	static private HRESULT TransAlphaImproved(
			LPDIRECTDRAWSURFACE src, LPDIRECTDRAWSURFACE dest, int lDestX, int lDestY, RECT srcRect, int ALPHA, long ColorKey, int BPP) {
		int register, i,j;
		int height,width;
		char [] lpSprite;
		char [] lpDest;
		int dPitch, SpritePitch;
		long sColorKey;
		long sTemp = 0,dTemp = 0;
		long sr,sg,sb,dr,dg,db;
		int sbuf,dbuf;
		long Result;
		boolean oddWidth = false;
		DDSURFACEDESC srcDDSD = new DDSURFACEDESC(), destDDSD = new DDSURFACEDESC();
		long REDC,GREENC, BLUEC;
		long PLUS64;
		long ALPHABY4;
		long doubleColorKey;

		// Check the ALPHA value
		if (ALPHA < 0)
			ALPHA = 0;
		else if (ALPHA > 256)
			ALPHA = 256;

		// Set height and width of SPRITE
		height = (int)(srcRect.bottom - srcRect.top);
		width = (int)(srcRect.right - srcRect.left);

		// Lock down both surfaces for read and write
		// memset(&srcDDSD, 0, sizeof(srcDDSD));
		/// srcDDSD.dwSize = sizeof(srcDDSD);
		src.Lock(null, srcDDSD, DDLOCK_WAIT, null);

		// memset(&destDDSD, 0, sizeof(destDDSD));
		// destDDSD.dwSize = sizeof(destDDSD);
		dest.Lock(null, destDDSD, DDLOCK_WAIT, null);

		// Get the color key for sprite surface
		sColorKey = ColorKey;

		// Set the pitch for both surfaces
		SpritePitch = (int)srcDDSD.lPitch;
		dPitch      = (int)destDDSD.lPitch;

		// Initialize the pointers to the upper left hand corner of surface
		lpSprite = (char [])srcDDSD.lpSurface;
		lpDest   = (char [])destDDSD.lpSurface;

		// Do some work outside of the loop
		PLUS64         = 64 | (64 << 16);
		ALPHABY4      = (ALPHA / 4) | ((ALPHA / 4) << 16);
		doubleColorKey = ColorKey | (ColorKey << 16);

		switch(BPP)
		{
		case 8:
			// IMHO paletized modes are a thing of the past please feel free to
			// implement this if you so desire.
			break;

		case 15:  ////////////////////////////////////////////////////////////////////////
			//
			//  WARNING!!!: I do not have a video card that uses the 5-5-5 format
			//              this barnch of code has not be tested.
			//
			////////////////////////////////////////////////////////////////////////

			// Initialize the pointers to the first pixel in the rectangle
			// TODO lpSprite += (srcRect.top * SpritePitch) + (srcRect.left * 2);
			// TODO lpDest   += (lDestY * dPitch) + (lDestX * 2);

			// Set the horizontal padding
			sbuf = (int)(SpritePitch - (2 * width));
			dbuf = (int)(dPitch - (2 * width));

			// Is the Sprite width odd or even?
			if (width % 2 == 1)
			{
				oddWidth = true;
				width = (width - 1) / 2; //div by 2, processing 2 pixels at a time.
			}
			else
				width = width / 2;  //div by 2, processing 2 pixels at a time.

			i = height;
			do
			{
				if (oddWidth)
				{
					// TODO sTemp = (long)lpSprite;

					if (sTemp != sColorKey)
					{
						// TODO dTemp = *((WORD*)lpDest);
						sb = sTemp & 0x1f;
						db = dTemp & 0x1f;
						sg = (sTemp >> 5) & 0x1f;
						dg = (dTemp >> 5) & 0x1f;
						sr = (sTemp >> 10) & 0x1f;
						dr = (dTemp >> 10) & 0x1f;

						// TODO
//						*((WORD*)lpDest) = (WORD)((ALPHA * (db - sb) >> 8) + sb |
//								((ALPHA * (dg - sg) >> 8) + sg) << 5 |
//								((ALPHA * (dr - sr) >> 8) + sr) << 10);
					}

					// TODO
//					lpDest += 2;
//					lpSprite += 2;
				}
				j = width;
				do
				{
					// TODO sTemp = *((DWORD*)lpSprite);

					if ( sTemp != doubleColorKey )
					{
						// TODO dTemp = *((DWORD*)lpDest);

						sb = sTemp & 0x001F001F;
						db = dTemp & 0x001F001F;
						sg = (sTemp >> 5)  & 0x001F001F;
						dg = (dTemp >> 5)  & 0x001F001F;
						sr = (sTemp >> 10) & 0x001F001F;
						dr = (dTemp >> 10) & 0x001F001F;

						BLUEC  = ((((ALPHA * ((sb + PLUS64) - db)) >> 8) + db) - ALPHABY4) & 0x001F001F;
						GREENC = (((((ALPHA * ((sg + PLUS64) - dg)) >> 8) + dg) - ALPHABY4) & 0x001F001F) << 5;
						REDC   = (((((ALPHA * ((sr + PLUS64) - dr)) >> 8) + dr) - ALPHABY4) & 0x001F001F) << 10;

						Result = BLUEC | GREENC | REDC;

						if ( (sTemp >> 16) == ColorKey )
							Result = (Result & 0xFFFF) | (dTemp & 0xFFFF0000);
						else if ( (sTemp & 0xFFFF) == ColorKey )
							Result = (Result & 0xFFFF0000) | (dTemp & 0xFFFF);

						// TODO *((DWORD*)lpDest) = Result;
					}
					// TODO lpDest    += 4;
					// TODO lpSprite  += 4;

				}while (--j > 0);

				// TODO lpDest   += dbuf;
				// TODO lpSprite += sbuf;

			}while (--i > 0);

			break;

		case 16:

			// Initialize the pointers to the first pixel in the rectangle
			// TODO lpSprite += (srcRect.top * SpritePitch) + (srcRect.left * 2);
			// TODO lpDest   += (lDestY * dPitch) + (lDestX * 2);

			// Set the horizontal padding
			sbuf = (int)(SpritePitch - (2 * width));
			dbuf = (int)(dPitch - (2 * width));

			// Is the Sprite width odd or even?
			if (width % 2 == 1)
			{
				oddWidth = true;
				width = (width - 1) / 2; //div by 2, processing 2 pixels at a time.
			}
			else
				width = width / 2;  //div by 2, processing 2 pixels at a time.


			i = height;
			do
			{
				if (oddWidth)
				{
					// TODO sTemp = *((WORD*)lpSprite);

					if (sTemp != ColorKey)
					{
						// TODO dTemp = *((WORD*)lpDest);
						sb = sTemp & 0x1f;
						db = dTemp & 0x1f;
						sg = (sTemp >> 5) & 0x3f;
						dg = (dTemp >> 5) & 0x3f;
						sr = (sTemp >> 11) & 0x1f;
						dr = (dTemp >> 11) & 0x1f;

						// TODO *((WORD*)lpDest) = (WORD)((ALPHA * (sb - db) >> 8) + db |
						// TODO 		((ALPHA * (sg - dg) >> 8) + dg) << 5 |
						// TODO 		((ALPHA * (sr - dr) >> 8) + dr) << 11);
					}

					// TODO lpDest   += 2;
					// TODO lpSprite += 2;
				}
				j = width;
				do
				{
					// TODO sTemp = *((DWORD*)lpSprite);

					if ( sTemp != doubleColorKey )
					{
						// TODO dTemp = *((DWORD*)lpDest);

						sb = sTemp & 0x001F001F;
						db = dTemp & 0x001F001F;
						sg = (sTemp >> 5)  & 0x003F003F;
						dg = (dTemp >> 5)  & 0x003F003F;
						sr = (sTemp >> 11) & 0x001F001F;
						dr = (dTemp >> 11) & 0x001F001F;

						BLUEC  = ((((ALPHA * ((sb + PLUS64) - db)) >> 8) + db) - ALPHABY4) & 0x001F001F;
						GREENC = (((((ALPHA * ((sg + PLUS64) - dg)) >> 8) + dg) - ALPHABY4) & 0x003F003F) << 5;
						REDC   = (((((ALPHA * ((sr + PLUS64) - dr)) >> 8) + dr) - ALPHABY4) & 0x001F001F) << 11;

						Result = BLUEC | GREENC | REDC;

						if ( (sTemp >> 16) == ColorKey )
							Result = (Result & 0xFFFF) | (dTemp & 0xFFFF0000);
						else if ( (sTemp & 0xFFFF) == ColorKey )
							Result = (Result & 0xFFFF0000) | (dTemp & 0xFFFF);

						// TODO *((DWORD*)lpDest) = Result;
					}
					// TODO lpDest    += 4;
					// TODO lpSprite  += 4;

				}while (--j > 0);

				// TODO lpDest   += dbuf;
				// TODO lpSprite += sbuf;

			}while (--i > 0);

			break;

		case 24:  ////////////////////////////////////////////////////////////////////////
			//
			//  WARNING!!!: I do not have a video card capable of 24bit rendering
			//              this barnch of code has not be tested.
			//
			////////////////////////////////////////////////////////////////////////

			// Initialize the pointers to the first pixel in the rectangle
			// TODO lpSprite += (srcRect.top * SpritePitch) + (srcRect.left * 3);
			// TODO lpDest   += (lDestY * dPitch) + (lDestX * 3);

			// Set the horizontal padding
			sbuf = (int)(SpritePitch - (3 * width));
			dbuf = (int)(dPitch - (3 * width));

			i = height;
			do
			{
				j = width;
				do
				{
					// TODO sTemp = *((DWORD*)lpSprite);

					if ((sTemp & 0xFFFFFF) != sColorKey)
					{
						// TODO dTemp = *((DWORD*)lpDest);
						sb = sTemp & 0xFF;
						db = dTemp & 0xFF;
						sg = (sTemp >> 8) & 0xFF;
						dg = (dTemp >> 8) & 0xFF;
						sr = (sTemp >> 16) & 0xFF;
						dr = (dTemp >> 16) & 0xFF;

						// TODO Result = (DWORD)((ALPHA * (db - sb) >> 8) + sb |
						// TODO 		((ALPHA * (dg - sg) >> 8) + sg) << 8 |
						// TODO 		((ALPHA * (dr - sr) >> 8) + sr) << 16);

						// TODO *((WORD*)lpDest) = (WORD)(Result & 0xFFFF);
						// TODO lpDest += 2;
						// TODO *lpDest = (BYTE)(Result >> 16);
						// TODO lpDest++;
					}
					else
					{
						// TODO lpDest += 3;
					}

					// TODO lpSprite += 3;

				}while (--j > 0);
				// TODO lpDest   += dbuf;
				// TODO lpSprite += sbuf;

			}while (--i > 0);
			break;

		case 32:

			// Initialize the pointers to the first pixel in the rectangle
			// TODO lpSprite += (srcRect.top * SpritePitch) + (srcRect.left * 4);
			// TODO lpDest   += (lDestY * dPitch) + (lDestX * 4);

			// Set the horizontal padding
			sbuf = (int)(SpritePitch - (4 * width));
			dbuf = (int)(dPitch - (4 * width));

			i = height;
			do
			{
				j = width;
				do
				{
					// TODO sTemp = *((DWORD*)lpSprite);

					if ((sTemp & 0xFFFFFF) != sColorKey)
					{
						// TODO dTemp = *((DWORD*)lpDest);
						sb = sTemp & 0xFF;
						db = dTemp & 0xFF;
						sg = (sTemp >> 8) & 0xFF;
						dg = (dTemp >> 8) & 0xFF;
						sr = (sTemp >> 16) & 0xFF;
						dr = (dTemp >> 16) & 0xFF;

						// TODO Result = (DWORD)((ALPHA * (db - sb) >> 8) + sb |
						// TODO 		((ALPHA * (dg - sg) >> 8) + sg) << 8 |
						// TODO 		((ALPHA * (dr - sr) >> 8) + sr) << 16);

						// TODO *((WORD*)lpDest) = (WORD)(Result & 0xFFFF);
						// TODO lpDest += 2;
						// TODO *lpDest = (BYTE)(Result >> 16);
						// TODO lpDest += 2;
					}
					else
					{
						// TODO lpDest += 4;
					}

					// TODO lpSprite += 4;

				}while (--j > 0);
				// TODO lpDest   += dbuf;
				// TODO lpSprite += sbuf;

			}while (--i > 0);
			break;
		} // End RGB Format switch statement


		src.Unlock(null);
		dest.Unlock(null);

		return HRESULT.DD_OK;
	}



	static private int temp;
	static private int i;
	static private long cur,last,sec;
	static private long starttime, curtime;
	static private ArrayList<RECT> rect1 = new ArrayList<RECT>(7);
	static private ArrayList<RECT> rect3 = new ArrayList<RECT>(7);
	static private ArrayList<RECT> rect5 = new ArrayList<RECT>(7);
	static private ArrayList<RECT> rect7 = new ArrayList<RECT>(7);
	static private ArrayList<RECT> rect9 = new ArrayList<RECT>(7);
	static private int sta;
	static private double tail;
	static private long t;
	static private HRESULT	hr;
	static private void KIU_STAGE() {
		/*
		static int temp;
		static long i;
		static long cur,last,sec;
		static long starttime, curtime;

		static RECT rect1[7],rect3[7],rect5[7],rect7[7],rect9[7];
		long delta;

		static int sta;

		static double tail;

		static time_t t;

		static	HRESULT	hr;
		*/

		long delta;
		int k;
		String s;

		double bpmpix=(PUMP_SPRITE_Y)*bpm/60000;

		DrawBackground(Data,i,temp);
		DisplayStageCount(dwGameCount);


		// Display debug msg.
		DisplayMessage(0,0,String.format("start1: %d", start));
		DisplayMessage(0,16,String.format("start2: %d", start2));
		DisplayMessage(0,32,String.format("start3: %d", start3));
		DisplayMessage(0,48,String.format("bpm 1:%g", bpm));
		DisplayMessage(0,64,String.format("bpm 2:%g", bpm2));
		DisplayMessage(0,80,String.format("bpm 3:%g", bpm3));
		DisplayMessage(0,96,String.format("bunki :%ld", bunki));
		DisplayMessage(0,112,String.format("bunki2:%ld", bunki2));

		if(start1==0)
		{
			if(b4dMix1p==true)
			{
				MaxSpeed = MinSpeed = HighSpeed1p_1;

				MaxSpeed = Math.max( MaxSpeed, HighSpeed1p_3);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed1p_5);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed1p_7);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed1p_9);

				MinSpeed = Math.min( MinSpeed, HighSpeed1p_3);
				MinSpeed = Math.min( MinSpeed, HighSpeed1p_5);
				MinSpeed = Math.min( MinSpeed, HighSpeed1p_7);
				MinSpeed = Math.min( MinSpeed, HighSpeed1p_9);
			}
			else
			{
				MaxSpeed = MinSpeed = HighSpeed1p;
				HighSpeed1p_1 = HighSpeed1p_3 = HighSpeed1p_5 = HighSpeed1p_7 = HighSpeed1p_9 = HighSpeed1p;
			}

			if(b4dMix2p)
			{
				MaxSpeed=MinSpeed=HighSpeed2p_1;

				MaxSpeed = Math.max( MaxSpeed, HighSpeed2p_3);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed2p_5);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed2p_7);
				MaxSpeed = Math.max( MaxSpeed, HighSpeed2p_9);

				MinSpeed = Math.min( MinSpeed, HighSpeed2p_3);
				MinSpeed = Math.min( MinSpeed, HighSpeed2p_5);
				MinSpeed = Math.min( MinSpeed, HighSpeed2p_7);
				MinSpeed = Math.min( MinSpeed, HighSpeed2p_9);
			}
			else
			{
				MaxSpeed = MinSpeed = HighSpeed2p;
				HighSpeed2p_1 = HighSpeed2p_3 = HighSpeed2p_5 = HighSpeed2p_7 = HighSpeed2p_9 = HighSpeed2p;
			}

			for(sta=0;sta<6;sta++)
			{
				rect7.get(sta).top=0;
				rect7.get(sta).left=PUMP_SPRITE_NEW*sta;
				rect7.get(sta).right=PUMP_SPRITE_NEW+PUMP_SPRITE_NEW*sta;
				rect7.get(sta).bottom=PUMP_SPRITE_NEW;

				rect9.get(sta).top=PUMP_SPRITE_NEW;
				rect9.get(sta).left=PUMP_SPRITE_NEW*sta;
				rect9.get(sta).right=PUMP_SPRITE_NEW+PUMP_SPRITE_NEW*sta;
				rect9.get(sta).bottom=PUMP_SPRITE_NEW*2;

				rect5.get(sta).top=PUMP_SPRITE_NEW*2;
				rect5.get(sta).left=PUMP_SPRITE_NEW*sta;
				rect5.get(sta).right=PUMP_SPRITE_NEW+PUMP_SPRITE_NEW*sta;
				rect5.get(sta).bottom=PUMP_SPRITE_NEW*3;

				rect3.get(sta).top=PUMP_SPRITE_NEW*3;
				rect3.get(sta).left=PUMP_SPRITE_NEW*sta;
				rect3.get(sta).right=PUMP_SPRITE_NEW+PUMP_SPRITE_NEW*sta;
				rect3.get(sta).bottom=PUMP_SPRITE_NEW*4;

				rect1.get(sta).top=PUMP_SPRITE_NEW*4;
				rect1.get(sta).left=PUMP_SPRITE_NEW*sta;
				rect1.get(sta).right=PUMP_SPRITE_NEW+PUMP_SPRITE_NEW*sta;
				rect1.get(sta).bottom=PUMP_SPRITE_NEW*5;
			}
			sta=0;

			Gauge1p=10;
			Gauge2p=10;

			if(bModeRandom1p)
			{
				for(i=0;i<MAX_DATA;i++)
				{
					Data[MAX_DATA][0]=Data[i][0];
					Data[MAX_DATA][1]=Data[i][1];
					Data[MAX_DATA][2]=Data[i][2];
					Data[MAX_DATA][3]=Data[i][3];
					Data[MAX_DATA][4]=Data[i][4];

					if(Data[i][0]=='2')break;

					Data[i][0]=Data[i][1]=Data[i][2]=Data[i][3]=Data[i][4]='0';

					if(Data[MAX_DATA][0]=='1')Data[i][rand()%5]='1';
					if(Data[MAX_DATA][1]=='1')Data[i][rand()%5]='1';
					if(Data[MAX_DATA][2]=='1')Data[i][rand()%5]='1';
					if(Data[MAX_DATA][3]=='1')Data[i][rand()%5]='1';
					if(Data[MAX_DATA][4]=='1')Data[i][rand()%5]='1';
				}
			}

			if(bModeRandom2p)
			{
				// if(!bModeRandom1p)srand((unsigned) time(&t));

				for(i=0;i<MAX_DATA;i++)
				{
					Data1[MAX_DATA][5]=Data1[i][5];
					Data1[MAX_DATA][6]=Data1[i][6];
					Data1[MAX_DATA][7]=Data1[i][7];
					Data1[MAX_DATA][8]=Data1[i][8];
					Data1[MAX_DATA][9]=Data1[i][9];

					if(Data1[i][0]=='2')break;

					Data1[i][5]=Data1[i][6]=Data1[i][7]=Data1[i][8]=Data1[i][9]='0';

					if(Data1[MAX_DATA][5]=='1')Data1[i][5+rand()%5]='1';
					if(Data1[MAX_DATA][6]=='1')Data1[i][5+rand()%5]='1';
					if(Data1[MAX_DATA][7]=='1')Data1[i][5+rand()%5]='1';
					if(Data1[MAX_DATA][8]=='1')Data1[i][5+rand()%5]='1';
					if(Data1[MAX_DATA][9]=='1')Data1[i][5+rand()%5]='1';
				}
			}

			if(bModeMirror1p)
			{
				for(i=0;i<MAX_DATA;i++)
				{
					Data[MAX_DATA][0]=Data[i][0];
					Data[MAX_DATA][1]=Data[i][1];
					Data[MAX_DATA][2]=Data[i][2];
					Data[MAX_DATA][3]=Data[i][3];
					Data[MAX_DATA][4]=Data[i][4];

					if(Data[i][0]=='2')break;

					if(Data[MAX_DATA][0]=='1')Data[i][3]='1'; else Data[i][3]='0';
					if(Data[MAX_DATA][1]=='1')Data[i][4]='1'; else Data[i][4]='0';
					if(Data[MAX_DATA][2]=='1')Data[i][2]='1'; else Data[i][2]='0';
					if(Data[MAX_DATA][3]=='1')Data[i][0]='1'; else Data[i][0]='0';
					if(Data[MAX_DATA][4]=='1')Data[i][1]='1'; else Data[i][1]='0';

				}
			}
			if(bModeMirror2p)
			{
				for(i=0;i<MAX_DATA;i++)
				{
					Data1[MAX_DATA][5]=Data1[i][5];
					Data1[MAX_DATA][6]=Data1[i][6];
					Data1[MAX_DATA][7]=Data1[i][7];
					Data1[MAX_DATA][8]=Data1[i][8];
					Data1[MAX_DATA][9]=Data1[i][9];

					if(Data1[i][0]=='2')break;

					if(Data1[MAX_DATA][5]=='1')Data1[i][8]='1'; else Data1[i][8]='0';
					if(Data1[MAX_DATA][6]=='1')Data1[i][9]='1'; else Data1[i][9]='0';
					if(Data1[MAX_DATA][7]=='1')Data1[i][7]='1'; else Data1[i][7]='0';
					if(Data1[MAX_DATA][8]=='1')Data1[i][5]='1'; else Data1[i][5]='0';
					if(Data1[MAX_DATA][9]=='1')Data1[i][6]='1'; else Data1[i][6]='0';

				}
			}



			// TODO	memcpy(&Data_Judge,&Data,sizeof(Data));
			// TODO	memcpy(&Data_Judge1,&Data1,sizeof(Data));

			if(bModeNonstep1p)
			{
				for(i=0;i<MAX_DATA;i++)
				{
					if(!(Data[i][0]=='0' && Data[i][1]=='0' && Data[i][2]=='0' && Data[i][3]=='0' && Data[i][4]=='0'))
					{
						i++;
						for(;i<MAX_DATA;i++)
						{
							if(Data[i][0]=='2')i=MAX_DATA;
							else
							{
								Data[i][0]='3';
								Data[i][1]='3';
								Data[i][2]='3';
								Data[i][3]='3';
								Data[i][4]='3';
							}
						}
					}
				}
			}

			if(bModeNonstep2p)
			{
				for(i=0;i<MAX_DATA;i++)
				{
					if(!(Data1[i][5]=='0' && Data1[i][6]=='0' && Data1[i][7]=='0' && Data1[i][8]=='0' && Data1[i][9]=='0'))
					{
						i++;
						for(;i<MAX_DATA;i++)
						{
							if(Data1[i][0]=='2')i=MAX_DATA;
							else
							{
								Data1[i][5]='3';
								Data1[i][6]='3';
								Data1[i][7]='3';
								Data1[i][8]='3';
								Data1[i][9]='3';
							}
						}
					}
				}
			}

			//FadeToSurface(songBack);
			g_pDDSBack.BltFast(0,0, songBack, null, DDBLTFAST_NOCOLORKEY);

			if(SongFlag==true)
				song.OnMediaPlay();

			start*=10;
			start2*=10;start3*=10;
			bunki*=10;bunki2*=10;

			last=cur=timeGetTime();
			tail=0;
			i=0;
			temp=0;
			start1++;
			temp+=55;
			starttime=start;
			curtime=0;
		}

		cur=timeGetTime();        // 130/ 600000
		delta=cur-last;
		last=cur;

		if(Start1p)DrawArrow1p(i); //회색 화살표를 말합니다.
		if(Start2p)DrawArrow2p(i);

		start-=delta;

		if(bunki!=0 && (curtime >= bunki))
		{
			bunki=0;
			bpm=bpm2;
			bpmpix=(PUMP_SPRITE_Y)*bpm/60000;

			starttime=start2;

		}

		if(bunki==0 && bunki2!=0 && (curtime >= bunki2))
		{
			bunki2=0;
			bpm=bpm3;
			bpmpix=(PUMP_SPRITE_Y)*bpm/60000;

			starttime=start3;
		}

		if(start<=0)
		{
			start=0;
			if(SongFlag)
			{
				i=0;
				temp=+55;
				tail=0;

				curtime=(long)(song.GetCurrentPosition()*1000);

				if(curtime > starttime)
				delta=(long)curtime-starttime;
				else delta=(long)curtime;
			}

			//1000 Tick당 180/60 -> 1초에 64*(180/60)  즉 1 tick 당 64*(bpm/60)/1000
			temp-=(int)(delta*bpmpix);
			tail+=(double)((double)(delta*bpmpix)-(int)(delta*bpmpix));

			if(tail>=1)
			{
				temp-=(int)tail;
				tail-=(int)tail;
			}

			if(temp<-100)
			{
				while(temp<-100)
				{
					temp+=(PUMP_SPRITE_Y);

					i+=tick;
				}
			}

		}
		if(timeGetTime()-sec>50)
		{
			sec=timeGetTime();
			if(sta==5)sta=0;
			else sta++;
		}

		if(Start1p)
		for(k=0;k<48;k+=tick)
		{
			if(Data[i][0]=='2' || Data[i+1][0]=='2' || Data[i+2][0]=='2' || Data[i+3][0]=='2')
			{
				k=48;
				if(SongFlag)
				{
					song.OnMediaStop();
					song = null;
					SongFlag=false;
				}
				g_programState=RESULT;

				First=0;
			}

			if(tick==2)
			{
				if(Data[i+k][0]=='1')
					ClpBlt(LP1_X,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][1]=='1')
					ClpBlt(LP7_X,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][2]=='1')
					ClpBlt(LP5_X,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][3]=='1')
					ClpBlt(LP9_X,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][4]=='1')
					ClpBlt(LP3_X,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k]=(temp+PUMP_SPRITE_Y*k/2)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data[i+k+1][0]=='1')
					ClpBlt(LP1_X,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][1]=='1')
					ClpBlt(LP7_X,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][2]=='1')
					ClpBlt(LP5_X,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][3]=='1')
					ClpBlt(LP9_X,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][4]=='1')
					ClpBlt(LP3_X,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k+1]=(25+temp+PUMP_SPRITE_Y*k/2)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(bModeSuddenR1p)
				{
					if(Data_y[i+k]>240 && Data_y[i+k]<290)
					{
						Data[MAX_DATA][0]=Data[i+k][0];
						Data[MAX_DATA][1]=Data[i+k][1];
						Data[MAX_DATA][2]=Data[i+k][2];
						Data[MAX_DATA][3]=Data[i+k][3];
						Data[MAX_DATA][4]=Data[i+k][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k][0]=Data[i+k][1]=Data[i+k][2]=Data[i+k][3]=Data[i+k][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k][rand()%5]='1';

							Data_Judge[i+k][0]=Data[i+k][0];
							Data_Judge[i+k][1]=Data[i+k][1];
							Data_Judge[i+k][2]=Data[i+k][2];
							Data_Judge[i+k][3]=Data[i+k][3];
							Data_Judge[i+k][4]=Data[i+k][4];
						}
					}

					if(Data_y[i+k+1]>240 && Data_y[i+k+1]<290)
					{
						Data[MAX_DATA][0]=Data[i+k+1][0];
						Data[MAX_DATA][1]=Data[i+k+1][1];
						Data[MAX_DATA][2]=Data[i+k+1][2];
						Data[MAX_DATA][3]=Data[i+k+1][3];
						Data[MAX_DATA][4]=Data[i+k+1][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k+1][0]=Data[i+k+1][1]=Data[i+k+1][2]=Data[i+k+1][3]=Data[i+k+1][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k+1][rand()%5]='1';

							Data_Judge[i+k+1][0]=Data[i+k+1][0];
							Data_Judge[i+k+1][1]=Data[i+k+1][1];
							Data_Judge[i+k+1][2]=Data[i+k+1][2];
							Data_Judge[i+k+1][3]=Data[i+k+1][3];
							Data_Judge[i+k+1][4]=Data[i+k+1][4];
						}
					}
				}
			}
			else if(tick==4)
			{
				if(Data[i+k][0]=='1')
					ClpBlt(LP1_X,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][1]=='1')
					ClpBlt(LP7_X,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][2]=='1')
					ClpBlt(LP5_X,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][3]=='1')
					ClpBlt(LP9_X,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k][4]=='1')
					ClpBlt(LP3_X,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k]=(temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data[i+k+1][0]=='1')
					ClpBlt(LP1_X,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][1]=='1')
					ClpBlt(LP7_X,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][2]=='1')
					ClpBlt(LP5_X,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][3]=='1')
					ClpBlt(LP9_X,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+1][4]=='1')
					ClpBlt(LP3_X,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k+1]=(12+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data[i+k+2][0]=='1')
					ClpBlt(LP1_X,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+2][1]=='1')
					ClpBlt(LP7_X,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+2][2]=='1')
					ClpBlt(LP5_X,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+2][3]=='1')
					ClpBlt(LP9_X,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+2][4]=='1')
					ClpBlt(LP3_X,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k+2]=(25+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data[i+k+3][0]=='1')
					ClpBlt(LP1_X,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_1-(PUMP_SPRITE_Y)*(HighSpeed1p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+3][1]=='1')
					ClpBlt(LP7_X,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_7-(PUMP_SPRITE_Y)*(HighSpeed1p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+3][2]=='1')
					ClpBlt(LP5_X,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_5-(PUMP_SPRITE_Y)*(HighSpeed1p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+3][3]=='1')
					ClpBlt(LP9_X,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_9-(PUMP_SPRITE_Y)*(HighSpeed1p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data[i+k+3][4]=='1')
					ClpBlt(LP3_X,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed1p_3-(PUMP_SPRITE_Y)*(HighSpeed1p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y[i+k+3]=(38+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(bModeSuddenR1p)
				{
					if(Data_y[i+k]>240 && Data_y[i+k]<290)
					{
						Data[MAX_DATA][0]=Data[i+k][0];
						Data[MAX_DATA][1]=Data[i+k][1];
						Data[MAX_DATA][2]=Data[i+k][2];
						Data[MAX_DATA][3]=Data[i+k][3];
						Data[MAX_DATA][4]=Data[i+k][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k][0]=Data[i+k][1]=Data[i+k][2]=Data[i+k][3]=Data[i+k][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k][rand()%5]='1';

							Data_Judge[i+k][0]=Data[i+k][0];
							Data_Judge[i+k][1]=Data[i+k][1];
							Data_Judge[i+k][2]=Data[i+k][2];
							Data_Judge[i+k][3]=Data[i+k][3];
							Data_Judge[i+k][4]=Data[i+k][4];
						}
					}
					if(Data_y[i+k+1]>240 && Data_y[i+k+1]<290)
					{
						Data[MAX_DATA][0]=Data[i+k+1][0];
						Data[MAX_DATA][1]=Data[i+k+1][1];
						Data[MAX_DATA][2]=Data[i+k+1][2];
						Data[MAX_DATA][3]=Data[i+k+1][3];
						Data[MAX_DATA][4]=Data[i+k+1][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k+1][0]=Data[i+k+1][1]=Data[i+k+1][2]=Data[i+k+1][3]=Data[i+k+1][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k+1][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k+1][rand()%5]='1';

							Data_Judge[i+k+1][0]=Data[i+k+1][0];
							Data_Judge[i+k+1][1]=Data[i+k+1][1];
							Data_Judge[i+k+1][2]=Data[i+k+1][2];
							Data_Judge[i+k+1][3]=Data[i+k+1][3];
							Data_Judge[i+k+1][4]=Data[i+k+1][4];
						}
					}
					if(Data_y[i+k+2]>240 && Data_y[i+k+2]<290)
					{
						Data[MAX_DATA][0]=Data[i+k+2][0];
						Data[MAX_DATA][1]=Data[i+k+2][1];
						Data[MAX_DATA][2]=Data[i+k+2][2];
						Data[MAX_DATA][3]=Data[i+k+2][3];
						Data[MAX_DATA][4]=Data[i+k+2][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k+2][0]=Data[i+k+2][1]=Data[i+k+2][2]=Data[i+k+2][3]=Data[i+k+2][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k+2][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k+2][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k+2][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k+2][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k+2][rand()%5]='1';

							Data_Judge[i+k+2][0]=Data[i+k+2][0];
							Data_Judge[i+k+2][1]=Data[i+k+2][1];
							Data_Judge[i+k+2][2]=Data[i+k+2][2];
							Data_Judge[i+k+2][3]=Data[i+k+2][3];
							Data_Judge[i+k+2][4]=Data[i+k+2][4];
						}
					}
					if(Data_y[i+k+3]>240 && Data_y[i+k+3]<290)
					{
						Data[MAX_DATA][0]=Data[i+k+3][0];
						Data[MAX_DATA][1]=Data[i+k+3][1];
						Data[MAX_DATA][2]=Data[i+k+3][2];
						Data[MAX_DATA][3]=Data[i+k+3][3];
						Data[MAX_DATA][4]=Data[i+k+3][4];

						if(Data[MAX_DATA][0]!='2')
						{
							Data[i+k+3][0]=Data[i+k+3][1]=Data[i+k+3][2]=Data[i+k+3][3]=Data[i+k+3][4]='0';

							if(Data[MAX_DATA][0]=='1')Data[i+k+3][rand()%5]='1';
							if(Data[MAX_DATA][1]=='1')Data[i+k+3][rand()%5]='1';
							if(Data[MAX_DATA][2]=='1')Data[i+k+3][rand()%5]='1';
							if(Data[MAX_DATA][3]=='1')Data[i+k+3][rand()%5]='1';
							if(Data[MAX_DATA][4]=='1')Data[i+k+3][rand()%5]='1';

							Data_Judge[i+k+3][0]=Data[i+k+3][0];
							Data_Judge[i+k+3][1]=Data[i+k+3][1];
							Data_Judge[i+k+3][2]=Data[i+k+3][2];
							Data_Judge[i+k+3][3]=Data[i+k+3][3];
							Data_Judge[i+k+3][4]=Data[i+k+3][4];
						}
					}
				}
			}
		}

		if(Start2p)
		for(k=0;k<48;k+=tick)
		{
			if(Data1[i][0]=='2' || Data1[i+1][0]=='2' || Data1[i+2][0]=='2' || Data1[i+3][0]=='2')
			{
				k=48;
				if(SongFlag)
				{
					song.OnMediaStop();
					song = null;
					SongFlag=false;
				}
				g_programState=RESULT;

				First=0;
			}

			if(tick==2)
			{
				if(Data1[i+k][5]=='1')
					ClpBlt(LP1_X1,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][6]=='1')
					ClpBlt(LP7_X1,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][7]=='1')
					ClpBlt(LP5_X1,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][8]=='1')
					ClpBlt(LP9_X1,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][9]=='1')
					ClpBlt(LP3_X1,(temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k]=(temp+PUMP_SPRITE_Y*k/2)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data1[i+k+1][5]=='1')
					ClpBlt(LP1_X1,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][6]=='1')
					ClpBlt(LP7_X1,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][7]=='1')
					ClpBlt(LP5_X1,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][8]=='1')
					ClpBlt(LP9_X1,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][9]=='1')
					ClpBlt(LP3_X1,(25+temp+PUMP_SPRITE_Y*k/2)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k+1]=(25+temp+PUMP_SPRITE_Y*k/2)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(bModeSuddenR2p)
				{
					if(Data_y1[i+k]>240 && Data_y1[i+k]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k][5];
						Data1[MAX_DATA][6]=Data1[i+k][6];
						Data1[MAX_DATA][7]=Data1[i+k][7];
						Data1[MAX_DATA][8]=Data1[i+k][8];
						Data1[MAX_DATA][9]=Data1[i+k][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k][5]=Data1[i+k][6]=Data1[i+k][7]=Data1[i+k][8]=Data1[i+k][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k][5 + rand()%5]='1';

							Data_Judge1[i+k][5]=Data1[i+k][5];
							Data_Judge1[i+k][6]=Data1[i+k][6];
							Data_Judge1[i+k][7]=Data1[i+k][7];
							Data_Judge1[i+k][8]=Data1[i+k][8];
							Data_Judge1[i+k][9]=Data1[i+k][9];
						}
					}
					if(Data_y1[i+k+1]>240 && Data_y1[i+k+1]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k+1][5];
						Data1[MAX_DATA][6]=Data1[i+k+1][6];
						Data1[MAX_DATA][7]=Data1[i+k+1][7];
						Data1[MAX_DATA][8]=Data1[i+k+1][8];
						Data1[MAX_DATA][9]=Data1[i+k+1][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k+1][5]=Data1[i+k+1][6]=Data1[i+k+1][7]=Data1[i+k+1][8]=Data1[i+k+1][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k+1][5 + rand()%5]='1';

							Data_Judge1[i+k+1][5]=Data1[i+k+1][5];
							Data_Judge1[i+k+1][6]=Data1[i+k+1][6];
							Data_Judge1[i+k+1][7]=Data1[i+k+1][7];
							Data_Judge1[i+k+1][8]=Data1[i+k+1][8];
							Data_Judge1[i+k+1][9]=Data1[i+k+1][9];
						}
					}
				}
			}
			else if(tick==4)
			{

				if(Data1[i+k][5]=='1')
					ClpBlt(LP1_X1,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][6]=='1')
					ClpBlt(LP7_X1,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][7]=='1')
					ClpBlt(LP5_X1,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][8]=='1')
					ClpBlt(LP9_X1,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k][9]=='1')
					ClpBlt(LP3_X1,(temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k]=(temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data1[i+k+1][5]=='1')
					ClpBlt(LP1_X1,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][6]=='1')
					ClpBlt(LP7_X1,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][7]=='1')
					ClpBlt(LP5_X1,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][8]=='1')
					ClpBlt(LP9_X1,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+1][9]=='1')
					ClpBlt(LP3_X1,(12+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k+1]=(12+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data1[i+k+2][5]=='1')
					ClpBlt(LP1_X1,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+2][6]=='1')
					ClpBlt(LP7_X1,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+2][7]=='1')
					ClpBlt(LP5_X1,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+2][8]=='1')
					ClpBlt(LP9_X1,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+2][9]=='1')
					ClpBlt(LP3_X1,(25+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k+2]=(25+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(Data1[i+k+3][5]=='1')
					ClpBlt(LP1_X1,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_1-(PUMP_SPRITE_Y)*(HighSpeed2p_1-1),wArrow,rect1.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+3][6]=='1')
					ClpBlt(LP7_X1,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_7-(PUMP_SPRITE_Y)*(HighSpeed2p_7-1),wArrow,rect7.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+3][7]=='1')
					ClpBlt(LP5_X1,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_5-(PUMP_SPRITE_Y)*(HighSpeed2p_5-1),wArrow,rect5.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+3][8]=='1')
					ClpBlt(LP9_X1,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_9-(PUMP_SPRITE_Y)*(HighSpeed2p_9-1),wArrow,rect9.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );
				if(Data1[i+k+3][9]=='1')
					ClpBlt(LP3_X1,(38+temp+PUMP_SPRITE_Y*k/4)*HighSpeed2p_3-(PUMP_SPRITE_Y)*(HighSpeed2p_3-1),wArrow,rect3.get(sta),DDBLTFAST_WAIT | DDBLTFAST_SRCCOLORKEY );

				Data_y1[i+k+3]=(38+temp+PUMP_SPRITE_Y*k/4)*MinSpeed-(PUMP_SPRITE_Y)*(MinSpeed-1);

				if(bModeSuddenR2p)
				{
					if(Data_y1[i+k]>240 && Data_y1[i+k]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k][5];
						Data1[MAX_DATA][6]=Data1[i+k][6];
						Data1[MAX_DATA][7]=Data1[i+k][7];
						Data1[MAX_DATA][8]=Data1[i+k][8];
						Data1[MAX_DATA][9]=Data1[i+k][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k][5]=Data1[i+k][6]=Data1[i+k][7]=Data1[i+k][8]=Data1[i+k][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k][5 + rand()%5]='1';

							Data_Judge1[i+k][5]=Data1[i+k][5];
							Data_Judge1[i+k][6]=Data1[i+k][6];
							Data_Judge1[i+k][7]=Data1[i+k][7];
							Data_Judge1[i+k][8]=Data1[i+k][8];
							Data_Judge1[i+k][9]=Data1[i+k][9];
						}
					}
					if(Data_y1[i+k+1]>240 && Data_y1[i+k+1]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k+1][5];
						Data1[MAX_DATA][6]=Data1[i+k+1][6];
						Data1[MAX_DATA][7]=Data1[i+k+1][7];
						Data1[MAX_DATA][8]=Data1[i+k+1][8];
						Data1[MAX_DATA][9]=Data1[i+k+1][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k+1][5]=Data1[i+k+1][6]=Data1[i+k+1][7]=Data1[i+k+1][8]=Data1[i+k+1][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k+1][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k+1][5 + rand()%5]='1';

							Data_Judge1[i+k+1][5]=Data1[i+k+1][5];
							Data_Judge1[i+k+1][6]=Data1[i+k+1][6];
							Data_Judge1[i+k+1][7]=Data1[i+k+1][7];
							Data_Judge1[i+k+1][8]=Data1[i+k+1][8];
							Data_Judge1[i+k+1][9]=Data1[i+k+1][9];
						}
					}
					if(Data_y1[i+k+2]>240 && Data_y1[i+k+2]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k+2][5];
						Data1[MAX_DATA][6]=Data1[i+k+2][6];
						Data1[MAX_DATA][7]=Data1[i+k+2][7];
						Data1[MAX_DATA][8]=Data1[i+k+2][8];
						Data1[MAX_DATA][9]=Data1[i+k+2][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k+2][5]=Data1[i+k+2][6]=Data1[i+k+2][7]=Data1[i+k+2][8]=Data1[i+k+2][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k+2][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k+2][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k+2][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k+2][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k+2][5 + rand()%5]='1';

							Data_Judge1[i+k+2][5]=Data1[i+k+2][5];
							Data_Judge1[i+k+2][6]=Data1[i+k+2][6];
							Data_Judge1[i+k+2][7]=Data1[i+k+2][7];
							Data_Judge1[i+k+2][8]=Data1[i+k+2][8];
							Data_Judge1[i+k+2][9]=Data1[i+k+2][9];
						}
					}
					if(Data_y1[i+k+3]>240 && Data_y1[i+k+3]<290)
					{
						Data1[MAX_DATA][5]=Data1[i+k+3][5];
						Data1[MAX_DATA][6]=Data1[i+k+3][6];
						Data1[MAX_DATA][7]=Data1[i+k+3][7];
						Data1[MAX_DATA][8]=Data1[i+k+3][8];
						Data1[MAX_DATA][9]=Data1[i+k+3][9];

						if(Data1[MAX_DATA][0]!='2')
						{
							Data1[i+k+3][5]=Data1[i+k+3][6]=Data1[i+k+3][7]=Data1[i+k+3][8]=Data1[i+k+3][9]='0';

							if(Data1[MAX_DATA][5]=='1')Data1[i+k+3][5 + rand()%5]='1';
							if(Data1[MAX_DATA][6]=='1')Data1[i+k+3][5 + rand()%5]='1';
							if(Data1[MAX_DATA][7]=='1')Data1[i+k+3][5 + rand()%5]='1';
							if(Data1[MAX_DATA][8]=='1')Data1[i+k+3][5 + rand()%5]='1';
							if(Data1[MAX_DATA][9]=='1')Data1[i+k+3][5 + rand()%5]='1';

							Data_Judge1[i+k+3][5]=Data1[i+k+3][5];
							Data_Judge1[i+k+3][6]=Data1[i+k+3][6];
							Data_Judge1[i+k+3][7]=Data1[i+k+3][7];
							Data_Judge1[i+k+3][8]=Data1[i+k+3][8];
							Data_Judge1[i+k+3][9]=Data1[i+k+3][9];
						}
					}
				}
			}
		}

		if(Start1p)
		{
			if(KCFG.optJudge)DrawJudge1p();
			DrawGauge1p();
			DrawScore1p();
		}
		if(Start2p)
		{
			if(KCFG.optJudge)DrawJudge2p();
			DrawGauge2p();
			DrawScore2p();
		}

		if(bModeMirror1p)DrawMode(0,200,KSelect.HMODE_MIRROR);
		if(bModeNonstep1p)DrawMode(0,240,KSelect.HMODE_NONSTEP);
		if(bModeSynchro)DrawMode(0,280,KSelect.HMODE_SYNCHRO);
		if(bModeUnion1p)DrawMode(0,320,KSelect.HMODE_UNION);
		if(bModeRandom1p)DrawMode(0,360,KSelect.HMODE_RANDOM);
		if(bModeVanish1p)DrawMode(0,400,KSelect.HMODE_VANISH);

		if(HighSpeed1p>1)DrawMode(0,160,KSelect.HMODE_2X);

		if(bModeMirror2p)DrawMode(600,200,KSelect.HMODE_MIRROR);
		if(bModeNonstep2p)DrawMode(600,240,KSelect.HMODE_NONSTEP);
		if(bModeUnion2p)DrawMode(600,320,KSelect.HMODE_UNION);
		if(bModeRandom2p)DrawMode(600,360,KSelect.HMODE_RANDOM);
		if(bModeVanish2p)DrawMode(600,400,KSelect.HMODE_VANISH);

		if(HighSpeed2p>1)DrawMode(600,160,KSelect.HMODE_2X);

		Flipp();
	}


	static private void DrawMode(int j, int k, int hmodeMirror) {
		// TODO Auto-generated method stub

	}

	static private void WaitMessage() {
		// TODO Auto-generated method stub

	}
	static private void DispatchMessage(MSG msg) {
		// TODO Auto-generated method stub

	}
	static private void TranslateMessage(MSG msg) {
		// TODO Auto-generated method stub

	}
	static private boolean GetMessage(MSG msg, Object object, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	static private boolean PeekMessage(MSG msg, Object object, int i, int j, int pmNoremove) {
		// TODO Auto-generated method stub
		return false;
	}
	static private void CFGInitialize() {
		// TODO Auto-generated method stub

	}
	static private HRESULT InitDI(HINSTANCE hInstance) {
		// TODO Auto-generated method stub
		return null;
	}
	static private void Read() {
		// TODO Auto-generated method stub

	}
	static private void CoInitialize(Object object) {
		// TODO Auto-generated method stub

	}
	static private long DDColorMatch(LPDIRECTDRAWSURFACE wArrow2, int clrInvalid) {
		// TODO Auto-generated method stub
		return 0;
	}
	static private LPDIRECTDRAWSURFACE DDLoadBitmap(LPDIRECTDRAW g_pDD2, int idbArrow1, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	static private void MessageBox(HWND hWnd2, String format, int i, int mbOk) {
		// TODO Auto-generated method stub

	}
	static private void DDSetColorKey(LPDIRECTDRAWSURFACE smallFont2, int clrInvalid) {
		// TODO Auto-generated method stub

	}
	static private LPDIRECTDRAWSURFACE DDLoadBitmap(LPDIRECTDRAW g_pDD2, String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	static private HRESULT DirectDrawCreate(Object object, LPDIRECTDRAW g_pDD2, Object object2) {
		// TODO Auto-generated method stub
		return null;
	}
	static private void SetFocus(HWND hWnd2) {
		// TODO Auto-generated method stub

	}
	static private void UpdateWindow(HWND hWnd2) {
		// TODO Auto-generated method stub

	}
	static private void ShowWindow(HWND hWnd2, int nCmdShow) {
		// TODO Auto-generated method stub

	}
	static private HWND CreateWindowEx(long dwExStyle, String pRGNAME2, String tITLE2, long dwStyle, int i, int j, long l,
			long m, Object object, Object object2, HINSTANCE hInstance, Object object3) {
		// TODO Auto-generated method stub
		return null;
	}
	static private void AdjustWindowRectEx(RECT windowRect, long dwStyle, boolean b, long dwExStyle) {
		// TODO Auto-generated method stub

	}
	static private void ShowCursor(boolean b) {
		// TODO Auto-generated method stub

	}
	static private void RegisterClass(WNDCLASS wc) {
		// TODO Auto-generated method stub

	}
	// TODO : NEXT

	static private Object LoadCursor(Object object, int idcArrow) {
		// TODO Auto-generated method stub
		return null;
	}
	static private Object LoadIcon(int i, int idiIcon) {
		// TODO Auto-generated method stub
		return null;
	}
	static private long DefWindowProc(HWND hWnd2, int message, long wParam, long lParam) {
		// TODO Auto-generated method stub
		return 0;
	}
	static private void SetCursor(Object object) {
		// TODO Auto-generated method stub

	}
	static private void PostQuitMessage(int i) {
		// TODO Auto-generated method stub

	}
	static private void CFGWrite() {
		// TODO Auto-generated method stub

	}
	static private void ClientToScreen(HWND hWnd2, long left) {
		// TODO Auto-generated method stub

	}
	static private void GetClientRect(HWND hWnd2, RECT g_rcViewport2) {
		// TODO Auto-generated method stub

	}
	static private void GetVersionEx(OSVERSIONINFO osver) {
		// TODO Auto-generated method stub

	}
	static private void DestroyWindow(HWND hWnd2) {
		// TODO Auto-generated method stub

	}
	static private void MessageBox(HWND hWnd2, String format, String tITLE2, int mbOk) {
		// TODO Auto-generated method stub

	}
	static private void PostMessage(HWND hWnd2, int wmClose, int i, int j) {
		// TODO Auto-generated method stub

	}

	static private void Result() {
		// TODO Auto-generated method stub

	}
	static private void Configuration() {
		// TODO Auto-generated method stub

	}
	static private void Dead() {
		// TODO Auto-generated method stub

	}
	static private void KIU_STAGE_DOUBLE() {
		// TODO Auto-generated method stub

	}
	static private void SelectSong() {
		// TODO Auto-generated method stub

	}


	static private void CleanupInput() {
		// TODO Auto-generated method stub

	}
	static private HRESULT InitFail(HWND hWnd2, HRESULT hRet, String string) {
		// TODO Auto-generated method stub
		return HRESULT.DD_OK;

	}
	static private HRESULT DirectSoundCreate(Object object, LPDIRECTSOUND lpds2, Object object2) {
		// TODO Auto-generated method stub
		return null;
	}
	static private void ReadGameInput() {
		// TODO Auto-generated method stub

	}

	static private LPDIRECTSOUNDBUFFER DSLoadSoundBuffer(LPDIRECTSOUND lpds2, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	static private long timeGetTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	// void KIU_STAGE(void)
}
