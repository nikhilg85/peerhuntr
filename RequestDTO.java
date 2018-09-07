package com.infodart.peerhuntr.dto.request;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;

public class RequestDTO {


	private List<Object> responseList;
	private List<ObjectError> errorList;
	private String status;
	private int statusCode;
	private List<Object> pageList;
	private Integer totalPage;
	private int id;
	private int currentPage;
	private String message;	
	private String errorMsg;
	private String pageName;
	private Map<String,List<Object>> responseMap;
	private String deviceType;
	private int pageNo;
	private String filterParamter;
	private String keyname;
	private String filterKey;
	private int pageData;
	private String sortByRating;
	private String nationalityName;
	private List<String> nationalityData;
	private String degreeName;
	private List<String> degreeData;
	private String specializationName;
	private List<String> specializationData;
	private String personalityName;
	private List<String> personalityData;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Integer getTotalPage() {
		return totalPage;
	}



	public int getPageData() {
		return pageData;
	}



	public void setPageData(int pageData) {
		this.pageData = pageData;
	}



	public String getSortByRating() {
		return sortByRating;
	}



	public void setSortByRating(String sortByRating) {
		this.sortByRating = sortByRating;
	}



	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public String getKeyname() {
		return keyname;
	}



	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}



	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public RequestDTO(List<Object> responseList, String status, int statusCode) {
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
	
	public int getPageNo() {
		return pageNo;
	}



	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	public String getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}



	public String getFilterParamter() {
		return filterParamter;
	}



	public void setFilterParamter(String filterParamter) {
		this.filterParamter = filterParamter;
	}



	public String getFilterKey() {
		return filterKey;
	}



	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}



/*	public List<String> getFilterName() {
		return filterName;
	}



	public void setFilterName(List<String> filterName) {
		this.filterName = filterName;
	}



	public List<String> getFilterkeyName() {
		return filterkeyName;
	}



	public void setFilterkeyName(List<String> filterkeyName) {
		this.filterkeyName = filterkeyName;
	}

*/

	public String getNationalityName() {
		return nationalityName;
	}



	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}



	public List<String> getNationalityData() {
		return nationalityData;
	}



	public void setNationalityData(List<String> nationalityData) {
		this.nationalityData = nationalityData;
	}



	public String getDegreeName() {
		return degreeName;
	}



	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}


	public String getSpecializationName() {
		return specializationName;
	}



	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}



	public List<String> getSpecializationData() {
		return specializationData;
	}



	public void setSpecializationData(List<String> specializationData) {
		this.specializationData = specializationData;
	}



	public String getPersonalityName() {
		return personalityName;
	}



	public void setPersonalityName(String personalityName) {
		this.personalityName = personalityName;
	}



	public List<String> getPersonalityData() {
		return personalityData;
	}



	public void setPersonalityData(List<String> personalityData) {
		this.personalityData = personalityData;
	}



	public List<String> getDegreeData() {
		return degreeData;
	}



	public void setDegreeData(List<String> degreeData) {
		this.degreeData = degreeData;
	}


	
}

