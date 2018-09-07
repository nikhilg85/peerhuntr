package com.infodart.peerhuntr.dto.response;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;

public class ResponseDTO {


	private List<Object> responseList;
	private List<ObjectError> errorList;
	private String status;
	private int statusCode;
	private List<Object> pageList;
	private int totalPage;
	private int currentPage;
	private String message;	
	private String errorMsg;
	private String pageName;
	private String cartCount;
	private Map<String,List<Object>> responseMap;
	private String type;
	private String role;
	private String colorCode;
	private String remarks;
	


	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getColorCode() {
		return colorCode;
	}



	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}



	public Map<String, List<Object>> getResponseMap() {
		return responseMap;
	}



	public void setResponseMap(Map<String, List<Object>> responseMap) {
		this.responseMap = responseMap;
	}



	public List<ObjectError> getErrorList() {
		return errorList;
	}



	public void setErrorList(List<ObjectError> errorList) {
		this.errorList = errorList;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseDTO(List<Object> responseList, String status, int statusCode) {
		super();
		this.responseList = responseList;
		this.status = status;
		this.statusCode = statusCode;
	}
	public List<Object> getResponseList() {
		return responseList;
	}
	public void setResponseList(List<Object> responseList) {
		this.responseList = responseList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<Object> getPageList() {
		return pageList;
	}
	public void setPageList(List<Object> pageList) {
		this.pageList = pageList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}




	public String getCartCount() {
		return cartCount;
	}



	public void setCartCount(String cartCount) {
		this.cartCount = cartCount;
	}




	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}



	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	
	
}

