package net.benji.bbuild.setting.settings;

import net.benji.bbuild.module.Module;
import net.benji.bbuild.setting.Setting;
import net.benji.bbuild.module.Module;
import net.benji.bbuild.setting.Setting;

public class SettingBoolean extends Setting {
	public boolean value;
	
	public SettingBoolean(String name, Module mod, boolean value)
	{
		this.name = name;
		this.value = value;
		this.mod = mod;
		this.type = Setting.Type.BOOLEAN;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
