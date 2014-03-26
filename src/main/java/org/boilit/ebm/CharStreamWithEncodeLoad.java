package org.boilit.ebm;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import webit.script.util.charset.UTF_8;

/**
 * @author Boilit
 * @see
 */
public final class CharStreamWithEncodeLoad extends Writer implements IOutput {

    private long streamSize = 0;
    //只适合utf-8,单线程测试
    static byte[] bs = new byte[1024];
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        streamSize += len;
        
        int used = UTF_8.encode(bs,
        		cbuf, off, off + len);
//        out.write(bytes, 0, used);
    }

    @Override
    public void write(int c) throws IOException {
        streamSize++;
    }

    @Override
    public void flush() throws IOException {
    	int a = 0;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public final long getStreamSize() {
        return streamSize;
    }

    public void init(Properties properties) {
    }
}
