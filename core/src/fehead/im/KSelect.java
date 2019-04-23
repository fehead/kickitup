package fehead.im;

import java.io.File;
import java.util.logging.Logger;

import com.badlogic.gdx.Gdx;

public class KSelect {
	static private	Logger	logger = Logger.getLogger(KSelect.class.getName());
	
	// select.h
	static public final int HMODE_CANCEL	= 99;
	static public final int HMODE_2X		= 1 ;
	static public final int HMODE_4X		= 2 ;
	static public final int HMODE_8X		= 3 ;
	static public final int HMODE_VANISH	= 4 ;
	static public final int HMODE_MIRROR	= 5 ;
	static public final int HMODE_RANDOM	= 6 ;
	static public final int HMODE_COUPLE	= 7 ;
	static public final int HMODE_SYNCHRO	= 8 ;
	static public final int HMODE_NONSTEP	= 9 ;
	static public final int HMODE_NONSTOPDOUBLE	 = 10;
	static public final int HMODE_UNION		=11;
	static public final int HMODE_SELECTALL	=12;
	static public final int HMODE_4DMIX		=13;
	static public final int HMODE_NONE		=0 ;
	static public final int HMODE_SUDDENR	=14;
	static public final int HMODE_RANDOMS	=15;
	
	
	// select.cpp
	static public final int DISCSIZE_X		= 300;
	static public final int DISCSIZE_Y		= 200;
	static public final int STILL_DRAWING	= 100;
	
	
	static private	long	startTimer;
	static private	long	curTimer;
	
	static HRESULT	ClpBlt3(int x ,int y ,LPDIRECTDRAWSURFACE ds, RECT srect, int mode) {
		RECT sRect = new RECT(srect);
		HRESULT	hRet;
	
		if(x>640 || y>480)
			return HRESULT.DD_OK;

		if(y+(srect.bottom-srect.top)>480)
			srect.bottom=srect.bottom-(y+(srect.bottom-srect.top)-480);
		if(y<0) {
			srect.top-=y;
			y=0;
		}

		if(x+(srect.right-srect.left)>640)
			srect.right=srect.right-(x+(srect.right-srect.left)-640);
		if(x<0) {
			srect.left-=x;
			x=0;
		}
		
		hRet= Main.g_pDDSBack.BltFast(x,y,ds,srect,mode);

		// TODO: memcpy(srect,&sRect,sizeof(sRect));
		srect = sRect;
		
		return hRet;
	}

