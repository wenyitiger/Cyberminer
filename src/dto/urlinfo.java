package dto;

public class urlinfo {
        public int getUrlid() {
		return urlid;
	}
	public void setUrlid(int urlid) {
		this.urlid = urlid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		private int urlid;
        private String url;
        private String description;
	
        public   boolean   equals(Object   anObject)   { 
        	String urltemp = ((urlinfo)anObject).getUrl(); 
        	
        	if(this.url.equals(urltemp)){ 
        	return   true; 
        	}else{ 
        	return   false; 
        	} 
        	}
        @Override  
        public int hashCode() {  
            
            return url.hashCode();  
        }  
}
