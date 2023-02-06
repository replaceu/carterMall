package com.mall4j.cloud.express.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ExpressRspDTO {
	String status;

	String message;

	ExpressInfoDTO result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	public ExpressInfoDTO getResult() {
		return result;
	}

	public void setResult(ExpressInfoDTO result) {
		this.result = result;
	}



	/**
	 * 物流跟踪
	 */
	@ApiModel(value = "ExpressTrack", description = "物流跟踪")
	public class ExpressTrack {
		/**
		 * 时间
		 */
		@ApiModelProperty("时间")
		String	time;
		/**
		 * 状态 
		 */
		@ApiModelProperty("状态")
		String	status;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
