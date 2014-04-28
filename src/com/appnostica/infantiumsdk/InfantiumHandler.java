package com.appnostica.infantiumsdk;

import java.util.HashMap;
import java.util.List;

import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollObject;
import com.infantium.android.sdk.InfantiumAsyncResponseHandler;
import com.infantium.android.sdk.Player;

public class InfantiumHandler extends InfantiumAsyncResponseHandler {
	
	private HashMap<String, KrollFunction> responseHandler = null;
	private KrollObject krollObj = null;
	
	public InfantiumHandler(HashMap<String, KrollFunction> responseHandler, KrollObject krollObj) {
		this.responseHandler = responseHandler;
		this.krollObj = krollObj;
	}
	
	@Override
    public void onFailureCloseGameplay(String description) { onFailure("onFailureCloseGameplay", description); }
	
	@Override
	public void onFailureContentApp(String description) { onFailure("onFailureContentApp", description); }
	
	@Override
	public void onFailureCreateGameplay(String description) { onFailure("onFailureCreateGameplay", description); }
	
	@Override
	public void onFailureEbookRawData(String description) { onFailure("onFailureEbookRawData", description); }
	
	@Override
	public void onFailureGameRawdata(String description) { onFailure("onFailureGameRawdata", description); }
	
	@Override
	public void onFailureGetPlayerByUUID(String description) { onFailure("onFailureGetPlayerByUUID", description); }
	
	@Override
	public void onFailureLogin(String description) { onFailure("onFailureLogin", description); }
	
	@Override
	public void onFailureLogout(String description) { onFailure("onFailureLogout", description); }
	
	@Override
	public void onFailureNewAnonymousPlayer(String description) { onFailure("onFailureNewAnonymousPlayer", description); }
	
	@Override
	public void onFailureNewPlayer(String description) { onFailure("onFailureNewPlayer", description); }
	
	@Override
	public void onFailurePlayerList(String description) { onFailure("onFailurePlayerList", description); }
	
	@Override
	public void onFailureVideoRawData(String description) { onFailure("onFailureVideoRawData", description); }
	
	@Override
    public void onSuccessCloseGameplay() { onSuccess("onSuccessCloseGameplay"); }
	
	@Override
	public void onSuccessContentApp() { onSuccess("onSuccessContentApp"); }
	
	@Override
	public void onSuccessCreateGameplay() { onSuccess("onSuccessCreateGameplay"); }
	
	@Override
	public void onSuccessEbookRawData() { onSuccess("onSuccessEbookRawData"); }
	
	@Override
	public void onSuccessGameRawData() { onSuccess("onSuccessGameRawData"); }
	
	@Override
	public void onSuccessGetPlayerByUUID() { onSuccess("onSuccessGetPlayerByUUID"); }
	
	@Override
	public void onSuccessLogin() { onSuccess("onSuccessLogin"); }
	
	@Override
	public void onSuccessLogout() { onSuccess("onSuccessLogout"); }
	
	@Override
	public void onSuccessNewAnonymousPlayer(Player player) { 
		if (responseHandler == null) return; 
    	KrollFunction callback = (KrollFunction) responseHandler.get("onSuccessNewAnonymousPlayer");
		if (callback != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("nickname", player.getNickname());
			map.put("months", new Integer(player.getMonths()).toString());
			map.put("uuid", player.getUUID());
			callback.call(krollObj, map);
		}
	}
	
	@Override
	public void onSuccessNewPlayer() { onSuccess("onSuccessNewPlayer"); }
	
	@Override
	public void onSuccessPlayerList(List<Player> players) { onSuccess("onSuccessPlayerList"); }
	
	@Override
	public void onSuccessVideoRawData() { onSuccess("onSuccessVideoRawData"); }
	
    private void onSuccess(String func_name) {
    	if (responseHandler == null) return; 
    	KrollFunction callback = (KrollFunction) responseHandler.get(func_name);
		if (callback != null) {
			callback.call(krollObj, new HashMap<String, Object>());
		}
    }
    
    private void onFailure(String func_name, String description) {
    	if (responseHandler == null) return; 
    	KrollFunction callback = (KrollFunction) responseHandler.get(func_name);
		if (callback != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("description", description);
			callback.call(krollObj, map);
		}
    }
}
