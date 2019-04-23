package fehead.im;

public class LPDIRECTDRAWSURFACE {
	/**
	 * HRESULT BltFast( DWORD dwX, DWORD dwY, LPDIRECTDRAWSURFACE lpDDSrcSurface, LPRECT lpSrcRect, DWORD dwTrans );
	 */
	public HRESULT BltFast(long dwX, long dwY, LPDIRECTDRAWSURFACE lpDDSrcSurface, RECT lpSrcRect, int dwTrans) {
		return HRESULT.DD_OK;
	}

	public HRESULT Flip(Object object, int ddflipWait) {
		// TODO Auto-generated method stub
		return HRESULT.DD_OK;
	}

	/**
	 * HRESULT Blt( LPRECT lpDestRect, LPDIRECTDRAWSURFACE lpDDSrcSurface, LPRECT lpSrcRect, DWORD dwFlags, LPDDBLTFX lpDDBltFX);
	 */
	
	public HRESULT Blt(RECT lpDestRect, LPDIRECTDRAWSURFACE lpDDSrcSurface, RECT lpSrcRect, long dwFlags,
			Object lpDDBltFX) {
		// TODO Auto-generated method stub
		return HRESULT.DD_OK;
	}

	public HRESULT Restore() {
		// TODO Auto-generated method stub
		return HRESULT.DD_OK;
	}

	public void Release() {
		// TODO Auto-generated method stub
		
	}

	public HRESULT GetAttachedSurface(DDSCAPS ddscaps, LPDIRECTDRAWSURFACE g_pDDSBack) {
		// TODO Auto-generated method stub
		return HRESULT.DD_OK;
	}

	public void SetClipper(LPDIRECTDRAWCLIPPER pClipper) {
		// TODO Auto-generated method stub
		
	}

	public void Lock(Object object, DDSURFACEDESC srcDDSD, int ddlockWait, Object object2) {
		// TODO Auto-generated method stub
		
	}

	public void Unlock(Object object) {
		// TODO Auto-generated method stub
		
	}


}
