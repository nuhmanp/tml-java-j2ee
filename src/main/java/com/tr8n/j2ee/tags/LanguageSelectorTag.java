/*
 *  Copyright (c) 2014 Michael Berkovich, http://tr8nhub.com All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.tr8n.j2ee.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.tr8n.core.Session;

public class LanguageSelectorTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
    	    Session tr8nSession = (Session) request.getAttribute("tr8n");
    	    if (tr8nSession == null)
    	    	return EVAL_PAGE;
            
            out.write("<a href='#' onClick='Tr8n.UI.LanguageSelector.show()'>");
            out.write("<img src='" + tr8nSession.getCurrentLanguage().getFlagUrl() + "' style='align:middle'>");
            out.write("&nbsp;");
            out.write(tr8nSession.getCurrentLanguage().getEnglishName());
            out.write("</a>");
        } catch(Exception e) {   
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
