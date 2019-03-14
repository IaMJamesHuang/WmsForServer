package test;

import com.kt.james.wmsforserver.core.RuntimeCore;
import org.junit.Test;

public class ScriptTest {

    @Test
    public void TestAutoSaleScript() {
        String s = RuntimeCore.execAutoSalePython();
        System.out.println(s);
    }

}
