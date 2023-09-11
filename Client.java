import com.sun.jna.*;
import java.util.*;
import java.lang.Long;

public class Client {
   public interface SSI extends Library {
        // GoSlice class maps to:
        // C type struct { void *data; GoInt len; GoInt cap; }
        public class GoSlice extends Structure {
            public static class ByValue extends GoSlice implements Structure.ByValue {}
            public Pointer data;
            public long len;
            public long cap;
            protected List getFieldOrder(){
                return Arrays.asList(new String[]{"data","len","cap"});
            }
        }

        // GoString class maps to:
        // C type struct { const char *p; GoInt n; }
        public class GoString extends Structure {
            public static class ByValue extends GoString implements Structure.ByValue {}
            public String p;
            public long n;
            protected List getFieldOrder(){
                return Arrays.asList(new String[]{"p","n"});
            }

        }

        // Foreign functions
        public GoString.ByValue GenerateDidDoc();
    }
 
   static public void main(String argv[]) {
        SSI ssi = (SSI) Native.loadLibrary("/Users/nealr/MY-WORKSPACE/SSI-SDK-JNA-JAVA/ssi.so", SSI.class);
        System.out.println("Generating DID Document: \n");
        System.out.println(ssi.GenerateDidDoc());
    }
}