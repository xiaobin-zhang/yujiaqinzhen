package com.yjqz.binge.event.demo;

import java.util.List;

import lombok.Data;

@Data
public class Result {

	private String from;
	
	private String to;
	
	private List<TransResult> trans_result;
	
	public static class TransResult{
		private String src;
		
		private String dst;

		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}

		public String getDst() {
			return dst;
		}

		public void setDst(String dst) {
			this.dst = dst;
		}
		
	}

	@Override
	public String toString() {
		return "Result [from=" + from + ", to=" + to + ", trans_result=" + trans_result + ", getFrom()=" + getFrom()
				+ ", getTo()=" + getTo() + ", getTrans_result()=" + getTrans_result() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
}

