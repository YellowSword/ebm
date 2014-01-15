package org.boilit.ebm.engine;


import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.res.FileResourceLoader;
import org.boilit.ebm.AbstractEngine;

/**
 * @author Boilit
 * @see
 */
public final class Beetl2 extends AbstractEngine {
    private String templateUrl;
    private GroupTemplate engine;

    @Override
    public final void init(Properties properties) throws Exception {
    	
    	templateUrl = "/beetl.html";
    	String home = Beetl2.class.getResource("/templates").getPath();
		Configuration cf = Configuration.defaultConfiguration();
		
		cf.setDirectByteOutput(super.isSupportByteStream());
		cf.setStatementStart("<!--:");
		cf.setStatementEnd("-->");
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		engine = new GroupTemplate(rs, cf);
    	
       
    }

    @Override
    public void work(final Map<String, Object> model, final Writer writer) throws Exception {
        final Template template = engine.getTemplate (this.templateUrl);
        template.binding(model);
        template.renderTo(writer);
    }

    @Override
    public void work(final Map<String, Object> model, final OutputStream outputStream) throws Exception {
    	final Template template = engine.getTemplate (this.templateUrl);
        template.binding(model);
        template.renderTo(outputStream);
    }
}
