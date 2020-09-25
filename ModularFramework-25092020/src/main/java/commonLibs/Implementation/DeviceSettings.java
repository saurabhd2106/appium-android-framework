package commonLibs.Implementation;

public class DeviceSettings {
	
	private String platformName;
	private String platformVersion;
	private String deviceName;
	private String udid;
	private String app;
	private String browserType;
	
	
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformVersion() {
		return platformVersion;
	}
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getUdid() {
		return udid;
	}
	public void setUdid(String udid) {
		this.udid = udid;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getBrowserType() {
		return browserType;
	}
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

}
