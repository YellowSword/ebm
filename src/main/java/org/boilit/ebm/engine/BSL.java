package org.boilit.ebm.engine;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import org.boilit.bsl.Engine;
import org.boilit.bsl.xio.FileResourceLoader;
import org.boilit.ebm.AbstractEngine;

/**
 * @author Boilit
 * @see
 */
public final class BSL extends AbstractEngine {
    private String templateUrl;
    private Engine engine;

    @Override
    public final void init(String engineName,Properties properties) throws Exception {
    	      templateUrl = BSL.class.getResource("/templates/bsl.html").getPath();

        engine = Engine.getEngine();
        engine.setInputEncoding(properties.getProperty("inputEncoding", "UTF-8"));
        engine.setOutputEncoding(properties.getProperty("outputEncoding", "UTF-8"));
        engine.setSpecifiedEncoder(true);
        engine.setUseTemplateCache(true);
        engine.setResourceLoader(new FileResourceLoader());
        engine.setTextProcessor(null);
        engine.setBreakPointer(null);
    }

    @Override
    public final void work(final Map<String, Object> model, final Writer writer) throws Exception {
        engine.getTemplate(templateUrl).execute(model, writer);
    }

    @Override
    public final void work(final Map<String, Object> model, final OutputStream outputStream) throws Exception {
        engine.getTemplate(templateUrl).execute(model, outputStream);
    }
}