	static void Read() {
		long	Count=0;

		/*
		String path="SONG";
		File dirFile=new File(path);
		Gdx.app.log("KSelect", dirFile.getAbsolutePath());		
		for(File file : dirFile.listFiles()) {
			if(file.isDirectory()) {
				if(access("Crazy_2.stf",04)==0)CSONG[Count].ReadCrazy_2_STF("Crazy_2.stf");
				else if(access("Crazy_2.ksf",04)==0)CSONG[Count].ReadCrazy_2_KSF("Crazy_2.ksf");
				if(access("Crazy_1.stf",04)==0)CSONG[Count].ReadCrazy_1_STF("Crazy_1.stf"),Count++;
				else if(access("Crazy_1.ksf",04)==0)CSONG[Count].ReadCrazy_1_KSF("Crazy_1.ksf"),Count++;

				if(access("Hard_2.stf",04)==0)CSONG[Count].ReadHard_2_STF("Hard_2.stf");
				else if(access("Hard_2.ksf",04)==0)CSONG[Count].ReadHard_2_KSF("Hard_2.ksf");

				if(access("Hard_1.stf",04)==0)CSONG[Count].ReadHard_1_STF("Hard_1.stf"),Count++;
				else if(access("Hard_1.ksf",04)==0)CSONG[Count].ReadHard_1_KSF("Hard_1.ksf"),Count++;

				if(access("Easy_2.stf",04)==0)CSONG[Count].ReadEasy_2_STF("Easy_2.stf");
				else if(access("Easy_2.ksf",04)==0)CSONG[Count].ReadEasy_2_KSF("Easy_2.ksf");

				if(access("Easy_1.stf",04)==0)CSONG[Count].ReadEasy_1_STF("Easy_1.stf"),Count++;
				else if(access("Easy_1.ksf",04)==0)CSONG[Count].ReadEasy_1_KSF("Easy_1.ksf"),Count++;

				if(access("Double.stf",04)==0)CSONG[Count].ReadDouble_STF("Double.stf"),Count++;
				else if(access("Double.ksf",04)==0)CSONG[Count].ReadDouble_KSF("Double.ksf");
			}
		}
		
		
		if(lpData.dwFileAttributes==FILE_ATTRIBUTE_DIRECTORY) {
			SetCurrentDirectory(cPathStr);
			hFind=FindFirstFile("*.*",&lpData);
			if(lpData.cFileName[0]!='.' && lpData.dwFileAttributes==FILE_ATTRIBUTE_DIRECTORY)
			{
				SetCurrentDirectory(lpData.cFileName);

				if(access("Crazy_2.stf",04)==0)CSONG[Count].ReadCrazy_2_STF("Crazy_2.stf");
				else if(access("Crazy_2.ksf",04)==0)CSONG[Count].ReadCrazy_2_KSF("Crazy_2.ksf");

				if(access("Crazy_1.stf",04)==0)CSONG[Count].ReadCrazy_1_STF("Crazy_1.stf"),Count++;
				else if(access("Crazy_1.ksf",04)==0)CSONG[Count].ReadCrazy_1_KSF("Crazy_1.ksf"),Count++;

				if(access("Hard_2.stf",04)==0)CSONG[Count].ReadHard_2_STF("Hard_2.stf");
				else if(access("Hard_2.ksf",04)==0)CSONG[Count].ReadHard_2_KSF("Hard_2.ksf");

				if(access("Hard_1.stf",04)==0)CSONG[Count].ReadHard_1_STF("Hard_1.stf"),Count++;
				else if(access("Hard_1.ksf",04)==0)CSONG[Count].ReadHard_1_KSF("Hard_1.ksf"),Count++;

				if(access("Easy_2.stf",04)==0)CSONG[Count].ReadEasy_2_STF("Easy_2.stf");
				else if(access("Easy_2.ksf",04)==0)CSONG[Count].ReadEasy_2_KSF("Easy_2.ksf");

				if(access("Easy_1.stf",04)==0)CSONG[Count].ReadEasy_1_STF("Easy_1.stf"),Count++;
				else if(access("Easy_1.ksf",04)==0)CSONG[Count].ReadEasy_1_KSF("Easy_1.ksf"),Count++;

				if(access("Double.stf",04)==0)CSONG[Count].ReadDouble_STF("Double.stf"),Count++;
				else if(access("Double.ksf",04)==0)CSONG[Count].ReadDouble_KSF("Double.ksf");

				//if(CSONG[Count].bpm!=0)Count++;
				SetCurrentDirectory("..\\");
			}

			for(;;)
			{
				if(FindNextFile(hFind,&lpData)==FALSE)break;
				else
				{
					if(lpData.cFileName[0]!='.' && lpData.dwFileAttributes==FILE_ATTRIBUTE_DIRECTORY)
					{
						SetCurrentDirectory(lpData.cFileName);

						if(access("Crazy_2.stf",04)==0)CSONG[Count].ReadCrazy_2_STF("Crazy_2.stf");
						else if(access("Crazy_2.ksf",04)==0)CSONG[Count].ReadCrazy_2_KSF("Crazy_2.ksf");

						if(access("Crazy_1.stf",04)==0)CSONG[Count].ReadCrazy_1_STF("Crazy_1.stf"),Count++;
						else if(access("Crazy_1.ksf",04)==0)CSONG[Count].ReadCrazy_1_KSF("Crazy_1.ksf"),Count++;

						if(access("Hard_2.stf",04)==0)CSONG[Count].ReadHard_2_STF("Hard_2.stf");
						else if(access("Hard_2.ksf",04)==0)CSONG[Count].ReadHard_2_KSF("Hard_2.ksf");

						if(access("Hard_1.stf",04)==0)CSONG[Count].ReadHard_1_STF("Hard_1.stf"),Count++;
						else if(access("Hard_1.ksf",04)==0)CSONG[Count].ReadHard_1_KSF("Hard_1.ksf"),Count++;

						if(access("Easy_2.stf",04)==0)CSONG[Count].ReadEasy_2_STF("Easy_2.stf");
						else if(access("Easy_2.ksf",04)==0)CSONG[Count].ReadEasy_2_KSF("Easy_2.ksf");

						if(access("Easy_1.stf",04)==0)CSONG[Count].ReadEasy_1_STF("Easy_1.stf"),Count++;
						else if(access("Easy_1.ksf",04)==0)CSONG[Count].ReadEasy_1_KSF("Easy_1.ksf"),Count++;

						if(access("Double.stf",04)==0)CSONG[Count].ReadDouble_STF("Double.stf"),Count++;
						else if(access("Double.ksf",04)==0)CSONG[Count].ReadDouble_KSF("Double.ksf"),Count++;
					
						//if(CSONG[Count].bpm!=0)Count++;
						SetCurrentDirectory("..\\");
					}
				}
			}
			SetCurrentDirectory("..\\");
		}
		FindClose(hFind);

		if(CSONG[0].bpm==0)
		{
			MessageBox(hWnd,"Song directory not found or No song data.","KICKITUP ERROR",MB_OK);
//			ReleaseAllObjects();

			PostQuitMessage(0);
		}
		*/
	}

	private static boolean FindNextFile(HANDLE hFind, WIN32_FIND_DATA lpData) {
		// TODO Auto-generated method stub
		return false;
	}

	private static HANDLE FindFirstFile(String string, WIN32_FIND_DATA lpData) {
		// TODO Auto-generated method stub
		return null;
	}

}
