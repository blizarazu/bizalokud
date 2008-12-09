package com.sgta07.bizalokud.login.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class LoginInfo implements IsSerializable{
	
	private String nan;
	private String izena;
	private String abizenak;
	private boolean isAdmin;
	
	private boolean baimena;
	private String erroreMezua;
	
	public LoginInfo(){}

	public LoginInfo(String nan, String izena, String abizenak, boolean isAdmin, boolean baimena) {
		super();
		this.nan = nan;
		this.izena = izena;
		this.abizenak = abizenak;
		this.isAdmin = isAdmin;
		this.baimena = baimena;
	}

	public LoginInfo(boolean baimena) {
		this.baimena = baimena;
	}

	public LoginInfo(String erroreMezua) {
		this.baimena = false;
		this.erroreMezua = erroreMezua;
	}

	public boolean isBaimena() {
		return baimena;
	}

	public String getErroreMezua() {
		return erroreMezua;
	}
	
	public String getNan() {
		return nan;
	}

	public String getIzena() {
		return izena;
	}

	public String getAbizenak() {
		return abizenak;
	}
	
	public boolean isAdmin(){
		return isAdmin;
	}
}
