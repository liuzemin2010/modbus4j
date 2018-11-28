package com.net4iot.oss.infra.permission;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author yanglijuan
 * @version 1.0, 2017年11月22日
 * @see
 * @since
 */
public class PermissionTag extends TagSupport {

	private String module;

	private String privilege;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@Override
	public int doStartTag() throws JspException {
		boolean result = false;
		// User user = (User) this.pageContext.getSession().getAttribute(
		// Constants.CURRENTUSER);
		HashMap<String, Integer> actionmenu = (HashMap<String, Integer>) this.pageContext
				.getSession().getAttribute("actionmenu");

		// if(user==null){
		//
		// }
		// if(user.getId()==1){
		// result = true;
		// return result ? EVAL_BODY_INCLUDE : SKIP_BODY;
		// }
		if (actionmenu == null) {
			ServletResponse response = this.pageContext.getResponse();
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>alert('��¼�û����ڣ������µ�¼');</script>");
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				result = false;
			}

		} else {
			if (actionmenu.containsKey(this.getPrivilege())) {
				result = true;
			}
		}
		// EVAL_BODY_INCLUDE���ִ���Զ����ǩ�е����ݣ�SKIP_BODY��?ִ���Զ����ǩ�е����ݡ�
		return result ? EVAL_BODY_INCLUDE : SKIP_BODY;
	}

}
