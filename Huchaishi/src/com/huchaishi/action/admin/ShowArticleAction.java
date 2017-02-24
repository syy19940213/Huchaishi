package com.huchaishi.action.admin;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;


import com.huchaishi.common.UnicodeFormatter;
import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ShowArticleAction {

	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式  
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符  
	
	private Integer articleId;

	
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	
	public String execute(){
		AticleFactory dao = new AticleFactory();
		Aticle artilc  = dao.findById(articleId);
//		artilc.setAticleCenter(UnicodeFormatter.parseString(UnicodeFormatter.toString(artilc.getAticleCenter())));
		ActionContext.getContext().put("artilc", artilc);
		return Action.SUCCESS;
		
	}
	
}
