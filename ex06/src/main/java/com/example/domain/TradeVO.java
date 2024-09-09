package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TradeVO {
	private int tid; 
	private String ano; 
	private String tno; 
	private int type; 
	private int amount; 
	@JsonFormat(pattern="yyyy-MM-dd kk:mm:ss", timezone="Asia/Seoul")
	 private Date tradeDate;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	@Override
	public String toString() {
		return "TradeVO [tid=" + tid + ", ano=" + ano + ", tno=" + tno + ", type=" + type + ", amount=" + amount
				+ ", tradeDate=" + tradeDate + "]";
	}
	
}
